-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema caterDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `caterDB` ;

-- -----------------------------------------------------
-- Schema caterDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `caterDB` DEFAULT CHARACTER SET utf8 ;
USE `caterDB` ;

-- -----------------------------------------------------
-- Table `user_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_roles` ;

CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(30) BINARY NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `type` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_user_user_roles2_idx` (`type` ASC),
  CONSTRAINT `fk_user_user_roles2`
    FOREIGN KEY (`type`)
    REFERENCES `user_roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `menu` ;

CREATE TABLE IF NOT EXISTS `menu` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(80) NOT NULL,
  `street2` VARCHAR(80) NULL,
  `city` VARCHAR(60) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zip` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `images` ;

CREATE TABLE IF NOT EXISTS `images` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `image_url` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company` ;

CREATE TABLE IF NOT EXISTS `company` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `menu_id` INT UNSIGNED NOT NULL,
  `company_address` INT UNSIGNED NULL,
  `company_image` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_company_menu1_idx` (`menu_id` ASC),
  INDEX `fk_company_address_idx` (`company_address` ASC),
  INDEX `fk_company_image_idx` (`company_image` ASC),
  CONSTRAINT `fk_company_menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_address`
    FOREIGN KEY (`company_address`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_image`
    FOREIGN KEY (`company_image`)
    REFERENCES `images` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employees` ;

CREATE TABLE IF NOT EXISTS `employees` (
  `employee_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `company_id` INT UNSIGNED NOT NULL,
  `active` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `employee_id_UNIQUE` (`employee_id` ASC),
  INDEX `fk_employees_company1_idx` (`company_id` ASC),
  CONSTRAINT `fk_employees_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item` ;

CREATE TABLE IF NOT EXISTS `item` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `calories` INT NULL,
  `synopsis` VARCHAR(1000) NULL,
  `price` DECIMAL(10,2) UNSIGNED NOT NULL,
  `availablity` INT UNSIGNED NOT NULL,
  `menu_id` INT UNSIGNED NOT NULL,
  `item_image` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_item_menu1_idx` (`menu_id` ASC),
  INDEX `fk_item_images_idx` (`item_image` ASC),
  CONSTRAINT `fk_item_menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_images`
    FOREIGN KEY (`item_image`)
    REFERENCES `images` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orders` ;

CREATE TABLE IF NOT EXISTS `orders` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `total` INT UNSIGNED NOT NULL,
  `customer_id` INT UNSIGNED NOT NULL,
  `delivery_date_time` DATETIME NULL,
  `delivery_address` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_orders_address_idx` (`delivery_address` ASC),
  CONSTRAINT `fk_orders_address`
    FOREIGN KEY (`delivery_address`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart` ;

