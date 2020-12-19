<%--
  Created by IntelliJ IDEA.
  User: zhixing.zzx
  Date: 2020/12/5
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/inclide-nav.css" rel="stylesheet">
</head>
<body>
<div id="container">
    <div id="header">
        <div id="rightTop">
            当前用户：<span>${currentuser.getUsename()}</span> &nbsp;[<a href="logOut.do">安全退出</a>]
        </div>
        <div id="menu">
            <ul>
                <li><a href="index.jsp">首页</a></li> 
                <li><a href="">关于</a></li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
