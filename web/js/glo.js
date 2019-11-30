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