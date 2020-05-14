CREATE TABLE employees (
    id SERIAL NOT NULL CONSTRAINT employee_key PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    organization_id INT NOT NULL,
     CONSTRAINT fk_organizations_employees_id FOREIGN KEY (organization_id) REFERENCES organizations (id)
);

CREATE TABLE organizations (
id SERIAL NOT NULL CONSTRAINT organization_key PRIMARY KEY,
name VARCHAR(255),
amount_of_employees INT
);