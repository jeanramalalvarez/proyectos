CREATE DEFINER=`agente`@`%` PROCEDURE `sp_consultaStock`(
in ilocal int,
in producto varchar(100),
in producto2 varchar(100)
)
BEGIN


select
p.int_idProducto codigo,
p.str_nombreProducto nombre,
p.str_fabricante fabricante,
pro.int_idProveedor as 'Codigo Proveedor',
pro.str_razonSocial proveedor,
um.int_idUnidadMedida CUM,
um.str_nombreUM UM,

-- ppum.dbl_precioFinal,
ROUND ((ppum.dbl_precioUnidadContenida*(1+(mr.dbl_utilidad/100))+dbl_costoTraslado)*(1+(mr.dbl_adicional/100)),2) as precio,
-- (( (ppum.dbl_precioUnidadContenida*(1+(mr.dbl_utilidad/100)  ) )+dbl_costoTraslado)*(1+(mr.dbl_adicional/100)))
(sum(a.dbl_cantidad))*ppum.dbl_unidadesContenidas as stock,
ppum.dbl_unidadesContenidas as stockUnidadCompra,
p.str_reintegrotributario as reintegro,
mr.dbl_adicional,
ppum.dbl_precioOferta,
p.str_codigoInterno -- Agregado Para habilitar la busqueda por codigo de producto
-- Inicio JRAMAL 
,p.int_idFamilia
-- Fin JRAMAL 
from tb_producto p, tb_proveedorproducto pp,
     tb_unidadmedida um, tb_almacen a, tb_proveedorproductounidadmedida ppum,
     tb_proveedor pro,  tb_medidarotacion mr
where p.int_idProducto=pp.int_idProducto and pro.int_idProveedor=pp.int_idProveedor and
      ppum.int_idUnidadMedidaVenta=um.int_idUnidadMedida and (a.int_idProveedor=pro.int_idProveedor and
      a.int_idProducto=p.int_idProducto) and
      (ppum.int_idProveedor=pro.int_idProveedor and ppum.int_idProducto=p.int_idProducto and um.int_idUnidadMedida=ppum.int_idUnidadMedidaVenta) and
      mr.int_idMedidaRotacion=p.int_idMedidaRotacion and
      (((p.str_nombreProducto like concat('%',producto,'%')) and (p.str_nombreProducto like concat('%',producto2,'%'))) or (p.str_codigoInterno=producto))and
      a.int_idLocal=ilocal
      AND a.str_estado = 'ACTIVO'
group by ppum.int_idUnidadMedidaVenta, ppum.int_idProducto

-- Inicio JRAMAL 
-- para listar servicios
UNION ALL

select
p.int_idProducto codigo,
p.str_nombreProducto nombre,
IFNULL(p.str_fabricante, '') fabricante,
null 'Codigo Proveedor',
'' proveedor,
um.int_idUnidadMedida CUM,
um.str_nombreUM UM,
0 precio,
1 stock,
0 stockUnidadCompra,
IFNULL(p.str_reintegrotributario, 'NO') reintegro,
mr.dbl_adicional,
0 dbl_precioOferta,
p.str_codigoInterno -- Agregado Para habilitar la busqueda por codigo de producto
-- Inicio JRAMAL 
,p.int_idFamilia
-- Fin JRAMAL 
from tb_producto p, 
     tb_unidadmedida um, 
     tb_medidarotacion mr
where 1 = 1
and um.int_idUnidadMedida=p.int_idUnidadMedida
and mr.int_idMedidaRotacion=p.int_idMedidaRotacion 
and (((p.str_nombreProducto like concat('%',producto,'%')) 
and (p.str_nombreProducto like concat('%',producto2,'%'))) or (p.str_codigoInterno=producto))
AND p.str_estado = 'ACTIVO'
-- Fin JRAMAL

order by stock desc
limit 100;


END