set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite3;

create database if not exists ecsite3;
use ecsite3;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_password varchar(16),
user_name varchar (50),
user_address varchar(50),
user_tell varchar(50),
master varchar(50),

insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名",
release_date datetime not null comment "発売年月",
release_company varchar(50) comment "発売会社"
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);

drop table if exists cart_info_transaction;

create table cart_info_transaction(
id int not null primary key auto_increment,
user_id int,
product_id int,
count int
);
INSERT INTO item_info_transaction VALUES
(1,"Sweden Berg SnowBoard",138,10,"./img/","board1.jpg",now(),"発売会社"),
(2,"Arbor Clovis SnowBoard",400,5,"./img/","board2.jpg",now(),"発売会社"),
(3,"Arbor Element Midwide",440,5,"./img/","board3.jpg",now(),"発売会社"),
(4,"Bataleon Camel Toe SnowBoard",315,5,"./img/","board4.jpg",now(),"発売会社");
INSERT INTO login_user_transaction(login_id, login_password, user_name, master) VALUES("Aaa","123","taro", "master");

