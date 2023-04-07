<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01/04/2023
  Time: 1:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/custom/index2.css">
</head>
<body>
    <div class="container">
        <form action="/Buoi2_war_exploded/gio-hang/store" method="POST">
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Khách Hàng</label>
                    <select class="form-select" aria-label="Default select example" name="khachHang">
                        <c:forEach items="${dsKhachHang}" var="kh">
                            <option value="${kh.ma}">${kh.ma}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Nhân viên</label>
                    <select class="form-select" aria-label="Default select example" name="nhanVien">
                        <c:forEach items="${dsNhanVien}" var="nv">
                            <option value="${nv.ma}">${nv.ma}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Mã Giỏ Hàng</label>
                    <input type="text" class="form-control" name="ma" >
                    <p>${txtMa}</p>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Ngày tạo</label>
                    <input type="date" class="form-control" name="ngayTao" >
                    <p>${txtNgayTao}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Ngày thanh toán</label>
                    <input type="date" class="form-control" name="ngayThanhToan" >
                    <p>${txtNgayThanhToan}</p>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Tên Người Nhận</label>
                    <input type="text" class="form-control" name="tenNguoiNhan" >
                    <p>${txtTenNguoiNhan}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" >
                    <p>${txtDiaChi}</p>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Sđt</label>
                    <input type="number" class="form-control" name="sdt" >
                    <p>${txtSdt}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Tình trạng</label>
                    <select class="form-select" aria-label="Default select example" name="tinhTrang">
                        <option value="0">Chưa Xác Nhận</option>
                        <option value="1">Đã Xác Nhận</option>
                    </select>
                </div>
            </div>
            <br>
            <div>
                <button type="submit" class="btn btn-outline-danger">ADD</button>
            </div>
        </form>
    </div>
</body>
</html>
