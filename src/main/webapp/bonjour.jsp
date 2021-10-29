<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonjour Première Servlet</title>
</head>
<body>

<form name="test" action="" method="post">
	<input type="text" name="chaine">
	<input type="submit" value="Submit" id="button-1"/>
</form>
	<h1>Page Bonjour</h1>
	<%! String s = ""; %>
	<%
		s = request.getParameter("chaine");
	%>
	<%= s %>
	<%= s.length() %>
</body>
</html>

