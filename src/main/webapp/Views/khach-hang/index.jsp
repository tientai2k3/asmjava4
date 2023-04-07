<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 11:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h4>Quản lý khách hàng</h4>
        <hr>
        <br>
        <a href="create" class="btn btn-outline-danger">Thêm mới</a>
        <br>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã KH</th>
                <th scope="col">Tên</th>
                <th scope="col">Tên đệm</th>
                <th scope="col">Họ</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">SĐT</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Thành phố</th>
                <th scope="col">Quốc gia</th>
                <th scope="col" colspan="2">Thao tác</th>

            </tr>
            </thead>
            <tbody>
            <c:if test="${f:length(ds)==0}">
                <span>Không có dữ liệu</span>
            </c:if>
            <c:if test="${f:length(ds)!=0}">
                <c:forEach items="${ ds }" var="kh">
                    <tr>
                        <th scope="row">${kh.ma}</th>
                        <td>${kh.ten}</td>
                        <td>${kh.tenDem}</td>
                        <td>${kh.ho}</td>
                        <td>${kh.ngaySinh}</td>
                        <td>${kh.sdt}</td>
                        <td>${kh.diaChi}</td>
                        <td>${kh.matKhau}</td>
                        <td>${kh.thanhPho == "hn"?"Hà Nội" : kh.thanhPho =="hcm" ? "TP. Hồ Chí Minh" : "Đà Nẵng"}</td>
                        <td>${kh.quocGia =="vn" ?"Việt Nam" : kh.quocGia =="nb"? "Nhật Bản" :"Trung Quốc"}</td>
                        <td><a href="/Buoi2_war_exploded/khach-hang/edit?ma=${kh.ma}"  class="btn btn-success">Sửa</a></td>
                        <td><a href="/Buoi2_war_exploded/khach-hang/delete?ma=${kh.ma}"  class="btn btn-danger">Xóa</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
    <script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
