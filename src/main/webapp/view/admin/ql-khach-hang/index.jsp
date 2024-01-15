<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>

<h2>Khach Hang Table</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ten</th>
        <th>SDT</th>
        <th>MaKH</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="khachHang" items="${khachHangList}">
        <tr>
            <td>${khachHang.id}</td>
            <td>${khachHang.ten}</td>
            <td>${khachHang.sdt}</td>
            <td>${khachHang.maKH}</td>
            <td>
                <a href="/khach-hang/edit/${khachHang.id}">
                    <button>Edit</button>
                </a>
                <a href="/khach-hang/delete/${khachHang.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/khach-hang/create">
    <button>Create</button>
</a>

</body>
</html>
