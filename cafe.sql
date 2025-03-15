-- Database: Cafe

-- DROP DATABASE IF EXISTS "Cafe";

-- CREATE DATABASE "Cafe"
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'Ukrainian_Ukraine.1251'
--     LC_CTYPE = 'Ukrainian_Ukraine.1251'
--     LOCALE_PROVIDER = 'libc'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1
--     IS_TEMPLATE = False;

CREATE TABLE Drinks (
    id SERIAL PRIMARY KEY,
    name_uk VARCHAR(100) NOT NULL,
    name_en VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE Desserts (
    id SERIAL PRIMARY KEY,
    name_uk VARCHAR(100) NOT NULL,
    name_en VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE Staff (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    position VARCHAR(50) CHECK (position IN ('Бариста', 'Офіціант', 'Кондитер')) NOT NULL
);

CREATE TABLE Clients (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    discount DECIMAL(5,2) DEFAULT 0.00
);

CREATE TABLE Schedule (
    id SERIAL PRIMARY KEY,
    staff_id INT REFERENCES Staff(id) ON DELETE CASCADE,
    work_date DATE NOT NULL,
    shift VARCHAR(20) CHECK (shift IN ('Ранок', 'День', 'Вечір')) NOT NULL
);

CREATE TABLE Orders (
    id SERIAL PRIMARY KEY,
    client_id INT REFERENCES Clients(id) ON DELETE SET NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Order_Items (
    id SERIAL PRIMARY KEY,
    order_id INT REFERENCES Orders(id) ON DELETE CASCADE,
    item_type VARCHAR(10) CHECK (item_type IN ('Напій', 'Десерт')) NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0)
);

-- 2
INSERT INTO Drinks (name_uk, name_en, price) VALUES ('Капучіно', 'Cappuccino', 45.00);
INSERT INTO Staff (full_name, phone, address, position) VALUES ('Іван Петров', '+380991234567', 'Київ, вул. Хрещатик, 10', 'Бариста');
INSERT INTO Clients (full_name, birth_date, phone, address, discount) VALUES ('Марія Іваненко', '1995-06-15', '+380931234567', 'Львів, вул. Городоцька, 25', 5.00);
INSERT INTO Orders (client_id) VALUES (1);
INSERT INTO Order_Items (order_id, item_type, item_id, quantity) VALUES (1, 'Напій', 1, 2);
INSERT INTO Schedule (staff_id, work_date, shift) VALUES (1, '2025-03-10', 'Ранок');

-- 3
UPDATE Drinks SET price = 50.00 WHERE name_en = 'Cappuccino';
UPDATE Staff SET phone = '+380992345678' WHERE full_name = 'Іван Петров' AND position = 'Бариста';
UPDATE Clients SET discount = 10.00 WHERE full_name = 'Марія Іваненко';

-- 4
DELETE FROM Desserts WHERE name_en = 'Cheesecake';
DELETE FROM Staff WHERE full_name = 'Олександр Коваль' AND position = 'Офіціант';
DELETE FROM Clients WHERE full_name = 'Марія Іваненко';
DELETE FROM Order_Items WHERE order_id = 1 AND item_type = 'Десерт';
DELETE FROM Orders WHERE id = 1;

-- 5
SELECT * FROM Drinks;
SELECT * FROM Desserts;
SELECT * FROM Staff WHERE position = 'Бариста';
SELECT * FROM Staff WHERE position = 'Офіціант';
SELECT * FROM Orders WHERE id IN (SELECT order_id FROM Order_Items WHERE item_type = 'Десерт');
SELECT * FROM Orders WHERE client_id = (SELECT id FROM Clients WHERE full_name = 'Марія Іваненко');
