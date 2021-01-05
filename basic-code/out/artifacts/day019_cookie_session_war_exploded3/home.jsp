<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: jijianfeng
  Date: 2020/12/23
  Time: 上午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //获取所有cookie数据
    Cookie[] cookies = request.getCookies();
    Boolean flag = false;
    //遍历cookies
    if (cookies != null && cookies.length > 0){
        for (Cookie cookie : cookies) {
            //获取cookie的键
            String name = cookie.getName();
            //判断是否有一个名为lastTime的cookie
            if ("lastTime".equals(name)){
                flag = true;
                //1.响应数据
                String value = cookie.getValue();
                //URL解码
                System.out.println("解码前："+value);
                value = URLDecoder.decode(value, "utf-8");
                System.out.println("解码后："+value);
                out.write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");
                //2.写回Cookie：lastTime=
                Date date = new Date();
                SimpleDateFormat spf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String new_date = spf.format(date);
                //url编码
                System.out.println("编码前："+new_date);
                new_date = URLEncoder.encode(new_date, "utf-8");
                System.out.println("编码后："+new_date);
                cookie.setValue(new_date);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                break;
            }

        }
    }
    if (cookies == null || cookies.length == 0 || flag == false){
        //1. 响应数据
        out.write("<h1>您好，欢迎您首次访问</h1>");
        //2. 写回Cookie
        Date date = new Date();
        SimpleDateFormat spf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String new_date = spf.format(date);
        //url编码
        System.out.println("编码前："+new_date);
        new_date = URLEncoder.encode(new_date, "utf-8");
        System.out.println("编码后："+new_date);
        Cookie cookie = new Cookie("lastTime",new_date);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        Cookie[] cookies1 = request.getCookies();
        for (Cookie cookie1 : cookies1) {
            String name = cookie1.getName();
            String value = cookie1.getValue();
            System.out.println(name+":"+value);
        }

    }
%>
</body>
</html>
