<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.hand.dao.UserDao"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>film表</title>
</head>
<body>
<p>3.1</p>
	<%
		UserDao ud = new UserDao();
		ResultSet rs = ud.getAllFilm();
	%>
	<table border="1">
		<tr>
			<td>film_id</td>
			<td>title</td>
			<td>description</td>
			<td>language</td>
		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%out.print(rs.getInt("film_id")); %></td>
			<td><%out.print(rs.getString("title")); %></td>
			<td><%out.print(rs.getString("description")); %></td>
			<td><%out.print(rs.getString("language")); %></td>
		</tr>

		<%
			}
		rs.close();
		%>
	</table>
</body>
</html>