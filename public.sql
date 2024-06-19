-- Active: 1707989179952@@127.0.0.1@5432@product_db@public

create DATABASE product_db;

create table product(
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR,
    price_per_unit NUMERIC(10,2),
    active_for_sell INTEGER
);


insert into product (product_name,price_per_unit,active_for_sell)
VALUES('Coke',2.00,1),('Pepsi',2.00,1),('Kizz',1.5,1),('RedBull',2.00,0);