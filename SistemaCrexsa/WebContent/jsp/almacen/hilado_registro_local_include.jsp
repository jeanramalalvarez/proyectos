<%@ include file="../include/include.jsp"%>
<script type="text/javascript">

 
    $(document).ready(function() {
      //$('#divListaPedido').load('${pageContext.request.contextPath}/pedidoAction!cargarListaPedido');
    });

</script>
<s:form id="formPedido" name="formBusquedaRol" validate="true" theme="simple" action="pedidoAction!registrar">
<s:hidden id="hdInRegiActi" name="pedido.inRegiActi" value="1"/>
<div class="esc_for_CapaTabla">
 <table style="width: 100%" class="tablaContenedora" >
   <tr>
	    <td colspan="2"><h3 style="width: 100%;"><span>Información de Proforma</span></h3></td>
   </tr>
  
   <tr>
		<td colspan="2">
			<table style="width: 100%; border: 1px gray solid;" class="tablaMarco">
				<tr>
					<td>Número de Pedido</td>
					<td id="separador">:</td>
					<td><s:textfield id="nuPedi" name="pedido.nuPedi" cssClass="campoGeneral" readonly="true"/></td>
					<td>&nbsp;</td>
					<td>Fecha de Pedido</td>
					<td id="separador">:</td>
					<td><sj:datepicker id="fePedi" name="pedido.fePedi" maxDate="+0d" cssClass="campoFecha"/></td>
				</tr>
				<tr>
					<td>Cargador/Shipper</td>
					<td id="separador">:</td>		
					<td><s:textfield id="noCarg" name="pedido.noCarg" cssClass="campoGeneral" /></td>
					<td>&nbsp;</td>
					<td>P/I</td>
					<td id="separador">:</td>		
					<td><s:textfield id="deProfInvo" name="pedido.deProfInvo" cssClass="campoGeneral"/></td>
				</tr>
				<tr>
					<td>Observación</td>
					<td id="separador">:</td>	
					<td colspan="5"><s:textfield id="deObsePedi" name="pedido.deObsePedi" cssClass="campoGeneral" cssStyle="width:85%" size="100px"/></td>
				</tr>
			</table>
		</td>
	</tr>
	
