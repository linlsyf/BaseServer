function setCookie(c_name, value, expiretimes){
    var exdate=new Date();
    exdate.setTime(exdate.getTime()+(expiretimes*60*60*1000));
    console.log(exdate);  //Tue Nov 05 2019 21:21:26 GMT+0800 (中国标准时间)
    console.log(exdate.toGMTString());   //Tue, 05 Nov 2019 13:21:26 GMT
    //相差8小时
    document.cookie=c_name+ "=" + escape(value) + ";path=/" + ((expiretimes==null) ? "" : ";expires="+exdate.toGMTString());
}
//读取cookies
function getCookie(name){
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return (arr[2]);
    else
        return null;
}


function   pageChane(url){
    // $(location).attr('href', "/admin-table.html");

    $(location).attr('href', url);

}
function  checkLogin(){
    var zticket=getCookie("zticket")

    if(null==zticket||   ""==zticket){
        $(location).attr('href', "/login.html");
        debugger
    }
}

function pageJump(url) {
    // //把静态网页路径和要加载的页面的内容的ID拼接
    // //var request = url + " " + "#startPage";
    $("#content").load(url,null,function () {

        if(url.indexOf('content_two')>-1){
            $("#content_two").append("<p>文本。</p>");
        }


    });
}