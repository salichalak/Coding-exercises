CREATE TABLE `people`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB ,
    `height` DOUBLE(10,2),
    `weight` DOUBLE(10,2),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);

INSERT INTO `people` (`name`, `gender`, `birthdate`)
VALUES 
('Test', 'M', DATE(NOW())),
('Test', 'M', DATE(NOW())),
('Test', 'M', DATE(NOW())),
('Test', 'M', DATE(NOW())),
('Test', 'M', DATE(NOW()));

CREATE TABLE `users` (
	`id` INT AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` TIME,
    `is_deleted` BOOLEAN, 
	CONSTRAINT pk_users 
    PRIMARY KEY `users`(`id`)
);

INSERT INTO `users` (`username`, `password`)
VALUES 
('Test1', 'Pass'),
('Test2', 'Pass'),
('Test3', 'Pass'),
('Test4', 'Pass'),
('Test5', 'Pass');

ALTER TABLE `users` 
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY (`id`, `username`);

ALTER TABLE `users`
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME DEFAULT NOW();

ALTER TABLE `users`
DROP PRIMARY KEY, 
ADD CONSTRAINT pk_users 
PRIMARY KEY `users`(`id`), 
CHANGE COLUMN `username` `username` VARCHAR(50) UNIQUE;