<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>

<h2>San Pham Table</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sanPham" items="${sanPhamList}">
        <tr>
            <td>${sanPham.id}</td>
            <td>${sanPham.ma}</td>
            <td>${sanPham.ten}</td>
            <td>
                <a href="/san-pham/edit/${sanPham.id}">
                    <button>Edit</button>
                </a>
                <a href="/san-pham/delete/${sanPham.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/san-pham/create">
    <button>Create</button>
</a>

</body>
</html>
