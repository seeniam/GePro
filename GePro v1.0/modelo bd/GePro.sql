-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT,
  `nome_Pessoa` VARCHAR(45) NOT NULL,
  `cpf_pessoa` VARCHAR(45) NULL,
  PRIMARY KEY (`id_pessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`setor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`setor` (
  `id_Setor` INT NOT NULL AUTO_INCREMENT,
  `nome_Setor` VARCHAR(45) NOT NULL,
  `sigla_Setor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Setor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id_Usuario` INT NOT NULL AUTO_INCREMENT,
  `email_Usuario` VARCHAR(45) NOT NULL,
  `senha_Usuario` VARCHAR(45) NOT NULL,
  `tipo_Usuario` VARCHAR(45) NOT NULL,
  `pessoa_Id_Pessoa` INT NOT NULL,
  `setor_Id_Setor` INT NOT NULL,
  PRIMARY KEY (`id_Usuario`),
  INDEX `fk_usuario_pessoa_idx` (`pessoa_Id_Pessoa` ASC),
  INDEX `fk_usuario_setor1_idx` (`setor_Id_Setor` ASC),
  CONSTRAINT `fk_usuario_pessoa`
    FOREIGN KEY (`pessoa_Id_Pessoa`)
    REFERENCES `mydb`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_setor1`
    FOREIGN KEY (`setor_Id_Setor`)
    REFERENCES `mydb`.`setor` (`id_Setor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Processo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Processo` (
  `id_Processo` INT NOT NULL AUTO_INCREMENT,
  `status_Processo` VARCHAR(45) NOT NULL,
  `assunto_Processo` VARCHAR(45) NOT NULL,
  `natureza_Processo` VARCHAR(45) NOT NULL,
  `descricao_Processo` VARCHAR(45) NOT NULL,
  `Usuario_id_Usuario` INT NOT NULL,
  `Pessoa_id_Pessoa` INT NOT NULL,
  `Setor_id_Setor` INT NOT NULL,
  PRIMARY KEY (`id_Processo`),
  INDEX `fk_Processo_usuario1_idx` (`Usuario_id_Usuario` ASC),
  INDEX `fk_Processo_pessoa1_idx` (`Pessoa_id_Pessoa` ASC),
  INDEX `fk_Processo_setor1_idx` (`Setor_id_Setor` ASC),
  CONSTRAINT `fk_Processo_usuario1`
    FOREIGN KEY (`Usuario_id_Usuario`)
    REFERENCES `mydb`.`usuario` (`id_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Processo_pessoa1`
    FOREIGN KEY (`Pessoa_id_Pessoa`)
    REFERENCES `mydb`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Processo_setor1`
    FOREIGN KEY (`Setor_id_Setor`)
    REFERENCES `mydb`.`setor` (`id_Setor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
