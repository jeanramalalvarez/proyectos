delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertHorarioJornada`(
    IN idHorario int,
    IN idJornada int,    
    IN estado varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_horariojornada`
(`int_idHorario`,
`int_idJornada`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModificador`)
VALUES
(
idHorario,
idJornada,
estado,
(select now()),
usuarioCreador,
fechaModificacion,
usuarioModificador
);

END$$

