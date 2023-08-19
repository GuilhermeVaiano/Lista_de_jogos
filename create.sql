create table tb_belonging (position integer, list_id bigint not null, game_id bigint not null, primary key (game_id, list_id));
create table tb_game (id bigserial not null, title varchar(255), game_year integer, genre varchar(255), platforms varchar(255), score float(53), img_url varchar(255), short_description TEXT, long_description TEXT, primary key (id));
create table tb_game_list (id bigserial not null, name varchar(255), primary key (id));
alter table tb_belonging add constraint FKrchwdikeu66uky1hf75ym1kh foreign key (list_id) references tb_game_list;
alter table tb_belonging add constraint FK2slybclee7wdfxhfltbvqkgpg foreign key (game_id) references tb_game;

