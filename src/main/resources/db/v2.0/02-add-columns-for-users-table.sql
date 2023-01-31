alter table users
    add column created DATE NOT NULL DEFAULT CURRENT_DATE,
    add column updated DATE NOT NULL DEFAULT CURRENT_DATE,
    add column status varchar(226),
    add column roles varchar(225)