create table youth_hostel
(
    id      bigserial
        constraint youth_hostel_pk
            primary key,
    name    varchar(40) not null,
    about   text        not null,
    phone   varchar(12) not null,
    email   varchar(30) not null,
    price   varchar     not null,
    deleted boolean     not null
);