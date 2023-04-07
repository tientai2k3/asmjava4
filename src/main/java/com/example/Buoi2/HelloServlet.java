package com.example.Buoi2;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/hello-servlet"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        String name = "taint";
        request.setAttribute("hoTen",name);
        request.getRequestDispatcher("/Views/hello.jsp")
                .forward(request,response);

    }
    public void create(){

    }
    public void destroy() {
    }
}