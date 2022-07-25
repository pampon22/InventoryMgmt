/*******************************************************************************
   Handley Database - Version 1.0
   Script: Handley_db.sql
   Description: Creates the Handley database for our inventory management app.
   DB Server: MySql
   Author: Philip Ampong
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP DATABASE IF EXISTS `Handley`;

/*******************************************************************************
   Create database
********************************************************************************/
CREATE DATABASE `Handley`;

USE `Handley`;

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE `warehouse` (
  `warehouse_id` int unsigned NOT NULL AUTO_INCREMENT,
  `state` char(2) NOT NULL,
  `capacity` int unsigned DEFAULT 0,
  PRIMARY KEY (`warehouse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `brand` (
  `brand_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `shoe` (
  `shoe_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `fk_location_id` int unsigned DEFAULT 0,
  `color` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `quantity` int unsigned DEFAULT 0 NOT NULL,
  PRIMARY KEY (`shoe_id`),
  KEY `location_id_idx` (`fk_location_id`),
  CONSTRAINT `fk_location_id` FOREIGN KEY (`fk_location_id`) REFERENCES `warehouse` (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `postal_code` (
  `postal_code` int unsigned NOT NULL,
  `state` char(2) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`postal_code`),
  UNIQUE KEY `postal_code_UNIQUE` (`postal_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*******************************************************************************
	End of Table creations
********************************************************************************/



/**********
	Population with data
***********/
INSERT INTO `warehouse` (`state`, `capacity`) VALUES ('CA', 2);
INSERT INTO `warehouse` (`state`, `capacity`) VALUES ('NV', 40);
INSERT INTO `warehouse` (`state`) VALUES ('OH');
INSERT INTO `warehouse` (`state`) VALUES ('MA');

SELECT * FROM warehouse;

INSERT INTO `brand` (`name`) VALUES ('Nike');

INSERT INTO `shoe` (`name`, `fk_location_id`, `brand`, `color`, `quantity`) VALUES ('Lebron soldier',		11,	'Nike',			'red', 10); 
INSERT INTO `shoe` (`name`, `fk_location_id`, `brand`, `color`, `quantity`) VALUES ('Air force 1',		 11,	'Nike', 		'white', 15);
INSERT INTO `shoe` (`name`, `fk_location_id`, `brand`, `color`, `quantity`) VALUES ('Under Armour Curry 6',	12,	'UnderArmor',	'off-white', 2);
INSERT INTO `shoe` (`name`, `brand`, `color`, `fk_location_id`) VALUES ("Disco Goldfish Platforms", "The Internet", "multi-color", 11);
INSERT INTO `shoe` (`name`, `brand`, `color`, `fk_location_id`) VALUES ("The Sandwich Flip Flops", "McDonalds", "brown", 11);

INSERT INTO `shoe` (`name`, `brand`, `color`, `fk_location_id`) VALUES ("Vans 147", "Vans", "White", 11);
INSERT INTO `shoe` (`name`, `fk_location_id`, `brand`, `color`, `quantity`) VALUES ('Reebok Kamikaze',	12,	'Reebok', 'blue+black', 2);
INSERT INTO `shoe` (`name`, `fk_location_id`, `brand`, `color`, `quantity`) VALUES ('Converse Anarchy',	13,	'Converse', 'grey', 4);
INSERT INTO `shoe` (`name`, `fk_location_id`, `brand`, `color`, `quantity`) VALUES ('Reebok Allstar',	12,	'Reebok', 'purple', 2);
INSERT INTO `shoe` (`name`, `fk_location_id`, `brand`, `color`, `quantity`) VALUES ('KD 5',	12,	'Nike',	'green', 2);
INSERT INTO `shoe` (`name`, `fk_location_id`, `brand`, `color`, `quantity`) VALUES ('Jordan 1s', 12, 'Air Jordan', 'Black', 2);

SELECT * FROM shoe;
DESCRIBE shoe;