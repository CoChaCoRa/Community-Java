create table comments
(
	id bigint auto_increment primary key,
	parent_id int not null,
	parent_type int not null,
	creator int not null,
	gmt_create bigint not null,
	gmt_modified bigint not null,
	like_count bigint default 0
);