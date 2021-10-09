create database mayasdl;
use mayasdl;
create table Users( uid varchar(30) primary key ,uname varchar(30),passwd varchar(30),address varchar(30));
create table category(cid int primary key,cname varchar(45));
drop table category;

create table book (bid int primary key ,bname varchar(45),author varchar(45),category varchar(45)); 
create table orders( oid int primary key auto_increment,uid varchar(45),bid int,foreign key(uid) references Users(uid) ,foreign key(bid) references book(bid));
