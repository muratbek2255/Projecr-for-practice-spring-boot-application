create table users (
                       id serial not null,
                       password varchar(255) not null,
                       username varchar(255) not null,
                       email varchar(255) not null,
                       primary key (id)
);