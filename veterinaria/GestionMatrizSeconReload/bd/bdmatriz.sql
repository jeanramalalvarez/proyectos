-- MySQL dump 10.13  Distrib 5.6.27-75.0, for Linux (x86_64)
--
-- Host: localhost    Database: bdmatriz
-- ------------------------------------------------------
-- Server version	5.6.27-75.0

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
-- Current Database: `bdmatriz`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bdmatriz` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bdmatriz`;

--
-- Table structure for table `tb_almacen`
--

DROP TABLE IF EXISTS `tb_almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_almacen` (
  `int_idAlmacen` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `int_idProveedor` int(11) NOT NULL,
  `int_idProducto` int(11) NOT NULL,
  `int_idLocal` int(11) NOT NULL,
  `int_idTipoMovimiento` int(11) NOT NULL,
  `str_documento` varchar(45) NOT NULL,
  `dbl_cantidad` double NOT NULL,
  `dbl_precio` double DEFAULT NULL,
  `dbl_igv` double DEFAULT NULL,
  `dbl_subTotal` double DEFAULT NULL,
  `dbl_descuento` double DEFAULT NULL,
  `str_fechaDocumento` date NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  `dbl_stock` double DEFAULT NULL,
  PRIMARY KEY (`int_idAlmacen`),
  KEY `FK_almacenProveedorProducto` (`int_idProveedor`,`int_idProducto`),
  KEY `FK_almacenLocal` (`int_idLocal`),
  KEY `FK_almacenTipoMovimiento` (`int_idTipoMovimiento`),
  KEY `IND_DOCUMENTO` (`str_documento`) USING BTREE,
  CONSTRAINT `FK_almacenLocal` FOREIGN KEY (`int_idLocal`) REFERENCES `tb_locales` (`int_idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_almacenProveedorProducto` FOREIGN KEY (`int_idProveedor`, `int_idProducto`) REFERENCES `tb_proveedorproducto` (`int_idProveedor`, `int_idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_almacenTipoMovimiento` FOREIGN KEY (`int_idTipoMovimiento`) REFERENCES `tb_tipomovimiento` (`int_idTipoMovimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_almacen`
--

LOCK TABLES `tb_almacen` WRITE;
/*!40000 ALTER TABLE `tb_almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_asistencia`
--

DROP TABLE IF EXISTS `tb_asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_asistencia` (
  `int_asistencia` int(11) NOT NULL AUTO_INCREMENT,
  `int_idHorario` int(11) NOT NULL,
  `int_idJornada` int(11) NOT NULL,
  `int_idContrato` int(11) NOT NULL,
  `dte_fecha` datetime NOT NULL,
  `str_estadoMarcado` varchar(45) NOT NULL,
  `str_tipoMarcado` varchar(1) NOT NULL,
  PRIMARY KEY (`int_asistencia`),
  KEY `fk_tb_asistencia_tb_horarioJornadaContrato1` (`int_idHorario`,`int_idJornada`,`int_idContrato`),
  KEY `fk_tb_tipoMarcado_tb_Asistemcia` (`str_estadoMarcado`),
  KEY `fk_tb_tipoMarcado_tb_Asistencia` (`str_tipoMarcado`),
  CONSTRAINT `fk_tb_asistencia_tb_horarioJornadaContrato1` FOREIGN KEY (`int_idHorario`, `int_idJornada`, `int_idContrato`) REFERENCES `tb_horariojornadacontrato` (`int_idHorario`, `int_idJornada`, `int_idContrato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_tipoMarcado_tb_Asistencia` FOREIGN KEY (`str_tipoMarcado`) REFERENCES `tb_tipomarcado` (`int_tipoMarcado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_asistencia`
--

LOCK TABLES `tb_asistencia` WRITE;
/*!40000 ALTER TABLE `tb_asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_caja`
--

DROP TABLE IF EXISTS `tb_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_caja` (
  `int_idCaja` int(11) NOT NULL AUTO_INCREMENT,
  `str_nombre` varchar(45) NOT NULL,
  `str_descripcion` varchar(200) DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificacion` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idCaja`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_caja`
--

LOCK TABLES `tb_caja` WRITE;
/*!40000 ALTER TABLE `tb_caja` DISABLE KEYS */;
INSERT INTO `tb_caja` VALUES (1,'CAJA1','CAJA 1','ACTIVO','SISTEMAS','2012-10-23 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `tb_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cliente` (
  `int_idCliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_razonSocial` varchar(100) NOT NULL,
  `str_rucdni` varchar(11) NOT NULL,
  `str_direccion` varchar(200) DEFAULT NULL,
  `str_telefono` varchar(15) DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idCliente`),
  UNIQUE KEY `str_rucdni_UNIQUE` (`str_rucdni`),
  KEY `IND_LISTAR_CLIENTE` (`str_razonSocial`,`str_rucdni`,`str_direccion`,`str_telefono`,`str_estado`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_codigodocumento`
--

DROP TABLE IF EXISTS `tb_codigodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_codigodocumento` (
  `int_idcodigoDocumento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_codigo` varchar(45) NOT NULL,
  `int_local` int(11) NOT NULL,
  `int_documento` int(10) unsigned NOT NULL,
  PRIMARY KEY (`int_idcodigoDocumento`),
  KEY `fk_localDocumento` (`int_local`),
  KEY `fk_tipoDocumentoCodigo` (`int_documento`),
  CONSTRAINT `fk_localDocumento` FOREIGN KEY (`int_local`) REFERENCES `tb_locales` (`int_idLocal`),
  CONSTRAINT `fk_tipoDocumentoCodigo` FOREIGN KEY (`int_documento`) REFERENCES `tb_tipodocumentosalida` (`int_idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_codigodocumento`
--

LOCK TABLES `tb_codigodocumento` WRITE;
/*!40000 ALTER TABLE `tb_codigodocumento` DISABLE KEYS */;
INSERT INTO `tb_codigodocumento` VALUES (1,'010',1,1),(2,'011',1,2),(3,'012',1,3),(4,'013',1,4),(19,'015',2,1),(20,'016',2,2),(21,'017',2,3),(22,'018',2,4);
/*!40000 ALTER TABLE `tb_codigodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_config`
--

DROP TABLE IF EXISTS `tb_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_config` (
  `int_idConfig` int(11) NOT NULL AUTO_INCREMENT,
  `intMinutosProrrogaAntes` int(11) NOT NULL,
  `intMinutosProrrogaDespues` int(11) NOT NULL,
  `dblIGV` double NOT NULL,
  `dblUIT` double NOT NULL,
  `strTipoImpresora` varchar(1) NOT NULL,
  `str_formatoTicket` text,
  PRIMARY KEY (`int_idConfig`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_config`
--

LOCK TABLES `tb_config` WRITE;
/*!40000 ALTER TABLE `tb_config` DISABLE KEYS */;
INSERT INTO `tb_config` VALUES (1,10,10,18,3600,'T','12F037C0BCE8326C8373973646B811931E70F70F246DFF86A7F5D65E6663D34FFA62B30AC985EF0C6CAB39457569E2CAE2E176639718A019CE1F282AEE44B874E41087BF18313EFBBC090F59F90328CCA3F1029795CC501389F33D40A9DEEE731A81357F916F753237105FBE6DF2F35266A7AE2C7CC175BD07C6B14615EF909A2F6C13D2211588EDAD7D416E84973A55872EFBFF57FCBFDFC5A14DE90B81C36D9C52A689F49EF1F829AC6396C31A4BB74AA7AE40D6B40EF877AED2C0CA89B5EB8BF5C3AFC663E832EC89BD433EB8B04CD0D550F1A0C5DC6078FCDBF3F65445AAAEAAED2E3679896354CF125CE9993D8C6847002A7FE135B02F8ADDBD19BA6BE214F5DC41D257723AB97902B34C073B5F6B63DB68D999E221CC1FC5C7A9ADC6B5DA377EA5B62AD5C89E7B3A5AFA5924B418C8F6E4273130382B8FB27B3B845AAC5C38E24A029BB63C1D803F7321E39369B1AFD15D594E399E278E63CCF7831465E758D147DF1C9B2C7447EB44D86FBFE3163F880DA73DEDD53E0C4A8F2EA890CF7D3968BD0CBD86F954F7B57C6FEFC14AAD07DD82D37BFC074BF0D4A848C6DB5B77080436064AAED9040DF02CD2C54CDE742D8683B343E515E650E2DA8BFB6C3345A5C134F68514081FDD73634C66B7089719128ADA1D5BF54F972B52EFDD526ACCAE1994BBFB6BB5CC009A47D6C77A87A20C8A736B5CF034E16E92234F696D38A1B7AB62E6A840FBB8A3C06C42EBE78C334B68B41AA7B26684159490B62C2EC1C0A64E6815EB435785E00DE569269417EF775AEA138A70635C4E9703458FABD0A001D8AA192768D81864A8D8496AB1042497DE7BDE937221');
/*!40000 ALTER TABLE `tb_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_contrato`
--

DROP TABLE IF EXISTS `tb_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_contrato` (
  `int_idContrato` int(11) NOT NULL AUTO_INCREMENT,
  `int_idPersona` int(11) NOT NULL,
  `int_idTipoContrato` int(11) NOT NULL,
  `int_idEmpresa` int(11) NOT NULL,
  `dte_fechaInicial` date DEFAULT NULL,
  `dte_fechaFinal` date DEFAULT NULL,
  `dbl_sueldo` double DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_ultimaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_observacion` text,
  `int_local` int(11) DEFAULT NULL,
  PRIMARY KEY (`int_idContrato`),
  KEY `fk_tb_contrato_tb_persona1` (`int_idPersona`),
  KEY `fk_tb_contrato_tb_tipoContrato1` (`int_idTipoContrato`),
  KEY `fk_tb_contrato_tb_empresa1` (`int_idEmpresa`),
  CONSTRAINT `fk_tb_contrato_tb_empresa1` FOREIGN KEY (`int_idEmpresa`) REFERENCES `tb_empresa` (`int_idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_contrato_tb_persona1` FOREIGN KEY (`int_idPersona`) REFERENCES `tb_persona` (`int_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_contrato_tb_tipoContrato1` FOREIGN KEY (`int_idTipoContrato`) REFERENCES `tb_tipocontrato` (`int_idTipoContrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_contrato`
--

LOCK TABLES `tb_contrato` WRITE;
/*!40000 ALTER TABLE `tb_contrato` DISABLE KEYS */;
INSERT INTO `tb_contrato` VALUES (1,1,1,1,'2015-12-05','2016-07-29',90000,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `tb_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cronogramapagos`
--

DROP TABLE IF EXISTS `tb_cronogramapagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cronogramapagos` (
  `int_idCronogramaPagos` int(11) NOT NULL AUTO_INCREMENT,
  `int_idObligacionesPago` int(11) NOT NULL,
  `str_numeroLetra` varchar(45) DEFAULT NULL,
  `str_fechaEmision` varchar(45) DEFAULT NULL,
  `int_diasCalendario` varchar(45) DEFAULT NULL,
  `str_fechaVencimiento` varchar(45) DEFAULT NULL,
  `dbl_monto` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idCronogramaPagos`),
  KEY `fk_tb_obligacionesPago` (`int_idObligacionesPago`),
  CONSTRAINT `fk_tb_obligacionesPago` FOREIGN KEY (`int_idObligacionesPago`) REFERENCES `tb_obligacionespago` (`int_idObligacionesPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cronogramapagos`
--

LOCK TABLES `tb_cronogramapagos` WRITE;
/*!40000 ALTER TABLE `tb_cronogramapagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cronogramapagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_datosacademicos`
--

DROP TABLE IF EXISTS `tb_datosacademicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_datosacademicos` (
  `int_idDatosAcademicos` int(11) NOT NULL AUTO_INCREMENT,
  `int_idPersona` int(11) NOT NULL,
  `str_nivel` varchar(45) DEFAULT NULL,
  `str_institucionEducativa` varchar(45) DEFAULT NULL,
  `dte_inicio` date DEFAULT NULL,
  `dte_termino` date DEFAULT NULL,
  `str_observacion` varchar(45) DEFAULT NULL,
  `str_gradoTitulo` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_ultimaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idDatosAcademicos`),
  KEY `fk_tb_datosAcademicos_tb_persona` (`int_idPersona`),
  CONSTRAINT `fk_tb_datosAcademicos_tb_persona` FOREIGN KEY (`int_idPersona`) REFERENCES `tb_persona` (`int_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_datosacademicos`
--

LOCK TABLES `tb_datosacademicos` WRITE;
/*!40000 ALTER TABLE `tb_datosacademicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_datosacademicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_datosfamiliares`
--

DROP TABLE IF EXISTS `tb_datosfamiliares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_datosfamiliares` (
  `int_idDatosFamiliares` int(11) NOT NULL AUTO_INCREMENT,
  `int_idPersona` int(11) NOT NULL,
  `str_documento` varchar(45) DEFAULT NULL,
  `str_numeroDocumento` varchar(15) DEFAULT NULL,
  `str_apePaterno` varchar(45) DEFAULT NULL,
  `str_apeMaterno` varchar(45) DEFAULT NULL,
  `str_nombres` varchar(45) DEFAULT NULL,
  `dte_fechaNacimiento` date DEFAULT NULL,
  `str_vinculo` varchar(45) DEFAULT NULL,
  `str_ocupacion` varchar(45) DEFAULT NULL,
  `str_conviven` char(1) DEFAULT NULL,
  `str_telfEmergencia` varchar(15) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_ultimaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idDatosFamiliares`),
  KEY `fk_tb_datosFamiliares_tb_persona1` (`int_idPersona`),
  CONSTRAINT `fk_tb_datosFamiliares_tb_persona1` FOREIGN KEY (`int_idPersona`) REFERENCES `tb_persona` (`int_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_datosfamiliares`
--

LOCK TABLES `tb_datosfamiliares` WRITE;
/*!40000 ALTER TABLE `tb_datosfamiliares` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_datosfamiliares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalleguia`
--

DROP TABLE IF EXISTS `tb_detalleguia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detalleguia` (
  `int_idGuiaremision` int(11) NOT NULL,
  `int_idProducto` int(11) NOT NULL,
  `dbl_cantidadProducto` double DEFAULT NULL,
  `str_descripcionProducto` varchar(200) DEFAULT NULL,
  `dbl_peso` double DEFAULT NULL,
  `dbl_costoTraslado` double DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `int_idProveedor` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`int_idGuiaremision`,`int_idProducto`),
  KEY `fk_tb_detalleguia_1` (`int_idGuiaremision`),
  KEY `fk_tb_detalleguia_2` (`int_idProducto`),
  CONSTRAINT `fk_tb_detalleguia_1` FOREIGN KEY (`int_idGuiaremision`) REFERENCES `tb_guiaremision` (`int_idGuiaremision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_detalleguia_2` FOREIGN KEY (`int_idProducto`) REFERENCES `tb_producto` (`int_idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalleguia`
--

LOCK TABLES `tb_detalleguia` WRITE;
/*!40000 ALTER TABLE `tb_detalleguia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detalleguia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_documentoventa`
--

DROP TABLE IF EXISTS `tb_documentoventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_documentoventa` (
  `int_idDocumentoVenta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `int_correlativo` int(10) unsigned NOT NULL,
  `int_codigoDocumento` int(10) unsigned NOT NULL,
  `db_total` double NOT NULL,
  PRIMARY KEY (`int_idDocumentoVenta`),
  KEY `fk_codigoDocumento` (`int_codigoDocumento`),
  CONSTRAINT `fk_codigoDocumento` FOREIGN KEY (`int_codigoDocumento`) REFERENCES `tb_codigodocumento` (`int_idcodigoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_documentoventa`
--

LOCK TABLES `tb_documentoventa` WRITE;
/*!40000 ALTER TABLE `tb_documentoventa` DISABLE KEYS */;
INSERT INTO `tb_documentoventa` VALUES (1,1000,1,0),(2,1000,2,0),(3,1000,3,0),(4,1000,4,0),(9,100,19,0),(10,100,20,0),(11,100,21,0),(12,100,22,0);
/*!40000 ALTER TABLE `tb_documentoventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empresa`
--

DROP TABLE IF EXISTS `tb_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_empresa` (
  `int_idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `str_razonSocial` varchar(100) DEFAULT NULL,
  `str_ruc` varchar(12) DEFAULT NULL,
  `str_domicilioEmpresa` varchar(150) DEFAULT NULL,
  `str_representanteLegal` varchar(150) DEFAULT NULL,
  `str_dniRepresentante` varchar(10) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empresa`
--

LOCK TABLES `tb_empresa` WRITE;
/*!40000 ALTER TABLE `tb_empresa` DISABLE KEYS */;
INSERT INTO `tb_empresa` VALUES (1,'Clínica Veterinaria Mascotas Felices','10452579834','HUALLAGA 178, IQUITOS, LORETO (PE)','Percy Cardenas Claudio','45257983','ACTIVO','2014-08-23','SISTEMA',NULL,NULL);
/*!40000 ALTER TABLE `tb_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_experiencialaboral`
--

DROP TABLE IF EXISTS `tb_experiencialaboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_experiencialaboral` (
  `int_idExperienciaLaboral` int(11) NOT NULL AUTO_INCREMENT,
  `int_idPersona` int(11) NOT NULL,
  `str_empresa` varchar(45) DEFAULT NULL,
  `str_rubro` varchar(45) DEFAULT NULL,
  `str_cargo` varchar(45) DEFAULT NULL,
  `str_funciones` varchar(45) DEFAULT NULL,
  `dte_fechaInicio` date DEFAULT NULL,
  `dte_fechaFin` date DEFAULT NULL,
  `str_sueldo` varchar(45) DEFAULT NULL,
  `str_jefeInmediato` varchar(45) DEFAULT NULL,
  `str_telfEmpresa` varchar(10) DEFAULT NULL,
  `str_motivoCese` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idExperienciaLaboral`),
  KEY `fk_tb_experienciaLaboral_tb_persona1` (`int_idPersona`),
  CONSTRAINT `fk_tb_experienciaLaboral_tb_persona1` FOREIGN KEY (`int_idPersona`) REFERENCES `tb_persona` (`int_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_experiencialaboral`
--

LOCK TABLES `tb_experiencialaboral` WRITE;
/*!40000 ALTER TABLE `tb_experiencialaboral` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_experiencialaboral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_facturacompra`
--

DROP TABLE IF EXISTS `tb_facturacompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_facturacompra` (
  `int_idFacturaCompra` int(11) NOT NULL AUTO_INCREMENT,
  `str_numeroFactura` varchar(45) NOT NULL,
  `str_numeroGuia` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idFacturaCompra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_facturacompra`
--

LOCK TABLES `tb_facturacompra` WRITE;
/*!40000 ALTER TABLE `tb_facturacompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_facturacompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_familia`
--

DROP TABLE IF EXISTS `tb_familia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_familia` (
  `int_idFamilia` int(11) NOT NULL AUTO_INCREMENT,
  `str_codigoFamilia` varchar(45) DEFAULT NULL,
  `str_nombre` varchar(45) NOT NULL,
  `str_descripcion` varchar(100) DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `dte_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificacion` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idFamilia`),
  UNIQUE KEY `str_codigoFamilia_UNIQUE` (`str_codigoFamilia`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_familia`
--

LOCK TABLES `tb_familia` WRITE;
/*!40000 ALTER TABLE `tb_familia` DISABLE KEYS */;
INSERT INTO `tb_familia` VALUES (1,'F1','ANTIMICOTICO','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(2,'F2','ACARICIDAS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(3,'F3','ACCESORIOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(4,'F4','ALIMENTOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(5,'F5','ANESTESICO','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(6,'F6','ANTIBIOTICO','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(7,'F7','ANTIDOTOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(8,'F8','ANTIEMETICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(9,'F9','ANTIFLAMATORIO','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(10,'F10','ANTINEOPLASICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(11,'F11','ANTIPARASITARIOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(12,'F12','ANTIPIRETICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(13,'F13','DESINFECTANTES  -  ANTISEPTICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(14,'F14','DIURETICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(15,'F15','ESPECTORANTES','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(16,'F16','ESTETICA','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(17,'F17','EUTANASICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(18,'F18','HORMONAS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(19,'F19','INMUNOLOGICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(20,'F20','INSECTICIDA','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(21,'F21','INSUMOS MEDICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(22,'F22','LECHE MATERNIZADA','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(23,'F23','MINERALES','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(24,'F24','MULTIVITAMINICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(25,'F25','OXITOCICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(26,'F26','PREPARACIONES OFSTALMICAS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(27,'F27','RELAJANTES MUSCULARES','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(28,'F28','ROPA','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(29,'F29','SOLUCIONES CORECTORAS  DE TRANSTORNOS HIDRICO','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(30,'F30','TRANQUILIZANTES','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(31,'F31','RATICIDAS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(32,'F32','LARVICIDAS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(33,'F33','ANALGESICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(34,'F35','ANTIANÉMICO','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(35,'F34','DERMATOLOGICOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(36,'F36','VITAMINAS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(37,'F37','ANTIHEMORRÁGICO','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(38,'F38','ANTIULCEROSOS','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(39,'F39','NEORAL','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(40,'F40','DILATOR VAGINAL','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(41,'F41','PROTECTOR DIGESTIVO COORDINA CON ZULMA','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL),(42,'F42','VACIO','','ACTIVO','SISTEMA','2012-09-24 13:59:15',NULL,NULL);
/*!40000 ALTER TABLE `tb_familia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_flujocaja`
--

DROP TABLE IF EXISTS `tb_flujocaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_flujocaja` (
  `int_idFlujoCaja` int(11) NOT NULL AUTO_INCREMENT,
  `int_idLocal` int(11) NOT NULL,
  `int_idCaja` int(11) NOT NULL,
  `dbl_cantidadSoles` double NOT NULL,
  `dbl_cantidadDolares` double DEFAULT NULL,
  `dbl_cantidadTotalSoles` double NOT NULL,
  `dbl_cantidadDiferencia` double DEFAULT NULL,
  `str_motivo` varchar(45) NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `dte_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` datetime DEFAULT NULL,
  `str_nroDocumento` varchar(45) DEFAULT NULL,
  `str_numeroSerieImpresora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idFlujoCaja`),
  KEY `fk_tb_locales` (`int_idLocal`),
  KEY `fk_tb_caja` (`int_idCaja`),
  CONSTRAINT `fk_tb_caja` FOREIGN KEY (`int_idCaja`) REFERENCES `tb_caja` (`int_idCaja`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_locales` FOREIGN KEY (`int_idLocal`) REFERENCES `tb_locales` (`int_idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_flujocaja`
--

LOCK TABLES `tb_flujocaja` WRITE;
/*!40000 ALTER TABLE `tb_flujocaja` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_flujocaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_funciones`
--

DROP TABLE IF EXISTS `tb_funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_funciones` (
  `int_idFunciones` int(11) NOT NULL AUTO_INCREMENT,
  `str_rol` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_ultimaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `int_modulo` int(11) NOT NULL,
  `str_key` varchar(10) NOT NULL,
  PRIMARY KEY (`int_idFunciones`),
  KEY `fk_tb_funciones_tb_modulo1` (`int_modulo`),
  CONSTRAINT `fk_tb_funciones_tb_modulo1` FOREIGN KEY (`int_modulo`) REFERENCES `tb_modulo` (`int_modulo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_funciones`
--

LOCK TABLES `tb_funciones` WRITE;
/*!40000 ALTER TABLE `tb_funciones` DISABLE KEYS */;
INSERT INTO `tb_funciones` VALUES (1,'Registrar Personal','2012-04-16','SISTEMAS',NULL,NULL,1,'10001'),(2,'Consultar Personal','2012-04-16','SISTEMAS',NULL,NULL,1,'10002'),(3,'Modificar Personal','2012-04-16','SISTEMAS',NULL,NULL,1,'10003'),(4,'Nuevo Usuario','2012-04-16','SISTEMAS',NULL,NULL,6,'10004'),(5,'Modificar Usuario','2012-04-16','SISTEMAS',NULL,NULL,6,'10005'),(6,'Generar Contrato','2012-04-16','SISTEMAS',NULL,NULL,1,'10006'),(7,'Renovar Contrato','2012-04-16','SISTEMAS',NULL,NULL,1,'10007'),(8,'Cancelar Contrato','2012-04-16','SISTEMAS',NULL,NULL,1,'10008'),(9,'Generar Memorandum','2012-04-16','SISTEMAS',NULL,NULL,1,'10009'),(10,'Consultar Memorandum','2012-04-16','SISTEMAS',NULL,NULL,1,'10010'),(11,'Cancelar Memorandum','2012-04-16','SISTEMAS',NULL,NULL,1,'10011'),(12,'Solicitar Permiso','2012-04-16','SISTEMAS',NULL,NULL,1,'10012'),(13,'Aprobar Permisos','2012-04-16','SISTEMAS',NULL,NULL,1,'10013'),(14,'Consultar Permiso','2012-04-16','SISTEMAS',NULL,NULL,1,'10014'),(15,'Ingreso al Sistema','2012-04-16','SISTEMAS',NULL,NULL,6,'10015'),(16,'Administracion de Funciones','2012-04-16','SISTEMAS',NULL,NULL,6,'10016'),(17,'Consultar Contrato','2012-05-16','SISTEMAS',NULL,NULL,1,'10017'),(18,'Generar Horario','2012-05-16','SISTEMAS',NULL,NULL,1,'10018'),(19,'Reporte Asistencia','2012-05-16','SISTEMAS',NULL,NULL,1,'10019'),(20,'Reporte Memorandum','2012-05-16','SISTEMAS',NULL,NULL,1,'10020'),(21,'Reporte Permisos','2012-05-16','SISTEMAS',NULL,NULL,1,'10021'),(22,'Reporte Funciones','2012-05-16','SISTEMAS',NULL,NULL,1,'10022'),(23,'Emitir Carta de Credenciales','2012-05-16','SISTEMAS',NULL,NULL,6,'10023'),(24,'AdministraciÃ³n de Faltas','2012-05-16','SISTEMAS',NULL,NULL,1,'10024'),(25,'Generar Solicitud de Compras','2012-05-16','SISTEMAS',NULL,NULL,3,'10025'),(26,'Aprobar Solicitud de Compras','2012-05-16','SISTEMAS',NULL,NULL,3,'10026'),(27,'Cancelar Solicitud de Compras','2012-05-16','SISTEMAS',NULL,NULL,3,'10027'),(28,'Generar Orden de Compra','2012-05-16','SISTEMAS',NULL,NULL,3,'10028'),(29,'Aprobar Orden de Compra ','2012-05-16','SISTEMAS',NULL,NULL,3,'10029'),(30,'Cancelar Orden de Compra','2012-05-16','SISTEMAS',NULL,NULL,3,'10030'),(31,'Ingresar Factura de Compra','2012-05-16','SISTEMAS',NULL,NULL,3,'10031'),(32,'Consultar Factura de Compra','2012-05-16','SISTEMAS',NULL,NULL,3,'10032'),(33,'Rechazar Factura de Compra','2012-05-16','SISTEMAS',NULL,NULL,3,'10033'),(34,'Generar Conformidad Compra','2012-05-16','SISTEMAS',NULL,NULL,3,'10034'),(35,'Aprobar Conformidad de Compra','2012-05-16','SISTEMAS',NULL,NULL,3,'10035'),(36,'Observar Conformidad de Compra','2012-05-16','SISTEMAS',NULL,NULL,3,'10036'),(37,'Ingresar Tipo de Cambio','2012-08-27','SISTEMAS','0000-00-00','',2,'10037'),(38,'Registrar Precio','2012-10-31','SISTEMAS',NULL,NULL,3,'10038'),(39,'Conformidad de Compra','2012-10-31','SISTEMAS',NULL,NULL,3,'10039'),(40,'Registrar Familia','2012-10-31','SISTEMAS',NULL,NULL,3,'10040'),(41,'Modificar Familia','2012-10-31','SISTEMAS',NULL,NULL,3,'10041'),(42,'Registrar Producto','2012-10-31','SISTEMAS',NULL,NULL,3,'10042'),(43,'Modificar Producto','2012-10-31','SISTEMAS',NULL,NULL,3,'10043'),(44,'Asignar Producto Proveedor','2012-10-31','SISTEMAS',NULL,NULL,3,'10044'),(45,'Registrar Proveedor','2012-10-31','SISTEMAS',NULL,NULL,3,'10045'),(46,'Modificar Proveedor','2012-10-31','SISTEMAS',NULL,NULL,3,'10046'),(47,'Registrar Unidad Medida','2012-10-31','SISTEMAS',NULL,NULL,3,'10047'),(48,'Modificar Unidad Medida','2012-10-31','SISTEMAS',NULL,NULL,3,'10048'),(49,'Modificar Medida Rotacion','2012-10-31','SISTEMAS',NULL,NULL,3,'10049'),(50,'Programar Letras','2012-10-31','SISTEMAS',NULL,NULL,3,'10050'),(51,'Registrar Recepcion Mercaderia','2012-10-31','SISTEMAS',NULL,NULL,3,'10051'),(52,'Registrar Conformidad','2012-10-31','SISTEMAS',NULL,NULL,3,'10052'),(53,'Reporte Proveedor Producto','2012-10-31','SISTEMAS',NULL,NULL,3,'10053'),(54,'Reporte Compras','2012-10-31','SISTEMAS',NULL,NULL,3,'10054'),(55,'Reporte Detallado Compras','2012-10-31','SISTEMAS',NULL,NULL,3,'10055'),(56,'Reporte Producto mas Comprado','2012-10-31','SISTEMAS',NULL,NULL,3,'10056'),(57,'Reporte Proveedor mas Comprado','2012-10-31','SISTEMAS',NULL,NULL,3,'10057'),(58,'Reporte Familia','2012-10-31','SISTEMAS',NULL,NULL,3,'10058'),(59,'Reporte Familia Global','2012-10-31','SISTEMAS',NULL,NULL,3,'10059'),(60,'Reporte Almacen','2012-10-31','SISTEMAS',NULL,NULL,3,'10060'),(61,'Reporte Rotacion','2012-10-31','SISTEMAS',NULL,NULL,3,'10061'),(62,'Reporte Reintegro','2012-10-31','SISTEMAS',NULL,NULL,3,'10062'),(63,'Reporte Reintegro Global','2012-10-31','SISTEMAS',NULL,NULL,3,'10063'),(64,'Reporte Traspaso y Guia Local','2012-10-31','SISTEMAS',NULL,NULL,3,'10064'),(65,'Reporte Traspaso y Guia Fecha','2012-10-31','SISTEMAS',NULL,NULL,3,'10065'),(66,'Traspaso Autorizar','2012-10-31','SISTEMAS',NULL,NULL,3,'10066'),(67,'Traspaso Confirmar Llegada','2012-10-31','SISTEMAS',NULL,NULL,3,'10067'),(68,'Anular Documento Venta','2012-10-31','SISTEMAS',NULL,NULL,2,'10068'),(69,'Apertura Caja','2012-10-31','SISTEMAS',NULL,NULL,2,'10069'),(70,'Enviar Facturacion Proforma','2012-10-31','SISTEMAS',NULL,NULL,2,'10070'),(71,'Vender documento','2012-10-31','SISTEMAS',NULL,NULL,2,'10071'),(72,'Suprimir Documento','2012-10-31','SISTEMAS',NULL,NULL,2,'10072'),(73,'Vender Realizar','2012-10-31','SISTEMAS',NULL,NULL,2,'10073'),(74,'Cerrar Caja','2012-10-31','SISTEMAS',NULL,NULL,2,'10074'),(75,'Cliente Registrar','2012-10-31','SISTEMAS',NULL,NULL,2,'10075'),(76,'Cliente Modificar','2012-10-31','SISTEMAS',NULL,NULL,2,'10076'),(77,'Cliente Inactivar','2012-10-31','SISTEMAS',NULL,NULL,2,'10077'),(78,'Guia Registrar','2012-10-31','SISTEMAS',NULL,NULL,2,'10078'),(79,'Guia Generar Traspaso','2012-10-31','SISTEMAS',NULL,NULL,2,'10079'),(80,'Guia Imprimir','2012-10-31','SISTEMAS',NULL,NULL,2,'10080'),(81,'Preventa Vender','2012-10-31','SISTEMAS',NULL,NULL,2,'10081'),(82,'Preventa Realizar Proforma','2012-10-31','SISTEMAS',NULL,NULL,2,'10082'),(83,'Cargar Producto','2012-10-31','SISTEMAS',NULL,NULL,2,'10083'),(84,'Reporte Ventas Vendedor','2012-10-31','SISTEMAS',NULL,NULL,2,'10084'),(85,'Reporte Ventas Vendedor Fechas','2012-10-31','SISTEMAS',NULL,NULL,2,'10085'),(86,'Reporte Ventas Factura Tienda','2012-10-31','SISTEMAS',NULL,NULL,2,'10086'),(87,'Reporte Ventas Boleta Tienda','2012-10-31','SISTEMAS',NULL,NULL,2,'10087'),(88,'Reporte Ventas Global','2012-10-31','SISTEMAS',NULL,NULL,2,'10088'),(89,'Reporte Grafico Venta tianda','2012-10-31','SISTEMAS',NULL,NULL,2,'10089'),(90,'Reporte Grafico Ventas Evolucion','2012-10-31','SISTEMAS',NULL,NULL,2,'10090'),(91,'Venta Buscar Producto','2012-10-31','SISTEMAS',NULL,NULL,2,'10091'),(92,'Venta Quitar Producto','2012-10-31','SISTEMAS',NULL,NULL,2,'10092'),(93,'Venta EnviarVenta','2012-10-31','SISTEMAS',NULL,NULL,2,'10093'),(94,'Venta Buscar Proforma','2012-10-31','SISTEMAS',NULL,NULL,2,'10094'),(95,'Venta Consultar Venta','2012-10-31','SISTEMAS',NULL,NULL,2,'10095'),(96,'Venta Consultar mis Ventas','2012-10-31','SISTEMAS',NULL,NULL,2,'10096'),(97,'Cajero Responsable Tienda','2012-11-12','SISTEMAS',NULL,NULL,2,'10097'),(98,'Configuracion Inicial','2012-11-12','SISTEMAS',NULL,NULL,6,'10098'),(99,'Gestion Ticketeras','2012-11-12','SISTEMAS',NULL,NULL,6,'10099');
/*!40000 ALTER TABLE `tb_funciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_funcionusuario`
--

DROP TABLE IF EXISTS `tb_funcionusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_funcionusuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `int_idFunciones` int(11) NOT NULL,
  `int_idUsuario` int(11) NOT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_ultimaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`int_idFunciones`,`int_idUsuario`),
  KEY `fk_tb_funciones_has_tb_usuario_tb_usuario1` (`int_idUsuario`),
  KEY `fk_tb_funciones_has_tb_usuario_tb_funciones1` (`int_idFunciones`),
  KEY `index_estado` (`str_estado`),
  CONSTRAINT `fk_tb_funciones_has_tb_usuario_tb_funciones1` FOREIGN KEY (`int_idFunciones`) REFERENCES `tb_funciones` (`int_idFunciones`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_funciones_has_tb_usuario_tb_usuario1` FOREIGN KEY (`int_idUsuario`) REFERENCES `tb_usuario` (`int_idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_funcionusuario`
--

LOCK TABLES `tb_funcionusuario` WRITE;
/*!40000 ALTER TABLE `tb_funcionusuario` DISABLE KEYS */;
INSERT INTO `tb_funcionusuario` VALUES (1,1,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(2,2,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(3,3,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(4,4,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(5,5,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(6,6,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(7,7,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(8,8,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(9,9,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(10,10,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(11,11,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(12,12,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(13,13,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(14,14,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(15,15,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(16,16,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(17,17,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(18,18,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(19,19,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(20,20,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(21,21,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(22,22,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(23,23,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(24,24,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(25,25,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(26,26,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(27,27,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(28,28,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(29,29,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(30,30,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(31,31,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(32,32,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(33,33,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(34,34,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(35,35,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(36,36,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(37,37,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(38,38,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(39,39,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(40,40,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(41,41,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(42,42,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(43,43,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(44,44,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(45,45,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(46,46,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(47,47,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(48,48,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(49,49,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(50,50,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(51,51,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(52,52,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(53,53,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(54,54,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(55,55,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(56,56,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(57,57,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(58,58,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(59,59,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(60,60,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(61,61,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(62,62,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(63,63,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(64,64,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(65,65,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(66,66,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(67,67,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(68,68,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(69,69,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(70,70,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(71,71,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(72,72,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(73,73,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(74,74,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(75,75,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(76,76,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(77,77,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(78,78,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(79,79,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(80,80,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(81,81,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(82,82,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(83,83,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(84,84,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(85,85,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(86,86,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(87,87,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(88,88,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(89,89,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(90,90,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(91,91,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(92,92,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(93,93,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(94,94,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(95,95,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(96,96,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(97,97,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(98,98,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(99,99,1,'2015-10-01','YTP',NULL,NULL,'ACTIVO'),(100,1,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(101,2,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(102,3,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(103,6,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(104,7,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(105,8,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(106,9,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(107,10,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(108,11,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(109,12,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(110,13,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(111,14,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(112,17,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(113,18,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(114,19,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(115,20,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(116,21,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(117,22,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(118,24,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(119,37,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(120,68,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(121,69,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(122,70,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(123,71,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(124,72,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(125,73,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(126,74,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(127,75,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(128,76,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(129,77,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(130,78,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(131,79,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(132,80,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(133,81,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(134,82,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(135,83,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(136,84,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(137,85,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(138,86,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(139,87,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(140,88,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(141,89,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(142,90,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(143,91,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(144,92,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(145,93,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(146,94,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(147,95,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(148,96,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(149,97,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(150,25,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(151,26,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(152,27,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(153,28,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(154,29,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(155,30,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(156,31,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(157,32,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(158,33,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(159,34,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(160,35,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(161,36,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(162,38,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(163,39,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(164,40,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(165,41,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(166,42,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(167,43,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(168,44,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(169,45,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(170,46,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(171,47,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(172,48,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(173,49,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(174,50,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(175,51,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(176,52,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(177,53,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(178,54,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(179,55,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(180,56,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(181,57,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(182,58,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(183,59,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(184,60,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(185,61,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(186,62,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(187,63,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(188,64,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(189,65,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(190,66,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(191,67,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(192,4,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(193,5,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(194,15,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(195,16,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(196,23,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(197,98,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO'),(198,99,2,'2015-12-05','SYSADMIN',NULL,NULL,'ACTIVO');
/*!40000 ALTER TABLE `tb_funcionusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_guiaremision`
--

DROP TABLE IF EXISTS `tb_guiaremision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_guiaremision` (
  `int_idGuiaremision` int(11) NOT NULL AUTO_INCREMENT,
  `str_numeroGuia` varchar(45) NOT NULL,
  `dte_fechaEmision` date DEFAULT NULL,
  `dte_fechaInicioTraslado` date DEFAULT NULL,
  `str_motivoTraslado` varchar(45) DEFAULT NULL,
  `str_domicilioPartida` text NOT NULL,
  `str_domicilioLlegada` text NOT NULL,
  `str_placaMarcaVehiculo` varchar(45) DEFAULT NULL,
  `str_inscripcionVehiculo` varchar(45) DEFAULT NULL,
  `str_breveteConductor` varchar(45) DEFAULT NULL,
  `str_destinatarioNombre` varchar(45) DEFAULT NULL,
  `str_destinatarioRuc` varchar(45) DEFAULT NULL,
  `str_destinatarioDireccion` varchar(45) DEFAULT NULL,
  `str_comprobantePago` varchar(45) DEFAULT NULL,
  `str_nroComprobante` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_localPartida` varchar(45) DEFAULT NULL,
  `str_localLlegada` varchar(45) DEFAULT NULL,
  `str_rucTransportista` varchar(11) DEFAULT NULL,
  `str_nombreTransportista` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`int_idGuiaremision`),
  UNIQUE KEY `str_numeroGuia_UNIQUE` (`str_numeroGuia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_guiaremision`
--

LOCK TABLES `tb_guiaremision` WRITE;
/*!40000 ALTER TABLE `tb_guiaremision` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_guiaremision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_horario`
--

DROP TABLE IF EXISTS `tb_horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_horario` (
  `int_idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `str_nombreHorario` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_usuarioModifcador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idHorario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_horario`
--

LOCK TABLES `tb_horario` WRITE;
/*!40000 ALTER TABLE `tb_horario` DISABLE KEYS */;
INSERT INTO `tb_horario` VALUES (1,'LUNES','ACTIVO','2012-05-17','SISTEMAS',NULL,NULL),(2,'MARTES','ACTIVO','2012-05-17','SISTEMAS',NULL,NULL),(3,'MIERCOLES','ACTIVO','2012-05-17','SISTEMAS',NULL,NULL),(4,'JUEVES','ACTIVO','2012-05-17','SISTEMAS',NULL,NULL),(5,'VIERNES','ACTIVO','2012-05-17','SISTEMAS',NULL,NULL),(6,'SABADO','ACTIVO','2012-05-17','SISTEMAS',NULL,NULL),(7,'DOMINGO','ACTIVO','2012-05-17','SISTEMAS',NULL,NULL);
/*!40000 ALTER TABLE `tb_horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_horariojornada`
--

DROP TABLE IF EXISTS `tb_horariojornada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_horariojornada` (
  `int_idHorario` int(11) NOT NULL,
  `int_idJornada` int(11) NOT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idHorario`,`int_idJornada`),
  KEY `fk_tb_horario_has_tb_jornada_tb_jornada1` (`int_idJornada`),
  KEY `fk_tb_horario_has_tb_jornada_tb_horario1` (`int_idHorario`),
  CONSTRAINT `fk_tb_horario_has_tb_jornada_tb_horario1` FOREIGN KEY (`int_idHorario`) REFERENCES `tb_horario` (`int_idHorario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_horario_has_tb_jornada_tb_jornada1` FOREIGN KEY (`int_idJornada`) REFERENCES `tb_jornada` (`int_idJornada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_horariojornada`
--

LOCK TABLES `tb_horariojornada` WRITE;
/*!40000 ALTER TABLE `tb_horariojornada` DISABLE KEYS */;
INSERT INTO `tb_horariojornada` VALUES (1,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(2,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(3,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(4,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(5,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL);
/*!40000 ALTER TABLE `tb_horariojornada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_horariojornadacontrato`
--

DROP TABLE IF EXISTS `tb_horariojornadacontrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_horariojornadacontrato` (
  `int_idHorario` int(11) NOT NULL,
  `int_idJornada` int(11) NOT NULL,
  `int_idContrato` int(11) NOT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idHorario`,`int_idJornada`,`int_idContrato`),
  KEY `fk_tb_horarioJornada_has_tb_contrato_tb_contrato1` (`int_idContrato`),
  KEY `fk_tb_horarioJornada_has_tb_contrato_tb_horarioJornada1` (`int_idHorario`,`int_idJornada`),
  CONSTRAINT `fk_tb_horarioJornada_has_tb_contrato_tb_contrato1` FOREIGN KEY (`int_idContrato`) REFERENCES `tb_contrato` (`int_idContrato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_horarioJornada_has_tb_contrato_tb_horarioJornada1` FOREIGN KEY (`int_idHorario`, `int_idJornada`) REFERENCES `tb_horariojornada` (`int_idHorario`, `int_idJornada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_horariojornadacontrato`
--

LOCK TABLES `tb_horariojornadacontrato` WRITE;
/*!40000 ALTER TABLE `tb_horariojornadacontrato` DISABLE KEYS */;
INSERT INTO `tb_horariojornadacontrato` VALUES (1,1,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(2,1,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(3,1,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(4,1,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(5,1,1,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL);
/*!40000 ALTER TABLE `tb_horariojornadacontrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_impresora`
--

DROP TABLE IF EXISTS `tb_impresora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_impresora` (
  `int_idImpresora` int(11) NOT NULL AUTO_INCREMENT,
  `int_local` int(11) NOT NULL,
  `str_nombre` varchar(100) NOT NULL,
  `str_marca` varchar(45) NOT NULL,
  `str_modelo` varchar(45) NOT NULL,
  `str_numeroSerie` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date NOT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  PRIMARY KEY (`int_idImpresora`),
  KEY `fk_local_idx` (`int_local`),
  CONSTRAINT `fk_local` FOREIGN KEY (`int_local`) REFERENCES `tb_locales` (`int_idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_impresora`
--

LOCK TABLES `tb_impresora` WRITE;
/*!40000 ALTER TABLE `tb_impresora` DISABLE KEYS */;
INSERT INTO `tb_impresora` VALUES (4,1,'TICKET-TUPAC 190','BIXOLON','BIXOLON','PSSFIKA15070212','YTP',NULL,'2015-10-04',NULL,'ASIGNADO'),(5,2,'TICKETERA II','BIXOLON','BIXOLON','PSSFIKA15070213','YTP',NULL,'2015-10-10',NULL,'ASIGNADO');
/*!40000 ALTER TABLE `tb_impresora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_jornada`
--

DROP TABLE IF EXISTS `tb_jornada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_jornada` (
  `int_idJornada` int(11) NOT NULL AUTO_INCREMENT,
  `tme_HoraInicio` time DEFAULT NULL,
  `tme_horaFin` time DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idJornada`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_jornada`
--

LOCK TABLES `tb_jornada` WRITE;
/*!40000 ALTER TABLE `tb_jornada` DISABLE KEYS */;
INSERT INTO `tb_jornada` VALUES (1,'08:00:00','18:00:00','ACTIVO','2015-12-05','SYSADMIN',NULL,NULL),(2,'08:00:00','18:00:00','ACTIVO','2015-12-05','SYSADMIN',NULL,NULL);
/*!40000 ALTER TABLE `tb_jornada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_justificacioneinasistencia`
--

DROP TABLE IF EXISTS `tb_justificacioneinasistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_justificacioneinasistencia` (
  `int_idJustificacioneInasistencia` int(11) NOT NULL AUTO_INCREMENT,
  `str_estado` varchar(45) DEFAULT NULL,
  `str_UsuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_UsuarioModificador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `int_asistencia` int(11) NOT NULL,
  `str_observacion` text NOT NULL,
  PRIMARY KEY (`int_idJustificacioneInasistencia`),
  KEY `fk_asistencia_justificacion` (`int_asistencia`),
  CONSTRAINT `fk_asistencia_justificacion` FOREIGN KEY (`int_asistencia`) REFERENCES `tb_asistencia` (`int_asistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_justificacioneinasistencia`
--

LOCK TABLES `tb_justificacioneinasistencia` WRITE;
/*!40000 ALTER TABLE `tb_justificacioneinasistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_justificacioneinasistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_locales`
--

DROP TABLE IF EXISTS `tb_locales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_locales` (
  `int_idLocal` int(11) NOT NULL AUTO_INCREMENT,
  `str_nombre` varchar(45) DEFAULT NULL,
  `str_direccion` varchar(45) DEFAULT NULL,
  `int_idEmpresa` int(11) NOT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `str_telefono` varchar(45) DEFAULT NULL,
  `str_distrito` varchar(45) DEFAULT NULL,
  `str_provincia` varchar(45) DEFAULT NULL,
  `str_departamento` varchar(45) DEFAULT NULL,
  `str_codLocalGuia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idLocal`),
  KEY `tb_local_to_tb_empresa` (`int_idEmpresa`),
  CONSTRAINT `tb_local_to_tb_empresa` FOREIGN KEY (`int_idEmpresa`) REFERENCES `tb_empresa` (`int_idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_locales`
--

LOCK TABLES `tb_locales` WRITE;
/*!40000 ALTER TABLE `tb_locales` DISABLE KEYS */;
INSERT INTO `tb_locales` VALUES (1,'PRINCIPAL','HUALLAGA 178, IQUITOS, LORETO (PE)',1,'ACTIVO',NULL,'01','01','16','1001');
/*!40000 ALTER TABLE `tb_locales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_logeo`
--

DROP TABLE IF EXISTS `tb_logeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_logeo` (
  `int_idLogeo` int(11) NOT NULL AUTO_INCREMENT,
  `str_usuario` varchar(45) NOT NULL,
  `dte_fecha` datetime NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  PRIMARY KEY (`int_idLogeo`)
) ENGINE=MyISAM AUTO_INCREMENT=5413 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_logeo`
--

LOCK TABLES `tb_logeo` WRITE;
/*!40000 ALTER TABLE `tb_logeo` DISABLE KEYS */;
INSERT INTO `tb_logeo` VALUES (5409,'SYSADMIN','2015-12-05 14:20:27','ACTIVO'),(5410,'SYSADMIN','2015-12-05 14:27:34','ACTIVO'),(5411,'SYSADMIN','2015-12-05 17:57:05','ACTIVO'),(5412,'SYSADMIN','2015-12-05 19:08:47','ACTIVO');
/*!40000 ALTER TABLE `tb_logeo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_medidarotacion`
--

DROP TABLE IF EXISTS `tb_medidarotacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_medidarotacion` (
  `int_idMedidaRotacion` int(11) NOT NULL AUTO_INCREMENT,
  `str_codigoMR` varchar(45) NOT NULL,
  `str_nombreMR` varchar(45) NOT NULL,
  `dbl_utilidad` double NOT NULL,
  `dbl_adicional` double NOT NULL,
  `str_descripcionMR` varchar(200) DEFAULT NULL,
  `str_estadoMR` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idMedidaRotacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_medidarotacion`
--

LOCK TABLES `tb_medidarotacion` WRITE;
/*!40000 ALTER TABLE `tb_medidarotacion` DISABLE KEYS */;
INSERT INTO `tb_medidarotacion` VALUES (1,'M1','MENOR',42,5,'menor con 42% de utilidad y 5% para posible descuento','ACTIVO','SISTEMAS','2012-06-27 00:00:00','Y6TORRES','2012-08-27 17:45:55'),(2,'M2','MEDIA',33,5,'menor con 33% de utilidad y 5% para posible descuento','ACTIVO','SISTEMAS','2012-06-27 00:00:00','C1TELLO','2012-08-24 12:36:06'),(3,'M3','MAYOR',25,5,'menor con 25% de utilidad y 5% para posible descuento','ACTIVO','SISTEMAS','2012-06-27 00:00:00','Y6TORRES','2012-08-25 12:47:31');
/*!40000 ALTER TABLE `tb_medidarotacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mediotiempo`
--

DROP TABLE IF EXISTS `tb_mediotiempo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_mediotiempo` (
  `int_idMedioTiempo` int(11) NOT NULL AUTO_INCREMENT,
  `int_asistencia` int(11) NOT NULL,
  `dte_marcacion` datetime NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_iniFin` varchar(45) NOT NULL,
  PRIMARY KEY (`int_idMedioTiempo`),
  KEY `fk_tb_medioTiempo_1` (`int_asistencia`),
  CONSTRAINT `fk_tb_medioTiempo_1` FOREIGN KEY (`int_asistencia`) REFERENCES `tb_asistencia` (`int_asistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mediotiempo`
--

LOCK TABLES `tb_mediotiempo` WRITE;
/*!40000 ALTER TABLE `tb_mediotiempo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_mediotiempo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_memorandum`
--

DROP TABLE IF EXISTS `tb_memorandum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_memorandum` (
  `int_idMemorandum` int(11) NOT NULL AUTO_INCREMENT,
  `str_numero` varchar(20) DEFAULT NULL,
  `str_emisor` varchar(45) DEFAULT NULL,
  `str_receptor` varchar(45) DEFAULT NULL,
  `str_asunto` text,
  `dte_fecha` date DEFAULT NULL,
  `str_cuerpo` text,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `int_idPersona` int(11) NOT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idMemorandum`),
  KEY `fk_tb_memorandum_tb_persona1` (`int_idPersona`),
  CONSTRAINT `fk_tb_memorandum_tb_persona1` FOREIGN KEY (`int_idPersona`) REFERENCES `tb_persona` (`int_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_memorandum`
--

LOCK TABLES `tb_memorandum` WRITE;
/*!40000 ALTER TABLE `tb_memorandum` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_memorandum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_modulo`
--

DROP TABLE IF EXISTS `tb_modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_modulo` (
  `int_modulo` int(11) NOT NULL AUTO_INCREMENT,
  `str_descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_modulo`
--

LOCK TABLES `tb_modulo` WRITE;
/*!40000 ALTER TABLE `tb_modulo` DISABLE KEYS */;
INSERT INTO `tb_modulo` VALUES (1,'Recursos Humanos'),(2,'Ventas'),(3,'Logistica'),(4,'Contabilidad'),(5,'Gerencia'),(6,'Seguridad');
/*!40000 ALTER TABLE `tb_modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_obligacionespago`
--

DROP TABLE IF EXISTS `tb_obligacionespago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_obligacionespago` (
  `int_idObligacionesPago` int(11) NOT NULL AUTO_INCREMENT,
  `int_idFacturaCompra` int(11) NOT NULL,
  `int_idTipoObligacion` int(11) NOT NULL,
  `dbl_montoTotal` double DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idObligacionesPago`),
  KEY `fk_idFactura` (`int_idFacturaCompra`),
  KEY `fk_idTipoObligacion` (`int_idTipoObligacion`),
  CONSTRAINT `fk_idFactura` FOREIGN KEY (`int_idFacturaCompra`) REFERENCES `tb_facturacompra` (`int_idFacturaCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idTipoObligacion` FOREIGN KEY (`int_idTipoObligacion`) REFERENCES `tb_tipoobligacion` (`int_idTipoObligacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_obligacionespago`
--

LOCK TABLES `tb_obligacionespago` WRITE;
/*!40000 ALTER TABLE `tb_obligacionespago` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_obligacionespago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ordencompra`
--

DROP TABLE IF EXISTS `tb_ordencompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ordencompra` (
  `int_idOrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `int_idProveedor` int(11) NOT NULL,
  `str_numeroOC` varchar(45) NOT NULL,
  `int_idTransportista` int(11) NOT NULL,
  `int_idAlmacen` int(11) NOT NULL,
  `str_viaTransporte` varchar(45) NOT NULL,
  `int_idTipoObligacion` int(11) NOT NULL,
  `dbl_precioBruto` double NOT NULL,
  `dbl_precioTotal` double NOT NULL,
  `dbl_descuentoTotal` double NOT NULL,
  `dbl_valorVenta` double NOT NULL,
  `dbl_igv` double NOT NULL,
  `dbl_igvRecuperado` double NOT NULL,
  `dbl_peso` double NOT NULL,
  `str_fechaEntrega` datetime NOT NULL,
  `str_fechaValidez` datetime NOT NULL,
  `str_operacion` varchar(45) NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idOrdenCompra`),
  KEY `fk_intProveedor` (`int_idProveedor`),
  KEY `fk_intTransportista` (`int_idTransportista`),
  KEY `fk_intAlmacen` (`int_idAlmacen`),
  KEY `fk_intTipoObligacion` (`int_idTipoObligacion`),
  CONSTRAINT `fk_intAlmacen` FOREIGN KEY (`int_idAlmacen`) REFERENCES `tb_locales` (`int_idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_intProveedor` FOREIGN KEY (`int_idProveedor`) REFERENCES `tb_proveedor` (`int_idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_intTipoObligacion` FOREIGN KEY (`int_idTipoObligacion`) REFERENCES `tb_tipoobligacion` (`int_idTipoObligacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_intTransportista` FOREIGN KEY (`int_idTransportista`) REFERENCES `tb_proveedor` (`int_idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ordencompra`
--

LOCK TABLES `tb_ordencompra` WRITE;
/*!40000 ALTER TABLE `tb_ordencompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_ordencompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_otrosestudios`
--

DROP TABLE IF EXISTS `tb_otrosestudios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_otrosestudios` (
  `int_idOtrosEstudios` int(11) NOT NULL AUTO_INCREMENT,
  `int_idPersona` int(11) NOT NULL,
  `str_estudio` varchar(45) DEFAULT NULL,
  `str_nivelEstudio` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_ultimaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idOtrosEstudios`),
  KEY `fk_tb_otrosEstudios_tb_persona1` (`int_idPersona`),
  CONSTRAINT `fk_tb_otrosEstudios_tb_persona1` FOREIGN KEY (`int_idPersona`) REFERENCES `tb_persona` (`int_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_otrosestudios`
--

LOCK TABLES `tb_otrosestudios` WRITE;
/*!40000 ALTER TABLE `tb_otrosestudios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_otrosestudios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_permisos`
--

DROP TABLE IF EXISTS `tb_permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_permisos` (
  `int_idPermisos` int(11) NOT NULL AUTO_INCREMENT,
  `dte_fecha` date DEFAULT NULL,
  `str_motivo` varchar(45) DEFAULT NULL,
  `tm_horaSalida` time DEFAULT NULL,
  `tm_horaLlegada` time DEFAULT NULL,
  `str_observacion` text,
  `str_estado` varchar(45) DEFAULT NULL,
  `tm_horaMarcadoSalida` time DEFAULT NULL COMMENT '	',
  `tm_horaMarcadoLlegada` time DEFAULT NULL,
  `dte_fechaRegistro` datetime NOT NULL,
  `int_idPersona` int(11) NOT NULL,
  `str_usuarioaAprobo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idPermisos`),
  KEY `fk_tb_permisos_tb_persona1` (`int_idPersona`),
  CONSTRAINT `fk_tb_permisos_tb_persona1` FOREIGN KEY (`int_idPersona`) REFERENCES `tb_persona` (`int_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_permisos`
--

LOCK TABLES `tb_permisos` WRITE;
/*!40000 ALTER TABLE `tb_permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_persona`
--

DROP TABLE IF EXISTS `tb_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_persona` (
  `int_idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `str_codigo` varchar(45) DEFAULT NULL,
  `str_apePaterno` varchar(45) DEFAULT NULL,
  `str_apeMaterno` varchar(45) DEFAULT NULL,
  `str_nombres` varchar(45) DEFAULT NULL,
  `str_dni` varchar(8) DEFAULT NULL,
  `str_carnetExtranjeria` varchar(15) DEFAULT NULL,
  `dte_fechaNacimiento` date DEFAULT NULL,
  `str_ciudadNacimiento` varchar(45) DEFAULT NULL,
  `str_telefono` varchar(10) DEFAULT NULL,
  `str_movil` varchar(9) DEFAULT NULL,
  `str_sexo` char(1) DEFAULT NULL,
  `str_nacionalidad` varchar(45) DEFAULT NULL,
  `str_correoElectronico` varchar(45) DEFAULT NULL,
  `str_brevete` char(1) DEFAULT NULL,
  `str_categoriaBrevete` varchar(45) DEFAULT NULL,
  `str_estadoCivil` varchar(15) DEFAULT NULL,
  `str_direccion` varchar(150) DEFAULT NULL,
  `str_distrito` varchar(45) DEFAULT NULL,
  `str_provincia` varchar(45) DEFAULT NULL,
  `str_departamento` varchar(45) DEFAULT NULL,
  `bin_huellaDigital_1` blob,
  `bin_huellaDigital_2` blob,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_ultimaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `blob_foto` longblob,
  PRIMARY KEY (`int_idPersona`),
  KEY `index_dni` (`str_dni`),
  KEY `index_nombre` (`str_nombres`),
  KEY `index_apePa` (`str_apePaterno`),
  KEY `index_apeMa` (`str_apeMaterno`),
  KEY `index_allName` (`str_apePaterno`,`str_apeMaterno`,`str_nombres`),
  KEY `index_codigo` (`str_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_persona`
--

LOCK TABLES `tb_persona` WRITE;
/*!40000 ALTER TABLE `tb_persona` DISABLE KEYS */;
INSERT INTO `tb_persona` VALUES (1,'Z1','TAVARA','SANDON','ZOLANCH','46671572','','1990-11-21','HUACHO','0000000000','999999999','M','HUACHO','ZOLANCH','N','Seleccionar una Opción','Soltero/a','MICAELA 180','COMAS\r','LIMA\r','LIMA\r',NULL,NULL,'ACTIVO','2015-12-05','SYSADMIN',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_producto` (
  `int_idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `str_codigoInterno` varchar(45) DEFAULT NULL,
  `str_nombreProducto` varchar(100) NOT NULL,
  `str_descripcion` varchar(200) DEFAULT NULL,
  `str_fabricante` varchar(45) DEFAULT NULL,
  `str_reintegroTributario` varchar(45) DEFAULT NULL,
  `int_idFamilia` int(11) NOT NULL,
  `int_idUnidadMedida` int(11) NOT NULL,
  `int_idMedidaRotacion` int(11) NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `dte_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idProducto`),
  KEY `fk_intFamilia` (`int_idFamilia`),
  KEY `fk_intUnidadMedida` (`int_idUnidadMedida`),
  KEY `fk_intMedidaRotacion` (`int_idMedidaRotacion`),
  CONSTRAINT `fk_intFamilia` FOREIGN KEY (`int_idFamilia`) REFERENCES `tb_familia` (`int_idFamilia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_intMedidaRotacion` FOREIGN KEY (`int_idMedidaRotacion`) REFERENCES `tb_medidarotacion` (`int_idMedidaRotacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_intUnidadMedida` FOREIGN KEY (`int_idUnidadMedida`) REFERENCES `tb_unidadmedida` (`int_idUnidadMedida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=745 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_producto`
--

LOCK TABLES `tb_producto` WRITE;
/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` VALUES (1,'M011','AMIBAÑO','AMITRAZ 12%    FRASCO X 33 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(2,'M012','ANTIHELMINTICO','SOLUCION AL  20%  FRASCO  X 100 ML','','SI ',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,'M013','AUMENTHA ATP',' SOLUCION INYECTABLE 100ML','','SI ',24,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(4,'MO14','ARTROSAMINE','PREVENTIVO DE OSTEOARTRITIS  / TABLETAS','','SI ',24,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,'M015','AMINOPLEX FORTE','500 ML SOLUCION INYECTABLE','','SI ',24,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,'M016','AGROGENTA11','SOLUCION INYECTABLE. FRASCO X 100ML','','SI ',6,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(7,'M017','ADRENA VIDA','SOLUCION INYECTABLE 50 ML','','SI ',7,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,'M018','ATROPINA','SULFATO AMPOLLA   1MG /1ML','','SI ',7,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,'M019','ALCANFORVET PLUS',' SOLUCION INYECTABLE 100 ML','','SI ',15,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(10,'M021','BAYTRIL','INYECTABLE 5% 100ML','','SI ',6,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,'M022','BAYTRIL','TABLETAS  150 MG   PERROS GRANDES','','SI ',6,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,'M023','BAYTRIL','TABLETAS   50MG   PERROS Y GATOS','','SI ',6,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,'M024','BIOTOSS','SOLUCION  INYECTABLE 50 ML','','SI ',15,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(14,'M025','BIOMISIL 1%','SOLUCION INYECTABLE 50 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(15,'M026','BIOMISIL   0.1%','SOLUCION INYECTABLE 20 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,'M027','BIOVALGINA','SOLUCION INYECTABLE 50 ML','','SI ',12,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,'M028','BRONCOPET','DESCONGESTIONANTE RESPIRATPRIO  100ML  ','','SI ',15,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,'M029','BOLFO  PLUSS',' 25 GR','','SI ',20,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(19,'M030','BISTURI  STERIL',' N°10','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(20,'M031','COMPLEJO B ','SOLUCION ORAL 120 ML','','SI ',24,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(21,'M032','COMPLEX B ','SOLUCION INYECTABLE 100 ML ','','SI ',24,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(22,'M033','CANEX','20K PERRO GRANDE ','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,'M034','CANEX','10K PERRO MEDIANO','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(24,'M035','CESTI-TABS','FRASCO  X 30 TABL.','','SI ',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(25,'M036','CANIVET','3ML','','SI ',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,'M037','CATETER URETRAL','','','SI ',21,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,'M038','CLORURO DE  NA',' AL 0.9%. FRASCO X 1 LITRO','','SI ',29,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(28,'M039','CATETER  ',' 20 GR','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(29,'M040','CATETER','22 GR','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(30,'M0401','CATETER','24 GR','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(31,'M0402','KILLER CAMPEON','  SOBRE 5 GR ','','SI ',31,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(32,'M041','DECTOMAX','50ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(33,'M042','DORAMEC','100ML','','SI ',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,'M043','DEXALAN ','100ML','','SI ',9,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(35,'M044','DORMI - XYL','20ML','','SI ',30,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(36,'M045','DESTROSA','5% FRASCO X 1 LITRO','','SI ',29,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(37,'M046','DISTENSIL','500ML','','SI ',17,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(38,'M051','ENROBIOT','SOLUCION INYECTABLE 100 ML ','','SI ',6,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(39,'M052','ENROFLOX','SOLUCION INYECTABLE  250 ML','','SI ',6,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(40,'M053','DECTOMAX','SOLUCION INYECTABLE 20 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(41,'M054','ESTOQUE 20EC',' INSECTICIDA. FRASCO X LITRO','','SI ',20,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(42,'M055','EQUIPO DE MICROGOTEO',' 1000 ML','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(43,'M056','EQUIPO DE VENOCLISIS','','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(44,'M057','EPOETINA ALFA',' SOLUCION INYECTABLE 2000UI /mL','','SI ',42,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(45,'M061','FITOMENADIONA  ','AMPOLLA  10 MG / 1 ML','','SI ',37,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(46,'M062','FOSFOVIT B12','SOLUCION INYECTABLE 100 ML ','','SI ',36,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(47,'M071','GLUCONATO DE CALCIO','10%. AMPOLLA X 10 ML','','SI ',23,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(48,'M072','GRISEOFULVINA 500','TABLETAS X 500MG','','SI ',1,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(49,'M073','GOTAS MAGICAS','LARVICIDA. 20ML','','SI ',32,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(50,'M074','GUANTES DE LATEX ','T= S. CAJA X 100 ','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(51,'M075','GUANTES DE LATEX','T= M CAJA X 100','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(52,'M076','GUANTES DE LATEX','6.5 CAJA X 100','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(53,'M077','GUANTES DE LATEX','7','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(54,'M078','GUANTES DE LATEX','7.5','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(55,'M079','GUANTES DE LATEX','8','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(56,'M080','GASA STERIL','100 YARDAS','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(57,'M 0403','CERENIA ','SOLUCION INYECTABLE X 20ML','','SI ',8,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(58,'M0801','GASA STERIL','10 X10','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(59,'M0802','GASA STERIL','7.5 X 7.5','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(60,'M0803','GRAVANIN','SOLUCION INYECTABLE X 5 ML','','SI ',8,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(61,'M081','HEPATIN','FRASCO X 250 ML','','SI ',36,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(62,'M082','HEMATOFOS B12 ','SOLUCION INYECTABLE X 50 ML','','SI ',34,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(63,'M083','HALATAL','ANESTESICO 50 ML','','SI ',5,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(64,'M084','HIBISOFT ','ESPUMA 4% X GALON','','SI ',13,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(65,'M0101','JERINGA DESECHABLE','2 ML. CAJA X 100 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(66,'M0102','JERINGA DESECHABLE','3 MLCAJA X 100 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(67,'M0103','JERINGA DESECHABLE','1 MLCAJA X 100 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(68,'M0104','JERINGA DESECHABLE','5 MLCAJA X 100 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(69,'M0105','JERINGA DESECHABLE','10 MLCAJA X 100 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(70,'M0106','JERINGA DESECHABLE','20 MLCAJA X 50 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(71,'M0107','JERINGA DESECHABLE','60 MLCAJA X 100 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(72,'M0108','JERINGA DESECHABLE','2.5 MLCAJA X 100 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(73,'M0109','JERINGA DESECHABLE','50 ML CAJA X 30 UNIDADES','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(74,'M0111','KET - A - 100 ','SOLUCION INYECTABLE. FRASCO X 50ML','','SI ',5,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(75,'M0121','LIDOCAINA','2%  X 20ML','','SI ',5,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(76,'M0122','LACTATO  DE RINGER  ','1000 ML','','SI ',29,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(77,'M0123','LECHE  MATERNIZADA SUSTITE ','TARRO X 400GR','','SI ',22,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(78,'M0124','LECHE  MATERNIZADA  JOSTEN',' SOBRE X 200GR','','SI ',22,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(79,'M0131','METROSTAT ',' SOLUCION INYECTABLE  500 MG /100ML','','SI ',6,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(80,'M0132','METRONIDAZOL','SOLUCION INYECTABLE 500MG /100 ML','','SI ',6,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(81,'M0133','AGUJA MARIPOSA ','','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(82,'M0134','MASCARILLA','','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(83,'M0135','METAMIZOL SODICO','AMPOLLA X 1G /2mL','','SI ',33,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(84,'M0136','MATANOX','CAJA  X 2  FRASCOS  10ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(85,'M0141','NEORAL',' CICLOSPORIN  25 MG','','SI ',39,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(86,'M0151','OPTOPET','SOLUCION OFTALMICA 10 ML','','SI ',9,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(87,'M0152','OXYTO - SYNT 10','SOLUCION INYECTABLE 20 ML','','SI ',25,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(88,'M0153','OTIDERMA - CEF. ','SUSPENSION OTICA - DERMICA 15 ML','','SI ',6,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(89,'M0154','DILATOR VAGINAL','','','SI ',40,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(90,'M0161','PET CAL','MINERALES. FRASCOS X 60 TABLETAS','','SI ',23,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(91,'M0162','PET TABS PLUS','SUPLEMENTO VITAMINICO. FRASCO X 60 TABLETAS','','SI ',24,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(92,'M0163','PANALOG','ANTIBIOTICO UNGÜENTO','','SI ',6,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(93,'M0164','PHYTO SOYA','250 ML','','SI ',42,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(94,'M0165','PAREX',' AMITRAZ 20.8% X 33 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(95,'M0166','PACITRAN','10 MG. AMPOLLA X 2 ML','','SI ',30,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(96,'M0167','PROFEN','1% X 50ML','','SI ',9,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(97,'M020','AGUA  ESTERIL ','AMPOLLAS ','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(98,'M0201','AGUJA HIPODERMICA','# 18','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(99,'M0202','AGUJA HIPODERMICA','# 21 ','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(100,'M0203','AGUJA HIPODERMICA','# 23','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(101,'M0204','ALCOHOL PURO  9%','1000 ML','','SI ',13,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(102,'M0205','ALGODÓN HIDROFOLICO','500GR','','SI ',21,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(103,'M0206','AGUA ESTERIL ','AMPOLLAS 10ML','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(104,'M0181','SYNULOX','ANTIBIOTICO TABLETAS X250 GR','','SI ',6,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(105,'M0182','SOLUTRES','AMPOLLAS X1ML  ANTICONCEPTIVO - ANTINEOPLASICO','','SI ',18,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(106,'M0183','SONDA','MEDIANA ','','SI ',21,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(107,'M0184','SONDA','GRANDE ','','SI ',21,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(108,'M0185','SONDA','ESPECIAL','','SI ',21,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(109,'M0186','SONDA','PEQUEÑAS','','SI ',21,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(110,'M0187','SUTURA ABSORBIBLE ESTERIL','#1','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(111,'M0188','SUTURA ABSORBIBLE ESTERIL','#2','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(112,'M0189','SUTURA ABSORBIBLE ESTERIL','#3','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(113,'M0190','SUTURA ABSORBIBLE ESTERIL','#4','','SI ',21,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(114,'M0171','RANITIDINA 2ML','50 MG / 2ML SOLUCION INYECTABLE','','SI ',41,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(115,'M0172','REVOLUTION 12%','DE 10 A 20 K','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(116,'M0174','REVOLUTION 12%','DE 2.6 A 5 KG','','SI ',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(117,'M0173','REVOLUTION 12%','DE 20 A 40 K','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(118,'M0201','TRANQUILIS GOTAS ','SOLUCION ORAL  ACEPROMAZINA  15 ML','','SI ',30,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(119,'M0202','TRAMADOL ','2ML  SOLUCION INYECTABLE ','','SI ',33,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(120,'M0203','TENIAFIN','ANTIPARASITARIO  TENICIDA10%. FRASCO X 1 LITRO','','SI ',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(121,'M0204','TUBO LATEX','','','SI ',42,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(122,'M0205','TRAMADOL ','1ML AMPOLLA X 10MG','','SI ',33,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(123,'M0221','VETALOG','10ML X 10MG','','SI ',9,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(124,'M0222','VERMI-DOG','ANTIPARASITARIO EN TABLETAS','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(125,'M0223','VIGANTOL ADE ','50ML','','SI ',36,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(126,'M0224','VIGANTOL ADE ','100ML','','SI ',36,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(127,'M0225','SEXTUPLE','FRASCO X 1 ML','','SI ',19,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(128,'M0226','TRIPLE','FRASCO X 1 ML','','SI ',19,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(129,'M0227','PARVO VIRUS','FRASCO X 1 ML','','SI ',19,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(130,'M0228','TRIPLE FELINA','FRASCO X 1 ML','','SI ',19,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(131,'M0229','RABIA','FRASCO X 1 ML','','SI ',19,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(132,'M0230','PENICILINA','FRASCO X 250 ML','','SI ',6,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(133,'M0231','VINCRISTINA','AMPOLLA X 1G /1mL','','SI ',10,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(134,'M0241','XILONEST  SP',' LIDOCAINA AL 2% 20 ML','','SI ',5,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(135,'A011','BOSAL DE CUERO','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(136,'A012','BOSAL DE CUERO','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(137,'A013','BOSAL DE CUERO','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(138,'A014','BOSAL  DE NYLON','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(139,'A015','BOSAL  DE NYLON','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(140,'A016','BOSAL  DE NYLON','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(141,'A017','BIBERON GRANDE ','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(142,'A018','GUANTE PARA BAÑO','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(143,'A019','BIBERON  PEQUEÑO','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(144,'A020','BOSAL DE FIERRO','ROTWAILLER','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(145,'A0201','BOSAL DE FIERRO','PITBULL','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(146,'A0202','BOSAL DE FIERRO','PASTOR ALEMAN','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(147,'A021','CADENA DE RESORTE TRAYLER','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(148,'A022','CADENA DE AHORQUE','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(149,'A023','CADENA SOLDADA  ','GRUESA','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(150,'A024','CADENA SOLDADA  ','DELGADA','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(151,'A025',' CADENA SIMPLE','4 MM X 48\"','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(152,'A026',' CADENA SIMPLE','3.5MM X48\"','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(153,'A027','CORREA DE PUAS','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(154,'A028','CORREA DE  CUERO','P/CACHORRO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(155,'A029','COLLAR DE LONA  CON AGARRE DE METAL','P/CACHORRO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(156,'A0290','COLLAR DE LONA  CON AGARRE DE  PLASTICO','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(157,'A0291','CORREA RETRACTABLE','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(158,'A0293','CEPILLOS DOBLES','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(159,'A0294','CORREA DE  NYLON','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(160,'A0295','CADENA SIMPLE','3.0 MM X48\"','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(161,'A0296','CADENA SIMPLE','2.5 MMX48\"','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(162,'A0297','CADENA SIMPLE','2.0 MM X 48\"','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(163,'A0298','COLLAR DE CHAROL CON SONAJA','T=1','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(164,'A0299','COLLAR DE CHAROL CON SONAJA','T=2','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(165,'A0230','COLLAR CHI CON SONAJA ','P/ GATO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(166,'A0231','COLLAR FAIPET DE CUERO','C/ APLIC. DE PUAS T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(167,'A0232','COLLAR FAIPET DE CUERO','C/ APLIC. DE PUAS T=5','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(168,'A0233','COLLAR FAIPET DE CUERO','C/ APLIC. DE PUAS T=6','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(169,'A0234','COLLAR FAIPET DE CUERO DELGADO','C/ APLIC. DE PUAS T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(170,'A0235','COLLAR FAIPET DE CUERO DELGADO','C/ APLIC. DE PUAS T=5','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(171,'A0236','COLLAR FAIPET DE CUERO DELGADO','C/ APLIC. DE PUAS T=6','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(172,'A0237','CAMA LASSIE CAM','T=0','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(173,'A0238','CAMA LASSIE CAM','T=1','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(174,'A0239','CAMA LASSIE CAM','T=2','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(175,'A0240','CAMA LASSIE CAM','T=3','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(176,'A0241','CAMA LASSIE CAM','T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(177,'A0242','CAMA LASSIE CAM','T=5','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(178,'A0243','CAMA IGLU','T1P','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(179,'A0244','CAMA IGLU','T2M','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(180,'A0245','CAMA IGLU','T3G','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(181,'A0246','CAMA ACCICAM','T=0','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(182,'A0247','CAMA ACCICAM','T=1','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(183,'A0248','CAMA ACCICAM','T=2','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(184,'A0249','CAMA ACCICAM','T=3','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(185,'A0250','CAMA ACCICAM','T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(186,'A0251','CAMA ACCICAM','T=5','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(187,'A0252','CAMA ACCICAM','T=6','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(188,'A031','PESAS CRASHCAN','JEBE DUREX','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(189,'A032','PELOTAS DE FUTBOLL AMERICANO','DUREX','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(190,'A034','ERIZO','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(191,'A036','RATONCITO','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(192,'A037','PATITO','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(193,'A038','OVEJITA','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(194,'A039','PELOTA  FUTBOLL AMERICANO ','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(195,'A040','PELOTA  FUTBOLL  AMERICANO ','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(196,'A0401','PELOTITA DE BASKETBOLL','PEQUEÑO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(197,'A0402','PELOTA DE FUTBOLL ','C/RATON DISEÑADO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(198,'A0403','PELOTA DE FUTBOLL ',' GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(199,'A0404','PELOTA DE BASKETBOLL ','GRANDE ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(200,'A0405','PELOTA GRASHCAN','DUREX TM','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(201,'A0406','PELOTA  ','C/ DISEÑO DE HUESITOS TL','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(202,'A0407','PELOTA  ','C/ DISEÑO DE HUESITOS TM','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(203,'A0408','HUESO DE JEBE','DUREX  TM','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(204,'A0409','HUESITO DE JEBE  CON PUAS ','DUREX TS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(205,'A0410','HUESO DE JEBE CON PUAS ','DUREX TL','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(206,'A0411','CARAMELO DE JEBE ','C/ PUAS  DUREX TM','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(207,'A0412','CARAMELO DE JEBE ','C/ PUAS  DUREX TS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(208,'A0413','SONAJA CIRCULAR CRASHCAN','JEBE DUREX','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(209,'A0414','PELOTA DE JEBE DUREX','T=S','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(210,'A0415','TRONQUITOS ','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(211,'A0416','BOTA DE JEBE CRASHCAN','DUREX','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(212,'A0417','PESAS  ','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(213,'A0418','RACIMOS DE UVA','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(214,'A0419','PELOTA CARITA FELIZ','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(215,'A0420','WUMERAN','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(216,'A0421','PELOTA CON HUELLAS','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(217,'A0422','PELOTA CON HUELLAS ','SEMI-DUREX','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(218,'A0423','HUESO C/MOTIVO NAVIDEÑO','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(219,'A0424','PELOTA C/MOTIVO NAVIDEÑO','GOMA','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(220,'A0425','RATONCITO','SOGA P/ GATO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(221,'A0426','SOGILLA C/PLUMA ','P/ GATO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(222,'A0427','PELOTA ATOMICA ','JEBE  T=S','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(223,'A0428','PELOTA ATOMICA ','JEBE  T=M','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(224,'A0429','PELOTA ATOMICA ','JEBE  T=L','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(225,'A0430','PELOTA DE JEBE  ','DUREX T=L','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(226,'A0431','JUEGO DE HILO','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(227,'A041','TRANSPORTADOR ',' L-70','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(228,'A042','TRANSPORTADOR ',' L-60','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(229,'A043','TRANSPORTADOR  ','SH - L-50','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(230,'A044','TRANSPORTADOR ','SH 3663','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(231,'A045','MOCHILA TRANSPORTADORA ','GRANDE ','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(232,'A046','MOCHILA TRANSPORTADORA ','MEDIANO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(233,'A047','MOCHILA TRANSPORTADORA ','PEQUEÑO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(234,'A048','CANGURO TRANSPORTADOR','GRANDE ','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(235,'A049','CANGURO TRANSPORTADOR','MEDIANO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(236,'A04501','CANGURO TRANSPORTADOR','PEQUEÑO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(237,'A04502','TIRO DE SOGA C/ TORNILLO','DELGADO ','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(238,'A04503','TIRO DE SOGA C/ TORNILLO','MEDIANO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(239,'A04504','TIRO DE SOGA C/ TORNILLO','GRUESO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(240,'A051','PECHERA DE   NYLON Y CUERO EN BOLSA','T=0','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(241,'A052','PECHERA DE   NYLON Y CUERO EN BOLSA','T=1','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(242,'A053','PECHERA DE   NYLON Y CUERO EN BOLSA','T=2','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(243,'A054','PECHERA DE   NYLON Y CUERO EN BOLSA','T=3','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(244,'A055','PECHERA DE   NYLON Y CUERO EN BOLSA','T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(245,'A056','PECHERA DE   NYLON Y CUERO EN BOLSA','T=5','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(246,'A057','PECHERA DE   NYLON Y CUERO EN BOLSA','T=6','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(247,'A058','PECHERA DE LONA  (ECONOMICA)','T=0','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(248,'A059','PECHERA DE LONA  (ECONOMICA)','T=1','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(249,'A0501','PECHERA DE LONA  (ECONOMICA)','T=2','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(250,'A0502','PECHERA DE LONA  (ECONOMICA)','T=3','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(251,'A0503','PECHERA DE LONA  (ECONOMICA)','T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(252,'A0504','PECHERA DE LONA  (ECONOMICA)','T=5','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(253,'A0505','PECHERA DE LONA  (ECONOMICA)','T=6','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(254,'A0506','PECHERA DE LONA EN BOLSA','T=S','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(255,'A0507','PECHERA DE LONA EN BOLSA','T=M','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(256,'A0508','PECHERA DE LONA EN BOLSA','T=L','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(257,'A0509','PECHERA DE CUERO (ECONOMICA)','T=3','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(258,'A0510','PECHERA DE CUERO (ECONOMICA)','T=4','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(259,'A0511','PECHERA DE CUERO (ECONOMICA)','T=5','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(260,'A0512','PECHERA DE CUERO (ECONOMICA)','T=6','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(261,'A0513','PECHERA DE CUERO M/ FAIPET','T=1','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(262,'A0514','PECHERA DE CUERO M/ FAIPET','T=3','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(263,'A0515','PECHERA DE CUERO M/ FAIPET','T=2','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(264,'A0516','PECHERA P/HAMSTER','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(265,'A0517','PECHERA CHALECO','T=0','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(266,'A0518','PECHERA CHALECO','T=1','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(267,'A0519','PECHERA CHALECO','T=2','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(268,'A0520','PECHERA CHALECO','T=3','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(269,'A0521','PECHERA CHALECO','T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(270,'A0522','PECHERA DE   NYLON Y CUERO EN BOLSA','T=7','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(271,'A0523','PECHERA EN CUERO M/ FAIPET','T=4','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(272,'A0524','PECHERA EN CUERO M/ FAIPET','T=5','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(273,'A0525','PECHERA EN CUERO M/ FAIPET','T=6','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(274,'A0526','PECHERA EN CUERO M/ FAIPET','T=7','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(275,'A0527','PETRAL DE CUERO M/ FAIPET','T=S','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(276,'A0528','PETRAL DE CUERO M/ FAIPET','T=M','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(277,'A0529','PETRAL DE CUERO M/ FAIPET','T=XL','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(278,'A091','PLATO DOBLE DE PLASTICO ','C/ NEGRO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(279,'A092','PLATO DE PLASTICO ','C/DISEÑO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(280,'A093','PLATO DOBLE C/BEBEDERO','C/VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(281,'A094','PLATO CIRCULAR DE PLASTICO','PEQUEÑO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(282,'A095','PLATO GRANDE ANTIDESLIZANTE','C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(283,'A096','PLATO  DOBLE C/ BEBEDERO -CORAZON','C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(284,'A097','PLATO GRANDE Y HONDO  RIC-CAM','C/ROJO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(285,'A098','PLATO GRANDE F/ HUESO  PED','C/AMARILLO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(286,'A099','BEBEDERO F/ PICO','C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(287,'A0901','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO','  T=0','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(288,'A0902','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO','  T=1','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(289,'A0903','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO','  T=2','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(290,'A0904','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO','  T=3','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(291,'A0905','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO','  T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(292,'A0906','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO','  T=5','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(293,'A0907','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO','  T=6','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(294,'A0908','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO ALTO RELIEVE','T=6','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(295,'A0909','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO ALTO RELIEVE','T=3','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(296,'A0910','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO ALTO RELIEVE','T=2','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(297,'A0911','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO ALTO RELIEVE','T=1','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(298,'A0912','PLATO DE ACERO INOXIDABLE  ANTIDESLIZANTE C/DISEÑO ALTO RELIEVE HONDO','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(299,'A0913','PLATO DE ACERO PESADO','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(300,'A0914','PLATO DE ALUMINIO','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(301,'A0915','PLATO DE ACERO INOXIDABLE  C/ DISEÑO EN ALTO RELIEVE  ANTIDESLIZANTE','T=4','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(302,'A0916','PLATO  DE MELAMINE  F/HUESO  C/ BLANCO','CHICO ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(303,'A0917','PLATO DE MELAMINE  C/ DISEÑO','CHICO ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(304,'A0918','PLATO DE MELAMINE  C/ DISEÑO DE HUESOS C/NEGRO','CHICO ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(305,'A0919','PLATO DE MELAMINE  C/ DISEÑO DE HUESOS C/BLANCO','CHICO ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(306,'A0920','PLATO DE MELAMINE  C/ DISEÑO DE   PERRITOS','GRANDE ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(307,'A0921','PLATO DE MELAMINE   HONDO C/DISEÑO DE ANIMALES','MEDIANO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(308,'A0922','PLATO DE MELAMINE   HONDO C/DISEÑO DE ANIMALES','CHICO ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(309,'A0923','PLATO EN MELAMINE P/ GATO ','CHICO ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(310,'A0924','PLATO EN MELAMINE  P/ PERRITOS ','MEDIANO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(311,'A0925','PLATO DOBLE DE ACERO ANTIDESLIZANTE','GRANDE ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(312,'A0926','PLATO DE ALUMINIO','GRANDE ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(313,'A0927','PLATO DISCO','C/ VARIADOS','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(314,'A0928','PEINE  DE GOMA F/ MANO','MEDIANO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(315,'A0929','PEINE  ECONOMICO SIN MANGO','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(316,'A0930','PEINE CON MANGO DE PLASTICO ','MEDIANO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(317,'A0931','PEINE CON MANGO DE PLASTICO ','GRANDE ','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(318,'A0932','PEINE  CON MANGO DE  PLASTICO','PEQUEÑO','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(319,'A0934','PEINE CON MANGO DE MADERA','MEDIANO ','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(320,'A0935','PEINE CON MANGO DE MADERA','GRANDE ','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(321,'A0936','PEINE  CON MANGO DE  PLASTICO  -  CERDAS   GRUESAS ','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(322,'A0937','PEINE  GRUESO C/  MANGO DE PLASTICO','GRANDE ','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(323,'A0938','PEINE DE BAÑO','GOMA','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(324,'A0939','PEINE DE ACERO INOXIDABLE S/MANGA C/ DISEÑO C/BLANCO Y AZUL','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(325,'A0940','PEINE DE ACERO INOXIDABLE S/MANGA  DOBLE PEINETA','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(326,'A0941','PEINE  CEPILLO SUPER GRANDE C/MANGA  C/AZUL Y PLOMO','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(327,'A0942','PEINE DE ACERO CON MANNGO DE PLASTICO C/ AMARILLO  C/DISEÑO HUELLITAS','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(328,'A0943','CEPILLO MEDIAANO CON MANGO DE PLASTICO C/ AZUL','','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(329,'A0944','PLATO DE PLASTICO ANTIDESLIZANTE ROKASD','C/VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(330,'A0945','PLATO DE CIRCULAR DE PLASTICO - ROKASD','MEDIANO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(331,'A0946','PLATO DOBLE ANTIDESLIZANTE MEDIANO','C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(332,'A0947','PLATO CIRCULAR ANTIDESLIZANTE','15 CM   C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(333,'A0948','PLATO CIRCULAR  CON BASE F/ ARQUITO ','15.5 CM   C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(334,'A0949','PLATO  DE PLASTICO SMALL  F/ HUESO','C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(335,'A0950','PLATO CIRCULAR ANTIHORMIGAS- ANTIDESLIZANTE','C/ VARIADOS T= S','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(336,'A0951','PLATO CIRCULAR ANTIHORMIGAS- ANTIDESLIZANTE','C/ VARIADOS T= M','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(337,'A0952','PLATO CIRCULAR MEDIANO','19.5 CM C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(338,'A0953','PLATO CIRCULAR ANTIDESLIZANTE PEQUEÑO ','C/ VARIADOS ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(339,'A0954','POLLO COROCOCO','GRANDE ','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(340,'A0955','POLLO COROCOCO','MEDIANO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(341,'A0956','POLLO COROCOCO','PEQUEÑO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(342,'A0957','PLATO DOBLE PEQUEÑO ','C/ VARIADOS','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(343,'A0958','PLATO DE ALUMINIO  M/ CAM CAM','P/ GATO','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(344,'A0959','PLATO DE ALUMINIO PESADO','','','NO',3,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(345,'A0101','VIRUTA BLANCA','','','NO',3,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(346,'E011','ATOMIL POLVO','SOBRE D/50 GR','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(347,'E012','ATOMIL PLUSS ','TALQUERA D/150 GR','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(348,'E013','ARENA SANITARIA P/ GATO','PAQUETE','','NO',16,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(349,'E021','BAÑO SECO EN ESPUMA','250 ML','','NO',16,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(350,'E031','COLONIA CLASICA PET LINE','120 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(351,'E032','COLONIA \"HEMBRA \" PET LINE','120 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(352,'E033','COLONIA \"DOKITO\" PET LINE','120 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(353,'E034','COLONIA CLASICA PET LINE','1 LITRO','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(354,'E035','CREMA PROTECTORA','120 GR','','NO',16,1,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(355,'E036','COLLARIN  ISABELINO','25 CM','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(356,'E0390','COLLARIN  ISABELINO','12.5 CM','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(357,'E0391','COLLARIN  ISABELINO','15 CM    ','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(358,'E0392','COLLARIN  ISABELINO','20 CM','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(359,'E061','FIPROZOO','60 ML','','NO',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(360,'E062','FIPROZOO','SPRAY X 130 ML','','NO',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(361,'E063','FIPROZOO','SPRAY X 250 L','','NO',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(362,'E064','FIPROCAM','SPRAY X 30 ML','','NO',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(363,'E071','GERMIDET','FRASCO X  120ML','','SI ',13,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(364,'E072','GERMIDET','SPRAY 250 ML','','SI ',13,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(365,'E073','GERMIDET','GALON X 4 L','','SI ',13,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(366,'E091','K-NINO ','SPRAY 130 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(367,'E 094','K - NINO DUO','SPRAY X 400 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(368,'E093','K- NINO DUO','SPRAY X 275ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(369,'E095','K- NINO DUO ','SPRAY X 130 ML ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(370,'E092','K-NINO FRESH','SPRAY 400 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(371,'E0111','NEODERMAL ','CICATRIZANTE ','','SI ',6,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(372,'E0112','NO MAS ','260 ML','','NO',18,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(373,'E0131','PASTA DENTAL','','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(374,'E0141','SARNAFIN','SACHET X 30 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(375,'E0142','SHAMPOO  MANZANILLA  PETLINE ','FRASCO X 330 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(376,'E0143','SHAMPOO  AVENA PETLINE  ','FRASCO X330 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(377,'E0144','SHAMPOO MEDICADO VETLINEX','FRASCO X250 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(378,'E0145','SHAMPOO DOKY´S ANTIPULGAS ','FRASCO X250 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(379,'E0146','SHAMPOO DOKY´S ALOE ','FRASCO X250 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(380,'E0147','SHAMPOO MEDICADO SARNICAN','FRASCO X300ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(381,'E0148','SHAMPOO DOKY´S ANTIPULGAS','FRASCO X400 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(382,'E0149','SHAMPOO SARNICAN  SACHETS','SACHET X20 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(383,'E01501','SHAMPOO MEDICADO RUFFO  EINSTEN','SACHET X50 ML','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(384,'E01502','SHAMPOO MEDICADO ANTIPULGAS VITAL DERM ','SACHET X50 ML','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(385,'E01503','SHAMPOO MEDICADO DERMA- SAN','SACHET X50 ML','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(386,'E01504','SHAMPOO MEDICADO  SARNA - AMITRAZ','50 ML','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(387,'E01505','SHAMPOO MEDICADO VETLINE ','50 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(388,'E01506','SHAMPOO DOKY´S   ALOE  SACHETS','30 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(389,'E01507','SHAMPOO MEDICADO EINSTEN FRASCO ','250 ML','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(390,'E01508','SHAMPOO MEDICADO RUFFO -GLISERINA','50 ML','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(391,'E01509','SHAMPOO DOKY´S  ANTIPULGAS ','30 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(392,'E015024','SHAMPOO AMIGO MAXIMO','FRASCO X 300ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(393,'E015022','SHAMPOO AMIGO  + JABON','FRASCO X 220 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(394,'E015021','SHAMPO AMIGO + COJIN','FRASCO X 220 ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(395,'E015025','SHAMPO AMIGO CACHORROS','FRASCO X 300ML','','SI ',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(396,'E015011','SHAMPOO AMIGO','COJIN  / TAPA 200ML ','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(397,'E015012','SHAMPOO DOKYS ALOE','GALON X 4L','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(398,'E015013','SHAMPOO DERMA - SAN','GALON','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(399,'E015014','SHAMPO CLORHEXIDINA','GALON','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(400,'E015015','SHAMPOO RUFFO EINSTEN','GALON','','NO',35,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(401,'E015016','SHAMPOO DOKY´S ALOE ','GALON X20L','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(402,'E015018','SHAMPOO DOKY´S ANTIPULGA','GALON X20L ','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(403,'E015019','SHAMPOO GERMEN DE TRIGO','FRASCO 270 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(404,'E015020','SHAMPOO DOKYS ALOE','400 ML','','NO',16,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(405,'E0161','VETLINE SPRAY','30 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(406,'E0162','VETLINE SPRAY','260 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(407,'E0163','VETLINE SPRAY INSECTO RASTRERO','250 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(408,'E0164','VETLINE SPRAY','60ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(409,'E0165','VETLINE SPRAY','60 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(410,'E0166','VETLINE SPRAY','120 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(411,'E0167','VETLINE SPRAY','260 ML','','NO',11,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(412,'E0168','VETLINE SPRAY','GALON','','NO',11,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(413,'V011','CAMISAS A CUADROS','T= 1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(414,'V012','CAMISAS A CUADROS','T= 2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(415,'V013','CAMISAS A CUADROS','T= 3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(416,'V014','CAMISA DE TELA   A CUADROS CON CUELLO DE ALGODÓN','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(417,'V015','CAMISA DE TELA   A CUADROS CON CUELLO DE ALGODÓN','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(418,'V016','CAMISA DE TELA   A CUADROS CON CUELLO DE ALGODÓN','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(419,'V017','CAMISA DE TELA   A CUADROS CON CUELLO DE ALGODÓN','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(420,'V018','CAMISA DE YTELA HAWAIANAS ','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(421,'V019','CAMISA DE YTELA HAWAIANAS ','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(422,'V020','CAMISA DE YTELA HAWAIANAS ','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(423,'V0201','CAMISA DE YTELA HAWAIANAS ','T=6','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(424,'V0202','CAMISA SPORT','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(425,'V021','DISFRAZ DE BLANCA NEVES','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(426,'V022','DISFRAZ DE BLANCA NEVES','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(427,'V023','DISFRAZ DE BLANCA NEVES','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(428,'V024','DISFRAZ DE BLANCA NEVES','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(429,'V025','DISFRAZ DE WATMAN','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(430,'V026','DISFRAZ DE WATMAN','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(431,'V027','DISFRAZ DE WATMAN','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(432,'V028','DISFRAZ DE WATMAN','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(433,'V029','DISFRAZ DE DIABLITO','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(434,'V0290','DISFRAZ DE DIABLITO','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(435,'V0291','DISFRAZ DE DIABLITO','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(436,'V0292','DISFRAZ DE DIABLITO','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(437,'V0293','DISFRAZ DE SUPER MAN','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(438,'V0294','DISFRAZ DE SUPER MAN','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(439,'V0295','DISFRAZ DE SUPER MAN','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(440,'V0296','DISFRAZ DE SUPER MAN','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(441,'V031','POLO DE LOS LEONES','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(442,'V032','POLO DE LOS LEONES','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(443,'V033','POLO DE LOS LEONES','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(444,'V034','POLO DE LOS LEONES','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(445,'V035','POLO DE LOS LEONES','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(446,'V036','POLO DE LAS COBRAS','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(447,'V037','POLO DE LAS COBRAS','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(448,'V038','POLO DE LAS COBRAS','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(449,'V039','POLO DE LAS COBRAS','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(450,'V0391','POLO DE LAS COBRAS','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(451,'V0392','POLO DE UNIVERSITARIO','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(452,'V0393','POLO DE UNIVERSITARIO','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(453,'V0394','POLO DE UNIVERSITARIO','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(454,'V0395','POLO DE UNIVERSITARIO','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(455,'V0396','POLO DE UNIVERSITARIO','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(456,'V0397','POLO M/PERU','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(457,'V0398','POLO M/PERU','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(458,'V0399','POLO M/PERU','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(459,'V0340','POLO M/PERU','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(460,'V0341','POLO CRISTAL','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(461,'V0342','POLO CRISTAL','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(462,'V0343','POLO CRISTAL','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(463,'V0344','POLO A RAYAS ','T=5','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(464,'V0345','POLO DISEÑO   C/FRASES  ','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(465,'V0346','POLO DISEÑO   C/FRASES  ','T=5','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(466,'V0347','POLOS C/ DISEÑOS BORDADOS','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(467,'V0348','POLOS C/ DISEÑOS BORDADOS','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(468,'V0349','POLOS C/ DISEÑOS BORDADOS','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(469,'V0350','POLOS C/ DISEÑOS BORDADOS VARIADO','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(470,'V0351','POLO RAYADO  ','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(471,'V0352','POLO ESTAMPADO','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(472,'V0353','POLO DE COMBATE','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(473,'V0354','POLO DE COMBATE','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(474,'V0355','POLO DE COMBATE','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(475,'V0356','POLO DE COMBATE','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(476,'V0357','POLO DE COMBATE','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(477,'V0358','POLO DE ALIANZA LIMA','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(478,'V0359','POLO DE ALIANZA LIMA','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(479,'V0360','POLO DE ALIANZA LIMA','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(480,'V0361','POLO DE ALIANZA LIMA','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(481,'V0362','POLO DE ALIANZA LIMA','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(482,'V0363','POLO RAYADO  C/ DISEÑO','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(483,'V0364','POLO RAYADO  C/ DISEÑO','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(484,'V0365','POLO RAYADO  C/ DISEÑO','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(485,'V0366','POLO RAYADO  C/ DISEÑO','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(486,'V0367','POLO RAYADO  C/ DISEÑO','T=5','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(487,'V0368','POLO RAYADO  C/ DISEÑO','T=6','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(488,'V0369','POLO RAYADO CON CUELLO','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(489,'V0370','POLO RAYADO','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(490,'V0371','POLO RAYADO','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(491,'V0372','POLO BORDADO','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(492,'V0373','POLO BORDADO','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(493,'V0374','POLO BORDADO','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(494,'V0375','POLO BORDADO','T=6','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(495,'V0376','POLO BORDADO','T=5','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(496,'V041','VESTIDO C/DISEÑOS','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(497,'V042','VESTIDO C/DISEÑOS','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(498,'V043','VESTIDO C/DISEÑOS','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(499,'V044','VESTIDO C/DISEÑOS','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(500,'V045','VESTIDO ESTAMPADO','T=5','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(501,'V046','VESTIDO A CUADRITOS - JEANS','T=5','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(502,'V047','VESTIDO -  FLOREADITO ','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(503,'V048','VESTIDO JEANS CON ACABADO EN FLORES','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(504,'V049','VESTIDO -MOTIVO NAVIDEÑO','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(505,'V0410','VESTIDO -MOTIVO NAVIDEÑO','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(506,'V0411','VESTIDO DE FIESTA C/ AMARILLO','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(507,'V0412','VESTIDO C/ ESTAMPADOS Y CORREA','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(508,'V0413','VESTIDO C/ ESTAMPADOS Y CORREA','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(509,'V0414','VESTIDO C/ ESTAMPADOS Y CORREA','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(510,'V0415','VESTIDO C/ ESTAMPADOS Y CORREA','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(511,'V0416','VESTIDO A CUADRITOS C/ LAZO','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(512,'V0417','VESTIDO A CUADRITOS C/ LAZO','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(513,'V0418','VESTIDO A CUADRITOS C/ LAZO','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(514,'V0419','VESTIDO DE ALGODÓN C/FLOR','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(515,'V0420','VESTIDO DE ALGODÓN C/FLOR','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(516,'V0421','VESTIDO DE ALGODÓN C/FLOR','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(517,'V0422','VESTIDO DE ALGODÓN C/FLOR','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(518,'V0423','VESTIDO DE ALGODÓN C/FLOR','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(519,'V0424','VESTIDO DE ALGODÓN ESTAMPADO C/ 2 FLOR','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(520,'V0425','VESTIDO DE ALGODÓN ESTAMPADO C/ 2 FLOR','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(521,'V0426','VESTIDO DE ALGODÓN ESTAMPADO C/ 2 FLOR','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(522,'V0427','VESTIDO DE ALGODÓN A RAYITAS','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(523,'V0428','VESTIDO DE ALGODÓN A RAYITAS','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(524,'V0429','VESTIDO DE ALGODÓN A RAYITAS','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(525,'V0430','VESTIDO DE HELLO KITTY','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(526,'V0431','VESTIDO DE HELLO KITTY','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(527,'V0432','VESTIDO DE HELLO KITTY','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(528,'V0433','VESTIDO DE HELLO KITTY','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(529,'V0434','VESTIDO A CUADRITOS','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(530,'V0435','VESTIDO ESTAMPADO EN TELA ','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(531,'V0436','JEANS','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(532,'V0437','JEANS','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(533,'V0438','JEANS','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(534,'V0439','VESTIDO FLOREADO EN TELA','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(535,'V0440','VESTIDO FLOREADO EN TELA','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(536,'V0441','VESTIDO FLOREADO EN TELA','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(537,'V0442','VESTIDO DE FIESTA  CORSE','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(538,'V0443','VESTIDO DE FIESTA  CORSE','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(539,'V0444','VESTIDO DE FIESTA  CORSE','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(540,'V0445','VESTIDO DE FIESTA PRINCESA','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(541,'V0446','VESTIDO ESTAMPADO ESTAMPADO D/ FLORES CON DETALLES','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(542,'V0447','VESTIDO C/ MANDILITO','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(543,'V0448','VESTIDO C/ MANDILITO','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(544,'V0449','VESTIDO C/ MANDILITO','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(545,'V0450','VESTIDO AFRANELADO','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(546,'V051','ENTERIZO A CUADRITO ','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(547,'V052','ENTERIZO A CUADRITO ','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(548,'V053','PIJAMA DE OSITOS','T=0','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(549,'V054','PIJAMA DE OSITOS','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(550,'V055','PIJAMA DE OSITOS','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(551,'V056','PIJAMA DE OSITOS','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(552,'V057','PIJAMA C/ DISEÑO DE CIRCULOS','T=1','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(553,'V058','PIJAMA C/ DISEÑO DE CIRCULOS','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(554,'V059','ROPA DE RANGER','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(555,'V0510','ROPA DE RANGER','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(556,'V0511','ROPA DE RANGER','T=4','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(557,'V061','BLUSAS CON DISEÑOS EN JEANS','T=2','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(558,'V062','BLUSAS CON DISEÑOS EN JEANS','T=3','','NO',28,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(559,'V063','BOLSA  TRANSPORTADORA PARA PERRO-GATOS','C/ VARIADOS','','NO',3,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(560,'C031',' HUESO DE  CARNAZA SABOR A POLLO',' MEDIDA 6-7','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(561,'C032',' HUESO DE  CARNAZA SABOR A POLLO','MEDIDA 7-8','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(562,'C033',' HUESO DE  CARNAZA SABOR A POLLO','MEDIDA 8-9','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(563,'C034',' HUESO DE  CARNAZA SABOR A POLLO','MEDIDA 9-10','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(564,'C035',' HUESO DE  CARNAZA SABOR A POLLO','MEDIDA 11-12','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(565,'C036',' HUESO DE  CARNAZA SABOR A POLLO',' MEDIDA 13-14','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(566,'C037',' HUESO DE  CARNAZA SABOR A POLLO','MEDIDA 15-17','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(567,'C038',' HUESO DE  CARNAZA SABOR A HIGADO','MEDIDA 11-12','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(568,'C039',' HUESO DE  CARNAZA SABOR A HIGADO',' MEDIDA 13-14','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(569,'C0310',' HUESO DE  CARNAZA SABOR A HIGADO','MEDIDA 15-17','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(570,'C0311',' HUESO DE  CARNAZA SABOR A  QUESO','MEDIDA 11-12','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(571,'C0312',' HUESO DE  CARNAZA SABOR A  QUESO',' MEDIDA 13-14','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(572,'C0313',' HUESO DE  CARNAZA SABOR A   CARNE','MEDIDA 8-9','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(573,'C0314',' HUESO DE  CARNAZA SABOR A   CARNE','MEDIDA 9-10','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(574,'C0315',' HUESO DE  CARNAZA SABOR A   CARNE','MEDIDA 11-12','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(575,'C0316',' HUESO DE  CARNAZA SABOR A   CARNE','MEDIDA 13-14','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(576,'C0317',' HUESO DE  CARNAZA SABOR A   CARNE','MEDIDA 15-17','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(577,'C0318','OREJA DE RES','BOLSA X KILO','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(578,'C0319','OREJA DE RES','BOLSA  X2','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(579,'C0320','HAMBURGESA DE CARNAZA ','X1','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(580,'C0321','PIERNITA DE CARNAZA ','X1','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(581,'C0322','HUESITO BLANCO ','BOLSA X1','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(582,'C0323','HUESO BLANCO','BOLSA X2','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(583,'C0324','OREJA DE RES','X1','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(584,'C0325','HUESO BLANCO','X1','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(585,'C0326','HUESO BLANCO','MEDIDA 7-8','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(586,'C0327','HUESO BLANCO','MEDIDA5-6','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(587,'C0328','HUESO DE CARNAZA  SABOR A CARNE','MEDIDA  2-3','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(588,'C0329','HUESO DE CARNAZA SABOR MANI-CHOCOLATE','MEDIDA  2-3','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(589,'C0330','HUESO DE CARNAZA SABOR  HIGADO','MEDIDA  2-3','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(590,'C0331','HUESO DE CARNAZA SABOR BLANCO','MEDIDA  2-3','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(591,'C0332','DONNA ','BOLSA X1','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(592,'C0333',' HUESO BLANCO','BOLSA X3','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(593,'C0334','GALLETA DE CARNAZA','BOLSA ','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(594,'C0335','HUESO BLANCO  DE CARNAZA','MEDIDA 3-4','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(595,'C0336','MINI GALLETA','X6','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(596,'C0337','SALCHICHAS ','X4','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(597,'C0338','GALLETAS PIEL Y PELAJE','FRASCO 780 GR','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(598,'C0339','GALLETAS INMUNOLOGICAS','FRASCO 780 GR','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(599,'C0340','GALLETAS  DENTITION','FRASCO 780 GR','','NO',4,1,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(600,'C0341','HUESO DE CARNAZA SABOR  POLLO','MEDIDA  2-3','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(601,'C0342','HUESO DE CARNAZA SABOR  QUESO','MEDIDA  2-3','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(602,'C0343','HUESO DE CARNAZA SABOR  CARNE','MEDIDA 7-8','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(603,'C0344','HUESO DE CARNAZA SABOR QUESO','MEDIDA 7-8','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(604,'C0345','HUESO DE CARNAZA SABOR HIGADO','MEDIDA 7-8','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(605,'C0346','PALITOS  SALCHICHAS DE CARNAZA','X1','','NO',4,1,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(606,'T0001','ALIMENTO PROPLAN SENSITIVE X15KILOS ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(607,'T0002','ALIMENTO PROPLAN SENSITIVE X3 KILOS ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(608,'T0003','ALIMENTO PROPLAN X500GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(609,'T0004','ALIMENTO PROPLAN PUPPY X 3 KILOS ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(610,'T0005','ALIMENTO PROPLAN PUPPY X 500 GR ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(611,'T0006','ALIMENTO PROPLAN PUPPY X  15  KILOS ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(612,'T0007','ALIMENTO PROPLAN OPTISTART X  15  KILOS ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(613,'T0008','ALIMENTO PROPLAN CACHORRO RAZA PEQUEÑA','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(614,'T0009','PEDEGREE CACHORRO X 21 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(615,'T0010','PEDEGREE CACHORRO X 15 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(616,'T0011','PEDEGREE CACHORRO X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(617,'T0012','PEDEGREE ADULTO X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(618,'T0013','PEDEGREE ADULTO POLLO Y CARNE X 21 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(619,'T0014','PEDEGREE ADULTO POLLO Y CARNE X 15 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(620,'T0015','PEDEGREE ADULTO X  500 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(621,'T0016','PEDEGREE CACHORRO X  500 GR','','BOLSA','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(622,'T0017','PEDEGREE POUCH CACHORRO CARNE X 85 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(623,'T0018','PEDEGREE POUCH ADULTO RAZA PEQUEÑA X 85 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(624,'T0019','RANITIDINA 2ML/50MG','','','SI ',38,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(625,'T0020','DOG CHOW ADULTO RAZA PEQUEÑA X 15KG','','SACO','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(626,'T0021','DOG CHOW CACHORRO RZ MEDIANA  Y GRANDE X 15KG','','SACO','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(627,'T0022','DOG CHOW CAHORRO RZ PEQUEÑA X 15KG','','SACO','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(628,'T0023','DOG CHOW ADULTO X 15KG','','SACO','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(629,'T0024','DOG CHOW ADULTO RAZA PEQUEÑA X 500KG','','BOLSA','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(630,'T0025','DOG CHOW CACHORRO RZ MEDIANA  Y GRANDE X 500KG','','BOLSA','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(631,'T0026','DOG CHOW CAHORRO RZ PEQUEÑA X 500KG','','BOLSA','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(632,'T0027','DOG CHOW ADULTO X 500KG','','BOLSA','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(633,'T0028','DOG CHOW ADULTO RAZA PEQUEÑA X 1.5KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(634,'T0029','DOG CHOW CACHORRO RZ MEDIANA  Y GRANDE X 1.5KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(635,'T0030','DOG CHOW CAHORRO RZ PEQUEÑA X 1.5KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(636,'T0031','DOG CHOW ADULTO X 1.5KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(637,'T0032','DOG CHOW ADULTO RAZA PEQUEÑA X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(638,'T0033','DOG CHOW CACHORRO RZ MEDIANA  Y GRANDE X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(639,'T0034','DOG CHOW CAHORRO RZ PEQUEÑA X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(640,'T0035','DOG CHOW ADULTO  MAYOR X 8KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(641,'T0036','DOG CHOW ADULTO  MAYOR X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(642,'T0037','DOG CHOW ADULTO X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(643,'T0038','PATE DOG CHOW ADULTO  PAVO Y POLLO / LATA GRANDE','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(644,'T0039','DOG CHOW ADULTO  POLLO Y VERDURAS / LATA GRANDE','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(645,'T0040','DOG CHOW ADULTO CORDERO /LATA GRANDE','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(646,'T0041','RICOCAN CARNE Y CEREALES X 1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(647,'T0042','RICOCAN CORDERO Y CEREALES X1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(648,'T0043','RICOCAN CACHORRO RAZA MEDIA Y GRANDE X 1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(649,'T0044','RICOCAN CACHORRO RAZA PEQUEÑA X 1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(650,'T0045','RICOCAN CLASICO ADULTO TODAS LAS RAZAS X1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(651,'T0046','RICOCAN MULTISABORES TODAS LAS RAZAS X1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(652,'T0047','RICOCAN CORDERO Y CEREALES X500KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(653,'T0048','RICOCAN CARNE Y CEREALES X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(654,'T0049','RICOCAN CACHORRO RAZA MEDIA Y GRANDE X 500KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(655,'T0050','RICOCAN CACHORRO RAZA PEQUEÑA X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(656,'T0051','RICOCAN CLASICO ADULTO TODAS LAS RAZAS X500KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(657,'T0052','RICOCAN MULTISABORES TODAS LAS RAZAS X500KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(658,'T0053','RICOCAN CORDERO Y CEREALES X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(659,'T0054','RICOCAN CARNE Y CEREALES X 3 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(660,'T0055','RICOCAN CACHORRO RAZA MEDIA Y GRANDE X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(661,'T0056','RICOCAN CACHORRO RAZA PEQUEÑA X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(662,'T0057','RICOCAN CLASICO ADULTO TODAS LAS RAZAS X3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(663,'T0058','RICOCAN MULTISABORES TODAS LAS RAZAS X3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(664,'T0059','RICOCAN CORDERO Y CEREALES X 15KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(665,'T0060','RICOCAN CARNE Y CEREALES X 15KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(666,'T0061','RICOCAN CACHORRO RAZA MEDIA Y GRANDE X 15KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(667,'T0062','RICOCAN CACHORRO RAZA PEQUEÑA X 15KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(668,'T0063','RICOCAN CLASICO ADULTO TODAS LAS RAZAS 15KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(669,'T0064','RICOCAN MULTISABORES TODAS LAS RAZAS X15KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(670,'T0065','RICOCAN CORDERO Y CEREALES X 22KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(671,'T0066','RICOCAN CARNE Y CEREALES X 22KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(672,'T0067','RICOCAN CACHORRO RAZA MEDIA Y GRANDE X 22KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(673,'T0068','RICOCAN CACHORRO RAZA PEQUEÑA X 22KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(674,'T0069','RICOCAN CLASICO ADULTO TODAS LAS RAZAS 22KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(675,'T0070','RICOCAN MULTISABORES TODAS LAS RAZAS X22KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(676,'T0071','PATE RICOCAN  CARNE LATA GRANDE ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(677,'T0072','PATE RICOCAN  POLLO LATA GRANDE ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(678,'T0073','PATE RICOCAN CORDERO LATA GRANDE ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(679,'T0074','PATE RICOCAN  CARNE LATA PEQUEÑA ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(680,'T0075','PATE RICOCAN  POLLO LATA PEQUEÑA','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(681,'T0076','PATE RICOCAN CORDERO LATA PEQUEÑA','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(682,'T0077','PATE RICOCAN CACHORRO LATA GRANDE ','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(683,'T0078','PATHE RICOCAN CACHORRO LATA PEQUEÑA','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(684,'T0079','RICOCRACK CACHORRO MULTISABORES X 200 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(685,'T0080','RICOCRACK ADULTO PEQUEÑO MEDIANO CLASICO X 200 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(686,'T0081','RICOCRACK ADULTO PEQUEÑO MEDIANO MULTISABORES X 200 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(687,'T0082','RICOCRACK CACHORRO  CLASICO X 200 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(688,'T0083','SUPER CAN   CORDERO Y CEREALES X18 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(689,'T0084','SUPER CAN    ADULTO CARNE X18 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(690,'T0085','SUPER CAN   CORDERO Y CEREALES X1 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(691,'T0086','SUPER CAN    ADULTO CARNE X 1 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(692,'T0087','SUPER CAN   CORDERO Y CEREALES X 4 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(693,'T0088','SUPER CAN    ADULTO CARNE X4 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(694,'T0089','SUPER CAN   CORDERO Y CEREALES X 500KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(695,'T0090','SUPER CAN    ADULTO CARNE X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(696,'T0091','CAMBO SUPER PREMIUM  CACHORRO CORDERO RZ GRANDE X 3KG','','','NO',4,2,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(697,'T0092','NUTRICAN ADULTO X 25 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(698,'T0093','NUTRICAN  CACHORRO X 25 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(699,'T0094','WHISKAS CARNE RECETA ORIGINAL X 500 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(700,'T0095','WHISKAS GATITOS X 1.5 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(701,'T0096','WHISKAS GATITOS X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(702,'T0097','WHISKAS GATITOS X 3 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(703,'T0098','WHISKAS POLLO Y LECHE X 8 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(704,'T0099','WHISKAS POLLO Y LECHE X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(705,'T0100','WHISKAS POLLO Y LECHE X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(706,'T0101','WHISKAS POLLO Y LECHE X 1.5 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(707,'T0102','WHISKAS SALMON X 10 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(708,'T0103','WHISKAS CAMARON Y CORVINA X 8 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(709,'T0104','WHISKAS GATITOS  CARNE Y LECHE X 8 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(710,'T0105','WHISKAS CAMARON Y CORVINA X3 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(711,'T0106','WHISKAS CAMARON Y CORVINA  X 500GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(712,'T0107','WHISKAS PESCADO X 8KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(713,'T0108','WHISKAS POUCH  PAVO X 85 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(714,'T0109','WHISKAS POUCH  SALMON X 85 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(715,'T0110','WHISKAS POUCH  CARNE X 85 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(716,'T0111','WHISKAS GATITOS POUCH  CARNE X 85 GR','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(717,'T0112','SUPER CAT ADULTO POLLO Y ATÚN X 9KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(718,'T0113','SUPER CAT SARDINA Y ATUN X500KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(719,'T0114','SUPER CAT ADULTO POLLO Y ATÚN X 500KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(720,'T0115','SUPER CAT SARDINA Y ATUN X1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(721,'T0116','SUPER CAT ADULTO POLLO Y ATÚN X 1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(722,'T0117','SUPER CAT SARDINA Y ATUN X3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(723,'T0118','SUPER CAT ADULTO POLLO Y ATÚN X 3KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(724,'T0119','RICOCAT  ATUN SARDINA TRUCHA X9 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(725,'T0120','RICOCAT  CARNR Y LECHE X 9 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(726,'T0121','RICOCAT GATITOS CARNE PESCADO Y LECHE X9 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(727,'T0122','RICOCAT POLLO SARDINAS X 9 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(728,'T0123','CAT CHOW GATITOS LECHE CARNE Y PESCADO X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(729,'T0124','CAT CHOW  ADULTO CARNE  X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(730,'T0125','CAT CHOW ADULTO CARNE Y PESCADO X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(731,'T0126','CAT CHOW ADULTO PESCADOS Y MARISCOS X 500 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(732,'T0127','CAT CHOW GATITOS LECHE CARNE Y PESCADO X 1 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(733,'T0128','CAT CHOW  ADULTO CARNE  X 1 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(734,'T0129','CAT CHOW ADULTO CARNE Y PESCADO X 1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(735,'T0130','CAT CHOW ADULTO PESCADOS Y MARISCOS X 1KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(736,'T0131','CAT CHOW GATITOS LECHE CARNE Y PESCADO X 8KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(737,'T0132','CAT CHOW  ADULTO CARNE  X 8 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(738,'T0133','CAT CHOW ADULTO CARNE Y PESCADO X 8KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(739,'T0134','CAT CHOW ADULTO PESCADOS Y MARISCOS X 8KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(740,'T0135','CAT CHOW GATITOS LECHE CARNE Y PESCADO X 1.5KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(741,'T0136','CAT CHOW  ADULTO CARNE  X 1.5 KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(742,'T0137','CAT CHOW ADULTO CARNE Y PESCADO X 1.5KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(743,'T0138','CAT CHOW ADULTO PESCADOS Y MARISCOS X 1.5KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(744,'T0139','CAT CHOW GATITOS LECHE CARNE Y PESCADO X 1.5KG','','','NO',4,2,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_productohistorial`
--

DROP TABLE IF EXISTS `tb_productohistorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_productohistorial` (
  `int_idProductoHistorial` int(11) NOT NULL AUTO_INCREMENT,
  `int_idProveedor` int(11) NOT NULL,
  `int_idProducto` int(11) NOT NULL,
  `dbl_precio` double NOT NULL,
  `dbl_descuento` double DEFAULT NULL,
  `dbl_peso` double DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idProductoHistorial`),
  KEY `fk_tb_PP` (`int_idProveedor`,`int_idProducto`),
  CONSTRAINT `fk_tb_PP` FOREIGN KEY (`int_idProveedor`, `int_idProducto`) REFERENCES `tb_proveedorproducto` (`int_idProveedor`, `int_idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_productohistorial`
--

LOCK TABLES `tb_productohistorial` WRITE;
/*!40000 ALTER TABLE `tb_productohistorial` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_productohistorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_proveedor` (
  `int_idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `str_razonSocial` varchar(500) NOT NULL,
  `str_nombreComercial` varchar(200) DEFAULT NULL,
  `str_ruc` varchar(15) NOT NULL,
  `str_direccion` varchar(200) DEFAULT NULL,
  `str_email` varchar(150) DEFAULT NULL,
  `str_telefono` varchar(45) DEFAULT NULL,
  `str_fax` varchar(45) DEFAULT NULL,
  `str_representanteLegal` varchar(150) DEFAULT NULL,
  `str_banco` varchar(45) DEFAULT NULL,
  `str_ctaPrincipal` varchar(45) DEFAULT NULL,
  `str_ctaAlternativa` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  PRIMARY KEY (`int_idProveedor`),
  UNIQUE KEY `str_ruc_UNIQUE` (`str_ruc`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES (1,'COAGROVET  E.I.R.L.','','20118383088','Jr Ricardo Basadre 201 - Magdalena','','(01)4621232 - # 907411','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(2,'SANTA ROSA S.A','AGROVETERINARIO SANTA ROSA S.A.','20110515376','San Juan de Amancaes MZ 7 Lote 9 Rimac','info@agrovetsantarosa.com','3816398 - 382982','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(3,'BANG ','BANG S.A. ','20101063896','AV. Los Frutales N°391 ATE -LIMA','bangsa@infotex.com.pe','2501113 - #521026','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(4,'ALTIPLANO S.A','Compañia Industrial  Altiplano s.a.','20383760471','San Juan de Amancaes MZ 7  Lote 9-A RIMAC - LIMA','info@shampooamigo.com','3823982 - 3816398','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(5,'VETLINE X','INVERSIONES VETLINEX  E.I.R.L','20557077741','Av. Universitaria Norte N°199 A.H Urb. Perú - San Martin de Porres','vetlinex@yahoo.es','5690329 - *946850 - 961586541','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(6,'TOP VETERINARIA DEL SUR S.A C.','','20551980805','AV. Circunvalacion N°2673-1°piso-Ate','topveterinariadelsur1@gmail.com','4361359 - # 976503000 -# 975234000','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(7,'AGROPSA','Agroindustria Norperuana S.A','20374817770','Jr.AgustoB.Leguia N°473 LIMA - LIMA','ventas@agropsa.com.pe','5474769','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(8,'AGROVETmarket S.A.','','20250406941','Carretera Antigua Panamericana del Sur Km.29.5 - Lurin','','4352323 - 7190105','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(9,'CTAMA INVERSIONES S.A.C.','','20544556828','AV. SUCRE N° 180 Pueblo Libre','otamainversiones@yahoo.es','2656635','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(10,'MOSER IMPRESS E.I.R.L','','20451408578','URB SGTO Lores  Q-4 - IQUITOS','','96510442 - *291919 - # 938085','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(11,'ALCIMAR S MEDIC S.A.C.','','20515631829','Jr.Moquegua N° 613 - LIMA','ventas@alcimarsmedic.com','4243612 - 4241190','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(12,'BIOMONT',' Laboratorios Biomont S.A. ','20100278708','AV.Industrial 184 - ATE','ventas@biomont.com pe','2062700 - 2062701 - 2062702','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(13,'COMERCIALIZADORA SAN JUAN S.A.C.','','20451319800','Calle Augusto Freyre N°737 - CALLE Samanez Ocampo N°819','comercializadorasanjuan@hotmail.com','233695 - 241603','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(14,'JORGE BARON S.A.C.','','20541259768','MZ. S LOTE 6 URB. Rio Mar Belen - MAYNAS','','065-264508 - 948575217 - # 948575217','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(15,'NEGOCIACIONES EL PARANA S.A.C.','','20541127349','CALLE  Moore N° 1338 - IQUITOS','','065-359112 - 942944635 - 965686820','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(16,'FAIPET E.I.R.L.','','20510113501','Jr. Ayacucho N°568 San Juan de Lurigancho  - LIMA','faipet@hotmail.com','4270364 - 3924840 - 4280654','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(17,'ROkASD ','ROKASD DISTRIBUCIONES  E.R.L.','20546303790','Jr.Ayacucho 550 int.15 - LIMA CERCADO','rokasdistribuciones@hotmail.com','0051-1-427-3667','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(18,'ACCE CAN E.I.R.L.','','20505681721','Jr.Arturo Suarez N°199 - Urb. San Juan - SAN JUAN DE MIRAFLORES','','4509709 - NEXTEL  99-830*1245 ','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(19,'DISTRIBUIDORA  ZELMAR   ','FRANCISCO JOSE CORDOVA','10402588689','Jr. CATAC 387 - Urb. Parque naranjal - LOS OLIVOS - LIMA','','991121680','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(20,'TRANSBER S.A.C','','20101158927','CALLE Cadmio129-135 Urb.Ind. Grimanesa -CALLAO -LIMA','','5721312','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(21,'ONCOFARM  S.A.','','20107015371','Av.Guardia Civil 571 - SAN BORJA','','2242473','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(22,'VET PRODUCT´S','H&P DISTRIBUCIONES  Y REPRESENTACIONES SAC.','20514564087','CAL CAYETANO HEREDIA NRO 571 - JESUS MARIA - LIMA LIMA ','vetproducts@hotmail.com','2611418 - 981178795 - 981188360','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(23,'LASSIE CAN','CARLA  MARIA ANGULO CHUNGA','10469786272','JR MIROQUEZADA 559 INT.02 -LIMA - LIMA ','','4283022 - 4282837','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(24,'DISTRIBUIDORA DEZA','TENAZOA DEZA MOISES','10422193605','CALLE CATAC  387- URB  PARQUE EL NARANJAL LOS OLIVOS  - LIMA - PERU','','','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(25,'LABORATORIOS PORTUGAL SRL','','20100204330','PARQUE INDUSTRIAL RIO SECO 1ERA ETAPAMZ A LOTE 2C COLORADO  - AREQUIPA -  PERU','labportugal@laboratoriosportugal.com','054 - 316031','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(26,'DOGUI CAM','','**********1','Jr. Prolongación Gamarra Nº 705 -  LA VICTORIA','','661-5462    404-7932 ','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(27,'ROSANGELA EIRL','IMPORTACIONES Y DISTRIBUICIONES ROSANGELA','20528244352','CALLE MI PERU N°579','','065- 233825  #954953109','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(28,'PANIFICA LORETO S R L','','20493617771','CALLE CAHUIDE N°589 PUNCHANA MAYNAS LORETO','','','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(29,'TQC','TECNOLOGIA QUIMICA Y COMERCIO  S. A ','20307150981','AV SEPARADORA INDUSTRIAL MZ E LOTE 12 SANTA RAQUEL - ATE  LIMA PERU','','3481103','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(30,'LLIMPU PERU','','**********2','JR AYACUCHO 638 CALLAO','llimpu@gmail.com','01 - 4535080','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(31,'ONCOSALUD','','20101039910','','','','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(32,'LABORATORIOS LABET S.A','','20521698013','CALLE 53 MZ 142 LOTE 25  LIMA 39 PERU','ventas@laboratorioslabet.com.pe','01-5519691','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(33,'VARIADOS','','00000000001','SIN DIRECCION',' ',' ','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(34,'JORGE BARON SAC','','00000000002','SIN DIRECCION',' ',' ','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(35,'ANTIPLANO S.A','','00000000003','SIN DIRECCION',' ',' ','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05'),(36,'CO7','','00000000004','SIN DIRECCION',' ',' ','',',\',','',',\',','','ACTIVO','SISTEMA','2015-12-05');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedorproducto`
--

DROP TABLE IF EXISTS `tb_proveedorproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_proveedorproducto` (
  `int_idProveedor` int(11) NOT NULL,
  `int_idProducto` int(11) NOT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` datetime DEFAULT NULL,
  `str_modificarUsuario` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idProveedor`,`int_idProducto`),
  KEY `int_idProveedor` (`int_idProveedor`),
  KEY `int_idProducto` (`int_idProducto`),
  CONSTRAINT `int_idProducto` FOREIGN KEY (`int_idProducto`) REFERENCES `tb_producto` (`int_idProducto`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `int_idProveedor` FOREIGN KEY (`int_idProveedor`) REFERENCES `tb_proveedor` (`int_idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedorproducto`
--

LOCK TABLES `tb_proveedorproducto` WRITE;
/*!40000 ALTER TABLE `tb_proveedorproducto` DISABLE KEYS */;
INSERT INTO `tb_proveedorproducto` VALUES (1,10,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(1,11,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(1,12,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(1,32,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(1,78,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(1,123,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(1,125,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(1,126,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(2,370,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,22,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,23,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,57,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,65,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,66,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,67,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,68,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,69,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,70,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,71,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,72,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,73,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,90,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,91,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,104,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,115,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,116,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,117,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,127,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,128,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,129,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,130,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,131,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,132,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,355,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,356,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,357,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(3,358,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(4,31,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(4,74,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(4,367,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(4,369,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(4,396,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,25,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,49,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,372,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,374,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,377,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,380,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,382,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,383,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,384,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,385,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,386,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,387,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,388,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,389,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,390,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,398,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,399,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,400,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,401,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,402,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,405,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,406,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,407,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,408,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,409,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,410,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,411,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(5,412,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,1,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,2,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,5,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,18,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,48,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,63,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,86,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,92,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,94,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(6,124,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(7,346,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(7,347,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(7,378,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(7,397,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(7,404,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,4,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,6,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,7,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,17,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,24,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,33,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,35,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,39,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,40,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,62,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,87,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,88,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(8,366,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,349,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,350,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,351,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,352,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,353,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,354,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,359,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,360,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,361,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,362,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,363,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,364,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,365,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,375,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(9,376,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,8,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,19,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,26,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,27,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,28,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,29,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,30,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,36,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,41,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,42,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,43,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,45,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,47,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,50,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,51,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,52,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,53,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,54,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,55,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,56,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,58,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,59,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,60,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,64,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,75,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,76,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,79,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,80,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,81,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,82,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,83,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,84,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,85,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,89,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,95,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,97,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,98,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,99,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,100,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,101,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,102,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,103,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,105,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,106,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,107,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,108,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,109,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,110,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,111,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,112,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,113,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,114,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,121,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,134,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(11,371,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,3,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,9,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,13,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,14,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,15,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,16,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,21,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,34,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,38,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,44,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,46,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,61,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,96,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(12,118,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,606,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,607,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,608,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,609,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,610,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,611,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,612,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,613,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,625,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,626,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,627,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,628,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,629,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,630,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,631,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,632,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,633,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,634,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,635,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,636,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,637,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,638,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,639,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,640,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,641,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,642,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,643,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,644,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,645,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,728,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,729,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,730,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,731,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,732,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,733,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,734,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,735,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,736,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,737,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,738,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,739,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,740,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,741,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,742,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,743,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(13,744,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,135,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,136,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,137,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,141,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,143,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,149,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,150,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,153,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,154,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,158,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,163,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,164,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,165,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,166,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,167,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,168,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,169,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,170,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,171,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,188,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,200,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,208,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,209,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,211,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,212,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,213,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,214,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,215,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,216,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,217,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,218,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,219,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,220,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,221,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,222,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,223,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,224,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,225,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,226,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,231,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,232,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,233,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,234,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,235,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,236,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,237,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,238,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,239,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,261,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,262,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,263,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,264,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,271,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,272,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,273,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,274,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,275,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,276,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,277,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,278,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,279,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,280,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,281,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,282,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,283,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,284,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,285,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,286,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,309,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,310,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,311,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,312,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,373,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(16,559,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,138,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,139,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,140,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,142,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,151,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,152,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,155,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,156,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,157,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,159,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,160,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,161,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,162,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,203,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,204,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,205,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,206,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,207,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,210,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,227,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,228,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,229,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,230,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,287,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,288,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,289,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,290,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,291,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,292,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,293,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,294,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,295,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,296,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,297,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,298,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,299,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,300,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,301,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,302,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,303,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,304,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,305,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,306,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,307,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,308,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,313,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,314,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,315,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,316,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,317,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,318,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,319,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,320,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,321,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,322,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,323,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,324,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,325,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,326,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,327,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,328,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,329,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,330,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,331,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,332,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,333,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,334,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,335,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,336,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,337,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,338,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,339,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,340,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,341,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(17,342,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,181,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,182,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,183,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,184,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,185,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,186,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,187,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,189,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,190,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,191,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,192,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,193,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,194,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,195,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,196,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,197,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,198,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,199,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,201,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,202,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,413,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,414,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,415,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,416,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,417,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,418,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,419,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,420,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,421,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,422,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,423,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,424,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,425,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,426,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,427,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,428,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,429,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,430,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,431,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,432,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,433,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,434,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,435,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,436,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,437,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,438,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,439,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,440,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,441,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,442,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,443,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,444,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,445,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,446,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,447,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,448,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,449,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,450,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,451,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,452,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,453,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,454,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,455,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,456,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,457,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,458,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,459,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,460,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,461,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,462,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,463,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,464,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,465,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,466,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,467,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,468,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,469,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,471,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,472,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,473,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,474,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,475,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,476,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,477,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,478,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,479,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,480,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,481,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,482,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,483,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,484,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,485,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,486,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,487,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,488,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(18,490,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,144,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,145,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,146,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,147,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,148,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,172,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,173,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,174,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,175,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,176,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,177,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,178,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,179,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,180,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,240,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,241,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,242,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,243,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,244,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,245,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,246,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,247,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,248,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,249,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,250,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,251,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,252,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,253,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,254,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,255,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,256,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,257,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,258,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,259,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,260,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,265,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,266,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,267,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,268,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,269,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,270,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,343,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,344,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,560,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,561,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,562,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,563,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,564,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,565,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,566,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,567,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,568,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,569,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,570,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,571,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,572,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,573,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,574,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,575,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,576,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,577,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,578,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,579,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,580,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,581,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,582,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,583,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,584,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,585,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,586,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,587,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,588,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,589,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,590,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,591,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,592,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,593,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,594,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,595,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,596,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,597,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,598,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,599,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,600,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,601,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,602,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,603,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,604,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(23,605,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(24,77,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(25,20,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,470,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,489,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,491,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,492,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,493,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,494,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,495,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,496,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,497,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,498,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,499,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,500,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,501,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,502,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,503,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,504,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,505,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,506,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,507,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,508,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,509,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,510,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,511,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,512,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,513,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,514,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,515,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,516,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,517,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,518,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,519,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,520,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,521,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,522,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,523,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,524,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,525,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,526,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,527,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,528,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,529,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,530,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,531,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,532,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,533,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,534,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,535,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,536,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,537,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,538,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,539,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,540,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,541,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,542,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,543,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,544,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,545,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,546,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,547,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,548,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,549,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,550,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,551,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,552,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,553,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,554,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,555,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,556,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,557,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(26,558,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,646,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,647,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,648,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,649,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,650,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,651,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,652,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,653,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,654,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,655,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,656,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,657,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,658,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,659,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,660,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,661,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,662,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,663,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,664,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,665,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,666,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,667,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,668,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,669,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,670,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,671,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,672,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,673,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,674,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,675,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,676,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,677,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,678,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,679,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,680,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,681,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,682,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,683,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,684,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,685,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,686,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,687,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,688,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,689,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,690,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,691,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,692,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,693,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,694,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,695,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,696,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,717,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,718,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,719,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,720,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,721,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,722,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,723,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,724,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,725,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,726,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(27,727,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(28,697,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(28,698,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(30,348,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(31,133,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(32,120,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(33,37,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(33,93,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(33,119,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(33,122,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(33,345,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,614,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,615,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,616,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,617,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,618,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,619,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,620,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,621,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,622,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,623,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,624,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,699,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,700,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,701,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,702,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,703,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,704,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,705,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,706,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,707,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,708,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,709,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,710,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,711,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,712,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,713,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,714,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,715,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(34,716,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(35,368,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(35,392,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(35,393,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(35,394,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(35,395,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(36,379,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(36,381,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(36,391,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00'),(36,403,'ACTIVO','SISTEMA','0000-00-00 00:00:00','','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `tb_proveedorproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedorproductoordencompra`
--

DROP TABLE IF EXISTS `tb_proveedorproductoordencompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_proveedorproductoordencompra` (
  `int_idProveedor` int(11) NOT NULL,
  `int_idProducto` int(11) NOT NULL,
  `int_idOrdenCompra` int(11) NOT NULL,
  `dbl_cantidad` double NOT NULL,
  `dbl_precio` double NOT NULL,
  `dbl_descuento` double NOT NULL,
  `dbl_peso` double NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificacion` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idProveedor`,`int_idProducto`,`int_idOrdenCompra`),
  KEY `fk_tb_proveedorproducto` (`int_idProveedor`,`int_idProducto`),
  KEY `fk_tb_ordenCompra` (`int_idOrdenCompra`),
  CONSTRAINT `fk_tb_ordenCompra` FOREIGN KEY (`int_idOrdenCompra`) REFERENCES `tb_ordencompra` (`int_idOrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_proveedorproducto` FOREIGN KEY (`int_idProveedor`, `int_idProducto`) REFERENCES `tb_proveedorproducto` (`int_idProveedor`, `int_idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedorproductoordencompra`
--

LOCK TABLES `tb_proveedorproductoordencompra` WRITE;
/*!40000 ALTER TABLE `tb_proveedorproductoordencompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_proveedorproductoordencompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedorproductoordencomprafacturacompra`
--

DROP TABLE IF EXISTS `tb_proveedorproductoordencomprafacturacompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_proveedorproductoordencomprafacturacompra` (
  `int_idProveedor` int(11) NOT NULL,
  `int_idProducto` int(11) NOT NULL,
  `int_idOrdenCompra` int(11) NOT NULL,
  `int_idFacturaCompra` int(11) NOT NULL,
  `dbl_cantidadRecibida` double DEFAULT NULL,
  `str_numeroFactura` varchar(45) DEFAULT NULL,
  `int_idLocalRecibido` int(11) DEFAULT NULL,
  `str_fechaDocumento` varchar(45) DEFAULT NULL,
  `dbl_conformidadOK` double DEFAULT NULL,
  `dbl_conformidadFallaProveedor` double DEFAULT NULL,
  `dbl_conformidadFallaTransportista` double DEFAULT NULL,
  `dbl_conformidadFallaOtro` double DEFAULT NULL,
  `str_conformidadObservacion` varchar(45) DEFAULT NULL,
  `str_conformidadEstado` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idProveedor`,`int_idProducto`,`int_idOrdenCompra`,`int_idFacturaCompra`),
  KEY `fk_tb_PPOC` (`int_idProveedor`,`int_idProducto`,`int_idOrdenCompra`),
  KEY `fk_tb_facturaCompra` (`int_idFacturaCompra`),
  KEY `fk_tb_locales` (`int_idLocalRecibido`),
  CONSTRAINT `fk_tb_PPOC` FOREIGN KEY (`int_idProveedor`, `int_idProducto`, `int_idOrdenCompra`) REFERENCES `tb_proveedorproductoordencompra` (`int_idProveedor`, `int_idProducto`, `int_idOrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_facturaCompra` FOREIGN KEY (`int_idFacturaCompra`) REFERENCES `tb_facturacompra` (`int_idFacturaCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedorproductoordencomprafacturacompra`
--

LOCK TABLES `tb_proveedorproductoordencomprafacturacompra` WRITE;
/*!40000 ALTER TABLE `tb_proveedorproductoordencomprafacturacompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_proveedorproductoordencomprafacturacompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedorproductounidadmedida`
--

DROP TABLE IF EXISTS `tb_proveedorproductounidadmedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_proveedorproductounidadmedida` (
  `int_idProveedor` int(11) NOT NULL,
  `int_idProducto` int(11) NOT NULL,
  `int_idUnidadMedidaVenta` int(11) NOT NULL,
  `str_UnidadMedidaCompra` varchar(45) NOT NULL,
  `dbl_costoCompra` double DEFAULT NULL,
  `dbl_unidadesContenidas` double DEFAULT NULL,
  `dbl_precioUnidadContenida` double DEFAULT NULL,
  `dbl_costoTraslado` double DEFAULT NULL,
  `dbl_precioFinal` double NOT NULL,
  `dbl_precioOferta` double NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idProveedor`,`int_idProducto`,`int_idUnidadMedidaVenta`),
  KEY `fk_proveedorProducto` (`int_idProveedor`,`int_idProducto`),
  KEY `fk_unidadMedidaVenta` (`int_idUnidadMedidaVenta`),
  CONSTRAINT `fk_proveedorProducto` FOREIGN KEY (`int_idProveedor`, `int_idProducto`) REFERENCES `tb_proveedorproducto` (`int_idProveedor`, `int_idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_unidadMedidaVenta` FOREIGN KEY (`int_idUnidadMedidaVenta`) REFERENCES `tb_unidadmedida` (`int_idUnidadMedida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='el costo de compra corresponde a la ultima compra realizada ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedorproductounidadmedida`
--

LOCK TABLES `tb_proveedorproductounidadmedida` WRITE;
/*!40000 ALTER TABLE `tb_proveedorproductounidadmedida` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_proveedorproductounidadmedida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_refrigerio`
--

DROP TABLE IF EXISTS `tb_refrigerio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_refrigerio` (
  `id_refrigerio` int(11) NOT NULL AUTO_INCREMENT,
  `dt_horaSalida` datetime DEFAULT NULL,
  `dt_horaRegreso` datetime DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `int_asistencia` int(11) NOT NULL,
  PRIMARY KEY (`id_refrigerio`),
  KEY `fk_tb_refrigerio_1` (`int_asistencia`),
  CONSTRAINT `fk_tb_refrigerio_1` FOREIGN KEY (`int_asistencia`) REFERENCES `tb_asistencia` (`int_asistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_refrigerio`
--

LOCK TABLES `tb_refrigerio` WRITE;
/*!40000 ALTER TABLE `tb_refrigerio` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_refrigerio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipocambio`
--

DROP TABLE IF EXISTS `tb_tipocambio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipocambio` (
  `int_idTipoCambio` int(11) NOT NULL AUTO_INCREMENT,
  `dbl_precioCompraDolar` double NOT NULL,
  `dbl_precioVentaDolar` double NOT NULL,
  `str_fechaDia` date NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idTipoCambio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipocambio`
--

LOCK TABLES `tb_tipocambio` WRITE;
/*!40000 ALTER TABLE `tb_tipocambio` DISABLE KEYS */;
INSERT INTO `tb_tipocambio` VALUES (1,3.22,3.24,'2015-12-05','ACTIVO','SYSADMIN','2015-12-05 14:20:45',NULL,NULL);
/*!40000 ALTER TABLE `tb_tipocambio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipocontrato`
--

DROP TABLE IF EXISTS `tb_tipocontrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipocontrato` (
  `int_idTipoContrato` int(11) NOT NULL AUTO_INCREMENT,
  `str_tipoContrato` varchar(45) DEFAULT NULL,
  `str_nombreReporte` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_sextoArticulo` text,
  PRIMARY KEY (`int_idTipoContrato`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipocontrato`
--

LOCK TABLES `tb_tipocontrato` WRITE;
/*!40000 ALTER TABLE `tb_tipocontrato` DISABLE KEYS */;
INSERT INTO `tb_tipocontrato` VALUES (1,'CAJERO','Contrato_Final','ACTIVO','2012-04-22','SISTEMAS',NULL,NULL,'  Efectuar cortésmente la cobranza a los clientes.   Dar atención preferencial al cliente que viene a pagar.   Hacer firmar documentos válidos por las salidas de dinero con cua1quier concepto.   Exigir firma autorizada en los egresos de caja.   Reportar diaria y adecuadamente los ingresos del día.   Eliminar  favores de cambios de sencillo a terceros ajenos a la empresa.   Exigir el reporte de cobranzas de créditos reportados con la firma del que cobra.   Exigir cheque certificado por compras al contado a los clientes de Municipalidades.   Verificar los cobros con cheque que correspondan al titular que aparece en la factura, casos excepcionales reportar a la Administración.   Conciliar las emisiones de facturas y boletas con el total reportado de dinero, por ventas al contado.   Verificar la recepción de billetes falsos y monedas falsas.   Romper o hacer agujeros en los billetes falsos.   No permitir el acceso a ninguna persona a su área de trabajo.   Exigir identificación plena del titular (DNI), que van a cobrar algún pago.   Rellenar adecuadamente los formatos que usa diariamente, referente a ingresos o egresos.   Reportar cualquier falla de seguridad en salvaguarda del dinero que posea en custodia.   Mantener cerrada el cajón donde guarda el efectivo, producto de las cobranzas.   En las rotaciones ente cajeros exigir y presentar un arqueo de caja, debidamente firmado por el que recibe, el que entrega y de un auditor (personal de contabilidad).   Fomentar el compañerismo, el trabajo en equipo y el debido respeto entre todo el personal de la tienda.   Presentar sus reclamos y sugerencias por escrito al jefe inmediato.   Informar de las actitudes sospechosas que se susciten en la tienda, que considere que afecta o pueda causar futuras pérdidas de dinero.'),(2,'VENDEDOR','Contrato_Final','ACTIVO','2012-05-01','SISTEMAS',NULL,NULL,'  Mantener el orden y limpieza de las instalaciones de la tienda.   Mantener constantemente limpio los productos.   Atender con cortesía y eficiencia a los clientes.   Asesorar, demostrar y explicar utilidad del producto a los clientes que no  deciden que producto comprar.   Cuidar y mantener seguro la mercadería que se encuentra en exhibición.   Sugerir y fomentar la compra de productos de alta rotación.   Sugerir e informar al jefe inmediato con copia a la Gerencia, de los productos que tengan poca rotación.   Sugerir promoción de productos lenta o nula rotación.   Mantenerse informado e informar a su jefe inmediato, con copia a la Gerencia, de los precios de productos similares iguales que   comercializa la competencia.   Sugerir al jefe inmediato, con copia a la Gerencia, de los productos que los clientes quieren y no tenemos en stock.    No hacer comentarios externos sobre el nivel de ventas, el precio de los productos, las políticas de ventas y en general cualquier información que se maneje para los intereses de la empresa.   No hacer comentarios externos sobre la condición física, mental o moral entre compañeros de trabajo.   Fomentar el compañerismo y trabajo en equipo.   Fomentar y sugerir reuniones permanentes de trabajo sobre formas de atender a los clientes y hacer constante campaña de presentación de los productos, de acuerdo a los meses del año.   Informar sobre los problemas que surgen en el sistema.   Sugerir mejoras en el manejo del sistema de ventas.'),(3,'SECRETARIA Y CAJERA','Contrato_Final','ACTIVO','2012-05-01','SISTEMAS',NULL,NULL,'- Recibir e informar asuntos que tenga que ver con el departamento correspondiente, para que todos estemos informados y desarrollar bien el trabajo asignado. - Mantener discreción sobre todo lo que respecta a la empresa. - Hacer y recibir llamadas telefónicas para tener informado a los jefes de los compromisos y demás asuntos. - Obedecer y realizar instrucciones que te sean asignadas por tú jefe inmediato. - Administrar y organizar el acervo documentario correspondiente al pago de obligaciones de la empresa. - Recepcionar toda la documentación de facturas de proveedores que ingresa a la Empresa, para ingresar al flujo  de caja para su programación de pago correspondiente. - Revisar y verificar el pago de la documentación que se ha realizado en el día, Para  evitar pagos indebidos que será responsabilidad de la tesorera.'),(4,'ENCARGADO DE SISTEMAS','Contrato_Final','ACTIVO','2012-05-01','SISTEMAS',NULL,NULL,'Mantener las computadoras operativas.  Mantener constantemente informado a los Jefes de Tienda como se puede arreglar los problemas que ocasionan el sistema por la congestión de red, y/o antena. Solucionar los problemas de reportes de caja, de las tiendas, cuando hacen facturaciones a manos y/o por error de sistema para el cuadre de sus cajas por cada tienda. Asesorar, enseñar el manejo del sistema al personal nuevo de venta,  administración para mejoras de la empresa.   Informar sobre los problemas que surgen en el sistema.  Sugerir mejoras en el manejo del sistema de ventas.'),(5,'JEFE DE ALMACEN','Contrato_Final','ACTIVO','2012-05-01','SISTEMAS',NULL,NULL,' Recepcionar la mercadería, verificando el buen estado presentación coordinado con su jefe inmediato cuando requiera apoyo. -Ordenar la mercadería y efectuar las entregas.  Codificar, etiquetar y ordenar la mercadería y efectuar las entregas correspondientes a las tiendas.  Rotar las mercaderías  en exhibición y sellar las cajas vacías mientras están en exhibición  Controlar que los registros de ingresos y salidas de mercaderías, se encuentren registrados debidamente el KARDEX del sistema mecanizado.   Efectuar y promover inventarios físicos diarios, semanal, mensual o bimensual, de chequeo preventivo, de los productos de mayor movimiento y de los de mayor precio y conciliarlos con los sistemas, dando cuenta a su jefatura de las diferencias encontradas.   Mantener limpio las instalaciones de los almacenes, pasadizos, lugar de almacenaje y servicios higiénicos.   Colaborar con la demostración algún producto al cliente, sobre la utilidad del producto, calidad y durabilidad, cuando la situación se amerite.   Mantener el ambiente del almacén exclusivamente accesible para ese fin, evitando el ingreso de personal no autorizado y velar por la seguridad de la mercadería bajo su responsabilidad.   De existir daños en la mercadería por mal manipuleo, informar al jefe de tienda, identificando al responsable del acto negligente.   Elaborar y hacer cumplir la relación de turnos para aseo de los servicios higiénicos.  Mantener las zonas de libre tránsito, libres y accesibles en casos de evacuaciones de emergencia, informar los vencimientos de los extinguidores.   Cumplir y hacer cumplir con el reglamento interno de la empresa.  Actualizar los BINCARD de mercadería.   Asumir las diferencias de inventario junto con los demás integrantes del almacén general. -Cumplir con las demás funciones afines que le asigne su jefe inmediato.'),(6,'ALMACENERO','Contrato_Final','ACTIVO','2012-05-01','SISTEMAS',NULL,NULL,'- Realizar la carga y descarga de mercaderías que ingresan y salen de los almacenes. - Verificar al detalle lo consignado en la factura o guía, teniendo en cuenta su estado de conservación, peso y cantidad consignada por el transportista. - Codificar y etiquetar la mercadería recibida. - Apoyar al Jefe de Almacén en el de reparto de mercadería, hacia las tiendas de venta, de manera inmediata y en su totalidad. - Mantener limpio las instalaciones de los almacenes, pasadizos, lugar de almacenaje y servicios higiénicos.   - Mantener las zonas de libre tránsito, libres y accesibles en casos de evacuaciones de emergencia, informar oportunamente los vencimientos de uso, de extinguidores. - Cumplir  el reglamento interno de la empresa. - Apoyar al Jefe de Almacén a mantener actualizado los BINCARD de mercadería. - Informar a su jefe inmediato qué mercadería llega faltante, deteriorado y con cual transportista. - Informar a su jefe inmediato de las mercaderías en mal estado.'),(7,'ASISTENTE ADMINISTRATIVO','Contrato_Final','ACTIVO','2012-05-01','SISTEMAS',NULL,NULL,'- Ordenar y procesar la documentación que servirá de fuente base para realizar los trámites de  reintegro tributario que realiza la empresa. - Coordinar con el Contador de la empresa los trámites a realizar para el reintegro tributario ante SUNAT. - Estar informándose permanentemente de nuevos productos que tienen el beneficio del reintegro tributario. - Las demás funciones que lo asigne sus jefes superiores. -Informar diariamente de las Gestiones de Reintegro efectuadas. -Informar diariamente de su ubicación fuera de la empresa. -Realizar inventarios periódicos en los almacenes.');
/*!40000 ALTER TABLE `tb_tipocontrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipodocumentosalida`
--

DROP TABLE IF EXISTS `tb_tipodocumentosalida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipodocumentosalida` (
  `int_idTipoDocumento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_descripcion` varchar(45) NOT NULL,
  `str_NomCorto` varchar(45) NOT NULL,
  PRIMARY KEY (`int_idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipodocumentosalida`
--

LOCK TABLES `tb_tipodocumentosalida` WRITE;
/*!40000 ALTER TABLE `tb_tipodocumentosalida` DISABLE KEYS */;
INSERT INTO `tb_tipodocumentosalida` VALUES (1,'BOLETA','B'),(2,'FACTURA','F'),(3,'GUIA REMISION','GR'),(4,'TICKET','TK');
/*!40000 ALTER TABLE `tb_tipodocumentosalida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipomarcado`
--

DROP TABLE IF EXISTS `tb_tipomarcado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipomarcado` (
  `int_tipoMarcado` varchar(1) NOT NULL,
  `str_descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_tipoMarcado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipomarcado`
--

LOCK TABLES `tb_tipomarcado` WRITE;
/*!40000 ALTER TABLE `tb_tipomarcado` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tipomarcado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipomovimiento`
--

DROP TABLE IF EXISTS `tb_tipomovimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipomovimiento` (
  `int_idTipoMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `str_descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`int_idTipoMovimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipomovimiento`
--

LOCK TABLES `tb_tipomovimiento` WRITE;
/*!40000 ALTER TABLE `tb_tipomovimiento` DISABLE KEYS */;
INSERT INTO `tb_tipomovimiento` VALUES (1,'INGRESO POR COMPRA'),(2,'SALIDA POR VENTA'),(3,'INGRESO POR TRASLADO'),(4,'SALIDA POR TRASLADO'),(5,'INGRESO POR DEVOLUCION');
/*!40000 ALTER TABLE `tb_tipomovimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipoobligacion`
--

DROP TABLE IF EXISTS `tb_tipoobligacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipoobligacion` (
  `int_idTipoObligacion` int(11) NOT NULL AUTO_INCREMENT,
  `str_nombreTO` varchar(45) NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `str_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idTipoObligacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipoobligacion`
--

LOCK TABLES `tb_tipoobligacion` WRITE;
/*!40000 ALTER TABLE `tb_tipoobligacion` DISABLE KEYS */;
INSERT INTO `tb_tipoobligacion` VALUES (1,'EFECTIVO','ACTIVO','SISTEMAS','2012-10-21 00:00:00',NULL,NULL),(2,'CREDITO','ACTIVO','SISTEMAS','2012-10-21 00:00:00',NULL,NULL),(3,'LETRAS','ACTIVO','SISTEMAS','2012-10-21 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `tb_tipoobligacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_traspasointerno`
--

DROP TABLE IF EXISTS `tb_traspasointerno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_traspasointerno` (
  `int_idTraspasointerno` int(11) NOT NULL AUTO_INCREMENT,
  `int_idGuiaRemision` int(11) NOT NULL,
  `str_codigoAutoriza` varchar(45) DEFAULT NULL,
  `str_codigoConfirma` varchar(45) DEFAULT NULL,
  `dte_fechaAutoriza` datetime DEFAULT NULL,
  `dte_fechaConfirma` datetime DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioModifcador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  PRIMARY KEY (`int_idTraspasointerno`),
  KEY `fk_tb_traspasointerno_1` (`int_idGuiaRemision`),
  CONSTRAINT `fk_tb_traspasointerno_1` FOREIGN KEY (`int_idGuiaRemision`) REFERENCES `tb_guiaremision` (`int_idGuiaremision`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_traspasointerno`
--

LOCK TABLES `tb_traspasointerno` WRITE;
/*!40000 ALTER TABLE `tb_traspasointerno` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_traspasointerno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ubigeo`
--

DROP TABLE IF EXISTS `tb_ubigeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ubigeo` (
  `CodDpto` varchar(2) DEFAULT '0',
  `CodProv` varchar(2) DEFAULT '0',
  `CodDist` varchar(2) DEFAULT '0',
  `Nombre` varchar(50) DEFAULT NULL,
  KEY `index_ubigeo` (`CodDpto`,`CodProv`,`CodDist`),
  KEY `index_depa` (`CodDpto`),
  KEY `index_prov` (`CodProv`),
  KEY `index_dist` (`CodDist`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ubigeo`
--

LOCK TABLES `tb_ubigeo` WRITE;
/*!40000 ALTER TABLE `tb_ubigeo` DISABLE KEYS */;
INSERT INTO `tb_ubigeo` VALUES ('01','00','00','AMAZONAS\r'),('01','01','00','CHACHAPOYAS\r'),('01','01','01','CHACHAPOYAS\r'),('01','01','02','ASUNCION\r'),('01','01','03','BALSAS\r'),('01','01','04','CHETO\r'),('01','01','05','CHILIQUIN\r'),('01','01','06','CHUQUIBAMBA\r'),('01','01','07','GRANADA\r'),('01','01','08','HUANCAS\r'),('01','01','09','LA JALCA\r'),('01','01','10','LEIMEBAMBA\r'),('01','01','11','LEVANTO\r'),('01','01','12','MAGDALENA\r'),('01','01','13','MARISCAL CASTILLA\r'),('01','01','14','MOLINOPAMPA\r'),('01','01','15','MONTEVIDEO\r'),('01','01','16','OLLEROS\r'),('01','01','17','QUINJALCA\r'),('01','01','18','SAN FRANCISCO DE DAGUAS\r'),('01','01','19','SAN ISIDRO DE MAINO\r'),('01','01','20','SOLOCO\r'),('01','01','21','SONCHE\r'),('01','02','00','BAGUA\r'),('01','02','01','BAGUA\r'),('01','02','02','ARAMANGO\r'),('01','02','03','COPALLIN\r'),('01','02','04','EL PARCO\r'),('01','02','05','IMAZA\r'),('01','02','06','LA PECA\r'),('01','03','00','BONGARA\r'),('01','03','01','JUMBILLA\r'),('01','03','02','CHISQUILLA\r'),('01','03','03','CHURUJA\r'),('01','03','04','COROSHA\r'),('01','03','05','CUISPES\r'),('01','03','06','FLORIDA\r'),('01','03','07','JAZAN\r'),('01','03','08','RECTA\r'),('01','03','09','SAN CARLOS\r'),('01','03','10','SHIPASBAMBA\r'),('01','03','11','VALERA\r'),('01','03','12','YAMBRASBAMBA\r'),('01','04','00','CONDORCANQUI\r'),('01','04','01','NIEVA\r'),('01','04','02','EL CENEPA\r'),('01','04','03','RIO SANTIAGO\r'),('01','05','00','LUYA\r'),('01','05','01','LAMUD\r'),('01','05','02','CAMPORREDONDO\r'),('01','05','03','COCABAMBA\r'),('01','05','04','COLCAMAR\r'),('01','05','05','CONILA\r'),('01','05','06','INGUILPATA\r'),('01','05','07','LONGUITA\r'),('01','05','08','LONYA CHICO\r'),('01','05','09','LUYA\r'),('01','05','10','LUYA VIEJO\r'),('01','05','11','MARIA\r'),('01','05','12','OCALLI\r'),('01','05','13','OCUMAL\r'),('01','05','14','PISUQUIA\r'),('01','05','15','PROVIDENCIA\r'),('01','05','16','SAN CRISTOBAL\r'),('01','05','17','SAN FRANCISCO DEL YESO\r'),('01','05','18','SAN JERONIMO\r'),('01','05','19','SAN JUAN DE LOPECANCHA\r'),('01','05','20','SANTA CATALINA\r'),('01','05','21','SANTO TOMAS\r'),('01','05','22','TINGO\r'),('01','05','23','TRITA\r'),('01','06','00','RODRIGUEZ DE MENDOZA\r'),('01','06','01','SAN NICOLAS\r'),('01','06','02','CHIRIMOTO\r'),('01','06','03','COCHAMAL\r'),('01','06','04','HUAMBO\r'),('01','06','05','LIMABAMBA\r'),('01','06','06','LONGAR\r'),('01','06','07','MARISCAL BENAVIDES\r'),('01','06','08','MILPUC\r'),('01','06','09','OMIA\r'),('01','06','10','SANTA ROSA\r'),('01','06','11','TOTORA\r'),('01','06','12','VISTA ALEGRE\r'),('01','07','00','UTCUBAMBA\r'),('01','07','01','BAGUA GRANDE\r'),('01','07','02','CAJARURO\r'),('01','07','03','CUMBA\r'),('01','07','04','EL MILAGRO\r'),('01','07','05','JAMALCA\r'),('01','07','06','LONYA GRANDE\r'),('01','07','07','YAMON\r'),('02','00','00','ANCASH\r'),('02','01','00','HUARAZ\r'),('02','01','01','HUARAZ\r'),('02','01','02','COCHABAMBA\r'),('02','01','03','COLCABAMBA\r'),('02','01','04','HUANCHAY\r'),('02','01','05','INDEPENDENCIA\r'),('02','01','06','JANGAS\r'),('02','01','07','LA LIBERTAD\r'),('02','01','08','OLLEROS\r'),('02','01','09','PAMPAS\r'),('02','01','10','PARIACOTO\r'),('02','01','11','PIRA\r'),('02','01','12','TARICA\r'),('02','02','00','AIJA\r'),('02','02','01','AIJA\r'),('02','02','02','CORIS\r'),('02','02','03','HUACLLAN\r'),('02','02','04','LA MERCED\r'),('02','02','05','SUCCHA\r'),('02','03','00','ANTONIO RAYMONDI\r'),('02','03','01','LLAMELLIN\r'),('02','03','02','ACZO\r'),('02','03','03','CHACCHO\r'),('02','03','04','CHINGAS\r'),('02','03','05','MIRGAS\r'),('02','03','06','SAN JUAN DE RONTOY\r'),('02','04','00','ASUNCION\r'),('02','04','01','CHACAS\r'),('02','04','02','ACOCHACA\r'),('02','05','00','BOLOGNESI\r'),('02','05','01','CHIQUIAN\r'),('02','05','02','ABELARDO PARDO LEZAMETA\r'),('02','05','03','ANTONIO RAYMONDI\r'),('02','05','04','AQUIA\r'),('02','05','05','CAJACAY\r'),('02','05','06','CANIS\r'),('02','05','07','COLQUIOC\r'),('02','05','08','HUALLANCA\r'),('02','05','09','HUASTA\r'),('02','05','10','HUAYLLACAYAN\r'),('02','05','11','LA PRIMAVERA\r'),('02','05','12','MANGAS\r'),('02','05','13','PACLLON\r'),('02','05','14','SAN MIGUEL DE CORPANQUI\r'),('02','05','15','TICLLOS\r'),('02','06','00','CARHUAZ\r'),('02','06','01','CARHUAZ\r'),('02','06','02','ACOPAMPA\r'),('02','06','03','AMASHCA\r'),('02','06','04','ANTA\r'),('02','06','05','ATAQUERO\r'),('02','06','06','MARCARA\r'),('02','06','07','PARIAHUANCA\r'),('02','06','08','SAN MIGUEL DE ACO\r'),('02','06','09','SHILLA\r'),('02','06','10','TINCO\r'),('02','06','11','YUNGAR\r'),('02','07','00','CARLOS FERMIN FITZCARRALD\r'),('02','07','01','SAN LUIS\r'),('02','07','02','SAN NICOLAS\r'),('02','07','03','YAUYA\r'),('02','08','00','CASMA\r'),('02','08','01','CASMA\r'),('02','08','02','BUENA VISTA ALTA\r'),('02','08','03','COMANDANTE NOEL\r'),('02','08','04','YAUTAN\r'),('02','09','00','CORONGO\r'),('02','09','01','CORONGO\r'),('02','09','02','ACO\r'),('02','09','03','BAMBAS\r'),('02','09','04','CUSCA\r'),('02','09','05','LA PAMPA\r'),('02','09','06','YANAC\r'),('02','09','07','YUPAN\r'),('02','10','00','HUARI\r'),('02','10','01','HUARI\r'),('02','10','02','ANRA\r'),('02','10','03','CAJAY\r'),('02','10','04','CHAVIN DE HUANTAR\r'),('02','10','05','HUACACHI\r'),('02','10','06','HUACCHIS\r'),('02','10','07','HUACHIS\r'),('02','10','08','HUANTAR\r'),('02','10','09','MASIN\r'),('02','10','10','PAUCAS\r'),('02','10','11','PONTO\r'),('02','10','12','RAHUAPAMPA\r'),('02','10','13','RAPAYAN\r'),('02','10','14','SAN MARCOS\r'),('02','10','15','SAN PEDRO DE CHANA\r'),('02','10','16','UCO\r'),('02','11','00','HUARMEY\r'),('02','11','01','HUARMEY\r'),('02','11','02','COCHAPETI\r'),('02','11','03','CULEBRAS\r'),('02','11','04','HUAYAN\r'),('02','11','05','MALVAS\r'),('02','12','00','HUAYLAS\r'),('02','12','01','CARAZ\r'),('02','12','02','HUALLANCA\r'),('02','12','03','HUATA\r'),('02','12','04','HUAYLAS\r'),('02','12','05','MATO\r'),('02','12','06','PAMPAROMAS\r'),('02','12','07','PUEBLO LIBRE\r'),('02','12','08','SANTA CRUZ\r'),('02','12','09','SANTO TORIBIO\r'),('02','12','10','YURACMARCA\r'),('02','13','00','MARISCAL LUZURIAGA\r'),('02','13','01','PISCOBAMBA\r'),('02','13','02','CASCA\r'),('02','13','03','ELEAZAR GUZMAN BARRON\r'),('02','13','04','FIDEL OLIVAS ESCUDERO\r'),('02','13','05','LLAMA\r'),('02','13','06','LLUMPA\r'),('02','13','07','LUCMA\r'),('02','13','08','MUSGA\r'),('02','14','00','OCROS\r'),('02','14','01','OCROS\r'),('02','14','02','ACAS\r'),('02','14','03','CAJAMARQUILLA\r'),('02','14','04','CARHUAPAMPA\r'),('02','14','05','COCHAS\r'),('02','14','06','CONGAS\r'),('02','14','07','LLIPA\r'),('02','14','08','SAN CRISTOBAL DE RAJAN\r'),('02','14','09','SAN PEDRO\r'),('02','14','10','SANTIAGO DE CHILCAS\r'),('02','15','00','PALLASCA\r'),('02','15','01','CABANA\r'),('02','15','02','BOLOGNESI\r'),('02','15','03','CONCHUCOS\r'),('02','15','04','HUACASCHUQUE\r'),('02','15','05','HUANDOVAL\r'),('02','15','06','LACABAMBA\r'),('02','15','07','LLAPO\r'),('02','15','08','PALLASCA\r'),('02','15','09','PAMPAS\r'),('02','15','10','SANTA ROSA\r'),('02','15','11','TAUCA\r'),('02','16','00','POMABAMBA\r'),('02','16','01','POMABAMBA\r'),('02','16','02','HUAYLLAN\r'),('02','16','03','PAROBAMBA\r'),('02','16','04','QUINUABAMBA\r'),('02','17','00','RECUAY\r'),('02','17','01','RECUAY\r'),('02','17','02','CATAC\r'),('02','17','03','COTAPARACO\r'),('02','17','04','HUAYLLAPAMPA\r'),('02','17','05','LLACLLIN\r'),('02','17','06','MARCA\r'),('02','17','07','PAMPAS CHICO\r'),('02','17','08','PARARIN\r'),('02','17','09','TAPACOCHA\r'),('02','17','10','TICAPAMPA\r'),('02','18','00','SANTA\r'),('02','18','01','CHIMBOTE\r'),('02','18','02','CACERES DEL PERU\r'),('02','18','03','COISHCO\r'),('02','18','04','MACATE\r'),('02','18','05','MORO\r'),('02','18','06','NEPEÂ¥A\r'),('02','18','07','SAMANCO\r'),('02','18','08','SANTA\r'),('02','18','09','NUEVO CHIMBOTE\r'),('02','19','00','SIHUAS\r'),('02','19','01','SIHUAS\r'),('02','19','02','ACOBAMBA\r'),('02','19','03','ALFONSO UGARTE\r'),('02','19','04','CASHAPAMPA\r'),('02','19','05','CHINGALPO\r'),('02','19','06','HUAYLLABAMBA\r'),('02','19','07','QUICHES\r'),('02','19','08','RAGASH\r'),('02','19','09','SAN JUAN\r'),('02','19','10','SICSIBAMBA\r'),('02','20','00','YUNGAY\r'),('02','20','01','YUNGAY\r'),('02','20','02','CASCAPARA\r'),('02','20','03','MANCOS\r'),('02','20','04','MATACOTO\r'),('02','20','05','QUILLO\r'),('02','20','06','RANRAHIRCA\r'),('02','20','07','SHUPLUY\r'),('02','20','08','YANAMA\r'),('03','00','00','APURIMAC\r'),('03','01','00','ABANCAY\r'),('03','01','01','ABANCAY\r'),('03','01','02','CHACOCHE\r'),('03','01','03','CIRCA\r'),('03','01','04','CURAHUASI\r'),('03','01','05','HUANIPACA\r'),('03','01','06','LAMBRAMA\r'),('03','01','07','PICHIRHUA\r'),('03','01','08','SAN PEDRO DE CACHORA\r'),('03','01','09','TAMBURCO\r'),('03','02','00','ANDAHUAYLAS\r'),('03','02','01','ANDAHUAYLAS\r'),('03','02','02','ANDARAPA\r'),('03','02','03','CHIARA\r'),('03','02','04','HUANCARAMA\r'),('03','02','05','HUANCARAY\r'),('03','02','06','HUAYANA\r'),('03','02','07','KISHUARA\r'),('03','02','08','PACOBAMBA\r'),('03','02','09','PACUCHA\r'),('03','02','10','PAMPACHIRI\r'),('03','02','11','POMACOCHA\r'),('03','02','12','SAN ANTONIO DE CACHI\r'),('03','02','13','SAN JERONIMO\r'),('03','02','14','SAN MIGUEL DE CHACCRAMPA\r'),('03','02','15','SANTA MARIA DE CHICMO\r'),('03','02','16','TALAVERA\r'),('03','02','17','TUMAY HUARACA\r'),('03','02','18','TURPO\r'),('03','02','19','KAQUIABAMBA\r'),('03','03','00','ANTABAMBA\r'),('03','03','01','ANTABAMBA\r'),('03','03','02','EL ORO\r'),('03','03','03','HUAQUIRCA\r'),('03','03','04','JUAN ESPINOZA MEDRANO\r'),('03','03','05','OROPESA\r'),('03','03','06','PACHACONAS\r'),('03','03','07','SABAINO\r'),('03','04','00','AYMARAES\r'),('03','04','01','CHALHUANCA\r'),('03','04','02','CAPAYA\r'),('03','04','03','CARAYBAMBA\r'),('03','04','04','CHAPIMARCA\r'),('03','04','05','COLCABAMBA\r'),('03','04','06','COTARUSE\r'),('03','04','07','HUAYLLO\r'),('03','04','08','JUSTO APU SAHUARAURA\r'),('03','04','09','LUCRE\r'),('03','04','10','POCOHUANCA\r'),('03','04','11','SAN JUAN DE CHACÂ¥A\r'),('03','04','12','SAÂ¥AYCA\r'),('03','04','13','SORAYA\r'),('03','04','14','TAPAIRIHUA\r'),('03','04','15','TINTAY\r'),('03','04','16','TORAYA\r'),('03','04','17','YANACA\r'),('03','05','00','COTABAMBAS\r'),('03','05','01','TAMBOBAMBA\r'),('03','05','02','COTABAMBAS\r'),('03','05','03','COYLLURQUI\r'),('03','05','04','HAQUIRA\r'),('03','05','05','MARA\r'),('03','05','06','CHALLHUAHUACHO\r'),('03','06','00','CHINCHEROS\r'),('03','06','01','CHINCHEROS\r'),('03','06','02','ANCO_HUALLO\r'),('03','06','03','COCHARCAS\r'),('03','06','04','HUACCANA\r'),('03','06','05','OCOBAMBA\r'),('03','06','06','ONGOY\r'),('03','06','07','URANMARCA\r'),('03','06','08','RANRACANCHA\r'),('03','07','00','GRAU\r'),('03','07','01','CHUQUIBAMBILLA\r'),('03','07','02','CURPAHUASI\r'),('03','07','03','GAMARRA\r'),('03','07','04','HUAYLLATI\r'),('03','07','05','MAMARA\r'),('03','07','06','MICAELA BASTIDAS\r'),('03','07','07','PATAYPAMPA\r'),('03','07','08','PROGRESO\r'),('03','07','09','SAN ANTONIO\r'),('03','07','10','SANTA ROSA\r'),('03','07','11','TURPAY\r'),('03','07','12','VILCABAMBA\r'),('03','07','13','VIRUNDO\r'),('03','07','14','CURASCO\r'),('04','00','00','AREQUIPA\r'),('04','01','00','AREQUIPA\r'),('04','01','01','AREQUIPA\r'),('04','01','02','ALTO SELVA ALEGRE\r'),('04','01','03','CAYMA\r'),('04','01','04','CERRO COLORADO\r'),('04','01','05','CHARACATO\r'),('04','01','06','CHIGUATA\r'),('04','01','07','JACOBO HUNTER\r'),('04','01','08','LA JOYA\r'),('04','01','09','MARIANO MELGAR\r'),('04','01','10','MIRAFLORES\r'),('04','01','11','MOLLEBAYA\r'),('04','01','12','PAUCARPATA\r'),('04','01','13','POCSI\r'),('04','01','14','POLOBAYA\r'),('04','01','15','QUEQUEÂ¥A\r'),('04','01','16','SABANDIA\r'),('04','01','17','SACHACA\r'),('04','01','18','SAN JUAN DE SIGUAS\r'),('04','01','19','SAN JUAN DE TARUCANI\r'),('04','01','20','SANTA ISABEL DE SIGUAS\r'),('04','01','21','SANTA RITA DE SIGUAS\r'),('04','01','22','SOCABAYA\r'),('04','01','23','TIABAYA\r'),('04','01','24','UCHUMAYO\r'),('04','01','25','VITOR\r'),('04','01','26','YANAHUARA\r'),('04','01','27','YARABAMBA\r'),('04','01','28','YURA\r'),('04','01','29','JOSE LUIS BUSTAMANTE Y RIVERO\r'),('04','02','00','CAMANA\r'),('04','02','01','CAMANA\r'),('04','02','02','JOSE MARIA QUIMPER\r'),('04','02','03','MARIANO NICOLAS VALCARCEL\r'),('04','02','04','MARISCAL CACERES\r'),('04','02','05','NICOLAS DE PIEROLA\r'),('04','02','06','OCOÂ¥A\r'),('04','02','07','QUILCA\r'),('04','02','08','SAMUEL PASTOR\r'),('04','03','00','CARAVELI\r'),('04','03','01','CARAVELI\r'),('04','03','02','ACARI\r'),('04','03','03','ATICO\r'),('04','03','04','ATIQUIPA\r'),('04','03','05','BELLA UNION\r'),('04','03','06','CAHUACHO\r'),('04','03','07','CHALA\r'),('04','03','08','CHAPARRA\r'),('04','03','09','HUANUHUANU\r'),('04','03','10','JAQUI\r'),('04','03','11','LOMAS\r'),('04','03','12','QUICACHA\r'),('04','03','13','YAUCA\r'),('04','04','00','CASTILLA\r'),('04','04','01','APLAO\r'),('04','04','02','ANDAGUA\r'),('04','04','03','AYO\r'),('04','04','04','CHACHAS\r'),('04','04','05','CHILCAYMARCA\r'),('04','04','06','CHOCO\r'),('04','04','07','HUANCARQUI\r'),('04','04','08','MACHAGUAY\r'),('04','04','09','ORCOPAMPA\r'),('04','04','10','PAMPACOLCA\r'),('04','04','11','TIPAN\r'),('04','04','12','UÂ¥ON\r'),('04','04','13','URACA\r'),('04','04','14','VIRACO\r'),('04','05','00','CAYLLOMA\r'),('04','05','01','CHIVAY\r'),('04','05','02','ACHOMA\r'),('04','05','03','CABANACONDE\r'),('04','05','04','CALLALLI\r'),('04','05','05','CAYLLOMA\r'),('04','05','06','COPORAQUE\r'),('04','05','07','HUAMBO\r'),('04','05','08','HUANCA\r'),('04','05','09','ICHUPAMPA\r'),('04','05','10','LARI\r'),('04','05','11','LLUTA\r'),('04','05','12','MACA\r'),('04','05','13','MADRIGAL\r'),('04','05','14','SAN ANTONIO DE CHUCA\r'),('04','05','15','SIBAYO\r'),('04','05','16','TAPAY\r'),('04','05','17','TISCO\r'),('04','05','18','TUTI\r'),('04','05','19','YANQUE\r'),('04','05','20','MAJES\r'),('04','06','00','CONDESUYOS\r'),('04','06','01','CHUQUIBAMBA\r'),('04','06','02','ANDARAY\r'),('04','06','03','CAYARANI\r'),('04','06','04','CHICHAS\r'),('04','06','05','IRAY\r'),('04','06','06','RIO GRANDE\r'),('04','06','07','SALAMANCA\r'),('04','06','08','YANAQUIHUA\r'),('04','07','00','ISLAY\r'),('04','07','01','MOLLENDO\r'),('04','07','02','COCACHACRA\r'),('04','07','03','DEAN VALDIVIA\r'),('04','07','04','ISLAY\r'),('04','07','05','MEJIA\r'),('04','07','06','PUNTA DE BOMBON\r'),('04','08','00','LA UNION\r'),('04','08','01','COTAHUASI\r'),('04','08','02','ALCA\r'),('04','08','03','CHARCANA\r'),('04','08','04','HUAYNACOTAS\r'),('04','08','05','PAMPAMARCA\r'),('04','08','06','PUYCA\r'),('04','08','07','QUECHUALLA\r'),('04','08','08','SAYLA\r'),('04','08','09','TAURIA\r'),('04','08','10','TOMEPAMPA\r'),('04','08','11','TORO\r'),('05','00','00','AYACUCHO\r'),('05','01','00','HUAMANGA\r'),('05','01','01','AYACUCHO\r'),('05','01','02','ACOCRO\r'),('05','01','03','ACOS VINCHOS\r'),('05','01','04','CARMEN ALTO\r'),('05','01','05','CHIARA\r'),('05','01','06','OCROS\r'),('05','01','07','PACAYCASA\r'),('05','01','08','QUINUA\r'),('05','01','09','SAN JOSE DE TICLLAS\r'),('05','01','10','SAN JUAN BAUTISTA\r'),('05','01','11','SANTIAGO DE PISCHA\r'),('05','01','12','SOCOS\r'),('05','01','13','TAMBILLO\r'),('05','01','14','VINCHOS\r'),('05','01','15','JESUS NAZARENO\r'),('05','02','00','CANGALLO\r'),('05','02','01','CANGALLO\r'),('05','02','02','CHUSCHI\r'),('05','02','03','LOS MOROCHUCOS\r'),('05','02','04','MARIA PARADO DE BELLIDO\r'),('05','02','05','PARAS\r'),('05','02','06','TOTOS\r'),('05','03','00','HUANCA SANCOS\r'),('05','03','01','SANCOS\r'),('05','03','02','CARAPO\r'),('05','03','03','SACSAMARCA\r'),('05','03','04','SANTIAGO DE LUCANAMARCA\r'),('05','04','00','HUANTA\r'),('05','04','01','HUANTA\r'),('05','04','02','AYAHUANCO\r'),('05','04','03','HUAMANGUILLA\r'),('05','04','04','IGUAIN\r'),('05','04','05','LURICOCHA\r'),('05','04','06','SANTILLANA\r'),('05','04','07','SIVIA\r'),('05','04','08','LLOCHEGUA\r'),('05','05','00','LA MAR\r'),('05','05','01','SAN MIGUEL\r'),('05','05','02','ANCO\r'),('05','05','03','AYNA\r'),('05','05','04','CHILCAS\r'),('05','05','05','CHUNGUI\r'),('05','05','06','LUIS CARRANZA\r'),('05','05','07','SANTA ROSA\r'),('05','05','08','TAMBO\r'),('05','05','09','SAMUGARI\r'),('05','06','00','LUCANAS\r'),('05','06','01','PUQUIO\r'),('05','06','02','AUCARA\r'),('05','06','03','CABANA\r'),('05','06','04','CARMEN SALCEDO\r'),('05','06','05','CHAVIÂ¥A\r'),('05','06','06','CHIPAO\r'),('05','06','07','HUAC-HUAS\r'),('05','06','08','LARAMATE\r'),('05','06','09','LEONCIO PRADO\r'),('05','06','10','LLAUTA\r'),('05','06','11','LUCANAS\r'),('05','06','12','OCAÂ¥A\r'),('05','06','13','OTOCA\r'),('05','06','14','SAISA\r'),('05','06','15','SAN CRISTOBAL\r'),('05','06','16','SAN JUAN\r'),('05','06','17','SAN PEDRO\r'),('05','06','18','SAN PEDRO DE PALCO\r'),('05','06','19','SANCOS\r'),('05','06','20','SANTA ANA DE HUAYCAHUACHO\r'),('05','06','21','SANTA LUCIA\r'),('05','07','00','PARINACOCHAS\r'),('05','07','01','CORACORA\r'),('05','07','02','CHUMPI\r'),('05','07','03','CORONEL CASTAÂ¥EDA\r'),('05','07','04','PACAPAUSA\r'),('05','07','05','PULLO\r'),('05','07','06','PUYUSCA\r'),('05','07','07','SAN FRANCISCO DE RAVACAYCO\r'),('05','07','08','UPAHUACHO\r'),('05','08','00','PAUCAR DEL SARA SARA\r'),('05','08','01','PAUSA\r'),('05','08','02','COLTA\r'),('05','08','03','CORCULLA\r'),('05','08','04','LAMPA\r'),('05','08','05','MARCABAMBA\r'),('05','08','06','OYOLO\r'),('05','08','07','PARARCA\r'),('05','08','08','SAN JAVIER DE ALPABAMBA\r'),('05','08','09','SAN JOSE DE USHUA\r'),('05','08','10','SARA SARA\r'),('05','09','00','SUCRE\r'),('05','09','01','QUEROBAMBA\r'),('05','09','02','BELEN\r'),('05','09','03','CHALCOS\r'),('05','09','04','CHILCAYOC\r'),('05','09','05','HUACAÂ¥A\r'),('05','09','06','MORCOLLA\r'),('05','09','07','PAICO\r'),('05','09','08','SAN PEDRO DE LARCAY\r'),('05','09','09','SAN SALVADOR DE QUIJE\r'),('05','09','10','SANTIAGO DE PAUCARAY\r'),('05','09','11','SORAS\r'),('05','10','00','VICTOR FAJARDO\r'),('05','10','01','HUANCAPI\r'),('05','10','02','ALCAMENCA\r'),('05','10','03','APONGO\r'),('05','10','04','ASQUIPATA\r'),('05','10','05','CANARIA\r'),('05','10','06','CAYARA\r'),('05','10','07','COLCA\r'),('05','10','08','HUAMANQUIQUIA\r'),('05','10','09','HUANCARAYLLA\r'),('05','10','10','HUAYA\r'),('05','10','11','SARHUA\r'),('05','10','12','VILCANCHOS\r'),('05','11','00','VILCAS HUAMAN\r'),('05','11','01','VILCAS HUAMAN\r'),('05','11','02','ACCOMARCA\r'),('05','11','03','CARHUANCA\r'),('05','11','04','CONCEPCION\r'),('05','11','05','HUAMBALPA\r'),('05','11','06','INDEPENDENCIA\r'),('05','11','07','SAURAMA\r'),('05','11','08','VISCHONGO\r'),('06','00','00','CAJAMARCA\r'),('06','01','00','CAJAMARCA\r'),('06','01','01','CAJAMARCA\r'),('06','01','02','ASUNCION\r'),('06','01','03','CHETILLA\r'),('06','01','04','COSPAN\r'),('06','01','05','ENCAÂ¥ADA\r'),('06','01','06','JESUS\r'),('06','01','07','LLACANORA\r'),('06','01','08','LOS BAÂ¥OS DEL INCA\r'),('06','01','09','MAGDALENA\r'),('06','01','10','MATARA\r'),('06','01','11','NAMORA\r'),('06','01','12','SAN JUAN\r'),('06','02','00','CAJABAMBA\r'),('06','02','01','CAJABAMBA\r'),('06','02','02','CACHACHI\r'),('06','02','03','CONDEBAMBA\r'),('06','02','04','SITACOCHA\r'),('06','03','00','CELENDIN\r'),('06','03','01','CELENDIN\r'),('06','03','02','CHUMUCH\r'),('06','03','03','CORTEGANA\r'),('06','03','04','HUASMIN\r'),('06','03','05','JORGE CHAVEZ\r'),('06','03','06','JOSE GALVEZ\r'),('06','03','07','MIGUEL IGLESIAS\r'),('06','03','08','OXAMARCA\r'),('06','03','09','SOROCHUCO\r'),('06','03','10','SUCRE\r'),('06','03','11','UTCO\r'),('06','03','12','LA LIBERTAD DE PALLAN\r'),('06','04','00','CHOTA\r'),('06','04','01','CHOTA\r'),('06','04','02','ANGUIA\r'),('06','04','03','CHADIN\r'),('06','04','04','CHIGUIRIP\r'),('06','04','05','CHIMBAN\r'),('06','04','06','CHOROPAMPA\r'),('06','04','07','COCHABAMBA\r'),('06','04','08','CONCHAN\r'),('06','04','09','HUAMBOS\r'),('06','04','10','LAJAS\r'),('06','04','11','LLAMA\r'),('06','04','12','MIRACOSTA\r'),('06','04','13','PACCHA\r'),('06','04','14','PION\r'),('06','04','15','QUEROCOTO\r'),('06','04','16','SAN JUAN DE LICUPIS\r'),('06','04','17','TACABAMBA\r'),('06','04','18','TOCMOCHE\r'),('06','04','19','CHALAMARCA\r'),('06','05','00','CONTUMAZA\r'),('06','05','01','CONTUMAZA\r'),('06','05','02','CHILETE\r'),('06','05','03','CUPISNIQUE\r'),('06','05','04','GUZMANGO\r'),('06','05','05','SAN BENITO\r'),('06','05','06','SANTA CRUZ DE TOLED\r'),('06','05','07','TANTARICA\r'),('06','05','08','YONAN\r'),('06','06','00','CUTERVO\r'),('06','06','01','CUTERVO\r'),('06','06','02','CALLAYUC\r'),('06','06','03','CHOROS\r'),('06','06','04','CUJILLO\r'),('06','06','05','LA RAMADA\r'),('06','06','06','PIMPINGOS\r'),('06','06','07','QUEROCOTILLO\r'),('06','06','08','SAN ANDRES DE CUTERVO\r'),('06','06','09','SAN JUAN DE CUTERVO\r'),('06','06','10','SAN LUIS DE LUCMA\r'),('06','06','11','SANTA CRUZ\r'),('06','06','12','SANTO DOMINGO DE LA CAPILLA\r'),('06','06','13','SANTO TOMAS\r'),('06','06','14','SOCOTA\r'),('06','06','15','TORIBIO CASANOVA\r'),('06','07','00','HUALGAYOC\r'),('06','07','01','BAMBAMARCA\r'),('06','07','02','CHUGUR\r'),('06','07','03','HUALGAYOC\r'),('06','08','00','JAEN\r'),('06','08','01','JAEN\r'),('06','08','02','BELLAVISTA\r'),('06','08','03','CHONTALI\r'),('06','08','04','COLASAY\r'),('06','08','05','HUABAL\r'),('06','08','06','LAS PIRIAS\r'),('06','08','07','POMAHUACA\r'),('06','08','08','PUCARA\r'),('06','08','09','SALLIQUE\r'),('06','08','10','SAN FELIPE\r'),('06','08','11','SAN JOSE DEL ALTO\r'),('06','08','12','SANTA ROSA\r'),('06','09','00','SAN IGNACIO\r'),('06','09','01','SAN IGNACIO\r'),('06','09','02','CHIRINOS\r'),('06','09','03','HUARANGO\r'),('06','09','04','LA COIPA\r'),('06','09','05','NAMBALLE\r'),('06','09','06','SAN JOSE DE LOURDES\r'),('06','09','07','TABACONAS\r'),('06','10','00','SAN MARCOS\r'),('06','10','01','PEDRO GALVEZ\r'),('06','10','02','CHANCAY\r'),('06','10','03','EDUARDO VILLANUEVA\r'),('06','10','04','GREGORIO PITA\r'),('06','10','05','ICHOCAN\r'),('06','10','06','JOSE MANUEL QUIROZ\r'),('06','10','07','JOSE SABOGAL\r'),('06','11','00','SAN MIGUEL\r'),('06','11','01','SAN MIGUEL\r'),('06','11','02','BOLIVAR\r'),('06','11','03','CALQUIS\r'),('06','11','04','CATILLUC\r'),('06','11','05','EL PRADO\r'),('06','11','06','LA FLORIDA\r'),('06','11','07','LLAPA\r'),('06','11','08','NANCHOC\r'),('06','11','09','NIEPOS\r'),('06','11','10','SAN GREGORIO\r'),('06','11','11','SAN SILVESTRE DE COCHAN\r'),('06','11','12','TONGOD\r'),('06','11','13','UNION AGUA BLANCA\r'),('06','12','00','SAN PABLO\r'),('06','12','01','SAN PABLO\r'),('06','12','02','SAN BERNARDINO\r'),('06','12','03','SAN LUIS\r'),('06','12','04','TUMBADEN\r'),('06','13','00','SANTA CRUZ\r'),('06','13','01','SANTA CRUZ\r'),('06','13','02','ANDABAMBA\r'),('06','13','03','CATACHE\r'),('06','13','04','CHANCAYBAÂ¥OS\r'),('06','13','05','LA ESPERANZA\r'),('06','13','06','NINABAMBA\r'),('06','13','07','PULAN\r'),('06','13','08','SAUCEPAMPA\r'),('06','13','09','SEXI\r'),('06','13','10','UTICYACU\r'),('06','13','11','YAUYUCAN\r'),('07','00','00','CALLAO\r'),('07','01','00','CALLAO\r'),('07','01','01','CALLAO\r'),('07','01','02','BELLAVISTA\r'),('07','01','03','CARMEN DE LA LEGUA REYNOSO\r'),('07','01','04','LA PERLA\r'),('07','01','05','LA PUNTA\r'),('07','01','06','VENTANILLA\r'),('08','00','00','CUSCO\r'),('08','01','00','CUSCO\r'),('08','01','01','CUSCO\r'),('08','01','02','CCORCA\r'),('08','01','03','POROY\r'),('08','01','04','SAN JERONIMO\r'),('08','01','05','SAN SEBASTIAN\r'),('08','01','06','SANTIAGO\r'),('08','01','07','SAYLLA\r'),('08','01','08','WANCHAQ\r'),('08','02','00','ACOMAYO\r'),('08','02','01','ACOMAYO\r'),('08','02','02','ACOPIA\r'),('08','02','03','ACOS\r'),('08','02','04','MOSOC LLACTA\r'),('08','02','05','POMACANCHI\r'),('08','02','06','RONDOCAN\r'),('08','02','07','SANGARARA\r'),('08','03','00','ANTA\r'),('08','03','01','ANTA\r'),('08','03','02','ANCAHUASI\r'),('08','03','03','CACHIMAYO\r'),('08','03','04','CHINCHAYPUJIO\r'),('08','03','05','HUAROCONDO\r'),('08','03','06','LIMATAMBO\r'),('08','03','07','MOLLEPATA\r'),('08','03','08','PUCYURA\r'),('08','03','09','ZURITE\r'),('08','04','00','CALCA\r'),('08','04','01','CALCA\r'),('08','04','02','COYA\r'),('08','04','03','LAMAY\r'),('08','04','04','LARES\r'),('08','04','05','PISAC\r'),('08','04','06','SAN SALVADOR\r'),('08','04','07','TARAY\r'),('08','04','08','YANATILE\r'),('08','05','00','CANAS\r'),('08','05','01','YANAOCA\r'),('08','05','02','CHECCA\r'),('08','05','03','KUNTURKANKI\r'),('08','05','04','LANGUI\r'),('08','05','05','LAYO\r'),('08','05','06','PAMPAMARCA\r'),('08','05','07','QUEHUE\r'),('08','05','08','TUPAC AMARU\r'),('08','06','00','CANCHIS\r'),('08','06','01','SICUANI\r'),('08','06','02','CHECACUPE\r'),('08','06','03','COMBAPATA\r'),('08','06','04','MARANGANI\r'),('08','06','05','PITUMARCA\r'),('08','06','06','SAN PABLO\r'),('08','06','07','SAN PEDRO\r'),('08','06','08','TINTA\r'),('08','07','00','CHUMBIVILCAS\r'),('08','07','01','SANTO TOMAS\r'),('08','07','02','CAPACMARCA\r'),('08','07','03','CHAMACA\r'),('08','07','04','COLQUEMARCA\r'),('08','07','05','LIVITACA\r'),('08','07','06','LLUSCO\r'),('08','07','07','QUIÂ¥OTA\r'),('08','07','08','VELILLE\r'),('08','08','00','ESPINAR\r'),('08','08','01','ESPINAR\r'),('08','08','02','CONDOROMA\r'),('08','08','03','COPORAQUE\r'),('08','08','04','OCORURO\r'),('08','08','05','PALLPATA\r'),('08','08','06','PICHIGUA\r'),('08','08','07','SUYCKUTAMBO\r'),('08','08','08','ALTO PICHIGUA\r'),('08','09','00','LA CONVENCION\r'),('08','09','01','SANTA ANA\r'),('08','09','02','ECHARATE\r'),('08','09','03','HUAYOPATA\r'),('08','09','04','MARANURA\r'),('08','09','05','OCOBAMBA\r'),('08','09','06','QUELLOUNO\r'),('08','09','07','KIMBIRI\r'),('08','09','08','SANTA TERESA\r'),('08','09','09','VILCABAMBA\r'),('08','09','10','PICHARI\r'),('08','10','00','PARURO\r'),('08','10','01','PARURO\r'),('08','10','02','ACCHA\r'),('08','10','03','CCAPI\r'),('08','10','04','COLCHA\r'),('08','10','05','HUANOQUITE\r'),('08','10','06','OMACHA\r'),('08','10','07','PACCARITAMBO\r'),('08','10','08','PILLPINTO\r'),('08','10','09','YAURISQUE\r'),('08','11','00','PAUCARTAMBO\r'),('08','11','01','PAUCARTAMBO\r'),('08','11','02','CAICAY\r'),('08','11','03','CHALLABAMBA\r'),('08','11','04','COLQUEPATA\r'),('08','11','05','HUANCARANI\r'),('08','11','06','KOSÂ¥IPATA\r'),('08','12','00','QUISPICANCHI\r'),('08','12','01','URCOS\r'),('08','12','02','ANDAHUAYLILLAS\r'),('08','12','03','CAMANTI\r'),('08','12','04','CCARHUAYO\r'),('08','12','05','CCATCA\r'),('08','12','06','CUSIPATA\r'),('08','12','07','HUARO\r'),('08','12','08','LUCRE\r'),('08','12','09','MARCAPATA\r'),('08','12','10','OCONGATE\r'),('08','12','11','OROPESA\r'),('08','12','12','QUIQUIJANA\r'),('08','13','00','URUBAMBA\r'),('08','13','01','URUBAMBA\r'),('08','13','02','CHINCHERO\r'),('08','13','03','HUAYLLABAMBA\r'),('08','13','04','MACHUPICCHU\r'),('08','13','05','MARAS\r'),('08','13','06','OLLANTAYTAMBO\r'),('08','13','07','YUCAY\r'),('09','00','00','HUANCAVELICA\r'),('09','01','00','HUANCAVELICA\r'),('09','01','01','HUANCAVELICA\r'),('09','01','02','ACOBAMBILLA\r'),('09','01','03','ACORIA\r'),('09','01','04','CONAYCA\r'),('09','01','05','CUENCA\r'),('09','01','06','HUACHOCOLPA\r'),('09','01','07','HUAYLLAHUARA\r'),('09','01','08','IZCUCHACA\r'),('09','01','09','LARIA\r'),('09','01','10','MANTA\r'),('09','01','11','MARISCAL CACERES\r'),('09','01','12','MOYA\r'),('09','01','13','NUEVO OCCORO\r'),('09','01','14','PALCA\r'),('09','01','15','PILCHACA\r'),('09','01','16','VILCA\r'),('09','01','17','YAULI\r'),('09','01','18','ASCENSION\r'),('09','01','19','HUANDO\r'),('09','02','00','ACOBAMBA\r'),('09','02','01','ACOBAMBA\r'),('09','02','02','ANDABAMBA\r'),('09','02','03','ANTA\r'),('09','02','04','CAJA\r'),('09','02','05','MARCAS\r'),('09','02','06','PAUCARA\r'),('09','02','07','POMACOCHA\r'),('09','02','08','ROSARIO\r'),('09','03','00','ANGARAES\r'),('09','03','01','LIRCAY\r'),('09','03','02','ANCHONGA\r'),('09','03','03','CALLANMARCA\r'),('09','03','04','CCOCHACCASA\r'),('09','03','05','CHINCHO\r'),('09','03','06','CONGALLA\r'),('09','03','07','HUANCA-HUANCA\r'),('09','03','08','HUAYLLAY GRANDE\r'),('09','03','09','JULCAMARCA\r'),('09','03','10','SAN ANTONIO DE ANTAPARCO\r'),('09','03','11','SANTO TOMAS DE PATA\r'),('09','03','12','SECCLLA\r'),('09','04','00','CASTROVIRREYNA\r'),('09','04','01','CASTROVIRREYNA\r'),('09','04','02','ARMA\r'),('09','04','03','AURAHUA\r'),('09','04','04','CAPILLAS\r'),('09','04','05','CHUPAMARCA\r'),('09','04','06','COCAS\r'),('09','04','07','HUACHOS\r'),('09','04','08','HUAMATAMBO\r'),('09','04','09','MOLLEPAMPA\r'),('09','04','10','SAN JUAN\r'),('09','04','11','SANTA ANA\r'),('09','04','12','TANTARA\r'),('09','04','13','TICRAPO\r'),('09','05','00','CHURCAMPA\r'),('09','05','01','CHURCAMPA\r'),('09','05','02','ANCO\r'),('09','05','03','CHINCHIHUASI\r'),('09','05','04','EL CARMEN\r'),('09','05','05','LA MERCED\r'),('09','05','06','LOCROJA\r'),('09','05','07','PAUCARBAMBA\r'),('09','05','08','SAN MIGUEL DE MAYOCC\r'),('09','05','09','SAN PEDRO DE CORIS\r'),('09','05','10','PACHAMARCA\r'),('09','05','11','COSME\r'),('09','06','00','HUAYTARA\r'),('09','06','01','HUAYTARA\r'),('09','06','02','AYAVI\r'),('09','06','03','CORDOVA\r'),('09','06','04','HUAYACUNDO ARMA\r'),('09','06','05','LARAMARCA\r'),('09','06','06','OCOYO\r'),('09','06','07','PILPICHACA\r'),('09','06','08','QUERCO\r'),('09','06','09','QUITO-ARMA\r'),('09','06','10','SAN ANTONIO DE CUSICANCHA\r'),('09','06','11','SAN FRANCISCO DE SANGAYAICO\r'),('09','06','12','SAN ISIDRO\r'),('09','06','13','SANTIAGO DE CHOCORVOS\r'),('09','06','14','SANTIAGO DE QUIRAHUARA\r'),('09','06','15','SANTO DOMINGO DE CAPILLAS\r'),('09','06','16','TAMBO\r'),('09','07','00','TAYACAJA\r'),('09','07','01','PAMPAS\r'),('09','07','02','ACOSTAMBO\r'),('09','07','03','ACRAQUIA\r'),('09','07','04','AHUAYCHA\r'),('09','07','05','COLCABAMBA\r'),('09','07','06','DANIEL HERNANDEZ\r'),('09','07','07','HUACHOCOLPA\r'),('09','07','09','HUARIBAMBA\r'),('09','07','10','Â¥AHUIMPUQUIO\r'),('09','07','11','PAZOS\r'),('09','07','13','QUISHUAR\r'),('09','07','14','SALCABAMBA\r'),('09','07','15','SALCAHUASI\r'),('09','07','16','SAN MARCOS DE ROCCHAC\r'),('09','07','17','SURCUBAMBA\r'),('09','07','18','TINTAY PUNCU\r'),('10','00','00','HUANUCO\r'),('10','01','00','HUANUCO\r'),('10','01','01','HUANUCO\r'),('10','01','02','AMARILIS\r'),('10','01','03','CHINCHAO\r'),('10','01','04','CHURUBAMBA\r'),('10','01','05','MARGOS\r'),('10','01','06','QUISQUI (KICHKI)\r'),('10','01','07','SAN FRANCISCO DE CAYRAN\r'),('10','01','08','SAN PEDRO DE CHAULAN\r'),('10','01','09','SANTA MARIA DEL VALLE\r'),('10','01','10','YARUMAYO\r'),('10','01','11','PILLCO MARCA\r'),('10','01','12','YACUS\r'),('10','02','00','AMBO\r'),('10','02','01','AMBO\r'),('10','02','02','CAYNA\r'),('10','02','03','COLPAS\r'),('10','02','04','CONCHAMARCA\r'),('10','02','05','HUACAR\r'),('10','02','06','SAN FRANCISCO\r'),('10','02','07','SAN RAFAEL\r'),('10','02','08','TOMAY KICHWA\r'),('10','03','00','DOS DE MAYO\r'),('10','03','01','LA UNION\r'),('10','03','07','CHUQUIS\r'),('10','03','11','MARIAS\r'),('10','03','13','PACHAS\r'),('10','03','16','QUIVILLA\r'),('10','03','17','RIPAN\r'),('10','03','21','SHUNQUI\r'),('10','03','22','SILLAPATA\r'),('10','03','23','YANAS\r'),('10','04','00','HUACAYBAMBA\r'),('10','04','01','HUACAYBAMBA\r'),('10','04','02','CANCHABAMBA\r'),('10','04','03','COCHABAMBA\r'),('10','04','04','PINRA\r'),('10','05','00','HUAMALIES\r'),('10','05','01','LLATA\r'),('10','05','02','ARANCAY\r'),('10','05','03','CHAVIN DE PARIARCA\r'),('10','05','04','JACAS GRANDE\r'),('10','05','05','JIRCAN\r'),('10','05','06','MIRAFLORES\r'),('10','05','07','MONZON\r'),('10','05','08','PUNCHAO\r'),('10','05','09','PUÂ¥OS\r'),('10','05','10','SINGA\r'),('10','05','11','TANTAMAYO\r'),('10','06','00','LEONCIO PRADO\r'),('10','06','01','RUPA-RUPA\r'),('10','06','02','DANIEL ALOMIA ROBLES\r'),('10','06','03','HERMILIO VALDIZAN\r'),('10','06','04','JOSE CRESPO Y CASTILLO\r'),('10','06','05','LUYANDO\r'),('10','06','06','MARIANO DAMASO BERAUN\r'),('10','07','00','MARAÂ¥ON\r'),('10','07','01','HUACRACHUCO\r'),('10','07','02','CHOLON\r'),('10','07','03','SAN BUENAVENTURA\r'),('10','08','00','PACHITEA\r'),('10','08','01','PANAO\r'),('10','08','02','CHAGLLA\r'),('10','08','03','MOLINO\r'),('10','08','04','UMARI\r'),('10','09','00','PUERTO INCA\r'),('10','09','01','PUERTO INCA\r'),('10','09','02','CODO DEL POZUZO\r'),('10','09','03','HONORIA\r'),('10','09','04','TOURNAVISTA\r'),('10','09','05','YUYAPICHIS\r'),('10','10','00','LAURICOCHA\r'),('10','10','01','JESUS\r'),('10','10','02','BAÂ¥OS\r'),('10','10','03','JIVIA\r'),('10','10','04','QUEROPALCA\r'),('10','10','05','RONDOS\r'),('10','10','06','SAN FRANCISCO DE ASIS\r'),('10','10','07','SAN MIGUEL DE CAURI\r'),('10','11','00','YAROWILCA\r'),('10','11','01','CHAVINILLO\r'),('10','11','02','CAHUAC\r'),('10','11','03','CHACABAMBA\r'),('10','11','04','APARICIO POMARES\r'),('10','11','05','JACAS CHICO\r'),('10','11','06','OBAS\r'),('10','11','07','PAMPAMARCA\r'),('10','11','08','CHORAS\r'),('11','00','00','ICA\r'),('11','01','00','ICA\r'),('11','01','01','ICA\r'),('11','01','02','LA TINGUIÂ¥A\r'),('11','01','03','LOS AQUIJES\r'),('11','01','04','OCUCAJE\r'),('11','01','05','PACHACUTEC\r'),('11','01','06','PARCONA\r'),('11','01','07','PUEBLO NUEVO\r'),('11','01','08','SALAS\r'),('11','01','09','SAN JOSE DE LOS MOLINOS\r'),('11','01','10','SAN JUAN BAUTISTA\r'),('11','01','11','SANTIAGO\r'),('11','01','12','SUBTANJALLA\r'),('11','01','13','TATE\r'),('11','01','14','YAUCA DEL ROSARIO\r'),('11','02','00','CHINCHA\r'),('11','02','01','CHINCHA ALTA\r'),('11','02','02','ALTO LARAN\r'),('11','02','03','CHAVIN\r'),('11','02','04','CHINCHA BAJA\r'),('11','02','05','EL CARMEN\r'),('11','02','06','GROCIO PRADO\r'),('11','02','07','PUEBLO NUEVO\r'),('11','02','08','SAN JUAN DE YANAC\r'),('11','02','09','SAN PEDRO DE HUACARPANA\r'),('11','02','10','SUNAMPE\r'),('11','02','11','TAMBO DE MORA\r'),('11','03','00','NAZCA\r'),('11','03','01','NAZCA\r'),('11','03','02','CHANGUILLO\r'),('11','03','03','EL INGENIO\r'),('11','03','04','MARCONA\r'),('11','03','05','VISTA ALEGRE\r'),('11','04','00','PALPA\r'),('11','04','01','PALPA\r'),('11','04','02','LLIPATA\r'),('11','04','03','RIO GRANDE\r'),('11','04','04','SANTA CRUZ\r'),('11','04','05','TIBILLO\r'),('11','05','00','PISCO\r'),('11','05','01','PISCO\r'),('11','05','02','HUANCANO\r'),('11','05','03','HUMAY\r'),('11','05','04','INDEPENDENCIA\r'),('11','05','05','PARACAS\r'),('11','05','06','SAN ANDRES\r'),('11','05','07','SAN CLEMENTE\r'),('11','05','08','TUPAC AMARU INCA\r'),('12','00','00','JUNIN\r'),('12','01','00','HUANCAYO\r'),('12','01','01','HUANCAYO\r'),('12','01','04','CARHUACALLANGA\r'),('12','01','05','CHACAPAMPA\r'),('12','01','06','CHICCHE\r'),('12','01','07','CHILCA\r'),('12','01','08','CHONGOS ALTO\r'),('12','01','11','CHUPURO\r'),('12','01','12','COLCA\r'),('12','01','13','CULLHUAS\r'),('12','01','14','EL TAMBO\r'),('12','01','16','HUACRAPUQUIO\r'),('12','01','17','HUALHUAS\r'),('12','01','19','HUANCAN\r'),('12','01','20','HUASICANCHA\r'),('12','01','21','HUAYUCACHI\r'),('12','01','22','INGENIO\r'),('12','01','24','PARIAHUANCA\r'),('12','01','25','PILCOMAYO\r'),('12','01','26','PUCARA\r'),('12','01','27','QUICHUAY\r'),('12','01','28','QUILCAS\r'),('12','01','29','SAN AGUSTIN\r'),('12','01','30','SAN JERONIMO DE TUNAN\r'),('12','01','32','SAÂ¥O\r'),('12','01','33','SAPALLANGA\r'),('12','01','34','SICAYA\r'),('12','01','35','SANTO DOMINGO DE ACOBAMBA\r'),('12','01','36','VIQUES\r'),('12','02','00','CONCEPCION\r'),('12','02','01','CONCEPCION\r'),('12','02','02','ACO\r'),('12','02','03','ANDAMARCA\r'),('12','02','04','CHAMBARA\r'),('12','02','05','COCHAS\r'),('12','02','06','COMAS\r'),('12','02','07','HEROINAS TOLEDO\r'),('12','02','08','MANZANARES\r'),('12','02','09','MARISCAL CASTILLA\r'),('12','02','10','MATAHUASI\r'),('12','02','11','MITO\r'),('12','02','12','NUEVE DE JULIO\r'),('12','02','13','ORCOTUNA\r'),('12','02','14','SAN JOSE DE QUERO\r'),('12','02','15','SANTA ROSA DE OCOPA\r'),('12','03','00','CHANCHAMAYO\r'),('12','03','01','CHANCHAMAYO\r'),('12','03','02','PERENE\r'),('12','03','03','PICHANAQUI\r'),('12','03','04','SAN LUIS DE SHUARO\r'),('12','03','05','SAN RAMON\r'),('12','03','06','VITOC\r'),('12','04','00','JAUJA\r'),('12','04','01','JAUJA\r'),('12','04','02','ACOLLA\r'),('12','04','03','APATA\r'),('12','04','04','ATAURA\r'),('12','04','05','CANCHAYLLO\r'),('12','04','06','CURICACA\r'),('12','04','07','EL MANTARO\r'),('12','04','08','HUAMALI\r'),('12','04','09','HUARIPAMPA\r'),('12','04','10','HUERTAS\r'),('12','04','11','JANJAILLO\r'),('12','04','12','JULCAN\r'),('12','04','13','LEONOR ORDOÂ¥EZ\r'),('12','04','14','LLOCLLAPAMPA\r'),('12','04','15','MARCO\r'),('12','04','16','MASMA\r'),('12','04','17','MASMA CHICCHE\r'),('12','04','18','MOLINOS\r'),('12','04','19','MONOBAMBA\r'),('12','04','20','MUQUI\r'),('12','04','21','MUQUIYAUYO\r'),('12','04','22','PACA\r'),('12','04','23','PACCHA\r'),('12','04','24','PANCAN\r'),('12','04','25','PARCO\r'),('12','04','26','POMACANCHA\r'),('12','04','27','RICRAN\r'),('12','04','28','SAN LORENZO\r'),('12','04','29','SAN PEDRO DE CHUNAN\r'),('12','04','30','SAUSA\r'),('12','04','31','SINCOS\r'),('12','04','32','TUNAN MARCA\r'),('12','04','33','YAULI\r'),('12','04','34','YAUYOS\r'),('12','05','00','JUNIN\r'),('12','05','01','JUNIN\r'),('12','05','02','CARHUAMAYO\r'),('12','05','03','ONDORES\r'),('12','05','04','ULCUMAYO\r'),('12','06','00','SATIPO\r'),('12','06','01','SATIPO\r'),('12','06','02','COVIRIALI\r'),('12','06','03','LLAYLLA\r'),('12','06','05','PAMPA HERMOSA\r'),('12','06','07','RIO NEGRO\r'),('12','06','08','RIO TAMBO\r'),('12','06','99','MAZAMARI - PANGOA\r'),('12','07','00','TARMA\r'),('12','07','01','TARMA\r'),('12','07','02','ACOBAMBA\r'),('12','07','03','HUARICOLCA\r'),('12','07','04','HUASAHUASI\r'),('12','07','05','LA UNION\r'),('12','07','06','PALCA\r'),('12','07','07','PALCAMAYO\r'),('12','07','08','SAN PEDRO DE CAJAS\r'),('12','07','09','TAPO\r'),('12','08','00','YAULI\r'),('12','08','01','LA OROYA\r'),('12','08','02','CHACAPALPA\r'),('12','08','03','HUAY-HUAY\r'),('12','08','04','MARCAPOMACOCHA\r'),('12','08','05','MOROCOCHA\r'),('12','08','06','PACCHA\r'),('12','08','07','SANTA BARBARA DE CARHUACAYAN\r'),('12','08','08','SANTA ROSA DE SACCO\r'),('12','08','09','SUITUCANCHA\r'),('12','08','10','YAULI\r'),('12','09','00','CHUPACA\r'),('12','09','01','CHUPACA\r'),('12','09','02','AHUAC\r'),('12','09','03','CHONGOS BAJO\r'),('12','09','04','HUACHAC\r'),('12','09','05','HUAMANCACA CHICO\r'),('12','09','06','SAN JUAN DE ISCOS\r'),('12','09','07','SAN JUAN DE JARPA\r'),('12','09','08','TRES DE DICIEMBRE\r'),('12','09','09','YANACANCHA\r'),('13','00','00','LA LIBERTAD\r'),('13','01','00','TRUJILLO\r'),('13','01','01','TRUJILLO\r'),('13','01','02','EL PORVENIR\r'),('13','01','03','FLORENCIA DE MORA\r'),('13','01','04','HUANCHACO\r'),('13','01','05','LA ESPERANZA\r'),('13','01','06','LAREDO\r'),('13','01','07','MOCHE\r'),('13','01','08','POROTO\r'),('13','01','09','SALAVERRY\r'),('13','01','10','SIMBAL\r'),('13','01','11','VICTOR LARCO HERRERA\r'),('13','02','00','ASCOPE\r'),('13','02','01','ASCOPE\r'),('13','02','02','CHICAMA\r'),('13','02','03','CHOCOPE\r'),('13','02','04','MAGDALENA DE CAO\r'),('13','02','05','PAIJAN\r'),('13','02','06','RAZURI\r'),('13','02','07','SANTIAGO DE CAO\r'),('13','02','08','CASA GRANDE\r'),('13','03','00','BOLIVAR\r'),('13','03','01','BOLIVAR\r'),('13','03','02','BAMBAMARCA\r'),('13','03','03','CONDORMARCA\r'),('13','03','04','LONGOTEA\r'),('13','03','05','UCHUMARCA\r'),('13','03','06','UCUNCHA\r'),('13','04','00','CHEPEN\r'),('13','04','01','CHEPEN\r'),('13','04','02','PACANGA\r'),('13','04','03','PUEBLO NUEVO\r'),('13','05','00','JULCAN\r'),('13','05','01','JULCAN\r'),('13','05','02','CALAMARCA\r'),('13','05','03','CARABAMBA\r'),('13','05','04','HUASO\r'),('13','06','00','OTUZCO\r'),('13','06','01','OTUZCO\r'),('13','06','02','AGALLPAMPA\r'),('13','06','04','CHARAT\r'),('13','06','05','HUARANCHAL\r'),('13','06','06','LA CUESTA\r'),('13','06','08','MACHE\r'),('13','06','10','PARANDAY\r'),('13','06','11','SALPO\r'),('13','06','13','SINSICAP\r'),('13','06','14','USQUIL\r'),('13','07','00','PACASMAYO\r'),('13','07','01','SAN PEDRO DE LLOC\r'),('13','07','02','GUADALUPE\r'),('13','07','03','JEQUETEPEQUE\r'),('13','07','04','PACASMAYO\r'),('13','07','05','SAN JOSE\r'),('13','08','00','PATAZ\r'),('13','08','01','TAYABAMBA\r'),('13','08','02','BULDIBUYO\r'),('13','08','03','CHILLIA\r'),('13','08','04','HUANCASPATA\r'),('13','08','05','HUAYLILLAS\r'),('13','08','06','HUAYO\r'),('13','08','07','ONGON\r'),('13','08','08','PARCOY\r'),('13','08','09','PATAZ\r'),('13','08','10','PIAS\r'),('13','08','11','SANTIAGO DE CHALLAS\r'),('13','08','12','TAURIJA\r'),('13','08','13','URPAY\r'),('13','09','00','SANCHEZ CARRION\r'),('13','09','01','HUAMACHUCO\r'),('13','09','02','CHUGAY\r'),('13','09','03','COCHORCO\r'),('13','09','04','CURGOS\r'),('13','09','05','MARCABAL\r'),('13','09','06','SANAGORAN\r'),('13','09','07','SARIN\r'),('13','09','08','SARTIMBAMBA\r'),('13','10','00','SANTIAGO DE CHUCO\r'),('13','10','01','SANTIAGO DE CHUCO\r'),('13','10','02','ANGASMARCA\r'),('13','10','03','CACHICADAN\r'),('13','10','04','MOLLEBAMBA\r'),('13','10','05','MOLLEPATA\r'),('13','10','06','QUIRUVILCA\r'),('13','10','07','SANTA CRUZ DE CHUCA\r'),('13','10','08','SITABAMBA\r'),('13','11','00','GRAN CHIMU\r'),('13','11','01','CASCAS\r'),('13','11','02','LUCMA\r'),('13','11','03','MARMOT\r'),('13','11','04','SAYAPULLO\r'),('13','12','00','VIRU\r'),('13','12','01','VIRU\r'),('13','12','02','CHAO\r'),('13','12','03','GUADALUPITO\r'),('14','00','00','LAMBAYEQUE\r'),('14','01','00','CHICLAYO\r'),('14','01','01','CHICLAYO\r'),('14','01','02','CHONGOYAPE\r'),('14','01','03','ETEN\r'),('14','01','04','ETEN PUERTO\r'),('14','01','05','JOSE LEONARDO ORTIZ\r'),('14','01','06','LA VICTORIA\r'),('14','01','07','LAGUNAS\r'),('14','01','08','MONSEFU\r'),('14','01','09','NUEVA ARICA\r'),('14','01','10','OYOTUN\r'),('14','01','11','PICSI\r'),('14','01','12','PIMENTEL\r'),('14','01','13','REQUE\r'),('14','01','14','SANTA ROSA\r'),('14','01','15','SAÂ¥A\r'),('14','01','16','CAYALTI\r'),('14','01','17','PATAPO\r'),('14','01','18','POMALCA\r'),('14','01','19','PUCALA\r'),('14','01','20','TUMAN\r'),('14','02','00','FERREÂ¥AFE\r'),('14','02','01','FERREÂ¥AFE\r'),('14','02','02','CAÂ¥ARIS\r'),('14','02','03','INCAHUASI\r'),('14','02','04','MANUEL ANTONIO MESONES MURO\r'),('14','02','05','PITIPO\r'),('14','02','06','PUEBLO NUEVO\r'),('14','03','00','LAMBAYEQUE\r'),('14','03','01','LAMBAYEQUE\r'),('14','03','02','CHOCHOPE\r'),('14','03','03','ILLIMO\r'),('14','03','04','JAYANCA\r'),('14','03','05','MOCHUMI\r'),('14','03','06','MORROPE\r'),('14','03','07','MOTUPE\r'),('14','03','08','OLMOS\r'),('14','03','09','PACORA\r'),('14','03','10','SALAS\r'),('14','03','11','SAN JOSE\r'),('14','03','12','TUCUME\r'),('15','00','00','LIMA\r'),('15','01','00','LIMA\r'),('15','01','01','LIMA\r'),('15','01','02','ANCON\r'),('15','01','03','ATE\r'),('15','01','04','BARRANCO\r'),('15','01','05','BREÂ¥A\r'),('15','01','06','CARABAYLLO\r'),('15','01','07','CHACLACAYO\r'),('15','01','08','CHORRILLOS\r'),('15','01','09','CIENEGUILLA\r'),('15','01','10','COMAS\r'),('15','01','11','EL AGUSTINO\r'),('15','01','12','INDEPENDENCIA\r'),('15','01','13','JESUS MARIA\r'),('15','01','14','LA MOLINA\r'),('15','01','15','LA VICTORIA\r'),('15','01','16','LINCE\r'),('15','01','17','LOS OLIVOS\r'),('15','01','18','LURIGANCHO\r'),('15','01','19','LURIN\r'),('15','01','20','MAGDALENA DEL MAR\r'),('15','01','21','PUEBLO LIBRE\r'),('15','01','22','MIRAFLORES\r'),('15','01','23','PACHACAMAC\r'),('15','01','24','PUCUSANA\r'),('15','01','25','PUENTE PIEDRA\r'),('15','01','26','PUNTA HERMOSA\r'),('15','01','27','PUNTA NEGRA\r'),('15','01','28','RIMAC\r'),('15','01','29','SAN BARTOLO\r'),('15','01','30','SAN BORJA\r'),('15','01','31','SAN ISIDRO\r'),('15','01','32','SAN JUAN DE LURIGANCHO\r'),('15','01','33','SAN JUAN DE MIRAFLORES\r'),('15','01','34','SAN LUIS\r'),('15','01','35','SAN MARTIN DE PORRES\r'),('15','01','36','SAN MIGUEL\r'),('15','01','37','SANTA ANITA\r'),('15','01','38','SANTA MARIA DEL MAR\r'),('15','01','39','SANTA ROSA\r'),('15','01','40','SANTIAGO DE SURCO\r'),('15','01','41','SURQUILLO\r'),('15','01','42','VILLA EL SALVADOR\r'),('15','01','43','VILLA MARIA DEL TRIUNFO\r'),('15','02','00','BARRANCA\r'),('15','02','01','BARRANCA\r'),('15','02','02','PARAMONGA\r'),('15','02','03','PATIVILCA\r'),('15','02','04','SUPE\r'),('15','02','05','SUPE PUERTO\r'),('15','03','00','CAJATAMBO\r'),('15','03','01','CAJATAMBO\r'),('15','03','02','COPA\r'),('15','03','03','GORGOR\r'),('15','03','04','HUANCAPON\r'),('15','03','05','MANAS\r'),('15','04','00','CANTA\r'),('15','04','01','CANTA\r'),('15','04','02','ARAHUAY\r'),('15','04','03','HUAMANTANGA\r'),('15','04','04','HUAROS\r'),('15','04','05','LACHAQUI\r'),('15','04','06','SAN BUENAVENTURA\r'),('15','04','07','SANTA ROSA DE QUIVES\r'),('15','05','00','CAÂ¥ETE\r'),('15','05','01','SAN VICENTE DE CAÂ¥ETE\r'),('15','05','02','ASIA\r'),('15','05','03','CALANGO\r'),('15','05','04','CERRO AZUL\r'),('15','05','05','CHILCA\r'),('15','05','06','COAYLLO\r'),('15','05','07','IMPERIAL\r'),('15','05','08','LUNAHUANA\r'),('15','05','09','MALA\r'),('15','05','10','NUEVO IMPERIAL\r'),('15','05','11','PACARAN\r'),('15','05','12','QUILMANA\r'),('15','05','13','SAN ANTONIO\r'),('15','05','14','SAN LUIS\r'),('15','05','15','SANTA CRUZ DE FLORES\r'),('15','05','16','ZUÂ¥IGA\r'),('15','06','00','HUARAL\r'),('15','06','01','HUARAL\r'),('15','06','02','ATAVILLOS ALTO\r'),('15','06','03','ATAVILLOS BAJO\r'),('15','06','04','AUCALLAMA\r'),('15','06','05','CHANCAY\r'),('15','06','06','IHUARI\r'),('15','06','07','LAMPIAN\r'),('15','06','08','PACARAOS\r'),('15','06','09','SAN MIGUEL DE ACOS\r'),('15','06','10','SANTA CRUZ DE ANDAMARCA\r'),('15','06','11','SUMBILCA\r'),('15','06','12','VEINTISIETE DE NOVIEMBRE\r'),('15','07','00','HUAROCHIRI\r'),('15','07','01','MATUCANA\r'),('15','07','02','ANTIOQUIA\r'),('15','07','03','CALLAHUANCA\r'),('15','07','04','CARAMPOMA\r'),('15','07','05','CHICLA\r'),('15','07','06','CUENCA\r'),('15','07','07','HUACHUPAMPA\r'),('15','07','08','HUANZA\r'),('15','07','09','HUAROCHIRI\r'),('15','07','10','LAHUAYTAMBO\r'),('15','07','11','LANGA\r'),('15','07','12','LARAOS\r'),('15','07','13','MARIATANA\r'),('15','07','14','RICARDO PALMA\r'),('15','07','15','SAN ANDRES DE TUPICOCHA\r'),('15','07','16','SAN ANTONIO\r'),('15','07','17','SAN BARTOLOME\r'),('15','07','18','SAN DAMIAN\r'),('15','07','19','SAN JUAN DE IRIS\r'),('15','07','20','SAN JUAN DE TANTARANCHE\r'),('15','07','21','SAN LORENZO DE QUINTI\r'),('15','07','22','SAN MATEO\r'),('15','07','23','SAN MATEO DE OTAO\r'),('15','07','24','SAN PEDRO DE CASTA\r'),('15','07','25','SAN PEDRO DE HUANCAYRE\r'),('15','07','26','SANGALLAYA\r'),('15','07','27','SANTA CRUZ DE COCACHACRA\r'),('15','07','28','SANTA EULALIA\r'),('15','07','29','SANTIAGO DE ANCHUCAYA\r'),('15','07','30','SANTIAGO DE TUNA\r'),('15','07','31','SANTO DOMINGO DE LOS OLLEROS\r'),('15','07','32','SURCO\r'),('15','08','00','HUAURA\r'),('15','08','01','HUACHO\r'),('15','08','02','AMBAR\r'),('15','08','03','CALETA DE CARQUIN\r'),('15','08','04','CHECRAS\r'),('15','08','05','HUALMAY\r'),('15','08','06','HUAURA\r'),('15','08','07','LEONCIO PRADO\r'),('15','08','08','PACCHO\r'),('15','08','09','SANTA LEONOR\r'),('15','08','10','SANTA MARIA\r'),('15','08','11','SAYAN\r'),('15','08','12','VEGUETA\r'),('15','09','00','OYON\r'),('15','09','01','OYON\r'),('15','09','02','ANDAJES\r'),('15','09','03','CAUJUL\r'),('15','09','04','COCHAMARCA\r'),('15','09','05','NAVAN\r'),('15','09','06','PACHANGARA\r'),('15','10','00','YAUYOS\r'),('15','10','01','YAUYOS\r'),('15','10','02','ALIS\r'),('15','10','03','ALLAUCA\r'),('15','10','04','AYAVIRI\r'),('15','10','05','AZANGARO\r'),('15','10','06','CACRA\r'),('15','10','07','CARANIA\r'),('15','10','08','CATAHUASI\r'),('15','10','09','CHOCOS\r'),('15','10','10','COCHAS\r'),('15','10','11','COLONIA\r'),('15','10','12','HONGOS\r'),('15','10','13','HUAMPARA\r'),('15','10','14','HUANCAYA\r'),('15','10','15','HUANGASCAR\r'),('15','10','16','HUANTAN\r'),('15','10','17','HUAÂ¥EC\r'),('15','10','18','LARAOS\r'),('15','10','19','LINCHA\r'),('15','10','20','MADEAN\r'),('15','10','21','MIRAFLORES\r'),('15','10','22','OMAS\r'),('15','10','23','PUTINZA\r'),('15','10','24','QUINCHES\r'),('15','10','25','QUINOCAY\r'),('15','10','26','SAN JOAQUIN\r'),('15','10','27','SAN PEDRO DE PILAS\r'),('15','10','28','TANTA\r'),('15','10','29','TAURIPAMPA\r'),('15','10','30','TOMAS\r'),('15','10','31','TUPE\r'),('15','10','32','VIÂ¥AC\r'),('15','10','33','VITIS\r'),('16','00','00','LORETO\r'),('16','01','00','MAYNAS\r'),('16','01','01','IQUITOS\r'),('16','01','02','ALTO NANAY\r'),('16','01','03','FERNANDO LORES\r'),('16','01','04','INDIANA\r'),('16','01','05','LAS AMAZONAS\r'),('16','01','06','MAZAN\r'),('16','01','07','NAPO\r'),('16','01','08','PUNCHANA\r'),('16','01','09','PUTUMAYO\r'),('16','01','10','TORRES CAUSANA\r'),('16','01','12','BELEN\r'),('16','01','13','SAN JUAN BAUTISTA\r'),('16','01','14','TENIENTE MANUEL CLAVERO\r'),('16','02','00','ALTO AMAZONAS\r'),('16','02','01','YURIMAGUAS\r'),('16','02','02','BALSAPUERTO\r'),('16','02','05','JEBEROS\r'),('16','02','06','LAGUNAS\r'),('16','02','10','SANTA CRUZ\r'),('16','02','11','TENIENTE CESAR LOPEZ ROJAS\r'),('16','03','00','LORETO\r'),('16','03','01','NAUTA\r'),('16','03','02','PARINARI\r'),('16','03','03','TIGRE\r'),('16','03','04','TROMPETEROS\r'),('16','03','05','URARINAS\r'),('16','04','00','MARISCAL RAMON CASTILLA\r'),('16','04','01','RAMON CASTILLA\r'),('16','04','02','PEBAS\r'),('16','04','03','YAVARI\r'),('16','04','04','SAN PABLO\r'),('16','05','00','REQUENA\r'),('16','05','01','REQUENA\r'),('16','05','02','ALTO TAPICHE\r'),('16','05','03','CAPELO\r'),('16','05','04','EMILIO SAN MARTIN\r'),('16','05','05','MAQUIA\r'),('16','05','06','PUINAHUA\r'),('16','05','07','SAQUENA\r'),('16','05','08','SOPLIN\r'),('16','05','09','TAPICHE\r'),('16','05','10','JENARO HERRERA\r'),('16','05','11','YAQUERANA\r'),('16','06','00','UCAYALI\r'),('16','06','01','CONTAMANA\r'),('16','06','02','INAHUAYA\r'),('16','06','03','PADRE MARQUEZ\r'),('16','06','04','PAMPA HERMOSA\r'),('16','06','05','SARAYACU\r'),('16','06','06','VARGAS GUERRA\r'),('16','07','00','DATEM DEL MARAÂ¥ON\r'),('16','07','01','BARRANCA\r'),('16','07','02','CAHUAPANAS\r'),('16','07','03','MANSERICHE\r'),('16','07','04','MORONA\r'),('16','07','05','PASTAZA\r'),('16','07','06','ANDOAS\r'),('17','00','00','MADRE DE DIOS\r'),('17','01','00','TAMBOPATA\r'),('17','01','01','TAMBOPATA\r'),('17','01','02','INAMBARI\r'),('17','01','03','LAS PIEDRAS\r'),('17','01','04','LABERINTO\r'),('17','02','00','MANU\r'),('17','02','01','MANU\r'),('17','02','02','FITZCARRALD\r'),('17','02','03','MADRE DE DIOS\r'),('17','02','04','HUEPETUHE\r'),('17','03','00','TAHUAMANU\r'),('17','03','01','IÂ¥APARI\r'),('17','03','02','IBERIA\r'),('17','03','03','TAHUAMANU\r'),('18','00','00','MOQUEGUA\r'),('18','01','00','MARISCAL NIETO\r'),('18','01','01','MOQUEGUA\r'),('18','01','02','CARUMAS\r'),('18','01','03','CUCHUMBAYA\r'),('18','01','04','SAMEGUA\r'),('18','01','05','SAN CRISTOBAL\r'),('18','01','06','TORATA\r'),('18','02','00','GENERAL SANCHEZ CERRO\r'),('18','02','01','OMATE\r'),('18','02','02','CHOJATA\r'),('18','02','03','COALAQUE\r'),('18','02','04','ICHUÂ¥A\r'),('18','02','05','LA CAPILLA\r'),('18','02','06','LLOQUE\r'),('18','02','07','MATALAQUE\r'),('18','02','08','PUQUINA\r'),('18','02','09','QUINISTAQUILLAS\r'),('18','02','10','UBINAS\r'),('18','02','11','YUNGA\r'),('18','03','00','ILO\r'),('18','03','01','ILO\r'),('18','03','02','EL ALGARROBAL\r'),('18','03','03','PACOCHA\r'),('19','00','00','PASCO\r'),('19','01','00','PASCO\r'),('19','01','01','CHAUPIMARCA\r'),('19','01','02','HUACHON\r'),('19','01','03','HUARIACA\r'),('19','01','04','HUAYLLAY\r'),('19','01','05','NINACACA\r'),('19','01','06','PALLANCHACRA\r'),('19','01','07','PAUCARTAMBO\r'),('19','01','08','SAN FRANCISCO DE ASIS DE YARUSYACAN\r'),('19','01','09','SIMON BOLIVAR\r'),('19','01','10','TICLACAYAN\r'),('19','01','11','TINYAHUARCO\r'),('19','01','12','VICCO\r'),('19','01','13','YANACANCHA\r'),('19','02','00','DANIEL ALCIDES CARRION\r'),('19','02','01','YANAHUANCA\r'),('19','02','02','CHACAYAN\r'),('19','02','03','GOYLLARISQUIZGA\r'),('19','02','04','PAUCAR\r'),('19','02','05','SAN PEDRO DE PILLAO\r'),('19','02','06','SANTA ANA DE TUSI\r'),('19','02','07','TAPUC\r'),('19','02','08','VILCABAMBA\r'),('19','03','00','OXAPAMPA\r'),('19','03','01','OXAPAMPA\r'),('19','03','02','CHONTABAMBA\r'),('19','03','03','HUANCABAMBA\r'),('19','03','04','PALCAZU\r'),('19','03','05','POZUZO\r'),('19','03','06','PUERTO BERMUDEZ\r'),('19','03','07','VILLA RICA\r'),('19','03','08','CONSTITUCION\r'),('20','00','00','PIURA\r'),('20','01','00','PIURA\r'),('20','01','01','PIURA\r'),('20','01','04','CASTILLA\r'),('20','01','05','CATACAOS\r'),('20','01','07','CURA MORI\r'),('20','01','08','EL TALLAN\r'),('20','01','09','LA ARENA\r'),('20','01','10','LA UNION\r'),('20','01','11','LAS LOMAS\r'),('20','01','14','TAMBO GRANDE\r'),('20','02','00','AYABACA\r'),('20','02','01','AYABACA\r'),('20','02','02','FRIAS\r'),('20','02','03','JILILI\r'),('20','02','04','LAGUNAS\r'),('20','02','05','MONTERO\r'),('20','02','06','PACAIPAMPA\r'),('20','02','07','PAIMAS\r'),('20','02','08','SAPILLICA\r'),('20','02','09','SICCHEZ\r'),('20','02','10','SUYO\r'),('20','03','00','HUANCABAMBA\r'),('20','03','01','HUANCABAMBA\r'),('20','03','02','CANCHAQUE\r'),('20','03','03','EL CARMEN DE LA FRONTERA\r'),('20','03','04','HUARMACA\r'),('20','03','05','LALAQUIZ\r'),('20','03','06','SAN MIGUEL DE EL FAIQUE\r'),('20','03','07','SONDOR\r'),('20','03','08','SONDORILLO\r'),('20','04','00','MORROPON\r'),('20','04','01','CHULUCANAS\r'),('20','04','02','BUENOS AIRES\r'),('20','04','03','CHALACO\r'),('20','04','04','LA MATANZA\r'),('20','04','05','MORROPON\r'),('20','04','06','SALITRAL\r'),('20','04','07','SAN JUAN DE BIGOTE\r'),('20','04','08','SANTA CATALINA DE MOSSA\r'),('20','04','09','SANTO DOMINGO\r'),('20','04','10','YAMANGO\r'),('20','05','00','PAITA\r'),('20','05','01','PAITA\r'),('20','05','02','AMOTAPE\r'),('20','05','03','ARENAL\r'),('20','05','04','COLAN\r'),('20','05','05','LA HUACA\r'),('20','05','06','TAMARINDO\r'),('20','05','07','VICHAYAL\r'),('20','06','00','SULLANA\r'),('20','06','01','SULLANA\r'),('20','06','02','BELLAVISTA\r'),('20','06','03','IGNACIO ESCUDERO\r'),('20','06','04','LANCONES\r'),('20','06','05','MARCAVELICA\r'),('20','06','06','MIGUEL CHECA\r'),('20','06','07','QUERECOTILLO\r'),('20','06','08','SALITRAL\r'),('20','07','00','TALARA\r'),('20','07','01','PARIÂ¥AS\r'),('20','07','02','EL ALTO\r'),('20','07','03','LA BREA\r'),('20','07','04','LOBITOS\r'),('20','07','05','LOS ORGANOS\r'),('20','07','06','MANCORA\r'),('20','08','00','SECHURA\r'),('20','08','01','SECHURA\r'),('20','08','02','BELLAVISTA DE LA UNION\r'),('20','08','03','BERNAL\r'),('20','08','04','CRISTO NOS VALGA\r'),('20','08','05','VICE\r'),('20','08','06','RINCONADA LLICUAR\r'),('21','00','00','PUNO\r'),('21','01','00','PUNO\r'),('21','01','01','PUNO\r'),('21','01','02','ACORA\r'),('21','01','03','AMANTANI\r'),('21','01','04','ATUNCOLLA\r'),('21','01','05','CAPACHICA\r'),('21','01','06','CHUCUITO\r'),('21','01','07','COATA\r'),('21','01','08','HUATA\r'),('21','01','09','MAÂ¥AZO\r'),('21','01','10','PAUCARCOLLA\r'),('21','01','11','PICHACANI\r'),('21','01','12','PLATERIA\r'),('21','01','13','SAN ANTONIO\r'),('21','01','14','TIQUILLACA\r'),('21','01','15','VILQUE\r'),('21','02','00','AZANGARO\r'),('21','02','01','AZANGARO\r'),('21','02','02','ACHAYA\r'),('21','02','03','ARAPA\r'),('21','02','04','ASILLO\r'),('21','02','05','CAMINACA\r'),('21','02','06','CHUPA\r'),('21','02','07','JOSE DOMINGO CHOQUEHUANCA\r'),('21','02','08','MUÂ¥ANI\r'),('21','02','09','POTONI\r'),('21','02','10','SAMAN\r'),('21','02','11','SAN ANTON\r'),('21','02','12','SAN JOSE\r'),('21','02','13','SAN JUAN DE SALINAS\r'),('21','02','14','SANTIAGO DE PUPUJA\r'),('21','02','15','TIRAPATA\r'),('21','03','00','CARABAYA\r'),('21','03','01','MACUSANI\r'),('21','03','02','AJOYANI\r'),('21','03','03','AYAPATA\r'),('21','03','04','COASA\r'),('21','03','05','CORANI\r'),('21','03','06','CRUCERO\r'),('21','03','07','ITUATA\r'),('21','03','08','OLLACHEA\r'),('21','03','09','SAN GABAN\r'),('21','03','10','USICAYOS\r'),('21','04','00','CHUCUITO\r'),('21','04','01','JULI\r'),('21','04','02','DESAGUADERO\r'),('21','04','03','HUACULLANI\r'),('21','04','04','KELLUYO\r'),('21','04','05','PISACOMA\r'),('21','04','06','POMATA\r'),('21','04','07','ZEPITA\r'),('21','05','00','EL COLLAO\r'),('21','05','01','ILAVE\r'),('21','05','02','CAPAZO\r'),('21','05','03','PILCUYO\r'),('21','05','04','SANTA ROSA\r'),('21','05','05','CONDURIRI\r'),('21','06','00','HUANCANE\r'),('21','06','01','HUANCANE\r'),('21','06','02','COJATA\r'),('21','06','03','HUATASANI\r'),('21','06','04','INCHUPALLA\r'),('21','06','05','PUSI\r'),('21','06','06','ROSASPATA\r'),('21','06','07','TARACO\r'),('21','06','08','VILQUE CHICO\r'),('21','07','00','LAMPA\r'),('21','07','01','LAMPA\r'),('21','07','02','CABANILLA\r'),('21','07','03','CALAPUJA\r'),('21','07','04','NICASIO\r'),('21','07','05','OCUVIRI\r'),('21','07','06','PALCA\r'),('21','07','07','PARATIA\r'),('21','07','08','PUCARA\r'),('21','07','09','SANTA LUCIA\r'),('21','07','10','VILAVILA\r'),('21','08','00','MELGAR\r'),('21','08','01','AYAVIRI\r'),('21','08','02','ANTAUTA\r'),('21','08','03','CUPI\r'),('21','08','04','LLALLI\r'),('21','08','05','MACARI\r'),('21','08','06','NUÂ¥OA\r'),('21','08','07','ORURILLO\r'),('21','08','08','SANTA ROSA\r'),('21','08','09','UMACHIRI\r'),('21','09','00','MOHO\r'),('21','09','01','MOHO\r'),('21','09','02','CONIMA\r'),('21','09','03','HUAYRAPATA\r'),('21','09','04','TILALI\r'),('21','10','00','SAN ANTONIO DE PUTINA\r'),('21','10','01','PUTINA\r'),('21','10','02','ANANEA\r'),('21','10','03','PEDRO VILCA APAZA\r'),('21','10','04','QUILCAPUNCU\r'),('21','10','05','SINA\r'),('21','11','00','SAN ROMAN\r'),('21','11','01','JULIACA\r'),('21','11','02','CABANA\r'),('21','11','03','CABANILLAS\r'),('21','11','04','CARACOTO\r'),('21','12','00','SANDIA\r'),('21','12','01','SANDIA\r'),('21','12','02','CUYOCUYO\r'),('21','12','03','LIMBANI\r'),('21','12','04','PATAMBUCO\r'),('21','12','05','PHARA\r'),('21','12','06','QUIACA\r'),('21','12','07','SAN JUAN DEL ORO\r'),('21','12','08','YANAHUAYA\r'),('21','12','09','ALTO INAMBARI\r'),('21','12','10','SAN PEDRO DE PUTINA PUNCO\r'),('21','13','00','YUNGUYO\r'),('21','13','01','YUNGUYO\r'),('21','13','02','ANAPIA\r'),('21','13','03','COPANI\r'),('21','13','04','CUTURAPI\r'),('21','13','05','OLLARAYA\r'),('21','13','06','TINICACHI\r'),('21','13','07','UNICACHI\r'),('22','00','00','SAN MARTIN\r'),('22','01','00','MOYOBAMBA\r'),('22','01','01','MOYOBAMBA\r'),('22','01','02','CALZADA\r'),('22','01','03','HABANA\r'),('22','01','04','JEPELACIO\r'),('22','01','05','SORITOR\r'),('22','01','06','YANTALO\r'),('22','02','00','BELLAVISTA\r'),('22','02','01','BELLAVISTA\r'),('22','02','02','ALTO BIAVO\r'),('22','02','03','BAJO BIAVO\r'),('22','02','04','HUALLAGA\r'),('22','02','05','SAN PABLO\r'),('22','02','06','SAN RAFAEL\r'),('22','03','00','EL DORADO\r'),('22','03','01','SAN JOSE DE SISA\r'),('22','03','02','AGUA BLANCA\r'),('22','03','03','SAN MARTIN\r'),('22','03','04','SANTA ROSA\r'),('22','03','05','SHATOJA\r'),('22','04','00','HUALLAGA\r'),('22','04','01','SAPOSOA\r'),('22','04','02','ALTO SAPOSOA\r'),('22','04','03','EL ESLABON\r'),('22','04','04','PISCOYACU\r'),('22','04','05','SACANCHE\r'),('22','04','06','TINGO DE SAPOSOA\r'),('22','05','00','LAMAS\r'),('22','05','01','LAMAS\r'),('22','05','02','ALONSO DE ALVARADO\r'),('22','05','03','BARRANQUITA\r'),('22','05','04','CAYNARACHI\r'),('22','05','05','CUÂ¥UMBUQUI\r'),('22','05','06','PINTO RECODO\r'),('22','05','07','RUMISAPA\r'),('22','05','08','SAN ROQUE DE CUMBAZA\r'),('22','05','09','SHANAO\r'),('22','05','10','TABALOSOS\r'),('22','05','11','ZAPATERO\r'),('22','06','00','MARISCAL CACERES\r'),('22','06','01','JUANJUI\r'),('22','06','02','CAMPANILLA\r'),('22','06','03','HUICUNGO\r'),('22','06','04','PACHIZA\r'),('22','06','05','PAJARILLO\r'),('22','07','00','PICOTA\r'),('22','07','01','PICOTA\r'),('22','07','02','BUENOS AIRES\r'),('22','07','03','CASPISAPA\r'),('22','07','04','PILLUANA\r'),('22','07','05','PUCACACA\r'),('22','07','06','SAN CRISTOBAL\r'),('22','07','07','SAN HILARION\r'),('22','07','08','SHAMBOYACU\r'),('22','07','09','TINGO DE PONASA\r'),('22','07','10','TRES UNIDOS\r'),('22','08','00','RIOJA\r'),('22','08','01','RIOJA\r'),('22','08','02','AWAJUN\r'),('22','08','03','ELIAS SOPLIN VARGAS\r'),('22','08','04','NUEVA CAJAMARCA\r'),('22','08','05','PARDO MIGUEL\r'),('22','08','06','POSIC\r'),('22','08','07','SAN FERNANDO\r'),('22','08','08','YORONGOS\r'),('22','08','09','YURACYACU\r'),('22','09','00','SAN MARTIN\r'),('22','09','01','TARAPOTO\r'),('22','09','02','ALBERTO LEVEAU\r'),('22','09','03','CACATACHI\r'),('22','09','04','CHAZUTA\r'),('22','09','05','CHIPURANA\r'),('22','09','06','EL PORVENIR\r'),('22','09','07','HUIMBAYOC\r'),('22','09','08','JUAN GUERRA\r'),('22','09','09','LA BANDA DE SHILCAYO\r'),('22','09','10','MORALES\r'),('22','09','11','PAPAPLAYA\r'),('22','09','12','SAN ANTONIO\r'),('22','09','13','SAUCE\r'),('22','09','14','SHAPAJA\r'),('22','10','00','TOCACHE\r'),('22','10','01','TOCACHE\r'),('22','10','02','NUEVO PROGRESO\r'),('22','10','03','POLVORA\r'),('22','10','04','SHUNTE\r'),('22','10','05','UCHIZA\r'),('23','00','00','TACNA\r'),('23','01','00','TACNA\r'),('23','01','01','TACNA\r'),('23','01','02','ALTO DE LA ALIANZA\r'),('23','01','03','CALANA\r'),('23','01','04','CIUDAD NUEVA\r'),('23','01','05','INCLAN\r'),('23','01','06','PACHIA\r'),('23','01','07','PALCA\r'),('23','01','08','POCOLLAY\r'),('23','01','09','SAMA\r'),('23','01','10','CORONEL GREGORIO ALBARRACIN LANCHIPA\r'),('23','02','00','CANDARAVE\r'),('23','02','01','CANDARAVE\r'),('23','02','02','CAIRANI\r'),('23','02','03','CAMILACA\r'),('23','02','04','CURIBAYA\r'),('23','02','05','HUANUARA\r'),('23','02','06','QUILAHUANI\r'),('23','03','00','JORGE BASADRE\r'),('23','03','01','LOCUMBA\r'),('23','03','02','ILABAYA\r'),('23','03','03','ITE\r'),('23','04','00','TARATA\r'),('23','04','01','TARATA\r'),('23','04','02','HEROES ALBARRACIN\r'),('23','04','03','ESTIQUE\r'),('23','04','04','ESTIQUE-PAMPA\r'),('23','04','05','SITAJARA\r'),('23','04','06','SUSAPAYA\r'),('23','04','07','TARUCACHI\r'),('23','04','08','TICACO\r'),('24','00','00','TUMBES\r'),('24','01','00','TUMBES\r'),('24','01','01','TUMBES\r'),('24','01','02','CORRALES\r'),('24','01','03','LA CRUZ\r'),('24','01','04','PAMPAS DE HOSPITAL\r'),('24','01','05','SAN JACINTO\r'),('24','01','06','SAN JUAN DE LA VIRGEN\r'),('24','02','00','CONTRALMIRANTE VILLAR\r'),('24','02','01','ZORRITOS\r'),('24','02','02','CASITAS\r'),('24','02','03','CANOAS DE PUNTA SAL\r'),('24','03','00','ZARUMILLA\r'),('24','03','01','ZARUMILLA\r'),('24','03','02','AGUAS VERDES\r'),('24','03','03','MATAPALO\r'),('24','03','04','PAPAYAL\r'),('25','00','00','UCAYALI\r'),('25','01','00','CORONEL PORTILLO\r'),('25','01','01','CALLERIA\r'),('25','01','02','CAMPOVERDE\r'),('25','01','03','IPARIA\r'),('25','01','04','MASISEA\r'),('25','01','05','YARINACOCHA\r'),('25','01','06','NUEVA REQUENA\r'),('25','01','07','MANANTAY\r'),('25','02','00','ATALAYA\r'),('25','02','01','RAYMONDI\r'),('25','02','02','SEPAHUA\r'),('25','02','03','TAHUANIA\r'),('25','02','04','YURUA\r'),('25','03','00','PADRE ABAD\r'),('25','03','01','PADRE ABAD\r'),('25','03','02','IRAZOLA\r'),('25','03','03','CURIMANA\r'),('25','04','00','PURUS\r'),('25','04','01','PURUS\r');
/*!40000 ALTER TABLE `tb_ubigeo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_unidadmedida`
--

DROP TABLE IF EXISTS `tb_unidadmedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_unidadmedida` (
  `int_idUnidadMedida` int(11) NOT NULL AUTO_INCREMENT,
  `str_codigoUM` varchar(45) DEFAULT NULL,
  `str_nombreUM` varchar(45) NOT NULL,
  `str_descripcionUM` varchar(100) DEFAULT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_usuarioCreador` varchar(45) NOT NULL,
  `dte_fechaCreacion` datetime NOT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`int_idUnidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_unidadmedida`
--

LOCK TABLES `tb_unidadmedida` WRITE;
/*!40000 ALTER TABLE `tb_unidadmedida` DISABLE KEYS */;
INSERT INTO `tb_unidadmedida` VALUES (1,'U1','UNIDAD','','ACTIVO','SISTEMA','2012-09-24 14:02:27',NULL,NULL),(2,'K7','KILOGRAMO','','ACTIVO','SISTEMA','2012-09-24 16:45:23',NULL,NULL);
/*!40000 ALTER TABLE `tb_unidadmedida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuario` (
  `int_idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `int_idPersona` int(11) NOT NULL,
  `str_usuario` varchar(45) DEFAULT NULL,
  `str_contrasenia` varchar(45) DEFAULT NULL,
  `str_estado` varchar(45) DEFAULT NULL,
  `dte_fechaCreacion` date DEFAULT NULL,
  `str_usuarioCreador` varchar(45) DEFAULT NULL,
  `dte_fechaModificacion` date DEFAULT NULL,
  `str_usuarioModificador` varchar(45) DEFAULT NULL,
  `str_codigoPersona` varchar(45) NOT NULL,
  PRIMARY KEY (`int_idUsuario`),
  KEY `fk_tb_usuario_tb_persona1` (`int_idPersona`),
  KEY `index_estado` (`str_estado`),
  CONSTRAINT `fk_tb_usuario_tb_persona1` FOREIGN KEY (`int_idPersona`) REFERENCES `tb_persona` (`int_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,1,'SYSADMIN','741B00D69BB603A9','ACTIVO','2014-08-23','SISTEMA',NULL,NULL,'S1'),(2,1,'Z1TAVARA','741B00D69BB603A9','ACTIVO','2015-12-05','SYSADMIN',NULL,NULL,'Z1');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_venta`
--

DROP TABLE IF EXISTS `tb_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_venta` (
  `int_idVenta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `int_idProveedor` int(11) NOT NULL,
  `int_idProducto` int(11) NOT NULL,
  `int_idCliente` int(10) unsigned NOT NULL,
  `dbl_cantidad` double NOT NULL,
  `dbl_precio` double NOT NULL,
  `dbl_subTotal` double NOT NULL,
  `dbl_descuento` double NOT NULL,
  `dbl_igv` double NOT NULL,
  `dbl_total` double NOT NULL,
  `str_numeroDocumento` varchar(45) DEFAULT NULL,
  `str_usuario` varchar(45) NOT NULL,
  `str_estado` varchar(45) NOT NULL,
  `str_clienteResponsable` varchar(100) NOT NULL,
  `int_local` int(11) NOT NULL,
  `str_fechaRegistro` datetime NOT NULL,
  `str_fechaModificacion` datetime NOT NULL,
  `dbl_unidadesContenidas` double DEFAULT NULL,
  `str_tipoVenta` varchar(45) DEFAULT NULL,
  `str_comprobantePago` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_idVenta`),
  KEY `fk_venta_cliente` (`int_idCliente`),
  KEY `fk_proveeProduc_venta` (`int_idProveedor`,`int_idProducto`),
  KEY `fk_local_Vennta` (`int_local`),
  CONSTRAINT `fk_local_Vennta` FOREIGN KEY (`int_local`) REFERENCES `tb_locales` (`int_idLocal`),
  CONSTRAINT `fk_proveeProduc_venta` FOREIGN KEY (`int_idProveedor`, `int_idProducto`) REFERENCES `tb_proveedorproducto` (`int_idProveedor`, `int_idProducto`),
  CONSTRAINT `fk_venta_cliente` FOREIGN KEY (`int_idCliente`) REFERENCES `tb_cliente` (`int_idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_venta`
--

LOCK TABLES `tb_venta` WRITE;
/*!40000 ALTER TABLE `tb_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bdmatriz'
--
/*!50003 DROP PROCEDURE IF EXISTS `a_seleccionarTodosProductos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `a_seleccionarTodosProductos`()
BEGIN

SELECT
    `tb_producto`.`int_idProducto`,
    `tb_producto`.`str_codigoInterno`,
    `tb_producto`.`int_idUnidadMedida`,
    `tb_unidadmedida`.`str_nombreUM`,
    `tb_producto`.`int_idMedidaRotacion`,
    `tb_medidarotacion`.`dbl_utilidad`,
    `tb_medidarotacion`.`dbl_adicional`
    
FROM
    `bdmatriz`.`tb_producto` inner join `bdmatriz`.`tb_unidadmedida`
    on `tb_producto`.`int_idUnidadMedida` = `tb_unidadmedida`.`int_idUnidadMedida`
    inner join `bdmatriz`.`tb_medidarotacion`
    on `tb_producto`.`int_idMedidaRotacion` = `tb_medidarotacion`.`int_idMedidaRotacion`
LIMIT 10000;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarImpresora` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarImpresora`(
IN idImpresora integer,
IN nombre varchar(100),
IN marca varchar(45),
IN modelo varchar(45),
IN numeroSerie varchar(45),
IN usuario varchar(45),
IN estado varchar(45)
)
BEGIN
DECLARE existeNS int;
IF estado = 'ELIMINADO' OR estado = 'INACTIVO' THEN
	update tb_impresora set 
	str_marca = marca,
	str_nombre = nombre,
	str_modelo = modelo,
	str_numeroSerie = numeroSerie,
	str_usuarioModificador = usuario,
	str_estado = estado,
	dte_fechaModificacion = now()
	where int_idImpresora = idImpresora and str_estado like 'ACTIVO';
END IF;
IF estado = 'ACTIVO' THEN
	SET existeNS = (select count(numeroSerie) from tb_impresora where str_numeroSerie like numeroSerie and  int_idImpresora <> idImpresora) ;
    IF existeNS<1 THEN
		update tb_impresora set 
		str_marca = marca,
		str_nombre = nombre,
		str_modelo = modelo,
		str_numeroSerie = numeroSerie,
		str_usuarioModificador = usuario,
		str_estado = estado,
		dte_fechaModificacion = now()
		where int_idImpresora = idImpresora;
    END IF;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Adace` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_Adace`(
    IN codigo VARCHAR(45),
    IN medida INT
)
BEGIN

UPDATE
    `bdmatriz`.`tb_producto`
SET
    `tb_producto`.`int_idMedidaRotacion` = medida,
    `tb_producto`.`str_usuarioCreador` = 'SISTEMAS',
    `tb_producto`.`dte_fechaCreacion` = (SELECT NOW())
WHERE
    `tb_producto`.`str_codigoInterno` = codigo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_anularDocumentoVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_anularDocumentoVenta`(
    IN idVenta INT,
    IN estado VARCHAR(45)
)
BEGIN

DECLARE numeroDocumento VARCHAR(45);
SET numeroDocumento = (SELECT `tb_venta`.`str_numeroDocumento` FROM `bdmatriz`.`tb_venta` WHERE `tb_venta`.`int_idVenta` = idVenta);





UPDATE
    `bdmatriz`.`tb_venta`
SET
    `tb_venta`.`str_estado` = estado
WHERE
    `tb_venta`.`str_numeroDocumento` = numeroDocumento;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_anularVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_anularVenta`(
    IN idVenta INT,
    IN estado1 VARCHAR(45),
    IN estado2 VARCHAR(45)
)
BEGIN

DECLARE numeroDocumento VARCHAR(45);
SET numeroDocumento = (SELECT `tb_venta`.`str_numeroDocumento` FROM `bdmatriz`.`tb_venta` WHERE `tb_venta`.`int_idVenta` = idVenta);





UPDATE
    `bdmatriz`.`tb_venta`
SET
    `tb_venta`.`str_estado` = estado1
WHERE
    `tb_venta`.`str_numeroDocumento` = numeroDocumento;





UPDATE
    `bdmatriz`.`tb_almacen`
SET
    `tb_almacen`.`str_estado` = estado2
WHERE
    `tb_almacen`.`str_documento` = numeroDocumento;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarCargoXIDPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarCargoXIDPersona`(
in idPersona int,
in estado varchar(45)
)
BEGIN
select
tc.str_tipoContrato
from tb_contrato c, tb_tipocontrato tc
where c.int_idTipoContrato=tc.int_idTipoContrato and 
c.int_idPersona=idPersona and c.str_estado=estado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarEmpresa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarEmpresa`(
    IN idEmpresa int 
)
BEGIN
SELECT
`tb_empresa`.`int_idEmpresa`,
`tb_empresa`.`str_razonSocial`,
`tb_empresa`.`str_ruc`,
`tb_empresa`.`str_domicilioEmpresa`,
`tb_empresa`.`str_representanteLegal`,
`tb_empresa`.`str_dniRepresentante`,
`tb_empresa`.`str_estado`,
`tb_empresa`.`dte_fechaCreacion`,
`tb_empresa`.`str_usuarioCreador`,
`tb_empresa`.`dte_fechaModificacion`,
`tb_empresa`.`str_usuarioModificador`
FROM `bdmatriz`.`tb_empresa`
where  int_idEmpresa=idEmpresa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarImpresora` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarImpresora`(
IN loca varchar(100),
IN marca varchar(45),
IN modelo varchar(45),
IN numeroSerie varchar(45),
IN estado varchar(45)
)
BEGIN
SELECT 
int_idImpresora,
i.str_nombre,
l.str_direccion,
str_marca,
str_modelo,
str_numeroSerie,
i.str_estado
FROM tb_impresora i inner join tb_locales l on
	i.int_local = l.int_idLocal
where 	int_local like  concat('%',loca,'%') and 
		str_marca like  concat('%',marca,'%') and 
        str_modelo like  concat('%',modelo,'%') and 
        str_numeroSerie like concat('%',numeroSerie,'%')   and
        i.str_estado like  concat('%',estado,'%')
order by i.str_estado asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarMemorandum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_buscarMemorandum`(
   in asunto text,
   in fechaInicial date,
   in fechaFinal date
   )
BEGIN
SELECT
`tb_memorandum`.`int_idMemorandum`,
`tb_memorandum`.`str_numero`,
`tb_memorandum`.`str_emisor`,
`tb_memorandum`.`str_receptor`,
`tb_memorandum`.`str_asunto`,
`tb_memorandum`.`dte_fecha`,
`tb_memorandum`.`str_cuerpo`,
`tb_memorandum`.`str_usuarioCreador`,
`tb_memorandum`.`dte_fechaCreacion`,
`tb_memorandum`.`int_idPersona`,
`tb_memorandum`.`str_estado`
FROM `bdmatriz`.`tb_memorandum`
where  `tb_memorandum`.`str_asunto` like asunto 
and `tb_memorandum`.`dte_fecha` between fechaInicial and fechaFinal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarNumeroSeriePrint` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarNumeroSeriePrint`(
IN idLocal int
)
BEGIN
select str_numeroSerieImpresora from tb_flujocaja where str_motivo like 'APERTURACAJA'  and 
DATE (dte_fechaCreacion) = DATE (NOW())  and int_idLocal = idLocal order by int_idFlujoCaja desc limit 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarPersona`(
    IN apePaterno varchar(45),
    IN apeMaterno varchar(45),
    IN nombres varchar(45),
    IN DNI varchar(8),
    IN estado VARCHAR(8)
)
BEGIN
select
`tb_persona`.`int_idPersona`,
`tb_persona`.`str_codigo`,
`tb_persona`.`str_apePaterno`,
`tb_persona`.`str_apeMaterno`,
`tb_persona`.`str_nombres`,
`tb_persona`.`str_dni`,
`tb_persona`.`str_carnetExtranjeria`,
`tb_persona`.`dte_fechaNacimiento`,
`tb_persona`.`str_ciudadNacimiento`,
`tb_persona`.`str_telefono`,
`tb_persona`.`str_movil`,
`tb_persona`.`str_sexo`,
`tb_persona`.`str_nacionalidad`,
`tb_persona`.`str_correoElectronico`,
`tb_persona`.`str_brevete`,
`tb_persona`.`str_categoriaBrevete`,
`tb_persona`.`str_estadoCivil`,
`tb_persona`.`str_direccion`,
`tb_persona`.`str_distrito`,
`tb_persona`.`str_provincia`,
`tb_persona`.`str_departamento`,
`tb_persona`.`bin_huellaDigital_1`,
`tb_persona`.`bin_huellaDigital_2`,
`tb_persona`.`str_estado`,
`tb_persona`.`dte_fechaCreacion`,
`tb_persona`.`str_usuarioCreador`,
`tb_persona`.`dte_ultimaModificacion`,
`tb_persona`.`str_usuarioModificador`,
`tb_persona`.`blob_foto`
from tb_persona 
    where  str_apePaterno like  concat('%',apePaterno,'%')  and str_apeMaterno like concat('%',apeMaterno , '%')  and
    str_nombres like concat('%',nombres,'%') and str_dni like concat('%',DNI,'%') and str_estado=estado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarPersonaXEmpresa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_buscarPersonaXEmpresa`(
   in idEmpresa int    
)
BEGIN
SELECT
     tb_persona.`int_idPersona` AS tb_persona_int_idPersona,
     tb_persona.`str_codigo` AS tb_persona_str_codigo,
     tb_persona.`str_apePaterno` AS tb_persona_str_apePaterno,
     tb_persona.`str_apeMaterno` AS tb_persona_str_apeMaterno,
     tb_persona.`str_nombres` AS tb_persona_str_nombres,
     tb_contrato.`int_idEmpresa` AS tb_contrato_int_idEmpresa,
     tb_contrato.`int_idPersona` AS tb_contrato_int_idPersona,
     tb_contrato.`str_estado`,
     tb_persona.`str_estado` AS tb_persona_str_estado
FROM
     `tb_persona` tb_persona INNER JOIN `tb_contrato` tb_contrato ON substring(tb_persona.`str_codigo`,2) = tb_contrato.`int_idPersona`
where 
tb_contrato.`int_idEmpresa`=idEmpresa  and tb_persona.`str_estado` = 'ACTIVO'
and tb_contrato.`str_estado` ='ACTIVO';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarPersonaXID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarPersonaXID`(
IN idPersona varchar(45),
IN estado varchar(45)
)
BEGIN
select
`tb_persona`.`int_idPersona`,
`tb_persona`.`str_codigo`,
`tb_persona`.`str_apePaterno`,
`tb_persona`.`str_apeMaterno`,
`tb_persona`.`str_nombres`,
`tb_persona`.`str_dni`,
`tb_persona`.`str_carnetExtranjeria`,
`tb_persona`.`dte_fechaNacimiento`,
`tb_persona`.`str_ciudadNacimiento`,
`tb_persona`.`str_telefono`,
`tb_persona`.`str_movil`,
`tb_persona`.`str_sexo`,
`tb_persona`.`str_nacionalidad`,
`tb_persona`.`str_correoElectronico`,
`tb_persona`.`str_brevete`,
`tb_persona`.`str_categoriaBrevete`,
`tb_persona`.`str_estadoCivil`,
`tb_persona`.`str_direccion`,
`tb_persona`.`str_distrito`,
`tb_persona`.`str_provincia`,
`tb_persona`.`str_departamento`,
`tb_persona`.`bin_huellaDigital_1`,
`tb_persona`.`bin_huellaDigital_2`,
`tb_persona`.`str_estado`,
`tb_persona`.`dte_fechaCreacion`,
`tb_persona`.`str_usuarioCreador`,
`tb_persona`.`dte_ultimaModificacion`,
`tb_persona`.`str_usuarioModificador`,
`tb_persona`.`blob_foto`from tb_persona 
    where   str_estado=estado  and str_codigo=idPersona;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_cantidadXLocalXCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_cantidadXLocalXCaja`(
    IN idLocal INT,
    IN idCaja INT,
    IN motivo1 VARCHAR(45),
    IN motivo2 VARCHAR(45),
    IN motivo3 VARCHAR(45)
)
BEGIN

DECLARE selectIF DOUBLE;
DECLARE cierreCaja DOUBLE;

SET selectIF =
    (SELECT
        SUM(`tb_flujocaja`.`dbl_cantidadTotalSoles`)
    FROM
        `bdmatriz`.`tb_flujocaja`
    WHERE
        `tb_flujocaja`.`int_idLocal` = idLocal
        AND `tb_flujocaja`.`int_idCaja` = idCaja
        AND `tb_flujocaja`.`str_motivo` = motivo3
        AND DATE(`tb_flujocaja`.`dte_fechaCreacion`) = DATE(NOW())
    );
    
SET cierreCaja = (SELECT IF (selectIF > 0, selectIF, 0));





SELECT
    SUM(`tb_flujocaja`.`dbl_cantidadTotalSoles`) - cierreCaja
FROM
    `bdmatriz`.`tb_flujocaja`
WHERE
    `tb_flujocaja`.`int_idLocal` = idLocal
    AND `tb_flujocaja`.`int_idCaja` = idCaja
    AND (`tb_flujocaja`.`str_motivo` = motivo1 OR `tb_flujocaja`.`str_motivo` = motivo2)
    AND DATE(`tb_flujocaja`.`dte_fechaCreacion`) = DATE(NOW());

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaAsistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consultaAsistencia`(
    IN fechaInicio date,
    IN fechaFinal date,
    IN empresa int
)
BEGIN
   SET lc_time_names = 'es_PE';
   select
        p.int_idPersona,
        p.str_apePaterno,
        p.str_apeMaterno,
        p.str_nombres,

        
        
        
        
        e.int_idEmpresa,
        
        
        
        
        
        l.str_Direccion,
        CONCAT(j.tme_HoraInicio, ' - ',j.tme_HoraFin) AS 'Horario',
        CONCAT
        ( DAYNAME(a.dte_fecha),' ', DAY(a.dte_fecha),'  de ',MONTHNAME(a.dte_fecha),' del ',YEAR(a.dte_fecha)) AS 'FECHA MARCADO',
        TIME(a.dte_fecha) as 'Hora Ingreso',
        
        tm.str_descripcion
FROM    tb_asistencia a, 
        tb_horariojornadacontrato hjc,
        tb_contrato c, 
        tb_persona p, 
        tb_locales l, 
        tb_tipomarcado tm,
        tb_empresa e,
        tb_jornada j
where
        a.int_idHorario=hjc.int_idHorario and 
        a.int_idJornada=hjc.int_idJornada and 
        a.int_idContrato=hjc.int_idContrato and
        hjc.int_idJornada=j.int_idJornada and 
        hjc.int_idContrato=c.int_idContrato and 
        p.int_idPersona=c.int_idPersona and
        c.int_local=l.int_idLocal and 
        a.str_tipoMarcado=tm.int_tipoMarcado and
        e.int_idEmpresa=c.int_idEmpresa and
        
         a.dte_fecha  >= fechaInicio and  a.dte_fecha <=fechaFinal and
         e.int_idEmpresa=empresa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaContrato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consultaContrato`(
IN dni varchar(8),
IN estado varchar(45)
)
BEGIN


select

p.int_idPersona,
p.str_codigo,
p.str_apePaterno,
p.str_apeMaterno,
p.str_nombres,
p.str_dni,
p.str_estado,



c.int_idContrato,
c.int_idPersona,
c.int_idTipoContrato,
c.int_idEmpresa,
c.dte_fechaInicial,
c.dte_fechaFinal, 
c.dbl_sueldo,
c.str_estado,



tc.int_idTipoContrato,
tc.str_tipoContrato,
tc.str_nombreReporte,
tc.str_estado,




e.int_idEmpresa,
e.str_razonSocial,
e.str_ruc,
e.str_domicilioEmpresa,
e.str_representanteLegal,
e.str_dniRepresentante,



c.str_usuarioCreador
from tb_persona p, tb_contrato c, tb_tipocontrato tc, tb_empresa e
where 

p.int_idPersona=c.int_idPersona and c.int_idTipoContrato=tc.int_idTipoContrato and
e.int_idEmpresa=c.int_idEmpresa and



p.str_dni like concat('%',dni,'%') and c.str_estado=estado; 



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaContratoRenovar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consultaContratoRenovar`(
IN dni varchar(8),
IN estado varchar(45)
)
BEGIN


select

p.int_idPersona,
p.str_codigo,
p.str_apePaterno,
p.str_apeMaterno,
p.str_nombres,
p.str_dni,
p.str_estado,



c.int_idContrato,
c.int_idPersona,
c.int_idTipoContrato,
c.int_idEmpresa,
c.dte_fechaInicial,
c.dte_fechaFinal, 
c.dbl_sueldo,
c.str_estado,



tc.int_idTipoContrato,
tc.str_tipoContrato,
tc.str_nombreReporte,
tc.str_estado,




e.int_idEmpresa,
e.str_razonSocial,
e.str_ruc,
e.str_domicilioEmpresa,
e.str_representanteLegal,
e.str_dniRepresentante,



c.str_usuarioCreador
from tb_persona p, tb_contrato c, tb_tipocontrato tc, tb_empresa e
where 

p.int_idPersona=c.int_idPersona and c.int_idTipoContrato=tc.int_idTipoContrato and
e.int_idEmpresa=c.int_idEmpresa and



p.str_dni like concat('%',dni,'%') and c.str_estado=estado and (select(now())>=dte_fechaFinal);



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaCorrelativoDocumento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaCorrelativoDocumento`(
    in idlocal int,
    in tipoDocumento varchar(45)
)
BEGIN

select
    td.str_NomCorto,
    cd.str_codigo,
    dv.int_correlativo,
    cd.int_idcodigoDocumento
from
    tb_documentoventa dv,
    tb_codigodocumento cd,
    tb_tipodocumentosalida td
where
    dv.int_codigoDocumento = cd.int_idCodigoDocumento
    and cd.int_documento = td.int_idTipoDocumento
    and cd.int_local = idlocal
    and str_nomCorto = tipoDocumento
order by
    int_correlativo desc
limit 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaDocumentoProforma` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaDocumentoProforma`(in idlocal int
)
BEGIN

select
MAX(CONVERT ((REPLACE(REPLACE(REPLACE(REPLACE(str_numeroDocumento,'PROFO',''),'-',''),'F',''),'B','')) , SIGNED INTEGER))
from tb_venta
where int_Local =idlocal  and str_numeroDocumento like '%PROFO%'
order by str_numeroDocumento desc limit 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaDocumentoVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaDocumentoVenta`(
in idlocal int
)
BEGIN

select
MAX(CONVERT ((REPLACE(REPLACE(REPLACE(REPLACE(str_numeroDocumento,'TEMP',''),'-',''),'F',''),'B','')) , SIGNED INTEGER))
from tb_venta
where int_Local =idlocal  and str_numeroDocumento like '%TEMP%'
order by int_idVenta desc limit 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaFaltas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaFaltas`(
    IN fechaInicio date,
    IN fechaFinal date,
    IN empresa int,
    IN persona varchar(10)
)
BEGIN
   SET lc_time_names = 'es_PE';
   select
        p.int_idPersona,
        p.str_apePaterno,
        p.str_apeMaterno,
        p.str_nombres,
        p.str_dni,

        e.int_idEmpresa,

        l.str_Direccion,
        
        CONCAT(j.tme_HoraInicio, ' - ',j.tme_HoraFin) AS 'Horario',
        
        a.int_asistencia,
        CONCAT(DAYNAME(a.dte_fecha),' ', DAY(a.dte_fecha),' de ',MONTHNAME(a.dte_fecha),' de ',YEAR(a.dte_fecha)) AS 'FECHA MARCADO',
        
        tm.str_descripcion
        
FROM
        tb_asistencia a, 
        tb_horariojornadacontrato hjc,
        tb_contrato c, 
        tb_persona p, 
        tb_locales l, 
        tb_tipomarcado tm,
        tb_empresa e,
        tb_jornada j
where
        a.int_idHorario = hjc.int_idHorario and 
        a.int_idJornada = hjc.int_idJornada and 
        a.int_idContrato = hjc.int_idContrato and
        hjc.int_idJornada = j.int_idJornada and 
        hjc.int_idContrato = c.int_idContrato and 
        p.int_idPersona = c.int_idPersona and
        c.int_local = l.int_idLocal and 
        a.str_tipoMarcado = tm.int_tipoMarcado and
        e.int_idEmpresa = c.int_idEmpresa and
        a.dte_fecha >= fechaInicio and
        a.dte_fecha <= fechaFinal and
        e.int_idEmpresa = empresa and
        a.str_tipoMarcado = 'F' and
        p.str_codigo = persona;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaHorarioJornadaContrato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consultaHorarioJornadaContrato`(
IN contrato int,
IN estado varchar(45)
)
BEGIN
select
p.int_idPersona,
concat(str_nombres,' ',str_apePaterno,' ',str_apeMaterno) as 'Nombre',
e.int_idEmpresa,
e.str_razonSocial,
e.str_ruc,
c.int_idContrato,
c.dte_fechaInicial,
c.dte_fechaFinal,













h.int_idHorario,
h.str_nombreHorario,
h.str_estado,




j.int_idJornada,
j.tme_HoraInicio,
j.tme_horaFin,
j.str_estado,




hj.int_idHorario,
hj.int_idJornada,
hj.str_estado


from  tb_horariojornadacontrato hcj ,  tb_horariojornada hj , tb_horario h , tb_jornada j, tb_contrato c , tb_empresa e, tb_persona p
where hcj.int_idHorario=hj.int_idHorario 
and   hcj.int_idJornada=hj.int_idJornada 
and   hj.int_idHorario=h.int_idHorario and hj.int_idJornada= j.int_idJornada
and   c.int_idContrato=hcj.int_idContrato
and   e.int_idEmpresa=c.int_idEmpresa 
and   c.int_idPersona=p.int_idPersona
and   hcj.int_idContrato=contrato
and   c.str_estado=estado
and   hcj.str_estado=estado
order by hj.int_idHorario asc, tme_HoraInicio asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaIdAlmacen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaIdAlmacen`(
in idLocal int,
in documento varchar(100)
)
BEGIN


select
int_idAlmacen
from tb_almacen
where `tb_almacen`.`int_idLocal` = idLocal
    AND `tb_almacen`.`str_documento` = documento;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaIdVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaIdVenta`(
in idLocal int,
in documento varchar(100)
)
BEGIN
select
int_idVenta
from tb_venta
where
`tb_venta`.`int_local` = idLocal
    AND `tb_venta`.`str_numeroDocumento` = documento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaIGV` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaIGV`()
BEGIN
select
dblIGV
from tb_config limit 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaLocal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consultaLocal`(
    in idEmpresa varchar(11),
    in estado varchar(45)
)
BEGIN
    SELECT
    `tb_locales`.`int_idLocal`,
    `tb_locales`.`str_nombre`,
    `tb_locales`.`str_direccion`,
    `tb_locales`.`str_estado`,
    `tb_locales`.`str_telefono`,

    `tb_empresa`.`int_idEmpresa`,
    `tb_empresa`.`str_razonSocial`,
    `tb_empresa`.`str_ruc`,
    `tb_locales`.`str_distrito`,
    `tb_locales`.`str_provincia`,
    `tb_locales`.`str_departamento`,
    `tb_locales`.`str_codLocalGuia`


    
FROM 
    `tb_locales` inner join `tb_empresa` on 
    `tb_locales`.`int_idEmpresa` = `tb_empresa`.`int_idEmpresa`
where
    `tb_locales`.`int_idEmpresa` like idEmpresa and
    `tb_locales`.`str_estado` = estado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaMarco` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consultaMarco`(
in contrato int,
in horario int,
in jornada int
)
BEGIN
select
    int_asistencia,
    int_idHorario,
    int_idJornada,
    int_idContrato,
    dte_fecha,
    str_estadoMarcado,
    str_tipoMarcado
from tb_asistencia a
where 
      date(a.dte_fecha)=date(now()) and 
      a.int_idContrato=contrato and 
      a.int_idHorario=horario and a.int_idJornada=jornada;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaPrefijoDocumentoXLocalXtipoDocumneto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consultaPrefijoDocumentoXLocalXtipoDocumneto`(
IN inLocal int,
IN inTipoDocumento int
)
BEGIN
select 
concat(t.str_NomCorto,'-',c.str_codigo,'-')
from tb_codigodocumento c inner join tb_tipodocumentosalida t  on
								 c.int_documento = t.int_idTipoDocumento
where c.int_local = inLocal and c.int_documento = inTipoDocumento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaProformasXLocal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaProformasXLocal`(
in idlocal int,
in documento varchar(100)
)
BEGIN
select
p.int_idProducto codigo,
p.str_nombreProducto nombre,
p.str_fabricante fabricante,
v.int_idVenta ,
v.int_idProveedor,
v.int_idProducto,
v.int_idCliente,
v.dbl_cantidad,
v.dbl_precio,
v.dbl_subTotal,
v.dbl_descuento,
v.dbl_igv,
v.dbl_total,
v.str_numeroDocumento,
v.str_usuario,
v.str_estado,
v.str_clienteResponsable,
v.int_local,
v.str_fechaRegistro,

v.dbl_unidadesContenidas,
ROUND ((ppum.dbl_precioUnidadContenida*(1+(mr.dbl_utilidad/100))+dbl_costoTraslado)*(1+(mr.dbl_adicional/100)),2) as precio,

(select (sum(a.dbl_cantidad))*ppum.dbl_unidadesContenidas  from tb_almacen a where a.int_IdProveedor=pp.int_idProveedor and a.int_idProducto=pp.int_idProducto and a.int_idLocal= idlocal) as sock,
ppum.dbl_unidadesContenidas as stockUnidadCompra,
p.str_reintegrotributario as reintegro,
mr.dbl_adicional,
um.int_idUnidadMedida CUM,
um.str_nombreUM UM
from tb_venta v, tb_proveedorproducto pp,tb_producto p,tb_proveedorproductounidadmedida ppum,tb_medidarotacion mr,tb_unidadmedida um
where v.int_idProveedor =pp.int_idProveedor and v.int_idProducto=pp.int_idProducto
      and v.int_idProducto=p.int_idProducto
      and ppum.int_idProveedor=pp.int_idProveedor and ppum.int_idProducto=p.int_idProducto
      and mr.int_idMedidaRotacion=p.int_idMedidaRotacion
      and v.str_numeroDocumento =documento
      and v.int_local=idlocal
      and ppum.int_idUnidadMedidaVenta=um.int_idUnidadMedida
group by p.int_idProducto,  str_numeroDocumento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaProformaXClienteXLocal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaProformaXClienteXLocal`(
in idlocal int,
in cliente varchar(100),
in strDocumento varchar(45)
)
BEGIN

select
  v.str_numeroDocumento,
  c.str_rucdni,
  c.str_razonSocial,
  sum(v.dbl_subTotal),
  sum(v.dbl_igv),
  sum(v.dbl_descuento),
  sum(v.dbl_total),
  v.str_fechaRegistro
from tb_venta v,tb_cliente c
where (v.int_idCliente=c.int_idCliente
      and v.str_numeroDocumento like'PROFO%'
      and c.str_razonSocial like concat('%',cliente,'%')
      and v.int_local=idlocal)
      or (v.str_numeroDocumento like concat('%',strDocumento,'%') and v.str_numeroDocumento like'PROFO%')
group by v.str_numeroDocumento,v.int_local;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaStock` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaStock`(
in ilocal int,
in producto varchar(100),
in producto2 varchar(100)
)
BEGIN


select
p.int_idProducto codigo,
p.str_nombreProducto nombre,
p.str_fabricante fabricante,
pro.int_idProveedor as "Codigo Proveedor",
pro.str_razonSocial proveedor,
um.int_idUnidadMedida CUM,
um.str_nombreUM UM,


ROUND ((ppum.dbl_precioUnidadContenida*(1+(mr.dbl_utilidad/100))+dbl_costoTraslado)*(1+(mr.dbl_adicional/100)),2) as precio,

(sum(a.dbl_cantidad))*ppum.dbl_unidadesContenidas as stock,
ppum.dbl_unidadesContenidas as stockUnidadCompra,
p.str_reintegrotributario as reintegro,
mr.dbl_adicional,
ppum.dbl_precioOferta,
p.str_codigoInterno 
from tb_producto p, tb_proveedorproducto pp,
     tb_unidadmedida um, tb_almacen a, tb_proveedorproductounidadmedida ppum,
     tb_proveedor pro,  tb_medidarotacion mr
where p.int_idProducto=pp.int_idProducto and pro.int_idProveedor=pp.int_idProveedor and
      ppum.int_idUnidadMedidaVenta=um.int_idUnidadMedida and (a.int_idProveedor=pro.int_idProveedor and
      a.int_idProducto=p.int_idProducto) and
      (ppum.int_idProveedor=pro.int_idProveedor and ppum.int_idProducto=p.int_idProducto and um.int_idUnidadMedida=ppum.int_idUnidadMedidaVenta) and
      mr.int_idMedidaRotacion=p.int_idMedidaRotacion and
      (((p.str_nombreProducto like concat('%',producto,'%')) and (p.str_nombreProducto like concat('%',producto2,'%'))) or (p.str_codigoInterno=producto))and
      a.int_idLocal=ilocal
      AND a.str_estado = 'ACTIVO'
group by ppum.int_idUnidadMedidaVenta, ppum.int_idProducto
order by stock desc
limit 100;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaUsuarioPorPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consultaUsuarioPorPersona`(
IN persona Varchar(45),
IN estado varchar(45)
)
BEGIN

 
SELECT
int_idUsuario,
int_idPersona,
str_usuario,
str_contrasenia,
str_estado
FROM tb_usuario
where str_codigoPersona = persona and str_estado=estado;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultaVentaXDocumento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaVentaXDocumento`(
in documento varchar(45),
in idLocal int
)
BEGIN
select
c.str_rucdni,
c.str_razonSocial,
c.str_direccion,
v.str_numeroDocumento,
v.str_fechaRegistro,
v.str_usuario,
p.str_codigoInterno,
p.str_nombreProducto,
v.dbl_cantidad,
v.dbl_precio,
v.dbl_subTotal,
v.dbl_descuento,
v.dbl_igv
from tb_producto p, tb_venta v, tb_cliente c
where p.int_idProducto=v.int_idProducto and v.int_idCliente=c.int_idCliente
AND v.str_numeroDocumento =  documento and v.int_local =idLocal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_desactivaFunciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_desactivaFunciones`(
in idUsuario int,
in estadoActualizar varchar(45)
)
BEGIN
update tb_funcionusuario set str_estado=estadoActualizar where int_idUsuario=idUsuario;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_desactivarHorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_desactivarHorario`(
 IN idContrato int
)
BEGIN
UPDATE
    tb_horariojornadacontrato

SET
    str_estado = 'INACTIVO',
    dte_fechaModificacion = date(now()),
    str_usuarioModificador = 'SISTEMAS'

WHERE
    int_idContrato = idContrato;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_exiteContrato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_exiteContrato`(
IN persona int,
IN estado varchar(45)
)
BEGIN
select count(int_idContrato) from tb_contrato
where str_estado=estado and int_idPersona=persona;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_exitePermiso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_exitePermiso`(
in idPersona int,
in fecha date,
in horaSalida time,
in horaLlegada time,
in estado varchar(45)
)
BEGIN
select
int_idPermisos,
dte_fecha,
str_motivo,
tm_horaSalida,
tm_horaLlegada,
str_observacion,
str_estado,
tm_horaMarcadoSalida,
tm_horaMarcadoLlegada,
dte_fechaRegistro,
int_idPersona

from tb_permisos p
where p.dte_fecha=fecha and ((tm_horaSalida between horaSalida and horaLlegada) 
                            or (tm_horaLlegada between horaSalida and horaLlegada)) and
      idPersona=int_idPersona and str_estado=estado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_exitePersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_exitePersona`(
IN dni VARCHAR(8),
IN estado varchar(45)
)
BEGIN
    SELECT
        COUNT(int_idPersona)
    FROM tb_persona
    where str_dni = dni and str_estado=estado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_fechaHoraMysql` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_fechaHoraMysql`()
BEGIN
select now();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_filtradoHorarioJornada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_filtradoHorarioJornada`(
   IN idContrato int
)
BEGIN

SELECT
    int_idJornada,
    int_idHorario,
    str_estado
FROM
    tb_horariojornadacontrato
WHERE
    int_idContrato = idContrato and
    str_estado='ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_imprimirGuia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_imprimirGuia`(
    
    in nroGuia varchar(11),
    in estado varchar(45),
    in localPartida varchar(45)

)
BEGIN

SELECT

`tb_guiaremision`.`int_idGuiaremision`,         
`tb_guiaremision`.`str_numeroGuia`,             
`tb_guiaremision`.`dte_fechaEmision`,           
`tb_guiaremision`.`dte_fechaInicioTraslado`,    
`tb_guiaremision`.`str_motivoTraslado`,         
`tb_guiaremision`.`str_domicilioPartida`,       
`tb_guiaremision`.`str_domicilioLlegada`,       
`tb_guiaremision`.`str_placaMarcaVehiculo`,     
`tb_guiaremision`.`str_inscripcionVehiculo`,    
`tb_guiaremision`.`str_breveteConductor`,       
`tb_guiaremision`.`str_destinatarioNombre`,     
`tb_guiaremision`.`str_destinatarioRuc`,        
`tb_guiaremision`.`str_destinatarioDireccion`,  
`tb_guiaremision`.`str_comprobantePago`,        
`tb_guiaremision`.`str_nroComprobante`,         
`tb_guiaremision`.`str_estado`,                 
`tb_guiaremision`.`str_localPartida` ,          
`tb_guiaremision`.`str_rucTransportista` ,      
`tb_guiaremision`.`str_nombreTransportista` ,   

`tb_detalleguia`.`int_idProducto`,              
`tb_detalleguia`.`dbl_cantidadProducto`,        
`tb_detalleguia`.`str_descripcionProducto`,     
`tb_detalleguia`.`dbl_peso`,                    
`tb_detalleguia`.`dbl_costoTraslado`
           




FROM `bdmatriz`.`tb_guiaremision` inner join `bdmatriz`.`tb_detalleguia` on 
`tb_guiaremision`.`int_idGuiaremision` = `tb_detalleguia`.`int_idGuiaremision`

where 
 `tb_guiaremision`.`int_idGuiaremision` = nroGuia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_imprimirVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_imprimirVenta`(
    in nroDocumento varchar(45)
)
BEGIN
SELECT
     tb_producto.`str_codigoInterno` AS codigoInterno,
     (tb_venta.`dbl_cantidad`*tb_venta.`dbl_unidadesContenidas`) AS cantidad,
     tb_unidadmedida.`str_nombreUM` AS nombreUM,
     tb_producto.`str_nombreProducto` AS nombreProducto,
     tb_venta.`dbl_subTotal` AS subTotal,
     tb_venta.`dbl_descuento` AS Totaldescuento,     
     tb_venta.`dbl_total` AS total,
     tb_venta.`str_usuario` AS vendedor,
     tb_cliente.`str_razonSocial` AS razonSocialCliente,
     tb_cliente.`str_rucdni` AS rucdniCliente,
     tb_cliente.`str_direccion` AS direccionCliente,
     tb_venta.`str_fechaModificacion` AS tb_venta_str_fechaModificacion,
 tb_venta.`dbl_precio` AS precioUnitario,
(select sum(tb_venta.`dbl_subTotal`) from tb_venta where tb_venta.`str_numeroDocumento` = nroDocumento) as sumaSubTotal,
(select sum(tb_venta.`dbl_descuento`) from tb_venta where tb_venta.`str_numeroDocumento` = nroDocumento) as sumaDesc,
(select sum(tb_venta.`dbl_total`) from tb_venta where tb_venta.`str_numeroDocumento` = nroDocumento) as sumaTotal,
(select sum(tb_venta.`dbl_igv`) from tb_venta where tb_venta.`str_numeroDocumento` = nroDocumento) as sumaIGV,
      tb_venta.str_clienteResponsable
FROM
     `tb_proveedorproducto` tb_proveedorproducto INNER JOIN `tb_venta` tb_venta ON tb_proveedorproducto.`int_idProveedor` = tb_venta.`int_idProveedor`
     AND tb_proveedorproducto.`int_idProducto` = tb_venta.`int_idProducto`
     INNER JOIN `tb_producto` tb_producto ON tb_proveedorproducto.`int_idProducto` = tb_producto.`int_idProducto`
     INNER JOIN `tb_proveedorproductounidadmedida` tb_proveedorproductounidadmedida ON tb_proveedorproducto.`int_idProveedor` = tb_proveedorproductounidadmedida.`int_idProveedor`
     AND tb_proveedorproducto.`int_idProducto` = tb_proveedorproductounidadmedida.`int_idProducto`
     INNER JOIN `tb_unidadmedida` tb_unidadmedida ON tb_proveedorproductounidadmedida.`int_idUnidadMedidaVenta` = tb_unidadmedida.`int_idUnidadMedida`
     INNER JOIN `tb_cliente` tb_cliente ON tb_venta.`int_idCliente` = tb_cliente.`int_idCliente`
WHERE
     tb_venta.`str_numeroDocumento` = nroDocumento
     and tb_venta.`str_estado` = 'PAGADO';
 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertAlmacen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertAlmacen`(
    IN idProveedor INT,
    IN idProducto INT,
    IN idLocal INT,
    IN idTipoMovimiento INT,
    IN documento VARCHAR(45),
    IN cantidad DOUBLE,
    IN precio DOUBLE,
    IN igv DOUBLE,
    IN subTotal DOUBLE,
    IN descuento DOUBLE,
    IN fechaDocumento VARCHAR(45),
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

DECLARE selectIF DOUBLE;
DECLARE cantidadTemp DOUBLE;
declare stock double;

set stock= (select sum(`tb_almacen`.`dbl_cantidad`) 
from `bdmatriz`.`tb_almacen` where `tb_almacen`.`str_estado`='ACTIVO' and `tb_almacen`.`int_idProveedor` = idProveedor
    AND `tb_almacen`.`int_idProducto` = idProducto); 


SET selectIF =
    (SELECT SUM(`tb_almacen`.`dbl_cantidad`)
    FROM `bdmatriz`.`tb_almacen`
    WHERE `tb_almacen`.`int_idProveedor` = idProveedor
    AND `tb_almacen`.`int_idProducto` = idProducto
    AND `tb_almacen`.`int_idLocal` = idLocal
    AND `tb_almacen`.`str_documento` = documento);

SET cantidadTemp = (SELECT IF (selectIF > 0, selectIF, 0));





INSERT INTO
    `bdmatriz`.`tb_almacen`(
        `tb_almacen`.`int_idAlmacen`,
        `tb_almacen`.`int_idProveedor`,
        `tb_almacen`.`int_idProducto`,
        `tb_almacen`.`int_idLocal`,
        `tb_almacen`.`int_idTipoMovimiento`,
        `tb_almacen`.`str_documento`,
        `tb_almacen`.`dbl_cantidad`,
        `tb_almacen`.`dbl_precio`,
        `tb_almacen`.`dbl_igv`,
        `tb_almacen`.`dbl_subTotal`,
        `tb_almacen`.`dbl_descuento`,
        `tb_almacen`.`str_fechaDocumento`,
        `tb_almacen`.`str_estado`,
        `tb_almacen`.`str_usuarioCreador`,
        `tb_almacen`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    idProveedor,
    idProducto,
    idLocal,
    idTipoMovimiento,
    documento,
    (cantidad - cantidadTemp),
    precio,
    igv,
    subTotal,
    descuento,
    fechaDocumento,
    estado,
    usuarioCreador,
    (SELECT NOW())
);
update `bdmatriz`.`tb_almacen` set `tb_almacen`.`dbl_stock`= (stock+cantidad)
where `tb_almacen`.`int_idAlmacen`=last_insert_id();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertAlmacenDocAnulado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertAlmacenDocAnulado`(
    IN idProveedor INT,
    IN idProducto INT,
    IN idLocal INT,
    IN idTipoMovimiento INT,
    IN documento VARCHAR(45),
    IN cantidad double,
    IN precio DOUBLE,
    IN igv DOUBLE,
    IN subTotal DOUBLE,
    IN descuento DOUBLE,
    
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN


declare stock double;

set stock= (select sum(`tb_almacen`.`dbl_cantidad`) 
from `bdmatriz`.`tb_almacen` where `tb_almacen`.`str_estado`='ACTIVO' and `tb_almacen`.`int_idProveedor` = idProveedor
    AND `tb_almacen`.`int_idProducto` = idProducto); 


INSERT INTO
    `bdmatriz`.`tb_almacen`(
        `tb_almacen`.`int_idAlmacen`,
        `tb_almacen`.`int_idProveedor`,
        `tb_almacen`.`int_idProducto`,
        `tb_almacen`.`int_idLocal`,
        `tb_almacen`.`int_idTipoMovimiento`,
        `tb_almacen`.`str_documento`,
        `tb_almacen`.`dbl_cantidad`,
        `tb_almacen`.`dbl_precio`,
        `tb_almacen`.`dbl_igv`,
        `tb_almacen`.`dbl_subTotal`,
        `tb_almacen`.`dbl_descuento`,
        `tb_almacen`.`str_fechaDocumento`,
        `tb_almacen`.`str_estado`,
        `tb_almacen`.`str_usuarioCreador`,
        `tb_almacen`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    idProveedor,
    idProducto,
    idLocal,
    idTipoMovimiento,
    documento,
    cantidad,
    precio,
    igv,
    subTotal,
    descuento,
    (SELECT NOW()),
    estado,
    usuarioCreador,
    (SELECT NOW())
);

update `bdmatriz`.`tb_almacen` set `tb_almacen`.`dbl_stock`=  (stock+cantidad)
where `tb_almacen`.`int_idAlmacen`=last_insert_id();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertAlmacenTraspaso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertAlmacenTraspaso`(
    IN idProveedor INT,
    IN idProducto INT,
    IN idLocal INT,
    IN idTipoMovimiento INT,
    IN documento VARCHAR(45),
    IN cantidad double,
    IN precio DOUBLE,
    IN igv DOUBLE,
    IN subTotal DOUBLE,
    IN descuento DOUBLE,
    IN fechaDocumento VARCHAR(45),
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

declare stock double;

set stock= (select sum(`tb_almacen`.`dbl_cantidad`) 
from `bdmatriz`.`tb_almacen` where `tb_almacen`.`str_estado`='ACTIVO' and `tb_almacen`.`int_idProveedor` = idProveedor
    AND `tb_almacen`.`int_idProducto` = idProducto); 


INSERT INTO
    `bdmatriz`.`tb_almacen`(
        `tb_almacen`.`int_idAlmacen`,
        `tb_almacen`.`int_idProveedor`,
        `tb_almacen`.`int_idProducto`,
        `tb_almacen`.`int_idLocal`,
        `tb_almacen`.`int_idTipoMovimiento`,
        `tb_almacen`.`str_documento`,
        `tb_almacen`.`dbl_cantidad`,
        `tb_almacen`.`dbl_precio`,
        `tb_almacen`.`dbl_igv`,
        `tb_almacen`.`dbl_subTotal`,
        `tb_almacen`.`dbl_descuento`,
        `tb_almacen`.`str_fechaDocumento`,
        `tb_almacen`.`str_estado`,
        `tb_almacen`.`str_usuarioCreador`,
        `tb_almacen`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    idProveedor,
    idProducto,
    idLocal,
    idTipoMovimiento,
    documento,
    cantidad,
    precio,
    igv,
    subTotal,
    descuento,
    fechaDocumento,
    estado,
    usuarioCreador,
    NOW()
);


update `bdmatriz`.`tb_almacen` set `tb_almacen`.`dbl_stock`= (stock+dbl_cantidad)
where `tb_almacen`.`int_idAlmacen`=last_insert_id();


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertarDocumentoVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertarDocumentoVenta`(
    in correlativo int,
    in documento int,
    in total double
)
BEGIN

insert into
    tb_documentoventa(
        int_idDocumentoVenta,
        int_correlativo,
        int_codigoDocumento,
        db_total
    )
values(
    null,
    correlativo,
    documento,
    total
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertarPartTime` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertarPartTime`(
in int_idContrato int,
in str_estado varchar(45),
in str_iniFin varchar(45)

)
BEGIN

INSERT INTO `bdmatriz`.`tb_mediotiempo`
(
`int_asistencia`,
`dte_marcacion`,
`str_estado`,
`str_iniFin`)
VALUES
(
(select `tb_asistencia`.`int_asistencia` 
from `tb_asistencia` 
where `tb_asistencia`.`int_idContrato`=int_idContrato 
and `tb_asistencia`.`str_tipoMarcado`='F' 
and date(`tb_asistencia`.`dte_fecha`)=(select date(now()))),
(select now()),
str_estado,
str_iniFin
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertarPermiso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertarPermiso`(
in fechaPermiso date,
in motivo Varchar(45),
in horaSalida time,
in horaLlegada time,
in observaciones text,
in estado varchar(45),


in idpersona int
)
BEGIN

insert into tb_permisos(
int_idPermisos,
dte_fecha,
str_motivo,
tm_horaSalida,
tm_horaLlegada,
str_observacion,
str_estado,
dte_fechaRegistro,
int_idPersona
)
values(null,fechaPermiso,motivo,horaSalida,horaLlegada,observaciones,estado,(select(now())),idpersona);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertCliente`(
    IN razonSocial VARCHAR(100),
    IN rucdni VARCHAR(11),
    IN direccion VARCHAR(200),
    IN telefono VARCHAR(15),
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_cliente`(
        `tb_cliente`.`int_idCliente`,
        `tb_cliente`.`str_razonSocial`,
        `tb_cliente`.`str_rucdni`,
        `tb_cliente`.`str_direccion`,
        `tb_cliente`.`str_telefono`,
        `tb_cliente`.`str_estado`,
        `tb_cliente`.`str_usuarioCreador`,
        `tb_cliente`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    razonSocial,
    rucdni,
    direccion,
    telefono,
    estado,
    usuarioCreador,
    (SELECT NOW())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertConformidadCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertConformidadCompra`(
    in idNroOC int,
    in estado varchar(45),
    in usuarioCreador varchar(45)
)
BEGIN
INSERT INTO `bdmatriz`.`tb_conformidadcompra`
(`int_idConformidadCompra`,
`str_nroConformidad`,
`int_nroOrdenCompra`,
`str_estado`,
`str_usuarioCreador`,
`dte_fechaCreacion`,
`str_usuarioModificador`,
`dte_fechaModificacion`)
VALUES
(
null,
concat('C-',idNroOC,'-',last_insert_id()),
idNroOC,
estado,
usuarioCreador,
now()

);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertContrato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertContrato`(
    
    IN idPersona int,
    IN idTipoContrato int,
    IN idEmpresa int,
    IN fechaInicial date,
    IN fechaFinal date,
    IN sueldo Double,
    IN estado varchar(45),    
    IN usuarioCreador varchar(45),
    IN localEmpresa int
    
    
    
    
)
BEGIN
INSERT INTO `bdmatriz`.`tb_contrato`
(`int_idContrato`,
`int_idPersona`,
`int_idTipoContrato`,
`int_idEmpresa`,
`dte_fechaInicial`,
`dte_fechaFinal`,
`dbl_sueldo`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,


`int_local`

)

VALUES
(
null,
idPersona,
idTipoContrato,
idEmpresa,
fechaInicial,
fechaFinal,
sueldo,
estado,
(select now()),
usuarioCreador,


localEmpresa

);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertCronogramaPagos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertCronogramaPagos`(
    IN idObligacionesPago INT,
    IN numeroLetra VARCHAR(45),
    IN fechaEmision VARCHAR(45),
    IN diasCalendario INT,
    IN fechaVencimiento VARCHAR(45),
    IN monto DOUBLE,
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_cronogramapagos`(
        `tb_cronogramapagos`.`int_idCronogramaPagos`,
        `tb_cronogramapagos`.`int_idObligacionesPago`,
        `tb_cronogramapagos`.`str_numeroLetra`,
        `tb_cronogramapagos`.`str_fechaEmision`,
        `tb_cronogramapagos`.`int_diasCalendario`,
        `tb_cronogramapagos`.`str_fechaVencimiento`,
        `tb_cronogramapagos`.`dbl_monto`,
        `tb_cronogramapagos`.`str_estado`,
        `tb_cronogramapagos`.`str_usuarioCreador`,
        `tb_cronogramapagos`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    idObligacionesPago,
    numeroLetra,
    fechaEmision,
    diasCalendario,
    fechaVencimiento,
    monto,
    estado,
    usuarioCreador,
    (SELECT NOW())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertDetalleGuia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertDetalleGuia`(
    in idProducto int,
    in cantidad double,
    in descProducto varchar(200),
    in peso double,
    in costoTraslado double,
    in estado varchar(45),
    in usuarioCreador varchar(45),
    in idProveedor varchar(11)
)
BEGIN
INSERT INTO `bdmatriz`.`tb_detalleguia`
(`int_idGuiaremision`,
`int_idProducto`,
`dbl_cantidadProducto`,
`str_descripcionProducto`,
`dbl_peso`,
`dbl_costoTraslado`,
`str_estado`,
`str_usuarioCreador`,
`dte_fechaCreacion`,
`int_idProveedor`
)
VALUES
((select last_insert_id(int_idGuiaRemision) from tb_guiaremision 
where int_idGuiaRemision=last_insert_id()),
idProducto,
cantidad,
descProducto,
peso,
costoTraslado,
estado,
usuarioCreador,
now(),
idProveedor
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertFacturaCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertFacturaCompra`(
    IN numeroFactura VARCHAR(45),
    IN numeroGuia VARCHAR(45),
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_facturacompra`(
        `tb_facturacompra`.`int_idFacturaCompra`,
        `tb_facturacompra`.`str_numeroFactura`,
        `tb_facturacompra`.`str_numeroGuia`,
        `tb_facturacompra`.`str_estado`,
        `tb_facturacompra`.`str_usuarioCreador`,
        `tb_facturacompra`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    numeroFactura,
    numeroGuia,
    estado,
    usuarioCreador,
    (SELECT NOW())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertFamilia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertFamilia`(
    in nombre varchar(45),
    in descripcion varchar(45),
    in usuarioCreador varchar(45),
    in estado varchar(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_familia`(
        `tb_familia`.`int_idFamilia`,
        `tb_familia`.`str_nombre`,
        `tb_familia`.`str_descripcion`,
        `tb_familia`.`str_usuarioCreador`,
        `tb_familia`.`dte_fechaCreacion`,
        `tb_familia`.`str_estado`
    )
VALUES(
    null,
    nombre,
    descripcion,
    usuarioCreador,
    (select now()),
    estado
);





UPDATE
    `bdmatriz`.`tb_familia`
SET
    str_codigoFamilia = concat((SELECT SUBSTRING(str_nombre, 1, 1)), last_insert_id())
WHERE
    int_idFamilia = last_insert_id();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertFlujoCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertFlujoCaja`(
    IN idLocal INT,
    IN idCaja INT,
    IN cantidadSoles DOUBLE,
    IN cantidadDolares DOUBLE,
    IN cantidadTotalSoles DOUBLE,
    IN motivo VARCHAR(45),
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45),
    IN nrodocumento varchar(100),
    IN numeroSerie varchar(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_flujocaja`(
        `tb_flujocaja`.`int_idFlujoCaja`,
        `tb_flujocaja`.`int_idLocal`,
        `tb_flujocaja`.`int_idCaja`,
        `tb_flujocaja`.`dbl_cantidadSoles`,
        `tb_flujocaja`.`dbl_cantidadDolares`,
        `tb_flujocaja`.`dbl_cantidadTotalSoles`,
        `tb_flujocaja`.`dbl_cantidadDiferencia`,
        `tb_flujocaja`.`str_motivo`,
        `tb_flujocaja`.`str_estado`,
        `tb_flujocaja`.`str_usuarioCreador`,
        `tb_flujocaja`.`dte_fechaCreacion`,
        `tb_flujocaja`.`str_nroDocumento`,
        `tb_flujocaja`.`str_numeroSerieImpresora`
        
    )
VALUES(
    NULL,
    idLocal,
    idCaja,
    cantidadSoles,
    cantidadDolares,
    cantidadTotalSoles,
    0,
    motivo,
    estado,
    usuarioCreador,
    (SELECT NOW()),
    nrodocumento,
    numeroSerie
);

update tb_impresora set str_estado = 'ASIGNADO' where str_numeroSerie like numeroSerie;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertFlujoCajaCierre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertFlujoCajaCierre`(
    IN idLocal INT,
    IN idCaja INT,
    IN cantidadSoles DOUBLE,
    IN cantidadDolares DOUBLE,
    IN cantidadTotalSoles DOUBLE,
    IN cantidadDiferencia DOUBLE,
    IN motivo VARCHAR(45),
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN
DECLARE select_numeroSerie varchar(45);
SET select_numeroSerie = (select str_numeroSerieImpresora from tb_flujocaja where str_motivo like 'APERTURACAJA'  and 
DATE (dte_fechaCreacion) = DATE (NOW())  and int_idLocal = idLocal order by int_idFlujoCaja desc limit 1);
INSERT INTO
    `bdmatriz`.`tb_flujocaja`(
        `tb_flujocaja`.`int_idFlujoCaja`,
        `tb_flujocaja`.`int_idLocal`,
        `tb_flujocaja`.`int_idCaja`,
        `tb_flujocaja`.`dbl_cantidadSoles`,
        `tb_flujocaja`.`dbl_cantidadDolares`,
        `tb_flujocaja`.`dbl_cantidadTotalSoles`,
        `tb_flujocaja`.`dbl_cantidadDiferencia`,
        `tb_flujocaja`.`str_motivo`,
        `tb_flujocaja`.`str_estado`,
        `tb_flujocaja`.`str_usuarioCreador`,
        `tb_flujocaja`.`dte_fechaCreacion`
    )
VALUES(
    NULL,
    idLocal,
    idCaja,
    cantidadSoles,
    cantidadDolares,
    cantidadTotalSoles,
    cantidadDiferencia,
    motivo,
    estado,
    usuarioCreador,
    (SELECT NOW())
);
update tb_impresora set str_estado = 'ACTIVO' WHERE str_numeroSerie = select_numeroSerie;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertFuncionUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertFuncionUsuario`(    
    in int_idFunciones int,
    in int_idUsuario int,
    in str_usuarioCreador varchar(45),
 
 
    in estado varchar(45)
)
BEGIN
INSERT INTO `bdmatriz`.`tb_funcionusuario`
(
`id`,
`int_idFunciones`,
`int_idUsuario`,
`dte_fechaCreacion`,
`str_usuarioCreador`,


`str_estado`
)
VALUES
(
null,
int_idFunciones,
int_idUsuario,
(select now()),
str_usuarioCreador,


estado
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertGuiaRemision` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertGuiaRemision`(
    in nroGuia varchar(45),
    in fechaInicioTraslado Date,
    in motivoTraslado varchar(45),
    in domicilioPartida text,
    in domicilioLlegada text,
    in placaMarcaVehiculo varchar(45),
    in inscripcionVehiculo	varchar(45),
    in breveteConductor	varchar(45),
    in destinatarioNombre	varchar(45),
    in destinatarioRuc	varchar(45),
    in destinatarioDireccion	varchar(45),
    in comprobantePago	varchar(45),
    in nroComprobante	varchar(45),
    in estado	varchar(45),
    in usuarioCreador	varchar(45),
    in local varchar(45),
    in rucTransportista varchar(15),
    in nombreTransportista varchar(100)
    
)
BEGIN
INSERT INTO `bdmatriz`.`tb_guiaremision`
(`int_idGuiaremision`,
`str_numeroGuia`,
`dte_fechaEmision`,
`dte_fechaInicioTraslado`,
`str_motivoTraslado`,
`str_domicilioPartida`,
`str_domicilioLlegada`,
`str_placaMarcaVehiculo`,
`str_inscripcionVehiculo`,
`str_breveteConductor`,
`str_destinatarioNombre`,
`str_destinatarioRuc`,
`str_destinatarioDireccion`,
`str_comprobantePago`,
`str_nroComprobante`,
`str_estado`,
`str_usuarioCreador`,
`dte_fechaCreacion`,
`str_localPartida`,
`str_rucTransportista`,
`str_nombreTransportista`
)
VALUES
(
null,
nroGuia,

fechaInicioTraslado,
fechaInicioTraslado,
motivoTraslado,
domicilioPartida,
domicilioLlegada,
placaMarcaVehiculo,
inscripcionVehiculo,
breveteConductor,
destinatarioNombre,
destinatarioRuc,
destinatarioDireccion,
comprobantePago,
nroComprobante,
estado,
usuarioCreador,
now(),
local,
rucTransportista,
nombreTransportista

);
update `bdmatriz`.`tb_guiaremision` set `str_localLlegada`=
subString_index(subString_index(tb_guiaremision.`str_domicilioLlegada`,'-.-',2),'-.-',-1)
where `int_idGuiaremision`=last_insert_id();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertHorarioJornada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertHorarioJornada`(
    IN idHorario int,
    IN idJornada int,
    IN str_estado varchar(45),
    IN usuarioCreador varchar(45),
    IN usuarioModificador varchar(45)  
    
)
BEGIN
    INSERT INTO `bdmatriz`.`tb_horariojornada`
(`int_idHorario`,
`int_idJornada`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`str_usuarioModificador`)
VALUES
(
idHorario,
idJornada,
str_estado,
(select now()),
usuarioCreador,
usuarioModificador
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertHorarioJornadaContratol` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertHorarioJornadaContratol`(
    IN idHorario int,
    IN idJornada int,
    IN idContrato int,
    IN estado varchar(45),    
    IN usuarioCreador varchar(45)
    
    
    
    
    
)
BEGIN
INSERT INTO `bdmatriz`.`tb_horariojornadacontrato`
(`int_idHorario`,
`int_idJornada`,
`int_idContrato`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`



)
VALUES
(
idHorario,
idJornada,
idContrato,
estado,
(select now()),
usuarioCreador



);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertJornada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertJornada`(
    
    IN HoraInicio time,
    IN horaFin time,
    IN estado varchar(45),
    IN usuarioCreador varchar(45)
    
)
BEGIN
INSERT INTO `bdmatriz`.`tb_jornada`
(
`tme_HoraInicio`,
`tme_horaFin`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`)
VALUES
(
HoraInicio,
horaFin,
estado,
(select now()),
usuarioCreador
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertJustificacionEInasistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertJustificacionEInasistencia`(
    IN estado varchar(45),
    IN UsuarioCreador varchar(45),
    IN asistencia int,
    IN observacion varchar(100)
)
BEGIN

INSERT INTO `bdmatriz`.`tb_justificacioneinasistencia` (
    `str_estado`,
    `str_UsuarioCreador`,
    `dte_fechaCreacion`,
    `int_asistencia`,
    `str_observacion`
)

VALUES (
    estado,
    UsuarioCreador,
    (select now()),
    asistencia,
    observacion
);

UPDATE tb_asistencia set str_tipoMarcado = 'J'
WHERE int_asistencia = asistencia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertKardex` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertKardex`(
    
    in idAlmacen int,
    in idProducto int,
    in cantidad double,
    in stock double

)
BEGIN
INSERT INTO `bdmatriz`.`tb_kardex`
(`int_idKardex`,
`int_idAlmacen`,
`int_idProducto`,
`dbl_cantidad`,
`dbl_stock`)
VALUES
(
null,
idAlmacen,
idProducto,
cantidad,
stock
);



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertLogeo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertLogeo`(
in usuario varchar(45),
in estado varchar(45)
)
BEGIN
INSERT INTO `bdmatriz`.`tb_logeo`
(`int_idLogeo`,
`str_usuario`,
`dte_fecha`,
`str_estado`)
VALUES
(
null,
usuario,
(now()),
estado
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertMemorandum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertMemorandum`(
   in int_idPersona int,
   in str_numero varchar(20),
   in str_emisor varchar(45),
   in str_receptor varchar(45),
   in str_asunto text,
   in dte_fecha date,
   in str_cuerpo text,
   in str_usuarioCreador varchar(45)
   
       
)
BEGIN
INSERT INTO `bdmatriz`.`tb_memorandum`
(`str_numero`,
`str_emisor`,
`str_receptor`,
`str_asunto`,
`dte_fecha`,
`str_cuerpo`,
`str_usuarioCreador`,
`dte_fechaCreacion`,
`int_idPersona`,
`str_estado`
)
VALUES
(
str_numero,
str_emisor,
str_receptor,
str_asunto,
dte_fecha,
str_cuerpo,
str_usuarioCreador,
(select now()),
int_idPersona,
'ACTIVO'
);
update `bdmatriz`.`tb_memorandum` 
set `str_numero`= concat(year(dte_fecha),' - ',LAST_INSERT_ID()) 
where `int_idMemorandum` =LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertObligacionesPago` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertObligacionesPago`(
    IN idFacturaCompra INT,
    IN idTipoObligacion INT,
    IN montoTotal DOUBLE,
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_obligacionespago`(
        `tb_obligacionespago`.`int_idObligacionesPago`,
        `tb_obligacionespago`.`int_idFacturaCompra`,
        `tb_obligacionespago`.`int_idTipoObligacion`,
        `tb_obligacionespago`.`dbl_montoTotal`,
        `tb_obligacionespago`.`str_estado`,
        `tb_obligacionespago`.`str_usuarioCreador`,
        `tb_obligacionespago`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    idFacturaCompra,
    idTipoObligacion,
    montoTotal,
    estado,
    usuarioCreador,
    (SELECT NOW())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertOrdenCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertOrdenCompra`(
    IN idProveedor int,
    IN numeroOC varchar(45),
    IN idTransportista int,
    IN idAlmacen int,
    IN viaTransporte varchar(45),
    IN idTipoObligacion INT,
    IN precioBruto double,
    IN precioTotal double,
    IN descuentoTotal double,
    IN valorVenta double,
    IN igv double,
    IN igvRecuperado double,
    IN peso double,
    IN fechaEntrega varchar(45),
    IN fechaValidez varchar(45),
    IN operacion VARCHAR(45),
    IN estado varchar(45),
    IN usuarioCreador varchar(45)
)
BEGIN

INSERT INTO `bdmatriz`.`tb_ordencompra` (
    `tb_ordencompra`.`int_idOrdenCompra`,
    `tb_ordencompra`.`int_idProveedor`,
    `tb_ordencompra`.`str_numeroOC`,
    `tb_ordencompra`.`int_idTransportista`,
    `tb_ordencompra`.`int_idAlmacen`,
    `tb_ordencompra`.`str_viaTransporte`,
    `tb_ordencompra`.`int_idTipoObligacion`,
    `tb_ordencompra`.`dbl_precioBruto`,
    `tb_ordencompra`.`dbl_precioTotal`,
    `tb_ordencompra`.`dbl_descuentoTotal`,
    `tb_ordencompra`.`dbl_valorVenta`,
    `tb_ordencompra`.`dbl_igv`,
    `tb_ordencompra`.`dbl_igvRecuperado`,
    `tb_ordencompra`.`dbl_peso`,
    `tb_ordencompra`.`str_fechaEntrega`,
    `tb_ordencompra`.`str_fechaValidez`,
    `tb_ordencompra`.`str_operacion`,
    `tb_ordencompra`.`str_estado`,
    `tb_ordencompra`.`str_usuarioCreador`,
    `tb_ordencompra`.`str_fechaCreacion`
)
VALUES (
    null,
    idProveedor,
    numeroOC,
    idTransportista,
    idAlmacen,
    viaTransporte,
    idTipoObligacion,
    precioBruto,
    precioTotal,
    descuentoTotal,
    valorVenta,
    igv,
    igvRecuperado,
    peso,
    fechaEntrega,
    fechaValidez,
    operacion,
    estado,
    usuarioCreador,
    (select now())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertPersonal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertPersonal`(
    IN paterno varchar(45),
    IN materno varchar(45),
    IN nombres varchar(45),
    IN dni varchar(8),
    IN carnetEstranjeria varchar(15),
    IN fechaNacimiento Date,
    IN ciudadNacimiento varchar(45),
    IN telefono varchar(10),
    IN movil varchar(9),
    IN sexo char(1),
    IN nacionalidad varchar(45),
    IN correoElectronico varchar(45),
    IN brevete char(1),
    IN categoriaBrevete varchar(45),
    IN estadoCivil varchar(15),
    IN direccion varchar(150),
    IN distrito varchar(150),
    IN provincia varchar(150),
    IN departamento varchar(150),
    IN huellaDigital_1 BLOB,
    IN huellaDigital_2 BLOB,
    IN estado varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion Date,
    IN usuarioModificador varchar(45),
    IN foto LONGBLOB
    
)
BEGIN
    INSERT INTO tb_persona
(
`int_idPersona`,
`str_apePaterno`,
`str_apeMaterno`,
`str_nombres`,
`str_dni`,
`str_carnetExtranjeria`,
`dte_fechaNacimiento`,
`str_ciudadNacimiento`,
`str_telefono`,
`str_movil`,
`str_sexo`,
`str_nacionalidad`,
`str_correoElectronico`,
`str_brevete`,
`str_categoriaBrevete`,
`str_estadoCivil`,
`str_direccion`,
`str_distrito`,
`str_provincia`,
`str_departamento`,
`bin_huellaDigital_1`,
`bin_huellaDigital_2`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_ultimaModificacion`,
`str_usuarioModificador`,
`blob_foto`)

VALUES
(
null,
paterno,
materno,
nombres,
dni,
carnetEstranjeria,
fechaNacimiento,
ciudadNacimiento,
telefono,
movil,
sexo,
nacionalidad,
correoElectronico,
brevete,
categoriaBrevete,
estadoCivil,
direccion,
distrito,
provincia,
departamento,
huellaDigital_1,
huellaDigital_2,
estado,
(select now()),
usuarioCreador,
ultimaModificacion,
usuarioModificador,
foto

);
update tb_persona set str_codigo=concat((select SUBSTRING(str_nombres,1,1)),last_insert_id()) 
where int_idPersona=last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertPPOCFC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertPPOCFC`(
    IN idProveedor INT,
    IN idProducto INT,
    IN idOrdenCompra INT,
    IN idFacturaCompra INT,
    IN idLocalRecibido INT,
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_proveedorproductoordencomprafacturacompra`(
        `tb_proveedorproductoordencomprafacturacompra`.`int_idProveedor`,
        `tb_proveedorproductoordencomprafacturacompra`.`int_idProducto`,
        `tb_proveedorproductoordencomprafacturacompra`.`int_idOrdenCompra`,
        `tb_proveedorproductoordencomprafacturacompra`.`int_idFacturaCompra`,
        `tb_proveedorproductoordencomprafacturacompra`.`int_idLocalRecibido`,
        `tb_proveedorproductoordencomprafacturacompra`.`str_estado`,
        `tb_proveedorproductoordencomprafacturacompra`.`str_usuarioCreador`,
        `tb_proveedorproductoordencomprafacturacompra`.`str_fechaCreacion`
    )
VALUES(
    idProveedor,
    idProducto,
    idOrdenCompra,
    idFacturaCompra,
    idLocalRecibido,
    estado,
    usuarioCreador,
    (SELECT NOW())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertPPUM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertPPUM`(
    IN idProveedor INT,
    IN idProducto INT,
    IN idUnidadMedidaVenta INT,
    IN UnidadMedidaCompra VARCHAR(45),
    IN costoCompra DOUBLE,
    IN unidadesContenidas DOUBLE,
    IN precioUnidadContenida DOUBLE,
    IN costoTraslado DOUBLE,
    IN precioFinal DOUBLE,
    IN precioOferta DOUBLE,
    IN estado VARCHAR(45),
    IN usuarioCreador varchar(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_proveedorproductounidadmedida`(
        `tb_proveedorproductounidadmedida`.`int_idProveedor`,
        `tb_proveedorproductounidadmedida`.`int_idProducto`,
        `tb_proveedorproductounidadmedida`.`int_idUnidadMedidaVenta`,
        `tb_proveedorproductounidadmedida`.`str_UnidadMedidaCompra`,
        `tb_proveedorproductounidadmedida`.`dbl_costoCompra`,
        `tb_proveedorproductounidadmedida`.`dbl_unidadesContenidas`,
        `tb_proveedorproductounidadmedida`.`dbl_precioUnidadContenida`,
        `tb_proveedorproductounidadmedida`.`dbl_costoTraslado`,
        `tb_proveedorproductounidadmedida`.`dbl_precioFinal`,
        `tb_proveedorproductounidadmedida`.`dbl_precioOferta`,
        `tb_proveedorproductounidadmedida`.`str_estado`,
        `tb_proveedorproductounidadmedida`.`str_usuarioCreador`,
        `tb_proveedorproductounidadmedida`.`str_fechaCreacion`
    )
VALUES(
    idProveedor,
    idProducto,
    idUnidadMedidaVenta,
    UnidadMedidaCompra,
    costoCompra,
    unidadesContenidas,
    precioUnidadContenida,
    costoTraslado,
    precioFinal,
    precioOferta,
    estado,
    usuarioCreador,
    (SELECT NOW())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertProducto`(
    IN nombreProducto varchar(100),
    IN descripcion varchar(200),
    IN fabricante varchar(45),
    IN reintegroTributario varchar(45),
    IN idFamilia int,
    IN idUnidadMedida int,
    IN idMedidaRotacion int,
    IN usuarioCreador varchar(45),
    IN estado varchar(45)
)
BEGIN

INSERT INTO tb_producto (
    int_idProducto,
    str_nombreProducto,
    str_descripcion,
    str_fabricante,
    str_reintegroTributario,
    int_idFamilia,
    int_idUnidadMedida,
    int_idMedidaRotacion,
    str_usuarioCreador,
    dte_fechaCreacion,
    str_estado
)
VALUES (
    null,
    nombreProducto,
    descripcion,
    fabricante,
    reintegroTributario,
    idFamilia,
    idUnidadMedida,
    idMedidaRotacion,
    usuarioCreador,
    (select now()),
    estado
);





UPDATE
    `bdmatriz`.`tb_producto`
SET
    str_codigoInterno = 
concat((select str_codigoFamilia from tb_familia where int_idFamilia = idFamilia and str_estado = 'ACTIVO'),
(SELECT SUBSTRING(str_nombreProducto, 1, 1)), last_insert_id())
WHERE
    int_idProducto = last_insert_id();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertProductoCodigo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertProductoCodigo`(
    IN codigo VARCHAR(45),
    IN nombreProducto varchar(100),
    IN descripcion varchar(200),
    IN fabricante varchar(45),
    IN reintegroTributario varchar(45),
    IN idFamilia int,
    IN idUnidadMedida int,
    IN idMedidaRotacion int,
    IN usuarioCreador varchar(45),
    IN estado varchar(45)
)
BEGIN

INSERT INTO tb_producto (
    int_idProducto,
    str_codigoInterno,
    str_nombreProducto,
    str_descripcion,
    str_fabricante,
    str_reintegroTributario,
    int_idFamilia,
    int_idUnidadMedida,
    int_idMedidaRotacion,
    str_usuarioCreador,
    dte_fechaCreacion,
    str_estado
)
VALUES (
    null,
    codigo,
    nombreProducto,
    descripcion,
    fabricante,
    reintegroTributario,
    idFamilia,
    idUnidadMedida,
    idMedidaRotacion,
    usuarioCreador,
    (select now()),
    estado
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertProductoHistorial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertProductoHistorial`(
    IN idProveedor INT,
    IN idProducto INT,
    IN precio DOUBLE,
    IN descuento DOUBLE,
    IN peso DOUBLE,
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_productohistorial`
SET
    `tb_productohistorial`.`str_estado` = 'INACTIVO',
    `tb_productohistorial`.`str_usuarioModificador` = usuarioCreador,
    `tb_productohistorial`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_productohistorial`.`int_idProveedor` = idProveedor
    AND `tb_productohistorial`.`int_idProducto` = idProducto;





INSERT INTO
    `bdmatriz`.`tb_productohistorial`(
        `tb_productohistorial`.`int_idProductoHistorial`,
        `tb_productohistorial`.`int_idProveedor`,
        `tb_productohistorial`.`int_idProducto`,
        `tb_productohistorial`.`dbl_precio`,
        `tb_productohistorial`.`dbl_descuento`,
        `tb_productohistorial`.`dbl_peso`,
        `tb_productohistorial`.`str_estado`,
        `tb_productohistorial`.`str_usuarioCreador`,
        `tb_productohistorial`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    idProveedor,
    idProducto,
    precio,
    descuento,
    peso,
    estado,
    usuarioCreador,
    (select now())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertProveedor`(
in str_razonSocial varchar(500),
in str_nombreComercial varchar(200),
in str_ruc varchar(15),
in str_direccion varchar(200),
in str_email varchar(150),
in str_telefono varchar(45),
in str_fax varchar(45),
in str_representanteLegal varchar(150),
in str_banco varchar(45),
in str_ctaPrincipal varchar(45),
in str_ctaAlternativa varchar(45),
in str_usuarioCreador varchar(45)

)
BEGIN
INSERT INTO `bdmatriz`.`tb_proveedor`
(`int_idProveedor`,
`str_razonSocial`,
`str_nombreComercial`,
`str_ruc`,
`str_direccion`,
`str_email`,
`str_telefono`,
`str_fax`,
`str_representanteLegal`,
`str_banco`,
`str_ctaPrincipal`,
`str_ctaAlternativa`,
`str_estado`,
`str_usuarioCreador`,
`dte_fechaCreacion`)
VALUES
(null,
str_razonSocial,
str_nombreComercial,
str_ruc ,
str_direccion,
str_email,
str_telefono,
str_fax,
str_representanteLegal,
str_banco,
str_ctaPrincipal,
str_ctaAlternativa,
'ACTIVO',
str_usuarioCreador,
(now())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertProveedorProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertProveedorProducto`(
    in idProveedor int,
    in idProducto int,
    in usuarioCreador varchar(45),
    in estado varchar(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_proveedorproducto`(
        `int_idProveedor`,
        `int_idProducto`,
        `str_usuarioCreador`,
        `dte_fechaCreacion`,
        `str_estado`
    )
VALUES(
    idProveedor,
    idProducto,
    usuarioCreador,
    (SELECT now()),
    estado
);





INSERT INTO
    `bdmatriz`.`tb_productohistorial`(
        `int_idProductoHistorial`,
        `int_idProveedor`,
        `int_idProducto`,
        `dbl_precio`,
        `dbl_descuento`,
        `dbl_peso`,
        `str_estado`,
        `str_usuarioCreador`,
        `str_fechaCreacion`
    )
VALUES(
    NULL,
    idProveedor,
    idProducto,
    0,
    0,
    0,
    estado,
    usuarioCreador,
    (SELECT now())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertProveedorProductoOrdenCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertProveedorProductoOrdenCompra`(
    IN idProveedor int,
    IN idProducto int,
    IN idOrdenCompra int,
    IN cantidad DOUBLE,
    IN precio double,
    IN descuento DOUBLE,
    IN peso DOUBLE,
    IN estado varchar(45),
    IN usuarioCreador varchar(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_proveedorproductoordencompra`(
        `tb_proveedorproductoordencompra`.`int_idProveedor`,
        `tb_proveedorproductoordencompra`.`int_idProducto`,
        `tb_proveedorproductoordencompra`.`int_idOrdenCompra`,
        `tb_proveedorproductoordencompra`.`dbl_cantidad`,
        `tb_proveedorproductoordencompra`.`dbl_precio`,
        `tb_proveedorproductoordencompra`.`dbl_descuento`,
        `tb_proveedorproductoordencompra`.`dbl_peso`,
        `tb_proveedorproductoordencompra`.`str_estado`,
        `tb_proveedorproductoordencompra`.`str_usuarioCreador`,
        `tb_proveedorproductoordencompra`.`str_fechaCreacion`
    )
VALUES(
    idProveedor,
    idProducto,
    idOrdenCompra,
    cantidad,
    precio,
    descuento,
    peso,
    estado,
    usuarioCreador,
    (select now())
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertRefrigerio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertRefrigerio`(
in estado varchar(45),
in asistencia int
)
BEGIN
INSERT INTO tb_refrigerio
(id_refrigerio,
dt_horaSalida,
str_estado,
int_asistencia)
VALUES
(
null,
(now()),
estado,
asistencia
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertTipoCambio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertTipoCambio`(
    IN precioCompraDolar DOUBLE,
    IN precioVentaDolar DOUBLE,
    IN fechaDia VARCHAR(45),
    IN estado VARCHAR(45),
    IN usuarioCreador VARCHAR(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_tipocambio`(
        `tb_tipocambio`.`int_idTipoCambio`,
        `tb_tipocambio`.`dbl_precioCompraDolar`,
        `tb_tipocambio`.`dbl_precioVentaDolar`,
        `tb_tipocambio`.`str_fechaDia`,
        `tb_tipocambio`.`str_estado`,
        `tb_tipocambio`.`str_usuarioCreador`,
        `tb_tipocambio`.`str_fechaCreacion`
    )
VALUES(
    NULL,
    precioCompraDolar,
    precioVentaDolar,
    fechaDia,
    estado,
    usuarioCreador,
    (SELECT NOW())
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertTraspasoMercaderia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertTraspasoMercaderia`(
    in idGuia int,
    in codAutoriza varchar(45),        
    in estado varchar(45),
    in usuarioCreador varchar(45)
    
)
BEGIN
INSERT INTO `bdmatriz`.`tb_traspasointerno`
(`int_idTraspasointerno`,
`int_idGuiaRemision`,
`str_codigoAutoriza`,
`dte_fechaAutoriza`,
`str_estado`,
`str_usuarioCreador`,
`dte_fechaCreacion`
)
VALUES
(
null,
idGuia,
codAutoriza,
now(),
estado,
usuarioCreador,
now()
);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertUnidadMedida` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_insertUnidadMedida`(
    in nombre varchar(45),
    in descripcion varchar(45),
    in usuarioCreador varchar(45),
    in estado varchar(45)
)
BEGIN

INSERT INTO
    `bdmatriz`.`tb_unidadmedida`(
        `tb_unidadmedida`.`int_idUnidadMedida`,
        `tb_unidadmedida`.`str_nombreUM`,
        `tb_unidadmedida`.`str_descripcionUM`,
        `tb_unidadmedida`.`str_usuarioCreador`,
        `tb_unidadmedida`.`dte_fechaCreacion`,
        `tb_unidadmedida`.`str_estado`
    )
VALUES(
    null,
    nombre,
    descripcion,
    usuarioCreador,
    (select now()),
    estado
);





UPDATE
    `bdmatriz`.`tb_unidadmedida`
SET
    `tb_unidadmedida`.`str_codigoUM` = concat((SELECT SUBSTRING(str_nombreUM, 1, 1)), last_insert_id())
WHERE
    `tb_unidadmedida`.`int_idUnidadMedida` = last_insert_id();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertUsuario`(    
    in int_idPersona int,
    in str_usuario varchar(45),
    in str_contrasenia varchar(45),
    in str_estado varchar(45),
    in str_usuarioCreador varchar(45),
    in dte_fechaModificacion date,
    in str_usuarioModificador varchar(45) ,
    in codigoPersona varchar(45)
)
BEGIN

INSERT INTO `bdmatriz`.`tb_usuario`
(
`int_idPersona`,
`str_usuario`,
`str_contrasenia`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModificador`,
`str_codigoPersona`)
VALUES
(
int_idPersona,
str_usuario,
str_contrasenia,
str_estado,
(select now()),
str_usuarioCreador,
dte_fechaModificacion,
str_usuarioModificador,
codigoPersona
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertVenta`(
in proveedor int,
in producto int,
in cliente int,
in cantidad double,
in precio double,
in subtotal double,
in descuento double,
in igv double,
in total double,
in nro_documento varchar(100),
in usuario varchar(45),
in estado varchar(45),
in clienteResponsable varchar(100),
in idLocal int,
in unidadesConenidas double



)
BEGIN
insert into tb_venta(
  int_idVenta,
  int_idProveedor,
  int_idProducto,
  int_idCliente,
  dbl_cantidad,
  dbl_precio,
  dbl_subtotal,
  dbl_descuento,
  dbl_igv,
  dbl_total,
  str_numeroDocumento,
  str_usuario,
  str_estado,
  str_clienteResponsable,
  int_local,
  str_fechaRegistro,
  dbl_unidadesContenidas

)
values(
null,
proveedor,
producto,
cliente,
cantidad,
precio,
subtotal,
descuento,
igv,
total,
nro_documento,
usuario,
estado,
clienteResponsable,
idLocal,
now(),
unidadesConenidas

);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaAsistenciasProgramadas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaAsistenciasProgramadas`(
IN estado varchar(45)
)
BEGIN
SET lc_time_names = 'es_PE';
select
p.int_idPersona,
concat(str_nombres,' ',str_apePaterno,' ',str_apeMaterno) as 'Nombre',
e.int_idEmpresa,
e.str_razonSocial,
e.str_ruc,
c.int_idContrato,
c.dte_fechaInicial,
c.dte_fechaFinal,













h.int_idHorario,
h.str_nombreHorario,
h.str_estado,




j.int_idJornada,
j.tme_HoraInicio,
j.tme_horaFin,
j.str_estado,




hj.int_idHorario,
hj.int_idJornada,
hj.str_estado


from  tb_horariojornadacontrato hcj ,  tb_horariojornada hj , tb_horario h , tb_jornada j, tb_contrato c , tb_empresa e, tb_persona p
where hcj.int_idHorario=hj.int_idHorario
and   hcj.int_idJornada=hj.int_idJornada
and   hcj.strEstado='ACTIVO'
and   hj.int_idHorario=h.int_idHorario and hj.int_idJornada= j.int_idJornada
and   c.int_idContrato=hcj.int_idContrato
and   e.int_idEmpresa=c.int_idEmpresa 
and   c.int_idPersona=p.int_idPersona

and   c.str_estado=estado

and   h.str_nombreHorario=dayname(now())
and   time(now()) between time(j.tme_HoraInicio+1000) and  time(j.tme_horaFin)
 order by p.int_idPersona ASC,tme_HoraInicio ASC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaDepartamentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaDepartamentos`()
BEGIN

SELECT
CodDpto,
CodProv,
CodDist,
Nombre
from tb_ubigeo
where CodProv ='00' and CodDist='00';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaDistritos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaDistritos`(
IN departamento varchar(2),
IN provincia varchar(2)
)
BEGIN

select
CodDpto,
CodProv,
CodDist,
Nombre
from tb_ubigeo
where CodDpto=departamento and CodProv=provincia  and CodDist<>'00';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaEmpresa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaEmpresa`(    
)
BEGIN
SELECT
`tb_empresa`.`int_idEmpresa`,
`tb_empresa`.`str_razonSocial`,
`tb_empresa`.`str_ruc`,
`tb_empresa`.`str_domicilioEmpresa`,
`tb_empresa`.`str_representanteLegal`,
`tb_empresa`.`str_dniRepresentante`,
`tb_empresa`.`str_estado`,
`tb_empresa`.`dte_fechaCreacion`,
`tb_empresa`.`str_usuarioCreador`,
`tb_empresa`.`dte_fechaModificacion`,
`tb_empresa`.`str_usuarioModificador`
FROM `bdmatriz`.`tb_empresa`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaFunciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaFunciones`()
BEGIN
select
int_idFunciones, 
str_rol,
dte_fechaCreacion,
str_usuarioCreador, 
dte_ultimaModificacion,
str_usuarioModificador,
int_modulo,
str_key
from tb_funciones ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaFuncionesXModulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaFuncionesXModulo`(
IN modulo int
)
BEGIN
select
int_idFunciones, 
str_rol,
dte_fechaCreacion,
str_usuarioCreador, 
dte_ultimaModificacion,
str_usuarioModificador,
int_modulo,
str_key
from tb_funciones
where int_modulo=modulo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listafuncionesXUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listafuncionesXUsuario`(
IN usuario INT,
IN estado VARCHAR(45)
)
BEGIN

select
u.int_idUsuario,
u.int_idPersona,
u.str_usuario,
f.int_idFunciones,
f.str_rol,
f.int_modulo,
f.str_key
from tb_usuario u, tb_funcionusuario fu, tb_funciones f
where u.int_idUsuario=fu.int_idUsuario and fu.int_idFunciones=f.int_idFunciones and
      u.int_idUsuario=usuario and u.str_estado=estado and fu.str_estado=estado;
      
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaHorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaHorario`(    
)
BEGIN
SELECT
`tb_horario`.`int_idHorario`,
`tb_horario`.`str_nombreHorario`,
`tb_horario`.`str_estado`,
`tb_horario`.`dte_fechaCreacion`,
`tb_horario`.`str_usuarioCreador`,
`tb_horario`.`dte_fechaModificacion`,
`tb_horario`.`str_usuarioModifcador`
FROM `bdmatriz`.`tb_horario`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaHuellas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaHuellas`(
IN estado varchar(45)
)
BEGIN
select 
int_Idpersona,
concat(str_nombres, ' ', str_apePaterno,' ', str_apeMaterno) as 'Nombre',
bin_huellaDigital_1,
bin_huellaDigital_2,
str_codigo

from tb_persona where bin_huellaDigital_1<>'null' and bin_huellaDigital_2 <> 'null' and str_estado=estado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaJornadas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaJornadas`(    
)
BEGIN
SELECT
`tb_jornada`.`int_idJornada`,
`tb_jornada`.`tme_HoraInicio`,
`tb_jornada`.`tme_horaFin`,
`tb_jornada`.`str_estado`,
`tb_jornada`.`dte_fechaCreacion`,
`tb_jornada`.`str_usuarioCreador`,
`tb_jornada`.`dte_fechaModificacion`,
`tb_jornada`.`str_usuarioModificador`
FROM `bdmatriz`.`tb_jornada`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaJornadasDisponibles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaJornadasDisponibles`(    
    in idHorario int
)
BEGIN
SELECT
j.int_idJornada,
j.tme_HoraInicio,
j.tme_horaFin,
j.str_estado,
j.dte_fechaCreacion,
j.str_usuarioCreador,
j.dte_fechaModificacion,
j.str_usuarioModificador
from tb_jornada j 
where j.int_idJornada not in(select int_idJornada from tb_horariojornada where int_idHorario=idHorario);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaModulos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaModulos`()
BEGIN
select
int_modulo,
str_descripcion
from tb_modulo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaPermisos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaPermisos`(
in fechaInicial DATE,
in fechaFinal DATE

)
BEGIN

SELECT
pers.int_idPersona,
pers.str_codigo,
pers.str_apePaterno,
pers.str_apeMaterno,
pers.str_nombres,
pers.str_dni,
pers.str_estado,

perm.int_idPermisos,
perm.dte_fecha,
perm.str_motivo,
perm.tm_horaSalida,
perm.tm_horaLlegada,
perm.str_observacion,
perm.str_estado,
perm.tm_horaMarcadoSalida,
perm.tm_horaMarcadoLlegada,
perm.dte_fechaRegistro
FROM tb_permisos perm, tb_persona pers
where perm.int_idPersona= substring(pers.str_codigo,2) and
pers.str_estado='ACTIVO' and
(perm.dte_fecha  >= fechaInicial and  perm.dte_fecha <=fechaFinal)
order by perm.str_estado asc ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaPermisosXPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaPermisosXPersona`(
in persona int
)
BEGIN
SELECT
pers.int_idPersona,
pers.str_codigo,
pers.str_apePaterno,
pers.str_apeMaterno,
pers.str_nombres,
pers.str_dni,
pers.str_estado,

perm.int_idPermisos,
perm.dte_fecha,
perm.str_motivo,
perm.tm_horaSalida,
perm.tm_horaLlegada,
perm.str_observacion,
perm.str_estado,
perm.tm_horaMarcadoSalida,
perm.tm_horaMarcadoLlegada,
perm.dte_fechaRegistro
FROM tb_permisos perm, tb_persona pers
where perm.int_idPersona= substring(pers.str_codigo,2) 
and pers.int_idPersona=persona

order by perm.str_estado asc ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaPersonasEmpresa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listaPersonasEmpresa`(
in empresa int,
in estado varchar(45)
)
BEGIN
SELECT
p.int_idPersona,
p.str_codigo,
p.str_apePaterno,
p.str_apeMaterno,
p.str_nombres,
p.str_dni,
p.str_estado
FROM tb_persona p, tb_contrato c, tb_empresa e
where substring(p.str_codigo,2)=c.int_idPersona
and c.int_idEmpresa=e.int_idEmpresa
and e.int_idEmpresa=empresa
and p.str_estado=estado
order by str_nombres asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaProvincias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaProvincias`(
IN departamento varchar(2)
)
BEGIN
select
CodDpto,
CodProv,
CodDist,
Nombre
from tb_ubigeo
where CodDpto=departamento and CodDist='00' and CodProv<>'00';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarCajasDisponibles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarCajasDisponibles`(
    IN idLocal INT,
    IN motivo1 VARCHAR(45),
    IN motivo2 VARCHAR(45)
)
BEGIN

SELECT
    `tb_caja`.`int_idCaja`,
    `tb_caja`.`str_nombre`,
    `tb_caja`.`str_descripcion`,
    `tb_caja`.`str_estado`
FROM
    `bdmatriz`.`tb_caja`
WHERE
    (`tb_caja`.`int_idCaja` NOT IN (
        SELECT `tb_flujocaja`.`int_idCaja`
        FROM `bdmatriz`.`tb_flujocaja`
        WHERE
            `tb_flujocaja`.`str_motivo` = motivo1
            AND DATE (`tb_flujocaja`.`dte_fechaCreacion`) = DATE (NOW())
            AND `tb_flujocaja`.`int_idLocal` = idLocal
        )
    AND `tb_caja`.`int_idCaja` NOT IN (
        SELECT `tb_flujocaja`.`int_idCaja`
        FROM `bdmatriz`.`tb_flujocaja`
        WHERE
            `tb_flujocaja`.`str_motivo` = motivo2
            AND DATE (`tb_flujocaja`.`dte_fechaCreacion`) = DATE(NOW())
            AND `tb_flujocaja`.`int_idLocal` = idLocal
        )
    )
    OR (`tb_caja`.`int_idCaja` IN (
        SELECT `tb_flujocaja`.`int_idCaja`
        FROM `bdmatriz`.`tb_flujocaja`
        WHERE
            `tb_flujocaja`.`str_motivo` = motivo1
            AND DATE (`tb_flujocaja`.`dte_fechaCreacion`) = DATE(NOW())
            AND `tb_flujocaja`.`int_idLocal` = idLocal
        )
    AND `tb_caja`.`int_idCaja` IN (
        SELECT `tb_flujocaja`.`int_idCaja`
        FROM `bdmatriz`.`tb_flujocaja`
        WHERE
            `tb_flujocaja`.`str_motivo` = motivo2
            AND DATE(`tb_flujocaja`.`dte_fechaCreacion`) = DATE(NOW())
            AND `tb_flujocaja`.`int_idLocal` = idLocal
        )
    );

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarCliente`(
    IN razonSocial VARCHAR(100),
    IN rucdni VARCHAR(11),
    IN direccion VARCHAR(200),
    IN telefono VARCHAR(15),
    IN estado VARCHAR(45)
)
BEGIN

SELECT
    `tb_cliente`.`int_idCliente`,
    `tb_cliente`.`str_razonSocial`,
    `tb_cliente`.`str_rucdni`,
    `tb_cliente`.`str_direccion`,
    `tb_cliente`.`str_telefono`,
    `tb_cliente`.`str_estado`
FROM
    `bdmatriz`.`tb_cliente`
WHERE
    `tb_cliente`.`str_razonSocial` LIKE CONCAT('%', razonSocial, '%')
    AND `tb_cliente`.`str_rucdni` LIKE CONCAT('%', rucdni, '%')
    AND `tb_cliente`.`str_direccion` LIKE CONCAT('%', direccion, '%')
    AND `tb_cliente`.`str_telefono` LIKE CONCAT('%', telefono, '%')
    AND `tb_cliente`.`str_estado` = estado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarConfig` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarConfig`()
BEGIN

SELECT
`tb_config`.`int_idConfig`,
`tb_config`.`intMinutosProrrogaAntes`,
`tb_config`.`intMinutosProrrogaDespues`,
`tb_config`.`dblIGV`,
`tb_config`.`dblUIT`,
`tb_config`.`strTipoImpresora`,
`tb_config`.`str_formatoTicket`
FROM `bdmatriz`.`tb_config`;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarContratoXPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarContratoXPersona`(
    IN empresa int,
    IN codigoPersona varchar(10),
    IN estado varchar(20)
)
BEGIN

SELECT

p.int_idPersona,
p.str_codigo,
p.str_apePaterno,
p.str_apeMaterno,
p.str_nombres,
p.str_dni,
p.str_estado,



c.int_idContrato,
c.int_idPersona,
c.int_idTipoContrato,
c.int_idEmpresa,
c.dte_fechaInicial,
c.dte_fechaFinal,
c.dbl_sueldo,
c.str_estado,



tc.int_idTipoContrato,
tc.str_tipoContrato,
tc.str_nombreReporte,
tc.str_estado,




e.int_idEmpresa,
e.str_razonSocial,
e.str_ruc,
e.str_domicilioEmpresa,
e.str_representanteLegal,
e.str_dniRepresentante,




c.str_usuarioCreador


FROM
    tb_contrato c,
    tb_empresa e,
    tb_persona p,
    tb_tipocontrato tc
WHERE
    p.int_idPersona = c.int_idPersona and
    c.int_idTipoContrato = tc.int_idTipoContrato and
    e.int_idEmpresa = c.int_idEmpresa and

    e.int_idEmpresa = empresa and
    p.str_codigo = codigoPersona and
    c.str_estado = estado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarDetalleGuiaAlmacen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarDetalleGuiaAlmacen`(
    in idGuia int
)
BEGIN
SELECT
`tb_detalleguia`.`int_idGuiaremision`,
`tb_detalleguia`.`int_idProducto`,
`tb_detalleguia`.`dbl_cantidadProducto`,
`tb_detalleguia`.`str_descripcionProducto`,
`tb_detalleguia`.`dbl_peso`,
`tb_detalleguia`.`dbl_costoTraslado`,
`tb_detalleguia`.`str_estado`,
`tb_detalleguia`.`str_usuarioCreador`,
`tb_detalleguia`.`dte_fechaCreacion`,
`tb_detalleguia`.`str_usuarioModificador`,
`tb_detalleguia`.`dte_fechaModificacion`,
`tb_detalleguia`.`int_idProveedor`
FROM `bdmatriz`.`tb_detalleguia`
where
`tb_detalleguia`.`int_idGuiaremision`=idGuia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarFamilia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarFamilia`(
    IN codigoFamilia varchar(45),
    IN nombre varchar(45)
)
BEGIN

SELECT
    `tb_familia`.`int_idFamilia`,
    `tb_familia`.`str_codigoFamilia`,
    `tb_familia`.`str_nombre`,
    `tb_familia`.`str_descripcion`,
    `tb_familia`.`str_estado`
FROM
    `bdmatriz`.`tb_familia`
where
    `tb_familia`.`str_codigoFamilia` like codigoFamilia 
    AND `tb_familia`.`str_nombre` like nombre
    AND `tb_familia`.`str_estado` = 'ACTIVO'
ORDER BY
    `tb_familia`.`str_nombre`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarFuncionesXUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarFuncionesXUsuario`(
    IN usuario INT,
    IN estado VARCHAR(45)
)
BEGIN

select
    u.int_idUsuario,
    u.int_idPersona,
    u.str_usuario,
    f.int_idFunciones,
    f.str_rol,
    f.int_modulo,
    f.str_key
from
    tb_usuario u, tb_funcionusuario fu, tb_funciones f
where
    u.int_idUsuario = fu.int_idUsuario
    and fu.int_idFunciones = f.int_idFunciones
    and u.int_idUsuario = usuario
    and u.str_estado = estado
    and fu.str_estado = estado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarGuias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarGuias`(
    in nroGuia varchar(11),
    in estado varchar(45),
    in localPartida varchar(45)
)
BEGIN
SELECT
`tb_guiaremision`.`int_idGuiaremision`,         
`tb_guiaremision`.`str_numeroGuia`,             
`tb_guiaremision`.`dte_fechaEmision`,           
`tb_guiaremision`.`dte_fechaInicioTraslado`,    
`tb_guiaremision`.`str_motivoTraslado`,         
`tb_guiaremision`.`str_domicilioPartida`,       
`tb_guiaremision`.`str_domicilioLlegada`,       
`tb_guiaremision`.`str_placaMarcaVehiculo`,     
`tb_guiaremision`.`str_inscripcionVehiculo`,    
`tb_guiaremision`.`str_breveteConductor`,       
`tb_guiaremision`.`str_destinatarioNombre`,     
`tb_guiaremision`.`str_destinatarioRuc`,        
`tb_guiaremision`.`str_destinatarioDireccion`,  
`tb_guiaremision`.`str_comprobantePago`,        
`tb_guiaremision`.`str_nroComprobante`,         
`tb_guiaremision`.`str_estado`,                 
`tb_guiaremision`.`str_usuarioCreador`,         
`tb_guiaremision`.`dte_fechaCreacion`,          
`tb_guiaremision`.`str_usuarioModificador`,     
`tb_guiaremision`.`dte_fechaModificacion`,      
`tb_guiaremision`.`str_localPartida`            
FROM `bdmatriz`.`tb_guiaremision`
where `tb_guiaremision`.`int_idGuiaremision` like nroGuia
and `tb_guiaremision`.`str_estado` like estado
and `tb_guiaremision`.`str_localPartida` like localPartida
order by `tb_guiaremision`.`int_idGuiaremision` desc;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarHorarioJornada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarHorarioJornada`(
IN estado varchar(45)
)
BEGIN
SELECT
 hj.int_idHorario,
 hj.int_idJornada ,
 hj.str_estado ,
 hj.dte_fechaCreacion ,
 hj.str_usuarioCreador ,
 hj.dte_fechaModificacion ,
 hj.str_usuarioModificador ,

 h.int_idHorario ,
 h.str_nombreHorario ,


 j.int_idJornada ,
 j.tme_HoraInicio ,
 j.tme_horaFin 

FROM  tb_horariojornada  hj inner join  tb_horario  h on
hj.int_idHorario=h.int_idHorario inner join  tb_jornada  j on
hj.int_idJornada=j.int_idJornada
where hj.str_estado=estado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarKardex` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarKardex`(
    in idProducto varchar(11) 
)
BEGIN
SELECT int_idAlmacen, int_idProducto, dbl_cantidad 
FROM bdmatriz.tb_almacen
where int_idProducto like idProducto and str_estado='ACTIVO';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarKardexStock` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarKardexStock`(
    in idProducto varchar(11)
)
BEGIN
SELECT
`tb_kardex`.`int_idKardex`,
`tb_kardex`.`int_idAlmacen`,
`tb_kardex`.`int_idProducto`,
`tb_kardex`.`dbl_cantidad`,
`tb_kardex`.`dbl_stock`
FROM `bdmatriz`.`tb_kardex`
where `tb_kardex`.`int_idProducto` like idProducto;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarLocalesAlmacen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarLocalesAlmacen`(
    in idEmpresa varchar(11),
    in nombre varchar(45),
    in estado varchar(45)
)
BEGIN
SELECT
    `tb_locales`.`int_idLocal`,
    `tb_locales`.`str_nombre`,
    `tb_locales`.`str_direccion`,
    `tb_locales`.`str_estado`,
    `tb_locales`.`str_telefono`,

    `tb_empresa`.`int_idEmpresa`,
    `tb_empresa`.`str_razonSocial`,
    `tb_empresa`.`str_ruc`,
    `tb_locales`.`str_distrito`,
    `tb_locales`.`str_provincia`,
    `tb_locales`.`str_departamento`,
    `tb_locales`.`str_codLocalGuia`


    
FROM 
    `tb_locales` inner join `tb_empresa` on 
    `tb_locales`.`int_idEmpresa` = `tb_empresa`.`int_idEmpresa`
where
    `tb_locales`.`int_idEmpresa` like idEmpresa and
    `tb_locales`.`str_estado` = estado
    and `tb_locales`.`str_nombre`= nombre;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarMedidaRotacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarMedidaRotacion`(
    IN estado VARCHAR(45)
)
BEGIN

SELECT
    `tb_medidarotacion`.`int_idMedidaRotacion`,
    `tb_medidarotacion`.`str_codigoMR`,
    `tb_medidarotacion`.`str_nombreMR`,
    `tb_medidarotacion`.`dbl_utilidad`,
    `tb_medidarotacion`.`dbl_adicional`,
    `tb_medidarotacion`.`str_descripcionMR`,
    `tb_medidarotacion`.`str_estadoMR`
FROM
    `bdmatriz`.`tb_medidarotacion`
WHERE
    `tb_medidarotacion`.`str_estadoMR` = estado
ORDER BY
    `tb_medidarotacion`.`str_nombreMR`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarOrdenCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarOrdenCompra`(
    IN numeroOC VARCHAR(45),
    IN proveedor VARCHAR(45),
    IN transportista VARCHAR(45),
    IN viaTransporte VARCHAR(45),
    IN TipoObligacion VARCHAR(45)
)
BEGIN

SELECT
    `tb_ordencompra`.`int_idOrdenCompra`, 
    `tb_ordencompra`.`int_idProveedor`, 
    `tb_ordencompra`.`str_numeroOC`, 
    `tb_ordencompra`.`int_idTransportista`, 
    `tb_ordencompra`.`int_idAlmacen`, 
    `tb_ordencompra`.`str_viaTransporte`, 
    `tb_ordencompra`.`int_idTipoObligacion`, 
    `tb_ordencompra`.`dbl_precioBruto`, 
    `tb_ordencompra`.`dbl_precioTotal`, 
    `tb_ordencompra`.`dbl_descuentoTotal`, 
    `tb_ordencompra`.`dbl_valorVenta`, 
    `tb_ordencompra`.`dbl_igv`, 
    `tb_ordencompra`.`dbl_igvRecuperado`, 
    `tb_ordencompra`.`dbl_peso`, 
    `tb_ordencompra`.`str_fechaEntrega`, 
    `tb_ordencompra`.`str_fechaValidez`, 
    `tb_ordencompra`.`str_operacion`, 
    `tb_ordencompra`.`str_estado`, 
    
    `tb_proveedor`.`str_razonSocial`, 
    `tb_proveedor`.`str_ruc`, 
    `tb_proveedor`.`str_direccion`, 
    `tb_proveedor`.`str_telefono`, 

    (SELECT `tb_proveedor`.`str_razonSocial` FROM `bdmatriz`.`tb_proveedor`
    WHERE `tb_proveedor`.`int_idProveedor` = `tb_ordencompra`.`int_idTransportista`), 
    (SELECT `tb_proveedor`.`str_ruc` FROM `bdmatriz`.`tb_proveedor`
    WHERE `tb_proveedor`.`int_idProveedor` = `tb_ordencompra`.`int_idTransportista`), 
    (SELECT `tb_proveedor`.`str_direccion` FROM `bdmatriz`.`tb_proveedor`
    WHERE `tb_proveedor`.`int_idProveedor` = `tb_ordencompra`.`int_idTransportista`), 
    (SELECT `tb_proveedor`.`str_telefono` FROM `bdmatriz`.`tb_proveedor`
    WHERE `tb_proveedor`.`int_idProveedor` = `tb_ordencompra`.`int_idTransportista`), 
    
    `tb_locales`.`str_nombre`, 
    `tb_tipoobligacion`.`str_nombreTO` 
FROM
    `bdmatriz`.`tb_ordencompra` INNER JOIN `bdmatriz`.`tb_proveedor`
    ON `tb_ordencompra`.`int_idProveedor` = `tb_proveedor`.`int_idProveedor`
    
    INNER JOIN `bdmatriz`.`tb_locales`
    ON `tb_ordencompra`.`int_idAlmacen` = `tb_locales`.`int_idLocal`
    
    INNER JOIN `bdmatriz`.`tb_tipoobligacion`
    ON `tb_ordencompra`.`int_idTipoObligacion` = `tb_tipoobligacion`.`int_idTipoObligacion`
WHERE
    `tb_ordencompra`.`str_numeroOC` LIKE CONCAT('%', numeroOC, '%')
    AND `tb_ordencompra`.`int_idProveedor` LIKE CONCAT('%', proveedor, '%')
    AND `tb_ordencompra`.`int_idTransportista` LIKE CONCAT('%', transportista, '%')
    AND `tb_ordencompra`.`str_viaTransporte` LIKE CONCAT('%', viaTransporte, '%')
    AND `tb_ordencompra`.`int_idTipoObligacion` LIKE CONCAT('%', TipoObligacion, '%')
    AND (`tb_ordencompra`.`str_estado` = 'ACTIVO'
    OR `tb_ordencompra`.`str_estado` = 'PENDIENTE'
    OR `tb_ordencompra`.`str_estado` = 'CERRADO')
order by int_idOrdenCompra desc, str_estado asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarOrdenCompraUltimoID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarOrdenCompraUltimoID`()
BEGIN

SELECT
    str_numeroOC
FROM
    tb_ordencompra
ORDER BY
    int_idOrdenCompra desc limit 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarPPOCFCTodos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarPPOCFCTodos`(
    IN idOrdenCompra INT
)
BEGIN

SELECT
    `tb_proveedorproductoordencompra`.`int_idProveedor`, 
    `tb_proveedorproductoordencompra`.`int_idProducto`, 
    `tb_proveedorproductoordencompra`.`int_idOrdenCompra`, 
    `tb_proveedorproductoordencompra`.`dbl_cantidad`, 
    `tb_proveedorproductoordencompra`.`dbl_precio`, 
    `tb_proveedorproductoordencompra`.`dbl_descuento`, 
    `tb_proveedorproductoordencompra`.`dbl_peso`, 
    `tb_proveedorproductoordencompra`.`str_estado`, 
    
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`, 
    
    `tb_proveedorproductoordencomprafacturacompra`.`int_idFacturaCompra`, 
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_cantidadRecibida`, 
    `tb_proveedorproductoordencomprafacturacompra`.`str_numeroFactura`, 
    `tb_proveedorproductoordencomprafacturacompra`.`int_idLocalRecibido`, 
    `tb_proveedorproductoordencomprafacturacompra`.`str_fechaDocumento`, 
    `tb_proveedorproductoordencomprafacturacompra`.`str_estado`, 
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_conformidadOK`, 
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_conformidadFallaProveedor`, 
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_conformidadFallaTransportista`, 
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_conformidadFallaOtro`, 
    `tb_proveedorproductoordencomprafacturacompra`.`str_conformidadObservacion`, 
    `tb_proveedorproductoordencomprafacturacompra`.`str_conformidadEstado` 

   

FROM
    `bdmatriz`.`tb_proveedorproductoordencompra` INNER JOIN `bdmatriz`.`tb_producto`
    ON `tb_proveedorproductoordencompra`.`int_idProducto` = `tb_producto`.`int_idProducto`
    INNER JOIN `bdmatriz`.`tb_proveedorproductoordencomprafacturacompra`
    ON `tb_proveedorproductoordencompra`.`int_idProveedor` = `tb_proveedorproductoordencomprafacturacompra`.`int_idProveedor`
    AND `tb_proveedorproductoordencompra`.`int_idProducto` = `tb_proveedorproductoordencomprafacturacompra`.`int_idProducto`
    AND `tb_proveedorproductoordencompra`.`int_idOrdenCompra` = `tb_proveedorproductoordencomprafacturacompra`.`int_idOrdenCompra`

WHERE
    `tb_proveedorproductoordencompra`.`int_idOrdenCompra` = idOrdenCompra
    AND `tb_proveedorproductoordencompra`.`str_estado` <> 'INACTIVO'
    AND `tb_proveedorproductoordencomprafacturacompra`.`str_estado` <> 'INACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarPPOCTodos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarPPOCTodos`(
    IN idOrdenCompra INT
)
BEGIN

SELECT
    `tb_proveedorproductoordencompra`.`int_idProveedor`, 
    `tb_proveedorproductoordencompra`.`int_idProducto`, 
    `tb_proveedorproductoordencompra`.`int_idOrdenCompra`, 
    `tb_proveedorproductoordencompra`.`dbl_cantidad`, 
    `tb_proveedorproductoordencompra`.`dbl_precio`, 
    `tb_proveedorproductoordencompra`.`dbl_descuento`, 
    `tb_proveedorproductoordencompra`.`dbl_peso`, 
    `tb_proveedorproductoordencompra`.`str_estado`, 
    
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`,     
     `tb_producto`.`int_idUnidadMedida`,
     `tb_unidadmedida`.`str_nombreUM`
FROM
    `bdmatriz`.`tb_proveedorproductoordencompra` INNER JOIN `bdmatriz`.`tb_producto`
    ON `tb_proveedorproductoordencompra`.`int_idProducto` = `tb_producto`.`int_idProducto`
    INNER JOIN `bdmatriz`.`tb_unidadmedida`
    ON `tb_unidadmedida`.`int_idUnidadMedida`=`tb_producto`.`int_idUnidadMedida`
WHERE
    `tb_proveedorproductoordencompra`.`int_idOrdenCompra` = idOrdenCompra
    AND (`tb_proveedorproductoordencompra`.`str_estado` = 'ACTIVO'
    or `tb_proveedorproductoordencompra`.`str_estado` = 'PENDIENTE'
    or `tb_proveedorproductoordencompra`.`str_estado` = 'CERRADO');

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarPPUM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarPPUM`(
    IN estado VARCHAR(45)
)
BEGIN

SELECT
    `tb_proveedorproductounidadmedida`.`int_idProveedor`, 
    `tb_proveedorproductounidadmedida`.`int_idProducto`, 
    `tb_proveedorproductounidadmedida`.`int_idUnidadMedidaVenta`, 
    `tb_proveedorproductounidadmedida`.`str_UnidadMedidaCompra`, 
    `tb_proveedorproductounidadmedida`.`dbl_costoCompra`, 
    `tb_proveedorproductounidadmedida`.`dbl_unidadesContenidas`, 
    `tb_proveedorproductounidadmedida`.`dbl_precioUnidadContenida`, 
    `tb_proveedorproductounidadmedida`.`dbl_costoTraslado`, 
    `tb_proveedorproductounidadmedida`.`dbl_precioFinal`, 
    `tb_proveedorproductounidadmedida`.`str_estado`, 
    
    `tb_proveedor`.`int_idProveedor`, 
    `tb_proveedor`.`str_razonSocial`, 
    `tb_proveedor`.`str_nombreComercial`, 
    `tb_proveedor`.`str_ruc`, 
    `tb_proveedor`.`str_direccion`, 
    `tb_proveedor`.`str_email`, 
    `tb_proveedor`.`str_telefono`, 
    `tb_proveedor`.`str_fax`, 
    `tb_proveedor`.`str_representanteLegal`, 
    `tb_proveedor`.`str_banco`, 
    `tb_proveedor`.`str_ctaPrincipal`, 
    `tb_proveedor`.`str_ctaAlternativa`, 
    `tb_proveedor`.`str_estado`, 
    
    `tb_producto`.`int_idProducto`, 
    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_descripcion`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`, 
    `tb_producto`.`str_estado`, 
    
    `tb_unidadmedida`.`str_codigoUM`, 
    `tb_unidadmedida`.`str_nombreUM`, 
    `tb_unidadmedida`.`str_descripcionUM`, 
    `tb_unidadmedida`.`str_estado`, 
    
    `tb_proveedorproductounidadmedida`.`dbl_precioOferta` 
FROM
    `bdmatriz`.`tb_proveedorproductounidadmedida` INNER JOIN `bdmatriz`.`tb_proveedor`
    ON `tb_proveedorproductounidadmedida`.`int_idProveedor` = `tb_proveedor`.`int_idProveedor`
    
    INNER JOIN `bdmatriz`.`tb_producto`
    ON `tb_proveedorproductounidadmedida`.`int_idProducto` = `tb_producto`.`int_idProducto`
    
    INNER JOIN `bdmatriz`.`tb_unidadmedida`
    ON `tb_proveedorproductounidadmedida`.`int_idUnidadMedidaVenta` = `tb_unidadmedida`.`int_idUnidadMedida`
WHERE
    `tb_proveedorproductounidadmedida`.`str_estado` = estado
ORDER BY
    `tb_producto`.`str_nombreProducto`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarProducto`(
    in str_codigoInter varchar(45),
	in str_nombreProd varchar(100),
    in int_familia varchar(45),
    in str_reintegro varchar(45),
    in int_rotacion varchar(45)
)
BEGIN

SELECT
    `tb_producto`.`int_idProducto`, 
    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_descripcion`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`, 
    `tb_producto`.`str_usuarioCreador`, 
    `tb_producto`.`dte_fechaCreacion`, 
    `tb_producto`.`str_usuarioModificador`, 
    `tb_producto`.`dte_fechaModificacion`, 

    `tb_familia`.`int_idFamilia`, 
    `tb_familia`.`str_nombre`, 
    
    `tb_unidadmedida`.`int_idUnidadMedida`, 
    `tb_unidadmedida`.`str_nombreUM`, 
    
    `tb_medidarotacion`.`int_idMedidaRotacion`, 
    `tb_medidarotacion`.`str_nombreMR` 
FROM
    `bdmatriz`.`tb_producto` inner join `bdmatriz`.`tb_familia`
    on `tb_familia`.`int_idFamilia` = `tb_producto`.`int_idFamilia`
    inner join `bdmatriz`.`tb_unidadmedida`
    on `tb_unidadmedida`.`int_idUnidadMedida` = `tb_producto`.`int_idUnidadMedida`
    inner join `bdmatriz`.`tb_medidarotacion`
    on `tb_medidarotacion`.`int_idMedidaRotacion` = `tb_producto`.`int_idMedidaRotacion`
where
     `tb_producto`.`str_codigoInterno` like concat('%',str_codigoInter,'%')
	AND `tb_producto`.`str_nombreProducto` like concat('%',str_nombreProd,'%')
	
	
	
ORDER BY
    `tb_producto`.`str_nombreProducto`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarProductoAlmacen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarProductoAlmacen`(
    in ipProducto varchar(11)
    
)
BEGIN
select int_idProducto, str_fechaCreacion
from bdmatriz.tb_almacen 
where str_estado='ACTIVO'
group by int_idProducto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarProductoHistorial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarProductoHistorial`(
    IN idProveedor INT,
    IN estado VARCHAR(45)
)
BEGIN

SELECT
    `tb_productohistorial`.`int_idProductoHistorial`,
    `tb_productohistorial`.`int_idProveedor`,
    `tb_productohistorial`.`int_idProducto`,
    `tb_productohistorial`.`dbl_precio`,
    `tb_productohistorial`.`dbl_descuento`,
    `tb_productohistorial`.`dbl_peso`,
    `tb_productohistorial`.`str_estado`
FROM
    `bdmatriz`.`tb_productohistorial`
WHERE
    `tb_productohistorial`.`int_idProveedor` = idProveedor
    AND `tb_productohistorial`.`str_estado` = estado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarProductosAlmacen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarProductosAlmacen`(
    in idLocal int
)
BEGIN
SELECT
`tb_almacen`.`int_idAlmacen`,
`tb_almacen`.`int_idProveedor`,
`tb_almacen`.`int_idProducto`,
`tb_almacen`.`int_idLocal`,
`tb_almacen`.`int_idTipoMovimiento`,
`tb_almacen`.`str_documento`,
sum(`tb_almacen`.`dbl_cantidad`),
`tb_almacen`.`dbl_precio`,
`tb_almacen`.`dbl_igv`,
`tb_almacen`.`dbl_subTotal`,
`tb_almacen`.`dbl_descuento`,
`tb_almacen`.`str_fechaDocumento`,
`tb_almacen`.`str_estado`,
`tb_almacen`.`str_usuarioCreador`,
`tb_almacen`.`str_fechaCreacion`,
`tb_almacen`.`str_usuarioModificador`,
`tb_almacen`.`str_fechaModificacion`

FROM `bdmatriz`.`tb_almacen` 
where `tb_almacen`.`int_idLocal` = idLocal
group by `tb_almacen`.`int_idProducto`;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarProductoXId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarProductoXId`(
    in idProducto int
)
BEGIN

SELECT
    `tb_producto`.`int_idProducto`, 
    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_descripcion`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`, 
    `tb_producto`.`str_usuarioCreador`, 
    `tb_producto`.`dte_fechaCreacion`, 
    `tb_producto`.`str_usuarioModificador`, 
    `tb_producto`.`dte_fechaModificacion`, 

    `tb_familia`.`int_idFamilia`, 
    `tb_familia`.`str_nombre`, 
    
    `tb_unidadmedida`.`int_idUnidadMedida`, 
    `tb_unidadmedida`.`str_nombreUM`, 
    
    `tb_medidarotacion`.`int_idMedidaRotacion`, 
    `tb_medidarotacion`.`str_nombreMR` 
FROM
    `bdmatriz`.`tb_producto` inner join `bdmatriz`.`tb_familia`
    on `tb_familia`.`int_idFamilia` = `tb_producto`.`int_idFamilia`
    inner join `bdmatriz`.`tb_unidadmedida`
    on `tb_unidadmedida`.`int_idUnidadMedida` = `tb_producto`.`int_idUnidadMedida`
    inner join `bdmatriz`.`tb_medidarotacion`
    on `tb_medidarotacion`.`int_idMedidaRotacion` = `tb_producto`.`int_idMedidaRotacion`
where `tb_producto`.`int_idProducto`=idProducto;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarTipoCambio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarTipoCambio`(
    IN estado VARCHAR(45)
)
BEGIN

SELECT
    `tb_tipocambio`.`int_idTipoCambio`,
    `tb_tipocambio`.`dbl_precioCompraDolar`,
    `tb_tipocambio`.`dbl_precioVentaDolar`,
    `tb_tipocambio`.`str_fechaDia`,
    `tb_tipocambio`.`str_estado`
FROM
    `bdmatriz`.`tb_tipocambio`
WHERE
    `tb_tipocambio`.`str_estado` = estado
    ORDER BY str_fechaDia desc
LIMIT 10;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarTipoMovimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarTipoMovimiento`()
BEGIN

SELECT
    `tb_tipomovimiento`.`int_idTipoMovimiento`,
    `tb_tipomovimiento`.`str_descripcion`
FROM
    `bdmatriz`.`tb_tipomovimiento`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarTipoObligacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarTipoObligacion`(
    IN estado VARCHAR(45)
)
BEGIN

SELECT
    `tb_tipoobligacion`.`int_idTipoObligacion`,
    `tb_tipoobligacion`.`str_nombreTO`,
    `tb_tipoobligacion`.`str_estado`
FROM
    `bdmatriz`.`tb_tipoobligacion`
WHERE
    `tb_tipoobligacion`.`str_estado` = estado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarTraspasos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarTraspasos`(
    in codAutoriza varchar(45),
    
    in fchAutoriza varchar(45),
    
    in estado varchar(45),
    in local varchar(45)    
)
BEGIN
SELECT
`tb_traspasointerno`.`int_idTraspasointerno`,
`tb_traspasointerno`.`int_idGuiaRemision`,
`tb_traspasointerno`.`str_codigoAutoriza`,
`tb_traspasointerno`.`str_codigoConfirma`,
`tb_traspasointerno`.`dte_fechaAutoriza`,
`tb_traspasointerno`.`dte_fechaConfirma`,
`tb_traspasointerno`.`str_estado`,
`tb_traspasointerno`.`str_usuarioCreador`,
`tb_traspasointerno`.`dte_fechaCreacion`,
`tb_traspasointerno`.`str_usuarioModifcador`,
`tb_traspasointerno`.`dte_fechaModificacion`,
`tb_guiaremision`.`str_localLlegada`
FROM `bdmatriz`.`tb_traspasointerno` inner join `bdmatriz`.`tb_guiaremision` 
on `tb_traspasointerno`.`int_idGuiaRemision` = `tb_guiaremision`.`int_idGuiaRemision`
where 
`tb_traspasointerno`.`str_codigoAutoriza` like codAutoriza

and `tb_traspasointerno`.`dte_fechaAutoriza` like fchAutoriza

and `tb_traspasointerno`.`str_estado` like estado
and `tb_guiaremision`.`str_localLlegada` like concat(local,' ');

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarUnidadMedida` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarUnidadMedida`(
    IN codigoUM varchar(45),
    IN nombreUM varchar(45)
)
BEGIN

SELECT
    `tb_unidadmedida`.`int_idUnidadMedida`,
    `tb_unidadmedida`.`str_codigoUM`,
    `tb_unidadmedida`.`str_nombreUM`,
    `tb_unidadmedida`.`str_descripcionUM`,
    `tb_unidadmedida`.`str_estado`
FROM
    `bdmatriz`.`tb_unidadmedida`
WHERE
    `tb_unidadmedida`.`str_codigoUM` like codigoUM
    and `tb_unidadmedida`.`str_nombreUM` like nombreUM
    AND `tb_unidadmedida`.`str_estado` = 'ACTIVO'
ORDER BY
    `tb_unidadmedida`.`str_nombreUM`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarVendedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarVendedores`(
    in idEmpresa varchar(15)
)
BEGIN
declare idTipoContrato int;
set idTipoContrato=(select int_idTipoContrato from tb_tipocontrato where str_tipoContrato like 'vendedor');

select 
p.str_codigo	,
p.str_apePaterno,	
p.str_apeMaterno,	
p.str_nombres

from tb_persona p inner join tb_contrato c on  p.int_idPersona=c.int_idPersona
where c.int_idEmpresa like idEmpresa 
and c.int_idTipoContrato=idTipoContrato
and c.str_estado='ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarVenta`(
    IN idLocal VARCHAR(45),
    IN estado VARCHAR(45)
)
BEGIN

SELECT
    `tb_venta`.`int_idVenta`, 
    `tb_venta`.`int_idProveedor`, 
    `tb_venta`.`int_idProducto`, 
    `tb_venta`.`int_idCliente`, 
    `tb_venta`.`dbl_cantidad`, 
    `tb_venta`.`dbl_precio`, 
    SUM(`tb_venta`.`dbl_subTotal`) AS subTotal, 
    SUM(`tb_venta`.`dbl_descuento`) AS descuento, 
    SUM(`tb_venta`.`dbl_igv`) AS igv, 
    SUM(`tb_venta`.`dbl_total`) AS total, 
    `tb_venta`.`str_numeroDocumento`, 
    `tb_venta`.`str_usuario`, 
    `tb_venta`.`str_estado`, 
    `tb_venta`.`str_clienteResponsable`, 
    `tb_venta`.`int_local`, 

    `tb_proveedor`.`str_razonSocial`, 
    `tb_proveedor`.`str_nombreComercial`, 
    
    
    `tb_proveedor`.`str_ruc`, 
    `tb_proveedor`.`str_direccion`, 
    `tb_proveedor`.`str_email`, 
    `tb_proveedor`.`str_telefono`, 
    `tb_proveedor`.`str_fax`, 
    `tb_proveedor`.`str_representanteLegal`, 
    `tb_proveedor`.`str_banco`, 
    `tb_proveedor`.`str_ctaPrincipal`, 
    `tb_proveedor`.`str_ctaAlternativa`, 
    `tb_proveedor`.`str_estado`, 

    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_descripcion`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`, 
    `tb_producto`.`str_estado`, 

    
    `tb_venta`.`str_clienteResponsable`,
    `tb_cliente`.`str_rucdni`, 
    `tb_cliente`.`str_direccion`, 
    `tb_cliente`.`str_telefono`, 
    `tb_cliente`.`str_estado`, 

    `tb_locales`.`str_nombre`, 
    `tb_locales`.`str_direccion`, 
    `tb_locales`.`str_estado`, 
    `tb_locales`.`str_telefono`, 
    `tb_locales`.`str_distrito`, 
    `tb_locales`.`str_provincia`, 
    `tb_locales`.`str_departamento`, 
    `tb_locales`.`str_codLocalGuia`, 
    `tb_venta`.`dbl_unidadesContenidas` 
FROM
    `bdmatriz`.`tb_venta` INNER JOIN `bdmatriz`.`tb_proveedor`
    ON `tb_venta`.`int_idProveedor` = `tb_proveedor`.`int_idProveedor`
    INNER JOIN `bdmatriz`.`tb_producto`
    ON `tb_venta`.`int_idProducto` = `tb_producto`.`int_idProducto`
    INNER JOIN `bdmatriz`.`tb_cliente`
    ON `tb_venta`.`int_idCliente` = `tb_cliente`.`int_idCliente`
    INNER JOIN `bdmatriz`.`tb_locales`
    ON `tb_venta`.`int_local` = `tb_locales`.`int_idLocal`
WHERE
    `tb_venta`.`int_local` LIKE CONCAT('%', idLocal, '%')
    
    AND `tb_venta`.`str_estado` = estado
    AND `tb_venta`.`str_numeroDocumento`LIKE 'TEMP-%'
GROUP BY
    `tb_venta`.`str_numeroDocumento`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarVentaAnular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarVentaAnular`(
    IN numeroDocumento VARCHAR(45)
)
BEGIN

SELECT
    `tb_venta`.`int_idVenta`, 
    `tb_venta`.`int_idProveedor`, 
    `tb_venta`.`int_idProducto`, 
    `tb_venta`.`int_idCliente`, 
    `tb_venta`.`dbl_cantidad`, 
    `tb_venta`.`dbl_precio`, 
    `tb_venta`.`dbl_subTotal`, 
    `tb_venta`.`dbl_descuento`, 
    `tb_venta`.`dbl_igv`, 
    `tb_venta`.`dbl_total`, 
    `tb_venta`.`str_numeroDocumento`, 
    `tb_venta`.`str_usuario`, 
    `tb_venta`.`str_estado`, 
    `tb_venta`.`str_clienteResponsable`, 
    `tb_venta`.`int_local`, 

    `tb_proveedor`.`str_razonSocial`, 
    `tb_proveedor`.`str_nombreComercial`, 
    `tb_proveedor`.`str_ruc`, 
    `tb_proveedor`.`str_direccion`, 
    `tb_proveedor`.`str_email`, 
    `tb_proveedor`.`str_telefono`, 
    `tb_proveedor`.`str_fax`, 
    `tb_proveedor`.`str_representanteLegal`, 
    `tb_proveedor`.`str_banco`, 
    `tb_proveedor`.`str_ctaPrincipal`, 
    `tb_proveedor`.`str_ctaAlternativa`, 
    `tb_proveedor`.`str_estado`, 

    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_descripcion`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`, 
    `tb_producto`.`str_estado`, 

    `tb_cliente`.`str_razonSocial`, 
    `tb_cliente`.`str_rucdni`, 
    `tb_cliente`.`str_direccion`, 
    `tb_cliente`.`str_telefono`, 
    `tb_cliente`.`str_estado`, 

    `tb_locales`.`str_nombre`, 
    `tb_locales`.`str_direccion`, 
    `tb_locales`.`str_estado`, 
    `tb_locales`.`str_telefono`, 
    `tb_locales`.`str_distrito`, 
    `tb_locales`.`str_provincia`, 
    `tb_locales`.`str_departamento`, 
    `tb_locales`.`str_codLocalGuia`, 
    
    `tb_venta`.`dbl_unidadesContenidas` 
FROM
    `bdmatriz`.`tb_venta` INNER JOIN `bdmatriz`.`tb_proveedor`
    ON `tb_venta`.`int_idProveedor` = `tb_proveedor`.`int_idProveedor`
    INNER JOIN `bdmatriz`.`tb_producto`
    ON `tb_venta`.`int_idProducto` = `tb_producto`.`int_idProducto`
    INNER JOIN `bdmatriz`.`tb_cliente`
    ON `tb_venta`.`int_idCliente` = `tb_cliente`.`int_idCliente`
    INNER JOIN `bdmatriz`.`tb_locales`
    ON `tb_venta`.`int_local` = `tb_locales`.`int_idLocal`
WHERE
    `tb_venta`.`str_numeroDocumento` = numeroDocumento
    AND `tb_venta`.`str_estado` = 'PAGADO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listarVentaDetalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_listarVentaDetalle`(
    IN idLocal VARCHAR(45),
    IN estado VARCHAR(45),
    IN numeroDocumento VARCHAR(45)
)
BEGIN

SELECT
    `tb_venta`.`int_idVenta`, 
    `tb_venta`.`int_idProveedor`, 
    `tb_venta`.`int_idProducto`, 
    `tb_venta`.`int_idCliente`, 
    `tb_venta`.`dbl_cantidad`, 
    `tb_venta`.`dbl_precio`, 
    `tb_venta`.`dbl_subTotal`, 
    `tb_venta`.`dbl_descuento`, 
    `tb_venta`.`dbl_igv`, 
    `tb_venta`.`dbl_total`, 
    `tb_venta`.`str_numeroDocumento`, 
    `tb_venta`.`str_usuario`, 
    `tb_venta`.`str_estado`, 
    `tb_venta`.`str_clienteResponsable`, 
    `tb_venta`.`int_local`, 

    `tb_proveedor`.`str_razonSocial`, 
    `tb_proveedor`.`str_nombreComercial`, 
    `tb_proveedor`.`str_ruc`, 
    `tb_proveedor`.`str_direccion`, 
    `tb_proveedor`.`str_email`, 
    `tb_proveedor`.`str_telefono`, 
    `tb_proveedor`.`str_fax`, 
    `tb_proveedor`.`str_representanteLegal`, 
    `tb_proveedor`.`str_banco`, 
    `tb_proveedor`.`str_ctaPrincipal`, 
    `tb_proveedor`.`str_ctaAlternativa`, 
    `tb_proveedor`.`str_estado`, 

    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_descripcion`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`, 
    `tb_producto`.`str_estado`, 

    `tb_cliente`.`str_razonSocial`, 
    `tb_cliente`.`str_rucdni`, 
    `tb_cliente`.`str_direccion`, 
    `tb_cliente`.`str_telefono`, 
    `tb_cliente`.`str_estado`, 

    `tb_locales`.`str_nombre`, 
    `tb_locales`.`str_direccion`, 
    `tb_locales`.`str_estado`, 
    `tb_locales`.`str_telefono`, 
    `tb_locales`.`str_distrito`, 
    `tb_locales`.`str_provincia`, 
    `tb_locales`.`str_departamento`, 
    `tb_locales`.`str_codLocalGuia`, 
    
    `tb_venta`.`dbl_unidadesContenidas` 
FROM
    `bdmatriz`.`tb_venta` INNER JOIN `bdmatriz`.`tb_proveedor`
    ON `tb_venta`.`int_idProveedor` = `tb_proveedor`.`int_idProveedor`
    INNER JOIN `bdmatriz`.`tb_producto`
    ON `tb_venta`.`int_idProducto` = `tb_producto`.`int_idProducto`
    INNER JOIN `bdmatriz`.`tb_cliente`
    ON `tb_venta`.`int_idCliente` = `tb_cliente`.`int_idCliente`
    INNER JOIN `bdmatriz`.`tb_locales`
    ON `tb_venta`.`int_local` = `tb_locales`.`int_idLocal`
WHERE
    `tb_venta`.`int_local` LIKE CONCAT('%', idLocal, '%')
    
    AND `tb_venta`.`str_estado` = estado
    AND `tb_venta`.`str_numeroDocumento` = numeroDocumento;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaTipoContrato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaTipoContrato`(    
)
BEGIN
SELECT
`tb_tipocontrato`.`int_idTipoContrato`,
`tb_tipocontrato`.`str_tipoContrato`,
`tb_tipocontrato`.`str_nombreReporte`,
`tb_tipocontrato`.`str_estado`,
`tb_tipocontrato`.`dte_fechaCreacion`,
`tb_tipocontrato`.`str_usuarioCreador`,
`tb_tipocontrato`.`dte_fechaModificacion`,
`tb_tipocontrato`.`str_usuarioModificador`
FROM `bdmatriz`.`tb_tipocontrato`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listaTodosContratos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaTodosContratos`(
IN dni varchar(8),
IN estado varchar(45)
)
BEGIN

select

p.int_idPersona,
p.str_codigo,
p.str_apePaterno,
p.str_apeMaterno,
p.str_nombres,
p.str_dni,
p.str_estado,



c.int_idContrato,
c.int_idPersona,
c.int_idTipoContrato,
c.int_idEmpresa,
c.dte_fechaInicial,
c.dte_fechaFinal, 
c.dbl_sueldo,
c.str_estado,



tc.int_idTipoContrato,
tc.str_tipoContrato,
tc.str_nombreReporte,
tc.str_estado,




e.int_idEmpresa,
e.str_razonSocial,
e.str_ruc,
e.str_domicilioEmpresa,
e.str_representanteLegal,
e.str_dniRepresentante,




c.str_usuarioCreador
from tb_persona p, tb_contrato c, tb_tipocontrato tc, tb_empresa e
where 

p.int_idPersona=c.int_idPersona and c.int_idTipoContrato=tc.int_idTipoContrato and
e.int_idEmpresa=c.int_idEmpresa and



p.str_dni like concat('%',dni,'%'); 



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_minutosProrroga` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_minutosProrroga`()
BEGIN
select 
    intMinutosProrrogaAntes,
    intMinutosProrrogaDespues
from tb_config limit 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_modificarContrasenia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_modificarContrasenia`(
    in idUsuario int,
    in contrasenia varchar(45)
)
BEGIN
    update tb_usuario set str_contrasenia=contrasenia 
    where int_idUsuario=idUsuario;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_modificarCronogramaPagos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_modificarCronogramaPagos`(
    IN idObligacionesPago INT,
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_cronogramapagos`
SET
    `tb_cronogramapagos`.`str_estado` = estado,
    `tb_cronogramapagos`.`str_usuarioModificador` = usuarioModificador,
    `tb_cronogramapagos`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_cronogramapagos`.`int_idObligacionesPago` = idObligacionesPago
    AND `tb_cronogramapagos`.`str_estado` = 'ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_modificarFacturaCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_modificarFacturaCompra`(
    IN numeroOC VARCHAR(45),
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

SELECT
    `tb_facturacompra`.`int_idFacturaCompra`
FROM
    `bdmatriz`.`tb_facturacompra`
WHERE
    `tb_facturacompra`.`str_numeroFactura` = numeroOC
    AND `tb_facturacompra`.`str_estado` = 'ACTIVO';





UPDATE
    `bdmatriz`.`tb_facturacompra`
SET
    `tb_facturacompra`.`str_estado` = estado,
    `tb_facturacompra`.`str_usuarioModificador` = usuarioModificador,
    `tb_facturacompra`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_facturacompra`.`str_numeroFactura` = numeroOC
    AND `tb_facturacompra`.`str_estado` = 'ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_modificarObligacionesPago` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_modificarObligacionesPago`(
    IN idFacturaCompra INT,
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

SELECT
    `tb_obligacionespago`.`int_idObligacionesPago`
FROM
    `bdmatriz`.`tb_obligacionespago`
WHERE
    `tb_obligacionespago`.`int_idFacturaCompra` = idFacturaCompra
    AND `tb_obligacionespago`.`str_estado` = 'ACTIVO';





UPDATE
    `bdmatriz`.`tb_obligacionespago`
SET
    `tb_obligacionespago`.`str_estado` = estado,
    `tb_obligacionespago`.`str_usuarioModificador` = usuarioModificador,
    `tb_obligacionespago`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_obligacionespago`.`int_idFacturaCompra` = idFacturaCompra
    AND `tb_obligacionespago`.`str_estado` = 'ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_modificarOrdenCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_modificarOrdenCompra`(
    IN idOrdenCompra INT,
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_ordencompra`
SET
    `tb_ordencompra`.`str_estado` = estado,
    `tb_ordencompra`.`str_usuarioModificador` = usuarioModificador,
    `tb_ordencompra`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_ordencompra`.`int_idOrdenCompra` = idOrdenCompra;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_modificarPPOCFC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_modificarPPOCFC`(
    IN idFacturaCompra INT,
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_proveedorproductoordencomprafacturacompra`
SET
    `tb_proveedorproductoordencomprafacturacompra`.`str_estado` = estado,
    `tb_proveedorproductoordencomprafacturacompra`.`str_usuarioModificador` = usuarioModificador,
    `tb_proveedorproductoordencomprafacturacompra`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_proveedorproductoordencomprafacturacompra`.`int_idFacturaCompra` = idFacturaCompra;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_modificarProveedorProductoOrdenCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_modificarProveedorProductoOrdenCompra`(
    IN idOrdenCompra INT,
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_proveedorproductoordencompra`
SET
    `tb_proveedorproductoordencompra`.`str_estado` = estado,
    `tb_proveedorproductoordencompra`.`str_usuarioModificacion` = usuarioModificador,
    `tb_proveedorproductoordencompra`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_proveedorproductoordencompra`.`int_idOrdenCompra` = idOrdenCompra;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_nuevaImpresora` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_nuevaImpresora`(
IN loca integer,
IN marca varchar(45),
IN modelo varchar(45),
IN numeroSerie varchar(45),
IN usuario varchar(45),
IN estado varchar(45),
IN nombre varchar(100)
)
BEGIN
DECLARE existeNS int;
SET existeNS = (select count(numeroSerie) from tb_impresora where str_numeroSerie like numeroSerie);
if existeNS<1 then
	insert into tb_impresora(int_idImpresora,int_local,str_marca,str_modelo,str_numeroSerie,str_usuarioCreador,dte_fechaCreacion,str_estado, str_nombre) 
	values (null,loca,marca,modelo,numeroSerie,usuario,now(),estado,nombre);
    select '1'; 
else
	select '0'; 
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_permisosXPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_permisosXPersona`(
IN idPersona INT,
IN estado varchar(45)
)
BEGIN
select
int_idPermisos,
dte_fecha,
str_motivo,
tm_horaSalida,
tm_horaLlegada,
str_observacion,
str_estado,
tm_horaMarcadoSalida,
tm_horaMarcadoLlegada,
dte_fechaRegistro,
int_idPersona,
time (now())
from  tb_permisos permi   where str_estado=estado and 
      permi.int_idPersona=idPersona AND dte_fecha=date(now())  and
     
           
             (time(now())>=ADDTIME(tm_horaSalida,-500)) 
            
         
          
          
          
          
         
       
;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_proformaToVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_proformaToVenta`(
in documento varchar(100),
in numDocumento varchar(100),
in idlocal int
)
BEGIN

update tb_venta set str_numeroDocumento=numDocumento,str_fechaModificacion=now(),str_fechaRegistro=now() where str_numeroDocumento=documento and int_local=idlocal;

select
int_idVenta,
int_idProveedor,
int_idProducto,
int_idCliente,
dbl_cantidad,
dbl_precio,
dbl_subTotal,
dbl_descuento,
dbl_igv,
dbl_total,
str_numeroDocumento,
str_usuario,
str_estado,
str_clienteResponsable,
int_local,
str_fechaRegistro,
str_fechaModificacion,
dbl_unidadesContenidas
from tb_venta
where str_numeroDocumento=numDocumento and int_local=idlocal;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrarAsistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarAsistencia`(
IN idHorario INT,
IN idJornada INT,
IN idContrato INT,
IN tipoMarcado VARCHAR(1),
IN estadoMarcado VARCHAR(45)

)
BEGIN


INSERT INTO tb_asistencia
(
int_idHorario,
int_idJornada,
int_idContrato,
dte_fecha,
str_tipoMarcado,
str_estadoMarcado)
VALUES
(

idHorario,
idJornada ,
idContrato,
(SELECT NOW()),
tipoMarcado,
estadoMarcado

);



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrarMarcadoPorPermiso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarMarcadoPorPermiso`(
in idPermiso int,
in tmHoraSalida time,
in tmHoraLlegada time,
in  estado varchar(45)
)
BEGIN
update tb_permisos set tm_horaMarcadoSalida=tmHoraSalida,
                       tm_horaMarcadoLlegada=tmHoraLlegada,
                       str_estado=estado
where int_idPermisos=idPermiso;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_renovarContrato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_renovarContrato`(
    IN idContrato int,
    IN idPersona int,
    IN idTipoContrato int,
    IN idEmpresa int,
    IN fechaInicial date,
    IN fechaFinal date,
    IN sueldo Double,
    IN estado varchar(45),    
    IN usuarioCreador varchar(45),
    IN fechaCreacion date,
    IN observacion text,
    IN estadoUpdate varchar(45)
)
BEGIN

update tb_contrato set str_estado=estadoUpdate, str_observacion=observacion where int_idContrato=idContrato;

INSERT INTO `bdmatriz`.`tb_contrato`
(`int_idContrato`,
`int_idPersona`,
`int_idTipoContrato`,
`int_idEmpresa`,
`dte_fechaInicial`,
`dte_fechaFinal`,
`dbl_sueldo`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_ultimaModificacion`

)

VALUES
(
null,
idPersona,
idTipoContrato,
idEmpresa,
fechaInicial,
fechaFinal,
sueldo,
estado,
fechaCreacion,
usuarioCreador,
(select now())


);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salioRefrigerio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_salioRefrigerio`(
in idAsistencia int,
in estado varchar(45)
)
BEGIN

SELECT
id_refrigerio,
dt_horaSalida,
dt_horaRegreso,
str_estado,
int_asistencia
FROM tb_refrigerio
where int_asistencia=idAsistencia and
       str_estado=estado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selecPersonaFunciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selecPersonaFunciones`(
    
)
BEGIN
SELECT
        tb_usuario.`int_idPersona`,
     tb_persona.`str_codigo` AS tb_persona_str_codigo,
     tb_persona.`str_apePaterno` AS tb_persona_str_apePaterno,
     tb_persona.`str_apeMaterno` AS tb_persona_str_apeMaterno,
     tb_persona.`str_nombres` AS tb_persona_str_nombres
     
FROM
     `tb_funciones` tb_funciones INNER JOIN `tb_funcionusuario` tb_funcionusuario ON tb_funciones.`int_idFunciones` = tb_funcionusuario.`int_idFunciones`
     INNER JOIN `tb_usuario` tb_usuario ON tb_funcionusuario.`int_idUsuario` = tb_usuario.`int_idUsuario`
     INNER JOIN `tb_persona` tb_persona ON tb_usuario.`int_idPersona` = tb_persona.`int_idPersona`
group by tb_persona.`str_codigo`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selecPersonaMemorandum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selecPersonaMemorandum`(
)
BEGIN
SELECT
     tb_memorandum.`int_idMemorandum`,
     tb_memorandum.`int_idPersona`,
     tb_persona.`int_idPersona`,
     tb_persona.`str_codigo`,
     tb_persona.`str_apePaterno`,
     tb_persona.`str_apeMaterno`,
     tb_persona.`str_nombres`
FROM
     `tb_persona` tb_persona INNER JOIN `tb_memorandum` tb_memorandum ON tb_persona.`int_idPersona` = tb_memorandum.`int_idPersona`
group by tb_persona.`str_codigo`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selecPersonaPermisos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selecPersonaPermisos`(
    
)
BEGIN
SELECT
        tb_persona.`int_idPersona`,
     tb_persona.`str_codigo` AS tb_persona_str_codigo,
     tb_persona.`str_apePaterno` AS tb_persona_str_apePaterno,
     tb_persona.`str_apeMaterno` AS tb_persona_str_apeMaterno,
     tb_persona.`str_nombres` AS tb_persona_str_nombres,
     tb_persona.`str_dni` AS tb_persona_str_dni
FROM
     `tb_persona` tb_persona INNER JOIN `tb_permisos` tb_permisos ON tb_persona.`int_idPersona` = tb_permisos.`int_idPersona`

group by tb_persona.`str_codigo`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectIdAsistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectIdAsistencia`(
    in int_idContrato int
)
BEGIN
select `tb_asistencia`.`int_asistencia` 
from `tb_asistencia` 
where `tb_asistencia`.`int_idContrato`=int_idContrato 
and `tb_asistencia`.`str_tipoMarcado`='F' 
and date(`tb_asistencia`.`dte_fecha`)=(select date(now()));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectIdContrato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectIdContrato`(
    in int_idPersona int
   
)
BEGIN

SELECT
`tb_contrato`.`int_idContrato`
FROM `bdmatriz`.`tb_contrato`
where `tb_contrato`.`int_idPersona`=int_idPersona and `tb_contrato`.`str_estado`='ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectIdUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectIdUsuario`(
    in str_usuario varchar(45)
)
BEGIN
SELECT
`tb_usuario`.`int_idUsuario`,
`tb_usuario`.`str_contrasenia`
FROM `bdmatriz`.`tb_usuario`
where `tb_usuario`.`str_usuario`=str_usuario;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectLogeo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectLogeo`(
    in strUsurio varchar(45)
)
BEGIN
SELECT
`tb_logeo`.`int_idLogeo`,
`tb_logeo`.`str_usuario`,
`tb_logeo`.`dte_fecha`,
`tb_logeo`.`str_estado`
FROM `bdmatriz`.`tb_logeo`
where str_usuario = strUsurio;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectMemorandum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectMemorandum`(
   )
BEGIN
SELECT
`tb_memorandum`.`int_idMemorandum`,
`tb_memorandum`.`str_numero`,
`tb_memorandum`.`str_emisor`,
`tb_memorandum`.`str_receptor`,
`tb_memorandum`.`str_asunto`,
`tb_memorandum`.`dte_fecha`,
`tb_memorandum`.`str_cuerpo`,
`tb_memorandum`.`str_usuarioCreador`,
`tb_memorandum`.`dte_fechaCreacion`,
`tb_memorandum`.`int_idPersona`
FROM `bdmatriz`.`tb_memorandum`
group by `tb_memorandum`.`str_asunto`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectPartTime` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectPartTime`(
    in int_idAsistencia int
)
BEGIN
SELECT
`tb_mediotiempo`.`int_idMedioTiempo`,
`tb_mediotiempo`.`int_asistencia`,
`tb_mediotiempo`.`dte_marcacion`,
`tb_mediotiempo`.`str_estado`,
`tb_mediotiempo`.`str_iniFin`
FROM `bdmatriz`.`tb_mediotiempo`
where `tb_mediotiempo`.`int_asistencia`= int_idAsistencia
and date(`tb_mediotiempo`.`dte_marcacion`)=(select date(now()));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectProductoHistorial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectProductoHistorial`(
    IN idProveedor INT,
    IN idProducto INT,
    IN estado VARCHAR(45)
)
BEGIN

SELECT
    `tb_productohistorial`.`dbl_precio`, 
    `tb_productohistorial`.`dbl_descuento`, 
    `tb_productohistorial`.`dbl_peso` 
FROM
    `bdmatriz`.`tb_productohistorial`
where
    `tb_productohistorial`.`int_idProveedor` = idProveedor
    AND `tb_productohistorial`.`int_idProducto` = idProducto
    AND `tb_productohistorial`.`str_estado` = estado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectProveedor`(
    in str_ruc varchar(15),
    in str_razonSocial varchar(500)
)
BEGIN
SELECT
    `tb_proveedor`.`int_idProveedor`,
    `tb_proveedor`.`str_razonSocial`,
    `tb_proveedor`.`str_nombreComercial`,
    `tb_proveedor`.`str_ruc`,
    `tb_proveedor`.`str_direccion`,
    `tb_proveedor`.`str_email`,
    `tb_proveedor`.`str_telefono`,
    `tb_proveedor`.`str_fax`,
    `tb_proveedor`.`str_representanteLegal`,
    `tb_proveedor`.`str_banco`,
    `tb_proveedor`.`str_ctaPrincipal`,
    `tb_proveedor`.`str_ctaAlternativa`,
    `tb_proveedor`.`str_estado`,
    `tb_proveedor`.`str_usuarioCreador`,
    `tb_proveedor`.`dte_fechaCreacion`
FROM
    `bdmatriz`.`tb_proveedor`
where
    `tb_proveedor`.`str_ruc` like str_ruc 
    and `tb_proveedor`.`str_razonSocial` like str_razonSocial
ORDER BY
    `tb_proveedor`.`str_razonSocial`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectProveedorProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectProveedorProducto`(
    in int_idProvee varchar(15),
    in int_idProd varchar(15),
    in str_esta varchar(45),
    IN nombreProducto VARCHAR(100)
)
BEGIN

SELECT
    `tb_proveedorproducto`.`int_idProveedor`, 
    `tb_proveedorproducto`.`int_idProducto`, 
    `tb_proveedorproducto`.`str_usuarioCreador`, 
    `tb_proveedorproducto`.`dte_fechaCreacion`, 
    `tb_proveedorproducto`.`str_modificarUsuario`, 
    `tb_proveedorproducto`.`dte_fechaModificacion`, 
    `tb_proveedorproducto`.`str_estado`, 

    `tb_producto`.`str_nombreProducto`, 
    `tb_producto`.`str_codigoInterno`, 
    `tb_producto`.`str_descripcion`, 
    `tb_producto`.`str_fabricante`, 
    `tb_producto`.`str_reintegroTributario`, 

    `tb_familia`.`int_idFamilia`, 
    `tb_familia`.`str_nombre`, 
    
    `tb_unidadmedida`.`int_idUnidadMedida`, 
    `tb_unidadmedida`.`str_nombreUM`, 
    
    `tb_medidarotacion`.`int_idMedidaRotacion`, 
    `tb_medidarotacion`.`str_codigoMR`, 
    `tb_medidarotacion`.`str_nombreMR`, 
    `tb_medidarotacion`.`dbl_utilidad`, 
    `tb_medidarotacion`.`dbl_adicional`, 
    `tb_medidarotacion`.`str_estadoMR` 
FROM
    `bdmatriz`.`tb_proveedorproducto` inner join `bdmatriz`.`tb_producto`
    on `tb_proveedorproducto`.`int_idProducto`=`tb_producto`.`int_idProducto`
    inner join `bdmatriz`.`tb_familia`
    on `tb_familia`.`int_idFamilia` = `tb_producto`.`int_idFamilia`
    inner join `bdmatriz`.`tb_unidadmedida`
    on `tb_unidadmedida`.`int_idUnidadMedida` = `tb_producto`.`int_idUnidadMedida`
    inner join `bdmatriz`.`tb_medidarotacion`
    on `tb_medidarotacion`.`int_idMedidaRotacion` = `tb_producto`.`int_idMedidaRotacion`
where
    `tb_proveedorproducto`.`int_idProveedor` like int_idProvee
    and `tb_proveedorproducto`.`int_idProducto` like int_idProd
    and `tb_proveedorproducto`.`str_estado` = str_esta
    AND (`tb_producto`.`str_nombreProducto` LIKE CONCAT('%', nombreProducto, '%') or 
    `tb_producto`.`str_codigoInterno` = nombreProducto);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_selectTipoCambio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_selectTipoCambio`(
    IN fechaDia VARCHAR(45)
)
BEGIN

SELECT
    `tb_tipocambio`.`int_idTipoCambio`,
    `tb_tipocambio`.`dbl_precioCompraDolar`,
    `tb_tipocambio`.`dbl_precioVentaDolar`,
    `tb_tipocambio`.`str_fechaDia`,
    `tb_tipocambio`.`str_estado`
FROM
    `bdmatriz`.`tb_tipocambio`
WHERE
    `tb_tipocambio`.`str_fechaDia` = fechaDia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_stock` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_stock`(
    in idAlmacen int
)
BEGIN
SELECT dbl_stock 
FROM bdmatriz.tb_almacen 
where int_idAlmacen=idAlmacen;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateCliente`(
    IN idCliente INT,
    IN razonSocial VARCHAR(45),
    IN rucdni VARCHAR(45),
    IN direccion VARCHAR(45),
    IN telefono VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_cliente`
SET
    `tb_cliente`.`str_razonSocial` = razonSocial,
    `tb_cliente`.`str_rucdni` = rucdni,
    `tb_cliente`.`str_direccion` = direccion,
    `tb_cliente`.`str_telefono` = telefono,
    `tb_cliente`.`str_usuarioModificador` = usuarioModificador,
    `tb_cliente`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_cliente`.`int_idCliente` = idCliente;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateClienteInactivar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateClienteInactivar`(
    IN idCliente INT,
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_cliente`
SET
    `tb_cliente`.`str_estado` = estado,
    `tb_cliente`.`str_usuarioModificador` = usuarioModificador,
    `tb_cliente`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_cliente`.`int_idCliente` = idCliente;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateCodigoPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateCodigoPersona`(
IN codigo varchar(45),
IN llave int
)
BEGIN
update tb_persona set str_codigo=codigo where int_idPersona=llave;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateConfig` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateConfig`(
    
    in idConfig int,
    in minutosAntes int,
    in minutosDespues int,
    in igv double,
    in uit double,
    in tipoImpresion varchar(1)
)
BEGIN
UPDATE `bdmatriz`.`tb_config`
SET

`intMinutosProrrogaAntes` = minutosAntes,
`intMinutosProrrogaDespues` = minutosDespues,
`dblIGV` = igv,
`dblUIT` = uit,
`strTipoImpresora` = tipoImpresion
WHERE `int_idConfig`=idConfig;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateContrato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateContrato`(
IN contrato int,
IN estado varchar(45),
IN observacion text
)
BEGIN
update tb_contrato set str_estado=estado, str_observacion=observacion
where int_idContrato=contrato;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateEstadoGuia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateEstadoGuia`(
    in idGuia int,
    in estado varchar(45)
)
BEGIN

update tb_guiaremision set str_estado=estado
where int_idGuiaremision=idGuia;

update tb_detalleguia set str_estado=estado
where int_idGuiaremision=idGuia;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateEstadoMemorandum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateEstadoMemorandum`(
   in idMemorandum int
   )
BEGIN
update `bdmatriz`.`tb_memorandum` 
set `str_estado` = 'INACTIVO' 
where `int_idMemorandum` =idMemorandum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateEstadoPermiso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateEstadoPermiso`(
in idPermiso int,
in estado varchar(45),


in usuarioApro varchar(45)
)
BEGIN
update tb_permisos set str_estado=estado,
       str_usuarioaAprobo=usuarioApro where int_idPermisos=idPermiso;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateFacturaCompraNumero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateFacturaCompraNumero`(
    IN numeroFC VARCHAR(45),
    IN idOrdenCompra INT,
    IN usuarioModificador VARCHAR(45)
)
BEGIN

DECLARE numeroFCTemp VARCHAR(45);
SET numeroFCTemp =
(SELECT
    `tb_facturacompra`.`str_numeroFactura`
FROM
    `bdmatriz`.`tb_facturacompra`
WHERE
    `tb_facturacompra`.`int_idFacturaCompra` =
        (SELECT `tb_proveedorproductoordencomprafacturacompra`.`int_idFacturaCompra`
        FROM `bdmatriz`.`tb_proveedorproductoordencomprafacturacompra`
        WHERE `tb_proveedorproductoordencomprafacturacompra`.`int_idOrdenCompra` = idOrdenCompra
        LIMIT 1)
);





UPDATE
    `bdmatriz`.`tb_facturacompra`
SET
    `tb_facturacompra`.`str_numeroFactura` = numeroFC,
    `tb_facturacompra`.`str_usuarioModificador` = usuarioModificador,
    `tb_facturacompra`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_facturacompra`.`str_numeroFactura` =  numeroFCTemp
    AND `tb_facturacompra`.`str_estado` = 'ACTIVO';





SELECT
    `tb_facturacompra`.`int_idFacturaCompra`
FROM
    `bdmatriz`.`tb_facturacompra`
WHERE
    `tb_facturacompra`.`str_numeroFactura` = numeroFC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateFamilia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateFamilia`(
    in idFamilia int,
    in nombre varchar(45),
    in descripcion varchar(100),
    in usuarioModificador varchar(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_familia`
SET
    `tb_familia`.`str_nombre` = nombre,
    `tb_familia`.`str_descripcion` = descripcion,
    `tb_familia`.`str_usuarioModificacion` = usuarioModificador,
    `tb_familia`.`dte_fechaModificacion` = (select now())
WHERE
    `int_idFamilia` = idFamilia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateFoto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateFoto`(
IN foto longblob,
IN estado varchar(45),
IN codigo varchar(45)
)
BEGIN
    update tb_persona set blob_foto=foto where str_codigo=codigo and str_estado=estado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateHorarioLocalPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateHorarioLocalPersona`(
    IN idHorario int,
    IN idJornada int,
    IN idContrato int,
    IN estado varchar(45)
)
BEGIN

UPDATE
    tb_horariojornadacontrato hjc

SET
    hjc.str_estado = estado

WHERE
    hjc.int_idContrato = idContrato and
    (hjc.int_idJornada <> idJornada and hjc.int_idHorario <> idHorario);
    
    
SELECT
    *
    
    
    
    

FROM
    tb_horariojornadacontrato hjc

WHERE
    hjc.int_idHorario = idHorario and
    hjc.int_idContrato = idContrato;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateHorarioPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateHorarioPersona`(
    IN idHorario int,
    IN idJornada int,
    IN idContrato int,
    IN estado varchar(45),
    IN usuarioModificador varchar(45)
)
BEGIN



UPDATE
    tb_horariojornadacontrato

SET
    str_estado = 'ACTIVO',
    dte_fechaModificacion = date(now()),
    str_usuarioModificador = usuarioModificador

WHERE
    int_idContrato = idContrato and
    int_idJornada = idJornada and
    int_idHorario = idHorario;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateKardex` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateKardex`(

    in idAlmacen int,
    in stock double

)
BEGIN

UPDATE `bdmatriz`.`tb_almacen`
SET
`dbl_stock` = stock
WHERE `int_idAlmacen` = idAlmacen and str_estado = 'ACTIVO';


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateLocalPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateLocalPersona`(
    IN idContrato int,
    IN idLocal int
)
BEGIN

UPDATE
    tb_contrato

SET
    int_local = idLocal

WHERE
    int_idContrato = idContrato;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateMedidaRotacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateMedidaRotacion`(
    IN idMedidaRotacion INT,
    IN codigoMR VARCHAR(45),
    IN utilidad DOUBLE,
    IN adicional DOUBLE,
    IN descripcionMR VARCHAR(200),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_medidarotacion`
SET
    
    `tb_medidarotacion`.`dbl_utilidad` = utilidad,
    `tb_medidarotacion`.`dbl_adicional` = adicional,
    `tb_medidarotacion`.`str_descripcionMR` = descripcionMR,
    `tb_medidarotacion`.`str_usuarioModificador` = usuarioModificador,
    `tb_medidarotacion`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_medidarotacion`.`int_idMedidaRotacion` = idMedidaRotacion
    AND `tb_medidarotacion`.`str_codigoMR` = codigoMR;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateOC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateOC`(
    IN idOrdenCompra INT,
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_ordencompra`
SET
    `tb_ordencompra`.`str_estado` = estado,
    `tb_ordencompra`.`str_usuarioModificador` = usuarioModificador,
    `tb_ordencompra`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_ordencompra`.`int_idOrdenCompra` = idOrdenCompra;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateOrdenCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateOrdenCompra`(
    IN idOrdenCompra INT,
    IN estado varchar(45),
    IN usuarioModificador varchar(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_ordencompra`
SET
    `str_estado` = estado,
    `str_usuarioModificador` = usuarioModificador,
    `str_fechaModificacion` = (SELECT now())
WHERE
    `int_idOrdenCompra`= idOrdenCompra;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updatePersonal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updatePersonal`(
    IN paterno varchar(45),
    IN materno varchar(45),
    IN nombres varchar(45),
    IN dni varchar(8),
    IN carnetEstranjeria varchar(15),
    IN fechaNacimiento Date,
    IN ciudadNacimiento varchar(45),
    IN telefono varchar(10),
    IN movil varchar(9),
    IN sexo char(1),
    IN nacionalidad varchar(45),
    IN correoElectronico varchar(45),
    IN brevete char(1),
    IN categoriaBrevete varchar(45),
    IN estadoCivil varchar(15),
    IN direccion varchar(150),
    IN distrito varchar(150),
    IN provincia varchar(150),
    IN departamento varchar(150),
    IN huellaDigital_1 BLOB,
    IN huellaDigital_2 BLOB,
    IN estado varchar(45),

    IN usuarioCreador varchar(45),
    IN ultimaModificacion Date,
    IN usuarioModificador varchar(45),
    IN foto LONGBLOB,
    
    
    IN estadoUpdate varchar(45),
    IN codigoCompuesto varchar(45)
    
)
BEGIN
declare nuevafoto LONGBLOB;


set nuevafoto=(select blob_foto from tb_persona where str_codigo=codigoCompuesto and str_estado=estado);


update tb_persona set blob_foto=null, str_estado=estadoUpdate , bin_huellaDigital_1=null, bin_huellaDigital_2=null
where str_codigo=codigoCompuesto;

INSERT INTO tb_persona
(
`int_idPersona`,

`str_codigo`,

`str_apePaterno`,
`str_apeMaterno`,
`str_nombres`,
`str_dni`,
`str_carnetExtranjeria`,
`dte_fechaNacimiento`,
`str_ciudadNacimiento`,
`str_telefono`,
`str_movil`,
`str_sexo`,
`str_nacionalidad`,
`str_correoElectronico`,
`str_brevete`,
`str_categoriaBrevete`,
`str_estadoCivil`,
`str_direccion`,
`str_distrito`,
`str_provincia`,
`str_departamento`,
`bin_huellaDigital_1`,
`bin_huellaDigital_2`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_ultimaModificacion`,
`str_usuarioModificador`,
`blob_foto`)

VALUES
(
null,

codigoCompuesto,


paterno,
materno,
nombres,
dni,
carnetEstranjeria,
fechaNacimiento,
ciudadNacimiento,
telefono,
movil,
sexo,
nacionalidad,
correoElectronico,
brevete,
categoriaBrevete,
estadoCivil,
direccion,
distrito,
provincia,
departamento,
huellaDigital_1,
huellaDigital_2,
estado,
(select now()),
usuarioCreador,
ultimaModificacion,
usuarioModificador,
nuevafoto

);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updatePPOCFC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updatePPOCFC`(
    in idProve int,
    in idProd int,
    in idOC int,
    IN idFactura INT,
    in cantidadRecibida DOUBLE,
    IN numeroFactura VARCHAR(45),
    IN idLocalRecibido INT,
    IN fechaDocumento VARCHAR(45),
    in estado varchar(45),
    IN usuarioModificador varchar(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_proveedorproductoordencomprafacturacompra`
SET
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_cantidadRecibida` = cantidadRecibida,
    `tb_proveedorproductoordencomprafacturacompra`.`str_numeroFactura` = numeroFactura,
    `tb_proveedorproductoordencomprafacturacompra`.`int_idLocalRecibido` = idLocalRecibido,
    `tb_proveedorproductoordencomprafacturacompra`.`str_fechaDocumento` = fechaDocumento,
    `tb_proveedorproductoordencomprafacturacompra`.`str_estado` = estado,
    `tb_proveedorproductoordencomprafacturacompra`.`str_usuarioModificador` = usuarioModificador,
    `tb_proveedorproductoordencomprafacturacompra`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_proveedorproductoordencomprafacturacompra`.`int_idProveedor` = idProve
    AND `tb_proveedorproductoordencomprafacturacompra`.`int_idProducto` = idProd
    and `tb_proveedorproductoordencomprafacturacompra`.`int_idOrdenCompra` = idOC
    AND `tb_proveedorproductoordencomprafacturacompra`.`int_idFacturaCompra` = idFactura;





UPDATE
    `bdmatriz`.`tb_proveedorproductoordencompra`
SET
    `tb_proveedorproductoordencompra`.`str_estado` = estado,
    `tb_proveedorproductoordencompra`.`str_usuarioModificacion` = usuarioModificador,
    `tb_proveedorproductoordencompra`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_proveedorproductoordencompra`.`int_idProveedor` = idProve
    AND `tb_proveedorproductoordencompra`.`int_idProducto` = idProd
    AND `tb_proveedorproductoordencompra`.`int_idOrdenCompra` = idOC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updatePPOCFCConformidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updatePPOCFCConformidad`(
    IN idProveedor INT,
    IN idProducto INT,
    IN idOrdenCompra INT,
    IN numeroFactura VARCHAR(45),
    IN conformidadOK DOUBLE,
    IN conformidadFallaProveedor DOUBLE,
    IN conformidadFallaTransportista DOUBLE,
    IN conformidadFallaOtro DOUBLE,
    IN conformidadObservacion VARCHAR(45),
    IN conformidadEstado VARCHAR(45),
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_proveedorproductoordencomprafacturacompra`
SET
    `tb_proveedorproductoordencomprafacturacompra`.`str_usuarioModificador` = usuarioModificador,
    `tb_proveedorproductoordencomprafacturacompra`.`str_fechaModificacion` = (SELECT NOW()),
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_conformidadOK` = conformidadOK,
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_conformidadFallaProveedor` = conformidadFallaProveedor,
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_conformidadFallaTransportista` = conformidadFallaTransportista,
    `tb_proveedorproductoordencomprafacturacompra`.`dbl_conformidadFallaOtro` = conformidadFallaOtro,
    `tb_proveedorproductoordencomprafacturacompra`.`str_conformidadObservacion` = conformidadObservacion,
    `tb_proveedorproductoordencomprafacturacompra`.`str_conformidadEstado` = conformidadEstado
WHERE
    `tb_proveedorproductoordencomprafacturacompra`.`int_idProveedor` = idProveedor
    AND `tb_proveedorproductoordencomprafacturacompra`.`int_idProducto` = idProducto
    AND `tb_proveedorproductoordencomprafacturacompra`.`int_idOrdenCompra` = idOrdenCompra
    AND `tb_proveedorproductoordencomprafacturacompra`.`str_numeroFactura` = numeroFactura;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updatePPUM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updatePPUM`(
    IN idProveedor INT,
    IN idProducto INT,
    IN idUnidadMedidaVenta INT,
    IN UnidadMedidaCompra VARCHAR(45),
    IN costoCompra DOUBLE,
    IN unidadesContenidas DOUBLE,
    IN precioUnidadContenida DOUBLE,
    IN costoTraslado DOUBLE,
    IN precioFinal DOUBLE,
    IN precioOferta DOUBLE,
    IN usuarioModificador VARCHAR(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_proveedorproductounidadmedida`
SET
    `tb_proveedorproductounidadmedida`.`dbl_costoCompra` = costoCompra,
    `tb_proveedorproductounidadmedida`.`dbl_unidadesContenidas` = unidadesContenidas,
    `tb_proveedorproductounidadmedida`.`dbl_precioUnidadContenida` = precioUnidadContenida,
    `tb_proveedorproductounidadmedida`.`dbl_costoTraslado` = costoTraslado,
    `tb_proveedorproductounidadmedida`.`dbl_precioFinal` = precioFinal,
    `tb_proveedorproductounidadmedida`.`dbl_precioOferta` = precioOferta,
    `tb_proveedorproductounidadmedida`.`str_usuarioModificador` = usuarioModificador,
    `tb_proveedorproductounidadmedida`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_proveedorproductounidadmedida`.`int_idProveedor` = idProveedor
    AND `tb_proveedorproductounidadmedida`.`int_idProducto` = idProducto
    AND `tb_proveedorproductounidadmedida`.`int_idUnidadMedidaVenta` = idUnidadMedidaVenta
    AND `tb_proveedorproductounidadmedida`.`str_UnidadMedidaCompra` = UnidadMedidaCompra;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updatePPUMOferta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updatePPUMOferta`(
    IN idProveedor INT,
    IN idProducto INT,
    IN precioOferta DOUBLE,
    IN usuarioModificador varchar(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_proveedorproductounidadmedida`
SET
    `tb_proveedorproductounidadmedida`.`dbl_precioOferta` = precioOferta,
    `tb_proveedorproductounidadmedida`.`str_usuarioModificador` = usuarioModificador,
    `tb_proveedorproductounidadmedida`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_proveedorproductounidadmedida`.`int_idProveedor` = idProveedor
    AND `tb_proveedorproductounidadmedida`.`int_idProducto` = idProducto;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateProducto`(
    IN idProducto int,
    IN codigo VARCHAR(45),
    IN nombreProducto varchar(100),
    IN descripcion varchar(200),
    IN fabricante varchar(45),
    IN idFamilia int,
    IN idUnidadMedida int,
    IN idMedidaRotacion int,
    IN usuarioModificador varchar(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_producto`
SET
    `tb_producto`.`str_codigoInterno` = codigo,
    `tb_producto`.`str_nombreProducto` = nombreProducto,
    `tb_producto`.`str_descripcion` = descripcion,
    `tb_producto`.`str_fabricante` = fabricante,
    `tb_producto`.`int_idFamilia` = idFamilia,
    `tb_producto`.`int_idUnidadMedida` = idUnidadMedida,
    `tb_producto`.`int_idMedidaRotacion` = idMedidaRotacion,
    `tb_producto`.`str_usuarioModificador` = usuarioModificador,
    `tb_producto`.`dte_fechaModificacion` = (select now())
WHERE
    `tb_producto`.`int_idProducto` = idProducto;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateProveedor`(

in str_razonSocial varchar(500),
in str_nombreComercial varchar(200),
in str_ruc varchar(15),
in str_direccion varchar(200),
in str_email varchar(150),
in str_telefono varchar(45),
in str_fax varchar(45),
in str_representanteLegal varchar(150),
in str_banco varchar(45),
in str_ctaPrincipal varchar(45),
in str_ctaAlternativa varchar(45),
in str_usuarioCreador varchar(45),
in int_idProve int

)
BEGIN
UPDATE `bdmatriz`.`tb_proveedor`
SET
`str_razonSocial` = str_razonSocial,
`str_nombreComercial` = str_nombreComercial,
`str_ruc` = str_ruc,
`str_direccion` = str_direccion,
`str_email` = str_email,
`str_telefono` = str_telefono,
`str_fax` = str_fax,
`str_representanteLegal` = str_representanteLegal,
`str_banco` = str_banco,
`str_ctaPrincipal` = str_ctaPrincipal,
`str_ctaAlternativa` = str_ctaAlternativa,
`str_usuarioCreador` = str_usuarioCreador,
`dte_fechaCreacion` = now()
WHERE `int_idProveedor`=int_idProve;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateProveedorProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateProveedorProducto`(
    in int_idProvee int,
    in int_idProd int,
    in str_usuarioModificar varchar(45),
    in str_esta varchar(45)
)
BEGIN
UPDATE `bdmatriz`.`tb_proveedorproducto`
SET
`str_modificarUsuario` = str_usuarioModificar,
`dte_fechaModificacion` = now(),
`str_estado` = str_esta
WHERE `tb_proveedorproducto`.`int_idProveedor`=int_idProvee
and `tb_proveedorproducto`.`int_idProducto`=int_idProd;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateRefrigerio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateRefrigerio`(
in idRefrigerio int,
in estado varchar(45)
)
BEGIN
UPDATE tb_refrigerio
SET
dt_horaRegreso = (NOW()),
str_estado = estado
WHERE id_refrigerio=idRefrigerio;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateTraspasoMercaderia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateTraspasoMercaderia`(
    in idTraspaso int,
    in codConfirma varchar(45),

    in estado varchar(45),
    in usuarioModifica varchar(45)
)
BEGIN
UPDATE `bdmatriz`.`tb_traspasointerno`
SET
`str_codigoConfirma` = codConfirma,
`dte_fechaConfirma` = now(),
`str_estado` = estado,
`str_usuarioModifcador` = usuarioModifica,
`dte_fechaModificacion` = now()
WHERE `int_idTraspasointerno`=idTraspaso;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateUnidadMedida` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateUnidadMedida`(
    IN idUnidadMedida INT,
    IN nombre varchar(45),
    IN descripcion varchar(100),
    IN usuarioModificador varchar(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_unidadmedida`
SET
    `tb_unidadmedida`.`str_nombreUM` = nombre,
    `tb_unidadmedida`.`str_descripcionUM` = descripcion,
    `tb_unidadmedida`.`str_usuarioModificador` = usuarioModificador,
    `tb_unidadmedida`.`dte_fechaModificacion` = (SELECT NOW())
WHERE
    `tb_unidadmedida`.`int_idUnidadMedida` = idUnidadMedida;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateVentaYAlmacen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_updateVentaYAlmacen`(
    IN idLocal INT,
    IN nroDocumentoTemp VARCHAR(45),
    IN nroDocumento VARCHAR(45),
    IN estado VARCHAR(45),
    IN usuarioModificador VARCHAR(45),
    IN idVenta int,
    IN idAlmacen int,
    in tipoVenta varchar(45),
    in nroComprobante varchar(45)
)
BEGIN

UPDATE
    `bdmatriz`.`tb_almacen`
SET
    `tb_almacen`.`str_documento` = nroDocumento,
    `tb_almacen`.`str_usuarioModificador` = usuarioModificador,
    `tb_almacen`.`str_fechaModificacion` = (SELECT NOW())
WHERE
    

      int_idAlmacen=idAlmacen;





UPDATE
    `bdmatriz`.`tb_venta`
SET
    `tb_venta`.`str_numeroDocumento` = nroDocumento,
    `tb_venta`.`str_estado` = estado,
    `tb_venta`.`str_fechaModificacion` = (SELECT NOW()),
    `tb_venta`.`str_tipoVenta`=tipoVenta,
    `tb_venta`.`str_comprobantePago`=nroComprobante
WHERE
    
    
      int_idVenta=idVenta;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_validarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validarUsuario`(
    IN usuario varchar(45),
    IN contrasenia varchar(45)
)
BEGIN
    select
    int_idUsuario,
    int_idPersona,
    str_usuario,
    str_contrasenia,
    dte_fechaCreacion,
    str_usuarioCreador,
    dte_fechaModificacion,
    str_usuarioModificador,
    str_codigoPersona
    from tb_usuario 
    where  str_usuario=usuario and str_contrasenia = contrasenia;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificarAperturaCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_verificarAperturaCaja`(
    IN idLocal INT,
    IN apertura VARCHAR(45),
    IN cierre VARCHAR(45),
    IN usuario VARCHAR(45)
)
BEGIN

SELECT
    `tb_flujocaja`.`int_idCaja`,
    `tb_caja`.`str_nombre`,
    `tb_flujocaja`.`str_numeroSerieImpresora`
FROM
    `bdmatriz`.`tb_flujocaja`, `bdmatriz`.`tb_caja`
WHERE
    (SELECT COUNT(`tb_flujocaja`.`str_motivo`)
    FROM
        `bdmatriz`.`tb_flujocaja`
    WHERE
        `tb_flujocaja`.`str_motivo` = apertura
        AND DATE (`tb_flujocaja`.`dte_fechaCreacion`) = DATE (NOW())
        AND `tb_flujocaja`.`int_idLocal` = idLocal
        AND `tb_flujocaja`.`str_usuarioCreador` = usuario)
    
    >
    
    (SELECT COUNT(`tb_flujocaja`.`str_motivo`)
    FROM
        `bdmatriz`.`tb_flujocaja`
    WHERE
        `tb_flujocaja`.`str_motivo` = cierre
        AND DATE (`tb_flujocaja`.`dte_fechaCreacion`) = DATE (NOW())
        AND `tb_flujocaja`.`int_idLocal` = idLocal
        AND `tb_flujocaja`.`str_usuarioCreador` = usuario)
    
    AND DATE (`tb_flujocaja`.`dte_fechaCreacion`) = DATE (NOW())
    AND `tb_flujocaja`.`int_idLocal` = idLocal
    AND `tb_flujocaja`.`str_usuarioCreador` = usuario
    AND `tb_flujocaja`.`int_idCaja` = `tb_caja`.`int_idCaja`
    ORDER BY
        `tb_flujocaja`.`int_idFlujoCaja` DESC
    LIMIT 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificarCodigoProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_verificarCodigoProducto`(
    IN codigo varchar(45)
)
BEGIN

SELECT
    `tb_producto`.`str_codigoInterno`    
FROM
    `bdmatriz`.`tb_producto`
WHERE
    `tb_producto`.`str_codigoInterno` = codigo
    AND `tb_producto`.`str_estado` = 'ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificarNombreFamilia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_verificarNombreFamilia`(
    IN nombre varchar(45)
   )
BEGIN

SELECT
    `tb_familia`.`str_nombre`    
FROM
    `bdmatriz`.`tb_familia`
WHERE
    `tb_familia`.`str_nombre` = nombre and
    `tb_familia`.`str_estado` = 'ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificarNombreProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_verificarNombreProducto`(
    IN nombre varchar(100)
   )
BEGIN

SELECT
    `tb_producto`.`str_nombreProducto`    
FROM
    `bdmatriz`.`tb_producto`
WHERE
    `tb_producto`.`str_nombreProducto` = nombre and
    `tb_producto`.`str_estado` = 'ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificarNombreUM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_verificarNombreUM`(
    IN nombreUM varchar(45)
   )
BEGIN

SELECT
    `tb_unidadmedida`.`str_nombreUM`    
FROM
    `bdmatriz`.`tb_unidadmedida`
WHERE
    `tb_unidadmedida`.`str_nombreUM` = nombreUM and
    `tb_unidadmedida`.`str_estado` = 'ACTIVO';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificarPPUM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_verificarPPUM`(
    IN idProveedor INT,
    IN idProducto INT,
    IN idUnidadMedidaVenta INT,
    IN UnidadMedidaCompra VARCHAR(45)
)
BEGIN

SELECT
    `tb_proveedorproductounidadmedida`.`int_idProveedor`,
    `tb_proveedorproductounidadmedida`.`int_idProducto`,
    `tb_proveedorproductounidadmedida`.`int_idUnidadMedidaVenta`,
    `tb_proveedorproductounidadmedida`.`str_UnidadMedidaCompra`,
    `tb_proveedorproductounidadmedida`.`dbl_costoCompra`,
    `tb_proveedorproductounidadmedida`.`dbl_unidadesContenidas`,
    `tb_proveedorproductounidadmedida`.`dbl_precioUnidadContenida`,
    `tb_proveedorproductounidadmedida`.`dbl_costoTraslado`,
    `tb_proveedorproductounidadmedida`.`dbl_precioFinal`,
    `tb_proveedorproductounidadmedida`.`str_estado`
FROM
    `bdmatriz`.`tb_proveedorproductounidadmedida`
WHERE
    `tb_proveedorproductounidadmedida`.`int_idProveedor` = idProveedor
    AND `tb_proveedorproductounidadmedida`.`int_idProducto` = idProducto
    AND `tb_proveedorproductounidadmedida`.`int_idUnidadMedidaVenta` = idUnidadMedidaVenta
    AND `tb_proveedorproductounidadmedida`.`str_UnidadMedidaCompra` = UnidadMedidaCompra;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificarTipoCambio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`agente`@`%` PROCEDURE `sp_verificarTipoCambio`(
    IN fechaDia VARCHAR(45)
)
BEGIN

SELECT
    `tb_tipocambio`.`int_idTipoCambio`,
    `tb_tipocambio`.`dbl_precioCompraDolar`,
    `tb_tipocambio`.`dbl_precioVentaDolar`,
    `tb_tipocambio`.`str_fechaDia`,
    `tb_tipocambio`.`str_estado`
FROM
    `bdmatriz`.`tb_tipocambio`
WHERE
    `tb_tipocambio`.`str_fechaDia` = fechaDia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-05 19:18:37
