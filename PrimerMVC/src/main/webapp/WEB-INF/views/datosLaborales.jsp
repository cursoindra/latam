<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">DATOS LABORALES</h1>
	<spring:form action="/latam/grabaDatoLaboral" method="post"
		modelAttribute="datoLaboral">
		<table border="1" align="center">
			<tr>
				<td>SALARIO</td>
				<td><spring:input path="salario" /></td>
			</tr>
			<tr>
				<td>CARGO</td>
				<td>
					<%-- <spring:select path="cargo.id" items="${cargos }"
						itemValue="id" itemLabel="descripcion"></spring:select> --%> <spring:select
						path="cargo.id">
						<spring:option value="0">Selecciona cargo...</spring:option>
						<spring:options itemLabel="descripcion" itemValue="id"
							items="${cargos }" />
					</spring:select>
				</td>
			</tr>
			<tr>

				<td colspan="2" align="center"><input type="submit"
					value="GRABAR"></td>
			</tr>
		</table>
	</spring:form>
	<table border="1" align="center">
		<tr>
			<td>SALARIO</td>
			<td>CARGO</td>
			<td>BORRAR</td>
		</tr>
		<c:forEach items="${datosLaborales }" var="datoLaboral">
			<tr>
				<td>${datoLaboral.salario }</td>
				<td>${datoLaboral.cargo.descripcion }</td>
				<td><a href="/latam/borraDatoLaboral/${datoLaboral.id }">borrar</a></td>
			</tr>
		</c:forEach>

	</table>
	<h1 style="color: #ff0000">${error }</h1>
	<div align="center">
		<a href="/latam/">MENU</a>
	</div>
</body>
</html>