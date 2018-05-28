<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">MODIFICACION</h1>

	<spring:form action="modificaEmpresa" method="post"
		modelAttribute="empresa">
		<table border="1" align="center">
			<tr>
				<td>EMPRESA</td>
				<td><spring:select path="id">
						<spring:option value="0">Selecciona Empresa....</spring:option>
						<spring:options items="${empresas }" itemLabel="descripcion"
							itemValue="id" />
					</spring:select></td>
					<spring:hidden path="descripcion"/>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="SELECCIONAR"></td>

			</tr>
		</table>
	</spring:form>

	<spring:form action="grabaEmpresaModificada" method="post"
		modelAttribute="empresaModificada">
		<spring:hidden path="descripcion"/>
		<spring:hidden path="id"/>
		
		<table border="1" align="center">
			<tr>
				<td>NOMBRE</td>
				<td>CORREO ELECTRONICO</td>
				<td>EDAD</td>
				<td>DATOS LABORALES</td>
				<td>DATOS PERSONALES</td>
			</tr>
			<c:forEach items="${empresaModificada.empleados }" var="empleado"
				varStatus="datos">
				<spring:hidden path="empleados[${datos.index }].id"/>
				<spring:hidden path="empleados[${datos.index }].datosLaborale.cargo.id"/>
				<spring:hidden path="empleados[${datos.index }].datosLaborale.cargo.descripcion"/>
				<spring:hidden path="empleados[${datos.index }].datosLaborale.salario"/>
				<spring:hidden path="empleados[${datos.index }].datosPersonale.estadoscivile.id"/>
				<spring:hidden path="empleados[${datos.index }].datosPersonale.estadoscivile.descripcion"/>
				<spring:hidden path="empleados[${datos.index }].datosPersonale.hijo.id"/>
				<spring:hidden path="empleados[${datos.index }].datosPersonale.hijo.chicos"/>
				<spring:hidden path="empleados[${datos.index }].datosPersonale.hijo.chicas"/>
				<spring:hidden path="empleados[${datos.index }].empresa.id"/>
				<tr>
					<td><spring:input path="empleados[${datos.index}].nombre" /></td>
					<td><spring:input path="empleados[${datos.index}].email" /></td>
					<td><spring:input path="empleados[${datos.index}].edad" /></td>
					<td><spring:select
							path="empleados[${datos.index}].datosLaborale.id"
							items="${datosLaborales }" itemValue="id"></spring:select></td>
					<td><spring:select
							path="empleados[${datos.index}].datosPersonale.id"
							items="${datosPersonales}" itemValue="id"></spring:select></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="center"><input type="submit"
					value="grabar"></td>
			</tr>
		</table>
	</spring:form>
	<h1 style="color: #ff0000">${error }</h1>
	<div align="center">
		<a href="/latam/">MENU</a>
	</div>
</body>
</html>