<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registry</title>
</head>
<body>
<h1>Register</h1>
<form method="POST">
    Name: <input type="text" name="name"/> <br/>
    Age: <input type="text" name="age"/> <br/>
    Married: <input type="radio" name="isMarried"/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
