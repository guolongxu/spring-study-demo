create database test1 default charset 'utf8';

use test1;

create table tb_user_info(
  id bigint not null primary key,
  name varchar(20) not null ,
  age tinyint,
  email varchar(20)
);


create table tb_user_login(
  id bigint not null primary key ,
  user_id bigint not null ,
  username varchar(32) not null,
  password varchar(128) not null
)


create table tb_user_role(
  id bigint not null primary key ,
  user_id bigint not null ,
  role varchar(16) not null
)


--------------------------------------------------------


create database test2 default charset 'utf8';

use test2;

create table tb_degree(
  id bigint not null primary key ,
  user_id bigint not null ,
  degree varchar(20) not null ,
  start_time datetime not null,
  end_time datetime not null
)
