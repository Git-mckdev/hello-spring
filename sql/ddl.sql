CREATE DATABASE `hello-spring` CHARACTER SET utf8mb4;

USE `hello-spring`;

CREATE TABLE `member` (  
    `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    `name` VARCHAR(255) NOT NULL COMMENT '회원 이름'
) COMMENT '회원 테이블';
