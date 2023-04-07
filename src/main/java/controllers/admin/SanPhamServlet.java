package controllers.admin;

import DomainModels.SanPham;
import Service.Impl.SanPhamServiceImpl;
import Service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRepository;
import views_models.QLSanPham;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/san-pham/index",
        "/san-pham/create",
        "/san-pham/store",
        "/san-pham/edit",
        "/san-pham/update",
        "/san-pham/delete",
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamService spService = new SanPhamServiceImpl();
    @Override
    public void init(){
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
        request.setAttribute("view","/Views/san-pham/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham spDm = spService.findByMa(ma);
        request.setAttribute("qlsp",spDm);
        request.setAttribute("view","/Views/san-pham/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham spDm = spService.findByMa(ma);
        spService.delete(spDm);
        response.sendRedirect("index");
    }
    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("ds",spService.findAll());
        request.setAttribute("view","/Views/san-pham/index.jsp");
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

        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtMa","");
        }
        for (QLSanPham x:spService.findAll()) {
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
        if (dem==0){
            QLSanPham sp = new QLSanPham();
            try {
                BeanUtils.populate(sp,request.getParameterMap());
                spService.insert(sp);
                response.sendRedirect("index");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("ma",ma);
            request.setAttribute("view", "/Views/san-pham/create.jsp");
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
        if (dem==0){
            String ma1 = request.getParameter("ma");
            SanPham sp =spService.findByMa(ma1);
            try {
                BeanUtils.populate(sp,request.getParameterMap());
                spService.update(sp);
                response.sendRedirect("index");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("ma",ma);
            request.setAttribute("view", "/Views/san-pham/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
}
