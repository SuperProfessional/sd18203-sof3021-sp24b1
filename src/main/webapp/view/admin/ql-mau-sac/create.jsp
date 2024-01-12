<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mau Sac Form</title>
</head>
<body>

<h2>Mau Sac Form</h2>

<f:form action="/mau-sac/store" method="post" modelAttribute="mauSac">
    <div>
        <label for="id">ID:</label>
        <f:input type="number" name="id" path="id"/><br>
    </div>
<div>
    <label for="ma">Ma:</label>
    <f:input type="text" id="ma" name="ma" path="ma" /><br>
</div>
<div>
    <label for="ma">Ma:</label>
    <f:input type="text" id="ma" name="ma" path="ten" /><br>
</div>
    <input type="submit" value="Submit">
</f:form>

</body>
</html>