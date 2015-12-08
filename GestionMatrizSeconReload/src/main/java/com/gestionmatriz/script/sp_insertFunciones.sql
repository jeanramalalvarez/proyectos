delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertFunciones`(
    IN idFunciones int,    
    IN rol varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45),
    IN modulo int,
    IN skey varchar(10)
    
)
BEGIN
INSERT INTO `matriz`.`tb_funciones`
(`int_idFunciones`,
`str_rol`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_ultimaModificacion`,
`str_usuarioModificador`,
`int_modulo`,
`str_skey`)
VALUES
(
idFunciones,
rol,
(select now()),
usuarioCreador,
ultimaModificacion,
usuarioModificador,
modulo,
skey
);
END$$

