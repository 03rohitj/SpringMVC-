<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Team</title>
</head>
<body>
	<h1>Create New Team</h1>
	<form action="NewTeamData" method="post">
		<table>
			<tr>
				<th>Team Name</th>
				<td><input type="text" name="team_name" required></td>
			</tr>
			<tr>
				<th>Country</th>
				<td><input type="text" name="country" required></td>
			</tr>
			<tr>
				<th>League</th>
				<td><input type="text" name="league" required></td>
			</tr>
			<tr>
				<th><input type="submit" value="Launch Team"></th>
			</tr>
		</table>
	</form>
</body>
</html>