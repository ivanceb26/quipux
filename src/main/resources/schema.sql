create table category (id varchar(255) not null, href varchar(255), name varchar(255), primary key (id));
create table category_icons (icon_id varchar(255) not null, category_id integer not null);
create table category_song (category_id integer not null, song_id varchar(255) not null);
create table category_icon (id integer not null, height varchar(255), url varchar(255), width varchar(255), primary key (id));
create table playlist (id integer generated by default as identity, description varchar(255) not null, name varchar(255) not null, primary key (id));
create table song (id integer generated by default as identity, album varchar(255) not null, artist varchar(255) not null, title varchar(255) not null, year varchar(255) not null, primary key (id));
create table song_playlist (song_id integer not null, playlist_id integer not null);
alter table playlist add constraint UK_gmx0jjome08oqihtks37w0lea unique (name);
alter table category_icons add constraint FK5s7fsydnf237wyljp62t3ad5s foreign key (category_id) references category_icon;
alter table category_icons add constraint FK4f3un4ilwgij72iy5qbsp788q foreign key (icon_id) references category;
alter table category_song add constraint FKkl7qasp3l23hvejawtuad5tqh foreign key (song_id) references category;
alter table category_song add constraint FKps8bbvysto4odjamngodkgjw5 foreign key (category_id) references song;
alter table song_playlist add constraint FK3kcniofvjgjemna8k62ow0vao foreign key (playlist_id) references song;
alter table song_playlist add constraint FK4krmv7n3wdp3hkyqqt0u85cj8 foreign key (song_id) references playlist;
