<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!int contador=0;%>
<%
String nombre=request.getParameter("nombre");

%>
<h1>Has escrito <%=nombre.toUpperCase()%> y tiene <%=nombre.length()%> letras</h1>
<%contador++; %><br>
<h1 style="color: #ff0000">Eres el visitante numero:<%=contador%></h1>

<%
if(session.getAttribute("visitas")==null)
{
	session.setAttribute("visitas", 1);
}
else
{
	int visitas=(Integer) session.getAttribute("visitas");
	visitas++;
	session.setAttribute("visitas", visitas);
}
%>



<h1 style="color: #00ff00">Tu has venido a verme <%=session.getAttribute("visitas") %></h1>
</body>
</html>