<%--
  Created by IntelliJ IDEA.
  User: jijianfeng
  Date: 2021/4/7
  Time: 下午7:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/userLogin">
        姓名：<input type="text" name="username">
        <br>
        密码：<input type="password" name="password">
        <br>
        <input type="submit" value="登录">
        <br>
        提示信息：${msg}



    </form>
</body>
</html>
