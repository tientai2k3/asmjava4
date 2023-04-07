<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:31 CH
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
    <h2>Quản lý nhà sản xuất</h2>
    <br>
    <form action="/Buoi2_war_exploded/nsx/update?ma=${qlnsx.ma}" method="POST">
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Mã nhà sản xuất</label>
            <input type="text" class="form-control" id="formGroupExampleInput" name="ma" value="${qlnsx.ma}" disabled>
            <p>${txtMa}</p>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Tên nhà sản xuất</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" name="ten" value="${qlnsx.ten}">
            <p>${txtTen}</p>
        </div>
        <br>
        <div>
            <button type="submit" class="btn btn-outline-danger">UPDATE</button>
        </div>
    </form>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
