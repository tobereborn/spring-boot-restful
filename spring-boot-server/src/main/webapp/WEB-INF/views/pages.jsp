<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>page</title>
</head>
<body>
<c:forEach items="${pages.content}" var="post">
    <li id="post_<c:out value="post.id"/>">
        <div class="postMessage">
            <c:out value="${post.message}"/>
        </div>
        <div>
            <span class="postDate"><c:out value="${post.date}"/></span>
            <span class="postLocation">
                (<c:out value="${post.latitude}"/>,<c:out value="${post.longitude}"/>)
            </span>
        </div>
    </li>
</c:forEach>
</body>
</html>
