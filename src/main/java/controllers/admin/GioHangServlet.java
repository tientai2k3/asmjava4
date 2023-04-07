package controllers.admin;

import DomainModels.*;
import Service.GioHangService;
import Service.Impl.GioHangServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import views_models.QLNhanVien;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

@WebServlet(name = "GioHangServlet", value = {
        "/gio-hang/create",
        "/gio-hang/store",
        "/gio-hang/edit",
        "/gio-hang/update",
        "/gio-hang/index",
        "/gio-hang/delete",
})
public class GioHangServlet extends HttpServlet {
    private GioHangService ghService = new GioHangServiceImpl();
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

    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("ds",ghService.findAllGioHang());
        request.setAttribute("view","/Views/gio-hang/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setAttribute("dsKhachHang",ghService.findAllKhachHang());
        request.setAttribute("dsNhanVien",ghService.findAllNhanVien());
        request.setAttribute("view", "/Views/gio-hang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        GioHang gh = ghService.findById(UUID.fromString(request.getParameter("id")));
        request.setAttribute("gh",gh);
        request.setAttribute("dsKhachHang",ghService.findAllKhachHang());
        request.setAttribute("dsNhanVien",ghService.findAllNhanVien());
        request.setAttribute("view", "/Views/gio-hang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        GioHang gh = (GioHang) ghService.findById(id);
        ghService.delete(id);
        response.sendRedirect("index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;

        String ma = request.getParameter("ma");
        String ngayTao = request.getParameter("ngayTao");
        String ngayThanhToan = request.getParameter("ngayThanhToan");
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
        for (GioHang x:ghService.findAllGioHang()) {
            if (ma.equals(x.getMa())){
                String loiMa = "Hiện tại đã có mã này, vui lòng nhập mã khác";
                request.setAttribute("txtMa", loiMa);
                dem++;
            }
        }
        if (ngayTao.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày tạo";
            request.setAttribute("txtNgayTao",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNgayTao","");
        }
        if (ngayThanhToan.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày thanh toán";
            request.setAttribute("txtNgayThanhToan",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNgayThanhToan","");
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
                NhanVien nv = ghService.findbyMaNV(request.getParameter("nhanVien"));
                KhachHang kh = ghService.findbyMaKH(request.getParameter("khachHang"));
                System.out.println(nv.getMa()+" "+kh.getMa());
                gh.setIdKH(kh);
                gh.setIdNV(nv);
                gh.setTinhTrang(tinhTrang);
                BeanUtils.populate(gh, request.getParameterMap());

                ghService.insert(gh);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("view", "/Views/gio-hang/create.jsp");
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

        String ma = request.getParameter("ma");
        String ngayTao = request.getParameter("ngayTao");
        String ngayThanhToan = request.getParameter("ngayThanhToan");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String tenNguoiNhan = request.getParameter("tenNguoiNhan");
        int tinhTrang = Integer.parseInt(request.getParameter("tinhTrang"));
//        if (ma.isEmpty()){
//            String loiMa = "Bạn cần phải nhập mã";
//            request.setAttribute("txtMa",loiMa);
//            dem ++;
//        } else {
//            request.setAttribute("txtMa","");
//        }
//        for (GioHang x:ghService.findAllGioHang()) {
//            if (ma.equals(x.getMa())){
//                String loiMa = "Hiện tại đã có mã này, vui lòng nhập mã khác";
//                request.setAttribute("txtMa", loiMa);
//                dem++;
//            }
//        }
        if (ngayTao.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày tạo";
            request.setAttribute("txtNgayTao",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNgayTao","");
        }
        if (ngayThanhToan.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày thanh toán";
            request.setAttribute("txtNgayThanhToan",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNgayThanhToan","");
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
            String ma1 = request.getParameter("ma");
            GioHang gh = ghService.findByMa(ma1);
            System.out.println(gh.getDiaChi());
                NhanVien nv = ghService.findbyMaNV(request.getParameter("nhanVien"));
                KhachHang kh = ghService.findbyMaKH(request.getParameter("khachHang"));
                System.out.println(nv.getMa()+" "+kh.getMa());
                gh.setIdKH(kh);
                gh.setIdNV(nv);
                gh.setTinhTrang(tinhTrang);
                gh.setNgayTao(Date.valueOf(ngayTao));
                gh.setNgayThanhToan(Date.valueOf(ngayThanhToan));
                gh.setDiaChi(diaChi);
                gh.setSdt(sdt);
                gh.setTenNguoiNhan(tenNguoiNhan);
                gh.setMa(ma);
                ghService.update(gh);
                response.sendRedirect("index");

        }else {
            request.setAttribute("ma",ma);
            request.setAttribute("view", "/Views/gio-hang/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
}
