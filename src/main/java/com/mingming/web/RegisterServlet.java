package com.mingming.web;

import com.mingming.pojo.User;
import com.mingming.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 获取验证码的值
        String checkCode = request.getParameter("checkCode");
        // 获取程序生成的验证码
        HttpSession session = request.getSession();
        Object checkCodeGen = session.getAttribute("checkCodeGen");


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean b = service.register(user);

        // 判断验证码
        System.out.println(checkCode.equals(checkCodeGen));
        if(checkCode.equalsIgnoreCase((String) checkCodeGen)){
            if(b && !("").equals(username) && !("").equals(password)){
                // 跳转登录页面
                request.setAttribute("login_err_msg", "注册成功请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                request.setAttribute("register_msg", "用户民重复，换一个");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("register_msg", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
/*        if(b && !("").equals(username) && !("").equals(password)){
            // 跳转登录页面
            request.setAttribute("login_err_msg", "注册成功请登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
            request.setAttribute("register_msg", "用户民重复，换一个");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }*/


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
