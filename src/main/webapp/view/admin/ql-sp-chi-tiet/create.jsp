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

<f:form action="/sp-chi-tiet/store" method="post" modelAttribute="spChiTiet">
    <div>
        <label for="id">ID:</label>
        <f:input type="number" name="id" path="id"/><br>
        <f:errors path="id" cssStyle="color: red"/>
    </div>
    <div>
        <label for="maSPCT">ID:</label>
        <f:input type="text" name="maSPCT" path="maSPCT"/><br>
        <f:errors path="maSPCT" cssStyle="color: red"/>
    </div>
    <div>
        <label for="khichThuocId">Nhan Vien:</label>
        <f:select  path="khichThuocId">
            <f:option value="NONE"> --SELECT--</f:option>
            <f:options items="${kichThuocList}" itemValue="id" itemLabel="ten"></f:options>
        </f:select><br>
        <f:errors path="nhanVienId" cssStyle="color: red"/>
    </div>
    <div>
        <label for="mauSacId">Nhan Vien:</label>
        <f:select  path="mauSacId">
            <f:option value="NONE"> --SELECT--</f:option>
            <f:options items="${mauSacList}" itemValue="id" itemLabel="ten"></f:options>
        </f:select><br>
        <f:errors path="nhanVienId" cssStyle="color: red"/>
    </div>
    <div>
        <label for="sanPhamId">Nhan Vien:</label>
        <f:select  path="sanPhamId">
            <f:option value="NONE"> --SELECT--</f:option>
            <f:options items="${sanPhamList}" itemValue="id" itemLabel="ma"></f:options>
        </f:select><br>
        <f:errors path="nhanVienId" cssStyle="color: red"/>
    </div>
    <div>
        <label for="soLuong">ID:</label>
        <f:input type="number" name="soLuong" path="soLuong"/><br>
        <f:errors path="soLuong" cssStyle="color: red"/>
    </div>
    <div>
        <label for="donGia">ID:</label>
        <f:input type="number" name="donGia" path="donGia"/><br>
        <f:errors path="donGia" cssStyle="color: red"/>
    </div>
    <input type="submit" value="Submit">
</f:form>

</body>
</html>