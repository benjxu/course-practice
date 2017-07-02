<%--
  Created by IntelliJ IDEA.
  User: hxu
  Date: 7/2/17
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Spring MVC Hello World</title>
</head>

<body>
<h2>All Employees in System</h2>

<form:form action="searchEmployees" method="post">
    <table>
        <tr>
            <td>search word:</td><td><form:input path="word"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>

<table border="1">
    <tr>
        <th>Employee Id</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>