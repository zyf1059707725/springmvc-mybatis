CREATE DATABASE tdb;
USE tdb;
CREATE TABLE t_user(
id VARCHAR(36) PRIMARY KEY,
username VARCHAR(32),
age INT
);
INSERT INTO t_user(id,username,age)VALUES(UUID(),'张三',23);

SELECT * FROM t_user;