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
<%//response.sendRedirect("s2.jsp") ;%>
<jsp:useBean id="agenda" class="servlets.Agenda" scope= "request">
</jsp:useBean>

<jsp:setProperty property="nombre" name="agenda" value="Javier"/>
<jsp:setProperty property="direccion" name="agenda" value="mi casa"/>
<jsp:setProperty property="telefono" name="agenda" value="88855443"/>

<%

Agenda agenda1= new Agenda();
agenda1.setNombre("nombre de agenda 1");
session.setAttribute("agenda1",agenda1);

%>


<jsp:forward page="/s2.jsp"></jsp:forward>





</body>
</html>