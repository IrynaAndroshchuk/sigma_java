CREATE TABLE organizations
(
    id              SERIAL       NOT NULL
        CONSTRAINT organization_key PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    phone_number     VARCHAR(255),
    address         VARCHAR(255),
    region          VARCHAR(255),
    country         VARCHAR(255) NOT NULL,
    city            VARCHAR(255) NOT NULL,
    is_active        BOOLEAN      NOT NULL,
    direction       VARCHAR(255),
    numberOfOffices INT
);

CREATE TABLE employees
(
    id              SERIAL NOT NULL
        CONSTRAINT employee_key PRIMARY KEY,
    name            VARCHAR(255),
    surname         VARCHAR(255),
    is_married      BOOLEAN,
    experience      INT,
    organization_id INT    NOT NULL,
    CONSTRAINT fk_organizations_employees_id FOREIGN KEY (organization_id) REFERENCES organizations (id)
);