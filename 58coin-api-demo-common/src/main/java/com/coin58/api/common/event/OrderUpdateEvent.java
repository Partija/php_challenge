package com.coin58.api.common.event;

import lombok.Data;

import java.util.List;

@Data
public class OrderUpdateEvent {

    private String type;
    private String business;
    private List<OrderDto> data;

    @Data
    public static class OrderDto {
        private String orderId;
        private Integer side;
        private String leverage;
        private Integer close;
        private Integer type;
        private Integer status;
        private Long userId;
        private String product;
        private String triggerPrice;
        private String orderPrice;
        private String orderSize;
        private String operationType;
        private String fillPrice;
        private String fillSize;
        private String fee;
        private String feeUnit;
        private String executedSize;
        private String avgPrice;
        private String operationResult;
        private String reason;

    }

}
