package com.coin58.api.common.enums;

public enum CloseTypeEnum {

    OPEN(0), CLOSE(1);

    int code;

    CloseTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
