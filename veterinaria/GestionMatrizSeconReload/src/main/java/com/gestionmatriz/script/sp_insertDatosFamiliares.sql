delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertDatosFamiliares`(
    IN idDatosFamiliares int,
    IN idPersona int,
    IN documento varchar(45),
    IN numeroDocumento varchar(15),
    IN apePaterno varchar(45),
    IN apeMaterno varchar(45),
    IN nombres varchar(45),
    IN fechaNacimiento date,
    IN vinculo varchar(45),
    IN ocupacion varchar(45),
    IN conviven char(1),
    IN telfEmergencia varchar(15),
    IN estado varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_datosfamiliares`
(`int_idDatosFamiliares`,
`int_idPersona`,
`str_documento`,
`str_numeroDocumento`,
`str_apePaterno`,
`str_apeMaterno`,
`str_nombres`,
`dte_fechaNacimiento`,
`str_vinculo`,
`str_ocupacion`,
`str_conviven`,
`str_telfEmergencia`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_ultimaModificacion`,
`str_usuarioModificador`)
VALUES
(
idDatosFamiliares,
idPersona,
documento,
numeroDocumento,
apePaterno,
apeMaterno,
nombres,
fechaNacimiento,
vinculo,
ocupacion,
conviven,
telfEmergencia,
estado,
(select now()),
usuarioCreador,
ultimaModificacion,
usuarioModificador
);


END$$


