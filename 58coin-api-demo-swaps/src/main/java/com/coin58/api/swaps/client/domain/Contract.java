
package com.coin58.api.swaps.client.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Contract {

    private Long id;
    private String name;
    private String unit;
    private Long value;
    private BigDecimal maxLeverage;
    private BigDecimal maintenanceMarginRate;
    private BigDecimal takerCommision;
    private BigDecimal makerCommision;


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
                '}';
    }
}