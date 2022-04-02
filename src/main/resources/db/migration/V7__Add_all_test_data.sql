ALTER SEQUENCE billiard_id_seq RESTART WITH 1;
ALTER SEQUENCE bowling_id_seq RESTART WITH 1;
ALTER SEQUENCE climbing_wall_id_seq RESTART WITH 1;
ALTER SEQUENCE extreme_id_seq RESTART WITH 1;
ALTER SEQUENCE karaoke_id_seq RESTART WITH 1;
ALTER SEQUENCE massage_id_seq RESTART WITH 1;
ALTER SEQUENCE museum_id_seq RESTART WITH 1;
ALTER SEQUENCE paintball_id_seq RESTART WITH 1;
ALTER SEQUENCE planetarium_id_seq RESTART WITH 1;
ALTER SEQUENCE pottery_id_seq RESTART WITH 1;
ALTER SEQUENCE quest_id_seq RESTART WITH 1;
ALTER SEQUENCE shooting_club_id_seq RESTART WITH 1;
ALTER SEQUENCE shooting_club_weapon_id_seq RESTART WITH 1;
ALTER SEQUENCE vr_club_game_id_seq RESTART WITH 1;
ALTER SEQUENCE vr_club_id_seq RESTART WITH 1;
ALTER SEQUENCE vr_club_game_id_seq RESTART WITH 1;
ALTER SEQUENCE weapon_id_seq RESTART WITH 1;
ALTER SEQUENCE wind_tunnel_id_seq RESTART WITH 1;
ALTER SEQUENCE weapon_id_seq RESTART WITH 1;
ALTER SEQUENCE zoo_id_seq RESTART WITH 1;
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+71112433508', 'Понедельник-пятница', '08:00:00', '23:00:00', 'BATH', '2 час 500р/чел.', false,
        'Русский Ухань');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79432222223', 'Суббота-воскресенье', '11:00:00', '14:00:00', 'BATH', '4 час 400р/чел.', false,
        'Американский пар');
insert into bath(id, type)
values (1, 'BATH');
insert into bath(id, type)
values (2, 'BATH');

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79432433508', 'Понедельник-пятница', '08:00:00', '20:00:00', 'BILLIARDS', '1 час 300р/чел.', false,
        'Русский');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79432433433', 'Суббота-воскресенье', '08:00:00', '14:00:00', 'BILLIARDS', '2 час 100р/чел.', false,
        'Американский');
insert into billiard(id, type, table_count)
values (3, 'RUSSIAN', 10);
insert into billiard(id, type, table_count)
values (4, 'AMERICAN', 5);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79432532123', 'Вторник-суббота', '11:00:00', '15:00:00', 'BOWLING', '1 час 150р/чел.', false, 'Классический');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79765446788', 'Понедельник-среда', '08:00:00', '13:00:00', 'BOWLING', '1 час 200р/чел.', false,
        'Бэйкер боулинг');
insert into bowling(id, lanes_count, lanes_limit)
values (5, 5, 10);
insert into bowling(id, lanes_count, lanes_limit)
values (6, 11, 25);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+76456546546', 'Понедельник-среда', '12:00:00', '20:00:00', 'CLIMBING_WALL', '1 час 1000р/чел.', false,
        'Скалолазание');
insert into climbing_wall(id)
values (7);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+76542343254', 'Суббота-воскресенье', '10:00:00', '14:00:00', 'EXTREME', '1 час 15000р/чел.', false,
        'Парашют');
insert into extreme(id)
values (8);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79875424234', 'Понедельник-воскресенье', '16:00:00', '22:00:00', 'KARAOKE', '1 час 200р/чел.', false,
        'Любительское');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79648679876', 'Понедельник-воскресенье', '16:00:00', '23:00:00', 'KARAOKE', '1 час 200р/чел.', false,
        'Профессиональное');
insert into karaoke(id)
values (9);
insert into karaoke(id)
values (10);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79621354339', 'Понедельник-пятница', '10:00:00', '15:00:00', 'MASSAGE', '5 час 9000р/чел.', false,
        'Лечебный');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79453132487', 'Суббота-воскресенье', '14:00:00', '16:00:00', 'MASSAGE', '2 час 3000р/чел.', false,
        'Рефлекторный');
insert into massage(id, type)
values (11, 'MEDICAL');
insert into massage(id, type)
values (12, 'REFLEXIVE');

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+75421698420', 'Понедельник-пятница', '10:00:00', '15:00:00', 'MUSEUM', '1 час 500р/чел.', false, 'Картины');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79005784331', 'Суббота-воскресенье', '12:00:00', '14:00:00', 'MUSEUM', '1 час 500р/чел.', false,
        'Ископаемые');
insert into museum(id, theme)
values (13, 'PICTURE');
insert into museum(id, theme)
values (14, 'ANCIENT');

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79543534342', 'Вторник-четверг', '10:00:00', '17:00:00', 'PAINTBALL', '1 час 3000р/чел.', false, 'Шарики');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79657868984', 'Суббота-понедельник', '08:00:00', '20:00:00', 'PAINTBALL', '1 час 4000р/чел.', false,
        'Краска');
