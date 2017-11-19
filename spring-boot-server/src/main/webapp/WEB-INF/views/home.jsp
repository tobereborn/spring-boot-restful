<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home </title>
</head>
<body>
<h1><s:message code="user.welcome"/></h1>
<a href="<s:url value="/api/posts" />">Posts</a> |
<a href="<s:url value="/api/registry" />">Register</a>
</body>
</html>


