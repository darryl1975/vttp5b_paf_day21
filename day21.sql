# create database vttp_2025;

use vttp_2025;

drop table tv_shows;

/*
create table tv_shows (
	prog_id int not null auto_increment,
    title char(64) not null,
    lang char(64) not null,
    official_site varchar(255),
    rating enum('G', 'PG', 'NC13', 'M18', 'R21') not null,
    user_rating float default '0.0',
    release_date date,
    image blob,
    constraint pk_prog_id primary key (prog_id),
    constraint chk_user_rating check(user_rating between 0.0 and 10.0)
);

select * from information_schema.table_constraints
where table_name = 'tv_shows'
*/

create table tutorial (
	id int not null auto_increment,
    title varchar(100) not null,
    author varchar(80) not null,
    submission_date date,
    constraint pk_tutorial_id primary key (id)
);

insert into tutorial (title, author, submission_date) values ('CS1001', 'Chuk', '2025-02-01');
insert into tutorial (title, author, submission_date) values ('CS1002', 'Cheesy', '2025-02-05');
insert into tutorial (title, author, submission_date) values ('CS1003', 'Chris', '2025-02-28');
insert into tutorial (title, author, submission_date) values ('CS1004', 'Christy', '2025-03-01');
insert into tutorial (title, author, submission_date) values ('CS1005', 'Melvin', '2025-03-08');
insert into tutorial (title, author, submission_date) values ('CS1006', 'Melcomn', '2025-03-15');
insert into tutorial (title, author, submission_date) values ('CS2001', 'Daisy', '2025-02-01');
insert into tutorial (title, author, submission_date) values ('CS2002', 'Damien', '2025-02-05');
insert into tutorial (title, author, submission_date) values ('CS2003', 'Daniel', '2025-02-28');
insert into tutorial (title, author, submission_date) values ('CS2004', 'Derrick', '2025-03-01');
insert into tutorial (title, author, submission_date) values ('CS2005', 'Darren', '2025-03-08');
insert into tutorial (title, author, submission_date) values ('CS2006', 'Dark Knight', '2025-03-15');

select * from tutorial limit 5 offset 10;

select * from tutorial where author = 'chris';

select * from tutorial where author like '%da%';

select * from tutorial 
where submission_date >= '2025-02-01' and submission_date <= '2025-02-28'
order by id desc, author asc;

select * from tutorial where title in ('cs2001', 'cs1001', 'cs2004');

select * from tutorial 
where submission_date between '2025-02-01' and '2025-02-28'
and author like '%da%';

select * from tutorial 
where submission_date not between '2025-02-01' and '2025-02-28' 
and author like '%da%';

create table tv_shows (
	prog_id int not null auto_increment,
    title char(64) not null,
    lang char(64) not null,
    official_site varchar(255),
    rating enum('G', 'PG', 'NC13', 'M18', 'R21') not null,
    user_rating float default '0.0',
    release_date date,
    image blob,
    constraint pk_prog_id primary key (prog_id),
    constraint chk_user_rating check(user_rating between 0.0 and 10.0)
);

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('AI wil win', 'Chinese', 'PG', 7.5, '2025-01-25');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('James Bond', 'English', 'M18', 8.5, '2023-02-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Inside Out', 'English', 'G', 8.5, '2022-02-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Inside Out 2', 'English', 'G', 8.0, '2024-05-15');


select * 
from tv_shows
where user_rating >= 8.0 
or rating in ('G', 'M18', 'PG');

create table room (
	id int not null auto_increment,
    roomtype varchar(150) not null,
    price float default '150.0',
    constraint pk_room_id primary key (id)
);

create table customer (
	id int not null auto_increment,
    fullname varchar(255) not null,
    email varchar(255) not null,
	constraint pk_customer_id primary key (id)
);

create table reservation (
	id int not null auto_increment,
    start_date date,
    end_date date, 
    cost float,
    customer_id int,
    room_id int,
    constraint pk_reservation_id primary key (id),
    constraint fk_customer_id foreign key (customer_id) references customer(id),
    constraint fk_room_id foreign key (room_id) references room(id)
);

insert into room (roomtype, price) values ('standard', 150.0);
insert into room (roomtype, price) values ('deluxe', 200.0);
insert into room (roomtype, price) values ('super deluxe', 250.0);
insert into room (roomtype, price) values ('president', 300.0);
insert into room (roomtype, price) values ('suite', 350.0);

insert into customer (fullname, email) values ('Emily Quek', 'emilyquek@visa.com.sg');
insert into customer (fullname, email) values ('Zhixuan Kang', 'zhixuan@visa.com.sg');
insert into customer (fullname, email) values ('Aloysius Chen', 'aloysius@visa.com.sg');
insert into customer (fullname, email) values ('Hanyen', 'hanyen@visa.com.sg');
insert into customer (fullname, email) values ('Darryl', 'darrylng@nus.edu.sg');


select * from room;

select * from customer;

# day 22

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Jap Test 1', 'Japanese', 'PG', 8.0, '2025-01-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Jap Test 2', 'Japanese', 'PG', 8.0, '2025-01-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Korea Test 1', 'Korea', 'PG', 8.0, '2025-01-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Korea Test 2', 'Korea', 'PG', 8.0, '2025-01-15');


select distinct lang from tv_shows;

select distinct lang, rating from tv_shows;