<!-- <tr><td height="0px" colspan="6">&nbsp;</td></tr> -->
    
    <tr>
		<td colspan="1"><h3 style="width: 100%;"><span>Información de Producto</span></h3></td>
		<td colspan="1"><h3 style="width: 100%;"><span> Información de Costos</span></h3></td>
	</tr>
	
	<tr>
			<td colspan="1">
			<table style="width: 100%; border: 1px gray solid;" class="tablaMarco">
					<tr>
						<td id="etiqueta">Hilado</td>
						<td id="separador">:</td>		
						<td  colspan="7">
						<div id="divAutoCompletarHilado">
							<sj:autocompleter id="cboHldo"
							                  formIds="formPedido"
											  list="%{#session.listaTipoHilados}"
											  listKey="idTipoHldo"
											  listValue="deHldo"
											  name="pedido.idTipoHldo"
											  emptyOption="true"
											  delay="50"
									    	  loadMinimumCount="2"
									    	  onChangeTopics="cargarMarcas,cargarUnidadMedida"
									    	  placeholder="Ingrese Hilado"
									    	  selectBox="true"
									    	  selectBoxIcon="true"
									    	  cssStyle="width: 100%;" />

						</div>
						</td>
					</tr>
					<tr>
						<!-- Marca será sólo un campo de lectura -->
						<td>Marca</td>
						<td id="separador">:</td>		
						<td><s:url id="urlcargarMarcas" action="pedidoAction!cargarMarcas"/>
							<sj:select  id="selectMarcas" 
							            name="pedido.idMrca"
								    	deferredLoading="true"
								    	reloadTopics="cargarMarcas"
								    	emptyOption="false"
								    	href="%{urlcargarMarcas}" 
								    	list="listaMarcas"
							    		listValue="deMrca" 
							    		listKey="idMrca" 
							    		autocomplete="false"
							    		selectBoxIcon="false"
							    		loadMinimumCount="2"
							    		formIds="formPedido"
									    />
						</td>
						<td>U.M.</td>
						<td id="separador">:</td>
						<td><s:url id="urlcargarUnidadMedida" action="pedidoAction!cargarUnidadMedida"/>
        					<sj:select  id="selectUnidadMedida" 
							            name="pedido.idUnidMedi"
								    	deferredLoading="true"
								    	reloadTopics="cargarUnidadMedida"
								    	href="%{urlcargarUnidadMedida}" 
								    	list="listaUnidadMedidas"
							    		listValue="coUnidMedi" 
							    		listKey="idUnidMedi"  
							    		autocomplete="false"
							    		selectBoxIcon="false"
							    		loadMinimumCount="2"
							    		formIds="formPedido"
									    />
						</td>
						<td>Cantidad</td>
						<td id="separador">:</td>		
						<td><s:textfield id="nuCantPedi" name="pedido.nuCantPedi" cssStyle="width:100px;" cssClass="campoCantidadPedido"/></td>				
					</tr>
			</table>
			</td>
			
			<td colspan="1">
				<table style="width: 100%; border: 1px gray solid;" class="tablaMarco">
				<tr>
				<td id="etiqueta">CIF</td>
				<td id="separador">:</td>		
				<td id="campo"><sj:textfield id="nuCostCif" name="pedido.nuCostCif" cssStyle="width:100px;" cssClass="campoGeneral"/></td>
				</tr>
				<tr>
				<td id="etiqueta">Costo (+32%)</td>
				<td id="separador">:</td>		
				<td id="campo"><s:textfield id="nuCostTota" name="pedido.nuCostTota" cssClass="campoGeneral" cssStyle="width:100px;" readonly="true"/></td>
				</tr>	
				</table>
			</td>
			</tr>	
			
<!-- <tr><td height="0px" colspan="6">&nbsp;</td></tr> -->

	<tr>
		<td colspan="2"><h3 style="width: 100%;"><span>Información de Montos y Banco de Pago</span></h3></td>
	</tr>
	<tr>
		<td colspan="2">
		  <table style="width: 100%; border: 1px gray solid;" class="tablaMarco">
			<tr>
				<sj:div id="divCalcularMontos"	>
					<td style="width:30px;">Total</td>
					<td id="separador">:</td>	
					<td><s:textfield id="nuTotaPedi" name="pedido.nuTotaPedi" cssClass="campoGeneral" size="10" cssStyle="width:100px;" readonly="true"/></td>
					<td style="width:70px;">Precio Venta</td>
					<td id="separador">:</td>		
					<td><s:textfield id="nuPrecVent" name="pedido.nuPrecVent" cssClass="campoGeneral" cssStyle="width:100px;" size="15" readonly="true"/></td>
					<td style="width:80px;">15% a Cuenta</td>
					<td id="separador">:</td>	
					<td><s:textfield id="nuAdelPedi" name="pedido.nuAdelPedi" cssClass="campoGeneral" cssStyle="width:100px;" size="15" readonly="true"/></td>
				</sj:div>
				<td style="width:30px;">Banco</td>
				<td id="separador">:</td>	
				<td>	
			    <div id="divBanco">
				<sj:autocompleter 
									id="coBnco"
									list="%{#session.listaBancos}"
									listKey="idBnco"
									listValue="noBnco"
									name="pedido.idBnco"
									emptyOption="true"
									delay="50"
							    	loadMinimumCount="2"
							    	onChangeTopics="autocompleteChange"
							    	onFocusTopics="autocompleteFocus"
							    	onSelectTopics="autocompleteSelect"
							    	placeholder="Ingrese Banco"
							    	selectBox="true"
									selectBoxIcon="true"
							    	size="20"
									/>	
			    </div>
			    </td>			
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