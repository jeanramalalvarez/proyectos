delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertJornada`(
    IN idJornada int,
    IN HoraInicio time,
    IN horaFin time,
    IN estado varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_jornada`
(`int_idJornada`,
`tme_HoraInicio`,
`tme_horaFin`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModificador`)
VALUES
(
idJornada,
HoraInicio,
horaFin,
estado,
(select now()),
usuarioCreador,
fechaModificacion,
suarioModificador
);
END$$

