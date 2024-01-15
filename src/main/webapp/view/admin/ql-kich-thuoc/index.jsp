<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>

<h2>Kich Thuoc Table</h2>

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
    <c:forEach var="kichThuoc" items="${kichThuocList}">
        <tr>
            <td>${kichThuoc.id}</td>
            <td>${kichThuoc.ma}</td>
            <td>${kichThuoc.ten}</td>
            <td>
                <a href="/kich-thuoc/edit/${kichThuoc.id}">
                    <button>Edit</button>
                </a>
                <a href="/kich-thuoc/delete/${kichThuoc.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/kich-thuoc/create">
    <button>Create</button>
</a>

</body>
</html>
