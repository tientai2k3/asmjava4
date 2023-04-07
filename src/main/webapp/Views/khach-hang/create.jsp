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
</head>
<body>
    <div class="container">
        <h2>Quản lý khách hàng</h2>
        <br>
        <form method="POST" action="/Buoi2_war_exploded/khach-hang/store">
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Mã KH</label>
                    <input type="text" class="form-control" name="ma" >
                    <p>${txtMa}</p>
                </div>
                <div class="col-md-6">
                    <label  class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" >
                    <p>${txtTen}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label  class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem" >
                    <p>${txtTenDem}</p>
                </div>
                <div class="col-md-6">
                    <label  class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho" >
                    <p>${txtHo}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" >
                    <p>${txtNS}</p>
                </div>
                <div class="col-md-6">
                    <label  class="form-label">SDT</label>
                    <input type="number" class="form-control" name="sdt" >
                    <p>${txtSDT}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" >
                    <p>${txtDC}</p>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau" >
                    <p>${txtMK}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label  class="form-label">Thành phố</label>
                    <select class="form-select" aria-label="Default select example" name="thanhPho">
                        <option value="hn">Hà Nội</option>
                        <option value="hcm">TP.HCM</option>
                        <option value="dn">Đà Nẵng</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Quốc gia</label>
                    <select class="form-select" aria-label="Default select example" name="quocGia">
                        <option value="vn">Việt nam</option>
                        <option value="nb">Nhật bản</option>
                        <option value="tq">Trung Quốc</option>
                    </select>
                </div>
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
