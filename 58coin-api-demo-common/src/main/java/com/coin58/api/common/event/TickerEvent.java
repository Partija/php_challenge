package com.coin58.api.common.event;

import lombok.Data;

@Data
public class TickerEvent {

    private String type;
    private String product;
    private String business;
    private Tick