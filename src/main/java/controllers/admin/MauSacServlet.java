package controllers.admin;

import DomainModels.MauSac;
import Service.Impl.MauSacServiceImpl;
import Service.MauSacService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepository;
import views_models.QLMauSac;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/mau-sac/index",
        "/mau-sac/create",
        "/mau-sac/store",
        "/mau-sac/edit",
        "/mau-sac/update",
        "/mau-sac/delete",
})
public class MauSacServlet extends HttpServlet {
    private MauSacService msService = new MauSacServiceImpl();

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
        request.setAttribute("view","/Views/mau-sac/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac msDm = msService.findByMa(ma);
        request.setAttribute("qlms",msDm);
        request.setAttribute("view","/Views/mau-sac/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac msDm = msService.findByMa(ma);
        msService.delete(msDm);
        response.sendRedirect("index");

    }
    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("ds",msService.findAll());
        request.setAttribute("view","/Views/mau-sac/index.jsp");
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
        for (QLMauSac x:msService.findAll()) {
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
            QLMauSac ms = new QLMauSac();
            try {
                BeanUtils.populate(ms, request.getParameterMap());
                msService.insert(ms);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("ma",ma);
            request.setAttribute("ten",ten);
            request.setAttribute("view", "/Views/mau-sac/create.jsp");
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
            MauSac msDm = msService.findByMa(ma1);
            try {
                BeanUtils.populate(msDm, request.getParameterMap());
                msService.update(msDm);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("ma",ma);
            request.setAttribute("ten",ten);
            request.setAttribute("view", "/Views/mau-sac/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }

}
