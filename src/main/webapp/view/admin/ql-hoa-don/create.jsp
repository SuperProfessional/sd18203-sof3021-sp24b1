<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hoa Don Form</title>
</head>
<body>

<h2>Hoa Don Form</h2>

<f:form action="/hoa-don/store" method="post" modelAttribute="hoaDon">
    <div>
        <label for="id">ID:</label>
        <f:input type="number" name="id" path="id"/><br>
        <f:errors path="id" cssStyle="color: red"/>
    </div>
    <div>
        <label for="nhanVienId">Nhan Vien:</label>
        <f:select  path="nhanVienId">
            <f:option value="0"> --SELECT--</f:option>
            <f:options items="${nhanVienList}" itemValue="id" itemLabel="maNV"></f:options>
        </f:select><br>
        <f:errors path="nhanVienId" cssStyle="color: red"/>
    </div>
    <div>
        <label for="khachHangId">Khac Hang:</label>
        <f:select path="khachHangId">
            <f:option value="0"> --SELECT--</f:option>
            <f:options items="${khachHangList}" itemValue="id" itemLabel="maKH"></f:options>
        </f:select><br>
        <f:errors path="nhanVienId" cssStyle="color: red"/>
    </div>
    <input type="submit" value="Submit">
</f:form>

</body>
</html>