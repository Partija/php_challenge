package com.coin58.api.mix.client.domain;


import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lhc
 * @version 1.0
 * @description Account related - asset query - response entity
 * @modify
 */
@Data
public class TradeResponse {

    private int size;
    private BigDecimal price;
    private int side;
    private long createDate;

    @Override
    public String toString() {
        return "TradeResponse{" +
                "size=" + size +
                ", price=" + price +
                ", side=" + side +
                ", createDate=" + createDate +
                '}';
    }
}
