CREATE TABLE `persons` (
	`person_id` INT UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `salary` DECIMAL(10, 2) NOT NULL DEFAULT 0,
    `passport_id` INT UNSIGNED NOT NULL UNIQUE
);

CREATE TABLE `passports` (
	`passport_id` INT UNSIGNED UNIQUE AUTO_INCREMENT PRIMARY KEY,
    `passport_number` VARCHAR(8) NOT NULL UNIQUE
) AUTO_INCREMENT=101;

INSERT 
	INTO `persons` (`first_name`, `salary`, `passport_id`) 
	VALUES 
		('Roberto', 43300, 102), 
		('Tom', 56100, 103), 
		('Yana', 60200, 101);

INSERT 
	INTO `passports` (`passport_number`) 
    VALUES ('N34FG21B'), ('K65LO4R7'), ('ZE657QP2');

ALTER TABLE `persons` 
	ADD CONSTRAINT `pk_persons` 
		PRIMARY KEY (`person_id`),
    ADD CONSTRAINT `fk_persons_passports` 
		FOREIGN KEY(`passport_id`) 
        REFERENCES `passports`(`passport_id`);

	CREATE TABLE `manufacturers`
(
  `manufacturer_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(40),
  `established_on` DATE 
);

CREATE TABLE `models` (
    `model_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    `manufacturer_id` INT,
    CONSTRAINT `fk_manufacturer_id` FOREIGN KEY (`manufacturer_id`)
        REFERENCES `manufacturers` (`manufacturer_id`)
);

INSERT INTO `manufacturers`(`manufacturer_id`, `name`, `established_on`)
VALUES(1, 'BMW', '1916-03-01'),
      (2, 'Tesla', '2003-01-01'),
      (3, 'Lada', '1966-05-01');
      
INSERT INTO `models`(`model_id`, `name`, `manufacturer_id`)
VALUES(101, 'X1', 1),
      (102, 'i6', 1),
      (103, 'Model S', 2),
      (104, 'Model X', 2),
      (105, 'Model 3', 2),
      (106, 'Nova', 3);
      
CREATE TABLE `students`(
  `student_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(40)
  );
  
  CREATE TABLE `exams`(
    `exam_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50)
    );
    
    CREATE TABLE `students_exams` (
    `student_id` INT,
    `exam_id` INT,
    CONSTRAINT `pk_student_exams` PRIMARY KEY (`student_id` , `exam_id`),
    CONSTRAINT `fk_student_exams_students` FOREIGN KEY (`student_id`)
        REFERENCES `students` (`student_id`),
    CONSTRAINT `fk_student_exams_exams` FOREIGN KEY (`exam_id`)
        REFERENCES `exams` (`exam_id`)
);

INSERT INTO `students`(`student_id`, `name`)
VALUES(1, 'Mila'),
      (2, 'Toni'),
      (3, 'Ron');
      
INSERT INTO `exams`(`exam_id`, `name`)
VALUES(101, 'Spring MVC'),
      (102, 'Neo4j'),
      (103, 'Oracle 11g');
      
INSERT INTO `students_exams`(`student_id`, `exam_id`)
VALUES(1, 101),
      (1, 102),
      (2, 101),
      (3, 103),
      (2, 102),
      (2, 103);
      
CREATE TABLE `teachers` (
    `teacher_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20),
    `manager_id` INT
);

INSERT INTO `teachers`(`teacher_id`, `name`, `manager_id`)
VALUES(101, 'John', NULL),
      (102, 'Maya', 106),
      (103, 'Silvia', 106),
      (104, 'Ted', 105),
      (105, 'Mark', 101),
      (106, 'Greta', 101);
      
ALTER TABLE `teachers`
ADD CONSTRAINT `fk_teachers_managers_id` 
FOREIGN KEY(`manager_id`) 
REFERENCES `teachers`(`teacher_id`);

CREATE TABLE `item_types`(
  `item_type_id` INT(11) PRIMARY KEY,
  `name` VARCHAR(50)
);

CREATE TABLE `items` (
    `item_id` INT(11) PRIMARY KEY,
    `name` VARCHAR(50),
    `item_type_id` INT(11),
    CONSTRAINT `fk_item_type_id_item_types` FOREIGN KEY (`item_type_id`)
        REFERENCES `item_types` (`item_type_id`)
);

CREATE TABLE `cities`(
  `city_id` INT(11) PRIMARY KEY,
  `name` VARCHAR(50)
);

CREATE TABLE `customers` (
    `customer_id` INT(11) PRIMARY KEY,
    `name` VARCHAR(50),
    `birthday` DATE,
    `city_id` INT(11),
    CONSTRAINT `fk_city_id_cities` FOREIGN KEY (`city_id`)
        REFERENCES `cities` (`city_id`)
);

CREATE TABLE `orders` (
    `order_id` INT(11) PRIMARY KEY,
    `customer_id` INT(11),
    CONSTRAINT `fk_customer_id_customers` FOREIGN KEY (`customer_id`)
        REFERENCES `customers` (`customer_id`)
);

CREATE TABLE `order_items` (
    `order_id` INT(11),
    `item_id` INT(11),
    CONSTRAINT `pk_order_items` PRIMARY KEY (`order_id` , `item_id`),
    CONSTRAINT `fk_order_items_items` FOREIGN KEY (`item_id`)
        REFERENCES `items` (`item_id`),
    CONSTRAINT `fk_order_items_orders` FOREIGN KEY (`order_id`)
        REFERENCES `orders` (`order_id`)
);

CREATE TABLE `majors`(
  `major_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50)
);

CREATE TABLE `students` (
    `student_id` INT(11) PRIMARY KEY,
    `student_number` VARCHAR(12),
    `student_name` VARCHAR(50),
    `major_id` INT(11),
    CONSTRAINT `fk_major_id_majors` FOREIGN KEY (`major_id`)
        REFERENCES `majors` (`major_id`)
);

CREATE TABLE `payments` (
    `payment_id` INT(11) PRIMARY KEY,
    `payment_date` DATE,
    `payment_amount` DECIMAL(8 , 2 ),
    `student_id` INT(11),
    CONSTRAINT `fk_student_id_students` FOREIGN KEY (`student_id`)
        REFERENCES `students` (`student_id`)
);

CREATE TABLE `subjects`(
  `subject_id` INT(11) PRIMARY KEY,
  `subject_name` VARCHAR(50)
);

CREATE TABLE `agenda` (
    `student_id` INT(11),
    `subject_id` INT(11),
    CONSTRAINT `pk_agenda` PRIMARY KEY (`student_id` , `subject_id`),
    CONSTRAINT `fk_agenda_student_id` FOREIGN KEY (`student_id`)
        REFERENCES `students` (`student_id`),
    CONSTRAINT `fk_agenda_subject_id` FOREIGN KEY (`subject_id`)
        REFERENCES `subjects` (`subject_id`)
);

SELECT 
    m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM
    `peaks` AS p
        JOIN
    `mountains` AS m ON m.`id` = p.`mountain_id`
WHERE
    m.`mountain_range` = 'Rila'
ORDER BY p.`elevation` DESC; 