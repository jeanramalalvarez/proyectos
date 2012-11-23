<%@ include file="../include/include.jsp"%>
<s:if test="hasActionMessages()">
	<sj:dialog id="dlgMensaje1" 
	           closeOnEscape="true" 
	           autoOpen="true" 
	           title="Mensaje" 
	           width="400" 
	           position="['center', 200]" 
	           cssClass="ui-state-highlight" 
	           showEffect="fade" 
	           hideEffect="fade"
	           resizable="false"
	           onOpenTopics="cerrarMensaje"
	           buttons="{'Aceptar':function(){fCancelar('dlgMensaje1');}}"
	           >
	 <!--  <s:actionmessage id="actMessGenerico" theme="jquery"/> -->
	 <s:actionmessage cssStyle="text-align: left;" />
	</sj:dialog>
</s:if>
<s:if test="hasActionErrors()" >
	<sj:dialog id="dlgMensaje2" 
	           closeOnEscape="true" 
	           autoOpen="true" 
	           title="Error"
	           width="400"
	           position="['center', 200]" 
	           cssClass="ui-state-error" 
	           showEffect="fade"
	           resizable="false"
	           hideEffect="fade" 
	           buttons="{'Aceptar':function(){fCancelar('dlgMensaje2');}}"
	           >
<!-- 	  <s:actionerror id="actErrGenerico" theme="jquery"/> -->
	  <s:actionerror cssStyle="text-align: left;" />
	</sj:dialog>
</s:if>
<s:if test="hasFieldErrors()" >			
	<sj:dialog id="dlgMensaje3" 
	           closeOnEscape="true" 
	           autoOpen="true" 
	           title="Error de validación"
	           width="300"
	           position="['center', 200]" 
	           cssClass="ui-state-error" 
	           showEffect="fade"
	           resizable="false"
	           hideEffect="fade"
	           buttons="{'Aceptar':function(){fCancelar('dlgMensaje3');}}"
	           >
	 <!--<s:fielderror cssClass="campoError" />-->
	 <s:fielderror cssStyle="text-align: left;" />				
	</sj:dialog>
</s:if>
<sj:dialog id="dlgVentanaUtil" 
           showEffect="fade" 
           hideEffect="fade"
  	       autoOpen="false" 
  	       modal="true" 
  	       title="Dialogo"
  	       resizable="false"
  	       buttons="{'Aceptar':function(){fCancelar('dlgVentanaUtil');}}"
  	       >
   <span id="spanMensajeDlgVentanaUtil"></span>
</sj:dialog>