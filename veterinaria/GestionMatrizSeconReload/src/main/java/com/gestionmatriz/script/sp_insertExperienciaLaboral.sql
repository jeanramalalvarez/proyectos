delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertExperienciaLaboral`(
    IN idExperienciaLaboral int,
    IN idPersona int,
    IN empresa varchar(45),
    IN rubro varchar(45),
    IN cargo varchar(45),
    IN funciones varchar(45),
    IN fechaInicio date,
    IN fechaFin date,
    IN sueldo varchar(45),
    IN jefeInmediato varchar(45),
    IN telfEmpresa varchar(45),
    IN motivoCese varchar(45),
    IN estado varchar(45),
    IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
)
BEGIN
INSERT INTO `matriz`.`tb_experiencialaboral`
(`int_idExperienciaLaboral`,
`int_idPersona`,
`str_empresa`,
`str_rubro`,
`str_cargo`,
`str_funciones`,
`dte_fechaInicio`,
`dte_fechaFin`,
`str_sueldo`,
`str_jefeInmediato`,
`str_telfEmpresa`,
`str_motivoCese`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModificador`)
VALUES
(
idExperienciaLaboral,
idPersona,
empresa,
rubro,
cargo,
funciones,
fechaInicio,
fechaFin,
sueldo,
jefeInmediato,
telfEmpresa,
motivoCese,
estado,
(select now()),
usuarioCreador,
fechaModificacion,
usuarioModificador
);


END$$

