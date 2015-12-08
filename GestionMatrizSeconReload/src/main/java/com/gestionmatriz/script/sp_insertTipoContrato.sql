delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertTipoContrato`(
    IN idTipoContrato int,
    IN tipoContrato varchar(45),
    IN nombreReporte varchar(45),
    IN estado varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_tipocontrato`
(`int_idTipoContrato`,
`str_tipoContrato`,
`str_nombreReporte`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModificador`)
VALUES
(
idTipoContrato,
tipoContrato,
nombreReporte,
estado,
(select now()),
usuarioCreador,
fechaModificacion,
usuarioModificador
);
END$$

