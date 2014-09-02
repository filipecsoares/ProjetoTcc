
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema controlevirtual
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `controlevirtual` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `controlevirtual` ;

-- -----------------------------------------------------
-- Table `controlevirtual`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlevirtual`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `controlevirtual`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` CHAR(14) NOT NULL,
  `dt_nascimento` TIMESTAMP NOT NULL,
  `tipo` ENUM('ALUNO','ADMINISTRADOR') NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controlevirtual`.`Administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlevirtual`.`Administrador` ;

CREATE TABLE IF NOT EXISTS `controlevirtual`.`Administrador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controlevirtual`.`Ficha`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlevirtual`.`Ficha` ;

CREATE TABLE IF NOT EXISTS `controlevirtual`.`Ficha` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `objetivo` VARCHAR(100) NULL,
  `dt_cadastro` TIMESTAMP NULL,
  `dt_mudanca_prevista` TIMESTAMP NULL,
  `fk_usuario` INT NOT NULL,
  `fk_administrador` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Ficha_Usuario1_idx` (`fk_usuario` ASC),
  INDEX `fk_Ficha_Administrador1_idx` (`fk_administrador` ASC),
  CONSTRAINT `fk_Ficha_Usuario1`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `controlevirtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ficha_Administrador1`
    FOREIGN KEY (`fk_administrador`)
    REFERENCES `controlevirtual`.`Administrador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controlevirtual`.`Recado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlevirtual`.`Recado` ;

CREATE TABLE IF NOT EXISTS `controlevirtual`.`Recado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NULL,
  `descricao` TEXT NOT NULL,
  `dt_cadastro` TIMESTAMP NOT NULL,
  `fk_usuario` INT NOT NULL,
  `fk_administrador` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Recado_Usuario1_idx` (`fk_usuario` ASC),
  INDEX `fk_Recado_Administrador1_idx` (`fk_administrador` ASC),
  CONSTRAINT `fk_Recado_Usuario1`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `controlevirtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Recado_Administrador1`
    FOREIGN KEY (`fk_administrador`)
    REFERENCES `controlevirtual`.`Administrador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controlevirtual`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlevirtual`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `controlevirtual`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC),
  UNIQUE INDEX `idCategoria_UNIQUE` (`idCategoria` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controlevirtual`.`Exercicio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlevirtual`.`Exercicio` ;

CREATE TABLE IF NOT EXISTS `controlevirtual`.`Exercicio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `fk_categoria` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC),
  INDEX `fk_Exercicio_Categoria1_idx` (`fk_categoria` ASC),
  CONSTRAINT `fk_Exercicio_Categoria1`
    FOREIGN KEY (`fk_categoria`)
    REFERENCES `controlevirtual`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controlevirtual`.`Execucao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlevirtual`.`Execucao` ;

CREATE TABLE IF NOT EXISTS `controlevirtual`.`Execucao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `serie` INT NOT NULL,
  `repeticao` INT NOT NULL,
  `carga` INT NULL,
  `intervalo` INT NULL,
  `fk_exercicio` INT NOT NULL,
  `fk_ficha` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Execucao_Exercicio_idx` (`fk_exercicio` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Execucao_Ficha1_idx` (`fk_ficha` ASC),
  CONSTRAINT `fk_Execucao_Exercicio`
    FOREIGN KEY (`fk_exercicio`)
    REFERENCES `controlevirtual`.`Exercicio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Execucao_Ficha1`
    FOREIGN KEY (`fk_ficha`)
    REFERENCES `controlevirtual`.`Ficha` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
