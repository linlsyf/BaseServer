function toPost(params,url,callback,callBackError) {

    $.ajax({
        "url" : url,
        "data" : params,
        "type" : "post",
        dataType: 'jsonp',
        "success" : function(data) {
            // 参数为json类型的对象
           // alert(data.message)
            callback.call(data);
        },
        "error" : function() {
            // alert("用户名或者密码错误");
            callBackError.call();
        }
    });


}