<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
    <style>
        p{
            font-size: 16px;
            color: red;
            font-style: italic;
        }
    </style>
</head>
<body>
<div class="container">
    <h4>Quản lý chức vụ</h4>
    <hr>
    <br>
    <a href="create"class="btn btn-outline-danger">Thêm mới</a>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã chức vụ</th>
            <th scope="col">Tên</th>
            <th scope="col" colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${f:length(ds)==0}">
            <span>Không có dữ liệu</span>
        </c:if>
        <c:if test="${f:length(ds)!=0}">
            <c:forEach items="${ds}" var="cv">
                <tr>
                    <th scope="row">${cv.ma}</th>
                    <td>${cv.ten}</td>
                    <td><a href="edit?ma=${cv.ma}" class="btn btn-success">Sửa</a></td>
                    <td><a href="delete?id=${cv.id}"class="btn btn-danger">Xóa</a></td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
