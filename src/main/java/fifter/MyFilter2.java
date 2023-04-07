package fifter;

import DomainModels.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import views_models.QLNhanVien;

import java.io.IOException;

@WebFilter(filterName = "MyFilter2", value  ={
        "/chuc-vu/*",
        "/cua-hang/*",
        "/nhan-vien/*",
        "/nsx/*",
})
public class MyFilter2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        NhanVien us = (NhanVien) session.getAttribute("user");
        if (us !=null && us.getIdCV().getTen().equalsIgnoreCase("Trưởng phòng")) {
            chain.doFilter(request, response);
        }else {
            request.getRequestDispatcher("/Views/error.jsp")
                    .forward(request, response);
        }
    }
}
