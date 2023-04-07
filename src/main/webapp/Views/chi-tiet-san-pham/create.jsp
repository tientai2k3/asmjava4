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
    <form action="/Buoi2_war_exploded/chi-tiet-san-pham/store" method="POST">
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Sản phẩm</label>
                <select class="form-select" aria-label="Default select example" name="sanPham">
                    <c:forEach items="${dsSanPham}" var="sp">
                        <option value="${sp.ma}">${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Nhà sản xuất</label>
                <select class="form-select" aria-label="Default select example" name="nhaSX">
                    <c:forEach items="${dsNSX}" var="nsx">
                        <option value="${nsx.ma}">${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Màu sắc</label>
                <select class="form-select" aria-label="Default select example" name="mauSac">
                    <c:forEach items="${dsMauSac}" var="ms">
                        <option value="${ms.ma}">${ms.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Dòng Sản Phẩm</label>
                <select class="form-select" aria-label="Default select example" name="dongSP">
                    <c:forEach items="${dsDongSP}" var="dsp">
                        <option value="${dsp.ma}">${dsp.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Năm Bảo Hành</label>
                <input type="number" class="form-control" name="namBH" >
                <p>${txtNamBH}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Mô tả</label>
                <input type="text" class="form-control" name="moTa" >
                <p>${txtMoTa}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="formGroupExampleInput" class="form-label">Số lượng tồn</label>
                <input type="number" class="form-control" name="soLuongTon" >
                <p>${txtSoLuongTon}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Giá Nhập</label>
                <input type="number" class="form-control" name="giaNhap" >
                <p>${txtGiaNhap}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Giá bán</label>
                <input type="number" class="form-control" name="giaBan" >
                <p>${txtGiaBan}</p>
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
