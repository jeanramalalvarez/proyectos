<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<title>LIST</title>
<link href="${pageContext.request.contextPath}/css/displaytag.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="divlista" class="tablaListado">
<display:table class="bordered" name="listResultBean" uid="row" excludedParams="*" export="false">    
    <display:column property="ID" title="ID" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_Outros" title="Q1_Outros" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_1" title="Q1_1" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_2" title="Q1_2" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_3" title="Q1_3" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_4" title="Q1_4" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_5" title="Q1_5" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_6" title="Q1_6" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_7" title="Q1_7" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_8" title="Q1_8" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q1_9" title="Q1_9" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q2" title="Q2" style="width: 7%;" headerClass="tituloTabla" />
    <display:column property="q3" title="Q3" style="width: 7%;" headerClass="tituloTabla" />
  </display:table>
</div>
</body>
</html>
