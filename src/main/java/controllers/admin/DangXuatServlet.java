package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({
        "/dang-xuat"
})
public class DangXuatServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xoa session
        HttpSession session = request.getSession();
        //Co 2 cach xoa :
        // C1: Xoa tat ca
//        session.invalidate();
        // C2: Xoa 1 session nao day
        session.removeAttribute("user");
        response.sendRedirect("/Buoi2_war_exploded/dang-nhap");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
