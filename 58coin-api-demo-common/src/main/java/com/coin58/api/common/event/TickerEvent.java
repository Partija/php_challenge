package com.coin58.api.common.event;

import lombok.Data;

@Data
public class TickerEvent {

    private String type;
    private String product;
    private String business;
    private TickerDto data;

    @Data
    public static class TickerDto {
        private String id;
        private String open;
        private String high;
        private String low;
        private String last;
        private String sell;
        private String buy;
        private String volume;
        private String amount;
        private String product;
        private String change;
        private String time;
    }

}
