<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/custom/index2.css">
</head>
<body>
<div class="container">
    <h2>Quản lý Dòng Sản Phẩm</h2>
    <br>
    <form action="/Buoi2_war_exploded/dongsp/store" method="POST">
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Mã Dòng</label>
            <input type="text" class="form-control" id="formGroupExampleInput" name="ma">
            <p>${txtMa}</p>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Tên Dòng sản phẩm</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" name="ten">
            <p>${txtTen}</p>
        </div>
        <br>
        <div>
            <button type="submit" class="btn btn-outline-danger">ADD</button>
        </div>
    </form>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
