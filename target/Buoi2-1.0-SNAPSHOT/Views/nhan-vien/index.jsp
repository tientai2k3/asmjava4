<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
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
    <h4>Quản lý nhân viên</h4>
    <hr>
    <br>
    <a href="create"class="btn btn-outline-danger">Thêm mới</a>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã NV</th>
            <th scope="col">Tên</th>
            <th scope="col">Tên đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">SĐT</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Chức vụ</th>
            <th scope="col">Cửa hàng</th>
            <th scope="col">Trạng thái</th>
            <th scope="col" colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${f:length(ds)==0}">
            <span>Không có dữ liệu</span>
        </c:if>
        <c:if test="${f:length(ds)!=0}">
            <c:forEach items="${ds}" var="nv">
                <tr>
                    <th scope="row">${nv.ma}</th>
                    <td>${nv.ten}</td>
                    <td>${nv.tenDem}</td>
                    <td>${nv.ho}</td>
                    <td>${nv.gioiTinh=="nam" ?"Nam" :"Nữ"}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.matKhau}</td>
                    <td>${nv.idCV.ten}</td>
                    <td>${nv.idCH.ten}</td>
                    <td>${nv.trangThai ==0?"Đang hoạt động":"Ngừng hoạt động"}</td>
                    <td><a href="edit?ma=${nv.ma}"  class="btn btn-success">Sửa</a></td>
                    <td><a href="delete?ma=${nv.ma}" class="btn btn-danger">Xóa</a></td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
