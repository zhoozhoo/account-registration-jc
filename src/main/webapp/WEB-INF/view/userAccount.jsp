<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Account</title>
</head>

<body>
	<div>
		<form:form method="POST" modelAttribute="userAccountForm" action="${pageContext.request.contextPath}/register">
			<fieldset>
				<legend>User Account</legend>
				<table>
					<tr>
						<td><form:label path="username">
								Username <form:errors path="username" />
							</form:label></td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td><form:label path="password">
								Password <form:errors path="password" />
							</form:label></td>
						<td><form:password path="password" /></td>
					</tr>
					<tr>
						<td><form:label path="password">
								Confirm Password <form:errors path="confirmPassword" />
							</form:label></td>
						<td><form:password path="confirmPassword" /></td>
					</tr>
				</table>
			</fieldset>
		</form:form>
	</div>
</body>
</html>
