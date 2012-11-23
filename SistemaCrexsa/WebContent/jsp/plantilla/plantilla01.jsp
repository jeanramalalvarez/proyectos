<%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title><s:text name="general.nombreSistema" /></title>
<sj:head jquerytheme="flick" defaultIndicator="indicador" defaultLoadingText="Cargando..." locale="es" compressed="false"/>
<link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.displaytag-ajax-1.2.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {

    	/******* PARA DESHABILITAR BOTON DERECHO DEL MOUSE INICIO ******/
    	$(document).bind("contextmenu",function(e){
            return false;
        });
    	/******* PARA DESHABILITAR BOTON DERECHO DEL MOUSE FIN ******/
        
    	$('#logueo').css({ display: 'none' }); 
    	//$('#logueo').show('slow');
    	$('#logueo').fadeIn(900);
    	$(window).unload(function() {$('#indicador').show();} );
    	
    } );
    $.subscribe('cerrarMensaje', function(event, data) {
        setTimeout(function(){  if($("#dlgMensaje").dialog( "isOpen" )) $("#dlgMensaje").dialog('close');}, 3000);
    });

    /******* PARA DESHABILITAR BOTON DERECHO DEL MOUSE INICIO ******/
    /*
    function IE(e) {
    	if (navigator.appName == "Microsoft Internet Explorer" && (event.button == "2" || event.button == "3")) {
    	return false;
    	}
    }
    function NS(e) {
    	if (document.layers || (document.getElementById && !document.all)) {
    	    if (e.which == "2" || e.which == "3") {
    	        return false;
    	    }
        }
    }
    document.onmousedown=IE;document.onmouseup=NS;document.oncontextmenu=new Function("return false");
    */
    /******* PARA DESHABILITAR BOTON DERECHO DEL MOUSE FIN ******/
    
    </script>
</head>
<body>
<div id="contenedor">
    <div id="cabecera">
      <table class="anchoMaximo">
        <tr>
          <td id="anchoLogo">
            <div id="logoCabecera"></div>
          </td>
          <td id="anchoTextos">
            <div id="bloqueTextos">
              <span id="nombreUsuario">
                <img id="indicador" src="<s:url forceAddSchemeHostAndPort="true" includeContext="true" value="/images/ajax-loader.gif"/>" 
                     align="top" style="display: none;"/>
              </span>
              <span id="fechaAnio">
              <%--<s:property value="%{#session.fecha}"/> |  --%><s:text name="general.anio" /></span>            
            </div>
            <h1><s:text name="general.nombreSistema" /></h1>
          </td>
          <td id="anchoExtremo">
            <div id="extremoDerecho"></div>
          </td>
        </tr>
      </table>
    </div>
    <div id="bloqueSombra">
      <img id="bgSombra" src="<s:url forceAddSchemeHostAndPort="true" includeContext="true" value="/images/bgSombraCabecera.gif"/>" alt="" title="" />   
    </div>    
    <tiles:insertAttribute name="cuerpo" />
</div>
</body>
</html>