<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.spring_mvc.TeamManagement.beans.Team"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Find a team</title>
</head>
<body>
	<h1>Edit a team</h1>
	<form action="getTeamId" method="POST">
		<table>
			<tr>
				<th><input type="text" placeholder="Enter team ID"
					name="team_id" required></th>
				<td><button type="submit" name="action" value="update">Update</button></td>
				<td><button type="submit" name="action" value="delete">Delete</button></td>
				<!-- <td><input type="submit" value="edit"></td>-->
			</tr>
		</table>
	</form>
	<br>
	<table border=1>

		<tr style="padding: 10px;">
			<th>TeamId</th>
			<th>Team Name</th>
			<th>Country</th>
			<th>League</th>
		</tr>
		<c:forEach items="${teams}" var="team" varStatus="status">
			<tr style="padding: 10px;">
				<td>${team.key}</td>
				<c:set var="teamObj" scope="session" value="${team.value }" />
				<td>${teamObj.name}</td>
				<td>${teamObj.country}</td>
				<td>${teamObj.league}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>