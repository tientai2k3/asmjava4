package controllers.admin;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Service.ChucVuService;
import Service.CuaHangService;
import Service.Impl.ChucVuServiceImpl;
import Service.Impl.CuaHangserviceImpl;
import Service.Impl.NhanVienServiceImpl;
import Service.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NhanVienRepository;
import views_models.QLNhanVien;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

@WebServlet({
        "/nhan-vien/index",
        "/nhan-vien/create",
        "/nhan-vien/store",
        "/nhan-vien/edit",
        "/nhan-vien/update",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienService nvService = new NhanVienServiceImpl();

    @Override
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        String url = request.getRequestURI();
        if (url.contains("create")){
            this.create(request,response);
        }else if(url.contains("edit")){
            this.edit(request,response);
        }else if(url.contains("delete")){
            this.delete(request,response);
        }
        else{
            this.index(request,response);
        }
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("store")){
            this.store(request,response);
        }else if (url.contains("update")){
            this.update(request,response);
        }else {
            response.sendRedirect("index");
        }
    }
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsIdCV",nvService.getListIdCV());
        request.setAttribute("dsIdCH",nvService.getListIdCH());
        request.setAttribute("view","/Views/nhan-vien/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nvDm = nvService.findByMa(ma);
        request.setAttribute("qlnv",nvDm);
        request.setAttribute("dsIdCV",nvService.getListIdCV());
        request.setAttribute("dsIdCH",nvService.getListIdCH());
        request.setAttribute("view","/Views/nhan-vien/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = nvService.findByMa(ma);
        nvService.delete(nv);
        response.sendRedirect("index");

    }
    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("ds",nvService.findAll());
        request.setAttribute("view","/Views/nhan-vien/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem= request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtMa","");
        }
        for (NhanVien x:nvService.findAll()) {
            if (ma.equals(x.getMa())){
                String loiMa = "Hiện tại đã có mã này, vui lòng nhập mã khác";
                request.setAttribute("txtMa", loiMa);
                dem++;
            }
        }
        if (ten.isEmpty()){
            String loiTen = "Bạn cần phải nhập tên";
            request.setAttribute("txtTen",loiTen);
            dem ++;
        } else {
            request.setAttribute("txtTen","");
        }
        if (tenDem.isEmpty()){
            String loiTenDem = "Bạn cần phải nhập tên đệm";
            request.setAttribute("txtTenDem",loiTenDem);
            dem ++;
        } else {
            request.setAttribute("txtTenDem","");
        }
        if (ho.isEmpty()){
            String loiHo = "Bạn cần phải nhập họ";
            request.setAttribute("txtHo",loiHo);
            dem ++;
        } else {
            request.setAttribute("txtHo","");
        }
        if (ngaySinh.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày sinh";
            request.setAttribute("txtNS",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNS","");
        }
        if (sdt.trim().length()!=10){
            String loiSDT = "Bạn cần phải nhập đúng định dạng sđt";
            request.setAttribute("txtSDT",loiSDT);
            dem ++;
        } else {
            request.setAttribute("txtSDT","");
        }
        if (diaChi.isEmpty()){
            String loiDC = "Bạn cần phải nhập địa chỉ";
            request.setAttribute("txtDC",loiDC);
            dem ++;
        } else {
            request.setAttribute("txtDC","");
        }
        if (matKhau.isEmpty()){
            String loiMK = "Bạn cần phải nhập mật khẩu";
            request.setAttribute("txtMK",loiMK);
            dem ++;
        } else {
            request.setAttribute("txtMK","");
        }

        if (dem==0){
            QLNhanVien nv = new QLNhanVien();
            try {
                ChucVu cv = nvService.findByMaCV(request.getParameter("chucVu"));
                CuaHang ch = nvService.findByMaCH(request.getParameter("cuaHang"));
                System.out.println(cv.getMa()+" "+ch.getMa());
                nv.setIdCH(ch);
                nv.setIdCV(cv);
                BeanUtils.populate(nv, request.getParameterMap());

                nvService.insert(nv);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("view", "/Views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem= request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtMa","");
        }
        if (ten.isEmpty()){
            String loiTen = "Bạn cần phải nhập tên";
            request.setAttribute("txtTen",loiTen);
            dem ++;
        } else {
            request.setAttribute("txtTen","");
        }
        if (tenDem.isEmpty()){
            String loiTenDem = "Bạn cần phải nhập tên đệm";
            request.setAttribute("txtTenDem",loiTenDem);
            dem ++;
        } else {
            request.setAttribute("txtTenDem","");
        }
        if (ho.isEmpty()){
            String loiHo = "Bạn cần phải nhập họ";
            request.setAttribute("txtHo",loiHo);
            dem ++;
        } else {
            request.setAttribute("txtHo","");
        }
        if (ngaySinh.isEmpty()){
            String loiNS = "Bạn cần phải nhập ngày sinh";
            request.setAttribute("txtNS",loiNS);
            dem ++;
        } else {
            request.setAttribute("txtNS","");
        }
        if (sdt.trim().length()!=10){
            String loiSDT = "Bạn cần phải nhập đúng định dạng sđt";
            request.setAttribute("txtSDT",loiSDT);
            dem ++;
        } else {
            request.setAttribute("txtSDT","");
        }
        if (diaChi.isEmpty()){
            String loiDC = "Bạn cần phải nhập địa chỉ";
            request.setAttribute("txtDC",loiDC);
            dem ++;
        } else {
            request.setAttribute("txtDC","");
        }
        if (matKhau.isEmpty()){
            String loiMK = "Bạn cần phải nhập mật khẩu";
            request.setAttribute("txtMK",loiMK);
            dem ++;
        } else {
            request.setAttribute("txtMK","");
        }

        if (dem==0){
            String ma1 = request.getParameter("ma");
            NhanVien nv = nvService.findByMa(ma1);
            try {
                ChucVu cv = nvService.findByMaCV(request.getParameter("chucVu"));
                CuaHang ch = nvService.findByMaCH(request.getParameter("cuaHang"));
                System.out.println(cv.getMa()+" "+ch.getMa());
                nv.setIdCH(ch);
                nv.setIdCV(cv);
                BeanUtils.populate(nv, request.getParameterMap());
                nvService.update(nv);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("view", "/Views/nhan-vien/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }

}
