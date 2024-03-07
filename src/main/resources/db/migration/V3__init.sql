-- create table users (
--                        id                    bigserial,
--                        username              varchar(30) not null unique,
--                        password              varchar(80) not null,
--                        email                 varchar(50) unique,
--                        primary key (id)
-- );
--
-- create table roles (
--                        id                    serial,
--                        name                  varchar(50) not null,
--                        primary key (id)
-- );
--
-- CREATE TABLE users_roles (
--                              user_id               bigint not null,
--                              role_id               int not null,
--                              primary key (user_id, role_id),
--                              foreign key (user_id) references users (id),
--                              foreign key (role_id) references roles (id)
-- );
--
-- insert into roles (name)
-- values
--     ('ROLE_USER'), ('ROLE_ADMIN');
--
-- insert into users (username, password, email)
-- values
--     ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
--     ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com');
--
-- insert into users_roles (user_id, role_id)
-- values
--     (1, 1),
--     (2, 2);
drop table if exists roles cascade;

create table roles
(
    id   bigserial
        constraint roles_pk
            primary key,
    name varchar(20) not null
);

drop table if exists users cascade;

create table users
(
    id        bigserial
        constraint users_pk
            primary key,
    user_name varchar(50) not null
        constraint users_pk2
            unique,
    password  varchar(80) not null,
    role_id   bigint      not null
        constraint users_roles_id_fk
            references roles
            on update cascade on delete cascade
);
insert into roles (name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into users (user_name, password, role_id)
values ('admin', 'admin', 1),
       ('user', 'user', 2);