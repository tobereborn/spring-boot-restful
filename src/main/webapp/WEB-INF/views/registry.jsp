<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registry</title>
    <%--<style>--%>
    <%--div.errors {--%>
    <%--background-color: #ffcccc;--%>
    <%--border: 2px solid red;--%>
    <%--}--%>

    <%--label.error {--%>
    <%--color: red;--%>
    <%--}--%>

    <%--input.error {--%>
    <%--background-color: #ffcccc;--%>
    <%--}--%>
    <%--</style>--%>
    <link rel="stylesheet" type="text/css" href="/css/registry.css"/>
</head>
<body>
<h1>Register</h1>

<sf:form method="post" commandName="user">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <table>
        <tr>
            <td><sf:label path="userName" cssErrorClass="error"> UserName: </sf:label></td>
            <td><sf:input path="userName" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><sf:label path="firstName" cssErrorClass="error"> FirstName: </sf:label></td>
            <td><sf:input path="firstName" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><sf:label path="lastName" cssErrorClass="error">LastName: </sf:label></td>
            <td><sf:input path="lastName" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><sf:label path="email"> Email:</sf:label></td>
            <td><sf:input path="email" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><sf:label path="single" cssErrorClass="error">Single:</sf:label></td>
            <td>
                <sf:radiobutton path="single" value="true" cssErrorClass="error"/> Yes
                <sf:radiobutton path="single" value="false" cssErrorClass="error"/>No
            </td>
        </tr>
        <tr>
            <td><sf:label path="password">Password:</sf:label></td>
            <td><sf:input path="password" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register"></td>
        </tr>
    </table>
</sf:form>

</body>
</html>
