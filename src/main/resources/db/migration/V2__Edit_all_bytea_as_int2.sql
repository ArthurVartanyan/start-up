alter table billiards drop column table_count;
alter table bowling drop column lanes_count;
alter table bowling drop column lanes_limit;
alter table vr_club drop column max_players_count;

alter table billiards add column table_count smallint;
alter table bowling add column lanes_count smallint;
alter table bowling add column lanes_limit smallint;
alter table vr_club add column max_players_count smallint;