DROP DATABASE
IF
	EXISTS springmvc;
CREATE DATABASE springmvc;
USE springmvc;

DROP TABLE IF EXISTS users;
	
CREATE TABLE users (
	id INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '编号',
	username VARCHAR ( 255 ) DEFAULT NULL COMMENT '用户名',
	email VARCHAR ( 255 ) DEFAULT NULL COMMENT '邮箱',
	age INT ( 11 ) DEFAULT NULL COMMENT '年龄',
	phone VARCHAR ( 11 ) DEFAULT NULL COMMENT '手机号',
	pwd VARCHAR ( 8 ) DEFAULT NULL COMMENT '密码',
	PRIMARY KEY ( id ) 
);

 
	DELETE  	FROM users;
	
	INSERT INTO users ( username, email, age, phone, pwd )
	VALUES
		('李四', 'lisi@2.com ,123456', 33, '18820285401', '1212' ),
		('44', '22', 11, '33', '222222' ),
		('31231313', '31231', 231333, '312313', '2222222' ),
		('21', '3', 2, '2', NULL ),
		( '1', '2', 2, '3', NULL ),
		( NULL, '/upload/1561821284810.txt', 0, NULL, NULL ),
		( '李四', 'lisi@2.com', 33, '18820285401', NULL ),
		( '44', '22', 11, '33', NULL );
 
COMMIT;