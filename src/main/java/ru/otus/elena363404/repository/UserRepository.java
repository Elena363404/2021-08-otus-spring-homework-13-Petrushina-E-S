package ru.otus.elena363404.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.otus.elena363404.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  @Query("SELECT u FROM User u WHERE u.username = :username")
  Optional<User> findUserByUsername(String username);
}
