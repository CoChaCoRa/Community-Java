package com.example.community.enums;

public enum NotificationTypeEnum {
    REPLY_POST(1, "回帖"),
    REPLY_COMMENT(2, "回复评论"),
    THUMB_COMMENT(3, "点赞");
    private int type;
    private String name;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String nameOfType(int type) {
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if (notificationTypeEnum.getType() == type) {
                return notificationTypeEnum.getName();
            }
        }
        return "";
    }
}
