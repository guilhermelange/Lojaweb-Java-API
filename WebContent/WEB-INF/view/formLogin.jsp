<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usu�rio</title>
</head>
<body>	
	<form action="${linkServlet}" method="post">
		Login: 
		<input type="text" name="login" /> 
		Senha: 
		<input type="password" name="senha" /> 
		<input type="submit" />
		<input type="hidden" name="acao" value="Login"/>
	</form>
</body>
</html>