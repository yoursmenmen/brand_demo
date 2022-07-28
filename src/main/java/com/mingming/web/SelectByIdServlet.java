package com.mingming.web;

import com.mingming.pojo.Brand;
import com.mingming.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {

    private final BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收id
        String id = request.getParameter("id");
        // 查询
        Brand brand = service.selectById(Integer.parseInt(id));
        // 存储到request域中
        request.setAttribute("brand", brand);
        // 转发到对应的jsp页面
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
