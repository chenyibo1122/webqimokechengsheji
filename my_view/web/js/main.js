function getTime() {
    var d = new Date(),
        str = '';
    str += d.getFullYear() + '年'; //获取当前年份
    str += d.getMonth() + 1 + '月'; //获取当前月份（0——11）
    str += d.getDate() + '日';
    return str;
}
function getWeekDate(time) {
    var date=new Date(time);
    var day = date.getDay();
    var weeks = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    var week = weeks[day];
    return week;
}

function getLowAndHighTemperature(temperature) {
    var temperature1="";
    var temperature2="";
    var temperatureback="";
    var str="";
    temperature1=temperature.replace("\/",",");
    temperature2=temperature1.replace("℃",",");
    str=temperature2.split(",");
    return str
}

function getTemperature(temperature){
    var str=getLowAndHighTemperature(temperature);
    temperatureBack=(Number(str[0])+Number(str[1]))/2;
   return temperatureBack;
}

function getWeatherImage(response) {
    var weatherImage=echarts.init(document.getElementById("image-weather"))
    var option={
        title:{
            text:""
        },
        tooltip:{},

        xAxis:{
            data:{},
            splitLine:{
                show:false,
            },
            axisLabel : {
                show:false,
            },
            show:false,
        },
        yAxis:{
            splitLine:{
                show:false,
            },
            axisLabel : {
                show:false,
            },
            show:false,
        },
        series:[{
            name:'温度',
            type:'line',
            data: [getTemperature(response.result.future[0].temperature),
                getTemperature(response.result.future[1].temperature),
                getTemperature(response.result.future[2].temperature),
                getTemperature(response.result.future[3].temperature),
                getTemperature(response.result.future[4].temperature)],
        }],
    }
    weatherImage.setOption(option);

}




function getWeatherCard(response) {
    $("#card-weather").empty();
    var str="";
    for (var i=0;i<response.result.future.length;i++){

        str=str+'<li ">';
        str=str+'<p>'+getWeekDate(response.result.future[i].date)+'</p>';
        str=str+'<p>'+response.result.future[i].date+'</p>';
        str=str+'<p>'+response.result.future[i].weather+'</p>';
        str=str+'<p>'+getLowAndHighTemperature(response.result.future[i].temperature)[1]+'℃</p>';
        str=str+'<p style="margin-top: 40px">'+getLowAndHighTemperature(response.result.future[i].temperature)[0]+'℃</p>';
        str=str+'<img src="'+adaptWeatherImage(response.result.future[i].wid.day)+'"></img>';
        str=str+'<p>'+response.result.future[i].direct+'</p>';
        str=str+'</li>';
    }
    $("#card-weather").html(str);
}


function adaptWeatherImage(wid) {
    var yu = new Array("07", "08", "09", "19", "21", "22");
    var baoyu = new Array("10", "11", "12", "23", "24", "25");
    var xue = new Array("13", "14", "15", "27", "26");
    var baoxue = new Array("16", "17", "28");
    var wu = new Array("18", "29");
    var shachen = new Array("20", "30", "31");
    var mai = new Array("53");
    var src;
    if (wid == "00") {
        src="images/weathersmall/qingtian.png";
    } else if (wid == "01") {
        src="images/weathersmall/duoyun.png";
    } else if (wid =="02") {
        src="images/weathersmall/yintian.png";
    } else if (wid == "03") {
        src="images/weathersmall/zhenyu.png";
    } else if (wid == "04") {
        src="images/weathersmall/leizhenyu.png";
    } else if (wid == "05") {
        src="images/weathersmall/bingbao.png";
    } else if (wid == "06") {
        src="images/weathersmall/yujiaxue.png";
    } else if ($.inArray(wid, yu) >= 0) {
        src="images/weathersmall/yu.png";
    } else if ($.inArray(wid, baoyu) >= 0) {
        src="images/weathersmall/baoyu.png";
    } else if ($.inArray(wid, xue) >= 0) {
        src="images/weathersmall/xue.png";
    } else if ($.inArray(wid, baoxue) >= 0) {
        src= "images/weathersmall/baoxue.png";
    } else if ($.inArray(wid, wu) >= 0) {
        src="images/weathersmall/wu.png";
    } else if ($.inArray(wid, shachen) >= 0) {
        src="images/weathersmall/shachen.png";
    } else if ($.inArray(wid, mai) >= 0) {
        src="images/weathersmall/mai.png";
    }
    return src;
}






