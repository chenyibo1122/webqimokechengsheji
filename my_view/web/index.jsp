<%--
  Created by IntelliJ IDEA.
  User: zhixing.zzx
  Date: 2020/9/28
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <title>系统主页</title>
    <link rel="stylesheet" href="bootstroop/css/bootstrap.min.css">
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="bootstroop/js/bootstrap.min.js"></script>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <script src="js/echarts.min.js"></script>
    <script src="js/main.js"></script>
    <script>
        $(document).ready(function () {
            $('#image').carousel({
                interval: 2000,
                ride: true
            })
        })

    </script>
</head>

<body>
<div id="container">
    <div id="header">
        <%@include file="include-nav.jsp" %>
    </div>
</div>
<div id="image" class="carousel slide container" data-ride="carousel">
    <div class="carousel-inner ">
        <div class="carousel-item active">
            <img src="${lunboImage.get(0).getImageurl()}" class="d-block w-100">
        </div>
        <c:forEach items="${lunboImage}" begin="1" var="image">
            <div class="carousel-item ">
                <img src="${image.getImageurl()}" class="d-block w-100">
            </div>
        </c:forEach>
    </div>
    <a class="carousel-control-prev" href="#image" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#image" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>



<div id="weather" style="background-color: dodgerblue">
    <div id="weathernow" style="float: left">
        <form id="serachByCity">
            <input id="cityText" type="text" placeholder="输入城市">
            <input id="searchweather" type="button" value="查询天气">
        </form>
        <div id="weather-mian">
            <div id="city"></div>
            <div id="time">
                <span id="datatime"></span>
                <span id="week"></span>
            </div>
            <div id="tempture-text">
                <span><img id="weatherimg" src=""></span>
                <span id="tempeture"></span>
                <div>
                    <p id="tianqi"></p>
                </div>
            </div>
            <div id="detail">
                <span id="shidu"></span>
                <span id="fengxiang"></span>
                <span id="kongqi"></span>
            </div>
        </div>
    </div>

    <div id="weatherimage" style="float: right">
        <h3 id="weathertitle">五日天气预报</h3>
        <div id="ct-weather">
            <ul id="card-weather">
            </ul>
            <div id="image-weather" style="width:800px;height:150px"></div>

        </div>
    </div>
</div>

</body>

</html>
