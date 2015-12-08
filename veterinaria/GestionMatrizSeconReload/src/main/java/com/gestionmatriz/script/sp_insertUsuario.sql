delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertUsuario`(
    IN idUsuario int,
    IN idPersona int,
    IN usuario varchar(45),
    IN str_contrasenia varchar(15),
    IN estado varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_usuario`
(`int_idUsuario`,
`int_idPersona`,
`str_usuario`,
`str_contrasenia`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModificador`)
VALUES
(
idUsuario,
idPersona,
usuario,
contrasenia,
estado,
(select now()),
usuarioCreador,
fechaModificacion,
usuarioModificador
);

END$$

