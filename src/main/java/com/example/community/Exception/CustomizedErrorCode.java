package com.example.community.Exception;

public enum CustomizedErrorCode implements ICustomizedErrorCode{
    POST_NOT_FOUND(2001, "帖子不存在"),
    TARGET_PARAM_NOT_FOUND(2002, "回复的问题/评论不存在"),
    NO_LOGIN(2003, "未登录"),
    TYPE_PARAM_WRONG(2004, "评论类型错误"),
    COMMENT_NOT_FOUND(2005, "评论未找到"),
    COMMENT_IS_EMPTY(2006, "评论为空"),
    READ_NOTIFICATION_FAIL(2007, "消息读取错误"),
    NOTIFICATION_NOT_FOUND(2008, "消息未找到"),
    ALREADY_LOGGED_IN(2009, "该邮箱已注册"),
    SYS_ERROR(2099, "服务端出错");

    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    CustomizedErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
