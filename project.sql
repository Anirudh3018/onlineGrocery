create table customer(
	cust_id number(6) primary key,
	fname varchar(15) not null,
	lname varchar(15) not null,
	mobile_no number(10) not null,
	email varchar(30) not null,
	password varchar(10) not null,
	flat_details varchar(50) not null,
	street varchar(25) not null,
	locality varchar(25) not null,
	city varchar(15) not null
);

create table categories(
	category_id number(6) primary key,
	category_name varchar(15) not null
);

create table items(
	category_id number(6),
	item_id number(6) primary key,
	item_name varchar(20) not null,
	brand varchar(15),
	price number(4) not null,
	foreign key(category_id) references categories(category_id) on delete cascade 
);
create table stock(
	item_id number(6) primary key,
	item_qty number(3) not null,
	mfg_date date,
	exp_date date,
	foreign key(item_id) references items(item_id)
);

create table cart(
	cart_id number(6) ,
	item_id number(6) ,
	item_name varchar(20) not null,
	item_qty number(2) not null,
	item_price number(4) not null,
	primary key(cart_id,item_id)
); 

create table added_to(
	cart_id number(6) not null,
	item_id number(6) not null,
	primary key(cart_id,item_id),
	foreign key(cart_id) references cart(cart_id) on delete cascade ,
	foreign key(item_id) references items(item_id) on delete cascade
);

create table order_history(
	order_id number(6) primary key,
	item_id number(6) ,
	item_name varchar(20) not null,
	item_qty number(2) not null,
	item_price number(4) not null,
	cust_id number(6) not null,
	foreign key(cust_id) references customer(cust_id),
	foreign key(item_id) references items(item_id)
);


	