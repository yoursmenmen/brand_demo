package com.mingming.web;

import com.mingming.utils.CheckCodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 生成验证码
        ServletOutputStream outputStream = response.getOutputStream();
        String s = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);
        // 存入session
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen", s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
