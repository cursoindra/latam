<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">EMPRESAS</h1>
	<spring:form action="/latam/grabaEmpresa" method="post"
		modelAttribute="empresa">
		<table border="1" align="center">
			<tr>
				<td>NOMBRE</td>
				<td><spring:input path="descripcion" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Grabar"></td>
			</tr>
		</table>
	</spring:form>
	<table border="1" align="center">
		<c:forEach items="${empresas }" var="empresa">
			<tr>
				<td>${empresa.descripcion}</td>
				<td><a href="/latam/borraEmpresa/${empresa.id}">borrar</a></td>
			</tr>
		</c:forEach>
	</table>

	<h1 style="color: #ff0000">${error }</h1>
	<div align="center">
		<a href="/latam/">MENU</a>
	</div>
</body>
</html>