CREATE TABLE IF NOT EXISTS tasks ( task_id INT AUTO_INCREMENT, title VARCHAR(255) NOT NULL,  start_date DATE, due_date DATE,  priority TINYINT NOT NULL DEFAULT 3, description TEXT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (task_id));

INSERT INTO tasks(title,priority)VALUES('Learn MySQL INSERT Statement',1);
INSERT INTO tasks(title,start_date, due_date, priority, description)VALUES('Learn MySQL INSERT Statement','2023-09-24', '2023-10-01',0, 'Not null avoided');
INSERT INTO tasks(title,start_date, due_date, priority, description)VALUES(?,?,?,?,?);
SELECT * FROM tasks;