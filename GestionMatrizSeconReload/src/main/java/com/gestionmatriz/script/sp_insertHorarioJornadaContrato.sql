delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertHorarioJornadaContratol`(
    IN idHorario int,
    IN idJornada int,
    IN idContrato int,
    IN estado varchar(45),    
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_horariojornadacontrato`
(`int_idHorario`,
`int_idJornada`,
`int_idContrato`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModificador`)
VALUES
(
idHorario,
idJornada,
idContrato,
estado,
(select now()),
usuarioCreador,
fechaModificacion,
usuarioModificador
);

END$$

