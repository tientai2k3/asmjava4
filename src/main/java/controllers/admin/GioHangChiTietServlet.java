package controllers.admin;

import DomainModels.*;
import Service.GioHangChiTietService;
import Service.Impl.GioHangChiTietServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

@WebServlet(name = "GioHangChiTietServlet", value = {
        "/gio-hang-chi-tiet/index",
        "/gio-hang-chi-tiet/create",
        "/gio-hang-chi-tiet/store",
        "/gio-hang-chi-tiet/edit",
        "/gio-hang-chi-tiet/update",
        "/gio-hang-chi-tiet/delete",
})
public class GioHangChiTietServlet extends HttpServlet {
    private GioHangChiTietService ghctService = new GioHangChiTietServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("create")) {
            this.create(request, response);
        } else if (url.contains("edit")) {
            this.edit(request, response);
        } else if (url.contains("delete")) {
            this.delete(request, response);
        }else {
            this.index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("update")) {
            this.update(request, response);
        } else if (url.contains("store")) {
            this.store(request, response);
        } else {
            response.sendRedirect("index");
        }
    }
    public void create(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setAttribute("dsGioHang",ghctService.findAllGioHang());
        request.setAttribute("dsCTSP",ghctService.findAllChiTietSP());
        request.setAttribute("view", "/Views/gio-hang-chi-tiet/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID idGioHang = UUID.fromString(request.getParameter("idGioHang"));
        UUID idChiTietSP = UUID.fromString(request.getParameter("idChiTietSP"));
        GioHangChiTiet ghct = ghctService.findbyIDGioHangChiTiet(idGioHang,idChiTietSP);
        request.setAttribute("dsGioHang",ghctService.findAllGioHang());
        request.setAttribute("dsCTSP",ghctService.findAllChiTietSP());
        request.setAttribute("ghct",ghct);
        request.setAttribute("view","/Views/gio-hang-chi-tiet/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID idGioHang = UUID.fromString(request.getParameter("idGioHang"));
        UUID idChiTietSP = UUID.fromString(request.getParameter("idChiTietSP"));
        GioHangChiTiet ghct = ghctService.findbyIDGioHangChiTiet(idGioHang,idChiTietSP);
        System.out.println(ghct.getDonGia()+"aaa");
        ghctService.delete(ghct);
        response.sendRedirect("index");
    }

    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("ds",ghctService.findAllGioHangChiTiet());
        request.setAttribute("view","/Views/gio-hang-chi-tiet/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

    //thêm
    protected void store(
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
            GioHangChiTiet ghct = new GioHangChiTiet();
            ChiTietSP ctsp = ghctService.findByIdCTSP(UUID.fromString(request.getParameter("chiTietSP")));
            GioHang gh = ghctService.findByIdGioHang(UUID.fromString(request.getParameter("gioHang")));
            System.out.println(ctsp.getGiaNhap()+" "+gh.getMa()+" ccc");
            int sl = Integer.parseInt(soLuong);
            BigDecimal donGia1 = new BigDecimal(donGia);
            BigDecimal donGiaKhiGiam1 = new BigDecimal(donGiaKhiGiam);
            ghct.setIdChiTietSP(ctsp);
            ghct.setIdGioHang(gh);
            ghct.setSoLuong(sl);
            ghct.setDonGia(donGia1);
            ghct.setDonGiaKhiGiam(donGiaKhiGiam1);
            ghctService.insert(ghct);
            response.sendRedirect("index");
        }else {
            request.setAttribute("view", "/Views/gio-hang-chi-tiet/create.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
    //update
    protected void update(
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

            ChiTietSP ctsp = ghctService.findByIdCTSP(UUID.fromString(request.getParameter("chiTietSP")));
            GioHang gh = ghctService.findByIdGioHang(UUID.fromString(request.getParameter("gioHang")));
            int sl = Integer.parseInt(soLuong);
            BigDecimal donGia1 = new BigDecimal(donGia);
            BigDecimal donGiaKhiGiam1 = new BigDecimal(donGiaKhiGiam);

            ghct.setIdChiTietSP(ctsp);
            ghct.setIdGioHang(gh);
            ghct.setSoLuong(sl);
            ghct.setDonGia(donGia1);
            ghct.setDonGiaKhiGiam(donGiaKhiGiam1);
            ghctService.update(ghct);
            response.sendRedirect("index");
        }else {
            request.setAttribute("view", "/Views/gio-hang-chi-tiet/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
}
