package controllers.admin;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import Service.Impl.NhanVienServiceImpl;
import Service.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repositories.NhanVienRepository;
import views_models.QLNhanVien;

import java.io.IOException;

@WebServlet({
        "/dang-nhap",
        "/user/dang-ki",
        "/user/tao-tai-khoan"
})
public class UserServlet extends HttpServlet {
    private NhanVienService nvService = new NhanVienServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        String url = request.getRequestURI();
        if (url.contains("dang-ki")){
            this.dangki(request,response);
        }else {
            this.dangnhap(request,response);
        }

    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("dang-nhap")){
            this.storeDangNhap(request,response);
        }else {
            this.storeDangKi(request,response);
        }

    }

    public void dangki(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsIdCV",nvService.getListIdCV());
        request.getRequestDispatcher("/Views/user/dangki.jsp")
                .forward(request, response);
    }
    public void dangnhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/user/dangnhap.jsp")
                .forward(request, response);
    }

    protected void storeDangNhap(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem=0;
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        System.out.println(ma + " " + matKhau);
        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập tên đăng nhập";
            request.setAttribute("txtUser",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtUser","");
        }
        if (matKhau.isEmpty()){
            String loiMatKhau = "Bạn cần phải nhập mật khẩu";
            request.setAttribute("txtPass",loiMatKhau);
            dem ++;
        } else {
            request.setAttribute("txtPass","");
        }

        if (dem!=0) {
            System.out.println("đăng nhập thất bại");
            request.setAttribute("ma",ma);
            request.setAttribute("matKhau",matKhau);
            request.getRequestDispatcher("/Views/user/dangnhap.jsp")
                    .forward(request, response);
            return;
        }
        for (NhanVien x : nvService.findAll()) {
            System.out.println(x.getMa() + " " + x.getMatKhau());
            if (ma.equals(x.getMa()) && matKhau.equals(x.getMatKhau())) {
                HttpSession session = request.getSession();
                session.setAttribute("user",x);
                System.out.println("đăng nhập thành công");
                response.sendRedirect("/Buoi2_war_exploded/shop/indexGioHang");
                return;
            }
        }

        String loiMa = "Tài khoản hoặc mật khẩu không chính xác";
        request.setAttribute("ma",ma);
        request.setAttribute("matKhau",matKhau);
        request.setAttribute("txtUser",loiMa);
        request.getRequestDispatcher("/Views/user/dangnhap.jsp")
                .forward(request, response);


    }
    protected void storeDangKi(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        String matKhau2 = request.getParameter("matKhau2");

        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtUser",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtUser","");
        }
        for (NhanVien x:nvService.findAll()) {
            if (ma.equals(x.getMa())){
                String loiTrung = "Tài khoản này hiện đã có người sử dụng";
                request.setAttribute("txtUser",loiTrung);
                dem++;
            }
        }
        if (matKhau.isEmpty()){
            String loiMK = "Bạn cần phải nhập mật khẩu";
            request.setAttribute("txtPass",loiMK);
            dem ++;
        } else {
            request.setAttribute("txtPass","");
        }
        if (!matKhau2.equals(matKhau)){
            String loiMK2 = "Bạn đã nhập sai mật khẩu bạn vừa nhập";
            request.setAttribute("txtPass2",loiMK2);
            dem++;
        }else {
            request.setAttribute("txtPass2","");
        }
        ChucVu cv = nvService.findByMaCV(request.getParameter("chucVu"));
        if (dem==0){
            QLNhanVien nv = new QLNhanVien(ma,"","","","",null,"","",matKhau,null,cv,0);
            nvService.insert(nv);
            System.out.println("dăng kí thành công");
            response.sendRedirect("/Buoi2_war_exploded/dang-nhap");
        }else {
            System.out.println("Đăng kí thất bại");
            request.setAttribute("ma",ma);
            request.setAttribute("matKhau",matKhau);
            request.setAttribute("matKhau2",matKhau2);
            request.getRequestDispatcher("/Views/user/dangki.jsp")
                    .forward(request, response);
        }

    }
}
