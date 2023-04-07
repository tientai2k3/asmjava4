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
<h4>Hóa đơn</h4>
<hr>
<br>
<%--<a href="/Buoi2_war_exploded/shop/themSP?idGH=${idGH}" class="btn btn-outline-danger">Thêm sản phẩm</a>--%>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Tên nhà sản xuất</th>
        <th scope="col">Tên màu sắc</th>
        <th scope="col">Tên dòng sản phẩm</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Đơn giá</th>
<%--        <th scope="col" colspan="2">Thao tác</th>--%>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(dsHDCT)==0}">
        <span>Không có dữ liệu</span>
    </c:if>
    <c:if test="${f:length(dsHDCT) !=0}">
        <c:forEach items="${dsHDCT}" var="hdct">
            <tr>
                <td>${hdct.idChiTietSP.idSP.ten}</td>
                <td>${hdct.idChiTietSP.idNsx.ten}</td>
                <td>${hdct.idChiTietSP.idMauSac.ten}</td>
                <td>${hdct.idChiTietSP.idDongSP.ten}</td>
                <td>${hdct.soLuong}</td>
                <td>${hdct.donGia}</td>
<%--                <td><a href="edit?idGioHang=${ghct.idGioHang.id}&idChiTietSP=${ghct.idChiTietSP.id}" class="btn btn-success">Sửa</a></td>--%>
<%--                <td><a href="deleteSPinGHCT?idGioHang=${ghct.idGioHang.id}&idChiTietSP=${ghct.idChiTietSP.id}"  class="btn btn-danger">Xóa</a></td>--%>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3"><h4>Tổng tiền: ${tongTien}</h4></td>
            <td> <a href="/Buoi2_war_exploded/shop/hoan-thanh?idHD=${idHD}" class="btn btn-outline-danger">Thanh Toán</a></td>
        </tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
