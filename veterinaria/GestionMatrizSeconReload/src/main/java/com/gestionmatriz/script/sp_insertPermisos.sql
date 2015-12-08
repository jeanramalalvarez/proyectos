delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertPermisos`(
    IN idPermisos int,
    IN fecha date,
    IN motivo varchar(45),
    IN horaSalida time,
    IN horaLlegada time, 
    IN observacion text,
    IN estado varchar(45),
    IN idPersona int
    
)
BEGIN
INSERT INTO `matriz`.`tb_permisos`
(`int_idPermisos`,
`dte_fecha`,
`str_motivo`,
`tm_horaSalida`,
`tm_horaLlegada`,
`str_observacion`,
`str_estado`,
`int_idPersona`)
VALUES
(
idPermisos,
fecha,
motivo,
horaSalida,
horaLlegada,
observacion,
estado,
idPersona
);
END$$

