insert into customer values
(1,'Jess','Singh',7091235699,'jessSingh@gmail.com','jess',
'405,Palm Heights','21st Lane','Gandhinagar','Delhi');
insert into customer values
(2,'William','Dsouza',8031235600,'josh1994@gmail.com',
'josh','180,Spring Mansion','24st Street','Amar Circle','Delhi');

drop table order_history;
drop table added_to;
drop table cart;
drop table stock;
drop table items;
drop table categories;

//category_name and item_name size changed

create table categories(
	category_id number(6) primary key,
	category_name varchar(30) not null
);

create table items(
	category_id number(6),
	item_id varchar(6) primary key,
	item_name varchar(40) not null,
	brand varchar(25),
	price number(4) not null,
	foreign key(category_id) references categories(category_id)
);

set define off;
insert into categories values(1,'Breakfast Foods');
insert into categories values(2,'Coffee,Tea & Health Drinks');
insert into categories values(3,'Rice,Flour & Pulses');
insert into categories values(4,'Dairy');
insert into categories values(5,'Dried Fruits & Nuts');
insert into categories values(6,'Oils,Spices & Masalas');
insert into categories values(7,'Biscuits & Cookies');
insert into categories values(8,'Pasta & Noodles');
insert into categories values(9,'Fried Snacks');
insert into categories values(10,'Sweets & Chocolates');
insert into categories values(11,'Fresh Veggies');
insert into categories values(12,'Fresh Fruits');
set define on;

insert into items values(2,1,'Red Label Tea,500g','Brooke Bond',215);
insert into items values(2,2,'Taj Mahal Tea,500g','Brooke Bond',295);
insert into items values(2,3,'Bournvita,750g','Cadbury',250);
insert into items values(2,4,'BRU Instant Coffee,100g','BRU',180);
insert into items values(2,5,'Nescafe Classic Coffee,200g','Nescafe',475);
insert into items values(2,6,'Horlicks,1 kg Refill Pack','Horlicks',355);
insert into items values(2,7,'BRU Gold Instant Coffee,100g','BRU',245);
insert into items values(2,8,'Instant Lemon Iced Tea,400g','Nestea',165);
insert into items values(2,9,'Horlicks,750g Refill Pack','Horlicks',330);
insert into items values(2,10,'Bourn Vita Little Champs,500g','Cadbury',280);
insert into items values(2,11,'Kanan Devan Classic Tea,1Kg','TATA Tea',260);
insert into items values(2,12,'Boost,750g Refil Pack','Boost',350);
insert into items values(2,13,'Lemon and Honey Green Tea,100g','Tetley',120);
insert into items values(2,14,'Darjeelling Tea,500g','Lipton',900);
insert into items values(2,15,'Badam Drink Mix,1Kg','MTR',425);
insert into items values(2,16,'Mothers Horlicks,500g','Horlicks',515);
insert into items values(2,17,'Juniors Horlicks,500g','Horlicks',273);
insert into items values(2,18,'Protinex Junior,400g','Protinex',650);
insert into items values(2,19,'Protinex Mama,400g','Protinex',650);
insert into items values(2,20,'Horlicks Lite,450g','Horlicks',290);

insert into items values(1,21,'Chocos,700g','Kelloggs',300);
insert into items values(1,22,'Corn Flakes,Real Almond and Honey,650g','Kelloggs',350);
insert into items values(1,23,'Oats,1.5Kg','Disano',200);
insert into items values(1,24,'Mixed Fruit Muesli,1Kg','Bagrrys',375);
insert into items values(1,25,'Crunchy Granola ,460g','Kelloggs',290);
insert into items values(1,26,'Multigrain Oats and Honey,435g','Kelloggs',230);
insert into items values(1,27,'Quinoa,500g','India Gate',235);
insert into items values(1,28,'Ragi Chocos,350g','Kelloggs',180);
insert into items values(1,29,'Corn Flakes,875g','Patanjali',185);
insert into items values(1,30,'Choco Delight Muesli Jar,1Kg','Bagrrys',575);
insert into items values(1,31,'Instant Uttappam Mix,200g','Gits',50);
insert into items values(1,32,'Masala Idli Breakfast Mix,500g','MTR',105);
insert into items values(1,33,'Vada Breakfast Mix,200g','MTR',95);
insert into items values(1,34,'Koko Crunch Cereal,250g','Nestle',105);
insert into items values(1,35,'Special K Cereal,900g','Kelloggs',390);
insert into items values(1,36,'Masala Upma Mix,180g','MTR',65);
insert into items values(1,37,'Protein Muesli,500g','Baggrys',399);
insert into items values(1,38,'Kesari Halwa Pouch,150g','MTR',45);
insert into items values(1,39,'Organic Pongal,200g','Kitchens Of India',120);
insert into items values(1,40,'Cuppa Misal,Pack of 12','Kitchens Of India',415);

