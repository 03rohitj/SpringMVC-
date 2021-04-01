<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a team</title>
</head>
<body>
	<h1>Edit Team</h1>

	<c:set var="team_id" scope="session" value="${team_id}" />
	<c:set var="team_name" scope="session" value="${team.name}" />
	<c:set var="country" scope="session" value="${team.country}" />
	<c:set var="league" scope="session" value="${team.league}" />
	<form action="EditTeamData" method="post">
		<table>
			<tr>
				<th>Team Id</th>
				<td><input type="text" name="team_id" value="${team_id}"
					readonly></td>
			</tr>
			<tr>
				<th>Team Name</th>
				<td><input type="text" name="team_name" value="${team_name}"
					required></td>
			</tr>
			<tr>
				<th>Country</th>
				<td><input type="text" name="country" value="${country}"
					required></td>
			</tr>
			<tr>
				<th>League</th>
				<td><input type="text" name="league" value="${league}" required></td>
			</tr>
			<tr>
				<th><input type="submit" value="Update Team"></th>
			</tr>
		</table>
	</form>
</body>
</html>