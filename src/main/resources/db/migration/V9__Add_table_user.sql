create table pg_user(
    id bigserial primary key not null,
    first_name varchar(20) not null,
    last_name varchar(30) not null,
    patronymic varchar(40) not null,
    user_name varchar(20) not null,
    password varchar not null,
    role varchar(15) not null,
    deleted boolean not null default false
)