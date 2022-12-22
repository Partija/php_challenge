
package com.coin58.api.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 *
 * @author zhiwei.deng
 * @date 2017-06-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    /**
     * 订单id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 交易方向  1:买 2:卖
     */
    private Byte side;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private BigDecimal size;
    /**
     * 已成交数量
     */
    private BigDecimal filledSize;
    /**
     * 基准币数量  只有在市价买的情况下会用到
     */
    private BigDecimal quoteSize;
    /**
     * 订单类型 0:限价单 1:市价单
     */