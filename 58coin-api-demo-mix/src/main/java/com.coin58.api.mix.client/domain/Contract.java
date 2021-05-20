
package com.coin58.api.mix.client.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Contract {

    private Long seq;
    private String name;
    private Long currencyId;

    private BigDecimal value;
    private BigDecimal maxLeverage;
    private BigDecimal takerCommision;
    private BigDecimal makerCommision;
    private BigDecimal maintenanceMarginRate;
    private BigDecimal liquidationLine;
    private BigDecimal maxOrderSize;
    private BigDecimal maxOrderQuantity;


    @Override
    public String toString() {
        return "Contract{" + //
                "seq=" + seq + //
                ", name='" + name + '\'' + //
                ", currencyId=" + currencyId + //
                ", value=" + value + //
                ", maxLeverage=" + maxLeverage + //
                ", takerCommision=" + takerCommision + //
                ", makerCommision=" + makerCommision + //
                ", maintenanceMarginRate=" + maintenanceMarginRate + //
                ", liquidationLine=" + liquidationLine + //
                ", maxOrderSize=" + maxOrderSize + //
                ", maxOrderQuantity=" + maxOrderQuantity + //
                '}';
    }
}