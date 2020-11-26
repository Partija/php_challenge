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
        private Integer 