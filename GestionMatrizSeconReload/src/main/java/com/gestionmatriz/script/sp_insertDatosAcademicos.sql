delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertDatosAcademicos`(
    IN int_idPersona int,
    IN str_nivel varchar(45),
    IN str_institucionEducativa varchar(45),
    IN dte_inicio date,
    IN dte_termino date,
    IN str_observacion varchar(45),
    IN str_gradoTitulo varchar(45),
    IN str_estado varchar(45),
    IN str_usuarioCreador varchar(45),
    IN dte_ultimaModificacion date,
    IN str_usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_datosacademicos`
(`int_idPersona`,
`str_nivel`,
`str_institucionEducativa`,
`dte_inicio`,
`dte_termino`,
`str_observacion`,
`str_gradoTitulo`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_ultimaModificacion`,
`str_usuarioModificador`)
VALUES
(
int_idPersona,
str_nivel,
str_institucionEducativa,
dte_inicio,
dte_termino,
str_observacion,
str_gradoTitulo,
str_estado,
(select now()),
str_usuarioCreador,
dte_ultimaModificacion,
str_usuarioModificador
);

END$$

