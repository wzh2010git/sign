package com.wuzhou.common;

public enum ResultCode {
    SUCCESS(0, "SUCCESS"),
    FAIL(-1, "fail"),
    NEED_LOGIN(1, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private int code;

    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
