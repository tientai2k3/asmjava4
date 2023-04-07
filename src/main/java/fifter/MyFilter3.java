package fifter;

import DomainModels.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import views_models.QLNhanVien;

import java.io.IOException;

@WebFilter(filterName = "MyFilter3",value={
        "/dang-nhap",
        "/user/dang-ki"
})
public class MyFilter3 implements Filter {
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
        if (us ==null){
            chain.doFilter(request, response);
        }else {
            request.setAttribute("view","/Views/chi-tiet-san-pham/index.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request,response);
        }

    }
}
