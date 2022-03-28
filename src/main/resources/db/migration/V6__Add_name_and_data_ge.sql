ALTER TABLE general_entertainment
    ADD column name varchar(20);

UPDATE general_entertainment
SET name = 'Русская'
WHERE id = 1;

UPDATE general_entertainment
SET name = 'Индийская'
WHERE id = 2;

UPDATE general_entertainment
SET name = 'Итальянская'
WHERE id = 3;