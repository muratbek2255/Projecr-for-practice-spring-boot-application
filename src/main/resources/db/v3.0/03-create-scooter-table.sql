--validCheckSum 8:4819a71fb5760e7c1e9b2c3bce2ec7f4

create table scooter_kg.scooter(
                       id serial not null PRIMARY KEY ,
                       title varchar(50),
                       price int DEFAULT 0,
                       battery int DEFAULT 0,
                       image varchar(500),
                       quantity int DEFAULT 0,
                       address varchar(100),
                       qr_code varchar(500)
);