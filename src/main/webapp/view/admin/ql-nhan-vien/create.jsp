<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhan Vien Form</title>
</head>
<body>

<h2>Nhan Vien Form</h2>

<f:form action="/nhan-vien/store" method="post" modelAttribute="nhanVien">
    <div>
        <label for="id">ID:</label>
        <f:input type="number" name="id" path="id"/><br>
        <f:errors path="id" cssStyle="color: red"/>
    </div>
    <div>
        <label for="ten">Ten:</label>
        <f:input type="text" id="ten" name="ten" path="ten"/><br>
        <f:errors path="ten" cssStyle="color: red"/>
    </div>
    <div>
        <label for="maNV">MaNV:</label>
        <f:input type="text" id="maNV" name="maNV" path="maNV"/><br>
        <f:errors path="maNV" cssStyle="color: red"/>
    </div>
    <div>
        <label for="tenDangNhap">Ten Dang Nhap:</label>
        <f:input type="text" id="tenDangNhap" name="tenDangNhap" path="tenDangNhap"/><br>
        <f:errors path="tenDangNhap" cssStyle="color: red"/>
    </div>
    <div>
        <label for="matKhau">Mat Khau:</label>
        <f:input type="password" id="matKhau" name="matKhau" path="matKhau"/><br>
        <f:errors path="matKhau" cssStyle="color: red"/>
    </div>
    <input type="submit" value="Submit">
</f:form>

</body>
</html>