insert into items values(3,41,'Moong Dal,1Kg','Vedaka',140);
insert into items values(3,42,'Gram Flour,1Kg','Vedaka',180);
insert into items values(3,43,'Rozana Super Basmati Rice,5Kg','Daawat',420);
insert into items values(3,44,'Everyday Basmati,2Kg','Fortune',215);
insert into items values(3,45,'Moong Dal(Yellow),1Kg','TATA',145);
insert into items values(3,46,'Organic Ragi Flour,500g','Vedaka',50);
insert into items values(3,47,'Chakki Fresh Atta,5Kg','Pilsbury',210);
insert into items values(3,48,'Organic Bajra Flour,500g','Vedaka',50);
insert into items values(3,49,'Premium Sooji Rawa,500g','Agro Fresh',35);
insert into items values(3,50,'Unpolished Rajma,500g','TATA',85);
insert into items values(3,51,'Black Masoor Whole,1Kg','Vedaka',100);
insert into items values(3,52,'Urad Dal,1Kg','TATA',145);
insert into items values(3,53,'Brown Rice,1Kg Jar','India Gate',135);
insert into items values(3,54,'Basmati Rice Pouch,1Kg','India Gate',98);
insert into items values(3,55,'Kabuli Channa,500g','TATA',70);
insert into items values(3,56,'Maida,1Kg','Vedaka',55);
insert into items values(3,57,'Corn Flour,500g','Weikfeild',75);
insert into items values(3,58,'Red Masoor Dal Split,500g','Vedaka',45);
insert into items values(3,59,'Kala Channa(Unpolished),1Kg','TATA',120);
insert into items values(3,60,'White Urad Dal Split,1Kg','TATA',145);

insert into items values(4,61,'Pure Ghee,1L','Nandini',490);
insert into items values(4,62,'Malai Paneer,200g','Amul',75);
insert into items values(4,63,'Pure Ghee,500ml','Nandini',245);
insert into items values(4,64,'Full Cream Milk,500ml','Mother Dairy',27);
insert into items values(4,65,'Fresh Paneer,200g','Mother Dairy',71);
insert into items values(4,66,'Butter-Pasteurized 100g','Amul',48);
insert into items values(4,67,'Greek Yoghurt-Wild Raspberry,90g','Epigamia',45);
insert into items values(4,68,'Premium Fresh Paneer,500g','Milky Mist',235);
insert into items values(4,69,'Classic Dahi,200g','Mother Dairy',25);
insert into items values(4,70,'Fresh Cream,200ml carton','Mother Dairy',55);
insert into items values(4,71,'Mishti Doi,400g','Mother Dairy',65);
insert into items values(4,72,'Low Fat Milk,500ml','Mother Dairy',25);
insert into items values(4,73,'Fruit Yoghurt-Mango,100g','Mother Dairy',25);
insert into items values(4,74,'Toned Milk,500ml','Nandini',25);
insert into items values(4,75,'Lassi-Mango,200ml bottle','Mother Dairy',20);
insert into items values(4,76,'Almond Milk,1L','So Good',275);
insert into items values(4,77,'Pizza Cheese,400g','Brittania',240);
insert into items values(4,78,'Fruit Yoghurt-Raspberry,100g','Mother Dairy',25);
insert into items values(4,79,'Pure Cow Milk,500ml','Mother Dairy',25);
insert into items values(4,80,'Cooking Butter,500g','Heritage',235);
insert into items values(4,81,'Cheese-Spread,200g','Mother Dairy',5);
insert into items values(4,82,'Pepper Cheddar Cheese,200g','Amul',125);

insert into items values(5,83,'Black Raisins,100g','Vedaka',90);
insert into items values(5,84,'Organic Raw Peanuts,500g','Pro Nature',125);
insert into items values(5,85,'Dried Cranberries,200g','Vedaka',280);
insert into items values(5,86,'Cashews,200g','Vedaka',200);
insert into items values(5,87,'Walnut Kernels Broken,500g','Solimo',700);
insert into items values(5,88,'Inshell Walnuts,500g','Solimo',500);
insert into items values(5,89,'Premium Cashews,250g','Solimo',335);
insert into items values(5,90,'Roasted and Salted Almonds,200g','Vedaka',235);
insert into items values(5,91,'Turkish Apricots,200g','Solimo',285);
insert into items values(5,92,'Dried Cranberries,200g','Gourmia',285);
insert into items values(5,93,'Mix Berries,200g','Gourmia',580);
insert into items values(5,94,'Dried Figs,200g','Solimo',425);
insert into items values(5,95,'Premium California Almonds,200g','Solimo',850);
insert into items values(5,96,'Iranian Pistachios,200g','Gourmia',335);
insert into items values(5,97,'Premium Salted Party Mix,200g','Pro Nature',310);
insert into items values(5,98,'Premium Seedless Raisins,250g','Pro Nature',265);
insert into items values(5,99,'Kashmiri Walnuts,200g','Gourmia',255);
insert into items values(5,100,'Premium Natural Whole Cashews,200g','Pro Nature',155);

