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
			<h1 align="center">ESTADO CIVIL</h1>
			<spring:form action="/latam/grabaEstadoCivil" method="post"
				modelAttribute="estadoCivil">

				<table  align="center" class="table"  style="width: 50%">
					<tr>

						<td><div class="form-group">
						<label for="descripcion">DESCRIPCION</label>
								<spring:input path="descripcion" cssClass="form-control"/>
							</div></td>

					</tr>
					<tr>
						<td align="center"><input type="submit" value="grabar" class="btn btn-default"></td>
					</tr>
				</table >
				<table class="table table-striped" style="width: 50%" align="center">
					<c:forEach items="${estadosCiviles }" var="estadoCivil">
						<tr>
							<td>${estadoCivil.descripcion }</td>
							<td align="center"><a href="/latam/borraEstadoCivil/${estadoCivil.id }" class="btn btn-danger">borrar</a></td>
						</tr>

					</c:forEach>
				</table>

			</spring:form>
			<h1 style="color: #ff0000">${error }</h1>
			
		</div>
	</div>
</body>
</html>