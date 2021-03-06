INSERT INTO organizations (name, phone_number, address, region, country, city, is_active, direction, number_of_offices)
VALUES ('SG', '+380985238965', 'Naulova 12', 'Europe', 'Ukraine', 'Lviv', true, 'Bank', 11),
       ('A-B', '+380985838925', 'Trava 51', 'America', 'Ukraine', 'Lviv', true, 'Bank', 23),
       ('Pomb', '+3806385238965', 'Kilana 12', 'Europe', 'Ukraine', 'Lviv', false, 'Bank', 11);

INSERT INTO employees (name, surname, position, is_married, experience, organization_id)
VALUES ('Kate', 'Latink', 'doctor', 'false', 12, 2),
       ('Daniel', 'Merkin', 'engineer', 'true', 6, 1),
       ('Sara', 'Tomels', 'manager', 'false', 18, 3),
       ('Tom', 'Lavink', 'doctor', 'false', 13, 2),
       ('Lili', 'Nibul', 'engineer', 'false', 22, 3),
       ('Kate', 'Lamk', 'manager', 'true', 32, 1);