
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  <body> Empresa <% //out.print(nomeEmpresa); %> Cadastrada. -->
<!-- Empresa <%//=(nomeEmpresa) %> Cadastrada! -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
	<body>
	<c:import url="logout-parcial.jsp" />
	<c:if test="${not empty empresa}">
		<p>Empresa ${empresa} Cadastrada!</p>
	</c:if>
	<c:if test="${empty empresa}">
		<p>Nenhuma empresa Cadastrada</p>
	</c:if>
	
	</body>
</html>