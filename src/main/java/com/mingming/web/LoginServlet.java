package com.mingming.web;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 调用service查询
        User user = service.login(username, password);

        // 获取复选框
        String remember = request.getParameter("remember");


        if (user != null) {
            // 登陆成功， 跳转到查询所有，由于没有数据共享，所以使用重定向即可
            // 判断用户是否记住
            if ("1".equals(remember)) {
                // 用户勾选复选框
                Cookie cUsername = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", password);

                // 设置存活时间
                cUsername.setMaxAge(60 * 60 * 24 * 7);
                cPassword.setMaxAge(60 * 60 * 24 * 7);

                //发送cookie
                response.addCookie(cUsername);
                response.addCookie(cPassword);

            }

            // 将登陆成功的user存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/selectAllServlet");

        } else {
            // 登陆失败
            // 存储错误信息
            request.setAttribute("login_err_msg", "别瞎几把填");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
