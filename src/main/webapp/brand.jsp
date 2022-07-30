<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 7/27/2022
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>${user.username}, 欢迎您</h1>
        <button id="add">添加</button>
        <table border="1" cellpadding="0" width="80%">
            <tr align="center">
                <td>序号</td>
                <td>品牌名</td>
                <td>企业名称</td>
                <td>排序</td>
                <td>品牌介绍</td>
                <td>状态</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${brands}" var="brand" varStatus="sequence">
            <tr align="centre">
                <td>${sequence.count}</td>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <c:if test="${brand.status == 0}">
                    <td>禁用</td>
                </c:if>
                <c:if test="${brand.status != 0}">
                    <td>启用</td>
                </c:if>
                <td><a href="<c:url value="/selectByIdServlet?id=${brand.id}"/>">修改</a> <a id="del" href="#" onclick="del(${sequence.index}, ${brand.id})">删除</a></td>
            </tr>
            </c:forEach>
    </body>
    <script>
        const addButton = document.getElementById("add");
        addButton.onclick = function () {
            location.href = "http://localhost:8080/brand_demo/addBrand.jsp"
        }
        const deleteButton = document.getElementById("del");
        deleteButton.onclick = del;
            function del(id, brandId) {
            let confirm = window.confirm("确认删除?");
            // alert(confirm);
            <%--location.href = "http://localhost:8080/brand_demo/deleteServlet?id=${brand.id}"--%>
            if(confirm){
                location.href = "http://localhost:8080/brand_demo/deleteServlet?id=" + brandId
            }

        }
    </script>
</html>
