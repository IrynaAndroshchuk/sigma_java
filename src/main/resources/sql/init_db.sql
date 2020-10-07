CREATE TABLE organizations
(
    id                SERIAL       NOT NULL
        CONSTRAINT organization_key PRIMARY KEY,
    name              VARCHAR(255) NOT NULL,
    phone_number      VARCHAR(255),
    address           VARCHAR(255),
    region            VARCHAR(255),
    country           VARCHAR(255) NOT NULL,
    city              VARCHAR(255) NOT NULL,
    is_active         BOOLEAN      NOT NULL,
    direction         VARCHAR(255),
    number_of_offices INT
);

CREATE TABLE employees
(
    id              SERIAL NOT NULL
        CONSTRAINT employee_key PRIMARY KEY,
    name            VARCHAR(255),
    surname         VARCHAR(255),
    position        VARCHAR(255),
    is_married      BOOLEAN,
    experience      INT,
    organization_id INT,
    CONSTRAINT fk_organizations_employees_id FOREIGN KEY (organization_id) REFERENCES organizations (id)
);