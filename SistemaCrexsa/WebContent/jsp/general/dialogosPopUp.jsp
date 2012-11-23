<%@ include file="../include/include.jsp"%>
<sj:dialog id="popUpAdicionarOpcion"
           href="mantenimientoRolUsuarioAction!adicionarOpcionInicio" 
           autoOpen="false" 
           width="600" 
           height="500" 
           draggable="false" 
           resizable="false" 
           title="Adicionar Opción" 
           modal="true"           
           overlayColor="#903"
           overlayOpacity="0.8"
           showEffect="fade"
           hideEffect="fade"
           buttons="{'Adicionar':function(){fAdicionar();},
                     'Cancelar':function(){fCancelar('popUpAdicionarOpcion');}}"           
           closeOnEscape="true" />