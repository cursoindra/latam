<%@page import="servlets.Agenda"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>NOMBRE:<%=request.getParameter("nombre") %></h1>

<jsp:useBean id="agenda" class="servlets.Agenda" scope="request"></jsp:useBean>
<h1>nombre:<jsp:getProperty property="nombre" name="agenda"/> </h1>
<h1>direccion:<jsp:getProperty property="direccion" name="agenda"/> </h1>
<h1>telefono:<jsp:getProperty property="telefono" name="agenda"/> </h1>


<h1>ejemplo de clase sin tag:<%=((Agenda)session.getAttribute("agenda1")).getNombre() %></h1>
</body>
</html>