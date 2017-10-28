<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${user.userName}"/><br/>
<c:out value="${user.firstName}"/><br/>
<c:out value="${user.lastName}"/><br/>
<c:out value="${user.email}"/><br/>
<c:out value="${user.single}"/>
</body>
</html>
