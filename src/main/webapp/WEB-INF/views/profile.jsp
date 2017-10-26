<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${user.name}"/><br/>
<c:out value="${user.age}"/><br/>
<c:out value="${user.isMarried}"/>
</body>
</html>
