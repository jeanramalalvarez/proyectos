<%@ include file="../include/include.jsp"%>
<script type="text/javascript">
 
    $(document).ready(function() {
      //$('#divListaPedido').load('${pageContext.request.contextPath}/pedidoAction!cargarListaPedido');
    });

</script>
<div class="capa" style="">
<div id="capita" >
<jsp:include page="hilado_registro_importacion_include.jsp" />
</div>
<h4>Listado de Ingreso de Hilado</h4>
<sj:div id="divListaPedido2" reloadTopics="rtdivListaHiladoIngreso" href="pedidoAction!cargarListaPedido"></sj:div>
<br />
</div>