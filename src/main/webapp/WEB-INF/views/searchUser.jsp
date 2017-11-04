<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Procurar Usuario</title>
	</head>

	<body>
		<p>Entre com as informacoes de usuario:</p>
		<form action="searchUsersForm" method="post"><br>
			Email<input name="email" type="text"><br>
			<button type="submit">Submit</button>
			<button>Cancelar</button>
			<p> ${mensagem}</p> 
		</form>
	</body>
</html>
