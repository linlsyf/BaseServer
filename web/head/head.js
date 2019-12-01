

function   pageChane(url){
    // $(location).attr('href', "/admin-table.html");

    $(location).attr('href', url);

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


