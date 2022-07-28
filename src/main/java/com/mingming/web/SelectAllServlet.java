package com.mingming.web;

import com.mingming.pojo.Brand;
import com.mingming.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author h
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    /**
     * 防止复用， 提升作用域
     */
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        // 存入request域中
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("brand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
