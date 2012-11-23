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
 <display:table name="sessionScope.listaMarcas" pagesize="10" uid="row" requestURI="mntMarcaAction!paginar" excludedParams="*" export="false">
    <display:column property="idMrca" title="N°" style="width: 40px;" headerClass="tituloTabla" sortable="true"/>
    <display:column property="deMrca" title="Marca"  headerClass="tituloTabla" sortable="true"/>
    <display:column property="inTipoProd" title="Tipo Producto" style="width: 120px;" headerClass="tituloTabla" sortable="true"/>
    <display:column property="inRegiActi" title="Estado" style="width: 90px;" headerClass="tituloTabla" sortable="true"/>			    
    
	<display:column  title="Editar" style="text-align: center; vertical-align: middle; width: 50px;" headerClass="tituloTabla">
	    <s:url id="urlcargar" action="mntMarcaAction!cargarMarca">
          <s:param name="marca.idMrca" value="#attr.row.idMrca" />
        </s:url>
	    <sj:a targets="contenido" href="%{urlcargar}">Editar</sj:a>
    </display:column>

  </display:table>
  
</div>
<!-- PARA CUANDO LA LISTA NO TENGA PAGINACION, ESTO HACE QUE EL FONDO SE ALINIE CON LA LISTA  - INICIO -->
<s:set id="tamanioId" name="tamanioName" var="tamanioVar" scope="page" value="%{#session.listaMarcas.size}" />
<s:if test="%{#session.listaMarcas.size > 0  and #session.listaMarcas.size == 1}">
  <div style="height: ${tamanioVar * 55}px; width:1px;" >&nbsp;</div>
</s:if>
<s:elseif test="%{#session.listaMarcas.size >= 2 and #session.listaMarcas.size <= 5  }">
 <div style="height: ${((tamanioVar-1) * 26) + 55}px; width:1px;" >&nbsp;</div>
</s:elseif>
<!-- PARA CUANDO LA LISTA NO TENGA PAGINACION, ESTO HACE QUE EL FONDO SE ALINIE CON LA LISTA  - FIN -->
<jsp:include page="../general/dialogoMensajes.jsp" />