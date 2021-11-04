<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${v.nombre}</title>
</head>
<body>
	<h2>${v.id}</h2>
	<h2>${v.nombre}</h2>
	<h2>${v.notaMedia}</h2>
	<h2>${v.creador}</h2>
	<h2>${v.precio}</h2>
	<a href="${v.link}">${v.link}</a>
	<a href="<c:url value="comprar">
             	<c:param name="id" value="${v.id}"/>
             </c:url>">
             <button>Comprar</button>
	</a>
</body>
</html>