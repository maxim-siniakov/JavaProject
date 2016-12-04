-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Facultet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Facultet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Facultet` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `Facultet` ;

-- -----------------------------------------------------
-- Table `Facultet`.`Actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Facultet`.`Actors` (
  `idActors` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `middlename` VARCHAR(45) NULL COMMENT '',
  `surname` VARCHAR(45) NULL COMMENT '',
  `age` VARCHAR(45) NULL COMMENT '',
  `dateOfBirth` DATE NULL COMMENT '',
  `login` VARCHAR(45) NULL COMMENT '',
  `pass` VARCHAR(45) NULL COMMENT '',
  `role` INT NULL COMMENT '',
  PRIMARY KEY (`idActors`)  COMMENT '',
  UNIQUE INDEX `login_UNIQUE` (`login` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Facultet`.`Faculties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Facultet`.`Faculties` (
  `idFaculties` INT UNSIGNED NULL AUTO_INCREMENT COMMENT '',
  `name_faculty` VARCHAR(45) NULL COMMENT '',
  `min_scores` INT NULL COMMENT '',
  `limit_students` INT UNSIGNED NULL COMMENT '',
  PRIMARY KEY (`idFaculties`)  COMMENT '',
  UNIQUE INDEX `name_faculty_UNIQUE` (`name_faculty` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Facultet`.`Actors_faculties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Facultet`.`Actors_faculties` (
  `idActors_faculties` INT UNSIGNED NULL AUTO_INCREMENT COMMENT '',
  `id_actor` INT UNSIGNED NULL COMMENT '',
  `id_faculty` INT UNSIGNED NULL COMMENT '',
  `state` INT NULL COMMENT '',
  PRIMARY KEY (`idActors_faculties`)  COMMENT '',
  INDEX `fk_Actors_faculties_1_idx` (`id_actor` ASC)  COMMENT '',
  INDEX `fk_Actors_faculties_2_idx` (`id_faculty` ASC)  COMMENT '',
  CONSTRAINT `fk_Actors_faculties_1`
    FOREIGN KEY (`id_actor`)
    REFERENCES `Facultet`.`Actors` (`idActors`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Actors_faculties_2`
    FOREIGN KEY (`id_faculty`)
    REFERENCES `Facultet`.`Faculties` (`idFaculties`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Facultet`.`Subjects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Facultet`.`Subjects` (
  `IdSubject` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `subject` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`IdSubject`)  COMMENT '',
  UNIQUE INDEX `subject_UNIQUE` (`subject` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Facultet`.`Actors_subjects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Facultet`.`Actors_subjects` (
  `idActors_subjects` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `id_Actor` INT UNSIGNED NULL COMMENT '',
  `id_Subject` INT UNSIGNED NULL COMMENT '',
  `scores` FLOAT NULL COMMENT '',
  PRIMARY KEY (`idActors_subjects`)  COMMENT '',
  INDEX `fk_Actors_subjects_1_idx` (`id_Actor` ASC)  COMMENT '',
  INDEX `fk_Actors_subjects_2_idx` (`id_Subject` ASC)  COMMENT '',
  CONSTRAINT `fk_Actors_subjects_1`
    FOREIGN KEY (`id_Actor`)
    REFERENCES `Facultet`.`Actors` (`idActors`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Actors_subjects_2`
    FOREIGN KEY (`id_Subject`)
    REFERENCES `Facultet`.`Subjects` (`IdSubject`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Facultet`.`Faculties_subjects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Facultet`.`Faculties_subjects` (
  `idFaculties_subjects` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `id_faculties` INT UNSIGNED NULL COMMENT '',
  `id_subject` INT UNSIGNED NULL COMMENT '',
  PRIMARY KEY (`idFaculties_subjects`)  COMMENT '',
  INDEX `fk_Faculties_subjects_1_idx` (`id_faculties` ASC)  COMMENT '',
  INDEX `fk_Faculties_subjects_2_idx` (`id_subject` ASC)  COMMENT '',
  CONSTRAINT `fk_Faculties_subjects_1`
    FOREIGN KEY (`id_faculties`)
    REFERENCES `Facultet`.`Faculties` (`idFaculties`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Faculties_subjects_2`
    FOREIGN KEY (`id_subject`)
    REFERENCES `Facultet`.`Subjects` (`IdSubject`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Facultet`.`Actors`
-- -----------------------------------------------------
START TRANSACTION;
USE `Facultet`;
INSERT INTO `Facultet`.`Actors` (`idActors`, `name`, `middlename`, `surname`, `age`, `dateOfBirth`, `login`, `pass`, `role`) VALUES (1, 'max', 'sin', 'vik', '27', '1989-04-22', 'max', 'max', 1);
INSERT INTO `Facultet`.`Actors` (`idActors`, `name`, `middlename`, `surname`, `age`, `dateOfBirth`, `login`, `pass`, `role`) VALUES (2, 'dimon', 'sor', 'ser', '27', '1988-09-16', 'dim', 'dim', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Facultet`.`Faculties`
-- -----------------------------------------------------
START TRANSACTION;
USE `Facultet`;
INSERT INTO `Facultet`.`Faculties` (`idFaculties`, `name_faculty`, `min_scores`, `limit_students`) VALUES (1, 'ENF', 220, 35);
INSERT INTO `Facultet`.`Faculties` (`idFaculties`, `name_faculty`, `min_scores`, `limit_students`) VALUES (2, 'GF', 160, 90);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Facultet`.`Actors_faculties`
-- -----------------------------------------------------
START TRANSACTION;
USE `Facultet`;
INSERT INTO `Facultet`.`Actors_faculties` (`idActors_faculties`, `id_actor`, `id_faculty`, `state`) VALUES (1, 1, 1, 1);
INSERT INTO `Facultet`.`Actors_faculties` (`idActors_faculties`, `id_actor`, `id_faculty`, `state`) VALUES (2, 1, 2, 1);
INSERT INTO `Facultet`.`Actors_faculties` (`idActors_faculties`, `id_actor`, `id_faculty`, `state`) VALUES (3, 2, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Facultet`.`Subjects`
-- -----------------------------------------------------
START TRANSACTION;
USE `Facultet`;
INSERT INTO `Facultet`.`Subjects` (`IdSubject`, `subject`) VALUES (1, 'Attestat');
INSERT INTO `Facultet`.`Subjects` (`IdSubject`, `subject`) VALUES (2, 'Math');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Facultet`.`Actors_subjects`
-- -----------------------------------------------------
START TRANSACTION;
USE `Facultet`;
INSERT INTO `Facultet`.`Actors_subjects` (`idActors_subjects`, `id_Actor`, `id_Subject`, `scores`) VALUES (1, 1, 1, 4.5);
INSERT INTO `Facultet`.`Actors_subjects` (`idActors_subjects`, `id_Actor`, `id_Subject`, `scores`) VALUES (2, 1, 2, 96);
INSERT INTO `Facultet`.`Actors_subjects` (`idActors_subjects`, `id_Actor`, `id_Subject`, `scores`) VALUES (3, 2, 1, 3.2);
INSERT INTO `Facultet`.`Actors_subjects` (`idActors_subjects`, `id_Actor`, `id_Subject`, `scores`) VALUES (4, 2, 2, 43);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Facultet`.`Faculties_subjects`
-- -----------------------------------------------------
START TRANSACTION;
USE `Facultet`;
INSERT INTO `Facultet`.`Faculties_subjects` (`idFaculties_subjects`, `id_faculties`, `id_subject`) VALUES (1, 1, 1);
INSERT INTO `Facultet`.`Faculties_subjects` (`idFaculties_subjects`, `id_faculties`, `id_subject`) VALUES (2, 1, 2);
INSERT INTO `Facultet`.`Faculties_subjects` (`idFaculties_subjects`, `id_faculties`, `id_subject`) VALUES (3, 2, 1);

COMMIT;

