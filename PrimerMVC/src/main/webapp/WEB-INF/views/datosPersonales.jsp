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
		<div style="padding-top: 50px">
			<jsp:include page="menu.jsp"></jsp:include>
			<h1 align="center">DATOS PERSONALES</h1>
			<spring:form action="/latam/grabaDatoPersonal" method="post"
				modelAttribute="datoPersonal">
				<table class="table" align="center">
					<tr>

						<td colspan="2">
							<div class="form-group">
								<label for="estadoscivile.id">ESTADOS CIVILES</label>
								<spring:select path="estadoscivile.id" cssClass="form-control">
									<spring:option value="0">Selecciona estado civil...</spring:option>
									<spring:options itemLabel="descripcion" itemValue="id"
										items="${estadosCiviles }" />
								</spring:select>
							</div>
						</td>
					</tr>
					<tr>

						<td><div class="form-group">
						<label for="hijo.id">HIJOS</label>
								<spring:select path="hijo.id" class="form-control">
									<spring:option value="0">Selecciona Hijos.....</spring:option>
									<spring:options items="${hijos }" itemValue="id" />
								</spring:select>
							</div></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="GRABAR" class="btn btn-default"></td>
					</tr>

				</table>
			</spring:form>
			<table class="table table-striped" align="center">
				<tr>
					<td>ESTADO CIVIL</td>
					<td>HIJOS</td>
					<td>BORRAR</td>
				</tr>
				<c:forEach items="${datosPersonales }" var="datoPersonal">
					<tr>
						<td>${datoPersonal.estadoscivile.descripcion }</td>
						<td>${datoPersonal.hijo.texto }</td>
						<td><a href="/latam/borraDatoPersonal/${datoPersonal.id }" class="btn btn-danger">borrar</a></td>
					</tr>
				</c:forEach>

			</table>
			<h1 style="color: #ff0000">${error }</h1>
		</div>
	</div>

</body>
</html>











