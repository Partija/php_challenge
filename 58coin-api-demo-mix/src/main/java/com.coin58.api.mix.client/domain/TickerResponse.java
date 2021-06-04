
package com.coin58.api.mix.client.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lhc
 * @version 1.0
 * @description
 * @modify
 */
@Data
public class TickerResponse {
    private long seq;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal last;
    private BigDecimal buy;
    private BigDecimal sell;
    private BigDecimal change;
    private BigDecimal volume;
    private BigDecimal amount;
    private long productId;
    private long time;
    private long createdDate;

    @Override
    public String toString() {
        return "TickerResponse{" +
                "seq=" + seq +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", last=" + last +
                ", buy=" + buy +
                ", sell=" + sell +
                ", change=" + change +
                ", volume=" + volume +
                ", amount=" + amount +
                ", productId=" + productId +
                ", time=" + time +
                ", createdDate=" + createdDate +
                '}';
    }
}