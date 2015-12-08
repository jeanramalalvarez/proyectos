delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertAsistencia`(
    IN asistencia int,
    IN idHorario int,
    IN idJornada int,
    IN idContrato int,
    IN fecha date,
    IN hora time,
    IN tipoMarcado int,
    IN estadoMarcado varchar(1)
    
)
BEGIN
INSERT INTO `matriz`.`tb_asistencia`
(`int_asistencia`,
`int_idHorario`,
`int_idJornada`,
`int_idContrato`,
`dte_fecha`,
`tm_hora`,
`int_tipoMarcado`,
`str_estadoMarcado`)
VALUES
(
asistencia,
idHorario,
idJornada,
idContrato,
fecha,
hora,
tipoMarcado,
estadoMarcado
);
END$$

