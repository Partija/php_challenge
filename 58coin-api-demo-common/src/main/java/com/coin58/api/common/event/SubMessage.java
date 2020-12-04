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
    p