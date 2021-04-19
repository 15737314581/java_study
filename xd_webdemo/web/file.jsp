<%--
  Created by IntelliJ IDEA.
  User: jijianfeng
  Date: 2021/4/12
  Time: 下午3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/fileUpload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username">
    <br>
    头像：<input type="file" name="img">
    <input type="submit" value="提交">
</form>
</body>
</html>
