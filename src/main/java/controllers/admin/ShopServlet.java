package controllers.admin;

import DomainModels.*;
import Service.*;
import Service.Impl.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@WebServlet(name = "ShopServlet", value = {
        "/shop/indexGioHang",
        "/shop/storeSP",
        "/shop/createGioHang",
        "/shop/storeGioHang",
        "/shop/deleteGioHang",
        "/shop/indexGHCT",
        "/shop/themSP",
        "/shop/deleteSPinGHCT",
        "/shop/themGHCT",
        "/shop/hoa-don",
        "/shop/tao-hoa-don",
        "/shop/danh-sach-hoa-don",
        "/shop/thanh-toan",
        "/shop/hoan-thanh",
        "/shop/editSPinGHCT",
        "/shop/updateGHCT"
})
public class ShopServlet extends HttpServlet {
    private GioHangChiTietService ghctService = new GioHangChiTietServiceImpl();
    private GioHangService ghService = new GioHangServiceImpl();
    private ChiTietSPService ctspService =new ChiTietSPServiceimpl();
    private HoaDonService hdService = new HoaDonServiceImpl();
    private HoaDonChiTietService hdctService = new HoaDonChiTietServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("indexGioHang")) {
            this.indexGioHang(request, response);
        }
        else if (url.contains("createGioHang")){
            this.createGH(request, response);
        }else if(url.contains("deleteGioHang")){
            this.deleteGiohang(request, response);
        }else if (url.contains("indexGHCT")){
            this.gioHangChitiet(request, response);
        }else if (url.contains("themSP")){
            this.ThemSanPham(request, response);
        }else if (url.contains("deleteSPinGHCT")){
            this.deleteSPinGHCT(request, response);
        }else if (url.contains("themGHCT")){
            this.themGHCT(request, response);
        }else if (url.contains("/hoa-don")){
            this.createHoaDon(request, response);
        }else if (url.contains("danh-sach-hoa-don")){
            this.indexHoaDon(request, response);
        }else if (url.contains("thanh-toan")){
            this.hoaDonChiTiet(request, response);
        }else if (url.contains("hoan-thanh")){
            this.updateHoaDon(request, response);
        }else if (url.contains("editSPinGHCT")){
            this.editSPinGHCT(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("storeGioHang")) {
            this.storeGioHang(request, response);
        }else if (url.contains("storeSP")){
            this.storeSP(request, response);
        }else if (url.contains("tao-hoa-don")){
            this.storeHoaDon(request, response);
        }else if (url.contains("updateGHCT")){
            this.updateGHCT(request, response);
        }

    }



    public void hoanThanh(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        GioHang gh= ghService.findById(UUID.fromString(request.getParameter("idGH")));
        gh.setTinhTrang(1);
        ghService.update(gh);
        response.sendRedirect("danh-sach-hoa-don");
    }

    public void editSPinGHCT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID idGioHang = UUID.fromString(request.getParameter("idGioHang"));
        UUID idChiTietSP = UUID.fromString(request.getParameter("idChiTietSP"));
        GioHangChiTiet ghct = ghctService.findbyIDGioHangChiTiet(idGioHang,idChiTietSP);
        request.setAttribute("ghct",ghct);
        request.setAttribute("view","/Views/shop/editGHCT.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

    public void indexHoaDon(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        NhanVien nv = (NhanVien) session.getAttribute("user");
        request.setAttribute("ds", hdService.findAllHoaDonByIdNV(nv.getId()));
        request.setAttribute("view", "/Views/shop/danh-sach-hoa-don.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }

    public void indexGioHang(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        NhanVien nv = (NhanVien) session.getAttribute("user");
        request.setAttribute("ds",ghService.findAllGioHangByIdNV(nv.getId()));
        request.setAttribute("view","/Views/shop/danh-sach-gio-hang.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }


    public void createGH(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setAttribute("dsKhachHang",ghService.findAllKhachHang());
        request.setAttribute("dsNhanVien",ghService.findAllNhanVien());
        request.setAttribute("view", "/Views/shop/create-gio-hang.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }

    public void createHoaDon(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        GioHang gh = ghService.findById(UUID.fromString(request.getParameter("idGH")));
        HttpSession session = request.getSession();
        session.setAttribute("gioHang",gh);

        request.setAttribute("maKH",gh.getIdKH().getMa());
        request.setAttribute("tenKH",gh.getTenNguoiNhan());
        request.setAttribute("diaChiKH",gh.getDiaChi());
        request.setAttribute("sdtKH",gh.getSdt());
        request.setAttribute("nv",gh.getIdNV().getMa());
        request.setAttribute("view", "/Views/shop/create-hoa-don.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }

    public void themGHCT(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        ChiTietSP ctsp = ctspService.findById(UUID.fromString(request.getParameter("idCTSP")));
        request.setAttribute("ctsp",ctsp);
        request.setAttribute("idGH",request.getParameter("idGH"));
        request.setAttribute("view", "/Views/shop/them-ghct.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }

    public void gioHangChitiet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        GioHang gh = ghService.findByMa(request.getParameter("ma"));

        String url = request.getRequestURI()+"?id="+gh.getId()+"&ma="+gh.getMa();
        HttpSession s = request.getSession();
        s.setAttribute("url",url);
        System.out.println(gh.getDiaChi()+"dd");
        request.setAttribute("idGH",gh.getId());
        request.setAttribute("dsGHCT",gh.getListGioHangChiTiet());
        int tong=0;
        for (GioHangChiTiet x:gh.getListGioHangChiTiet()) {
            tong += x.getDonGiaKhiGiam().intValue()*x.getSoLuong();
        }
        request.setAttribute("tongTien",tong);
        request.setAttribute("view","/Views/shop/index-gio-hang-chi-tiet.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

    public void hoaDonChiTiet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        HoaDon hd = hdService.findByID(UUID.fromString(request.getParameter("idHD")));
        HttpSession s = request.getSession();
        GioHang gh = (GioHang) s.getAttribute("gioHang");
        HoaDonChiTiet hdct = new HoaDonChiTiet();
            for (GioHangChiTiet ghChiTiet: gh.getListGioHangChiTiet()) {
                hdct.setDonGia(ghChiTiet.getDonGiaKhiGiam());
                hdct.setSoLuong(ghChiTiet.getSoLuong());
                hdct.setIdChiTietSP(ghChiTiet.getIdChiTietSP());
                hdct.setIdHoaDon(hd);
                hdctService.insert(hdct);
            }

        request.setAttribute("idHD",hd.getId());
        request.setAttribute("dsHDCT",hd.getListHDCT());
        int tong=0;
        for (HoaDonChiTiet x: hd.getListHDCT()) {
            tong += x.getDonGia().intValue()* x.getSoLuong();
        }
        request.setAttribute("tongTien",tong);
        request.setAttribute("view","/Views/shop/index-hoa-don-chi-tiet.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

    public void deleteSPinGHCT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession s = request.getSession();
        String url = (String) s.getAttribute("url");

        System.out.println(url+"v");
        UUID idGioHang = UUID.fromString(request.getParameter("idGioHang"));
        UUID idChiTietSP = UUID.fromString(request.getParameter("idChiTietSP"));
        GioHangChiTiet ghct = ghctService.findbyIDGioHangChiTiet(idGioHang,idChiTietSP);
        ChiTietSP ctsp = ctspService.findById(idChiTietSP);
        ctsp.setSoLuongTon(ctsp.getSoLuongTon()+ghct.getSoLuong());
        ctspService.update(ctsp);
        ghctService.delete(ghct);
        response.sendRedirect(url);

    }

    public void ThemSanPham(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        UUID idGH = UUID.fromString(request.getParameter("idGH"));
        request.setAttribute("idGH",idGH);
//        GioHangChiTiet ghct = ghctService.findGHCTByIdGH(UUID.fromString(request.getParameter("id")));
//        GioHang gh = ghService.findById(UUID.fromString(request.getParameter("idGH")));
        request.setAttribute("ds",ctspService.findAllChiTietSP());
        request.setAttribute("view","/Views/shop/them-san-pham.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

    public void deleteGiohang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        GioHang gh = (GioHang) ghService.findById(id);
        ghService.delete(id);
        response.sendRedirect("indexGioHang");
    }
    protected void storeGioHang(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;

        String ma = request.getParameter("ma");

        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String tenNguoiNhan = request.getParameter("tenNguoiNhan");
        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtMa","");
        }
        for (GioHang x:ghService.findAllGioHang()) {
            if (ma.equals(x.getMa())){
                String loiMa = "Hiện tại đã có mã này, vui lòng nhập mã khác";
                request.setAttribute("txtMa", loiMa);
                dem++;
            }
        }

        if (tenNguoiNhan.isEmpty()){
            String loiTen = "Bạn cần phải nhập tên";
            request.setAttribute("txtTenNguoiNhan",loiTen);
            dem ++;
        } else {
            request.setAttribute("txtTenNguoiNhan","");
        }
        if (diaChi.isEmpty()){
            String loiDC = "Bạn cần phải nhập địa chỉ";
            request.setAttribute("txtDiaChi",loiDC);
            dem ++;
        } else {
            request.setAttribute("txtDiaChi","");
        }
        if (sdt.trim().length()!=10){
            String loiSDT = "Bạn cần phải nhập đúng định dạng sđt";
            request.setAttribute("txtSdt",loiSDT);
            dem ++;
        } else {
            request.setAttribute("txtSdt","");
        }


        if (dem==0){
            GioHang gh = new GioHang();
            try {
                HttpSession session = request.getSession();
                NhanVien nv = (NhanVien) session.getAttribute("user");
                KhachHang kh = ghService.findbyMaKH(request.getParameter("khachHang"));
                System.out.println(nv.getMa()+" "+kh.getMa());
                gh.setIdKH(kh);
                gh.setIdNV(nv);
                gh.setTinhTrang(0);
                long millis=System.currentTimeMillis();
                gh.setNgayTao(new Date(millis));
                gh.setNgayThanhToan(new Date(millis));
                BeanUtils.populate(gh, request.getParameterMap());

                ghService.insert(gh);
                response.sendRedirect("indexGioHang");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("view", "/Views/shop/create-gio-hang.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }


    protected void storeSP(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
            GioHangChiTiet ghct = new GioHangChiTiet();
            boolean check =true;
            ChiTietSP ctsp = ctspService.findById(UUID.fromString(request.getParameter("id")));
            int sl = Integer.parseInt(request.getParameter("soLuong"));

            GioHang gh= ghService.findById(UUID.fromString(request.getParameter("idGH")));
            if (sl<= ctsp.getSoLuongTon()){

                BigDecimal donGia = new BigDecimal(request.getParameter("donGia"));
                BigDecimal donGiaKhiGiam = new BigDecimal(request.getParameter("donGiaKhiGiam"));
                ghct.setIdChiTietSP(ctsp);
                ghct.setIdGioHang(gh);
                ghct.setSoLuong(sl);
                ghct.setDonGia(donGia);
                ghct.setDonGiaKhiGiam(donGiaKhiGiam);

                ghctService.insert(ghct);
                ctsp.setSoLuongTon(ctsp.getSoLuongTon()-sl);
                ctspService.update(ctsp);
                HttpSession s = request.getSession();
                String url = (String) s.getAttribute("url");
                response.sendRedirect(url);
            }else {
                String loi ="Số lượng của sản phẩm không đủ.";
                request.setAttribute("txtSoLuong",loi);
            request.setAttribute("view", "/Views/shop/them-ghct.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
            }

//        System.out.println(url);
//            request.setAttribute("view", "/Views/shop/them-san-pham.jsp");
//            request.getRequestDispatcher("/Views/layout.jsp")
//                    .forward(request, response);
    }

    protected void storeHoaDon(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;

        String ma = request.getParameter("ma");

        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String tenNguoiNhan = request.getParameter("tenNguoiNhan");
        int tinhTrang = Integer.parseInt(request.getParameter("tinhTrang"));
        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtMa","");
        }
        for (HoaDon x:hdService.findAllHoaDon()) {
            if (ma.equals(x.getMa())){
                String loiMa = "Hiện tại đã có mã này, vui lòng nhập mã khác";
                request.setAttribute("txtMa", loiMa);
                dem++;
            }
        }

        if (dem==0){
            HoaDon gh = new HoaDon();
            long millis=System.currentTimeMillis();
                NhanVien nv = hdService.findbyMaNV(request.getParameter("nhanVien"));
                KhachHang kh = hdService.findbyMaKH(request.getParameter("khachHang"));
                gh.setIdKH(kh);
                gh.setIdNV(nv);
                gh.setTinhTrang(1);
                gh.setMa(ma);
                gh.setDiaChi(diaChi);
                gh.setTenNguoiNhan(tenNguoiNhan);
                gh.setSdt(sdt);
                gh.setNgayNhan(new Date(millis));
                gh.setNgayTao(new Date(millis));
                gh.setNgayShip(new Date(millis));
                gh.setNgayThanhToan(null);

                hdService.insert(gh);
                response.sendRedirect("/Buoi2_war_exploded/shop/danh-sach-hoa-don");

        }else {
            request.setAttribute("view", "/Views/shop/create-hoa-don.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }

    protected void updateHoaDon(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        long millis=System.currentTimeMillis();
        HoaDon hd= hdService.findByID(UUID.fromString(request.getParameter("idHD")));
            HttpSession s = request.getSession();
            GioHang gh = (GioHang) s.getAttribute("gioHang");
            gh.setTinhTrang(1);
            ghService.update(gh);
            hd.setTinhTrang(0);
            hd.setNgayThanhToan(new Date(millis));
            hdService.update(hd);
            response.sendRedirect("danh-sach-hoa-don");

    }
    protected void updateGHCT(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;
        String donGiaKhiGiam = request.getParameter("donGiaKhiGiam");
        String soLuong = request.getParameter("soLuong");
        String donGia = request.getParameter("donGia");
        if (soLuong.isEmpty()){
            String loiNBH = "Bạn cần phải nhập số lượng";
            request.setAttribute("txtSoLuong",loiNBH);
            dem ++;
        } else {
            request.setAttribute("txtSoLuong","");
        }
        if (donGia.isEmpty()){
            String loiMoTa = "Bạn cần phải nhập đơn giá";
            request.setAttribute("txtDonGia",loiMoTa);
            dem ++;
        } else {
            request.setAttribute("txtDonGia","");
        }
        if (donGiaKhiGiam.isEmpty()){
            String loiTen1= "Bạn cần phải nhập đơn giá khi giảm";
            request.setAttribute("txtDonGiaKhiGiam",loiTen1);
            dem ++;
        } else {
            request.setAttribute("txtDonGiaKhiGiam","");
        }
        if (dem==0){
            UUID idGioHang = UUID.fromString(request.getParameter("idGioHang"));
            UUID idChiTietSP = UUID.fromString(request.getParameter("idChiTietSP"));
            GioHangChiTiet ghct = ghctService.findbyIDGioHangChiTiet(idGioHang,idChiTietSP);

            ChiTietSP ctsp = ghctService.findByIdCTSP(idChiTietSP);
            GioHang gh = ghctService.findByIdGioHang(idGioHang);
            int sl = Integer.parseInt(soLuong);
            if (sl<=ctsp.getSoLuongTon()){
                BigDecimal donGia1 = new BigDecimal(donGia);
                BigDecimal donGiaKhiGiam1 = new BigDecimal(donGiaKhiGiam);

                ctsp.setSoLuongTon(ctsp.getSoLuongTon()+(ghct.getSoLuong()-sl));
                ctspService.update(ctsp);

                ghct.setIdChiTietSP(ctsp);
                ghct.setIdGioHang(gh);
                ghct.setSoLuong(sl);
                ghct.setDonGia(donGia1);
                ghct.setDonGiaKhiGiam(donGiaKhiGiam1);
                ghctService.update(ghct);

                HttpSession s = request.getSession();
                String url = (String) s.getAttribute("url");
                response.sendRedirect(url);
            }else {
                String loi ="Số lượng của sản phẩm không đủ.";
                request.setAttribute("txtSoLuong",loi);
                request.setAttribute("view", "/Views/shop/editGHCT.jsp");
                request.getRequestDispatcher("/Views/layout.jsp")
                        .forward(request, response);
            }

        }else {
            request.setAttribute("view", "/Views/shop/editGHCT.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
}
