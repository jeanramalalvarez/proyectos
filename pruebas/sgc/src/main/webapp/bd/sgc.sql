CREATE DATABASE  IF NOT EXISTS `sgc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sgc`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: sgc
-- ------------------------------------------------------
-- Server version	5.5.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `ID_DEPARTAMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `NUMERO` int(4) NOT NULL,
  `PISO` int(2) NOT NULL,
  `OCUPACION` int(1) NOT NULL COMMENT 'HABITADO:0,INHABITADO:1,ALQUILADO:2',
  `ESTADO` int(1) NOT NULL DEFAULT '0' COMMENT 'ACTIVO:0,INACTIVO:1',
  `FEC_REGISTRO` date NOT NULL,
  `FEC_ACTUALIZACION` date DEFAULT NULL,
  PRIMARY KEY (`ID_DEPARTAMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasto`
--

DROP TABLE IF EXISTS `gasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gasto` (
  `ID_GASTO` int(11) NOT NULL AUTO_INCREMENT,
  `ANIO` int(4) NOT NULL,
  `MES` int(2) NOT NULL,
  `ESTADO` int(1) NOT NULL DEFAULT '0' COMMENT 'ACTIVO:0,INACTIVO:1',
  `FEC_REGISTRO` date NOT NULL,
  `FEC_ACTUALIZACION` date DEFAULT NULL,
  PRIMARY KEY (`ID_GASTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gasto`
--

LOCK TABLES `gasto` WRITE;
/*!40000 ALTER TABLE `gasto` DISABLE KEYS */;
/*!40000 ALTER TABLE `gasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasto_detalle`
--

DROP TABLE IF EXISTS `gasto_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gasto_detalle` (
  `ID_GASTO_DETALLE` int(11) NOT NULL,
  `ID_GASTO` int(11) NOT NULL,
  `CONCEPTO` int(11) NOT NULL,
  `IMPORTE` decimal(6,2) NOT NULL,
  PRIMARY KEY (`ID_GASTO_DETALLE`),
  KEY `fk_GASTO_DETALLE_GASTO1_idx` (`ID_GASTO`),
  CONSTRAINT `fk_GASTO_DETALLE_GASTO1` FOREIGN KEY (`ID_GASTO`) REFERENCES `gasto` (`ID_GASTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gasto_detalle`
--

LOCK TABLES `gasto_detalle` WRITE;
/*!40000 ALTER TABLE `gasto_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `gasto_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro` (
  `ID_PARAMETRO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PARAMETRO_PADRE` int(11) DEFAULT NULL,
  `CODIGO` int(3) NOT NULL,
  `VALOR` varchar(45) DEFAULT NULL,
  `NOMBRE` varchar(45) NOT NULL,
  `DESCRIPCION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_PARAMETRO`),
  UNIQUE KEY `VALOR_UNIQUE` (`VALOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `ID_PERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DEPARTAMENTO` int(11) DEFAULT NULL,
  `NOMBRES` varchar(100) NOT NULL,
  `AP_PATERNO` varchar(100) NOT NULL,
  `AP_MATERNO` varchar(100) NOT NULL,
  `FEC_NACIMIENTO` date DEFAULT NULL,
  `DNI` int(10) DEFAULT NULL,
  `TELEFONO` varchar(20) DEFAULT NULL,
  `CELULAR` varchar(20) DEFAULT NULL,
  `CORREO` varchar(45) DEFAULT NULL,
  `PARENTESCO` int(1) DEFAULT NULL,
  `TIPO` int(1) NOT NULL COMMENT 'PROPIETARIO:0,RESIDENTE:1,EMPLEADO:2',
  `ESTADO` int(1) NOT NULL DEFAULT '0' COMMENT 'ACTIVO:0,INACTIVO:1',
  `FEC_REGISTRO` date NOT NULL,
  `FEC_ACTUALIZACION` date DEFAULT NULL,
  PRIMARY KEY (`ID_PERSONA`),
  KEY `fk_PERSONA_DEPARTAMENTO_idx` (`ID_DEPARTAMENTO`),
  CONSTRAINT `fk_PERSONA_DEPARTAMENTO` FOREIGN KEY (`ID_DEPARTAMENTO`) REFERENCES `departamento` (`ID_DEPARTAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `ID_RECIBO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_GASTO` int(11) NOT NULL,
  `ID_DEPARTAMENTO` int(11) NOT NULL,
  `ANIO` int(4) NOT NULL,
  `MES` int(2) NOT NULL,
  `PROPIETARIO` varchar(300) NOT NULL,
  `DEPARTAMENTO` int(4) NOT NULL,
  `ESTADO` int(1) NOT NULL DEFAULT '0' COMMENT 'ACTIVO:0,INACTIVO:1',
  `FEC_REGISTRO` date NOT NULL,
  `FEC_ACTUALIZACION` date DEFAULT NULL,
  PRIMARY KEY (`ID_RECIBO`),
  KEY `fk_RECIBO_DEPARTAMENTO1_idx` (`ID_DEPARTAMENTO`),
  KEY `fk_RECIBO_GASTO1_idx` (`ID_GASTO`),
  CONSTRAINT `fk_RECIBO_DEPARTAMENTO1` FOREIGN KEY (`ID_DEPARTAMENTO`) REFERENCES `departamento` (`ID_DEPARTAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RECIBO_GASTO1` FOREIGN KEY (`ID_GASTO`) REFERENCES `gasto` (`ID_GASTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo_detalle`
--

DROP TABLE IF EXISTS `recibo_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo_detalle` (
  `ID_RECIBO_DETALLE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_RECIBO` int(11) NOT NULL,
  `CONCEPTO` int(11) NOT NULL,
  `IMPORTE` decimal(6,2) NOT NULL,
  `TIPO` int(1) NOT NULL COMMENT 'GASTO:0,ADICIONAL:1',
  `ESTADO` int(1) NOT NULL DEFAULT '0' COMMENT 'ACTIVO:0,INACTIVO:1',
  PRIMARY KEY (`ID_RECIBO_DETALLE`),
  KEY `fk_RECIBO_DETALLE_RECIBO1_idx` (`ID_RECIBO`),
  CONSTRAINT `fk_RECIBO_DETALLE_RECIBO1` FOREIGN KEY (`ID_RECIBO`) REFERENCES `recibo` (`ID_RECIBO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo_detalle`
--

LOCK TABLES `recibo_detalle` WRITE;
/*!40000 ALTER TABLE `recibo_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERSONA` int(11) DEFAULT NULL,
  `USUARIO` varchar(45) NOT NULL,
  `CLAVE` varchar(45) NOT NULL,
  `ROL` int(1) NOT NULL DEFAULT '0' COMMENT 'USUARIO:0,ADMINISTRADOR:1',
  `ESTADO` int(1) NOT NULL DEFAULT '0' COMMENT 'ACTIVO:0,INACTIVO:1',
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `USUARIO_UNIQUE` (`USUARIO`),
  KEY `fk_USUARIO_PERSONA1_idx` (`ID_PERSONA`),
  CONSTRAINT `fk_USUARIO_PERSONA1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,NULL,'admin','admin',1,0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-04 18:34:58
