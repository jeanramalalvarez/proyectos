delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarPersona`(
    IN apePaterno varchar(45),
    IN apeMaterno varchar(45),
    IN nombres varchar(45),
    IN DNI varchar(8)
)
BEGIN
select
`tb_persona`.`int_idPersona`,
`tb_persona`.`str_codigo`,
`tb_persona`.`str_apePaterno`,
`tb_persona`.`str_apeMaterno`,
`tb_persona`.`str_nombres`,
`tb_persona`.`str_dni`,
`tb_persona`.`str_carnetExtranjeria`,
`tb_persona`.`dte_fechaNacimiento`,
`tb_persona`.`str_ciudadNacimiento`,
`tb_persona`.`str_telefono`,
`tb_persona`.`str_movil`,
`tb_persona`.`str_sexo`,
`tb_persona`.`str_nacionalidad`,
`tb_persona`.`str_correoElectronico`,
`tb_persona`.`str_brevete`,
`tb_persona`.`str_categoriaBrevete`,
`tb_persona`.`str_estadoCivil`,
`tb_persona`.`str_direccion`,
`tb_persona`.`str_distrito`,
`tb_persona`.`str_provincia`,
`tb_persona`.`str_departamento`,
`tb_persona`.`bin_huellaDigital_1`,
`tb_persona`.`bin_huellaDigital_2`,
`tb_persona`.`str_estado`,
`tb_persona`.`dte_fechaCreacion`,
`tb_persona`.`str_usuarioCreador`,
`tb_persona`.`dte_ultimaModificacion`,
`tb_persona`.`str_usuarioModificador`
from tb_persona 
    where  str_apePaterno like apePaterno or str_apeMaterno like apeMaterno or
    str_nombres like nombres or str_dni like DNI;
END$$

