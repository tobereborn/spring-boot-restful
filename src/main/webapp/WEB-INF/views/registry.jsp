<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registry</title>
</head>
<body>
<h1>Register</h1>
<sf:form method="post" commandName="user">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <sf:label path="firstName" cssErrorClass="error"> FirstName: </sf:label>
    <sf:input path="firstName" cssErrorClass="error"/><br/>
    <sf:label path="lastName" cssErrorClass="error">LastName: </sf:label>
    <sf:input path="lastName" cssErrorClass="error"/> <br/>
    <sf:label path="email"> Email:</sf:label>
    <sf:input path="email" cssErrorClass="error"/><br/>
    <table>
        <tr>
            <td><sf:label path="single" cssErrorClass="error">Single:</sf:label></td>
            <td>
                <sf:radiobutton path="single" value="true" cssErrorClass="error"/> Yes
                <sf:radiobutton path="single" value="false" cssErrorClass="error"/>No
            </td>
        </tr>
    </table>
    <sf:label path="userName" cssErrorClass="error"> UserName: </sf:label>
    <sf:input path="userName" cssErrorClass="error"/><br/>
    <sf:label path="password" cssErrorClass="error">Password:</sf:label>
    <sf:input path="password" cssErrorClass="error"/><br/>
    <input type="submit" value="Register">
</sf:form>

</body>
</html>
