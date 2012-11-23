<%@ include file="../include/include.jsp"%>
<script type="text/javascript">

 
    $(document).ready(function() {
      //$('#divListaPedido').load('${pageContext.request.contextPath}/pedidoAction!cargarListaPedido');
    });

    $(function(){
    	mostrarRutaOpcion("<tiles:getAsString name='titulo'/>");
    });

</script>
<h2>Registro de Marca</h2>
<div class="capa" >
<div id="capita" >
<s:form id="formMarca" name="formMarca" validate="true" theme="simple">
<div class="esc_for_CapaTabla">
 <table style="width: 100%" class="tablaContenedora" >
   <tr>
	    <td colspan="2"><h3 style="width: 100%;"><span>Información de Marca</span></h3></td>
   </tr>
   <tr>
		<td colspan="2">
			<table style="width: 100%; border: 1px gray solid;" class="tablaMarco">
				<tr>
					<td>Descripcion</td>
					<td id="separador">:</td>
					<td><s:textfield id="deMrca" name="marca.deMrca" cssStyle="width:400px;" /></td>
					<td colspan="4">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:110px;">Tipo de Producto</td>
					<td id="separador">:</td>		
					<td><s:select id="inTipoProd" list="#{'H':'HILO','T':'TELA'}" name="marca.inTipoProd"/></td>
					<td colspan="4">&nbsp;</td>
				</tr>
				<tr>
					<td>Estado</td>
					<td id="separador">:</td>		
					<td><s:select id="inRegiActi" list="#{'1':'HABILITADO','2':'DESHABILITADO'}" name="marca.inRegiActi"/></td>
					<td colspan="4">&nbsp;</td>
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
               <sj:a id="btnGrabar" 
                     title="Grabar Marca"
                     formIds="formMarca" 
		             targets="contenido"
		             href="mntMarcaAction!registrar"
                     button="true">
                     <span>Grabar Marca</span>
                </sj:a>
            </li>
            <li>
               <sj:a id="btnCancelar" 
                     title="Cancelar" 
                     button="true"
                     href="mntMarcaAction"
                     targets="contenido"
                     formIds="formMarca">
                     <span>Cancelar</span>
                </sj:a>
            </li>
            <li>&nbsp;</li>
          </ul>
        </td>
      </tr>
    </table>
</div>
</s:form>
</div>
<jsp:include page="../general/dialogoMensajes.jsp" />
</div>