<%@ include file="../include/include.jsp"%>
<script type="text/javascript">

$( function(){
    $("#divlista").displayTagAjax();
	$('#divlista').css({ display: 'none' });
	$('#divlista').fadeIn(100);
	$(window).unload(function() {$('#indicador').show();} );
 });

</script>
<div id="divlista" class="tablaListado">
<!-- format="{0,date,dd/MM/yyyy}" -->
 <display:table name="sessionScope.listaPedido" pagesize="5" uid="row" requestURI="pedidoAction!paginar" excludedParams="*" export="false">
    <display:column property="nuPedi" style="width: 80px;" title="N° Pedido" headerClass="tituloTabla" sortable="true"/>
    <display:column property="fePedi" format="{0,date,dd/MM/yyyy}" style="width: 120px;" title="Fecha de Pedido" headerClass="tituloTabla" sortable="true"/>
    <display:column property="deProfInvo" title="Proforma Invoice" style="width: 140px;" headerClass="tituloTabla" sortable="true"/>
    <display:column property="deHldo" title="Hilado" headerClass="tituloTabla" sortable="true"/>
    <display:column property="noCarg" title="Cargador/Shipper" headerClass="tituloTabla" sortable="true"/>
    <display:column property="noBnco" title="Banco" headerClass="tituloTabla" sortable="true"/>			    
    
	<display:column  title="Editar" style="text-align: center; vertical-align: middle; width: 50px;" headerClass="tituloTabla">
	    <s:url id="urlcargarPedido" action="pedidoAction!cargarPedido">
          <s:param name="pedido.nuPedi" value="#attr.row.nuPedi" />
        </s:url>
	    <sj:a targets="contenido" onCompleteTopics="cargarMarcas,cargarUnidadMedida" href="%{urlcargarPedido}">Editar</sj:a>
    </display:column>
    
     <display:column title="Anular"  style="text-align: center; vertical-align: middle; width: 50px;" headerClass="tituloTabla">
      <s:url id="urlAnularPedido" action="pedidoAction!anularPedido">
        <s:param name="pedido.nuPedi" value="#attr.row.nuPedi" />
      </s:url>
      <s:a title="Anular Pedido" 
		   href="javascript:confirmarAccionAjax('%{urlAnularPedido}','divLista', '¿Desea anular el pedido?')">Eliminar
	  </s:a>
		    
	</display:column>
  </display:table>
  
</div>
<!-- PARA CUANDO LA LISTA NO TENGA PAGINACION, ESTO HACE QUE EL FONDO SE ALINIE CON LA LISTA  - INICIO -->
<s:set id="tamanioId" name="tamanioName" var="tamanioVar" scope="page" value="%{#session.listaPedido.size}" />
<s:if test="%{#session.listaPedido.size > 0  and #session.listaPedido.size == 1}">
  <div style="height: ${tamanioVar * 55}px; width:1px;" >&nbsp;</div>
</s:if>
<s:elseif test="%{#session.listaPedido.size >= 2 and #session.listaPedido.size <= 5  }">
 <div style="height: ${((tamanioVar-1) * 26) + 55}px; width:1px;" >&nbsp;</div>
</s:elseif>
<!-- PARA CUANDO LA LISTA NO TENGA PAGINACION, ESTO HACE QUE EL FONDO SE ALINIE CON LA LISTA  - FIN -->
<jsp:include page="../general/dialogoMensajes.jsp" />