<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas Cadastradas</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<p>Usuário Logado: ${usuarioLogado.login}</p>
	<c:if test="${not empty empresa}">
		<p>Empresa ${empresa} Cadastrada!</p>
	</c:if>
	
	<ul>
		<c:forEach items="${empresas}" var="emp">
			<li>${emp.nome} - <fmt:formatDate value="${emp.dataAbertura}" pattern="dd/MM/yyyy"/> 
			<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${emp.id}">editar</a>
			<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${emp.id}">remover</a> </li>
		</c:forEach>
	</ul>
</body>
</html>