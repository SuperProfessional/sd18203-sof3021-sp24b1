<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>

<h2>San Pham Chi Tiet Table</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma SPCT</th>
        <th>Kich Thuoc ID</th>
        <th>Mau Sac ID</th>
        <th>San Pham ID</th>
        <th>So Luong</th>
        <th>Don Gia</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="spChiTiet" items="${spChiTietList}">
        <tr>
            <td>${spChiTiet.id}</td>
            <td>${spChiTiet.maSPCT}</td>
            <td>
                <a href="/kich-thuoc/show/${spChiTiet.khichThuocId}">
                        ${spChiTiet.khichThuocId}
                </a>
            </td>
            <td>
                <a href="/mau-sac/show/${spChiTiet.mauSacId}">
                        ${spChiTiet.mauSacId}
                </a>
            </td>
            <td>
                <a href="/san-pham/show/${spChiTiet.sanPhamId}">
                        ${spChiTiet.sanPhamId}
                </a>
            </td>
            <td>${spChiTiet.soLuong}</td>
            <td>${spChiTiet.donGia}</td>
            <td>
                <a href="/sp-chi-tiet/edit/${spChiTiet.id}">
                    <button>Edit</button>
                </a>
                <a href="/sp-chi-tiet/delete/${spChiTiet.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/sp-chi-tiet/create">
    <button>Create</button>
</a>

</body>
</html>
