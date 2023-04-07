package controllers.admin;

import DomainModels.CuaHang;
import Service.CuaHangService;
import Service.Impl.CuaHangserviceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepository;
import views_models.QlCuaHang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/cua-hang/index",
        "/cua-hang/create",
        "/cua-hang/store",
        "/cua-hang/edit",
        "/cua-hang/update",
        "/cua-hang/delete",
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangService chService = new CuaHangserviceImpl();

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
        request.setAttribute("view","/Views/cua-hang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);


    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang chDm= chService.findByMa(ma);
        request.setAttribute("qlch",chDm);
        request.setAttribute("view","/Views/cua-hang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);

    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang vm= chService.findByMa(ma);
        chService.delete(vm);
        response.sendRedirect("index");
    }
    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("ds",chService.findAll());
        request.setAttribute("view","/Views/cua-hang/index.jsp");
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
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        if (ma.isEmpty()){
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa",loiMa);
            dem ++;
        } else {
            request.setAttribute("txtMa","");
        }
        for (QlCuaHang x:chService.findAll()) {
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
        if (diaChi.isEmpty()){
            String loiDC = "Bạn cần phải nhập địa chỉ";
            request.setAttribute("txtDC",loiDC);
            dem ++;
        } else {
            request.setAttribute("txtDC","");
        }
        if (dem==0){
            QlCuaHang ch = new QlCuaHang();
            try {
                BeanUtils.populate(ch, request.getParameterMap());
                chService.insert(ch);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("view", "/Views/cua-hang/create.jsp");
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
        String diaChi = request.getParameter("diaChi");
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
        if (diaChi.isEmpty()){
            String loiDC = "Bạn cần phải nhập địa chỉ";
            request.setAttribute("txtDC",loiDC);
            dem ++;
        } else {
            request.setAttribute("txtDC","");
        }
        if (dem==0){
            String ma1 = request.getParameter("ma");
            CuaHang ch = chService.findByMa(ma1);
            try {
                BeanUtils.populate(ch, request.getParameterMap());
                chService.update(ch);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("ma",ma);
            request.setAttribute("view", "/Views/cua-hang/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
}
