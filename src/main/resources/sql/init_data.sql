INSERT INTO organizations (name, phoneNumber, address, region, country, city, isActive, direction, numberOfOffices)
VALUES ('SG', '+380985238965', 'Naulova 12', 'Lviv', 'Ukraine', 'Lviv', 'true', 'Bank', '11'),
       ('A-B', '+380985838925', 'Trava 51', 'Lviv', 'Ukraine', 'Lviv', 'true', 'Bank', '23'),
       ('Pomb', '+3806385238965', 'Kilana 12', 'Lviv', 'Ukraine', 'Lviv', 'false', 'Bank', '11');

INSERT INTO employees (name, surname, is_married, experience, organization_id)
VALUES ('Kate', 'Latink', 'false', 12, 2),
       ('Daniel', 'Merkin', 'true', 6, 1),
       ('Sara', 'Tomels', 'false', 18, 3),
       ('Tom', 'Lavink', 'false', 13, 2),
       ('Lili', 'Nibul', 'false', 22, 3),
       ('Kate', 'Lamk', 'true', 32, 1);