<%@ include file="../include/include.jsp"%>
<script type="text/javascript">
    $(document).ready(function() {
    	$('#contenido').css({ display: 'none' }); 
    	//$('#contenido').show('fade');
    	$('#contenido').fadeIn(900);
    	$(window).unload(function() {$('#indicador').show();} );
    } );
    
    $.subscribe('cerrarMensaje', function(event, data) {
        setTimeout(function(){  if($("#dlgMensaje").dialog( "isOpen" )) $("#dlgMensaje").dialog('close');}, 3000);
    });

    function confirmarAccion(url, mensaje){
    	$("#spanMensajeDlgVentanaUtil").html(mensaje);
    	$("#dlgVentanaUtil").dialog({ buttons: { "Si":function() { $("#dlgVentanaUtil").dialog('close'); window.location.href=url; },
    	                                                 "No":function() { $("#dlgVentanaUtil").dialog("close"); } }
    	                                      ,title: "Confirmación"
    	                                     });
    	$("#dlgVentanaUtil").dialog("open");
    }
    
    function confirmarAccionAjax(url, target, mensaje){
    	$("#spanMensajeDlgVentanaUtil").html(mensaje);
    	$("#dlgVentanaUtil").dialog({ buttons: { "Si":function() { $("#dlgVentanaUtil").dialog('close'); $('#'+target).load('${pageContext.request.contextPath}/'+url); },
    	                                                 "No":function() { $("#dlgVentanaUtil").dialog("close"); } }
    	                                      ,title: "Confirmación"
    	 });
    	$("#dlgVentanaUtil").dialog("open");
    }
    
    
    //EFECTOS PARA EL MENU
    $(document).ready(function(){
      $('.oculto').hide();
	  $('.notcurrent:first').addClass('enlaceCapaDesplegada');
      $('.notcurrent').click(function(){
        if( $(this).next().is(':hidden') ){
          $('.notcurrent').removeClass('current').next().slideUp();
          $(this).toggleClass('oculto').next().show('slow');
          $(this).toggleClass('current').next().slideDown();	
        }
        else{
          $(this).removeClass('current').next().slideUp();
        }
		return false;
	  });
    });
    
    //CERRAR SESION
    function fCerrarSesion(){
    	var mensaje = "¿Está seguro(a) de salir del sistema?";
    	confirmarAccion("logueoAction!logOut",mensaje);
    }
    
    function fCancelar(idDialogo){
    	$('#'+idDialogo).dialog('close');
    }
    
//     function fIr(Url){
//     	window.location.href = Url;
//     }
    
    //PARA MARCAR TODOS LOS CHECKS
    function marcarTodos(formulario){
   	 var form = document.getElementById(formulario);
   	 if(form.chkregistro != undefined){
   	    if(form.chkregistro.length != undefined){
   		   for(var i = 0; i<form.chkregistro.length; i++){
   		       form.chkregistro[i].checked = form.chkregistroTodo.checked;
   		   }
   		}else{
   		       form.chkregistro.checked = form.chkregistroTodo.checked;
   		}
   	 }
     }
    
     //PARA MARCAR LOS CHECKS
     function marcar(formulario){
   	 var form = document.getElementById(formulario);
   	 var cont = 0;
   	 if(form.chkregistro != undefined){
   		if(form.chkregistro.length != undefined){
   		   for(var i = 0; i<form.chkregistro.length; i++){
   			   if(form.chkregistro[i].checked){
   						cont++;
   			   }
   		   }
   		   if(cont == form.chkregistro.length){
   			  form.chkregistroTodo.checked = true;				
   		   }else if(cont == 0){
   			  form.chkregistroTodo.checked = false;
   		   }else{
   			  form.chkregistroTodo.checked = false;
   		   }
   		}else{
   		   form.chkregistroTodo.checked = form.chkregistro.checked;
   		}
   	 }

    }
     
    $('div.ui-widget-overlay').live('click', function(){
    	$('#popUpAdicionarOpcion').dialog('close');
    });
    
    function mostrarRutaOpcion(opcion){
    	$('#rutaOpcion').html(opcion);
    }
 </script>
    <jsp:include page="../general/head.jsp" />
    <jsp:include page="../general/content.jsp" />
    <jsp:include page="../general/foot.jsp" />

<jsp:include page="../general/dialogoMensajes.jsp" />
<jsp:include page="../general/dialogosPopUp.jsp" />