-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mutrack_simple
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mutrack_simple` ;

-- -----------------------------------------------------
-- Schema mutrack_simple
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mutrack_simple` DEFAULT CHARACTER SET utf8 ;
USE `mutrack_simple` ;


-- -----------------------------------------------------
-- Table `mutrack_simple`.`tb_client_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mutrack_simple`.`tb_client_type` ;

CREATE TABLE IF NOT EXISTS `mutrack_simple`.`tb_client_type` (
  `pk_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pk_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mutrack_simple`.`tb_client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mutrack_simple`.`tb_client` ;

CREATE TABLE IF NOT EXISTS `mutrack_simple`.`tb_client` (
  `pk_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(20) NULL,
  `email` VARCHAR(45) NULL,
  `client_type_id` INT NOT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `fk_client_client_type1_idx` (`client_type_id` ASC),
  CONSTRAINT `fk_client_client_type1`
    FOREIGN KEY (`client_type_id`)
    REFERENCES `mutrack_simple`.`tb_client_type` (`pk_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

COMMIT;

