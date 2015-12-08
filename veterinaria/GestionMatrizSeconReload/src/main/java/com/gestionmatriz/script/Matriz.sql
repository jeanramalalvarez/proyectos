SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `Matriz` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Matriz` ;

-- -----------------------------------------------------
-- Table `Matriz`.`tb_persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_persona` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_persona` (
  `int_idPersona` INT NOT NULL AUTO_INCREMENT ,
  `str_codigo` VARCHAR(45) NOT NULL ,
  `str_apePaterno` VARCHAR(45) NOT NULL ,
  `str_apeMaterno` VARCHAR(45) NOT NULL ,
  `str_nombres` VARCHAR(45) NOT NULL ,
  `str_dni` VARCHAR(8) NOT NULL ,
  `str_carnetExtranjeria` VARCHAR(15) NULL ,
  `dte_fechaNacimiento` DATE NULL ,
  `str_ciudadNacimiento` VARCHAR(45) NULL ,
  `str_telefono` VARCHAR(10) NULL ,
  `str_movil` VARCHAR(9) NULL ,
  `str_sexo` CHAR NOT NULL ,
  `str_nacionalidad` VARCHAR(45) NULL ,
  `str_correoElectronico` VARCHAR(45) NULL ,
  `str_brevete` CHAR NULL ,
  `str_categoriaBrevete` VARCHAR(45) NULL ,
  `str_estadoCivil` VARCHAR(15) NULL ,
  `str_direccion` VARCHAR(150) NULL ,
  `str_distrito` VARCHAR(45) NULL ,
  `str_provincia` VARCHAR(45) NULL ,
  `str_departamento` VARCHAR(45) NULL ,
  `bin_huellaDigital_1` BINARY NOT NULL ,
  `bin_huellaDigital_2` BINARY NOT NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_ultimaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idPersona`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_datosAcademicos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_datosAcademicos` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_datosAcademicos` (
  `int_idDatosAcademicos` INT NOT NULL AUTO_INCREMENT ,
  `int_idPersona` INT NOT NULL ,
  `str_nivel` VARCHAR(45) NULL ,
  `str_institucionEducativa` VARCHAR(45) NULL ,
  `dte_inicio` DATE NULL ,
  `dte_termino` DATE NULL ,
  `str_observacion` VARCHAR(45) NULL ,
  `str_gradoTitulo` VARCHAR(45) NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_ultimaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idDatosAcademicos`) ,
  INDEX `fk_tb_datosAcademicos_tb_persona` (`int_idPersona` ASC) ,
  CONSTRAINT `fk_tb_datosAcademicos_tb_persona`
    FOREIGN KEY (`int_idPersona` )
    REFERENCES `Matriz`.`tb_persona` (`int_idPersona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_experienciaLaboral`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_experienciaLaboral` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_experienciaLaboral` (
  `int_idExperienciaLaboral` INT NOT NULL AUTO_INCREMENT ,
  `int_idPersona` INT NOT NULL ,
  `str_empresa` VARCHAR(45) NULL ,
  `str_rubro` VARCHAR(45) NULL ,
  `str_cargo` VARCHAR(45) NULL ,
  `str_funciones` VARCHAR(45) NULL ,
  `dte_fechaInicio` DATE NULL ,
  `dte_fechaFin` DATE NULL ,
  `str_sueldo` VARCHAR(45) NULL ,
  `str_jefeInmediato` VARCHAR(45) NULL ,
  `str_telfEmpresa` VARCHAR(10) NULL ,
  `str_motivoCese` VARCHAR(45) NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_fechaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idExperienciaLaboral`) ,
  INDEX `fk_tb_experienciaLaboral_tb_persona1` (`int_idPersona` ASC) ,
  CONSTRAINT `fk_tb_experienciaLaboral_tb_persona1`
    FOREIGN KEY (`int_idPersona` )
    REFERENCES `Matriz`.`tb_persona` (`int_idPersona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_datosFamiliares`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_datosFamiliares` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_datosFamiliares` (
  `int_idDatosFamiliares` INT NOT NULL AUTO_INCREMENT ,
  `int_idPersona` INT NOT NULL ,
  `str_documento` VARCHAR(45) NULL ,
  `str_numeroDocumento` VARCHAR(15) NULL ,
  `str_apePaterno` VARCHAR(45) NULL ,
  `str_apeMaterno` VARCHAR(45) NULL ,
  `str_nombres` VARCHAR(45) NULL ,
  `dte_fechaNacimiento` DATE NULL ,
  `str_vinculo` VARCHAR(45) NULL ,
  `str_ocupacion` VARCHAR(45) NULL ,
  `str_conviven` CHAR NULL ,
  `str_telfEmergencia` VARCHAR(15) NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_ultimaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idDatosFamiliares`) ,
  INDEX `fk_tb_datosFamiliares_tb_persona1` (`int_idPersona` ASC) ,
  CONSTRAINT `fk_tb_datosFamiliares_tb_persona1`
    FOREIGN KEY (`int_idPersona` )
    REFERENCES `Matriz`.`tb_persona` (`int_idPersona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_otrosEstudios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_otrosEstudios` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_otrosEstudios` (
  `int_idOtrosEstudios` INT NOT NULL AUTO_INCREMENT ,
  `int_idPersona` INT NOT NULL ,
  `str_estudio` VARCHAR(45) NULL ,
  `str_nivelEstudio` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_ultimaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idOtrosEstudios`) ,
  INDEX `fk_tb_otrosEstudios_tb_persona1` (`int_idPersona` ASC) ,
  CONSTRAINT `fk_tb_otrosEstudios_tb_persona1`
    FOREIGN KEY (`int_idPersona` )
    REFERENCES `Matriz`.`tb_persona` (`int_idPersona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_usuario` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_usuario` (
  `int_idUsuario` INT NOT NULL AUTO_INCREMENT ,
  `int_idPersona` INT NOT NULL ,
  `str_usuario` VARCHAR(45) NULL ,
  `str_contrasenia` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_fechaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idUsuario`) ,
  INDEX `fk_tb_usuario_tb_persona1` (`int_idPersona` ASC) ,
  CONSTRAINT `fk_tb_usuario_tb_persona1`
    FOREIGN KEY (`int_idPersona` )
    REFERENCES `Matriz`.`tb_persona` (`int_idPersona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_funciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_funciones` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_funciones` (
  `int_idFunciones` INT NOT NULL AUTO_INCREMENT ,
  `str_rol` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_ultimaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idFunciones`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_funcionUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_funcionUsuario` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_funcionUsuario` (
  `int_idFunciones` INT NOT NULL ,
  `int_idUsuario` INT NOT NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_ultimaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idFunciones`, `int_idUsuario`) ,
  INDEX `fk_tb_funciones_has_tb_usuario_tb_usuario1` (`int_idUsuario` ASC) ,
  INDEX `fk_tb_funciones_has_tb_usuario_tb_funciones1` (`int_idFunciones` ASC) ,
  CONSTRAINT `fk_tb_funciones_has_tb_usuario_tb_funciones1`
    FOREIGN KEY (`int_idFunciones` )
    REFERENCES `Matriz`.`tb_funciones` (`int_idFunciones` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_funciones_has_tb_usuario_tb_usuario1`
    FOREIGN KEY (`int_idUsuario` )
    REFERENCES `Matriz`.`tb_usuario` (`int_idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_tipoContrato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_tipoContrato` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_tipoContrato` (
  `int_idTipoContrato` INT NOT NULL ,
  `str_tipoContrato` VARCHAR(45) NULL ,
  `str_nombreReporte` VARCHAR(45) NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_fechaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idTipoContrato`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_empresa` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_empresa` (
  `int_idEmpresa` INT NOT NULL ,
  `str_razonSocial` VARCHAR(100) NULL ,
  `str_ruc` VARCHAR(12) NULL ,
  `str_domicilioEmpresa` VARCHAR(150) NULL ,
  `str_representanteLegal` VARCHAR(150) NULL ,
  `str_dniRepresentante` VARCHAR(10) NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_fechaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idEmpresa`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_contrato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_contrato` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_contrato` (
  `int_idContrato` INT NOT NULL ,
  `int_idPersona` INT NOT NULL ,
  `int_idTipoContrato` INT NOT NULL ,
  `int_idEmpresa` INT NOT NULL ,
  `dte_fechaInicial` DATE NULL ,
  `dte_fechaFinal` DATE NULL ,
  `dbl_sueldo` DOUBLE NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_ultimaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idContrato`) ,
  INDEX `fk_tb_contrato_tb_persona1` (`int_idPersona` ASC) ,
  INDEX `fk_tb_contrato_tb_tipoContrato1` (`int_idTipoContrato` ASC) ,
  INDEX `fk_tb_contrato_tb_empresa1` (`int_idEmpresa` ASC) ,
  CONSTRAINT `fk_tb_contrato_tb_persona1`
    FOREIGN KEY (`int_idPersona` )
    REFERENCES `Matriz`.`tb_persona` (`int_idPersona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_contrato_tb_tipoContrato1`
    FOREIGN KEY (`int_idTipoContrato` )
    REFERENCES `Matriz`.`tb_tipoContrato` (`int_idTipoContrato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_contrato_tb_empresa1`
    FOREIGN KEY (`int_idEmpresa` )
    REFERENCES `Matriz`.`tb_empresa` (`int_idEmpresa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_horario` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_horario` (
  `int_idHorario` INT NOT NULL ,
  `str_nombreHorario` VARCHAR(45) NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_fechaModificacion` DATE NULL ,
  `str_usuarioModifcador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idHorario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_jornada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_jornada` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_jornada` (
  `int_idJornada` INT NOT NULL ,
  `tme_HoraInicio` TIME NULL ,
  `tme_horaFin` TIME NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_fechaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idJornada`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_horarioJornada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_horarioJornada` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_horarioJornada` (
  `int_idHorario` INT NOT NULL ,
  `int_idJornada` INT NOT NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_fechaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idHorario`, `int_idJornada`) ,
  INDEX `fk_tb_horario_has_tb_jornada_tb_jornada1` (`int_idJornada` ASC) ,
  INDEX `fk_tb_horario_has_tb_jornada_tb_horario1` (`int_idHorario` ASC) ,
  CONSTRAINT `fk_tb_horario_has_tb_jornada_tb_horario1`
    FOREIGN KEY (`int_idHorario` )
    REFERENCES `Matriz`.`tb_horario` (`int_idHorario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_horario_has_tb_jornada_tb_jornada1`
    FOREIGN KEY (`int_idJornada` )
    REFERENCES `Matriz`.`tb_jornada` (`int_idJornada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_horarioJornadaContrato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_horarioJornadaContrato` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_horarioJornadaContrato` (
  `int_idHorario` INT NOT NULL ,
  `int_idJornada` INT NOT NULL ,
  `int_idContrato` INT NOT NULL ,
  `str_estado` VARCHAR(45) NULL ,
  `dte_fechaCreacion` DATE NULL ,
  `str_usuarioCreador` VARCHAR(45) NULL ,
  `dte_fechaModificacion` DATE NULL ,
  `str_usuarioModificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`int_idHorario`, `int_idJornada`, `int_idContrato`) ,
  INDEX `fk_tb_horarioJornada_has_tb_contrato_tb_contrato1` (`int_idContrato` ASC) ,
  INDEX `fk_tb_horarioJornada_has_tb_contrato_tb_horarioJornada1` (`int_idHorario` ASC, `int_idJornada` ASC) ,
  CONSTRAINT `fk_tb_horarioJornada_has_tb_contrato_tb_horarioJornada1`
    FOREIGN KEY (`int_idHorario` , `int_idJornada` )
    REFERENCES `Matriz`.`tb_horarioJornada` (`int_idHorario` , `int_idJornada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_horarioJornada_has_tb_contrato_tb_contrato1`
    FOREIGN KEY (`int_idContrato` )
    REFERENCES `Matriz`.`tb_contrato` (`int_idContrato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_tipoMarcado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_tipoMarcado` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_tipoMarcado` (
  `int_tipoMarcado` INT NOT NULL AUTO_INCREMENT ,
  `str_descripcion` VARCHAR(1) NULL ,
  PRIMARY KEY (`int_tipoMarcado`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matriz`.`tb_asistencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matriz`.`tb_asistencia` ;

CREATE  TABLE IF NOT EXISTS `Matriz`.`tb_asistencia` (
  `int_asistencia` INT NOT NULL ,
  `int_idHorario` INT NOT NULL ,
  `int_idJornada` INT NOT NULL ,
  `int_idContrato` INT NOT NULL ,
  `dte_fecha` DATE NOT NULL ,
  `tm_hora` TIME NOT NULL ,
  `int_tipoMarcado` INT NOT NULL ,
  `str_estadoMarcado` VARCHAR(1) NULL ,
  PRIMARY KEY (`int_asistencia`) ,
  INDEX `fk_tb_asistencia_tb_horarioJornadaContrato1` (`int_idHorario` ASC, `int_idJornada` ASC, `int_idContrato` ASC) ,
  INDEX `fk_tb_asistencia_tb_tipoMarcado1` (`int_tipoMarcado` ASC) ,
  CONSTRAINT `fk_tb_asistencia_tb_horarioJornadaContrato1`
    FOREIGN KEY (`int_idHorario` , `int_idJornada` , `int_idContrato` )
    REFERENCES `Matriz`.`tb_horarioJornadaContrato` (`int_idHorario` , `int_idJornada` , `int_idContrato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_asistencia_tb_tipoMarcado1`
    FOREIGN KEY (`int_tipoMarcado` )
    REFERENCES `Matriz`.`tb_tipoMarcado` (`int_tipoMarcado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
