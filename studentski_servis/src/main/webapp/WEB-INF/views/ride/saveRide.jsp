<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rides</title>
</head>
<body>

	<spring:url value="/ride/save" var="addRide" />
	<form:form action="${addRide}" method="post" modelAttribute="ride">
		<spring:bind path="id">
			<form:hidden path="id" />
		</spring:bind>
		<label>Description:</label>
		<spring:bind path="description">
			<form:input path="description" type="text" />
		</spring:bind>
		<label>Licence:</label>
		<spring:bind path="licenceId">
			<form:select path="licenceId">
				<c:forEach var="licence" items="${licences}">
					<form:option value="${licence.getLicenceId()}">${licence.getCategory() }</form:option>
				</c:forEach>
			</form:select>
		</spring:bind>
		<input type="submit" value="Save" />
	</form:form>

</body>
</html>