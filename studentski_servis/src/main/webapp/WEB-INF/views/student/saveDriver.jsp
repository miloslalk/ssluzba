<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Driver</title>
</head>
<body>

	<spring:url value="/driver/save" var="addDriver" />
	<form:form action="${addDriver}" method="post" modelAttribute="driver">
		<spring:bind path="id">
			<form:hidden path="id" />
		</spring:bind>
		<label>First name:</label>
		<spring:bind path="firstName">
			<form:input path="firstName" type="text" />
		</spring:bind>
		<label>Last name:</label>
		<spring:bind path="lastName">
			<form:input path="lastName" type="text" />
		</spring:bind>
		<label>Age:</label>
		<spring:bind path="age">
			<form:input path="age" type="text" />
		</spring:bind>
		<input type="submit" value="Save" />
	</form:form>
	<div id="Licences">
		<c:if test="${driver.getId() > 0}">
			Licences:
			<c:forEach items="${driver.getLicences()}" var="item">
				${item.getCategory()} | 
				<form action="/driver/licence/${item.getLicenceId()}" method="post">
					<input type="submit" value="delete licence" name="Submit" />
				</form>
			</c:forEach>
		</c:if>
	</div>
	</br>
	</br>
	</br>
	</br>
	<c:if test="${driver.getId() > 0}">
		<select>
			<c:forEach items="${licences}" var="licence">
				<option value="${licence.getLicenceId()}">${licence.getCategory()}</option>
			</c:forEach>
		</select>
		<button id="addLicence">Add licence</button>
	</c:if>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		jQuery(document).ready(function() {
			$("#addLicence").on('click', function() {
				var select = $(this).prev().find(":selected").val();
				var data = {
					driverId : $("#id").val(),
					licenceId: select
				};
				$.ajax({
					type : "POST",
					url : "/driver/licence/add",
					data : JSON.stringify(data),
					success : function(licence) {
						$("#Licences").append(" " + licence.category + "|");
					},
					failure : function(e) {
						alert("NOT ADDED!");
					},
					contentType : "application/json; charset=utf-8"
				});
			});
		});
	</script>
</body>
</html>