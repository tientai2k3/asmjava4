<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:30 CH
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
    <h4>SHOP</h4>
    <hr>
    <br>
    <br>
    <form action="/Buoi2_war_exploded/shop/themSP?idGH=${idGH}" method="post">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã Sản Phẩm</th>
                <th scope="col">Mã Nhà sản xuất</th>
                <th scope="col">Mã màu sắc</th>
                <th scope="col">Mã dòng sản phẩm</th>
                <th scope="col">Năm bảo hành</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Số lượng tồn</th>
                <th scope="col">Giá nhập</th>
                <th scope="col">Giá bán</th>
                <th scope="col" >Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${f:length(ds)==0}">
                <span>Không có dữ liệu</span>
            </c:if>
            <c:if test="${f:length(ds)!=0}">
                <c:forEach items="${ds}" var="ctsp">
                    <tr>
                        <th scope="row">${ctsp.idSP.ma}</th>
                        <th scope="row">${ctsp.idNsx.ma}</th>
                        <th scope="row">${ctsp.idMauSac.ma}</th>
                        <th scope="row">${ctsp.idDongSP.ma}</th>
                        <td>${ctsp.namBH}</td>
                        <td>${ctsp.moTa}</td>
                        <td>${ctsp.soLuongTon}</td>
                        <td>${ctsp.giaNhap}</td>
                        <td name="donGia">${ctsp.giaBan}</td>
                        <td><a href="/Buoi2_war_exploded/shop/themGHCT?idCTSP=${ctsp.id}&idGH=${idGH}" class="btn btn-success">Add</a></td>
<%--                        <td><button type="submit" class="btn btn-success">ADD</button></td>--%>
                    </tr>

                </c:forEach>
            </c:if>
<%--            <a href="/Buoi2_war_exploded/shop/themSP" class="btn btn-outline-danger">Back</a>--%>
            </tbody>
        </table>
    </form>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
