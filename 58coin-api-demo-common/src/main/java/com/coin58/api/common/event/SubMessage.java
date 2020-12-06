package com.coin58.api.common.event;

import lombok.Data;

@Data
public class SubMessage {

    /**
     * eventEnum
     */
    private String event;

    private Long ts;

    private String product;

    /**
     * kline ticker
     */
    private String type;

    /**
     * 消息
     */
    private String msg;

    /**
     * 返回码
     */
    private String code;

    private String business;


}
