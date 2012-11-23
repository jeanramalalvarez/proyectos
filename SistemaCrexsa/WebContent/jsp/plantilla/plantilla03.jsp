<%@ include file="../include/include.jsp"%>
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