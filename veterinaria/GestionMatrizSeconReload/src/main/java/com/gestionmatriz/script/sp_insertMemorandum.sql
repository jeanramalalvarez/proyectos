delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertMemorandum`(
    IN idMemorandum int,
    IN numero varchar(20),
    IN emisor varchar(45),
    IN receptor varchar(45),
    IN asunto text,
    IN fecha date,
    IN cuerpo text,
    IN usuarioCreador varchar(45),
    IN usuarioModificador varchar(45),
    IN ultimaModificacion date,
    IN idPersona int
    
)
BEGIN
INSERT INTO `matriz`.`tb_memorandum`
(`int_idMemorandum`,
`str_numero`,
`str_emisor`,
`str_receptor`,
`str_asunto`,
`dte_fecha`,
`str_cuerpo`,
`str_usuarioCreador`,
`dte_fechaCreacion`,
`str_usuarioModificador`,
`dte_fechaModificacion`,
`int_idPersona`)
VALUES
(
idMemorandum,
numero,
emisor,
receptor,
asunto,
fecha,
cuerpo,
usuarioCreador,
(select now()),
usuarioModificador,
fechaModificacion,
idPersona
);

END$$

