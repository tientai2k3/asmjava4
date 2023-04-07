<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14/03/2023
  Time: 3:31 CH
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
<div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-md-9 col-lg-6 col-xl-5">
            <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                    class="img-fluid"
                    alt="Sample image"
            />
        </div>
        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
            <form action="/Buoi2_war_exploded/dang-nhap" method="POST">
                <div class="divider d-flex align-items-center my-4">
                    <h4 class="text-center fw-bold mx-3 mb-0">Login</h4>
                </div>

                <div class="form-outline mb-4">
                    <input
                            class="form-control form-control-lg"
                            placeholder="Enter username"
                            name="ma" value="${ma}"
                    />
                    <p>${txtUser}</p>
<%--                    <p>${txtUser}</p>--%>
                </div>

                <!-- Password input -->
                <div class="form-outline mb-3">
                    <input
                            type="password"
                            id="form3Example4"
                            class="form-control form-control-lg"
                            placeholder="Enter password"
                            name="matKhau" value="${matKhau}"
                    />
                    <p>${txtPass}</p>
                </div>

                <div class="d-flex justify-content-between align-items-center">
                    <!-- Checkbox -->
                    <div class="form-check mb-0">
                        <input
                                class="form-check-input me-2"
                                type="checkbox"
                                id="form2Example3"
                        />
                        <label class="form-check-label" for="form2Example3">
                            Remember me
                        </label>
                    </div>
                    <!-- <a href="#!" class="text-body">Forgot password?</a> -->
                </div>

                <div class="text-center text-lg-start mt-4 pt-2">
                    <button
                            type="submit"
                            class="btn btn-primary btn-lg"
                    >
                        Login
                    </button>
                    <p class="small fw-bold mt-2 pt-1 mb-0">
                        Don't have an account?
                        <a href="/Buoi2_war_exploded/user/dang-ki" class="link-danger">Register</a>
                    </p>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/Buoi2_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
