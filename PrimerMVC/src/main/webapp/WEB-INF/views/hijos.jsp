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
			<h1 align="center">HIJOS</h1>
			<spring:form action="/latam/grabaHijo" method="post"
				modelAttribute="hijo">
				<table class="table" align="center" style="width: 15%">
					<tr>

						<td colspan="2">
							<div class="form-group">
							<label for="chicos">CHICOS</label>
								<spring:input path="chicos" class="form-control"/>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="form-group">
							<label for="chicas">CHICAS</label>
								<spring:input path="chicas" class="form-control"/>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="GRABAR" class="btn btn-default"></td>

					</tr>
				</table>
				<table class="table table-striped" align="center">
					<tr>
						<td align="center">CHICOS</td>
						<td  align="center">CHICAS</td>
						<td  align="center">BORRAR</td>
					</tr>
					<c:forEach items="${hijos}" var="hijo">
						<tr>
							<td  align="center">${hijo.chicos }</td>
							<td  align="center">${hijo.chicas }</td>
							<td  align="center"><a href="borraHijo.html?id=${hijo.id }" class="btn btn-danger">BORRAR</a></td>
						</tr>
					</c:forEach>
				</table>


			</spring:form>
			<h1 style="color: #ff0000">${error }</h1>

		</div>
	</div>
</body>
</html>