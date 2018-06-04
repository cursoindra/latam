<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="cabecera.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp"></jsp:include>
		<div style="padding-top: 50px">
			<h1 align="center">DATOS LABORALES</h1>
			<spring:form action="/latam/grabaDatoLaboral" method="post"
				modelAttribute="datoLaboral">
				<table class="table" align="center">
					<tr>

						<td colspan="2">
							<div class="form-group">
							<label for="salario">SALARIO</label>
								<spring:input path="salario"  class="form-control"/>
							</div>
						</td>
					</tr>
					<tr>
						
						<td colspan="2">
						<label for="cargo.id">CARGO:</label>
							 <spring:select
								path="cargo.id" cssClass="form-control">
								<spring:option value="0">Selecciona cargo...</spring:option>
								<spring:options itemLabel="descripcion" itemValue="id"
									items="${cargos }" />
							</spring:select>
						</td>
					</tr>
					<tr>

						<td colspan="2" align="center"><input type="submit"
							value="GRABAR" class="btn btn-default"></td>
					</tr>
				</table>
			</spring:form>
			<table class="table table-striped" align="center">
				<tr>
					<td>SALARIO</td>
					<td>CARGO</td>
					<td>BORRAR</td>
				</tr>
				<c:forEach items="${datosLaborales }" var="datoLaboral">
					<tr>
						<td>${datoLaboral.salario }</td>
						<td>${datoLaboral.cargo.descripcion }</td>
						<td><a href="/latam/borraDatoLaboral/${datoLaboral.id }" class="btn btn-danger">borrar</a></td>
					</tr>
				</c:forEach>

			</table>
			<h1 style="color: #ff0000">${error }</h1>
		</div>
	</div>
</body>
</html>