DROP TABLE IF EXISTS cookbook_users;  
CREATE TABLE cookbook_users ( 
id BIGINT PRIMARY KEY,
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
is_active BOOLEAN,
roles VARCHAR(200) NOT NULL
);
commit;