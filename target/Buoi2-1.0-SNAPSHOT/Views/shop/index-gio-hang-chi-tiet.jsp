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
<h4>Giỏ hàng</h4>
<hr>
<br>
<a href="/Buoi2_war_exploded/shop/themSP?idGH=${idGH}" class="btn btn-outline-danger">Thêm sản phẩm</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Tên nhà sản xuất</th>
        <th scope="col">Tên màu sắc</th>
        <th scope="col">Tên dòng sản phẩm</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Đơn giá</th>
        <th scope="col">Đơn giá khi giảm</th>
        <th scope="col" colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(dsGHCT)==0}">
        <span>Không có dữ liệu</span>
    </c:if>
    <c:if test="${f:length(dsGHCT) !=0}">
        <c:forEach items="${dsGHCT}" var="ghct">
            <tr>
                <td>${ghct.idChiTietSP.idSP.ten}</td>
                <td>${ghct.idChiTietSP.idNsx.ten}</td>
                <td>${ghct.idChiTietSP.idMauSac.ten}</td>
                <td>${ghct.idChiTietSP.idDongSP.ten}</td>
                <td>${ghct.soLuong}</td>
                <td>${ghct.donGia}</td>
                <td>${ghct.donGiaKhiGiam}</td>
                <td><a href="editSPinGHCT?idGioHang=${ghct.idGioHang.id}&idChiTietSP=${ghct.idChiTietSP.id}" class="btn btn-success">Sửa</a></td>
                <td><a href="deleteSPinGHCT?idGioHang=${ghct.idGioHang.id}&idChiTietSP=${ghct.idChiTietSP.id}"  class="btn btn-danger">Xóa</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3"><h4>Tổng tiền: ${tongTien}</h4></td>
            <td> <a href="/Buoi2_war_exploded/shop/hoa-don?idGH=${idGH}" class="btn btn-outline-danger">Tạo hóa đơn</a></td>
        </tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
