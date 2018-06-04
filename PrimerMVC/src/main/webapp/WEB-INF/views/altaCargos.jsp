<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="cabecera.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp"></jsp:include>
		<div style="padding-top: 50px">
			<h1 align="center">ALTA CARGOS</h1>

			<spring:form action="/latam/grabaCargo" method="post"
				modelAttribute="cargo">

				<table  align="center" class="table" style="width: 50%">
					<tr>
						<td>
							<div class="form-group">
								<label>Descripcion</label>
								<spring:input path="descripcion" cssClass="form-control" />
							</div>
						</td>
					</tr>
					<tr>
						<td align="center"><input type="submit" value="grabar"
							class="btn btn-default"></td>
					</tr>
				</table>
				
					<table  align="center" class="table table-striped" style="width: 50%">
						<c:forEach items="${cargos }" var="cargo">
							<tr>
								<td>${cargo.descripcion }</td>
								<td align="center"><a class="btn btn-danger" href="/latam/borraCargo/${cargo.id }">borrar</a></td>
							</tr>

						</c:forEach>
					</table>
				
				<h1 style="color: #ff0000">${error }</h1>
			</spring:form>

			
		</div>
	</div>
</body>
</html>