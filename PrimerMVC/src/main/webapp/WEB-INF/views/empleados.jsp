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
	<h1 align="center">EMPLEADOS</h1>
	<spring:form action="/latam/grabaEmpleado" method="post"
		modelAttribute="empleado">
		<table border="1" " align="center">

			<tr>
				<td>NOMBRE</td>
				<td><spring:input path="nombre" /></td>
			</tr>
			<tr>
				<td>EDAD</td>
				<td><spring:input path="edad" /></td>
			</tr>
			<tr>
				<td>CORREO</td>
				<td><spring:input path="email" /></td>
			</tr>
			<tr>
				<td>DATOS LABORALES</td>
				<td><spring:select path="datosLaborale.id">
						<spring:option value="0">Selecciona Dato Laboral...</spring:option>
						<spring:options items="${datosLaborales }" itemValue="id" />
					</spring:select></td>
			</tr>
			<tr>
				<td>DATOS PERSONALES</td>
				<td><spring:select path="datosPersonale.id">
						<spring:option value="0">Selecciona Dato Personal</spring:option>
						<spring:options items="${datosPersonales }" itemValue="id" />
					</spring:select></td>
			</tr>
			<tr>
				<td>EMPRESAS</td>
				<td><spring:select path="empresa.id">
						<spring:option value="0">Selecciona Empresa...</spring:option>
						<spring:options items="${empresas}" itemLabel="descripcion"
							itemValue="id" />
					</spring:select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="GRABAR"> </td>
			</tr>

		</table>



	</spring:form>
	<table border="1" align="center">
		<tr>
			<td>NOMBRE</td>
			<td>CORREO</td>
			<td>EDAD</td>
			<td>DATOS LABORALES</td>
			<td>DATOS PERSONALES</td>
			<td>EMPRESA</td>
			<td>BORRAR</td>
		</tr>

		<c:forEach items="${empleados }" var="empleado">
			<tr>
				<td>${empleado.nombre}</td>
				<td>${empleado.email }</td>
				<td>${empleado.edad}</td>
				<td>${empleado.datosLaborale}</td>
				<td>${empleado.datosPersonale }</td>
				<td>${empleado.empresa.descripcion }</td>
				<td><a href="/latam/borraEmpleado/${empleado.id}">borrar</a></td>
			</tr>


		</c:forEach>

	</table>

	<h1 style="color: #ff0000">${error }</h1>
	<div align="center">
		<a href="/latam/">MENU</a>
	</div>

</body>
</html>