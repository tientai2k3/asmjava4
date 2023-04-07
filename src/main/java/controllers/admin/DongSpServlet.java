package controllers.admin;

import DomainModels.DongSP;
import Service.DongSpService;
import Service.Impl.DongSpServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSpRepository;
import views_models.QLDongSP;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/dongsp/index",
        "/dongsp/create",
        "/dongsp/store",
        "/dongsp/edit",
        "/dongsp/update",
        "/dongsp/delete",
})
public class DongSpServlet extends HttpServlet {
    private DongSpService dspService = new DongSpServiceImpl();

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
        } else {
            this.index(request, response);
        }
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("store")) {
            this.store(request, response);
        } else if (url.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("index");
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/Views/dongsp/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);

    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP dspDm = dspService.findByMa(ma);
        request.setAttribute("qldsp", dspDm);
        request.setAttribute("view", "/Views/dongsp/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP vm = dspService.findByMa(ma);
        dspService.delete(vm);
        response.sendRedirect("index");
    }

    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("ds", dspService.findAll());
        request.setAttribute("view", "/Views/dongsp/index.jsp");
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
        for (QLDongSP x:dspService.findAll()) {
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
            QLDongSP dsp = new QLDongSP();
            try {
                BeanUtils.populate(dsp, request.getParameterMap());
                dspService.insert(dsp);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("view", "/Views/dongsp/create.jsp");
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
            DongSP dspDm = dspService.findByMa(ma1);
            try {
                BeanUtils.populate(dspDm, request.getParameterMap());
                dspService.update(dspDm);
                response.sendRedirect("index");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("ma",ma);
            request.setAttribute("view", "/Views/dongsp/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
}
