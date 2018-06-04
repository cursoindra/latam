<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="cabecera.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp"></jsp:include>
		<div style="padding-top: 50px">
			<h1 align="center">EMPLEADOS</h1>
			<spring:form action="/latam/grabaEmpleado" method="post"
				modelAttribute="empleado">
				<table class="table" align="center">

					<tr>
						<td colspan="2">
							<div class="form-group">
								<label for="nombre">NOMBRE</label>
								<spring:input path="nombre" cssClass="form-control" />
							</div>
						</td>

					</tr>
					<tr>

						<td colspan="2"><div class="form-group">
								<label for="edad">EDAD</label>
								<spring:input path="edad" cssClass="form-control" />
							</div></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="form-group">
								<label for="email">CORREO</label>
								<spring:input path="email" cssClass="form-control" />
							</div>
						</td>
					</tr>
					<tr>

						<td colspan="2"><div class="form-group">
								<label for="datosLaborale.id">DATOS LABORALES</label>
								<spring:select path="datosLaborale.id" cssClass="form-control">
									<spring:option value="0">Selecciona Dato Laboral...</spring:option>
									<spring:options items="${datosLaborales }" itemValue="id" />
								</spring:select>
							</div></td>

					</tr>
					<tr>

						<td colspan="2"><div class="form-group">
								<label for="datosPersonale.id">DATOS PERSONALES</label>
								<spring:select path="datosPersonale.id" cssClass="form-control">
									<spring:option value="0">Selecciona Dato Personal</spring:option>
									<spring:options items="${datosPersonales }" itemValue="id" />
								</spring:select>
							</div></td>

					</tr>
					<tr>

						<td colspan="2">
							<div class="form-group">
								<label for="empresa.id">EMPRESAS</label>
								<spring:select path="empresa.id" cssClass="form-control">
									<spring:option value="0">Selecciona Empresa...</spring:option>
									<spring:options items="${empresas}" itemLabel="descripcion"
										itemValue="id" />
								</spring:select>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="GRABAR" class="btn btn-default"></td>
					</tr>

				</table>



			</spring:form>
			<table class="table table-striped" align="center" style="width: 100%">
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
						<td><a href="/latam/borraEmpleado/${empleado.id}" class="btn btn-danger">borrar</a></td>
					</tr>


				</c:forEach>

			</table>

			<h1 style="color: #ff0000">${error }</h1>
		</div>
	</div>

</body>
</html>