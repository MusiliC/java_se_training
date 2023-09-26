CREATE TABLE IF NOT EXISTS items ( item_id INT AUTO_INCREMENT, item_code VARCHAR(255) NOT NULL, item_quantity INT NOT NULL DEFAULT 1, item_price DOUBLE NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (item_id));

SELECT * FROM items;

INSERT INTO items(item_code,item_quantity, item_price)VALUES(?,?,?);