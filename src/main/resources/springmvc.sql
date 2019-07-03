DROP DATABASE
IF
	EXISTS springmvc;
CREATE DATABASE springmvc;
USE springmvc;
DROP TABLE
IF
	EXISTS `springmvc`.`users`;
CREATE TABLE `users` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '编号',
	`username` VARCHAR ( 255 ) DEFAULT NULL COMMENT '用户名',
	`email` VARCHAR ( 255 ) DEFAULT NULL COMMENT '邮箱',
	`age` INT ( 11 ) DEFAULT NULL COMMENT '年龄',
	`phone` VARCHAR ( 11 ) DEFAULT NULL COMMENT '手机号',
	`pwd` VARCHAR ( 8 ) DEFAULT NULL COMMENT '密码',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB AUTO_INCREMENT = 33 DEFAULT CHARSET = utf8;
BEGIN;
	LOCK TABLES `springmvc`.`users` WRITE;
	DELETE 
	FROM
		`springmvc`.`users`;
	INSERT INTO `springmvc`.`users` ( `id`, `username`, `email`, `age`, `phone`, `pwd` )
	VALUES
		( 2, '李四', 'lisi@2.com ,123456', 33, '18820285401', '1212' ),
		( 3, '44', '22', 11, '33', '222222' ),
		( 4, '31231313', '31231', 231333, '312313', '2222222' ),
		( 8, '21', '3', 2, '2', NULL ),
		( 12, '1', '2', 2, '3', NULL ),
		( 13, NULL, '/upload/1561821284810.txt', 0, NULL, NULL ),
		( 14, '李四', 'lisi@2.com', 33, '18820285401', NULL ),
		( 15, '44', '22', 11, '33', NULL ),
		( 16, '1', '31231', 231333, '312313', '' ),
		( 20, '2', '5', 3, '4', '6' ),
		( 21, NULL, '/upload/1562160132632.txt', 0, NULL, NULL ),
		( 22, '李四', 'lisi@2.com ,123456', 33, '18820285401', '1212' ),
		( 23, '44', '22', 11, '33', '222222' ),
		( 24, '31231313', '31231', 231333, '312313', '2222222' ),
		( 25, '21', '3', 2, '2', NULL ),
		( 26, '1', '2', 2, '3', NULL ),
		( 27, NULL, '/upload/1561821284810.txt', 0, NULL, NULL ),
		( 28, '李四', 'lisi@2.com', 33, '18820285401', NULL );
UNLOCK TABLES;
COMMIT;