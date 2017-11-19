<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registry</title>
</head>
<body>
<h1>Register</h1>
<form method="POST">
    FirstName: <input type="text" name="firstName"/> <br/>
    LastName: <input type="text" name="lastName"/> <br/>
    UserName: <input type="text" name="userName"/> <br/>
    Email: <input type="email" name="email"/> <br/>
    Single: <input type="radio" name="single"/> <br/>
    Password: <input type="password" name="password">
    <input type="submit" value="Register"/>
</form>
</body>
</html>
