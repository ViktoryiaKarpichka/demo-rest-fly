drop table if exists books cascade;
create table books
(
    id          serial,
    name        varchar,
    description varchar
);