insert into items values(6,101,'Refined Sunflower Oil,1L','Gemini',110);
insert into items values(6,102,'Extra Virgin Olive Oil,1L','Disano',650);
insert into items values(6,103,'Garam Masala,100g','TATA',85);
insert into items values(6,104,'Turmeric Powder,200g','TATA',60);
insert into items values(6,105,'Canola Oil,1L','Borges',200);
insert into items values(6,106,'Pure Mustard Oil,1L','Fortune',150);
insert into items values(6,107,'Coriander Powder,200g','TATA',60);
insert into items values(6,108,'Jeera,100g','Agro Fresh',40);
insert into items values(6,109,'Rice Bran Health Oil,5L','Fortune',675);
insert into items values(6,110,'Sambhar Masala,45g','TATA',35);
insert into items values(6,111,'Kithen King Masala,100g','Catch',65);
insert into items values(6,112,'Soyabean Oil,1L','Fortune',120);
insert into items values(6,113,'Extra Light Olive Oil,2L','Disano',1450);
insert into items values(6,114,'Premium Raw Chia Seeds,100g','Vedaka',130);
insert into items values(6,115,'Rajma Masala,100g','Catch',65);
insert into items values(6,116,'Pizza Oregano,80g','Keya',80); 
insert into items values(6,117,'Red Chilli Flakes,40g','Keya',80);
insert into items values(6,118,'Caraway Seeds(Shahjeera),100g','Catch',60);
insert into items values(6,119,'Refined Soyabean Oil,1L','Gemini',135);
insert into items values(6,120,'Organic Cardamom,10g','Pro Nature',50);
insert into items values(6,121,'Dal Tadka Masala,100g','TATA',65);
insert into items values(6,122,'Organic Fenugreek Seed,100g','Pro Nature',40);

insert into items values(7,123,'Dark Fantasy Choco Fills,300g','Sunfeast',130);
insert into items values(7,124,'Moms Magic Cashew and Almonds,200g','Sunfeast',35);
insert into items values(7,125,'Cookie Cake Choco Trio,20g(pack of 6)','Pillsbury',60);
insert into items values(7,126,'Cashew Badam Cookies,500 g','UNIBIC',120);
insert into items values(7,127,'Marie Light Oats,200g','Sunfeast',25);
insert into items values(7,128,'Choco Chip Cookies,(5 x 100g)','UNIBIC',145);
insert into items values(7,129,'Krack Jack Biscuit, 200g','Parle',30);
insert into items values(7,130,'Farmlite Digestive,100g','Sunfeast',25);
insert into items values(7,131,'Farmlite Digestive Oats with Almonds,50g','Sunfeast',50);
insert into items values(7,132,'Cookie Cake, Tutti Frutti,(Pack of 6)','Pillsbury',60);
insert into items values(7,133,'Assorted Cookies,(Pack of 6 x 75 g)' ,'UNIBIC',125); 
insert into items values(7,134,'Milano Chocolate Chip Cookies,200g','Parle',30);
insert into items values(7,135,'Nutri Choice-Digestive Biscuits,100 g','Britannia',25);
insert into items values(7,136,'Hide & Seek Chocolate Chip Cookies,200g','Parle',30);
  
insert into items values(8,137,'Maggi Noodles Masala,280g','Maggi',45);
insert into items values(8,138,'Durum Wheat Spaghetti Pasta,500g','Solimo',99);
insert into items values(8,139,'Cheese Maraconi Pazzta,70g','Maggi',25);
insert into items values(8,140,'Cheesy Tomato Twist Pazzta,70g','Maggi',25);
insert into items values(8,141,'Mast Masala Soupy Noodles(Pack of 4)','Knorr',60);
insert into items values(8,142,'Durum Wheat Penne Pasta,500g','Solimo',99);
insert into items values(8,143,'Yippee Mood Masala Noodles,280 g','Sunfeast',55);
insert into items values(8,144,'Cuppa Mania Chilli Chow Cup Noodles,70g','Maggi',45);
insert into items values(8,145,'Elbow Pasta,500g','Weikfield',175);
insert into items values(8,146,'Penne Pasta,250g','Bambino',70);
insert into items values(8,147,'Masala Penne Pazzta,70g','Maggi',25);
insert into items values(8,148,'Veg Atta Masala Noodles–290g(Pack of 4)','Maggi',80);
insert into items values(8,149,'Cheesy Creamy Pasta,64g','Weikfield',25); 
insert into items values(8,150,'Fusilli Pasta,200g','Weikfield',70);
insert into items values(8,151,'Shell Pasta,250g','Bambino',70); 

