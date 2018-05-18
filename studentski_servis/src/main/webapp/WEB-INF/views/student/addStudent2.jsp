<!DOCTYPE HTML>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h2>Unesite novog studenta</h2>
    <form action="#" th:action="@{/save}" th:object="${studentDTO}" method="post" >
    	<p>Name: <input name="ime" type="text" th:field="*{ime}" /></p>	
        <p>Lastname: <input name="prezime" type="text" th:field="*{prezime}" /></p>
        <p>Gender: <input name="pol" type="text" th:field="*{pol}" /></p>
    	<p>Date of Birth: <input name="datumS" type="date" th:field="*{datumS}" /></p>
    	<p>Sport: <input name="sport" type="text" th:field="*{sport}" /></p>
    	<p>Hobby: <input name="hobi" type="text" th:field="*{hobi}" /></p>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
    
 
    

    
</body>
</html>
