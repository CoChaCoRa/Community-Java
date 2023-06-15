create table thumb
(
	id int auto_increment,
	user_id int not null,
	parent_id int not null,
	constraint thumb_pk
		primary key (id)
);