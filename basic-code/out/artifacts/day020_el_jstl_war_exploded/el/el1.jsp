<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取对象</title>
</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(23);
    user.setBirthday(new Date());


    request.setAttribute("u",user);

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);

    request.setAttribute("list",list);


    Map map = new HashMap();
    map.put("sname","李四");
    map.put("gender","男");
    map.put("user",user);

    request.setAttribute("map",map);

%>
${u.name}<br>
${u.age}<br>
${u.birthday}<br>
${u.strdate}<br>
${list[0]}<br>
${list[1]}<br>
${list[2].name}<br>

${map.gender}<br>
${map["gender"]}<br>
${map.user.name}

</body>
</html>
