delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertModulo`(
    IN modulo int,    
    IN descripcion varchar(45)
        
)
BEGIN
INSERT INTO `matriz`.`tb_modulo`
(`int_modulo`,
`str_descripcion`)
VALUES
(
modulo,
descripcion
);
END$$

