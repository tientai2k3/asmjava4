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
    <form action="/Buoi2_war_exploded/hoa-don/update?id=${qlhd.id}&ma=${qlhd.ma}" method="POST">
        <div class="row">
            <label for="formGroupExampleInput" class="form-label">Mã Hóa Đơn</label>
            <input type="text" class="form-control" name="ma" value="${qlhd.ma}" disabled >
            <p>${txtMa}</p>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Khách Hàng</label>
                <select class="form-select" aria-label="Default select example" name="khachHang">
                    <c:forEach items="${dsKhachHang}" var="kh">
                        <option value="${kh.ma}" ${kh.ma == qlhd.idKH.ma ?"Selected":""}>${kh.ma}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Nhân viên</label>
                <select class="form-select" aria-label="Default select example" name="nhanVien">
                    <c:forEach items="${dsNhanVien}" var="nv">
                        <option value="${nv.ma}" ${nv.ma == qlhd.idNV.ma ?"Selected":""}>${nv.ma}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">

            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Ngày tạo</label>
                <input type="date" class="form-control" name="ngayTao"  value="${qlhd.ngayTao}">
                <p>${txtNgayTao}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Ngày thanh toán</label>
                <input type="date" class="form-control" name="ngayThanhToan" value="${qlhd.ngayThanhToan}" >
                <p>${txtNgayThanhToan}</p>
            </div>
        </div>
        <div class="row">

            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Ngày Ship</label>
                <input type="date" class="form-control" name="ngayShip"  value="${qlhd.ngayShip}">
                <p>${txtNgayShip}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Ngày nhận</label>
                <input type="date" class="form-control" name="ngayNhan"  value="${qlhd.ngayNhan}">
                <p>${txtNgayNhan}</p>
            </div>
        </div>
        <div class="row">

            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Tình trạng</label>
                <select class="form-select" aria-label="Default select example" name="tinhTrang">
                    <option value="0"  value="${qlhd.tinhTrang == 0 ?"Selected":"" }">Đã Thanh Toán</option>
                    <option value="1"  value="${qlhd.tinhTrang == 1 ?"Selected":""}">Chưa Thanh Toán</option>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Tên Người nhận</label>
                <input type="text" class="form-control" name="tenNguoiNhan" value="${qlhd.tenNguoiNhan}" >
                <p>${txtTenNguoiNhan}</p>
            </div>
        </div>
        <div class="row">

            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi"  value="${qlhd.diaChi}">
                <p>${txtDiaChi}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Sđt</label>
                <input type="number" class="form-control" name="sdt" value="${qlhd.sdt}" >
                <p>${txtSdt}</p>
            </div>
        </div>
        <br>
        <div>
            <button type="submit" class="btn btn-outline-danger">UPDATE</button>
        </div>
    </form>
</div>
</body>
</html>
