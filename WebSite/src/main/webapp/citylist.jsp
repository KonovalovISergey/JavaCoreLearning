<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Города</h1>

	<%
		request.setCharacterEncoding("UTF-8");
		String search;
		search = request.getParameter("search");
	
		if(search == null || search.trim().isEmpty())
			search = "";
		else
			search = search.trim();
			
	%>

	<form method="POST">
		<input type=text name=search value="<%=search%>"><input type=submit value="Поиск">
	</form>

	<%
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String CONNECTION_STRING = "jdbc:mysql://localhost/world?user=root&password=admin";

	Class.forName(DRIVER_NAME);

	try (Connection connect = DriverManager.getConnection(CONNECTION_STRING)) {

		String sql = "select Name, District, Population from world.city where Name like ? order by Name";
		PreparedStatement cmd = connect.prepareStatement(sql);
		cmd.setString(1, "%" + search + "%");
		ResultSet result = cmd.executeQuery();

		out.print("<table border=1>");
		while (result.next()) {
			out.print("<tr>");
			String name = result.getString("Name");
			String district = result.getString("District");
			int population = result.getInt(3);

			out.print("<td>");
			out.print(name);
			out.print("</td>");
			out.print("<td>");
			out.print(district);
			out.print("</td>");
			out.print("<td>");
			out.print(population);
			out.print("</td>");

			out.print("</tr>");
		}
		result.close();
		out.print("</table>");
	}
	%>

</body>
</html>