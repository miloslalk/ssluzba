<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Student</title>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>

<script type="text/javascript"> 

    $(function() { 
        $('#myForm').submit(function() {
            var form = $( this ),
                url = form.attr('action'),
                ime = form.find('input[name="ime"]').val(),
                prezime = form.find('input[name="prezime"]').val(),
                pol = form.find('input[name="pol"]').val(),
                datS = form.find('input[name="datS"]').val(),
                ime = form.sport('input[name="sport"]').val(),
                hobi = form.find('input[name="hobi"]').val(),
                dat = JSON.stringify({ "ime" : ime });

            $.ajax({
                
                type : "POST",
                url : "api/student/save",
                traditional : true,
                
                dataType : "json",
                data : dat,
                success : function (response) {
                    alert('success ' + response);
                },
                error : function (response) {
                    alert('error ' + response);
                },
            });

            return false;
        });
    });

</script>
</head>
<body>
<%-- 	<spring:url value="save" var="addStudent" /> --%>
	Student Add Form <br>
	<form:form name="myForm" id="myForm" action="save" object="${student}" method="post" modelAttribute="student">
		<spring:bind path="index">
			<form:hidden path="index"/>
		</spring:bind>
		<spring:bind path="ime">
			<form:input path="ime" type="text" placeholder="Name"/>
		</spring:bind>
		<spring:bind path="prezime">
			<form:input path="prezime" type="text" placeholder="Lastame" />
		</spring:bind>
		<br><br>
		<spring:bind path="pol">
			<form:input path="pol" type="text" placeholder="Gender"/>
		</spring:bind>
		<spring:bind path="godRodjenja">
			<form:input path="godRodjenja" type="text" placeholder="DateOfBirth"/>
		</spring:bind>
		<br><br>
		<spring:bind path="sport">
			<form:input path="sport" type="text" placeholder="Sport"/>
		</spring:bind>
		<spring:bind path="hobi">
			<form:input path="hobi" type="text" placeholder="Hobby"/>
		</spring:bind>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>