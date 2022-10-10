function commentToPost() {
     var postId = $("#post_id").val();
     var content = $("#comment_content").val();
     post(postId,1,content);

}

function post(targetId, type, content) {
    if (!content) {
        alert("内容为空.......");
        return;
    }
    $.ajax({
        type: "POST",
        url:"/comment",
        contentType:"application/json",
        data:JSON.stringify( {
            "parentId":targetId,
            "content":content,
            "parentType":type
        }),
        success: function (response) {
            if (response.code == 200){
                window.location.reload();
            }else {
                //评论未登录返回登录页面
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        debugger;
                        //获得当前目录
                        var curPath = window.document.location.href;
                        //获取主机地址之后的目录，如： test/test.jsp
                        var pathName = window.document.location.pathname;
                        //计算目录名字的索引位置
                        var pos = curPath.indexOf(pathName);
                        //获取主机地址，如： http://localhost:8088
                        var localhostPath = curPath.substring(0, pos);
                        //在原来的窗口中打开新的窗口
                        window.open(localhostPath + "/login");
                        window.localStorage.setItem("closable","true");
                    }

                }else {
                    alert(response.message);
                }

            }
//            console.log(response);
        },
        dataType: "json"
    })

}