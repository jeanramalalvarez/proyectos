delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertTipoMarcado`(
    IN tipoMarcado int,    
    IN descripcion varchar(1)
        
)
BEGIN
INSERT INTO `matriz`.`tb_tipomarcado`
(`int_tipoMarcado`,
`str_descripcion`)
VALUES
(
tipoMarcado,
descripcion
);
END$$

