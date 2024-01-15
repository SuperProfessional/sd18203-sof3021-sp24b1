<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>

<h2>Nhan Vien Table</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ten</th>
        <th>MaNV</th>
        <th>Ten Dang Nhap</th>
        <th>Mat Khau</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="nhanVien" items="${nhanVienList}">
        <tr>
            <td>${nhanVien.id}</td>
            <td>${nhanVien.ten}</td>
            <td>${nhanVien.maNV}</td>
            <td>${nhanVien.tenDangNhap}</td>
            <td>${nhanVien.matKhau}</td>
            <td>
                <a href="/nhan-vien/edit/${nhanVien.id}">
                    <button>Edit</button>
                </a>
                <a href="/nhan-vien/delete/${nhanVien.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/nhan-vien/create">
    <button>Create</button>
</a>

</body>
</html>
