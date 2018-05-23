<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="curso" uri="/WEB-INF/curso.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<curso:mayusculas
			texto="este texto se va a convertir en mayusculas xcbdfsbfsbxvcbxbcv"></curso:mayusculas>
	</h1>
	<h1>
		<table border="1">
			<curso:repeticiones texto="esto es el texto" cantidad="5">
				<tr><td style="background-color: #cacaca"><curso:resultado /></td></tr>
			</curso:repeticiones>
		</table>
	</h1>

</body>
</html>