insert into items values(9,152,'Mad Angles Mmmmm Masala,80g','Bingo',20);
insert into items values(9,153,'Jalapeno Nachoz,150g','Act II',65);
insert into items values(9,154,'Quinoa Nachos Crisps,70 g','Cornitos',60);
insert into items values(9,155,'Bhujia Sev,1Kg','Haldirams',190);
insert into items values(9,156,'Lays Magic Masala Chips','Lays',35); 
insert into items values(9,157,'Mad Angles Achari Masti,80g','Bingo',20); 
insert into items values(9,158,'Dry Fruit Mixture,150g','Haldirams',70);
insert into items values(9,159,'Potato chips Tomato,52g','Bingo',20);
insert into items values(9,160,'Peri Peri Nachos and Salsa Dip Tray','Cornitos',60);
insert into items values(9,161,'Lays Classic Salted Chips','Lays',35); 
insert into items values(9,162,'Nacho Crisps-Cheese and Herbs,150 g','Cornitos',85);
insert into items values(9,163,'Nacho Tortilla Chips-Cheese,44 g','Doritos',35);
insert into items values(9,164,'Pringles Potato Chips-Original,150g','Pringles',99);
insert into items values(9,165,'Lays Spanish Tomato Tango Chips','Lays',35); 

insert into items values(10,166,'Instant Gulab Jamun Mix,500g','MTR',175);
insert into items values(10,167,'Choco Double Eclairs,760g','Candyman',200);
insert into items values(10,168,'Choclairs Gold,630g','Cadbury',200);
insert into items values(10,169,'Instant Mix Vermicelli Payasam,200g','Maiyas',70);
insert into items values(10,170,'Dairy Milk Chocolate Shots,(58 units)','Cadbury',120);
insert into items values(10,171,'Dairy Milk Lickables,20 g','Cadbury',40);
insert into items values(10,172,'Jodhpuri Moong Dal Halwa,250g','Kitchens of India',145);
insert into items values(10,173,'Gulab Jamun Tin, 500g','MTR',115);
insert into items values(10,174,'Instant Phirni Dessert Mix,200g','Maiyas',70);
insert into items values(10,175,'Sweet Mix Vermicelli Payasam,100g','MTR',45);


insert into items values(11,176,'Organically Grown Tomatoes,500 g','Fresho',12);
insert into items values(11,177,'Baby Potatoes,250g','Fresho',8);
insert into items values(11,178,'Parwal 500g','Fresho',100);	
insert into items values(11,179,'Organically Grown Onion,1Kg','Fresho',50); 
insert into items values(11,180,'Zucchini-Yellow,250g','Fresho',55);
insert into items values(11,181,'Ridge Gourd,500g','Fresho',25);
insert into items values(11,182,'Broccoli,1Kg','Fresho',110);
insert into items values(11,183,'Kale,100g','Fresho',45);
insert into items values(11,184,'Spring Onion,100g','Fresho',10);
insert into items values(11,185,'Cucumber,250g','Fresho',10);
insert into items values(11,186,'Amaranthus-Red,250g','Fresho',20);
insert into items values(11,187,'Palak/Spinach,250 g','Fresho',15);

insert into items values(12,188,'Orange-Nagpur,2 Kg','Fresho',85);
insert into items values(12,189,'Avocado,500g','Fresho',200);
insert into items values(12,190,'Pear-Green,2 pcs','Fresho',65);
insert into items values(12,191,'Banana-Red/Sevvazhai,1Kg','Fresho',75);
insert into items values(12,192,'Kiwi-Green,1 pc','Fresho',20);
insert into items values(12,193,'Banana-Nendran,1 Kg','Fresho',34);
insert into items values(12,194,'Wood Apple,1 pc','Fresho',15);
insert into items values(12,195,'Strawberry,200g','Fresho',55);
insert into items values(12,196,'Apple-Kinnaur,6 pcs','Fresho',260);
insert into items values(12,197,'Banana-Robusta,1 Kg','Fresho',35);
insert into items values(12,198,'Dragon Fruit 1 pc','Hopcoms',155);
insert into items values(12,199,'Raw Mango,250 g','Fresho',23);
insert into items values(12,200,'Grapes-Red Globe,250 g','Fresho',115);





