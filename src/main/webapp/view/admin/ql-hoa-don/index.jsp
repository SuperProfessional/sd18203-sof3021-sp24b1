<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>

<h2>Hoa Don Table</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nhan Vien ID</th>
        <th>Khac Hang ID</th>
        <th>Ngay Mua Hang</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hoaDon" items="${hoaDonList}">
        <tr>
            <td>${hoaDon.id}</td>
            <td>
                <a href="/nhan-vien/show/${hoaDon.nhanVienId}">
                        ${hoaDon.nhanVienId}
                </a>
            </td>
            <td>
                <a href="/khach-hang/show/${hoaDon.khachHangId}">
                        ${hoaDon.khachHangId}
                </a>
            </td>
            <td>${hoaDon.ngayMuaHang}</td>
            <td>
                <a href="/hoa-don/edit/${hoaDon.id}">
                    <button>Edit</button>
                </a>
                <a href="/hoa-don/delete/${hoaDon.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/hoa-don/create">
    <button>Create</button>
</a>

</body>
</html>
