-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.16


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema crexsa
--

CREATE DATABASE IF NOT EXISTS crexsa;
USE crexsa;

--
-- Definition of table `banco`
--

DROP TABLE IF EXISTS `banco`;
CREATE TABLE `banco` (
  `id_bnco` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `no_bnco` varchar(80) DEFAULT NULL,
  `in_regi_acti` char(1) DEFAULT '1',
  `co_usua_crea` varchar(20) DEFAULT NULL,
  `fe_usua_crea` datetime DEFAULT NULL,
  `co_usua_modi` varchar(20) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  PRIMARY KEY (`id_bnco`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `banco`
--

/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
INSERT INTO `banco` (`id_bnco`,`no_bnco`,`in_regi_acti`,`co_usua_crea`,`fe_usua_crea`,`co_usua_modi`,`fe_usua_modi`) VALUES 
 (1,'Banco de Crédito','1',NULL,NULL,NULL,NULL),
 (2,'Banco Continental','1',NULL,NULL,NULL,NULL),
 (3,'Banco Scotiabank','1',NULL,NULL,NULL,NULL),
 (4,'Banco de la Nación','1',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;


--
-- Definition of table `color`
--

DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `id_colo` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `de_colo` int(11) DEFAULT NULL,
  `in_regi_acti` char(1) DEFAULT '1',
  `co_usua_crea` varchar(20) DEFAULT NULL,
  `fe_usua_crea` varchar(45) DEFAULT NULL,
  `co_usua_modi` varchar(20) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  `de_term_crea` varchar(20) DEFAULT NULL,
  `de_term_modi` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_colo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `color`
--

/*!40000 ALTER TABLE `color` DISABLE KEYS */;
/*!40000 ALTER TABLE `color` ENABLE KEYS */;


--
-- Definition of table `entidad`
--

DROP TABLE IF EXISTS `entidad`;
CREATE TABLE `entidad` (
  `id_enti` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `de_enti` varchar(50) DEFAULT NULL,
  `in_regi_acti` char(1) DEFAULT NULL,
  `usua_crea` varchar(20) DEFAULT NULL,
  `fe_usua_crea` datetime DEFAULT NULL,
  `usua_modi` varchar(20) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  PRIMARY KEY (`id_enti`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `entidad`
--

/*!40000 ALTER TABLE `entidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `entidad` ENABLE KEYS */;


--
-- Definition of table `hilado`
--

DROP TABLE IF EXISTS `hilado`;
CREATE TABLE `hilado` (
  `id_hldo` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `co_hldo` varchar(10) DEFAULT NULL,
  `nu_pedi` int(11) unsigned DEFAULT NULL,
  `fe_rece` date DEFAULT NULL,
  `de_come_invo` varchar(50) DEFAULT NULL,
  `nu_cont` varchar(50) DEFAULT NULL,
  `de_bill_ladi` varchar(40) DEFAULT NULL,
  `no_nave` varchar(30) DEFAULT NULL,
  `co_unid_medi` varchar(5) DEFAULT NULL,
  `nu_cant_neto` decimal(9,2) DEFAULT NULL,
  `de_doc_dhl` varchar(30) DEFAULT NULL,
  `id_marc` int(11) DEFAULT NULL,
  `de_obse` varchar(100) DEFAULT NULL,
  `id_tipo_tran` int(11) unsigned DEFAULT NULL,
  `co_esta_pedi` char(1) DEFAULT NULL COMMENT 'Código de estado del pedido.',
  PRIMARY KEY (`id_hldo`) USING BTREE,
  KEY `fk_HILADO_PEDIDO1_idx` (`nu_pedi`),
  KEY `fk_Hilado_Transaccion_idx` (`id_tipo_tran`) USING BTREE,
  CONSTRAINT `FK_hilado_1` FOREIGN KEY (`id_tipo_tran`) REFERENCES `tipo_transaccion` (`id_tipo_tran`),
  CONSTRAINT `FK_hilado_2` FOREIGN KEY (`nu_pedi`) REFERENCES `pedido` (`nu_pedi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hilado`
--

/*!40000 ALTER TABLE `hilado` DISABLE KEYS */;
/*!40000 ALTER TABLE `hilado` ENABLE KEYS */;


--
-- Definition of table `movimiento_historico_hilado`
--

DROP TABLE IF EXISTS `movimiento_historico_hilado`;
CREATE TABLE `movimiento_historico_hilado` (
  `id_movi_hist` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_tipo_tran` int(11) unsigned NOT NULL DEFAULT '0',
  `id_hldo` int(11) unsigned NOT NULL DEFAULT '0',
  `co_unid_medi` varchar(45) NOT NULL,
  `co_enti_dest` varchar(45) NOT NULL,
  `co_enti_orig` varchar(45) NOT NULL,
  `nu_sald` decimal(9,2) NOT NULL,
  `nu_cant` decimal(9,2) NOT NULL,
  `fe_movi` datetime NOT NULL,
  PRIMARY KEY (`id_movi_hist`),
  KEY `FK_movimiento_historico_hilado_1` (`id_tipo_tran`),
  KEY `FK_movimiento_historico_hilado_2` (`id_hldo`),
  CONSTRAINT `FK_movimiento_historico_hilado_1` FOREIGN KEY (`id_tipo_tran`) REFERENCES `tipo_transaccion` (`id_tipo_tran`),
  CONSTRAINT `FK_movimiento_historico_hilado_2` FOREIGN KEY (`id_hldo`) REFERENCES `hilado` (`id_hldo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movimiento_historico_hilado`
--

/*!40000 ALTER TABLE `movimiento_historico_hilado` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimiento_historico_hilado` ENABLE KEYS */;


--
-- Definition of table `movimiento_ultimo_hilado`
--

DROP TABLE IF EXISTS `movimiento_ultimo_hilado`;
CREATE TABLE `movimiento_ultimo_hilado` (
  `id_movi_ulti` int(11) unsigned NOT NULL,
  `id_movi_hist` int(11) unsigned NOT NULL,
  `id_tipo_tran` int(11) unsigned NOT NULL DEFAULT '0',
  `id_hldo` int(11) unsigned NOT NULL DEFAULT '0',
  `co_unid_medi` varchar(45) DEFAULT NULL,
  `co_enti_dest` varchar(10) DEFAULT NULL,
  `co_enti_orig` varchar(10) DEFAULT NULL,
  `fe_movi` datetime DEFAULT NULL,
  `nu_sald` decimal(9,2) DEFAULT NULL,
  `nu_cant` decimal(9,2) DEFAULT NULL,
  PRIMARY KEY (`id_movi_ulti`),
  KEY `FK_movimiento_ultimo_hilado_1` (`id_movi_hist`),
  KEY `FK_movimiento_ultimo_hilado_2` (`id_tipo_tran`),
  KEY `FK_movimiento_ultimo_hilado_3` (`id_hldo`),
  CONSTRAINT `FK_movimiento_ultimo_hilado_1` FOREIGN KEY (`id_movi_hist`) REFERENCES `movimiento_historico_hilado` (`id_movi_hist`),
  CONSTRAINT `FK_movimiento_ultimo_hilado_2` FOREIGN KEY (`id_tipo_tran`) REFERENCES `tipo_transaccion` (`id_tipo_tran`),
  CONSTRAINT `FK_movimiento_ultimo_hilado_3` FOREIGN KEY (`id_hldo`) REFERENCES `hilado` (`id_hldo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movimiento_ultimo_hilado`
--

/*!40000 ALTER TABLE `movimiento_ultimo_hilado` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimiento_ultimo_hilado` ENABLE KEYS */;


--
-- Definition of table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `nu_pedi` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fe_pedi` date DEFAULT NULL,
  `de_prof_invo` varchar(50) DEFAULT NULL,
  `id_tipo_hldo` int(11) unsigned DEFAULT NULL,
  `no_carg` varchar(50) DEFAULT NULL,
  `nu_cost_cif` decimal(9,2) DEFAULT NULL,
  `nu_cost_tota` decimal(9,2) DEFAULT NULL,
  `nu_prec_vent` decimal(9,2) DEFAULT NULL,
  `nu_cant_pedi` decimal(9,2) DEFAULT NULL,
  `nu_tota_pedi` decimal(9,2) DEFAULT NULL,
  `nu_adel_pedi` decimal(9,2) DEFAULT NULL,
  `co_usua_crea` varchar(20) DEFAULT NULL,
  `fe_usua_crea` datetime DEFAULT NULL,
  `co_usua_modi` varchar(20) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  `in_regi_acti` char(1) DEFAULT '1',
  `de_obse_pedi` varchar(100) DEFAULT NULL,
  `co_unid_medi` varchar(3) DEFAULT NULL,
  `co_marc_prod` varchar(50) DEFAULT NULL,
  `id_bnco` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`nu_pedi`),
  KEY `fk_PEDIDO_TIPO_HILADO1_idx` (`id_tipo_hldo`) USING BTREE,
  KEY `FK_pedido_1` (`id_bnco`),
  CONSTRAINT `FK_pedido_1` FOREIGN KEY (`id_bnco`) REFERENCES `banco` (`id_bnco`),
  CONSTRAINT `FK_pedido_2` FOREIGN KEY (`id_tipo_hldo`) REFERENCES `tipo_hilado` (`id_tipo_hldo`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedido`
--

/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` (`nu_pedi`,`fe_pedi`,`de_prof_invo`,`id_tipo_hldo`,`no_carg`,`nu_cost_cif`,`nu_cost_tota`,`nu_prec_vent`,`nu_cant_pedi`,`nu_tota_pedi`,`nu_adel_pedi`,`co_usua_crea`,`fe_usua_crea`,`co_usua_modi`,`fe_usua_modi`,`in_regi_acti`,`de_obse_pedi`,`co_unid_medi`,`co_marc_prod`,`id_bnco`) VALUES 
 (82,'2012-11-15','10',1,'SDFG','10.00','13.20','13.70','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'0','SDFG','','',2),
 (83,'2012-11-15','SDFGSD',1,'SDFG','10.00','13.20','13.70','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'0','SDFG','','',4),
 (84,'2012-11-15','SSDFG',1,'SDFG','102.00','134.64','135.14','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'0','SDFG','','',1),
 (85,'2012-11-15','DSDF',1,'ASDF','10.00','13.20','13.70','10.00','100.00','15.00',NULL,NULL,NULL,NULL,'0','ASDFASD','','asdfasdf',3),
 (86,'2012-11-15','GH',2,'ASDF','1.00','1.32','1.82','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'0','ASDF','','sdfas',4),
 (87,'2012-11-15','DSFG',2,'ASDF','10.00','13.20','13.70','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'0','ASDFASD','','',3),
 (88,'2012-11-16','SFG',1,'SDFG','10.00','13.20','13.70','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'0','SDFG','','asdfasd',2),
 (89,'2012-11-16','ASDF',2,'ASDF','5.00','6.60','7.10','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'1','ASDF','','',1),
 (90,'2012-11-16','ASDF',2,'ASDF','3.00','3.96','4.46','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'1','ASDF','','',3),
 (91,'2012-11-16','ASFD',1,'ASDF','5.00','6.60','7.10','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'1','ADSF','','',2),
 (92,'2012-11-16','ADSF',1,'ASDF','10.00','13.20','13.70','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'0','ASDF','','',1),
 (93,'2012-11-16','ASDF',2,'ADSF','1.00','1.32','1.82','1.00','0.00','0.00',NULL,NULL,NULL,NULL,'0','ADFA','','',2),
 (94,'2012-11-16','ASDF',1,'ASDF','3.00','3.96','4.46','10.00','0.00','0.00',NULL,NULL,NULL,NULL,'1','ASDF','','',3);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;


--
-- Definition of table `tipo_hilado`
--

DROP TABLE IF EXISTS `tipo_hilado`;
CREATE TABLE `tipo_hilado` (
  `co_tipo_hldo` varchar(10) NOT NULL,
  `de_hldo` varchar(50) DEFAULT NULL,
  `de_titu_hldo` varchar(10) DEFAULT NULL,
  `in_regi_acti` char(1) DEFAULT '1',
  `co_usua_crea` varchar(20) DEFAULT NULL,
  `fe_usua_crea` datetime DEFAULT NULL,
  `co_usua_modi` varchar(20) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  `id_tipo_hldo` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_tipo_hldo`) USING BTREE,
  UNIQUE KEY `codiHilado_UNIQUE` (`co_tipo_hldo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_hilado`
--

/*!40000 ALTER TABLE `tipo_hilado` DISABLE KEYS */;
INSERT INTO `tipo_hilado` (`co_tipo_hldo`,`de_hldo`,`de_titu_hldo`,`in_regi_acti`,`co_usua_crea`,`fe_usua_crea`,`co_usua_modi`,`fe_usua_modi`,`id_tipo_hldo`) VALUES 
 ('HLO2410001','Polyester Texturizado 24/1','24/1','1','rmarquez',NULL,NULL,NULL,1),
 ('POL3610001','Polyester Texturizado 36/1','36/1','1','rmarquez',NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `tipo_hilado` ENABLE KEYS */;


--
-- Definition of table `tipo_tela`
--

DROP TABLE IF EXISTS `tipo_tela`;
CREATE TABLE `tipo_tela` (
  `id_tipo_tela` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `de_tela` varchar(45) DEFAULT NULL,
  `de_titu_tela` varchar(45) DEFAULT NULL,
  `co_usua_crea` varchar(20) DEFAULT NULL,
  `fe_usua_crea` datetime DEFAULT NULL,
  `co_usua_modi` varchar(20) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  `in_regi_acti` char(1) DEFAULT '1',
  `co_proc` char(1) DEFAULT NULL COMMENT 'Codigo de proceso= \\"C\\" Crudo, \\"T\\" Teñido.',
  `id_colo` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_tipo_tela`) USING BTREE,
  KEY `FK_tipo_tela_1` (`id_colo`),
  CONSTRAINT `FK_tipo_tela_1` FOREIGN KEY (`id_colo`) REFERENCES `color` (`id_colo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_tela`
--

/*!40000 ALTER TABLE `tipo_tela` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_tela` ENABLE KEYS */;


--
-- Definition of table `tipo_transaccion`
--

DROP TABLE IF EXISTS `tipo_transaccion`;
CREATE TABLE `tipo_transaccion` (
  `id_tipo_tran` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `de_tran` varchar(45) DEFAULT NULL,
  `in_regi_activo` varchar(45) DEFAULT NULL COMMENT 'Indicador de Registro = \\"1\\" - Activo, \\"0\\" - Inactivo\\n',
  `fe_usua_crea` datetime DEFAULT NULL,
  `co_usua_crea` varchar(20) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  `co_usua_modi` varchar(20) DEFAULT NULL,
  `co_tipo_tran` char(1) DEFAULT NULL COMMENT 'Tipo de Transaccion = Entrada \\"E\\" o  Salida \\"S\\"',
  PRIMARY KEY (`id_tipo_tran`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_transaccion`
--

/*!40000 ALTER TABLE `tipo_transaccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_transaccion` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `co_usua` varchar(20) NOT NULL,
  `de_pass_usua` varchar(20) DEFAULT NULL,
  `in_regi_acti` char(1) DEFAULT '1',
  `fe_usua_crea` datetime DEFAULT NULL,
  `usua_crea` varchar(20) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  `usua_modi` varchar(20) DEFAULT NULL,
  `id_usua` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_usua`) USING BTREE,
  UNIQUE KEY `co_usua_UNIQUE` (`co_usua`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`co_usua`,`de_pass_usua`,`in_regi_acti`,`fe_usua_crea`,`usua_crea`,`fe_usua_modi`,`usua_modi`,`id_usua`) VALUES 
 ('1','1','1',NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
