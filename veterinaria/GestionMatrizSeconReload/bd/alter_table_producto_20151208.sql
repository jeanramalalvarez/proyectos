ALTER TABLE `bdmatriz_desa`.`tb_producto` 
ADD COLUMN `str_tipoProducto` CHAR(1) NOT NULL DEFAULT 'P' COMMENT '' AFTER `dte_fechaModificacion`,
ADD COLUMN `int_idTipoServicio` INT(11) NULL COMMENT '' AFTER `str_tipoProducto`;