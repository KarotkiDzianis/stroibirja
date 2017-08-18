DROP SCHEMA IF EXISTS `birja`;
CREATE SCHEMA IF NOT EXISTS `birja` DEFAULT CHARACTER SET utf8 ;
USE `birja` ;

CREATE TABLE IF NOT EXISTS `birja`.`organization` (
  `orgId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `rol` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`orgId`));

CREATE TABLE IF NOT EXISTS `birja`.`ad` (
  `adId` INT NOT NULL AUTO_INCREMENT,
  `adName` VARCHAR(200) NOT NULL,
  `adAuthor` INT NOT NULL,
  PRIMARY KEY (`adId`),
  INDEX `name_idx` (`adAuthor` ASC),
  CONSTRAINT `name`
    FOREIGN KEY (`adAuthor`) REFERENCES `birja`.`organization` (`orgId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `birja`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `birja`.`event` (
  `eventNumber` INT NOT NULL,
  `ispId` INT NOT NULL,
  PRIMARY KEY (`eventId`, `ispId`),
  INDEX `ispId_idx` (`ispId` ASC),
  INDEX `eventNamber_idx` (`eventNumber` ASC),
  CONSTRAINT `eventNamber`
    FOREIGN KEY (`eventNumber`) REFERENCES `birja`.`ad` (`adId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ispId`
    FOREIGN KEY (`ispId`)REFERENCES `birja`.`organization` (`orgId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO `birja`.`organization` (`name`, `password`, `rol`) VALUES ('admin', 'admin', 1);
INSERT INTO `birja`.`organization` (`name`, `password`, `rol`) VALUES ('strominvest', 'strom123', 3);
INSERT INTO `birja`.`organization` (`name`, `password`, `rol`) VALUES ('sy7', 'sy123', 3);
INSERT INTO `birja`.`organization` (`name`, `password`, `rol`) VALUES ('belhard', 'bh123', 2);
INSERT INTO `birja`.`organization` (`name`, `password`, `rol`) VALUES ('epam', 'epam123', 2);
INSERT INTO `birja`.`organization` (`name`, `password`, `rol`) VALUES ('bazar', 'bazar123', 4);


INSERT INTO `birja`.`ad` (`adName`, `adAuthor`) VALUES ('renovationOffice', 4);
INSERT INTO `birja`.`ad` (`adName`, `adAuthor`) VALUES ('buildHouse', 5);
INSERT INTO `birja`.`ad` (`adName`, `adAuthor`) VALUES ('sellAll', 6);

INSERT INTO `birja`.`event` (`eventNumber`, `ispId`) VALUES (1, 2);
INSERT INTO `birja`.`event` (`eventNumber`, `ispId`) VALUES (1, 3);
INSERT INTO `birja`.`event` (`eventNumber`, `ispId`) VALUES (2, 2);
INSERT INTO `birja`.`event` (`eventNumber`, `ispId`) VALUES (2, 3);
INSERT INTO `birja`.`event` (`eventNumber`, `ispId`) VALUES (3, 4);

