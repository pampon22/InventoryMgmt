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
  `capacity` int unsigned DEFAULT NULL,
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
  `size` int unsigned NOT NULL,
  `gender` enum('male','female','unisex') NOT NULL,
  `FK_shoe_location_id` int unsigned NOT NULL,
  `color` varchar(45) NOT NULL,
  `FK_shoe_brand_id` int unsigned NOT NULL,
  PRIMARY KEY (`shoe_id`),
  KEY `location_id_idx` (`FK_shoe_location_id`),
  KEY `brand_id_idx` (`FK_shoe_brand_id`,`FK_shoe_location_id`),
  CONSTRAINT `FK_shoe_brand_id` FOREIGN KEY (`FK_shoe_brand_id`) REFERENCES `brand` (`brand_id`),
  CONSTRAINT `FK_shoe_location_id` FOREIGN KEY (`FK_shoe_location_id`) REFERENCES `warehouse` (`warehouse_id`)
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
INSERT INTO `warehouse` (`state`) VALUES ('CA');
INSERT INTO `warehouse` (`state`) VALUES ('NV');
INSERT INTO `warehouse` (`state`) VALUES ('OH');
INSERT INTO `warehouse` (`state`) VALUES ('MA');

SELECT * FROM warehouse;