insert into paintball(id, type)
values (15, 'BALLS');
insert into paintball(id, type)
values (16, 'PAINTS');

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79905467823', 'Вторник-четверг', '10:00:00', '12:00:00', 'PLANETARIUM', '1 час 2000р/чел.', false,
        'Солнечная система');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79646564111', 'Суббота-среда', '20:00:00', '23:00:00', 'PLANETARIUM', '1 час 1000р/чел.', false,
        'Млечный путь');
insert into planetarium(id)
values (17);
insert into planetarium(id)
values (18);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79875324825', 'Четверг-пятница', '08:00:00', '20:00:00', 'POTTERY', '1 час 3000р/чел.', false, 'Горшки');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79987544310', 'Суббота-воскресенье', '08:00:00', '20:00:00', 'POTTERY', '2 час 5000р/чел.', false, 'Тарелки');
insert into pottery(id)
values (19);
insert into pottery(id)
values (20);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79645654756', 'Понедельник-пятница', '14:00:00', '16:00:00', 'QUEST', '1 час 1000р/чел.', false, 'Дурка');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79765535247', 'Суббота-Вторник', '12:00:00', '15:00:00', 'QUEST', '3 час 2500р/чел.', false,
        'Резня бензопилой');
insert into quest(id)
values (21);
insert into quest(id)
values (22);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79648755423', 'Понедельник-четверг', '20:00:00', '22:00:00', 'SHOOTING_CLUB', '1 час 5000р/чел.', false,
        'Выстрел');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79957347543', 'Пятница-воскресенье', '18:00:00', '23:00:00', 'SHOOTING_CLUB', '5 час 12000р/чел.', false,
        'Бункер');
insert into shooting_club(id, firearms, airguns)
values (23, true, false);
insert into shooting_club(id, firearms, airguns)
values (24, false, true);

insert into weapon(id, name)
values (1, 'ТТ');
insert into weapon(id, name)
values (2, 'ПММ');
insert into weapon(id, name)
values (3, 'АК-74М');
insert into weapon(id, name)
values (4, 'GLOCK-17');
insert into weapon(id, name)
values (5, 'BORNER');
insert into weapon(id, name)
values (6, 'CROSMAN_C31');
insert into weapon(id, name)
values (7, 'STALKER_SA96');
insert into weapon(id, name)
values (8, 'MP7');

insert into shooting_club_weapon(id, shooting_club_id, weapon_id)
values (1, 23, 1);
insert into shooting_club_weapon(id, shooting_club_id, weapon_id)
values (2, 23, 2);
insert into shooting_club_weapon(id, shooting_club_id, weapon_id)
values (3, 23, 3);
insert into shooting_club_weapon(id, shooting_club_id, weapon_id)
values (4, 23, 4);
insert into shooting_club_weapon(id, shooting_club_id, weapon_id)
values (5, 24, 5);
insert into shooting_club_weapon(id, shooting_club_id, weapon_id)
values (6, 24, 6);
insert into shooting_club_weapon(id, shooting_club_id, weapon_id)
values (7, 24, 7);
insert into shooting_club_weapon(id, shooting_club_id, weapon_id)
values (8, 24, 8);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79345345312', 'Понедельник-пятница', '12:00:00', '18:00:00', 'VR_CLUB', '1 час 900р/чел.', false, 'Релайф');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79956543211', 'Суббота-воскресенье', '10:00:00', '18:00:00', 'VR_CLUB', '1 час 1000р/чел.', false,
        'ВР Поинт');
insert into vr_club(id, max_players_count)
values (25, 10);
insert into vr_club(id, max_players_count)
values (26, 5);

insert into vr_game(id, name)
values (1, 'OVERWATCH');
insert into vr_game(id, name)
values (2, 'APEX_LEGENDS');
insert into vr_game(id, name)
values (3, 'THE_ELDER_SCROLLS_V_SKYRIM');
insert into vr_game(id, name)
values (4, 'STAR WARS');

insert into vr_club_game(id, vr_club_id, vr_game_id)
values (1, 25, 1);
insert into vr_club_game(id, vr_club_id, vr_game_id)
values (2, 25, 2);
insert into vr_club_game(id, vr_club_id, vr_game_id)
values (3, 26, 3);
insert into vr_club_game(id, vr_club_id, vr_game_id)
values (4, 26, 1);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79545453434', 'Понедельник-пятница', '15:00:00', '20:00:00', 'WIND_TUNNEL', '1 час 9000р/чел.', false,
        'Невесомость');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79213355321', 'Суббота-воскресенье', '12:00:00', '15:00:00', 'WIND_TUNNEL', '1 час 5000р/чел.', false,
        'Космический рейнджер');
insert into wind_tunnel(id)
values (27);
insert into wind_tunnel(id)
values (28);

insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79312356654', 'Понедельник-среда', '10:00:00', '17:00:00', 'ZOO', '1 час 300р/чел.', false,
        'Африка');
insert into general_entertainment(phone_number, shift_name, start_at, end_at, entertainment_type, price, deleted, name)
values ('+79765454563', 'Четверг-суббота', '12:00:00', '19:00:00', 'ZOO', '1 час 500р/чел.', false,
        'Австралия');
insert into zoo(id)
values (29);
insert into zoo(id)
values (30);