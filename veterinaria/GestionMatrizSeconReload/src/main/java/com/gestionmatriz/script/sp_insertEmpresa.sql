delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertEmpresa`(
    IN idEmpresa int,
    IN razonSocial varchar(100),
    IN ruc varchar(12),
    IN domicilioEmpresa varchar(150),
    IN representanteLegal varchar(150),
    IN dniRepresentante varchar(10),
    IN estado varchar(45),
	IN usuarioCreador varchar(45),
    IN ultimaModificacion date,
    IN usuarioModificador varchar(45)
    
    
)
BEGIN
INSERT INTO `matriz`.`tb_empresa`
(`int_idEmpresa`,
`str_razonSocial`,
`str_ruc`,
`str_domicilioEmpresa`,
`str_representanteLegal`,
`str_dniRepresentante`,
`str_estado`,
`dte_fechaCreacion`,
`str_usuarioCreador`,
`dte_fechaModificacion`,
`str_usuarioModificador`)
VALUES
(
idEmpresa,
razonSocial,
ruc,
domicilioEmpresa,
representanteLegal,
dniRepresentante,
estado,
(select now()),
usuarioCreador,
fechaModificacion,
usuarioModificador
);
END$$