CREATE TABLE IF NOT EXISTS `cart` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `cart_id` INT UNSIGNED NOT NULL,
  `billing_address` INT UNSIGNED NULL,
  `customer_image` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_customer_cart1_idx` (`cart_id` ASC),
  UNIQUE INDEX `cart_id1_UNIQUE` (`cart_id` ASC),
  INDEX `fk_customer_address_idx` (`billing_address` ASC),
  INDEX `fk_customer_images_idx` (`customer_image` ASC),
  CONSTRAINT `fk_customer_cart1`
    FOREIGN KEY (`cart_id`)
    REFERENCES `cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_address`
    FOREIGN KEY (`billing_address`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_images`
    FOREIGN KEY (`customer_image`)
    REFERENCES `images` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_has_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_has_category` ;

CREATE TABLE IF NOT EXISTS `item_has_category` (
  `item_id` INT UNSIGNED NOT NULL,
  `category_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`item_id`, `category_id`),
  INDEX `fk_item_has_category_category1_idx` (`category_id` ASC),
  INDEX `fk_item_has_category_item1_idx` (`item_id` ASC),
  CONSTRAINT `fk_item_has_category_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `order_has_items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_has_items` ;

CREATE TABLE IF NOT EXISTS `order_has_items` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `item_id` INT UNSIGNED NOT NULL,
  `orders_id` INT UNSIGNED NOT NULL,
  `count` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_has_orders_orders1_idx` (`orders_id` ASC),
  INDEX `fk_item_has_orders_item1_idx` (`item_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_item_has_orders_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_orders_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cart_has_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart_has_item` ;

CREATE TABLE IF NOT EXISTS `cart_has_item` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `cart_id` INT UNSIGNED NOT NULL,
  `item_id` INT UNSIGNED NOT NULL,
  `count` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cart_has_item_item1_idx` (`item_id` ASC),
  INDEX `fk_cart_has_item_cart1_idx` (`cart_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_cart_has_item_cart1`
    FOREIGN KEY (`cart_id`)
    REFERENCES `cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_has_item_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO cater;
 DROP USER cater;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'cater' IDENTIFIED BY 'cater';

GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'cater';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'cater';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user_roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `user_roles` (`id`, `type`) VALUES (1, 'Customer');
INSERT INTO `user_roles` (`id`, `type`) VALUES (2, 'Employee');
INSERT INTO `user_roles` (`id`, `type`) VALUES (3, 'Admin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (1, 'James', 'Gato', 'jGato', 'password1', 'jgato@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (2, 'William', 'Johnson', 'bigWill', 'password2', 'william.johnson@illegalpetes.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (3, 'Harriet', 'Foster', 'foster', 'password3', 'foHarriet@yahoo.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (4, 'Teri', 'Crootons', 'OutHereCrooton', 'password4', 'crooton@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (5, 'Payne', 'Roehr', 'proehr', 'password5', 'payne.roehr@lilrics.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (6, 'Lynne', 'Robey', 'robes23', 'password6', 'lrobey@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (7, 'Greg', 'Gato', 'gGato', 'password7', 'doubleG@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (8, 'Ollie', 'Gross', 'OGross', 'password8', 'theOG@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (9, 'Christine', 'California', 'CC1456', 'password9', 'himynameischristine@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (10, 'Mark', 'Wilson', 'markWilson', 'password10', 'markiemarkandtheBBQbunch@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (11, 'Tyler', 'Towns', 'tyto', 'password11', 'tyto@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (12, 'Jim', 'Harrison', 'jharrison', 'password12', 'jharrison@gmail.com', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (13, 'Sara', 'McMully', 'lilMac', 'password13', 'lilmac@gmail.com', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (14, 'Harry', 'Loche', 'lochesonloches', 'password14', 'locheness@gmail.com', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (15, 'Derek', 'Vann', 'dVann', 'password15', 'dvan@kc.rr.com', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (16, 'Steve', 'Cappe', 'Cappe23', 'password16', 'scappes@gmail.com', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (17, 'Melanie', 'McArthur', 'mel86', 'password17', 'mandm@gmail.com', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (18, 'Lucy', 'Harrison', 'lharrison', 'password18', 'lharrison@gmail.com', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (19, 'Jim', 'Harrison', 'jharrison2', 'password19', 'jharrison@gmail.com', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `type`) VALUES (20, 'Erik', 'Ernst', 'eernst', 'password20', 'erikrobeyernst@gmail.com', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `menu`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `menu` (`id`) VALUES (1);
INSERT INTO `menu` (`id`) VALUES (2);
INSERT INTO `menu` (`id`) VALUES (3);
INSERT INTO `menu` (`id`) VALUES (4);
INSERT INTO `menu` (`id`) VALUES (5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (1, '5312 DTC Blvd', 'Suite #400', 'Denver', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (2, '5322 DTC Blvd', 'Suite #400', 'Denver', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (3, '5322 DTC Blvd', '', 'Greenwood Village', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (4, '9069 E Arapahoe Rd', '', 'Greenwood Village', 'CO', 80112);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (5, '5332 DTC Blvd', '', 'Denver', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (6, '5884 S Hanover Way', '', 'Greenwood Village', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (7, '5695 S Galena St.', '', 'Greenwood Village', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (8, '6172 S Kearney St', '', 'Centennial', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (9, '6110 S Ivanhoe St', '', 'Centennial', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (10, '6093 S Fairfax', '', 'Centennial', 'CO', 80121);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (11, '5505 S Krameria St', '', 'Greenwood Village', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (12, '6616 E Prentice Ave', '', 'Greenwood', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (13, '13 Redfox Ln', '', 'Greenwood', 'CO', 80111);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (14, '6100 Plateau Dr', '', 'Englewood', 'CO', 80111);

COMMIT;


-- -----------------------------------------------------
-- Data for table `images`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `images` (`id`, `image_url`) VALUES (1, 'http://illegalpetes.com/wp-content/uploads/2015/06/logo-home.png');
INSERT INTO `images` (`id`, `image_url`) VALUES (2, 'http://www.lilriccisdtc.com/wp-content/uploads/2015/04/HiRes_transparentLogo.png');
INSERT INTO `images` (`id`, `image_url`) VALUES (3, 'https://media-cdn.tripadvisor.com/media/photo-s/02/c1/13/50/cuba-cuba-sandwicheria.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (4, 'https://s3-media2.fl.yelpcdn.com/bphoto/WqzutWk4LD9-LK3ZxXcsHQ/ls.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (5, 'https://burntendbbqkc.com/images/burnt-end-logo.png');
INSERT INTO `images` (`id`, `image_url`) VALUES (6, 'https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjv98bDw83WAhXHxVQKHRv_CyAQjRwIBw&url=http%3A%2F%2Ffreeuse.io%2Fphoto%2F5357-person-woman-girl-face&psig=AOvVaw3-BHvOXo2OCv1sgB7zz91K&ust=1506882064337154');
INSERT INTO `images` (`id`, `image_url`) VALUES (7, 'https://cdn.pixabay.com/photo/2015/05/25/18/59/person-783780_960_720.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (8, 'https://i.pinimg.com/564x/d9/b4/17/d9b41712060e336cc6fd5c54bf1560af--face-wrinkles-old-age.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (9, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRN1M70MnDwf6ykLF2rsJ6YLRlcFm2aNPjY1Yn7vPPUrqxdW4tzg');
INSERT INTO `images` (`id`, `image_url`) VALUES (10, 'https://static.pexels.com/photos/355164/pexels-photo-355164.jpeghttps://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfOoqH1wgA5Wl7Qp2Cl4Y5hiIYJBL1x7-dbmB8fNtBdNYBolc6');
INSERT INTO `images` (`id`, `image_url`) VALUES (11, 'https://static.pexels.com/photos/355164/pexels-photo-355164.jpeg');
INSERT INTO `images` (`id`, `image_url`) VALUES (12, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSt4mij18MtkxBFkySNlVKmIGFo9yErzRogPEmlCisa90xFT2dfcA');
INSERT INTO `images` (`id`, `image_url`) VALUES (13, 'http://www.howsweeteats.com/wp-content/uploads/2015/04/chicken-tacos-I-howsweeteats.com-5.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (14, 'http://hispanickitchen.com/wp-content/uploads/2017/01/classic-ground-beef-hardshell-tacos-3-2.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (15, 'https://lh4.googleusercontent.com/-mg0wpgjdOck/U3Bw1L2De6I/AAAAAAAEh3w/xBrm02pDroA/s800/beer-battered-fish-tacos-26.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (16, 'http://images.media-allrecipes.com/userphotos/960x960/3757728.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (17, 'https://www.savorynothings.com/wp-content/uploads/2016/04/loaded-vegetarian-nachos-recipe-2.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (18, 'http://www.ourbestbites.com/wp-content/uploads/2014/07/Our-Best-Bites-Chicken-Taquitos.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (19, 'http://newyork.seriouseats.com/images/20110419-sandwiches-coppelia-pork.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (20, 'http://hispanickitchen.com/wp-content/uploads/2016/09/4861-polloalaplancha2A.jpg');
INSERT INTO `images` (`id`, `image_url`) VALUES (21, 'https://images.eatthismuch.com/site_media/img/57157_erin_m_9a5fff83-b1a0-4d3d-a0c6-f07a336ac936.png');
INSERT INTO `images` (`id`, `image_url`) VALUES (22, 'https://cms.splendidtable.org/sites/default/files/styles/900x500/public/french-fries.jpg?itok=2wcnbFAY');
INSERT INTO `images` (`id`, `image_url`) VALUES (23, 'https://www.cscassets.com/recipes/large_cknew/large_61250.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `company`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `company` (`id`, `name`, `menu_id`, `company_address`, `company_image`) VALUES (1, 'Illegal Pete\'s', 1, 1, 1);
INSERT INTO `company` (`id`, `name`, `menu_id`, `company_address`, `company_image`) VALUES (2, 'Lil Ricci\'s', 2, 2, 2);
INSERT INTO `company` (`id`, `name`, `menu_id`, `company_address`, `company_image`) VALUES (3, 'Cuba Cuba Sandwicheria', 3, 3, 3);
INSERT INTO `company` (`id`, `name`, `menu_id`, `company_address`, `company_image`) VALUES (4, 'Brothers BBQ Greenwood Village', 4, 4, 4);
INSERT INTO `company` (`id`, `name`, `menu_id`, `company_address`, `company_image`) VALUES (5, 'Burnt End BBQ', 5, 5, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `employees`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (1, 1, 1, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (2, 2, 1, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (3, 3, 1, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (4, 4, 2, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (5, 5, 2, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (6, 6, 3, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (7, 7, 4, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (8, 8, 4, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (9, 9, 4, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (10, 10, 4, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (11, 11, 5, DEFAULT);
INSERT INTO `employees` (`employee_id`, `user_id`, `company_id`, `active`) VALUES (12, 12, 5, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (1, 'Grilled Chicken Tacos', 500, 'Just your basic chicken tacos', 7.29, 1000, 1, 13);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (2, 'Shredded Beef Tacos', 500, 'Just your basic beef tacos', 7.79, 1000, 1, 14);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (3, 'Beer-Battered Fish Tacos', 500, 'Just your basic fish tacos', 7.49, 1000, 1, 15);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (4, 'Grilled Steak Burrito', 500, 'Just your basic steak burrito', 7.79, 1000, 1, 16);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (5, 'Vegetarian Nachos', 500, 'Just your vegetarian tacos', 6.79, 1000, 1, 17);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (6, 'Chicken Taquitos', 500, '4 chicken taquitos', 5.99, 1000, 1, 18);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (7, 'Antipasta', 500, 'Mixed greens and the veggies with ham salami black olives and provolone cheese', 5.00, 1000, 2, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (8, 'Caesar Salad', 500, 'Crisp romaine tossed with our famous Caesar dress croutons and parmesan', 3.00, 1000, 2, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (9, 'New York Style Thin Crust Cheese', 500, '12\" 6 slices cheese', 12.00, 1000, 2, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (10, 'Baked Ravioli', 500, 'Red sauce and baked with mozarella with meat', 12.00, 1000, 2, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (11, 'Pan Con Lechon', 500, 'Slow-roasted pork sauteed onions veggie-citrus slaw and mojo aioli on toasted cuban bread', 9.50, 1000, 3, 19);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (12, 'Cubano', 500, 'Roasted pork ham swiss pickles and mustard on pressed cuban bread', 9.50, 1000, 3, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (13, 'Pollo A La Plancha', 500, 'All-natural grilled chicken breast sauteed onions and garlic mojo', 9.50, 1000, 3, 20);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (14, 'De La Casa', 500, 'Avocado cucumbers carrots tomatoes served over mixed greens with chili vinaigrette', 4.00, 1000, 3, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (15, 'Tres Leches Cake', 500, 'Three-milk sponge cake with whipped cream', 3.25, 1000, 3, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (16, 'Pulled Pork Sandwich Special', 500, 'Just your basic pulled pork', 11.49, 1000, 4, 21);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (17, 'Rib Special', 500, '4 pork ribs', 12.99, 1000, 4, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (18, 'Side of Fries', 500, 'Quarter inch cut skin cooked fresh to order', 2.49, 1000, 4, 22);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (19, 'Brisket', 500, 'You haven\'t had our brisket yet ?!?!?', 6.99, 1000, 5, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (20, 'Burnt End', 500, 'You\'re telling me you don\'t know what burnt ends are?', 8.79, 1000, 5, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (21, 'Burnt End Bowl', 500, 'Our signature burnt ends with hickory pit beans and sweet cornbread topped with crispy onion straws', 6.99, 1000, 5, NULL);
INSERT INTO `item` (`id`, `name`, `calories`, `synopsis`, `price`, `availablity`, `menu_id`, `item_image`) VALUES (22, 'The PK', 500, 'Pulled pork topped with melted smoked provolone cheese barbecue sauce and 2 house made onion rings served on a brioche bun', 9.49, 1000, 5, 23);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `category` (`id`, `category`) VALUES (1, 'BBQ');
INSERT INTO `category` (`id`, `category`) VALUES (2, 'Mexican');
INSERT INTO `category` (`id`, `category`) VALUES (3, 'Italian');
INSERT INTO `category` (`id`, `category`) VALUES (4, 'Sandwich');
INSERT INTO `category` (`id`, `category`) VALUES (5, 'Side');
INSERT INTO `category` (`id`, `category`) VALUES (6, 'Fish');
INSERT INTO `category` (`id`, `category`) VALUES (7, 'Vegetarian');
INSERT INTO `category` (`id`, `category`) VALUES (8, 'Salad');
INSERT INTO `category` (`id`, `category`) VALUES (9, 'Dessert');

COMMIT;


-- -----------------------------------------------------
-- Data for table `orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `orders` (`id`, `total`, `customer_id`, `delivery_date_time`, `delivery_address`) VALUES (1, 72.67, 2, '2017-9-26 11:58:00', 7);
INSERT INTO `orders` (`id`, `total`, `customer_id`, `delivery_date_time`, `delivery_address`) VALUES (2, 53.00, 4, '2017-9-27 11:17:00', 9);
INSERT INTO `orders` (`id`, `total`, `customer_id`, `delivery_date_time`, `delivery_address`) VALUES (3, 66.22, 2, '2017-9-27 13:45:00', 7);
INSERT INTO `orders` (`id`, `total`, `customer_id`, `delivery_date_time`, `delivery_address`) VALUES (4, 159.58, 1, '2017-9-28 12:05:00', 13);
INSERT INTO `orders` (`id`, `total`, `customer_id`, `delivery_date_time`, `delivery_address`) VALUES (5, 44.29, 2, '2017-9-29 11:00:00', 14);
INSERT INTO `orders` (`id`, `total`, `customer_id`, `delivery_date_time`, `delivery_address`) VALUES (6, 44.29, 3, '2017-9-29 11:53:00', 8);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cart`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `cart` (`id`) VALUES (1);
INSERT INTO `cart` (`id`) VALUES (2);
INSERT INTO `cart` (`id`) VALUES (3);
INSERT INTO `cart` (`id`) VALUES (4);
INSERT INTO `cart` (`id`) VALUES (5);
INSERT INTO `cart` (`id`) VALUES (6);
INSERT INTO `cart` (`id`) VALUES (7);

COMMIT;


-- -----------------------------------------------------
-- Data for table `customer`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `customer` (`id`, `user_id`, `cart_id`, `billing_address`, `customer_image`) VALUES (1, 13, 1, 6, 6);
INSERT INTO `customer` (`id`, `user_id`, `cart_id`, `billing_address`, `customer_image`) VALUES (2, 14, 2, 7, 7);
INSERT INTO `customer` (`id`, `user_id`, `cart_id`, `billing_address`, `customer_image`) VALUES (3, 15, 3, 8, 8);
INSERT INTO `customer` (`id`, `user_id`, `cart_id`, `billing_address`, `customer_image`) VALUES (4, 16, 4, 9, 9);
INSERT INTO `customer` (`id`, `user_id`, `cart_id`, `billing_address`, `customer_image`) VALUES (5, 17, 5, 10, 10);
INSERT INTO `customer` (`id`, `user_id`, `cart_id`, `billing_address`, `customer_image`) VALUES (6, 18, 6, 11, 11);
INSERT INTO `customer` (`id`, `user_id`, `cart_id`, `billing_address`, `customer_image`) VALUES (7, 19, 7, 12, 12);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item_has_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (1, 2);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (2, 2);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (3, 2);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (3, 6);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (4, 2);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (5, 2);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (5, 7);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (6, 2);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (7, 3);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (8, 5);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (8, 8);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (9, 3);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (10, 3);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (11, 4);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (12, 4);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (13, 2);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (13, 4);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (14, 5);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (15, 9);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (16, 1);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (16, 4);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (17, 1);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (18, 1);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (18, 5);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (19, 1);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (19, 4);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (20, 1);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (20, 4);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (21, 1);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (22, 1);
INSERT INTO `item_has_category` (`item_id`, `category_id`) VALUES (22, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `order_has_items`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `order_has_items` (`id`, `item_id`, `orders_id`, `count`) VALUES (1, 3, 1, 5);
INSERT INTO `order_has_items` (`id`, `item_id`, `orders_id`, `count`) VALUES (2, 4, 1, 8);
INSERT INTO `order_has_items` (`id`, `item_id`, `orders_id`, `count`) VALUES (3, 1, 2, 18);
INSERT INTO `order_has_items` (`id`, `item_id`, `orders_id`, `count`) VALUES (4, 1, 3, 14);
INSERT INTO `order_has_items` (`id`, `item_id`, `orders_id`, `count`) VALUES (5, 8, 4, 32);
INSERT INTO `order_has_items` (`id`, `item_id`, `orders_id`, `count`) VALUES (6, 2, 4, 5);
INSERT INTO `order_has_items` (`id`, `item_id`, `orders_id`, `count`) VALUES (7, 3, 5, 5);
INSERT INTO `order_has_items` (`id`, `item_id`, `orders_id`, `count`) VALUES (8, 3, 6, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cart_has_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `caterDB`;
INSERT INTO `cart_has_item` (`id`, `cart_id`, `item_id`, `count`) VALUES (1, 1, 1, 1);
INSERT INTO `cart_has_item` (`id`, `cart_id`, `item_id`, `count`) VALUES (2, 1, 4, 3);
INSERT INTO `cart_has_item` (`id`, `cart_id`, `item_id`, `count`) VALUES (3, 1, 7, 2);
INSERT INTO `cart_has_item` (`id`, `cart_id`, `item_id`, `count`) VALUES (4, 2, 4, 1);
INSERT INTO `cart_has_item` (`id`, `cart_id`, `item_id`, `count`) VALUES (5, 2, 1, 1);
INSERT INTO `cart_has_item` (`id`, `cart_id`, `item_id`, `count`) VALUES (6, 3, 4, 13);
INSERT INTO `cart_has_item` (`id`, `cart_id`, `item_id`, `count`) VALUES (7, 3, 6, 22);
INSERT INTO `cart_has_item` (`id`, `cart_id`, `item_id`, `count`) VALUES (8, 5, 1, 1);

COMMIT;

