create table general_entertainment
(
    id                 bigint      not null
        constraint general_entertainment_pkey
            primary key,
    phone_number       varchar(12) not null
        constraint general_entertainment_phone_number_key
            unique,
    shift_name         varchar     not null,
    start_at           time        not null,
    end_at             time        not null,
    entertainment_type varchar     not null,
    price              varchar     not null
);

create table bath
(
    id   bigint      not null
        constraint bath_pkey
            primary key
        constraint bath_id_fkey
            references general_entertainment,
    type varchar(20) not null
);

create table billiards
(
    id          bigint  not null
        constraint billiards_pkey
            primary key
        constraint billiards_id_fkey
            references general_entertainment,
    type        varchar not null,
    table_count bytea   not null
);

create table bowling
(
    id          bigint not null
        constraint bowling_pkey
            primary key
        constraint bowling_id_fkey
            references general_entertainment,
    lanes_count bytea  not null,
    lanes_limit bytea  not null
);

create table climbing_wall
(
    id bigint not null
        constraint climbing_wall_pkey
            primary key
        constraint climbing_wall_id_fkey
            references general_entertainment
);

create table extreme
(
    id bigint not null
        constraint extreme_pkey
            primary key
        constraint extreme_id_fkey
            references general_entertainment
);

create table karaoke
(
    id bigint not null
        constraint karaoke_pkey
            primary key
        constraint karaoke_id_fkey
            references general_entertainment
);

create table massage
(
    id   bigint  not null
        constraint massage_pkey
            primary key
        constraint massage_id_fkey
            references general_entertainment,
    type varchar not null
);

create table museum
(
    id    bigint      not null
        constraint museum_pkey
            primary key
        constraint museum_id_fkey
            references general_entertainment,
    theme varchar(40) not null
);

create table paintball
(
    id   bigint  not null
        constraint paintball_pkey
            primary key
        constraint paintball_id_fkey
            references general_entertainment,
    type boolean not null
);

create table planetarium
(
    id bigint not null
        constraint planetarium_pkey
            primary key
        constraint planetarium_id_fkey
            references general_entertainment
);

create table pottery
(
    id bigint not null
        constraint pottery_pkey
            primary key
        constraint pottery_id_fkey
            references general_entertainment
);

create table quest
(
    id bigint not null
        constraint quest_pkey
            primary key
        constraint quest_id_fkey
            references general_entertainment
);

create table shooting_club
(
    id       bigint  not null
        constraint shooting_club_pkey
            primary key
        constraint shooting_club_id_fkey
            references general_entertainment,
    firearms boolean not null,
    airguns  boolean not null
);

create table weapon
(
    id   bigint       not null
        constraint weapon_pkey
            primary key,
    name varchar(100) not null
);

create table shooting_club_weapon
(
    id               bigint not null
        constraint shooting_club_weapon_pkey
            primary key,
    shooting_club_id bigint not null
        constraint shooting_club_weapon_shooting_club_id_fkey
            references shooting_club
            on update cascade on delete cascade,
    weapon_id        bigint not null
        constraint shooting_club_weapon_weapon_id_fkey
            references weapon
            on update cascade on delete cascade
);

create table vr_club
(
    id                bigint not null
        constraint vr_club_pkey
            primary key
        constraint vr_club_id_fkey
            references general_entertainment,
    max_players_count bytea  not null
);

create table vr_game
(
    id   bigint      not null
        constraint vr_game_pkey
            primary key,
    name varchar(40) not null
);

create table vr_club_game
(
    id         bigint not null
        constraint vr_club_game_pkey
            primary key,
    vr_club_id bigint not null
        constraint vr_club_game_vr_club_id_fkey
            references vr_club
            on update cascade on delete cascade,
    vr_game_id bigint not null
        constraint vr_club_game_vr_game_id_fkey
            references vr_game
            on update cascade on delete cascade
);

create table wind_tunnel
(
    id bigint not null
        constraint wind_tunnel_pkey
            primary key
        constraint wind_tunnel_id_fkey
            references general_entertainment
);

create table zoo
(
    id bigint not null
        constraint zoo_pkey
            primary key
        constraint zoo_id_fkey
            references general_entertainment
);