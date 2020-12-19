function changeImg() {
    document.getElementById("vcodeImg").src="createVerifyImage.do?t="+Math.random();
}
var xmlHttp;
function getxmlHttp() {
    if (window.XMLHttpRequest){
        xmlHttp=new XMLHttpRequest();
    }else
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
}


function ajaxchecklogin() {
    var userName=document.getElementById("usename").value;
    var password=document.getElementById("password").value;
    var vcode=document.getElementById("vcode").value;
    var data = "usename=" + userName + "&password=" + password + "&vcode_enter=" + vcode;
    if (document.getElementById("autologin").checked)
        data = data + "&autologin=y";
    getxmlHttp();
    xmlHttp.open("post","ajaxLoginCheck.do",true);
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xmlHttp.send(data);
    xmlHttp.onreadystatechange=function () {
        if (xmlHttp.readyState==4&&xmlHttp.status==200){
            var response=xmlHttp.responseText;
            var json=JSON.parse(response);
            if (json.code==0){
                window.location.href="index.jsp";
            }else
                document.getElementById("error").innerText=json.info;
        }
    }
}


$(document).ready(function() {
    $("#usename").blur(function(e) {
        if ($(this).val() == "") {
            $("#usenameerr").text("用户名不能为空！");
        } else {
            $("#usenameerr").text("");
            userName_correct = true;
        }
    });

    $("#password").blur(function(e) {
        if ($(this).val() == "") {
            $("#passworderr").text("密码不能为空！");
        } else {
            $("#passworderr").text("");
            password_correct = true;
        }
    });

    $("#vcode").blur(function(e) {
        if ($(this).val() == "") {
            $("#vcodeerr").text("验证码不能为空！");
        } else {
            $("#vcodeerr").text("");
            vcode_correct = true;
        }
    });
});