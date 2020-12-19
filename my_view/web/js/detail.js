
function getBankDetails() {
    var data=' {"time":"'+$("#time").val()+'","inorout":"'+$("#inorout").val()+'","pageSize":"'+$("#pageSize").val()+'","pageNumber":"'+$("#pageNumber").text()+'"   }';
    console.log(data);
    $.ajax({
        type: "post",
        url: "getBankDetail.do",
        data: data,
        dataType: "json",
        contentType:"application/json",
        success: function(response) {
            $("tbody").empty()
            $("#total").text(response.total);
            $("#pageCount").text(Math.ceil(response.total/($("#pageSize").val())));
            var str;
            for (var i=0;i<response.bankDetails.length;i++){
                str=str+'<tr >';
                str=str+'<td>'+response.bankDetails[i].time+'</td>';
                str=str+'<td>'+response.bankDetails[i].money+'</td>';
                str=str+'<td>'+response.bankDetails[i].sum+'</td>';
                str=str+'<td>'+response.bankDetails[i].inorout+'</td>';
                str=str+'<td>'+response.bankDetails[i].byorto+'</td>';
                str=str+'<td><a id="detailImage" value='+response.bankDetails[i].id+'>生成图片</a> </td>';
                str=str+'</tr>';
            }
            $("tbody").html(str);

        }
    });
    $("#tbody tr:even").addClass("tr_even");
    $("#tbody tr:odd").addClass("tr_odd");
}


$(document).ready(function () {
    getBankDetails();
    $("tbody").on("mouseover","tr",function (){
        $(this).addClass("tr_hover");
    });
    $("tbody").on("mouseout","tr",function (){
        $(this).removeClass("tr_hover")
    });

    $("#btserach").click(function () {
        getBankDetails();
    });


    $("#next").click(function () {
        var data=' {"time":"'+$("#time").text()+'","inorout":"'+$("#inorout").val()+'","pageSize":"'+$("#pageSize").val()+'",   "pageNumber":"'+$("#pageNumber").text()+'"   }';
        $.ajax({
            type: "post",
            url: "getBankDetail.do",
            data: data,
            contentType:"application/json",
            dataType: "json",
            success: function(response) {
                $("#total").text(response.total);
                $("#pageCount").text(Math.ceil(response.total/($("#pageSize").val())));
                if (parseInt($("#pageNumber").text())<parseInt($("#pageCount").text())){
                    $("#pageNumber").html(parseInt($("#pageNumber").text())+1);
                }
                else{
                    $("#pageNumber").html($("#pageCount").text());
                }

              getBankDetails();
            }
        });

    });

    $("#btclear").click(function () {
        $("#detail-image").attr("src","");
        $("#time").val("");
    });


    $("table").on("click","#detailImage",function () {
        var id=$(this).attr("value");
        console.log(id);
        $("#detail-image").attr("src","creataDetailsImage.do?id="+id)
    });


    $("#back").click(function () {
        if (parseInt($("#pageNumber").text())>1){
            $("#pageNumber").html(parseInt($("#pageNumber").text())-1);
        }else{
            $("#pageNumber").html(1);
        }
       getBankDetails();
    });

    $("#first").click(function () {
        $("#pageNumber").html(1);
        getBankDetails();
    });

    $("#last").click(function () {
        var data=' {"time":"'+$("#time").text()+'","inorout":"'+$("#inorout").val()+'","pageSize":"'+$("#pageSize").val()+'",   "pageNumber":"'+$("#pageNumber").text()+'"   }';

        $.ajax({
            type: "post",
            url: "getBankDetail.do",
            data: data,
            contentType:"application/json",
            dataType: "json",
            success: function(response) {
                $("#total").text(response.total);
                $("#pageCount").text(Math.ceil(response.total/($("#pageSize").val())));
                $("#pageNumber").html($("#pageCount").text());

                getBankDetails();
            }
        });

    });

    $("#pageSize").change(function () {
        getBankDetails();
    });

    $("#inorout").change(function () {
        getBankDetails();
    });

})