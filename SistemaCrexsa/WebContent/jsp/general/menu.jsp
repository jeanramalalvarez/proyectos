<%@ include file="../include/include.jsp"%>
<div id="menuPrincipal">
   <h2>MENU</h2>
   <ul id="men_ContenedorItem">
   <s:iterator value="#session.listaModulosSesion" var="listaModulos">
      <li>
         <a class="notcurrent" title="<s:property value='deOpci'/>"><s:property value="noOpci"/></a>
           <div class="oculto">
              <ul class="men_SubContItem">
                 <s:iterator value="listaOpcion">
<%--                     <li><a class="otroClase" title="<s:property value='deOpci'/>" href="<s:property value='url'/>"><s:property value="noOpci"/></a></li> --%>
                    <li>
                       <s:if test="url != null"> 
                       <sj:a class="otroClase" 
                             title="%{noOpci}" 
                             href="%{url}" 
                             indicator="indicator" 
		                     targets="contenido"  >
		                     <s:property value="noOpci"/>
		                </sj:a>
		                </s:if>
		                <s:else>
                       <sj:a class="otroClase" 
                             title="%{noOpci}" 
                             href="%{url}" 
                             indicator="indicator">
		                     <s:property value="noOpci"/>
		                </sj:a>
		                </s:else>
		            </li>
                 </s:iterator>
              </ul>
           </div>
     </li>
   </s:iterator>
   </ul>
</div>