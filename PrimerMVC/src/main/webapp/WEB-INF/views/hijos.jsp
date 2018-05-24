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
	<h1 align="center">HIJOS</h1>
	<spring:form action="/latam/grabaHijo" method="post" modelAttribute="hijo">
		<table border="1" align="center">
			<tr>
				<td>CHICOS</td>
				<td><spring:input path="chicos" /></td>
			</tr>
			<tr>
				<td>CHICAS</td>
				<td><spring:input path="chicas" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="GRABAR"></td>

			</tr>
		</table>
		<table border="1" align="center">
			<tr>
				<td>CHICOS</td>
				<td>CHICAS</td>
			</tr>
			<c:forEach items="${hijos}" var="hijo">
				<tr>
					<td>${hijo.chicos }</td>
					<td>${hijo.chicas }</td>
				</tr>
			</c:forEach>
		</table>


	</spring:form>
	<h1 style="color: #ff0000">${error }</h1>
	<div align="center">
		<a href="/latam/">MENU</a>
	</div>
</body>
</html>