<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="cabecera.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp"></jsp:include>
		<div style="padding-top: 50px">
			<h1 align="center">MODIFICACION</h1>

			<spring:form action="modificaEmpresa" method="post"
				modelAttribute="empresa">
				<table class="table" align="center">
					<tr>

						<td colspan="2"><div class="from-group">
								<label for="id">EMPRESA</label>
								<spring:select path="id" cssClass="form-control">
									<spring:option value="0">Selecciona Empresa....</spring:option>
									<spring:options items="${empresas }" itemLabel="descripcion"
										itemValue="id" />
								</spring:select>
							</div></td>
						<spring:hidden path="descripcion" />
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="SELECCIONAR" class="btn btn-default"></td>

					</tr>
				</table>
			</spring:form>

			<spring:form action="grabaEmpresaModificada" method="post"
				modelAttribute="empresaModificada">
				<spring:hidden path="descripcion" />
				<spring:hidden path="id" />

				<table class="table" align="center" style="width: 100%">
					<tr>
						<td align="center"">NOMBRE</td>
						<td align="center"">CORREO ELECTRONICO</td>
						<td align="center"">EDAD</td>
						<td align="center"">DATOS LABORALES</td>
						<td> align="center""DATOS PERSONALES</td>
					</tr>
					<c:forEach items="${empresaModificada.empleados }" var="empleado"
						varStatus="datos">
						<spring:hidden path="empleados[${datos.index }].id" />
						<spring:hidden
							path="empleados[${datos.index }].datosLaborale.cargo.id" />
						<spring:hidden
							path="empleados[${datos.index }].datosLaborale.cargo.descripcion" />
						<spring:hidden
							path="empleados[${datos.index }].datosLaborale.salario" />
						<spring:hidden
							path="empleados[${datos.index }].datosPersonale.estadoscivile.id" />
						<spring:hidden
							path="empleados[${datos.index }].datosPersonale.estadoscivile.descripcion" />
						<spring:hidden
							path="empleados[${datos.index }].datosPersonale.hijo.id" />
						<spring:hidden
							path="empleados[${datos.index }].datosPersonale.hijo.chicos" />
						<spring:hidden
							path="empleados[${datos.index }].datosPersonale.hijo.chicas" />
						<spring:hidden path="empleados[${datos.index }].empresa.id" />
						<tr>
							<td><spring:input path="empleados[${datos.index}].nombre" cssClass="form-control"/></td>
							<td><spring:input path="empleados[${datos.index}].email" cssClass="form-control"/></td>
							<td><spring:input path="empleados[${datos.index}].edad" cssClass="form-control"/></td>
							<td><spring:select
									path="empleados[${datos.index}].datosLaborale.id"
									items="${datosLaborales }" itemValue="id" cssClass="form-control"></spring:select></td>
							<td><spring:select
									path="empleados[${datos.index}].datosPersonale.id"
									items="${datosPersonales}" itemValue="id" cssClass="form-control"></spring:select></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="center"><input type="submit"
							value="grabar" class="btn btn-danger"></td>
					</tr>
				</table>
			</spring:form>
			<h1 style="color: #ff0000">${error }</h1>
			
		</div>
	</div>
</body>
</html>