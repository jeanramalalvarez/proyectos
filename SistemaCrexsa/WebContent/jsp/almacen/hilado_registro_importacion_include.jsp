<%@ include file="../include/include.jsp"%>
<script type="text/javascript">

 
    $(document).ready(function() {
      //$('#divListaPedido').load('${pageContext.request.contextPath}/pedidoAction!cargarListaPedido');
    });

</script>
<s:form id="formHilado" name="formHilado" validate="true" theme="simple" action="hiladoAction!registrar">
<s:hidden id="hdInRegiActi" name="pedido.inRegiActi" value="1"/>
<div class="esc_for_CapaTabla">
 <table style="width: 100%" class="tablaContenedora" >
   <tr>
	    <td colspan="2"><h3 style="width: 100%;"><span>Compra por Importación</span></h3></td>
   </tr>
  
   <tr>
		<td colspan="2">
			<table style="width: 100%; border: 1px gray solid;" class="tablaMarco">
				<tr>
					<td>Número de Pedido</td>
					<td id="separador">:</td>
					<td>
						<sj:autocompleter id="nuPedi"
						                  formIds="formPedido"
										  list="%{#session.listaTipoHilados}"
										  listKey="idTipoHldo"
										  listValue="deHldo"
										  name="pedido.nuPedi"
										  emptyOption="true"
										  delay="50"
								    	  loadMinimumCount="2"
								    	  onChangeTopics="cargarMarcas,cargarUnidadMedida"
								    	  placeholder="Ingrese Hilado"
								    	  selectBox="true"
								    	  selectBoxIcon="true"
								    	   />

						
					</td>
					<td colspan="4">&nbsp;</td>
					<td>Fecha de Pedido</td>
					<td id="separador">:</td>
					<td><sj:datepicker id="fePedi" name="pedido.fePedi" maxDate="+0d" cssClass="campoFecha"/></td>
				</tr>
				<tr>
					<td>C/I</td>
					<td id="separador">:</td>		
					<td><s:textfield id="comeInvo" name="pedido.noCarg" cssClass="campoGeneral" /></td>
					<td colspan="4">&nbsp;</td>
					<td>N° Container</td>
					<td id="separador">:</td>		
					<td><s:textfield id="nuCont" name="pedido.deProfInvo" cssClass="campoGeneral"/></td>
				</tr>
				<tr>
					<td>BL</td>
					<td id="separador">:</td>		
					<td><s:textfield id="deBillLadi" name="pedido.noCarg" cssClass="campoGeneral" /></td>
					<td colspan="4">&nbsp;</td>
					<td>Nave</td>
					<td id="separador">:</td>		
					<td><s:textfield id="noNave" name="pedido.deProfInvo" cssClass="campoGeneral"/></td>
				</tr>
				<tr>
					<td>Acticulo</td>
					<td id="separador">:</td>	
					<td colspan="8"><s:textfield id="coHldo" name="pedido.deObsePedi" cssClass="campoGeneral" cssStyle="width:85%" size="100px" readonly="true" /></td>
				</tr>
					<tr>
						<!-- Marca será sólo un campo de lectura -->
						<td>Marca</td>
						<td id="separador">:</td>
						<td><s:textfield id="idMrca" name="pedido.idMrca" readonly="true" /></td>		
						<td style="text-align:right;">U.M.</td>
						<td id="separador">:</td>
						<td><s:textfield id="idUnidMedi" name="pedido.idUnidMedi" readonly="true" /></td>
						<td colspan="1">&nbsp;</td>
						<td>Cantidad</td>
						<td id="separador">:</td>		
						<td><s:textfield id="nuCantPedi" name="pedido.nuCantPedi" cssStyle="width:100px;" cssClass="campoCantidadPedido"/></td>				
					</tr>
				<tr>
					<td>Observación</td>
					<td id="separador">:</td>	
					<td colspan="8"><s:textfield id="deObsePedi" name="pedido.deObsePedi" cssClass="campoGeneral" cssStyle="width:85%" size="100px"/></td>
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
               <sj:a id="btnNPedido" 
                     title="Nuevo Pedido" 
                     button="true"
                     href="pedidoAction"
                     targets="contenido"
                     formIds="formPedido">
                     <span>Nuevo Pedido</span>
                </sj:a>
            </li>
            <li>
               <sj:a id="btnNuevo" 
                     title="Grabar Pedido"
                     formIds="formPedido" 
		             targets="capita"
		             onCompleteTopics="rtdivListaHiladoIngreso,cargarMarcas,cargarUnidadMedida"
		             onAfterValidationTopics="cargarMarcas,cargarUnidadMedida"
		             loadingText="cagandoaa"
                     button="true">
                     <span>Grabar Pedido</span>
                </sj:a>
            </li>
            <li>&nbsp;</li>
          </ul>
        </td>
      </tr>
    </table>
</div>
</s:form>
<jsp:include page="../general/dialogoMensajes.jsp" />