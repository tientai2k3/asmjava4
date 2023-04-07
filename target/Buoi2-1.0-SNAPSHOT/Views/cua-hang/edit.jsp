<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:28 CH
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
        <h2>Quản lý cửa hàng</h2>
        <br>
        <form action="/Buoi2_war_exploded/cua-hang/update?ma=${qlch.ma}" method="POST">
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Mã cửa hàng</label>
                <input type="text" class="form-control" id="formGroupExampleInput" name="ma" disabled value="${qlch.ma}">
                <p>${txtMa}</p>
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Tên cửa hàng</label>
                <input type="text" class="form-control" id="formGroupExampleInput2" name="ten" value="${qlch.ten}">
                <p>${txtTen}</p>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <label for="formGroupExampleInput" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi"  value="${qlch.diaChi}">
                    <p>${txtDC}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Thành phố</label>
                    <select class="form-select" aria-label="Default select example" name="thanhPho">
                        <option value="hn" ${qlch.thanhPho == "hn" ? "selected":""} >Hà Nội</option>
                        <option value="hcm" ${qlch.thanhPho == "hcm" ? "selected":""}>TP.HCM</option>
                        <option value="dn" ${qlch.thanhPho == "dn" ? "selected":""}>Đà Nẵng</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Quốc gia</label>
                    <select class="form-select" aria-label="Default select example" name="quocGia">
                        <option value="vn"  ${qlch.quocGia == "vn" ? "selected":""}>Việt nam</option>
                        <option value="nb"  ${qlch.quocGia == "nb" ? "selected":""}>Nhật bản</option>
                        <option value="tq"  ${qlch.quocGia == "tq" ? "selected":""}>Trung Quốc</option>
                    </select>
                </div>
            </div>
            <br>
            <div>
                <button type="submit" class="btn btn-outline-danger">UPDATE</button>
            </div>
        </form>
    </div>
    <script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
