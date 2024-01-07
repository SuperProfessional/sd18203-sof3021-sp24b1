<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
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

<form action="/mau-sac/create" method="post">
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required><br>

    <label for="ma">Ma:</label>
    <input type="text" id="ma" name="ma" required><br>

    <label for="ten">Ten:</label>
    <input type="text" id="ten" name="ten" required><br>

    <input type="submit" value="Submit">
</form>

<%--<c:if test="${not empty param.id or not empty param.ma or not empty param.ten}">--%>
<%--    <h3>Form Data:</h3>--%>
<%--    <p>ID: ${param.id}</p>--%>
<%--    <p>Ma: ${param.ma}</p>--%>
<%--    <p>Ten: ${param.ten}</p>--%>
<%--</c:if>--%>

</body>
</html>