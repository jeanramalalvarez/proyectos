delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertContrato`(
    IN idContrato int,
    IN idPersona int,
    IN idTipoContrato int,
    IN idEmpresa int,
    IN fechaInicial date,
    IN fechaFinal date,
    IN sueldo Double,
    IN estado varchar(45),    
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_contrato`
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
`dte_ultimaModificacion`,
`str_usuarioModificador`)
VALUES
(
idContrato,
idPersona,
idTipoContrato,
idEmpresa,
fechaInicial,
fechaFinal,
sueldo,
estado,
(select now()),
usuarioCreador,
ultimaModificacion,
usuarioModificador
);

END$$

