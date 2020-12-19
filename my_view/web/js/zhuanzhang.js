$(document).ready(function() {

    var money_count=false;
    var other=false;
    var password=false
    $("#money-count").blur(function(e) {
        if ($(this).val() == "") {
            $("#error").text("金额不能为空！");
        } else {
            $("#error").text("");
            money_count = true;
        }
    });

    $("#other").blur(function(e) {
        if ($(this).val() == "") {
            $("#error").text("对方账户不能为空！");
        } else {
            $("#error").text("");
            other = true;
        }
    });

    $("#money-password").blur(function(e) {
        if ($(this).val() == "") {
            $("#error").text("支付密码不能为空！");
        } else {
            $("#error").text("");
            password = true;
        }
    });

    $("#queren").click(function () {
        var money=$("#money-count").val();
        var password=$("#money-password").val();
        var other=$("#other").val();
        if (password&&other&&money_count){
            $.ajax({
                type: "post",
                url: "zhuanzhang.do",
                data: "money="+money+"&password="+password+"&other="+other,
                dataType: "json",
                success: function(response) {
                    if (response.code==0){
                        window.location.href="caiwu.jsp";
                        alert(response.info);
                    }
                    else {
                        document.getElementById("error").innerText=response.info;
                    }
                }

            });
        }

    })
});