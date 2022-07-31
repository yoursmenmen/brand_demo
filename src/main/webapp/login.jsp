<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 7/30/2022
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>login</title>
        <link href="css/login.css" rel="stylesheet">
        <style>
            #errorMsg{
                color: red;
            }
        </style>
    </head>

    <body>
        <div id="loginDiv" style="height: 350px">
            <form action="http://localhost:8080/brand_demo/loginServlet" id="form">
                <h1 id="loginMsg">LOGIN IN</h1>
                <div id="errorMsg" align="centre">${login_err_msg}</div>
                <p>Username:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>

                <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
                <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
                <div id="subDiv">
                    <input type="submit" class="button" value="login up">
                    <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
                    <a href="register.jsp">没有账号？</a>
                </div>
            </form>
        </div>

    </body>
</html>