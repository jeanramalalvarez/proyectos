<%@ include file="../include/include.jsp"%>
    <div id="cuerpo">
      <table class="anchoTotal">
        <tr>
          <td id="anchoMenu">
            <jsp:include page="../general/menu.jsp" />
          </td>
          <td id="anchoCuerpo">
            <div id="contenido">
              <tiles:insertAttribute name="cuerpo"/>
            </div>
          </td>
        </tr>
      </table>
    </div>