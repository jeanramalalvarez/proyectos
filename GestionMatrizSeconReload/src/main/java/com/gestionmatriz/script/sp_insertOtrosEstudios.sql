delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertOtrosEstudios`(
    IN idOtrosEstudios int,
    IN idPersona int,
    IN estudio varchar(45),
    IN nivelEstudio varchar(45),        
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_otrosestudios`
(`int_idOtrosEstudios`,
`int_idPersona`,
`str_estudio`,
`str_nivelEstudio`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_ultimaModificacion`,
`str_usuarioModificador`)
VALUES
(
idOtrosEstudios,
idPersona,
estudio,
nivelEstudio,
(select now()),
usuarioCreador,
ultimaModificacion,
usuarioModificador
);

END$$