CREATE TABLE IF NOT EXISTS stock
  (
     stock_id  SERIAL PRIMARY KEY NOT NULL,
     name       VARCHAR(50) NOT NULL,
     count int NOT NULL,
     expiry_day int
  );