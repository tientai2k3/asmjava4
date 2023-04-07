<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01/04/2023
  Time: 1:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
</head>
<body>
<h4>Quản lý giỏ hàng</h4>
<hr>
<br>
<a href="create" class="btn btn-outline-danger">Thêm mới</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Giỏ Hàng</th>
        <th scope="col">Chi tiết sản phẩm</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Đơn giá</th>
        <th scope="col">Đơn giá khi giảm</th>
        <th scope="col" colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(ds)==0}">
        <span>Không có dữ liệu</span>
    </c:if>
    <c:if test="${f:length(ds) !=0}">
        <c:forEach items="${ds}" var="ghct">
            <tr>
                <th scope="row">${ghct.idGioHang.ma}</th>
                <th scope="row">${ghct.idChiTietSP.id}</th>
                <td>${ghct.soLuong}</td>
                <td>${ghct.donGia}</td>
                <td>${ghct.donGiaKhiGiam}</td>
                <td><a href="edit?idGioHang=${ghct.idGioHang.id}&idChiTietSP=${ghct.idChiTietSP.id}" class="btn btn-success">Sửa</a></td>
                <td><a href="delete?idGioHang=${ghct.idGioHang.id}&idChiTietSP=${ghct.idChiTietSP.id}"  class="btn btn-danger">Xóa</a></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
