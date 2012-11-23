<%@ include file="../include/include.jsp"%>
<script type="text/javascript">
 
    $(document).ready(function() {
      //$('#divListaPedido').load('${pageContext.request.contextPath}/pedidoAction!cargarListaPedido');
    });

</script>
<fieldset><legend>Compra Local</legend>
<div class="capa" style="">
<div id="capita" >
<jsp:include page="hilado_registro_local_include.jsp" />
</div>
<h4>Listado de Pedidos</h4>
<!-- cssStyle="height: 310px;" -->
<sj:div id="divListaPedido2" reloadTopics="rtdivListaHiladoIngreso" href="pedidoAction!cargarListaPedido"></sj:div>
<br />
</div>
</fieldset>