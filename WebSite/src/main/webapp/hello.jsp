<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My HELLO title</title>
</head>
<body>

	<h1>
		<%
		request.setCharacterEncoding("UTF-8");

		String userName = "";
		String result;
		if (request.getMethod().equals("POST")) {
			userName = request.getParameter("userName");
			result = String.format("Hello %s!", userName);
		} else
			result = "Hello!";

		out.println(result);
		%>
	</h1>
	<h2>
		<%
		Date now = new Date();
		out.println(now);
		%>
	</h2>

	<form method="POST">
		<label>Name: </label> <input type=text name="userName" value="<%= userName%>"> 
		<input type=submit value="Hello">
	</form>

</body>
</html>