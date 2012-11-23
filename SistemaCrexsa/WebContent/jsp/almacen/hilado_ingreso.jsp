<%@ include file="../include/include.jsp"%>
<script type="text/javascript">

 
    $(document).ready(function() {
      //$('#divListaPedido').load('${pageContext.request.contextPath}/pedidoAction!cargarListaPedido');
    });

    $(function(){
    	mostrarRutaOpcion("<tiles:getAsString name='titulo'/>");
    	fLimpiar();
    });

    function fLimpiar(){
        //$('#txtNoRol').val("");
        //$('#txtNoRol').focus();
    }

</script>
<h2>Ingreso de Hilado</h2>
<div class="capa" style="">
<s:form id="formHilado" name="formHilado" validate="true" theme="simple" action="pedidoAction!registrar">
<div class="esc_for_CapaTabla">
 <table style="width: 25%" class="tablaContenedora" >
   <tr>
	    <td style="width: 120px;">Tipo de Transaccion :</td>
	    <td>
	            <sj:select id="cboTipoTransaccion"
                   name="tipoTransaccion.idTipoTran" 
                   href="tipoTransaccionAction!cargarListaTransaccion" 
	               list="listaTipoTransaccion"	               
	               listKey="idTipoTran" 
	               listValue="deTran"
	               headerKey="0"
	               headerValue="-- Seleccione --"
	               onChangeTopics="rtdivListaPedido1"
	               formIds="formHilado"
	               />
	    </td>
   </tr>	
</table>
</div>
</s:form>
<br /><br /><br /><br />
<sj:div id="divListaPedido1" reloadTopics="rtdivListaPedido1" formIds="formHilado" deferredLoading="true" href="hiladoAction!mostrarPaginaRegistro"></sj:div>
<br />
</div>
<jsp:include page="../general/dialogoMensajes.jsp" />