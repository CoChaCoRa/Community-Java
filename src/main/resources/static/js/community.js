function commentToPost() {
     var postId = $("#post_id").val();
     var content = $("#comment_content").val();
     post(postId,1,content);

}

function commentToComment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    post(commentId,2,content);
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
//                        window.open(localhostPath + "/login");
                        window.open("https://github.com/login/oauth/authorize?client_id=7919fd8c770c7c7ab699&redirect_uri=http://localhost:8087/callback&scope=user&state=1");
                        window.localStorage.setItem("closable","true");
                    }

                }else {
                    alert(response.message);
                }

            }
            console.log(response);
        },
        dataType: "json"
    })

}

function queryComments(e){

    var id = e.getAttribute("aria-controls");
    var comments = $('#' + id);
    // 获取二级评论展开状态
    var collapse = e.getAttribute("aria-expanded");
    // 第一次展开时执行get请求
    if (collapse === 'true' && comments.children().length == 1){
        var commentElement = $("<div />", {
                                "class" : "list-info"
                             });
        comments.prepend(commentElement);
        $.getJSON("/comment/" + id.split('-')[1], function (data) {
//                        console.log(data);
                        $.each(data.data, function(index, comment) {

                            // 头像div
                            var avatar = $("<div />", {
                                "class" : "flex-shrink-0"
                            }).append($("<img />", {
                                "class" : "img-fluid",
                                "style" : "width: 40px;height: 40px;border: 1px solid #ddd;border-radius: 20%;margin-right: 10px;",
                                "src" : comment.user != null ? comment.user.avatarUrl :'/images/default-avatar.png'
                            }));

                            // 用户名div
                            var userInfo = $("<div/>").append($("<span/>", {
                                "style" : "align-self: center; font-size: 14px;",
                                "text" : comment.user!= null ? comment.user.name:'已注销用户'
                            }));

                            // 评论时间div
                            var timeInfo = $("<div/>").append($("<span/>", {
                               "style" : "align-self: center; font-size: 14px;",
                               "text" : dayjs(comment.gmtCreate).format('YYYY/MM/DD HH:mm')
                            }));


                            var info = $("<div/>").append(userInfo).append(timeInfo);

                            var commentFlex = $("<div />", {
                                "class" : "d-flex mt-2"
                            }).append(avatar).append(info);

                            var content = $("<div/>", {
                                "class" : "col-12",
                                "style" : "margin-top: 10px; font-size: 16px;"
                            }).append($("<span/>", {
                                "text" : comment.content
                            }));

                            var replyButton = $("<button/>", {
                                "type" : "button",
                                "class" : "btn btn-labeled btn-outline-dark btn-sm",
                                "style" : "float: right;",
                                "on-click" : "reply(this)"
                            }).append($("<span/>", {
                                "class" : "btn-label"
                            })).append($("<i/>", {
                                "class" : "bi bi-reply"
                            }));
                            content.append(replyButton);

                            commentElement.prepend(content).prepend(commentFlex);
                        });

        });
    }

}

function reply()

function thumbComments(e) {

    console.log("thumb up");

}