<%--
  Created by IntelliJ IDEA.
  User: jijianfeng
  Date: 2020/12/24
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1><%=request.getSession().getAttribute("user")%>，欢迎您</h1>
</body>
</html>
