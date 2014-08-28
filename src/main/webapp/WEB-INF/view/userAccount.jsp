<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Account</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<div>
		<form:form method="POST" modelAttribute="userAccountForm" action="${pageContext.request.contextPath}/register">
			<fieldset>
				<legend>User Account</legend>
				<table>
					<tr>
						<td><form:label path="username">Username</form:label></td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="password">Password</form:label></td>
						<td><form:password path="password" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="password">Confirm Password</form:label></td>
						<td><form:password path="confirmPassword" /></td>
						<td><form:errors path="confirmPassword" cssClass="error" /></td>
					</tr>
				</table>
				<input type="submit" name="register" value="Register" />
			</fieldset>
		</form:form>
	</div>
</body>
</html>
