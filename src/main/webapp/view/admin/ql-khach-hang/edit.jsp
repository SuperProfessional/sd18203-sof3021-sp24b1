<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Khach Hang Form</title>
</head>
<body>

<h2>Khach Hang Form</h2>

<f:form method="post" modelAttribute="khachHang">
    <div>
        <label for="id">ID:</label>
        <f:input type="number" name="id" path="id" disabled="true"/><br>
        <f:errors path="id" cssStyle="color: red"/>
    </div>
    <div>
        <label for="ten">Ten:</label>
        <f:input type="text" id="ten" name="ten" path="ten"/><br>
        <f:errors path="ten" cssStyle="color: red"/>
    </div>
    <div>
        <label for="sdt">SDT:</label>
        <f:input type="text" id="sdt" name="sdt" path="sdt"/><br>
        <f:errors path="sdt" cssStyle="color: red"/>
    </div>
    <div>
        <label for="maKH">MaKH:</label>
        <f:input type="text" id="maKH" name="maKH" path="maKH"/><br>
        <f:errors path="maKH" cssStyle="color: red"/>
    </div>
    <input formaction="/khach-hang/update/${khachHang.id}" type="submit" value="Submit">
</f:form>

</body>
</html>