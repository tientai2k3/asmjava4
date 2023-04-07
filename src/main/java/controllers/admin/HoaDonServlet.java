package controllers.admin;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Service.HoaDonService;
import Service.Impl.HoaDonServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.UUID;

@WebServlet(name = "HoaDonServlet", value = {
        "/hoa-don/index",
        "/hoa-don/create",
        "/hoa-don/store",
        "/hoa-don/edit",
        "/hoa-don/update",
        "/hoa-don/delete",
})
public class HoaDonServlet extends HttpServlet {
    private HoaDonService hdService = new HoaDonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("create")) {
            this.create(request, response);
        } else if (url.contains("edit")) {
            this.edit(request, response);
        } else if (url.contains("delete")) {
            this.delete(request, response);
        } else {
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
//        HttpSession session = request.getSession();
//        NhanVien nv = (NhanVien) session.getAttribute("user");
//        request.setAttribute("ds", hdService.findAllHoaDonByIdNV(nv.getId()));
        request.setAttribute("ds", hdService.findAllHoaDon());
        request.setAttribute("view", "/Views/hoa-don/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setAttribute("dsKhachHang", hdService.findAllKhachHang());
        request.setAttribute("dsNhanVien", hdService.findAllNhanVien());
        request.setAttribute("view", "/Views/hoa-don/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HoaDon hd = hdService.findByID(UUID.fromString(request.getParameter("id")));
        request.setAttribute("dsKhachHang", hdService.findAllKhachHang());
        request.setAttribute("dsNhanVien", hdService.findAllNhanVien());
        request.setAttribute("qlhd", hd);
        request.setAttribute("view", "/Views/hoa-don/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        hdService.delete(id);
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
        String ngayShip = request.getParameter("ngayThanhToan");
        String ngayNhan = request.getParameter("ngayNhan");
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
        if (ngayShip.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày ship";
            request.setAttribute("txtNgayShip",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNgayShip","");
        }
        if (ngayNhan.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày nhận";
            request.setAttribute("txtNgayNhan",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNgayNhan","");
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
            HoaDon gh = new HoaDon();
            try {
                NhanVien nv = hdService.findbyMaNV(request.getParameter("nhanVien"));
                KhachHang kh = hdService.findbyMaKH(request.getParameter("khachHang"));
                System.out.println(nv.getMa()+" "+kh.getMa());
                gh.setIdKH(kh);
                gh.setIdNV(nv);
                gh.setTinhTrang(tinhTrang);
                gh.setMa(ma);
                BeanUtils.populate(gh, request.getParameterMap());

                hdService.insert(gh);
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
        String ngayShip = request.getParameter("ngayThanhToan");
        String ngayNhan = request.getParameter("ngayNhan");
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
        if (ngayShip.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày ship";
            request.setAttribute("txtNgayShip",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNgayShip","");
        }
        if (ngayNhan.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày nhận";
            request.setAttribute("txtNgayNhan",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNgayNhan","");
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
            HoaDon hd = hdService.findByMa(request.getParameter("ma"));
            System.out.println(hd.getDiaChi());
            NhanVien nv = hdService.findbyMaNV(request.getParameter("nhanVien"));
            KhachHang kh = hdService.findbyMaKH(request.getParameter("khachHang"));
            System.out.println(nv.getMa()+" "+kh.getMa());
            hd.setIdKH(kh);
            hd.setIdNV(nv);
            hd.setTinhTrang(tinhTrang);
            hd.setNgayTao(Date.valueOf(ngayTao));
            hd.setNgayThanhToan(Date.valueOf(ngayThanhToan));
            hd.setNgayShip(Date.valueOf(ngayShip));
            hd.setNgayNhan(Date.valueOf(ngayNhan));
            hd.setDiaChi(diaChi);
            hd.setSdt(sdt);
            hd.setTenNguoiNhan(tenNguoiNhan);
            hd.setMa(ma);
            hdService.update(hd);
            System.out.println("thành công ");
            response.sendRedirect("index");

        }else {
            request.setAttribute("ma",ma);
            request.setAttribute("view", "/Views/hoa-don/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }

}