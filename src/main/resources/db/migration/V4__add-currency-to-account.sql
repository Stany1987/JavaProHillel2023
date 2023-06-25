ALTER TABLE accounts ADD COLUMN currency VARCHAR(5);
UPDATE accounts
SET currency = 'UAH';
ALTER TABLE accounts
ALTER COLUMN currency SET NOT NULL;