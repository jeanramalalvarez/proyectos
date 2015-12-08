delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertHorario`(
    IN idHorario int,
    IN nombreHorario varchar(45),
    IN estado varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_horario`
(`int_idHorario`,
`str_nombreHorario`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModifcador`)
VALUES
(
idHorario,
nombreHorario,
estado,
(select now()),
usuarioCreador,
fechaModificacion,
usuarioModifcador
);

END$$

