
package com.coin58.api.future.client.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Contract {

    private Long id;
    private String name;
    private String unit;

    private BigDecimal value;
    private BigDecimal maxLeverage;
    private BigDecimal takerCommision;
    private BigDecimal makerCommision;
    private BigDecimal maintenanceMarginRate;
    private BigDecimal liquidationLine;
    private Integer intervalHour;
    private Integer settlementBeginHour;
    private BigDecimal maxOrderSize;
    private BigDecimal maxOrderQuantity;

    private BigDecimal limitPrizeOffsetRate;
    private Date deliverDate;

    @Override
    public String toString() {
        return "Contract{" + //
                "id=" + id + //
                ", name='" + name + '\'' + //
                ", unit='" + unit + '\'' + //
                ", value=" + value + //
                ", maxLeverage=" + maxLeverage + //
                ", takerCommision=" + takerCommision + //
                ", makerCommision=" + makerCommision + //
                ", maintenanceMarginRate=" + maintenanceMarginRate + //
                ", liquidationLine=" + liquidationLine + //
                ", intervalHour=" + intervalHour + //
                ", settlementBeginHour=" + settlementBeginHour + //
                ", maxOrderSize=" + maxOrderSize + //
                ", maxOrderQuantity=" + maxOrderQuantity + //
                ", limitPrizeOffsetRate=" + limitPrizeOffsetRate + //
                ", deliverDate=" + deliverDate + //
                '}';
    }
}