insert into customer values
(1,'Jess','Singh',7091235699,'jessSingh@gmail.com','jess',
'405,Palm Heights','21st Lane','Gandhinagar','Delhi');
insert into customer values
(2,'William','Dsouza',8031235600,'josh1994@gmail.com',
'josh','180,Spring Mansion','24st Street','Amar Circle','Delhi');

insert into categories values(1,'Snacks');
insert into categories values(2,'Fruits');
insert into categories values(3,'Vegetables');
insert into categories values(4,'Dairy');
insert into categories values(5,'Grains');

insert into items values(1,1,'Maggi Noodle','Maggi',20);
insert into items values(1,2,'Cheese Puffcorn','Kurkure',10); 
insert into items values(2,3,'Oranges-1kg','Achal',40);
insert into items values(2,4,'Bananas-1kg','Achal',35);
insert into items values(3,5,'Green peas-0.5kg','Vijaya',40);
insert into items values(3,6,'Carrots-1kg','Vijaya',40);
insert into items values(4,7,'Cheese','Amul',40);
insert into items values(4,8,'Milk','Amul',30);
insert into items values(5,9,'Rice-1kg','Gerbs',30);
insert into items values(5,10,'Wheat-1kg','Ashirvad',40);

insert into stock values(1,200,TO_DATE('10/02/2020','dd/mm/yyyy'),TO_DATE('10/04/2020','dd/mm/yyyy'));
insert into stock values(2,50,TO_DATE('1/02/2020','dd/mm/yyyy'),TO_DATE('1/04/2020','dd/mm/yyyy'));
insert into stock values(3,200,TO_DATE('4/02/2020','dd/mm/yyyy'),TO_DATE('24/02/2020','dd/mm/yyyy'));
insert into stock values(4,200,TO_DATE('10/02/2020','dd/mm/yyyy'),TO_DATE('20/02/2020','dd/mm/yyyy'));
insert into stock values(5,200,TO_DATE('1/02/2020','dd/mm/yyyy'),TO_DATE('10/02/2020','dd/mm/yyyy'));
insert into stock values(6,200,TO_DATE('17/02/2020','dd/mm/yyyy'),TO_DATE('25/02/2020','dd/mm/yyyy'));
insert into stock values(7,100,TO_DATE('1/02/2020','dd/mm/yyyy'),TO_DATE('10/03/2020','dd/mm/yyyy'));
insert into stock values(8,100,TO_DATE('10/02/2020','dd/mm/yyyy'),TO_DATE('13/02/2020','dd/mm/yyyy'));
insert into stock values(9,25,TO_DATE('10/02/2020','dd/mm/yyyy'),TO_DATE('10/04/2020','dd/mm/yyyy'));
insert into stock values(10,25,TO_DATE('10/02/2020','dd/mm/yyyy'),TO_DATE('10/03/2020','dd/mm/yyyy'));


