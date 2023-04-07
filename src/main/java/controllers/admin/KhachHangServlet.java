package controllers.admin;

import DomainModels.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import views_models.QLKhachHang;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/khach-hang/index",
        "/khach-hang/create",
        "/khach-hang/store",
        "/khach-hang/edit",
        "/khach-hang/update",
        "/khach-hang/delete",
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    public KhachHangServlet() {
        khRepo = new KhachHangRepository();
    }

    @Override
    public void init(){
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException{
        String url = request.getRequestURI();
        if (url.contains("create")){
            this.create(request,response);
        }
        else if (url.contains("edit")){
            this.edit(request,response);
        }
        else if (url.contains("delete")){
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
        if (url.contains("update")){
            this.update(request,response);
        }else if (url.contains("store")){
            this.store(request,response);
        }else {
            response.sendRedirect("index");
        }

    }
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/Views/khach-hang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {


        request.setAttribute("ds",khRepo.findAll());
        request.setAttribute("view","/Views/khach-hang/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang khDm = khRepo.findbyMa(ma);
        request.setAttribute("qlkh",khDm);
        request.setAttribute("view","/Views/khach-hang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
    String ma = request.getParameter("ma");
    KhachHang vm = khRepo.findbyMa(ma);
    this.khRepo.delete(vm);

    response.sendRedirect("index");
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
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtMa","");
        }
        for (KhachHang x:khRepo.findAll()) {
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
        if (sdt.trim().length() !=10){
            String loiSDT = "Bạn cần phải nhập sđt đúng địng dạng";
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
            KhachHang kh = new KhachHang();
            try {
                BeanUtils.populate(kh, request.getParameterMap());
                this.khRepo.insert(kh);
                response.sendRedirect("index");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("view", "/Views/khach-hang/create.jsp");
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
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

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
        if (sdt.trim().length() !=10){
            String loiSDT = "Bạn cần phải nhập sđt đúng địng dạng";
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
            KhachHang khDm = khRepo.findbyMa(ma1);
            try {
                BeanUtils.populate(khDm, request.getParameterMap());
                this.khRepo.update(khDm);
                response.sendRedirect("index");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("view", "/Views/khach-hang/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }


}
