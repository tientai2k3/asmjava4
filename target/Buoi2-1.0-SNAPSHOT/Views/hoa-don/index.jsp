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
<h4>Quản lý hóa đơn</h4>
<hr>
<br>
<a href="create" class="btn btn-outline-danger">Thêm mới</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã Hóa Đơn</th>
        <th scope="col">Mã Khách hàng</th>
        <th scope="col">Mã nhân viên</th>
        <th scope="col">Ngày tạo</th>
        <th scope="col">Ngày thanh toán</th>
        <th scope="col">Ngày ship</th>
        <th scope="col">Ngày nhận</th>
        <th scope="col">Tình trạng</th>
        <th scope="col">Tên người nhận</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">SĐT</th>
        <th scope="col" colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(ds)==0}">
        <span>Không có dữ liệu</span>
    </c:if>
    <c:if test="${f:length(ds) !=0}">
        <c:forEach items="${ds}" var="hd">
            <tr>
                <th scope="row">${hd.ma}</th>
                <td>${hd.idKH.ma}</td>
                <td>${hd.idNV.ma}</td>
                <td>${hd.ngayTao}</td>
                <td>${hd.ngayThanhToan}</td>
                <td>${hd.ngayShip}</td>
                <td>${hd.ngayNhan}</td>
                <td>${hd.tinhTrang == 0? "Đã thanh toán":"Chưa thanh toán"}</td>
                <td>${hd.tenNguoiNhan}</td>
                <td>${hd.diaChi}</td>
                <td>${hd.sdt}</td>
                <td><a href="edit?id=${hd.id}" class="btn btn-success">Sửa</a></td>
                <td><a href="delete?id=${hd.id}"  class="btn btn-danger">Xóa</a></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