function getWeather(){
    var city=$("#cityText").val();
    $.ajax({
        type: "post",
        url: "getWeather.do",
        data: "city="+city,
        dataType: "json",
        success: function(response) {
            console.log(response.result.future[0].date);
            if (null == response && "" == response){
                alert("无法查询该城市");
            }

            else {
                $("#city").text(response.result.city);
                $("#datatime").text(getTime());
                $("#week").text(getWeekDate(new Date()));
                var yu = new Array("07", "08", "09", "19", "21", "22");
                var baoyu = new Array("10", "11", "12", "23", "24", "25");
                var xue = new Array("13", "14", "15", "27", "26");
                var baoxue = new Array("16", "17", "28");
                var wu = new Array("18", "29");
                var shachen = new Array("20", "30", "31");
                var mai = new Array("53");
                if (response.result.realtime.wid == "00") {
                    $("#weatherimg").attr("src", "images/weather/qingtian.png");
                } else if (response.result.realtime.wid == "01") {
                    $("#weatherimg").attr("src", "images/weather/duoyun.png");
                } else if (response.result.realtime.wid =="02") {
                    $("#weatherimg").attr("src", "images/weather/yintian.png");
                } else if (response.result.realtime.wid == "03") {
                    $("#weatherimg").attr("src", "images/weather/zhenyu.png");
                } else if (response.result.realtime.wid == "04") {
                    $("#weatherimg").attr("src", "images/weather/leizhenyu.png");
                } else if (response.result.realtime.wid == "05") {
                    $("#weatherimg").attr("src", "images/weather/bingbao.png");
                } else if (response.result.realtime.wid == "06") {
                    $("#weatherimg").attr("src", "images/weather/yujiaxue.png");
                } else if ($.inArray(response.result.realtime.wid, yu) >= 0) {
                    $("#weatherimg").attr("src", "images/weather/yu.png");
                } else if ($.inArray(response.result.realtime.wid, baoyu) >= 0) {
                    $("#weatherimg").attr("src", "images/weather/baoyu.png");
                } else if ($.inArray(response.result.realtime.wid, xue) >= 0) {
                    $("#weatherimg").attr("src", "images/weather/xue.png");
                } else if ($.inArray(response.result.realtime.wid, baoxue) >= 0) {
                    $("#weatherimg").attr("src", "images/weather/baoxue.png");
                } else if ($.inArray(response.result.realtime.wid, wu) >= 0) {
                    $("#weatherimg").attr("src", "images/weather/wu.png");
                } else if ($.inArray(response.result.realtime.wid, shachen) >= 0) {
                    $("#weatherimg").attr("src", "images/weather/shachen.png");
                } else if ($.inArray(response.result.realtime.wid, mai) >= 0) {
                    $("#weatherimg").attr("src", "images/weather/mai.png");
                }
                $("#tianqi").text(response.result.realtime.info);
                $("#tempeture").text("温度：" + response.result.realtime.temperature + "°C");
                $("#shidu").text("湿度：" + response.result.realtime.humidity);
                $("#fengxiang").text("风向：" + response.result.realtime.direct);
                $("#kongqi").text("空气质量：" + response.result.realtime.aqi);


                getWeatherImage(response);
                getWeatherCard(response);



            }
        }
    });
}



$(document).ready(function () {
getWeather();
$("#searchweather").click(function () {
    getWeather();
})
})