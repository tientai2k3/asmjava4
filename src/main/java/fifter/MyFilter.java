package fifter;

import DomainModels.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import views_models.QLNhanVien;

import java.io.IOException;

@WebFilter(filterName = "MyFilter",value = {
        "/khach-hang/*",
        "/mau-sac/*",
        "/dongsp/*",
        "/san-pham/*",
        "/chi-tiet-san-pham/*",
        "/gio-hang/*",
        "/hoa-don/*",
        "/dang-xuat",
        "/shop/*",
        "/gio-hang-chi-tiet/*"
})
public class MyFilter implements Filter {
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
        if (us !=null) {
            chain.doFilter(request, response);
        }else {
            request.getRequestDispatcher("/Views/user/dangnhap.jsp")
                    .forward(request, response);
        }

    }
}
