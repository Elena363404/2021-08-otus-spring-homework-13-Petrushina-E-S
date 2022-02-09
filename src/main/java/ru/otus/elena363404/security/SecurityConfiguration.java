package ru.otus.elena363404.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure( HttpSecurity http ) throws Exception {

        http.csrf().disable()
          .formLogin()
          .and().authorizeRequests()
          .antMatchers("/login").permitAll()
          .antMatchers("/edit_book/**", "/edit_author/**", "/edit_genre/**", "/edit_comment/**").hasAuthority("ROLE_ADMIN")
          .antMatchers("/delete_book/**", "/delete_author/**", "/delete_genre/**", "/delete_comment/**").hasAuthority("ROLE_ADMIN")
          .antMatchers("/").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
          .and()
          .rememberMe()
          .key("libraryKey")
          .tokenValiditySeconds(60 * 60 * 24);
    }

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    public void configure( AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }

}
