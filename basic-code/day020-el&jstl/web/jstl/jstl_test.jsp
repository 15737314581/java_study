<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl练习</title>
    <style>
        table{
            border: 1px solid #000000;
            width: 500px;
            margin: 50px auto 0;
        }
        tr,td,th{
            border: 1px solid #000000;
        }
    </style>
</head>
<body>
<%
    List list = new ArrayList();
    list.add(new User("张三",19,new Date(1994-1900,11-1,19)));
    list.add(new User("李四",22,new Date(1996-1900,10-1,20)));
    list.add(new User("王五",10,new Date()));
    request.setAttribute("list",list);
%>

<table >
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.index % 2 == 0}">
            <tr bgcolor="green">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.strdate}</td>
            </tr>
        </c:if>
        <c:if test="${s.index % 2 != 0}">
            <tr bgcolor="red">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.strdate}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
