-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.53-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sgn
--

CREATE DATABASE IF NOT EXISTS sgn;
USE sgn;

--
-- Definition of table `t_abogado`
--

DROP TABLE IF EXISTS `t_abogado`;
CREATE TABLE `t_abogado` (
  `IDABOGADO` int(10) NOT NULL,
  `IDPERSONA` int(10) NOT NULL,
  `COLEGIATURA` varchar(10) DEFAULT NULL,
  `ZONA` int(10) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDABOGADO`),
  KEY `fk_T_ABOGADO_T_PERSONA1_idx` (`IDPERSONA`),
  CONSTRAINT `fk_T_ABOGADO_T_PERSONA1` FOREIGN KEY (`IDPERSONA`) REFERENCES `t_persona` (`IDPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_abogado`
--

/*!40000 ALTER TABLE `t_abogado` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_abogado` ENABLE KEYS */;


--
-- Definition of table `t_det_kado`
--

DROP TABLE IF EXISTS `t_det_kado`;
CREATE TABLE `t_det_kado` (
  `IDDETKADO` int(10) NOT NULL COMMENT 'TABLA KARDEX DOCUMENTOS PDF, WORD',
  `IDKARDEX` int(10) NOT NULL,
  `DESCRIPCION` int(10) DEFAULT NULL,
  `RUTA` varchar(200) DEFAULT NULL,
  `FLAGLECTURA` char(1) DEFAULT NULL,
  `FLAGPROTEGIDO` char(1) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDDETKADO`) USING BTREE,
  KEY `fk_T_DET_KADO_T_KARDEX1_idx` (`IDKARDEX`),
  CONSTRAINT `fk_T_DET_KADO_T_KARDEX1` FOREIGN KEY (`IDKARDEX`) REFERENCES `t_kardex` (`IDKARDEX`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_det_kado`
--

/*!40000 ALTER TABLE `t_det_kado` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_det_kado` ENABLE KEYS */;


--
-- Definition of table `t_det_kaem`
--

DROP TABLE IF EXISTS `t_det_kaem`;
CREATE TABLE `t_det_kaem` (
  `IDKAEM` int(10) NOT NULL COMMENT 'TABLA KARDEX EMPRESA',
  `IDKARDEX` int(10) NOT NULL,
  `IDEMREP` int(10) NOT NULL,
  `PARTIDA` varchar(50) DEFAULT NULL,
  `ZONA` int(10) DEFAULT NULL,
  `CONDICION` int(10) DEFAULT NULL,
  `FECFIRMA` datetime DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDKAEM`) USING BTREE,
  KEY `fk_T_DET_KAEM_T_KARDEX1` (`IDKARDEX`),
  KEY `fk_T_DET_KAEM_T_EMREP1_idx` (`IDEMREP`) USING BTREE,
  CONSTRAINT `FK_t_det_kaem_T_EMREP1` FOREIGN KEY (`IDEMREP`) REFERENCES `t_emrep` (`IDEMREP`),
  CONSTRAINT `fk_T_DET_KAEM_T_KARDEX1` FOREIGN KEY (`IDKARDEX`) REFERENCES `t_kardex` (`IDKARDEX`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_det_kaem`
--

/*!40000 ALTER TABLE `t_det_kaem` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_det_kaem` ENABLE KEYS */;


--
-- Definition of table `t_det_kapa`
--

DROP TABLE IF EXISTS `t_det_kapa`;
CREATE TABLE `t_det_kapa` (
  `IDDETKAPA` int(10) NOT NULL COMMENT 'TABLA KARDEX PARTES',
  `IDKARDEX` int(10) NOT NULL,
  `FECHA` datetime DEFAULT NULL,
  `ORDEN` varchar(20) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDDETKAPA`) USING BTREE,
  KEY `fk_T_DET_KAPA_T_KARDEX1_idx` (`IDKARDEX`),
  CONSTRAINT `fk_T_DET_KAPA_T_KARDEX1` FOREIGN KEY (`IDKARDEX`) REFERENCES `t_kardex` (`IDKARDEX`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_det_kapa`
--

/*!40000 ALTER TABLE `t_det_kapa` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_det_kapa` ENABLE KEYS */;


--
-- Definition of table `t_det_kate`
--

DROP TABLE IF EXISTS `t_det_kate`;
CREATE TABLE `t_det_kate` (
  `IDDETKATE` int(10) NOT NULL COMMENT 'TABLA KARDEX TESTIMONIO',
  `IDKARDEX` int(10) NOT NULL,
  `FECHA` datetime DEFAULT NULL,
  `ORDEN` varchar(20) DEFAULT NULL,
  `ENTREGPERS` varchar(200) DEFAULT NULL COMMENT 'NOMBRES DE LA PERSONA A QUIEN LE FUE ENTREGADO EL TESTIMONIO',
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDDETKATE`) USING BTREE,
  KEY `fk_T_DET_KATE_T_KARDEX1_idx` (`IDKARDEX`),
  CONSTRAINT `fk_T_DET_KATE_T_KARDEX1` FOREIGN KEY (`IDKARDEX`) REFERENCES `t_kardex` (`IDKARDEX`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_det_kate`
--

/*!40000 ALTER TABLE `t_det_kate` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_det_kate` ENABLE KEYS */;


--
-- Definition of table `t_empleado`
--

DROP TABLE IF EXISTS `t_empleado`;
CREATE TABLE `t_empleado` (
  `IDEMPLEADO` int(10) NOT NULL COMMENT 'TABLA EMPLEADOS INTERNOS INCLUYE ABOGADOS INTERNOS COMO ROL',
  `IDPERSONA` int(10) NOT NULL,
  `IDUSUARIO` int(10) unsigned NOT NULL,
  `ROL` varchar(45) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDEMPLEADO`),
  KEY `fk_T_EMPLEADO_T_PERSONA1_idx` (`IDPERSONA`),
  KEY `fk_T_EMPLEADO_T_USUARIO1_idx` (`IDUSUARIO`),
  CONSTRAINT `fk_T_EMPLEADO_T_PERSONA1` FOREIGN KEY (`IDPERSONA`) REFERENCES `t_persona` (`IDPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_EMPLEADO_T_USUARIO1` FOREIGN KEY (`IDUSUARIO`) REFERENCES `t_usuario` (`IDUSUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_empleado`
--

/*!40000 ALTER TABLE `t_empleado` DISABLE KEYS */;
INSERT INTO `t_empleado` (`IDEMPLEADO`,`IDPERSONA`,`IDUSUARIO`,`ROL`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`) VALUES 
 (1,2,1,'9',NULL,NULL,NULL,NULL,NULL,'1'),
 (2,3,2,'8',NULL,NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `t_empleado` ENABLE KEYS */;


--
-- Definition of table `t_empresa`
--

DROP TABLE IF EXISTS `t_empresa`;
CREATE TABLE `t_empresa` (
  `IDEMPRESA` int(10) NOT NULL,
  `RAZSOCIAL` varchar(200) DEFAULT NULL,
  `RUC` varchar(20) DEFAULT NULL,
  `DIRECCION` varchar(200) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDEMPRESA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_empresa`
--

/*!40000 ALTER TABLE `t_empresa` DISABLE KEYS */;
INSERT INTO `t_empresa` (`IDEMPRESA`,`RAZSOCIAL`,`RUC`,`DIRECCION`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`) VALUES 
 (1,'EMPRESA1 SAC','12345678912','DIRECCION1',NULL,NULL,NULL,NULL,NULL,'1'),
 (2,'EMPRESA2 SAC','12345678901','DIRECCION2',NULL,NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `t_empresa` ENABLE KEYS */;


--
-- Definition of table `t_emrep`
--

DROP TABLE IF EXISTS `t_emrep`;
CREATE TABLE `t_emrep` (
  `IDEMREP` int(10) NOT NULL COMMENT 'TABLA REPRESENTANTES DE LAS EMPRESAS',
  `IDPERSONA` int(10) NOT NULL,
  `IDEMPRESA` int(10) NOT NULL,
  `CARGO` varchar(50) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDEMREP`) USING BTREE,
  KEY `fk_T_DET_EMPE_T_PERSONA1_idx` (`IDPERSONA`),
  KEY `fk_T_EMREP_T_EMPRESA1_idx` (`IDEMPRESA`),
  CONSTRAINT `fk_T_DET_EMPE_T_PERSONA1` FOREIGN KEY (`IDPERSONA`) REFERENCES `t_persona` (`IDPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_EMREP_T_EMPRESA1` FOREIGN KEY (`IDEMPRESA`) REFERENCES `t_empresa` (`IDEMPRESA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_emrep`
--

/*!40000 ALTER TABLE `t_emrep` DISABLE KEYS */;
INSERT INTO `t_emrep` (`IDEMREP`,`IDPERSONA`,`IDEMPRESA`,`CARGO`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`) VALUES 
 (1,1,1,'CARGO 1',NULL,NULL,NULL,NULL,NULL,'1'),
 (2,5,1,'CARGO 2',NULL,NULL,NULL,NULL,NULL,'1'),
 (3,6,1,'CARGO3',NULL,NULL,NULL,NULL,NULL,'1'),
 (4,2,2,'CARGO4',NULL,NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `t_emrep` ENABLE KEYS */;


--
-- Definition of table `t_kaac`
--

DROP TABLE IF EXISTS `t_kaac`;
CREATE TABLE `t_kaac` (
  `IDKAAC` int(10) NOT NULL COMMENT 'TABLA KARDEX ACTOS',
  `ACTO` varchar(500) DEFAULT NULL,
  `CODPDT` int(10) DEFAULT NULL,
  `CODUIF` int(10) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDKAAC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_kaac`
--

/*!40000 ALTER TABLE `t_kaac` DISABLE KEYS */;
INSERT INTO `t_kaac` (`IDKAAC`,`ACTO`,`CODPDT`,`CODUIF`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`) VALUES 
 (1,'Acto01',123456,15252,NULL,NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `t_kaac` ENABLE KEYS */;


--
-- Definition of table `t_kape`
--

DROP TABLE IF EXISTS `t_kape`;
CREATE TABLE `t_kape` (
  `IDKAPE` int(10) NOT NULL COMMENT 'TABLA DE RELACION KAREX CON PERSONAS Y PUEDA QUE LA PERSONA TENGA REPRESENTANTE',
  `IDKARDEX` int(10) NOT NULL,
  `IDPEREP` int(10) NOT NULL,
  `CONDICION` int(10) DEFAULT NULL COMMENT 'COMPRADOR, VENDEDOR, ETC',
  `PARTICIPACONYUGE` char(1) DEFAULT NULL,
  `FECFIRMA` datetime DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDKAPE`) USING BTREE,
  KEY `fk_T_DET_KAOT_T_KARDEX1_idx` (`IDKARDEX`),
  KEY `fk_t_kape_t_perep1_idx` (`IDPEREP`),
  CONSTRAINT `fk_T_DET_KAOT_T_KARDEX1` FOREIGN KEY (`IDKARDEX`) REFERENCES `t_kardex` (`IDKARDEX`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_t_kape_2_t_repPerso` FOREIGN KEY (`IDPEREP`) REFERENCES `t_perep` (`IDPEREP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_kape`
--

/*!40000 ALTER TABLE `t_kape` DISABLE KEYS */;
INSERT INTO `t_kape` (`IDKAPE`,`IDKARDEX`,`IDPEREP`,`CONDICION`,`PARTICIPACONYUGE`,`FECFIRMA`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`) VALUES 
 (1,10,3,1,'1',NULL,NULL,NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `t_kape` ENABLE KEYS */;


--
-- Definition of table `t_kardex`
--

DROP TABLE IF EXISTS `t_kardex`;
CREATE TABLE `t_kardex` (
  `IDKARDEX` int(10) NOT NULL AUTO_INCREMENT,
  `RESPONSABLE` int(10) NOT NULL,
  `IDKAAC` int(10) NOT NULL,
  `NROKARDEX` varchar(10) DEFAULT NULL,
  `ESCRITURA` varchar(10) DEFAULT NULL,
  `MINUTA` varchar(10) DEFAULT NULL,
  `FOLIO` varchar(10) DEFAULT NULL,
  `FECINGRESO` datetime DEFAULT NULL,
  `FECCIERRE` datetime DEFAULT NULL,
  `IDABOGADO` int(10) DEFAULT NULL,
  `FLAGPDT` char(1) DEFAULT NULL,
  `FLAGUIT` char(1) DEFAULT NULL,
  `FECESCRITURA` datetime DEFAULT NULL,
  `FECFIRMANOT` datetime DEFAULT NULL,
  `FOLIOINI` int(10) DEFAULT NULL,
  `FOLIOFIN` int(10) DEFAULT NULL,
  `REGISTRO` int(10) DEFAULT NULL,
  `NROFOJAS` int(5) DEFAULT NULL,
  `FLAGNOCORRE` char(1) DEFAULT NULL,
  `TOMO` int(10) DEFAULT NULL,
  `PROTEGIDO` char(1) DEFAULT NULL,
  `DIGITADOR` int(10) DEFAULT NULL,
  `CONFRONTADOR` int(10) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDKARDEX`),
  KEY `fk_T_KARDEX_T_EMPLEADO1_idx` (`RESPONSABLE`),
  KEY `fk_T_KARDEX_T_ABOGADO1_idx` (`IDABOGADO`),
  KEY `fk_T_KARDEX_T_KAAC1_idx` (`IDKAAC`),
  KEY `fk_T_KARDEX_T_EMPLEADO2_idx` (`DIGITADOR`),
  KEY `fk_T_KARDEX_T_EMPLEADO3_idx` (`CONFRONTADOR`),
  CONSTRAINT `fk_T_KARDEX_T_ABOGADO1` FOREIGN KEY (`IDABOGADO`) REFERENCES `t_abogado` (`IDABOGADO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_KARDEX_T_EMPLEADO1` FOREIGN KEY (`RESPONSABLE`) REFERENCES `t_empleado` (`IDEMPLEADO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_KARDEX_T_EMPLEADO2` FOREIGN KEY (`DIGITADOR`) REFERENCES `t_empleado` (`IDEMPLEADO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_KARDEX_T_EMPLEADO3` FOREIGN KEY (`CONFRONTADOR`) REFERENCES `t_empleado` (`IDEMPLEADO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_KARDEX_T_KAAC1` FOREIGN KEY (`IDKAAC`) REFERENCES `t_kaac` (`IDKAAC`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_kardex`
--

/*!40000 ALTER TABLE `t_kardex` DISABLE KEYS */;
INSERT INTO `t_kardex` (`IDKARDEX`,`RESPONSABLE`,`IDKAAC`,`NROKARDEX`,`ESCRITURA`,`MINUTA`,`FOLIO`,`FECINGRESO`,`FECCIERRE`,`IDABOGADO`,`FLAGPDT`,`FLAGUIT`,`FECESCRITURA`,`FECFIRMANOT`,`FOLIOINI`,`FOLIOFIN`,`REGISTRO`,`NROFOJAS`,`FLAGNOCORRE`,`TOMO`,`PROTEGIDO`,`DIGITADOR`,`CONFRONTADOR`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`) VALUES 
 (3,2,1,'1','1','1',NULL,'2014-07-06 20:38:18',NULL,NULL,NULL,NULL,'2014-07-17 00:00:00',NULL,25,0,1,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-06 20:38:19','2014-07-11 00:20:18',NULL,NULL),
 (4,2,1,'2','2','2',NULL,'2014-07-06 20:54:29',NULL,NULL,NULL,NULL,'2014-07-24 00:00:00',NULL,11,0,2,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-06 20:54:35','2014-07-11 00:30:29',NULL,NULL),
 (5,1,1,'3','3',NULL,NULL,'2014-07-06 20:55:59',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,0,NULL,0,NULL,NULL,NULL,NULL,NULL,'2014-07-06 20:56:18',NULL,NULL,NULL),
 (6,2,1,'4','4','3',NULL,'2014-07-06 20:59:11',NULL,NULL,NULL,NULL,'2014-07-17 00:00:00',NULL,222,0,771415911,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-06 20:59:11','2014-07-10 22:22:33',NULL,NULL),
 (9,2,1,'5','5','4',NULL,'2014-07-06 21:11:02',NULL,NULL,NULL,NULL,'2014-07-10 06:12:00',NULL,77,0,99,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-06 21:11:02',NULL,NULL,NULL),
 (10,2,1,'6','6','5',NULL,'2014-07-06 22:08:42',NULL,NULL,NULL,NULL,'2014-07-10 15:00:28',NULL,555666,0,77788,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-06 22:08:42','2014-07-11 00:44:47',NULL,NULL),
 (13,2,1,'7','7','6',NULL,'2014-07-10 01:27:55',NULL,NULL,NULL,NULL,'2014-07-23 00:00:00',NULL,555,0,55522,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-10 01:28:30',NULL,NULL,NULL),
 (14,2,1,'8','8','7',NULL,'2014-07-10 22:03:38',NULL,NULL,NULL,NULL,'2014-07-17 00:00:00',NULL,1252,0,1515,0,NULL,0,NULL,2,NULL,NULL,NULL,'2014-07-10 22:03:54','2014-07-10 22:20:50',NULL,NULL),
 (16,2,1,'9','9','8',NULL,'2014-07-10 22:54:19',NULL,NULL,NULL,NULL,'2014-07-30 00:00:00',NULL,1820,0,16,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-10 22:54:33','2014-07-11 00:41:32',NULL,NULL),
 (17,2,1,'10','10',NULL,NULL,'2014-07-10 23:00:35',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,0,NULL,0,NULL,NULL,NULL,NULL,NULL,'2014-07-10 23:00:46',NULL,NULL,NULL),
 (18,2,1,'11','11','9',NULL,'2014-07-10 23:07:56',NULL,NULL,NULL,NULL,'2014-07-23 00:00:00',NULL,2022,0,9,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-10 23:08:06','2014-07-11 00:40:44',NULL,NULL),
 (19,2,1,'12','12',NULL,NULL,'2014-07-11 00:30:37',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,0,NULL,0,NULL,NULL,NULL,NULL,NULL,'2014-07-11 00:30:47',NULL,NULL,NULL),
 (20,2,1,'13','13','10',NULL,'2014-07-11 00:41:42',NULL,NULL,NULL,NULL,'2014-07-18 00:00:00',NULL,2926,0,16,0,NULL,0,NULL,1,NULL,NULL,NULL,'2014-07-11 00:41:50','2014-07-11 00:42:26',NULL,NULL);
/*!40000 ALTER TABLE `t_kardex` ENABLE KEYS */;


--
-- Definition of table `t_perep`
--

DROP TABLE IF EXISTS `t_perep`;
CREATE TABLE `t_perep` (
  `IDPEREP` int(10) NOT NULL,
  `IDPERSONA` int(10) NOT NULL,
  `FECFIRMA` datetime DEFAULT NULL,
  `PARTIDA` varchar(50) DEFAULT NULL,
  `ZONA` int(10) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  `ID_REPRESENTANTE` int(10) DEFAULT NULL,
  PRIMARY KEY (`IDPEREP`),
  KEY `fk_t_perep_t_persona1_idx` (`IDPERSONA`),
  KEY `FK_t_perep_REPRESENTANTE` (`ID_REPRESENTANTE`),
  CONSTRAINT `FK_t_perep_REPRESENTANTE` FOREIGN KEY (`ID_REPRESENTANTE`) REFERENCES `t_persona` (`IDPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_perep`
--

/*!40000 ALTER TABLE `t_perep` DISABLE KEYS */;
INSERT INTO `t_perep` (`IDPEREP`,`IDPERSONA`,`FECFIRMA`,`PARTIDA`,`ZONA`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`,`ID_REPRESENTANTE`) VALUES 
 (1,7,NULL,'35355',57,NULL,NULL,NULL,NULL,NULL,'1',8),
 (2,7,NULL,'13133',57,NULL,NULL,NULL,NULL,NULL,'1',2),
 (3,7,NULL,'77777',57,NULL,NULL,NULL,NULL,NULL,'1',NULL);
/*!40000 ALTER TABLE `t_perep` ENABLE KEYS */;


--
-- Definition of table `t_persona`
--

DROP TABLE IF EXISTS `t_persona`;
CREATE TABLE `t_persona` (
  `IDPERSONA` int(10) NOT NULL,
  `PRINOM` varchar(50) DEFAULT NULL,
  `SEGNOM` varchar(50) DEFAULT NULL,
  `APEPAT` varchar(50) DEFAULT NULL,
  `APEMAT` varchar(50) DEFAULT NULL,
  `DOCIDENTIDAD` varchar(20) DEFAULT NULL,
  `RUC` varchar(20) DEFAULT NULL,
  `DIRECCION` varchar(200) DEFAULT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `FECNAC` datetime DEFAULT NULL,
  `ESTADOCIVIL` int(10) DEFAULT NULL,
  `CONYUGE` int(10) DEFAULT NULL,
  `NACIONALIDAD` int(10) DEFAULT NULL,
  `OCUPACION` int(10) DEFAULT NULL,
  `SEXO` int(10) DEFAULT NULL,
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDPERSONA`),
  KEY `fk_T_PERSONA_T_PERSONA1_idx` (`CONYUGE`),
  CONSTRAINT `fk_T_PERSONA_T_PERSONA1` FOREIGN KEY (`CONYUGE`) REFERENCES `t_persona` (`IDPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_persona`
--

/*!40000 ALTER TABLE `t_persona` DISABLE KEYS */;
INSERT INTO `t_persona` (`IDPERSONA`,`PRINOM`,`SEGNOM`,`APEPAT`,`APEMAT`,`DOCIDENTIDAD`,`RUC`,`DIRECCION`,`EMAIL`,`FECNAC`,`ESTADOCIVIL`,`CONYUGE`,`NACIONALIDAD`,`OCUPACION`,`SEXO`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`) VALUES 
 (1,'ANA','SANDI','TAMAQUI','ZAPATA','12345678',NULL,'DIRECION1',NULL,NULL,47,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1'),
 (2,'BARBARA','ALE','Mallqui','FALFA','12345679',NULL,'DIRECION2',NULL,NULL,47,7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1'),
 (3,'CARLOS','SAUL','ALOR','MORE','12345677',NULL,'DIRECION3',NULL,NULL,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1'),
 (4,'DIEGO',NULL,'PERALES','MORALES','12345676','12345678912','DIRECION4',NULL,NULL,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1'),
 (5,'ERNESTO',NULL,'QUINTO','TAMIA','12345675',NULL,'DIRECION5',NULL,NULL,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1'),
 (6,'FERNANDO','Pedro','ALCANTARA','TAVARES','12345674',NULL,'DIRECION6',NULL,NULL,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1'),
 (7,'GINO',NULL,'FERNADEZ','CHUMBES','12345673',NULL,'DIRECION7',NULL,NULL,47,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1'),
 (8,'HANS','OMAR','LOPEZ','SANTILLAN','12345672','12345678913','DIRECION8',NULL,NULL,47,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `t_persona` ENABLE KEYS */;


--
-- Definition of table `t_tabla`
--

DROP TABLE IF EXISTS `t_tabla`;
CREATE TABLE `t_tabla` (
  `ID` int(10) NOT NULL,
  `IDGRUPO` int(10) NOT NULL,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  `VALOR1` int(11) DEFAULT NULL,
  `ESTADO` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_tabla`
--

/*!40000 ALTER TABLE `t_tabla` DISABLE KEYS */;
INSERT INTO `t_tabla` (`ID`,`IDGRUPO`,`DESCRIPCION`,`VALOR1`,`ESTADO`) VALUES 
 (1,0,'Tipo Documento',NULL,1),
 (2,1,'DNI',NULL,1),
 (3,1,'RUC',NULL,1),
 (4,0,'Tipo Persona',NULL,1),
 (5,4,'Natural',NULL,1),
 (6,4,'Juridico',NULL,1),
 (7,0,'Rol Empleado',NULL,1),
 (8,7,'Abogado(a)',NULL,1),
 (9,7,'Digitador(a)',NULL,1),
 (10,7,'Cajero(a)',NULL,1),
 (11,7,'Asistente Legal',NULL,1),
 (12,0,'Tipo ComunicaciÃ³n',NULL,1),
 (13,12,'Celular Personal',NULL,1),
 (14,12,'Celular Empresa',NULL,1),
 (15,12,'Nextel Personal',NULL,1),
 (16,12,'Nextel Empresa',NULL,1),
 (17,12,'Telefono Fijo Casa',NULL,1),
 (18,12,'Telefono Fijo Oficina',NULL,1),
 (19,12,'Direccion Casa',NULL,1),
 (20,12,'Direccion Trabajo',NULL,1),
 (21,12,'Direccion Empresa',NULL,1),
 (22,12,'Messenger Msn',NULL,1),
 (23,12,'Email',NULL,1),
 (24,12,'Facebook',NULL,1),
 (25,12,'Pagina Web',NULL,1),
 (26,0,'Estados Tramite',NULL,1),
 (27,26,'Solicitado',NULL,1),
 (28,26,'En Proceso',NULL,1),
 (29,26,'Observado',NULL,1),
 (30,0,'Estados Comprobante',NULL,1),
 (31,30,'Pagado',NULL,1),
 (32,30,'Anulado',NULL,1),
 (33,30,'Pago Parcial',NULL,1),
 (34,30,'A CrÃ©dito Total',NULL,1),
 (35,30,'A CrÃ©dito Parcial',NULL,1),
 (36,0,'Tipo Otorgante',NULL,1),
 (37,36,'Vendedor(a)',NULL,1),
 (38,36,'Comprador(a)',NULL,1),
 (39,36,'Poderdante',NULL,1),
 (40,36,'Apoderado(a)',NULL,1),
 (41,0,'Acto',NULL,1),
 (42,41,'Compra-Venta',NULL,1),
 (43,41,'Hipoteca',NULL,1),
 (44,41,'Poder Amplio y General',NULL,1),
 (45,0,'Estado Civil',NULL,1),
 (46,45,'Soltero(a)',NULL,1),
 (47,45,'Casado(a)',NULL,1),
 (48,45,'Divorciado(a)',NULL,1),
 (49,45,'Viudo(a)',NULL,1),
 (50,0,'Nivel de Seguridad',NULL,1),
 (51,50,'Administrador',NULL,1),
 (52,50,'Usuario Cartas',NULL,1),
 (53,50,'Usuario Libros',NULL,1),
 (54,50,'Usuario Escrituras',NULL,1),
 (55,50,'Usuario Vehicular',NULL,1),
 (56,0,'Zona',NULL,1),
 (57,56,'zona1',NULL,1),
 (58,56,'zona2',NULL,1),
 (59,56,'zona3',NULL,1),
 (60,56,'zona4',NULL,1),
 (61,56,'zona5',NULL,1),
 (62,56,'zona6',NULL,1),
 (63,56,'zona7',NULL,1),
 (64,56,'zona8',NULL,1),
 (65,56,'zona9',NULL,1),
 (66,0,'Auto incremental kardex',14,1),
 (67,0,'Auto incremental minuta',11,1),
 (68,0,'Auto incremental escritura',14,1);
/*!40000 ALTER TABLE `t_tabla` ENABLE KEYS */;


--
-- Definition of table `t_usuario`
--

DROP TABLE IF EXISTS `t_usuario`;
CREATE TABLE `t_usuario` (
  `IDUSUARIO` int(10) unsigned NOT NULL,
  `USUARIO` varchar(20) NOT NULL,
  `CLAVE` varchar(100) NOT NULL,
  `NIVELSEG` int(10) DEFAULT NULL COMMENT 'NIVEL DE SEGURIDAD PARA OPCIONES DE MENUS',
  `USUCREA` varchar(20) DEFAULT NULL,
  `USUMODI` varchar(20) DEFAULT NULL,
  `FECCREA` datetime DEFAULT NULL,
  `FECMODI` datetime DEFAULT NULL,
  `PC` varchar(20) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT '1',
  PRIMARY KEY (`IDUSUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_usuario`
--

/*!40000 ALTER TABLE `t_usuario` DISABLE KEYS */;
INSERT INTO `t_usuario` (`IDUSUARIO`,`USUARIO`,`CLAVE`,`NIVELSEG`,`USUCREA`,`USUMODI`,`FECCREA`,`FECMODI`,`PC`,`ESTADO`) VALUES 
 (1,'usuario','1234',1,'',NULL,NULL,NULL,NULL,'1'),
 (2,'1245','124',1,NULL,NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `t_usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
