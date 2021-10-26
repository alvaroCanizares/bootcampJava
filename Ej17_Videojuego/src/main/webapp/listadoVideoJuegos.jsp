<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Listado de Videojuegos</h1>
	<h2>${lista}</h2>
	
	<form action="DetalleServlet">
		<label>Id Videojuego<input type="number" name="id"></label><br>
		<input type="submit" value="Buscar">
	</form>
</body>
</html>