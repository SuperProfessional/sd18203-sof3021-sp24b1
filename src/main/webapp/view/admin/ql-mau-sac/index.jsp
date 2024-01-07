<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>

<h2>Mau Sac Table</h2>

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
    <c:forEach var="mauSac" items="${mauSacList}">
        <tr>
            <td>${mauSac.id}</td>
            <td>${mauSac.ma}</td>
            <td>${mauSac.ten}</td>
            <td>
                <a href="editForm.jsp?id=${mauSac.id}">
                    <button>Edit</button>
                </a>
                <a href="delete.jsp?id=${mauSac.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="createForm.jsp">
    <button>Create</button>
</a>

</body>
</html>
