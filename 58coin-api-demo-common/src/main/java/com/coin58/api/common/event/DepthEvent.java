package com.coin58.api.common.event;

import lombok.Data;

@Data
public class DepthEvent {

    private String type;
    private String product;
    private String business;
    private DepthDto data;

    @Data
    public static class DepthDto {

        private Object[][] bids;

        private Object[][] asks;

    }


}
