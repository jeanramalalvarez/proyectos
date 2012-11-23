<%@ include file="../include/include.jsp"%>
<div id="cabecera">
   <table class="anchoMaximo">
      <tr>
          <td id="anchoLogo">
            <div id="logoCabecera" title="<s:text name="general.nombreEmpresa" />"></div>
            <div id="logoCabecera2"></div>
          </td>
          <td id="anchoTextos">
            <div id="bloqueTextos">
              <span id="nombreUsuario">
                <img id="indicador" src="<s:url forceAddSchemeHostAndPort="true" includeContext="true" value="/images/ajax-loader.gif"/>" 
                     align="top" style="display: none;"/>
                Usuario: <b><s:property value="%{#session.usuarioSesion.coUsua}"/></b>
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
      <img id="bgSombra" src="<s:url forceAddSchemeHostAndPort="true" includeContext="true" value="/images/bgSombraCabecera.gif"/>" alt="" title="">
        <span id="informacionRuta">.: Usted se encuentra en: <span id="rutaOpcion" ><tiles:getAsString name="titulo"/></span></span>
        <sj:a id="btnCerrarSession" title="Cerrar sesi&oacute;n" href="identificarAction!logOut" targets="contenedor">Cerrar sesi&oacute;n</sj:a>
<!--         <a id="btnCerrarSession" title="Cerrar sesi&oacute;n" href="#" onclick="javascript: fCerrarSesion()">Cerrar sesi&oacute;n</a>     -->
</div>