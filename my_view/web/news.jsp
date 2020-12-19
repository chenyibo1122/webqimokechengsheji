<%--
  Created by IntelliJ IDEA.
  User: zhixing.zzx
  Date: 2020/12/3
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/news.css" rel="stylesheet"/>
    <script src="js/jquery-3.5.1.js"></script>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/news.js" ></script>
</head>
<body>
<%@include file="include-nav.jsp"%>
<div class="main">

            <div class="left-content">
                <div class="bigger-card">
                    <nav class="card-nav">
                        <ul id="jwxxList">
                            <li id="1" class="active">人事信息</li>
                            <li id="2">教务信息</li>
                            <li id="3">学工信息</li>
                        </ul>
                        <a id="morejwxx" class="more" >更多</a>
                    </nav>
                    <ul id="jwxx" class="bigcard-content">
                    </ul>
                </div>
            </div>
            <div class="right-content">


                <div class="zhuanti">
                    <h3>专题网站</h3>
                    <p class="line"></p>
                    <ul>
                        <li>
                            <a>
                                <img src="${newsimage.get(0).getImageurl()}" alt="">
                                <span title="校庆专题">校庆专题</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${newsimage.get(2).getImageurl()}" alt="">
                                <span title="VPN">VPN</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${newsimage.get(1).getImageurl()}" alt="">
                                <span title="图书资源">图书资源</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${newsimage.get(5).getImageurl()}" alt="">
                                <span title="招标网">招标网</span>
                            </a>
                        </li>
                        <li>
                            <a >
                                <img src="${newsimage.get(4).getImageurl()}" alt="">
                                <span title="信息公开">信息公开</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${newsimage.get(7).getImageurl()}" alt="">
                                <span title="人才招聘">人才招聘</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${newsimage.get(3).getImageurl()}" alt="">
                                <span title="网络课堂">网络课堂</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${newsimage.get(6).getImageurl()}" alt="">
                                <span title="邮件系统">邮件系统</span>
                            </a>
                        </li>

                    </ul>
                </div>

                <div class="dataCenter">
                    <h3>资源中心</h3>
                    <p class="line"></p>
                    <ul>
                        <li>
                            <a>
                                <span title="电子图书馆">电子图书馆</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <span title="网络资源">网络资源</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <span title="网络教学平台">网络教学平台</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
</div>




</body>
</html>
