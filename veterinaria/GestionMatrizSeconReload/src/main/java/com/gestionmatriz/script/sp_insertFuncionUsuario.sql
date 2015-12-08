delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertFuncionUsuario`(
    IN idFunciones int,
    IN idUsuario int,
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_funcionusuario`
(`int_idFunciones`,
`int_idUsuario`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_ultimaModificacion`,
`str_usuarioModificador`)
VALUES
(
idFunciones,
idUsuario,
(select now()),
usuarioCreador,
ultimaModificacion,
usuarioModificador
);

END$$

