function fillFromSelect() {
    $.ajax({
        type: "post",
        url: "getSelect.do",
        data: "groupId=from",
        dataType: "json",
        success: function(response) {
            var yuan_select = document.getElementById("yuan-select");
            //清除select的所有option
            yuan_select.options.length = 0;
            //增加一个选项
            yuan_select.add(new Option("请选择源语言", ""));
            //循环增加其他所有选项
            for (index = 0; index < response.length; index++) {
                yuan_select.add(new Option(response[index].charname,
                    response[index].name));
            }
        }
    });
}


function fillToSelect() {
    $.ajax({
        type: "post",
        url: "getSelect.do",
        data: "groupId=to",
        dataType: "json",
        success: function(response) {
            var to_select = document.getElementById("to-select");
            //清除select的所有option
            to_select.options.length = 0;
            //增加一个选项
            to_select.add(new Option("请选择目标语言", ""));
            //循环增加其他所有选项
            for (index = 0; index < response.length; index++) {
                to_select.add(new Option(response[index].charname,
                    response[index].name));
            }
        }
    });
}

var to_select=false;
var yuan_select=false;

function getFanyi(){
    var data=' {"text":"'+$("#yuan-text").val()+'","from":"'+$("#yuan-select").val()+'","to":"'+$("#to-select").val()+'"}';
    console.log(data);
    $.ajax({
        type: "post",
        url: "getFanyi.do",
        data: data,
        contentType:"application/json",
        dataType: "json",
        success: function(response) {
            $("#to-text").val(response.trans_result[0].dst);
            console.log(response)
        }
    });
}

$(document).ready(function () {
    fillToSelect();
    fillFromSelect();
    $("#to-select").blur(function () {
        if ($(this).val() == "") {
            $("#error").css("color", " #c00202");
            $("#error").text("目标语言选择不能为空");
            return;
        }
        else  to_select=true;

    })

    $("#yuan-select").blur(function () {
        if ($(this).val() == "") {
            $("#error").css("color", " #c00202");
            $("#error").text("源语言选择不能为空");
            return;
        }
        else  yuan_select=true;

    })
    
    
    $("#fanyi-button").click(function () {
        if (to_select&&yuan_select){
            $("#error").text("");
            getFanyi()
        }

    })
    
    $("#copy").click(function () {
        var text=document.getElementById("to-text");
        text.select();
        document.execCommand("Copy");
    })
})


