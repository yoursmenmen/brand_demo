package com.mingming.web;

import com.mingming.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/deleteServlet")


public class DeleteServlet extends HttpServlet {

    private final BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        service.delectById(Integer.parseInt(id));
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
