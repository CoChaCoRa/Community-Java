package com.example.community.enums;

public enum CommentTypeEnum {
    POST(1),
    COMMENT(2);
    private Integer type;

    public static boolean contains(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
