<%@ include file="../include/include.jsp"%>
<div id="esc_error"><!--Capa que contiene los estilos para la plantilla de error-->
    <div id="esc_err_mensaje">
        <h1>ERROR 404</h1>
        <p>La información solicitada no fué encontrada.
           <%--<br/>Es posible que la página haya sido movida o eliminada del servidor. --%>
        </p>
<%--         <p style="color: red;"><s:property value="%{mensaje}"/></p> --%>
        <p>Le sugerimos que intente nuevamente.</p>
        <!-- 
        <div class="capaEnlace">
            <center>
                <table summary="Contenedor Botones" class="tablaAnchoAjustable"><tr><td>
                    <ul class="enlacesCentroAjustables">
                        <li><a href="emergente_sesion.html?height=240&amp;width=450" title="PÉRDIDA DE SESIÓN" class="thickbox"><span>Regresar</span></a></li>
                    </ul>
                </td></tr></table>
            </center>
        </div>
        -->
    </div>
</div>
<s:if test="hasActionErrors()" >
	<sj:dialog id="dlgMensaje" closeOnEscape="true" autoOpen="true" title="Error"
	           width="400" position="['center', 200]" cssClass="ui-state-error" 
	           showEffect="slide" hideEffect="slide" >
	  <s:actionerror id="actErrGenerico" theme="jquery"/>
	</sj:dialog>
</s:if>