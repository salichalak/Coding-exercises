UPDATE employees AS e
SET salary = salary + 1000
WHERE e.age < 40 AND e.salary <= 5000;