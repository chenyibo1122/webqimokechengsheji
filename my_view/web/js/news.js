function getNews(newsid){
    $.ajax({
        type: "post",
        url: "getNewsByNewsid.do",
        data: "newsid="+newsid,
        dataType: "json",
        success: function(response) {
            $("#jwxx").empty();
            var str="";
            for (var i=0;i<response.newlist.length;i++){
                str=str+'<li id="li">';
                str=str+'<span>'+response.newlist[i].title+'</span>';
                str=str+'<span>'+response.newlist[i].time+'</span>';
                str=str+'</li>';
            }
            $("#jwxx").html(str);
        }
    });
}

$(document).ready(function () {
    getNews(1);
    $("#jwxxList").on("click","li",function (){
        $("#jwxxList li[class*='active']").removeClass("active");
        $(this).addClass("active");
        var newid=$(this).attr("id");
        getNews(newid);
    });





})