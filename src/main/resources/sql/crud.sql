UPDATE employees
SET name       = 'Ann',
    is_married = true
WHERE id = 1;

UPDATE organizations
SET name      = 'VB',
    is_active = false
WHERE id = 2;

SELECT *
FROM organizations
WHERE organizations.is_active = false;

SELECT *
FROM employees
WHERE employees.organization_id = 2;

SELECT experience
FROM employees;

SELECT address
FROM organizations;

DELETE
FROM employees
WHERE organization_id = 3;

DELETE
FROM organizations
WHERE id = 3;