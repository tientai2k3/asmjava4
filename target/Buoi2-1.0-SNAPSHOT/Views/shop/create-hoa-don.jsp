<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01/04/2023
  Time: 1:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/custom/index2.css">
</head>
<body>
<div class="container">
    <form action="/Buoi2_war_exploded/shop/tao-hoa-don" method="POST">
        <div class="row">
            <label for="formGroupExampleInput" class="form-label">Mã Hóa Đơn</label>
            <input type="text" class="form-control" name="ma" >
            <p>${txtMa}</p>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Khách Hàng</label>
                <input type="text" class="form-control" value="${maKH}" name="khachHang" readonly >
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Nhân viên</label>
                <input type="text" class="form-control" name="nhanVien" value="${nv}" readonly >
            </div>
        </div>
<%--        <div class="row">--%>

<%--            <div class="col-md-6">--%>
<%--                <label for="formGroupExampleInput" class="form-label">Ngày tạo</label>--%>
<%--                <input type="date" class="form-control" name="ngayTao"  >--%>
<%--                <p>${txtNgayTao}</p>--%>
<%--            </div>--%>
<%--            <div class="col-md-6">--%>
<%--                <label for="formGroupExampleInput" class="form-label">Ngày thanh toán</label>--%>
<%--                <input type="date" class="form-control" name="ngayThanhToan" >--%>
<%--                <p>${txtNgayThanhToan}</p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>

<%--            <div class="col-md-6">--%>
<%--                <label for="formGroupExampleInput" class="form-label">Ngày Ship</label>--%>
<%--                <input type="date" class="form-control" name="ngayShip" >--%>
<%--                <p>${txtNgayShip}</p>--%>
<%--            </div>--%>
<%--            <div class="col-md-6">--%>
<%--                <label for="formGroupExampleInput" class="form-label">Ngày nhận</label>--%>
<%--                <input type="date" class="form-control" name="ngayNhan" >--%>
<%--                <p>${txtNgayNhan}</p>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="row">

            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Tình trạng</label>
                <select class="form-select" aria-label="Default select example" name="tinhTrang">
                    <option value="1">Chưa Thanh Toán</option>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Tên Người nhận</label>
                <input type="text" class="form-control" name="tenNguoiNhan" value="${tenKH}" >
                <p>${txtTenNguoiNhan}</p>
            </div>
        </div>
        <div class="row">

            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi"  value="${diaChiKH}">
                <p>${txtDiaChi}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Sđt</label>
                <input type="number" class="form-control" name="sdt"  value="${sdtKH}">
                <p>${txtSdt}</p>
            </div>
        </div>
        <br>
        <div>
            <button type="submit" class="btn btn-outline-danger">TẠO</button>
        </div>
    </form>
</div>
</body>
</html>
