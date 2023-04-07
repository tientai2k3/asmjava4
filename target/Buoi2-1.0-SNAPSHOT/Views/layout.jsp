<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17/03/2023
  Time: 11:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/plugin/bootstrap.min.css">
    <link rel="stylesheet" href="/Buoi2_war_exploded/css/custom/index.css">
    <link
            rel="stylesheet"
            href="/Buoi2_war_exploded/css/custom/fontawesome-free-6.0.0-web/css/all.min.css"
    />

</head>
<body>
<div class="container">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <!-- Container wrapper -->
            <div class="container-fluid">
                <!-- Toggle button -->
                <button
                        class="navbar-toggler"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <i class="fas fa-bars"></i>
                </button>

                <!-- Collapsible wrapper -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!-- Navbar brand -->
                    <a class="navbar-brand mt-2 mt-lg-0" href="san-pham/index" style="width: 140px">
                        <img
                                src="https://upload.wikimedia.org/wikipedia/vi/thumb/3/37/Bitis_logo.svg/1200px-Bitis_logo.svg.png"
                                style="max-width: 50%"
                        />
                    </a>
                    <!-- Left links -->
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="/Buoi2_war_exploded/shop/indexGioHang">SHOP</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Buoi2_war_exploded/chi-tiet-san-pham/index">CHI TIẾT SẢN PHẨM</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Buoi2_war_exploded/san-pham/index">SẢN PHẨM</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Buoi2_war_exploded/nhan-vien/index">NHÂN VIÊN</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Buoi2_war_exploded/khach-hang/index">KHÁCH HÀNG</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Buoi2_war_exploded/cua-hang/index">CỦA HÀNG</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Buoi2_war_exploded/nsx/index">NHÀ SẢN XUẤT</a>
                        </li>
                    </ul>
                    <!-- Left links -->
                </div>
                <!-- Collapsible wrapper -->

                <!-- Right elements -->
                <div class="d-flex align-items-center">
                    <!-- Icon -->
                    <a class="text-reset me-3" href="/Buoi2_war_exploded/shop/indexGioHang">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </a>
                    <div class="li">
                        <li class="nav-item dropdown">
                            <a
                                    class="nav-link dropdown-toggle"
                                    href="#"
                                    role="button"
                                    data-bs-toggle="dropdown"
                                    aria-expanded="false"
                            >
                                Xin chào ${sessionScope.user.ma}
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a class="dropdown-item" href="#">My Order</a>
                                </li>
                                <li>
                                    <a class="dropdown-item">Category</a>
                                </li>
                                <li>
                                    <hr class="dropdown-divider"/>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/Buoi2_war_exploded/dang-xuat">Log out</a>
                                </li>
                            </ul>
                        </li>
                    </div>
                </div>
                <!-- Right elements -->
            </div>
            <!-- Container wrapper -->
        </nav>
    </header>
    <br>
    <section>
        <div class="row">
            <div class="col-md-3">
                <h4>QUẢN LÝ</h4>
                <hr>
                <br>
                <div class="list-group">
                    <a class="list-group-item list-group-item-action" href="/Buoi2_war_exploded/mau-sac/index">Quản lý
                        màu sắc</a>
                    <a class="list-group-item list-group-item-action" href="/Buoi2_war_exploded/dongsp/index">Quản lý
                        dòng sản phẩm</a>
                    <a class="list-group-item list-group-item-action" href="/Buoi2_war_exploded/chuc-vu/index">Quản lý
                        chức vụ</a>
                    <a class="list-group-item list-group-item-action" href="/Buoi2_war_exploded/hoa-don/index">Quản lý
                        Hóa đơn</a>
                    <a class="list-group-item list-group-item-action" href="/Buoi2_war_exploded/gio-hang/index">Quản lý
                        Giỏ hàng</a>
                    <a class="list-group-item list-group-item-action" href="/Buoi2_war_exploded/gio-hang-chi-tiet/index">Quản lý
                        Giỏ hàng chi tiết</a>
                </div>
            </div>
            <div class="col-md-9">
                <jsp:include page="${view}"></jsp:include>
            </div>
        </div>
    </section>
</div>
<footer>
    <div class="container">
        <div class="row foo">
            <div class="col-lg-4 col-md-6">
                <div class="anh">
                    <img
                            src="https://upload.wikimedia.org/wikipedia/vi/thumb/3/37/Bitis_logo.svg/1200px-Bitis_logo.svg.png"
                            alt=""
                            style="max-width: 30%"
                    />
                </div>
                <ul class="diachi">
                    <li>Address: Hòa Chính-Chương Mỹ-Hà Nội</li>
                    <li>Phone: +84972 758 663</li>
                    <li>Email: taintph26788@fpt.edu.vn</li>
                </ul>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="footer__about">
                    <h5><b>Useful Links</b></h5>
                    <ul>
                        <li><a href="" #>About Us</a></li>
                        <li><a href="">About Our Shop</a></li>
                        <li><a href="">Secure Shopping</a></li>
                        <li><a href="">Delivery infomation</a></li>
                        <li><a href="">Privacy Policy</a></li>
                        <li><a href="">Our Sitemap</a></li>
                    </ul>
                    <ul>
                        <li><a href="">Who We Are</a></li>
                        <li><a href="">Our Services</a></li>
                        <li><a href="">Projects</a></li>
                        <li><a href="https://zalo.me/0972758663">Contact</a></li>
                        <li><a href="">Innovation</a></li>
                        <li><a href="">Testimonials</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-12">
                <div class="footer__email">
                    <h5><b>Join Our Newsletter Now</b></h5>
                    <p>Get E-mail updates about our latest shop and special offers.</p>
                    <form action="" class="form">
                        <input type="text" placeholder="Enter Your Email"/>
                        <button type="submit" class="btn">SUBSCRIBE</button>
                    </form>
                    <div class="logo">
                        <a href="https://www.facebook.com/nguyentientai.xx/"
                        ><i class="fa-brands fa-facebook-f"></i
                        ></a>
                        <a href="https://www.instagram.com/im_t.tai/"
                        ><i class="fa-brands fa-instagram"></i
                        ></a>
                        <a href="https://zalo.me/0972758663"
                        ><i class="fa-solid fa-phone"></i
                        ></a>
                        <a href="https://www.youtube.com/channel/UCi4rQSq51MIeqtwzbJAaBnA"
                        ><i class="fa-brands fa-youtube"></i
                        ></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<script src="/Buoi2_war_exploded/js/plugin/bootstrap.bundle.js"></script>
</body>
</html>
