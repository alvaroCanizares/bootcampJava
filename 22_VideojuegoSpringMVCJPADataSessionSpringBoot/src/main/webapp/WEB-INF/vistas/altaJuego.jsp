<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Juego</title>
</head>
<body>

<form action="doAltaJuego" method="post">
	<h1>Alta Juego</h1>
		<label>Id Videojuego<input type="number" name="id"></label><br>
		<label>Nombre<input type="text" name="nombre"></label><br>
		<label>Compa??a<input type="text" name="compania"></label><br>
		<label>Creador<input type="text" name="creador"></label><br>
		<label>Link<input type="text" name="link"></label><br>
		<label>Nota Media<input type="number" name="notaMedia"></label><br>
		<label>Precio<input type="number" name="precio"></label><br>
		<input type="submit" value="Buscar">
	</form>

</body>
</html>