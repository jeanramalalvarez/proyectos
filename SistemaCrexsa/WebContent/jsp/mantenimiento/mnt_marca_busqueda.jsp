<%@ include file="../include/include.jsp"%>
<script type="text/javascript">

 
    $(document).ready(function() {
      //$('#divListaPedido').load('${pageContext.request.contextPath}/pedidoAction!cargarListaPedido');
    });

    $(function(){
    	mostrarRutaOpcion("<tiles:getAsString name='titulo'/>");
    	fLimpiar();
    });
    /*
    $('#selectCriterio').change(function() {
    	  var selectCriterio = $('#selectCriterio').val();
          if(selectCriterio == 1){
        	 $('#fecInicial').val("");
        	 $('#fecFinal').val("");
        	 $('#tdFechas').css("display","none");
      	     $('#tdCampo').css("display","");
          }else{
        	 $('#nuPedi').val("");
        	 $('#tdCampo').css("display","none");
     	     $('#tdFechas').css("display","");
          }
    });
    */
</script>
<h2>Busqueda de Marcas</h2>
<div class="capa" >
<s:form id="formMarca" name="formMarca" validate="true" theme="simple" >
<s:hidden id="hdInRegiActi" name="pedido.inRegiActi" value="1"/>
<div class="esc_for_CapaTabla">
 <table style="width: 100%" class="tablaContenedora" >
   <tr>
	    <td colspan="2"><h3 style="width: 100%;"><span>Seleccion de Criterio</span></h3></td>
   </tr>
   <tr>
		<td colspan="2">
			<table style="width: 100%; border: 1px gray solid;" class="tablaMarco">
				<tr>
					<td style="width: 7%">Buscar Por</td>
					<td id="separador" style="width: 1%">:</td>
					<td style="width: 10%"><s:select id="selectCriterio" list="#{'1':'Marca'}" name="selectCriterio"/></td>
					<td id="tdCampo" style="width: 13%;">	
					<s:textfield id="deMrca" name="busqueda.deMrca"/>
					</td>
					<td><sj:a id="btnBuscar" 
                              title="Buscar Marca"
                              formIds="formMarca" 
		                      targets="divLista"
		                      href="mntMarcaAction!buscarMarca"
                              button="true">
                         <span>Buscar</span>
                         </sj:a>
                    </td>
                    <td>&nbsp;</td>
					
				</tr>
			</table>
		</td>
	</tr>
	
</table>
<br />
</div>
<div class="esc_for_capaEnlace" style="width:100%; margin: 0 auto;">
    <table summary="Contenedor Botones" class="tablaAnchoAjustable" style="margin: 0 auto;">
      <tr>
        <td>
          <ul class="enlacesCentroAjustables">
            <li>
               <sj:a id="btnNuevo" 
                     title="Nueva Marca" 
                     button="true"
                     href="mntMarcaAction!cargarRegistro"
                     targets="contenido"
                     formIds="formMarca">
                     <span>Nueva Marca</span>
                </sj:a>
            </li>
            <li>&nbsp;</li>
          </ul>
        </td>
      </tr>
    </table>
</div>
</s:form>
<h4>Listado de Marcas</h4>
<sj:div id="divLista" reloadTopics="rtdivLista" href="mntMarcaAction!cargarListaMarca"></sj:div>
<br />
</div>
<jsp:include page="../general/dialogoMensajes.jsp" />