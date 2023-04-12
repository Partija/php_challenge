package com.coin58.api.swaps.client.domain;

import com.coin58.api.common.enums.CloseTypeEnum;
import com.coin58.api.common.enums.OrderTypeEnum;
import com.coin58.api.common.enums.SideEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewOrder {

    private long contractId;
    private OrderTypeEnum orderType;
    private SideEnum side;
    private int size;
    private BigDecimal price;
    private CloseTypeEnum closeType;
}