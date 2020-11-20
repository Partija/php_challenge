package com.coin58.api.common.enums;

/**
 * Order type
 */
public enum OrderTypeEnum {

    LIMIT(1), MARKET(2);

    int code;

    OrderTypeEnum(int code) {
        this.