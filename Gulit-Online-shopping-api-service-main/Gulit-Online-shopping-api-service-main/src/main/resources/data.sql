INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (1, 'USER');
INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (2, 'ADMIN');

insert into user (id ,username, password, is_enabled )  VALUES (1,'user@gmail.com','1234',true);
insert into user (id, username, password, is_enabled )  VALUES (2,'admin@gmail.com','1234',true);

insert into USER_ROLES(USER_ID, ROLE_ID) VALUES (1, 1);
insert into USER_ROLES(USER_ID, ROLE_ID) VALUES (2, 2);

insert into brand (id,name) VALUES (1,'Nike');
insert into brand (id,name) VALUES (2,'Nokia');
insert into brand (id,name) VALUES (3,'Samsung');
insert into brand (id,name) VALUES (4,'Apple');

insert into category (id,name) VALUES (1,'Shoes');
insert into category (id,name) VALUES (2,'Electronics');
insert into category (id,name) VALUES (3,'Books');

insert into USER_ADDRESS(ID ,CITY ,STREET_ADDRESS1 ,STREET_ADDRESS2 ,ZIP_CODE,state ) values (1,'Fairfield','100 N 4th','MR #322',52557,'IOWA');
insert into USER_ADDRESS(ID ,CITY ,STREET_ADDRESS1 ,STREET_ADDRESS2 ,ZIP_CODE,state) values (2,'Fairfield','2000 N 4th','MR #106',52556,'LA');

insert into BUYER(B_ID ,POINTS ,BILLING_ADDRESS_ID ,SHIPPING_ADDRESS_ID ,USER_ID ) values (1,14,1,1,2);

insert into seller(seller_Id,COMPANY, IS_APPROVED, WEBSITE, USER_ID) values (1,'MIU',false,'www.miu.edu',1);


insert into product (id, brand_id, category_id, description, is_active, name, price, quantity,SELLER_SELLER_ID  ) VALUES (1, 1,1, 'Nike Summer shoes confrtable', true,'Nike Zoom 12', 142.2,15,1);

insert into product (id, brand_id, category_id, description, is_active, name, price, quantity) VALUES (2, 2,2, 'Nokia best camera Mobile', true, 'Nokia 7,2', 342.2,50);

insert into product (id, brand_id, category_id, description, is_active, name, price, quantity) VALUES (3, 3,2, 'Apple 12 is now goe live', true,'Apple 13 pro', 312.2,20);

insert into product (id, brand_id, category_id, description, is_active, name, price, quantity) VALUES (4, 4,2, 'Google Pixel 5a - 5G with three month free Go-FI', true, 'Pixel 5a', 450.0,12);




