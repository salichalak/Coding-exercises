CREATE TABLE `users` (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
gender CHAR NOT NULL,
age INT NOT NULL,
job_title VARCHAR(40) NOT NULL,
ip VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses` (
id INT AUTO_INCREMENT PRIMARY KEY,
address VARCHAR(30) NOT NULL,
town VARCHAR(30) NOT NULL,
country VARCHAR(30) NOT NULL,
user_id INT NOT NULL,
CONSTRAINT fk_addresses_users
FOREIGN KEY (user_id)
REFERENCES users(id)
);

CREATE TABLE `photos` (
id INT AUTO_INCREMENT PRIMARY KEY,
`description` TEXT NOT NULL,
`date` DATETIME NOT NULL,
views INT NOT NULL DEFAULT 0
);

CREATE TABLE `comments` (
id INT AUTO_INCREMENT PRIMARY KEY,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
photo_id INT NOT NULL,
CONSTRAINT fk_comments_photos
FOREIGN KEY (photo_id)
REFERENCES photos(id)
);

CREATE TABLE `users_photos` (
user_id INT NOT NULL,
photo_id INT NOT NULL,
CONSTRAINT fk_users_photos
FOREIGN KEY (user_id)
REFERENCES users(id),
CONSTRAINT fk_photos_users
FOREIGN KEY (photo_id)
REFERENCES photos(id)
);

CREATE TABLE `likes` (
id INT AUTO_INCREMENT PRIMARY KEY,
photo_id INT,
CONSTRAINT fk_likes_photos
FOREIGN KEY (photo_id)
REFERENCES photos(id),
user_id INT,
CONSTRAINT fk_likes_users
FOREIGN KEY (user_id)
REFERENCES users(id)
);