<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:28 CH
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
    <h4>Quản lý cửa hàng</h4>
    <hr>
    <br>
    <a href="create"class="btn btn-outline-danger">Thêm mới</a>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã cửa hảng</th>
            <th scope="col">Tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th scope="col" colspan="2">Thao tác</th>
        </tr>
        </thead>

        <tbody>
        <c:if test="${f:length(ds)==0}">
            <span>Không có dữ liệu</span>
        </c:if>
        <c:if test="${f:length(ds)!=0}">
            <c:forEach items="${ds}" var="ch">
                <tr>
                    <th scope="row">${ch.ma}</th>
                    <td>${ch.ten}</td>
                    <td>${ch.diaChi}</td>
                    <td>${ch.thanhPho == "hn"?"Hà Nội" : ch.thanhPho =="hcm" ? "TP. Hồ Chí Minh" : "Đà Nẵng"}</td>
                    <td>${ch.quocGia =="vn" ?"Việt Nam" : ch.quocGia =="nb"? "Nhật Bản" :"Trung Quốc"}</td>
                    <td><a href="edit?ma=${ch.ma}"  class="btn btn-success">Sửa</a></td>
                    <td><a href="delete?ma=${ch.ma}"  class="btn btn-danger">Xóa</a></td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
