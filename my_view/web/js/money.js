$(document).ready(function () {
    var money=$("#money").val();
    $("#querem").click(function () {
        $.ajax({
            type: "post",
            url: "getNewsByNewsid.do",
            data: "money="+money,
            dataType: "json",
            success: function(response) {

            }
        });
    })

})