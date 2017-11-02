-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema ecafe
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ecafe` ;

-- -----------------------------------------------------
-- Schema ecafe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecafe` DEFAULT CHARACTER SET latin1 ;
SHOW WARNINGS;
USE `ecafe` ;

-- -----------------------------------------------------
-- Table `ecafe`.`items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecafe`.`items` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `ecafe`.`items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `time_req` INT NULL,
  `item_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `ecafe`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecafe`.`orders` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `ecafe`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `delivery_details` VARCHAR(45) NULL,
  `curr_time` VARCHAR(45) NOT NULL,
  `delivery_time` VARCHAR(45) NULL,
  `address` VARCHAR(100) NULL,
  `bill_price` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `ecafe`.`order_dertails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecafe`.`order_dertails` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `ecafe`.`order_dertails` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `items_id` INT NOT NULL,
  `orders_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_dertails_items_idx` (`items_id` ASC),
  INDEX `fk_order_dertails_orders1_idx` (`orders_id` ASC),
  CONSTRAINT `fk_order_dertails_items`
    FOREIGN KEY (`items_id`)
    REFERENCES `ecafe`.`items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_dertails_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `ecafe`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `ecafe`.`logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecafe`.`logs` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `ecafe`.`logs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_des` VARCHAR(45) NULL,
  `time` VARCHAR(45) NULL,
  `affected_table` VARCHAR(45) NULL,
  `affected_row` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*
-- Query: SELECT * FROM ecafe.items
LIMIT 0, 1000

-- Date: 2017-11-02 11:00
*/
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (1,'Butter Bread',30,5,'Appetizer');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (2,'Ginger Bread',40,5,'Appetizer');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (3,'Cheese Bread',50,5,'Appetizer');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (4,'Sweet Bread',60,5,'Appetizer');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (5,'Chicken Soup',180,5,'Soup');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (6,'Corn Soup',140,5,'Soup');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (7,'Zinger Burger',280,10,'Main Dish');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (8,'Fish Burger',390,10,'Main Dish');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (9,'Plain Burger',220,10,'Main Dish');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (10,'Spicy Burger',210,10,'Main Dish');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (11,'Cheese Burger',250,10,'Main Dish');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (12,'Tikka Burger',270,10,'Main Dish');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (13,'Hot Wing',40,7,'Side Dish');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (14,'Shashlick',200,7,'Side Dish');
INSERT INTO `items` (`id`,`name`,`price`,`time_req`,`item_type`) VALUES (15,'Club Sandwich',170,7,'Side Dish');
