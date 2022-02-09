insert into author (`name`) values ('Stephen King');
insert into author (`name`) values ('Alexander Pushkin');
insert into author (`name`) values ('Isaak Newton');
insert into author (`name`) values ('Vladimir Lenin');
insert into author (`name`) values ('Marina Tsvetaeva');

insert into genre (`name`) values ('Fantastic');
insert into genre (`name`) values ('Political');
insert into genre (`name`) values ('Novel');
insert into genre (`name`) values ('Horror');
insert into genre (`name`) values ('Horror-123');

insert into book (`name`, author_id, genre_id) values ('Doughter of Capitan', 2, 3);
insert into book (`name`, author_id, genre_id) values ('Apocalypse', 3, 1);
insert into book (`name`, author_id, genre_id) values ('Revolution-1', 4, 2);
insert into book (`name`, author_id, genre_id) values ('Revolution-2', 4, 2);
insert into book (`name`, author_id, genre_id) values ('It', 1, 4);

insert into comment(`comment`, book_id) values ('Good book!', 1);
insert into comment(`comment`, book_id) values ('Bad book!', 1);
insert into comment(`comment`, book_id) values ('Normal book!', 3);

insert into users (`username`, `password`, `enabled`) values ('admin', '1', true);
insert into users (`username`, `password`, `enabled`) values ('guest', '2', true);
insert into users (`username`, `password`, `enabled`) values ('petrovich', '3', true);

insert into role(`name`) values ('ADMIN');
insert into role(`name`) values ('USER');

INSERT INTO users_role (user_id, role_id) VALUES (1, 1);
INSERT INTO users_role (user_id, role_id) VALUES (3, 2);