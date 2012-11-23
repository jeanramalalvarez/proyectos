<%@ include file="../include/include.jsp"%>
<script type="text/javascript">

 
    $(document).ready(function() {
      //$('#divListaPedido').load('${pageContext.request.contextPath}/pedidoAction!cargarListaPedido');
    });

    $(function(){
    	mostrarRutaOpcion("<tiles:getAsString name='titulo'/>");
    	fLimpiar();
    });

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

</script>
<h2>Busqueda de Pedidos</h2>
<div class="capa" >
<s:form id="formPedido" name="formPedido" validate="true" theme="simple" >
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
					<td style="width: 10%"><s:select id="selectCriterio" list="#{'1':'Nº Pedido', '2':'Fechas'}" name="selectCriterio"/></td>
					<td id="tdFechas" style="width: 35%; display: none;">					    
					    del: <sj:datepicker id="fecInicial" name="busqueda.fecInicial" maxDate="+0d" />
					    al: <sj:datepicker id="fecFinal" name="busqueda.fecFinal" maxDate="+0d" />
					</td>
					<td id="tdCampo" style="width: 13%;">	
					<s:textfield id="nuPedi" name="busqueda.nuPedi"/>
					</td>
					<td><sj:a id="btnBuscar" 
                              title="Buscar Pedido"
                              formIds="formPedido" 
		                      targets="divLista"
		                      href="pedidoAction!buscarPedido"
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
                     title="Nuevo Pedido" 
                     button="true"
                     href="pedidoAction!cargarRegistro"
                     targets="contenido"
                     formIds="formPedido">
                     <span>Nuevo Pedido</span>
                </sj:a>
            </li>
            <li>&nbsp;</li>
          </ul>
        </td>
      </tr>
    </table>
</div>
</s:form>
<h4>Listado de Pedidos</h4>
<sj:div id="divLista" reloadTopics="rtdivLista" href="pedidoAction!cargarListaPedido"></sj:div>
<br />
</div>
<jsp:include page="../general/dialogoMensajes.jsp" />