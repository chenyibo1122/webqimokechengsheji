<%--
  Created by IntelliJ IDEA.
  User: zhixing.zzx
  Date: 2020/12/10
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery-3.5.0.min.js"></script>
<link href="css/detail.css" rel="stylesheet">
<script src="js/detail.js"></script>
<body>
<div id="background">
    <div id="pageBody">
        <div id="search">
            <input id="time" type="text" name="time" placeholder="时间"/>
            <select id="inorout">
                <option value="in">in</option>
                <option value="out">out</option>
                <option value="qukuan">qukuan</option>
                <option selected value="">all</option>
            </select>
            <div id="serach-clear">
                <a href="#" id="btserach">查找</a>
                <a href="#" id="btclear">清空</a>
            </div>

        </div>


        <table border="1">
            <thead>
            <tr>
                <th>时间</th>
                <th>操作金额</th>
                <th>余额</th>
                <th>转入or转出</th>
                <th>other</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="tbody">
            </tbody>
        </table>


        <div class="paging">
            <div class="pagesize" id="Pagechoice">每页
                <select id="pageSize">
                    <option>2</option>
                    <option selected>5</option>
                </select>条,共
                <span id="total"></span> 条数据
                <span id="pageNumber">1</span>页/
                <span id="pageCount"></span>页
            </div>
            <div class="pagenext" id="Pagechoice2">
                <a id="first" href="#">首页</a>
                <a id="back" href="#">上一页</a>
                <a id="next" href="#">下一页</a>
                <a id="last" href="#">尾页</a>
            </div>
        </div>
    </div>

    <img id="detail-image" οnerrοr="this.style.display='none''">


</div>
</body>
</html>
