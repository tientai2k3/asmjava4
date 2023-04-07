<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01/04/2023
  Time: 1:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="" method="POST">
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Hóa Đơn</label>
                <select class="form-select" aria-label="Default select example" name="idHoaDon">
                    <%--                        <c:forEach items="${dsIdCV}" var="cv">--%>
                    <%--                            <option value="${cv.id}">${cv.ma}</option>--%>
                    <%--                        </c:forEach>--%>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Chi Tiết Sản Phẩm</label>
                <select class="form-select" aria-label="Default select example" name="idChiTietSP">
                    <%--                        <c:forEach items="${dsIdCH}" var="ch">--%>
                    <%--                            <option value="${ch.id}">${ch.ma}</option>--%>
                    <%--                        </c:forEach>--%>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Số lượng</label>
                <input type="text" class="form-control" name="soLuong" >
                <p>${txtSoLuong}</p>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Đơn Giá</label>
                <input type="number" class="form-control" name="donGia" >
                <p>${txtDonGia}</p>
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
