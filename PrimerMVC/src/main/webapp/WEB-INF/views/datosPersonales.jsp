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
	<h1 align="center">DATOS PERSONALES</h1>
	<spring:form action="/latam/grabaDatoPersonal" method="post"
		modelAttribute="datoPersonal">
		<table border="1" align="center">
			<tr>
				<td>ESTADO CIVIL</td>
				<td><spring:select path="estadoscivile.id">
						<spring:option value="0">Selecciona estado civil...</spring:option>
						<spring:options itemLabel="descripcion" itemValue="id"
							items="${estadosCiviles }" />
					</spring:select></td>
			</tr>
			<tr>
				<td>HIJOS</td>
				<td><spring:select path="hijo.id">
						<spring:option value="0">Selecciona Hijos.....</spring:option>
						<spring:options items="${hijos }" itemValue="id" />
					</spring:select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="GRABAR"></td>
			</tr>

		</table>
	</spring:form>
	<table border="1" align="center">
		<tr>
			<td>ESTADO CIVIL</td>
			<td>HIJOS</td>
			<td>BORRAR</td>
		</tr>
		<c:forEach items="${datosPersonales }" var="datoPersonal">
		<tr>
			<td>${datoPersonal.estadoscivile.descripcion }</td>
			<td>${datoPersonal.hijo.texto }</td>
			<td><a href="/latam/borraDatoPersonal/${datoPersonal.id }">borrar</a></td>
		</tr>
		</c:forEach>
		
	</table>
	<h1 style="color: #ff0000">${error }</h1>
	<div align="center">
		<a href="/latam/">MENU</a>
	</div>

</body>
</html>











