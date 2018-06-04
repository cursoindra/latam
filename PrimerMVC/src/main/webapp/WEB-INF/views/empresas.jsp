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
			<h1 align="center">EMPRESAS</h1>
			<spring:form action="/latam/grabaEmpresa" method="post"
				modelAttribute="empresa">
				<table class="table" align="center">
					<tr>

						<td><div class="form-group">
								<label for="descripcion">NOMBRE</label>
								<spring:input path="descripcion"  cssClass="form-control"/>
							</div></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Grabar" class="btn btn-default"></td>
					</tr>
				</table>
			</spring:form>
			<table class="table" align="center">
				<c:forEach items="${empresas }" var="empresa">
					<tr>
						<td>${empresa.descripcion}</td>
						<td align="center"><a href="/latam/borraEmpresa/${empresa.id}" class="btn btn-danger">borrar</a></td>
					</tr>
				</c:forEach>
			</table>

			<h1 style="color: #ff0000">${error }</h1>
		</div>
	</div>
</body>
</html>