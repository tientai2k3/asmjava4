<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08/03/2023
  Time: 11:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/custom/index2.css">
    <style>
        p{
            font-size: 16px;
            color: red;
            font-style: italic;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Quản lý khách hàng</h2>
        <br>
        <form method="POST" action="/Buoi2_war_exploded/khach-hang/update?ma=${qlkh.ma}">
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Mã KH</label>
                    <input type="text" class="form-control" name="ma" value="${qlkh.ma}" disabled>
                    <p>${txtMa}</p>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten"  value="${qlkh.ten}">
                    <p>${txtTen}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem"  value="${qlkh.tenDem}">
                    <p>${txtTenDem}</p>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho"  value="${qlkh.ho}">
                    <p>${txtHo}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh"  value="${qlkh.ngaySinh}">
                    <p>${txtNS}</p>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">SDT</label>
                    <input type="number" class="form-control" name="sdt"  value="${qlkh.sdt}">
                    <p>${txtSDT}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi"  value="${qlkh.diaChi}">
                    <p>${txtDC}</p>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau"  value="${qlkh.matKhau}">
                    <p>${txtMK}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Thành phố</label>
                    <select class="form-select" aria-label="Default select example" name="thanhPho">
                        <option value="hn" ${qlkh.thanhPho == "hn" ? "selected":""} >Hà Nội</option>
                        <option value="hcm" ${qlkh.thanhPho == "hcm" ? "selected":""}>TP.HCM</option>
                        <option value="dn" ${qlkh.thanhPho == "dn" ? "selected":""}>Đà Nẵng</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="formGroupExampleInput" class="form-label">Quốc gia</label>
                    <select class="form-select" aria-label="Default select example" name="quocGia">
                        <option value="vn"  ${qlkh.quocGia == "vn" ? "selected":""}>Việt nam</option>
                        <option value="nb"  ${qlkh.quocGia == "nb" ? "selected":""}>Nhật bản</option>
                        <option value="tq"  ${qlkh.quocGia == "tq" ? "selected":""}>Trung Quốc</option>
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
