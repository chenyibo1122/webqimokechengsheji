<%--
  Created by IntelliJ IDEA.
  User: zhixing.zzx
  Date: 2020/12/10
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>money</title>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/qukuan.js"></script>
    <style type="text/css">
        body{
            background-image: url("images/money.jpg");
        }
        #money{
            width: 300px;
            height: 200px;
            margin: 330px 60px;
        }
        #queren{
            width: 250px;
            height: 35px;
            background-color: rgb(78,99,99);
            color: #098787;
            font-weight: bold;
        }
        #money-count,
        #money-password{
            width: 250px;
            height: 30px;
            border:1px solid #cccccc;
            text-indent: 24px;
        }
        .err {
            font-size: 14px;
            color: red;
            display: block;
            height: 7px;
            line-height: 16px;
        }
    </style>

</head>
<body>
<%@include file="include-nav.jsp"%>
<div id="money">
    <input type="text" id="money-count" placeholder="输入取款金额">
    <input type="password" id="money-password" placeholder="输入支付密码">
    <input type="button" id="queren" value="确认">
    <span class="err" id="error"></span>
</div>
</body>
</html>

