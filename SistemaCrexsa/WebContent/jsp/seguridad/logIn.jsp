<%@ include file="../include/include.jsp"%>
<script type="text/javascript">
   
    $(function(){
        $('#btnIngresar, #btnLimpiar').hover(
        	    function() { $(this).addClass('ui-state-hover'); }, 
        	    function() { $(this).removeClass('ui-state-hover'); }
		);
        $('#btnIngresar').click(
        	    function(){ 
        	        fIngresar(); 
			    }
		);
        $('#btnLimpiar').click(
        	    function(){
        	        fLimpiar();
        	    }
		);
});

    function fCancelar(idDialogo){
    	$('#'+idDialogo).dialog('close');
    }

    function fIngresar(){
        $('#frmLogin').submit();	
    }
    function fLimpiar(){
        $('#txtUsuario, #txtClave').val("");
        $('#txtUsuario').focus();	
    }
</script>
<div class="log_Separador">&nbsp;</div>
<div id="logueo">
    	<div id="log_Titulo">INICIAR SESI&Oacute;N</div>
        <div id="log_Contenido">
          <s:form id="frmLogin" name="frmLogin" action="identificarAction!logIn">          
        	<div class="log_Separador">
                <div class="log_Sep_Texto">Usuario:</div>
                <div class="log_Sep_Input">
                	<span class="icoUsuario"></span>
                    <input id="txtUsuario" name="usuario.coUsua" value="" type="text" maxlength="23" onkeydown="if(event.keyCode == 13){fIngresar();}">
                    
                </div>
            </div>
            <div class="log_Separador">&nbsp;</div>
        	    <div class="log_Separador">
                <div class="log_Sep_Texto">Clave:</div>
                <div class="log_Sep_Input">
                	<span class="icoClave"></span>
                    <input id="txtClave" name="usuario.dePassUsua" value="" type="password" maxlength="23" onkeydown="if(event.keyCode == 13){fIngresar();}">
                    
                </div>
            </div>
            <div class="log_Separador">
            <!-- 
            	<s:fielderror id="feCodUsua" fieldName="usuario.coUsua" cssClass="campoError"/>
            	<s:fielderror id="feDePassUsua" fieldName="usuario.dePassUsua" cssClass="campoError"/>
            	 -->
            </div>
            <div class="log_Separador">&nbsp;
               
            </div>
            <table summary="Contenedor Botones" style="margin: 0 auto;" class="tablaAnchoAjustable">
      <tr>
        <td>
              <ul class="enlacesCentroAjustables" style="margin: 0 auto;">
               <li>
                 <sj:a id="btnLogin" 
                      title="Ingresar"
                      formIds="frmLogin"
                      targets="contenedor"
                      onAlwaysTopics="fMetodo()"
                      button="true">
                      <span>Ingresar</span>
                 </sj:a>
               </li>
               <!-- 
               <li>
                  <a id="btnLimpiar" 
                     href="#" 
                     class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" >
                       <span class="ui-button-text">Limpiar</span>
                  </a>
                </li>
                 -->
              <li>
              <sj:a id="btnLimpiar"  
                      title="Cancelar"
                     button="true">
                    <span>Limpiar</span>
                </sj:a>
               </li>
               <li>&nbsp;</li>
                </ul>
            </td>
            </tr>
            </table>
           </s:form>
        </div>
        </div>
<jsp:include page="../general/dialogoMensajes.jsp" />