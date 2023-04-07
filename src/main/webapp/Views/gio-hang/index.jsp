<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01/04/2023
  Time: 1:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
</head>
<body>
    <h4>Quản lý giỏ hàng</h4>
    <hr>
    <br>
    <a href="create" class="btn btn-outline-danger">Thêm mới</a>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Mã Giỏ Hàng</th>
                <th scope="col">Mã Khách hàng</th>
                <th scope="col">Mã nhân viên</th>
                <th scope="col">Ngày tạo</th>
                <th scope="col">Ngày thanh toán</th>
                <th scope="col">Tên người nhận</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">SĐT</th>
                <th scope="col">Tình trạng</th>
                <th scope="col" colspan="2">Thao tác</th>
            </tr>
        </thead>
        <tbody>
        <c:if test="${f:length(ds)==0}">
            <span>Không có dữ liệu</span>
        </c:if>
        <c:if test="${f:length(ds) !=0}">
            <c:forEach items="${ds}" var="gh">
                <tr>
                    <th scope="row">${gh.ma}</th>
                    <td>${gh.idKH.ma}</td>
                    <td>${gh.idNV.ma}</td>
                    <td>${gh.ngayTao}</td>
                    <td>${gh.ngayThanhToan}</td>
                    <td>${gh.tenNguoiNhan}</td>
                    <td>${gh.diaChi}</td>
                    <td>${gh.sdt}</td>
                    <td>${gh.tinhTrang == 0? "Đã xác nhận":"Chưa xác nhận"}</td>
                    <td><a href="edit?id=${gh.id}&ma=${gh.ma}" class="btn btn-success">Sửa</a></td>
                    <td><a href="delete?id=${gh.id}"  class="btn btn-danger">Xóa</a></td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</body>
</html>
