CREATE TABLE IF NOT EXISTS items ( item_id INT AUTO_INCREMENT, item_code VARCHAR(255) NOT NULL, item_quantity INT NOT NULL DEFAULT 1, item_price DOUBLE NOT NULL,user_id INT NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (item_id));

CREATE TABLE IF NOT EXISTS users( user_id INT AUTO_INCREMENT, username UNIQUE VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, PRIMARY KEY (user_id));

SELECT * FROM items;

INSERT INTO items(item_code,item_quantity, item_price, user_id)VALUES(?,?,?, ?);

INSERT INTO users(username, password)VALUES(?,?);

SELECT user_id FROM users WHERE username = ? AND password = ?;

-- selecting items for specific user
SELECT * FROM items WHERE user_id = ?;