<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h2>Quản lý nhân viên</h2>
    <br>
    <form method="POST" action="/Buoi2_war_exploded/nhan-vien/store">
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Mã NV</label>
                <input type="text" class="form-control" name="ma" >
                <p>${txtMa}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Tên NV</label>
                <input type="text" class="form-control" name="ten" >
                <p>${txtTen}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Tên đệm</label>
                <input type="text" class="form-control" name="tenDem" >
                <p>${txtTenDem}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Họ</label>
                <input type="text" class="form-control" name="ho" >
                <p>${txtHo}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Giới tính</label>
                <input class="form-check-input" type="radio" name="gioiTinh" value="nam" checked>Nam
                <input class="form-check-input" type="radio" name="gioiTinh" value="nu" >Nữ
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Ngày sinh</label>
                <input type="date" class="form-control" name="ngaySinh" >
                <p>${txtNS}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">SDT</label>
                <input type="number" class="form-control" name="sdt" >
                <p>${txtSDT}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi" >
                <p>${txtDC}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" name="matKhau" >
                <p>${txtMK}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Chức vụ</label>
                <select class="form-select" aria-label="Default select example" name="chucVu">
                    <c:forEach items="${dsIdCV}" var="cv">
                        <option value="${cv.ma}">${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Cửa hàng</label>
                <select class="form-select" aria-label="Default select example" name="cuaHang">
                    <c:forEach items="${dsIdCH}" var="ch">
                        <option value="${ch.ma}">${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-6">
            <label for="formGroupExampleInput" class="form-label">Trạng thái</label>
            <select class="form-select" aria-label="Default select example" name="trangThai">
                <option value="0">Đang Hoạt động</option>
                <option value="1">Ngừng hoạt động</option>
            </select>
        </div>
        <br>
        <div>
            <button type="submit" class="btn btn-outline-danger">ADD</button>
        </div>
    </form>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
