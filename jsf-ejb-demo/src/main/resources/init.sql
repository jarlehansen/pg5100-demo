insert into Address (id, city, street) values(100, 'Oslo', 'Torggata');
insert into Customer (id, email, name, fk_address_id) values(101, 'test@test.com', 'test user', 100);