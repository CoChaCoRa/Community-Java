create table users
(
    id int auto_increment primary key,
    account_id varchar(100),
    token char(36),
    name varchar(50),
    email varchar(50),
    gmt_create bigint,
    gmt_modified bigint
);