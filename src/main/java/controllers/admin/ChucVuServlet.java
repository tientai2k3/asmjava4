package controllers.admin;

import DomainModels.ChucVu;
import Service.ChucVuService;
import Service.Impl.ChucVuServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import views_models.QLChucVu;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/chuc-vu/index",
        "/chuc-vu/create",
        "/chuc-vu/store",
        "/chuc-vu/edit",
        "/chuc-vu/update",
        "/chuc-vu/delete",
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuService cvService = new ChucVuServiceImpl();

    @Override
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
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

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
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
        request.setAttribute("view", "/Views/chuc-vu/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);

    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cvDm = cvService.findByMa(ma);
        request.setAttribute("qlcv", cvDm);
        request.setAttribute("view", "/Views/chuc-vu/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChucVu cv = cvService.findById(id);
        cvService.delete(cv);
        response.sendRedirect("index");
    }

    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        List<QLChucVu> listCV = cvService.findAll();

        request.setAttribute("ds", listCV);
        request.setAttribute("view", "/Views/chuc-vu/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);

    }


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        if (ma.isEmpty()) {
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa", loiMa);
            dem++;
        } else {
            request.setAttribute("txtMa", "");
        }
        for (QLChucVu x:cvService.findAll()) {
            if (ma.equals(x.getMa())){
                String loiMa = "Hiện tại đã có mã này, vui lòng nhập mã khác";
                request.setAttribute("txtMa", loiMa);
                dem++;
            }
        }
        if (ten.isEmpty()) {
            String loiTen = "Bạn cần phải nhập tên";
            request.setAttribute("txtTen", loiTen);
            dem++;
        } else {
            request.setAttribute("txtTen", "");
        }
        if (dem == 0) {
            QLChucVu cv = new QLChucVu();
            try {
                BeanUtils.populate(cv, request.getParameterMap());
                cvService.insert(cv);
                response.sendRedirect("index");


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("view", "/Views/chuc-vu/create.jsp");
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

        if (ma.isEmpty()) {
            String loiMa = "Bạn cần phải nhập mã";
            request.setAttribute("txtMa", loiMa);
            dem++;
        } else {
            request.setAttribute("txtMa", "");
        }
        if (ten.isEmpty()) {
            String loiTen = "Bạn cần phải nhập tên";
            request.setAttribute("txtTen", loiTen);
            dem++;
        } else {
            request.setAttribute("txtTen", "");
        }
        if (dem == 0) {
            String ma1 = request.getParameter("ma");
            ChucVu cv = cvService.findByMa(ma);
            try {
                BeanUtils.populate(cv, request.getParameterMap());
                cvService.update(cv);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("ma",ma);
            request.setAttribute("ten",ten);
            request.setAttribute("view", "/Views/chuc-vu/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
}
