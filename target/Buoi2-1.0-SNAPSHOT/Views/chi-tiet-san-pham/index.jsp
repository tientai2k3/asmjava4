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
    <h4>Quản lý chi tiết sản phẩm</h4>
    <hr>
    <br>
    <a href="create"class="btn btn-outline-danger">Thêm mới</a>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã Sản Phẩm</th>
            <th scope="col">Mã Nhà sản xuất</th>
            <th scope="col">Mã màu sắc</th>
            <th scope="col">Mã dòng sản phẩm</th>
            <th scope="col">Năm bảo hành</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Số lượng tồn</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Giá bán</th>
            <th scope="col" colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${f:length(ds)==0}">
            <span>Không có dữ liệu</span>
        </c:if>
        <c:if test="${f:length(ds)!=0}">
            <c:forEach items="${ds}" var="ctsp">
                <tr>
                    <th scope="row">${ctsp.idSP.ma}</th>
                    <th scope="row">${ctsp.idNsx.ma}</th>
                    <th scope="row">${ctsp.idMauSac.ma}</th>
                    <th scope="row">${ctsp.idDongSP.ma}</th>
                    <td>${ctsp.namBH}</td>
                    <td>${ctsp.moTa}</td>
                    <td>${ctsp.soLuongTon}</td>
                    <td>${ctsp.giaNhap}</td>
                    <td>${ctsp.giaBan}</td>
                    <td><a href="edit?id=${ctsp.id}" class="btn btn-success">Sửa</a></td>
                    <td><a href="delete?id=${ctsp.id}"class="btn btn-danger">Xóa</a></td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
