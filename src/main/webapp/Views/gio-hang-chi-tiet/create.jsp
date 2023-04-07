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
    <form action="/Buoi2_war_exploded/gio-hang-chi-tiet/store" method="POST">
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Giỏ Hàng</label>
                <select class="form-select" aria-label="Default select example" name="gioHang">
                    <c:forEach items="${dsGioHang}" var="gh">
                        <option value="${gh.id}">${gh.ma}</option>
                    </c:forEach>
                </select>
                <p>${loi1}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Chi Tiết Sản Phẩm</label>
                <select class="form-select" aria-label="Default select example" name="chiTietSP">
                     <c:forEach items="${dsCTSP}" var="ch">
                         <option value="${ch.id}">${ch.id}</option>
                     </c:forEach>
                    <p>${loi2}</p>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Số lượng</label>
                <input type="number" class="form-control" name="soLuong" >
                <p>${txtSoLuong}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Đơn Giá</label>
                <input type="number" class="form-control" name="donGia" >
                <p>${txtDonGia}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="formGroupExampleInput" class="form-label">Đơn giá khi giảm</label>
                <input type="number" class="form-control" name="donGiaKhiGiam" >
                <p>${txtDonGiaKhiGiam}</p>
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
