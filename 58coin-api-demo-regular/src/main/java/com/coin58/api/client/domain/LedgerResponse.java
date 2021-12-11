package com.coin58.api.client.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @BelongsPackage com.coin58.api.client.domain
 * @ClassName LedgerResponse
 * @Author gexinghua915@sina.com
 * @Tmie 2019-08-15 17:24
 * @Version 1.0
 */
@Data
public class LedgerResponse {

    /**
     * 账单ID
     */
    private long id;
    /**
     * 用户id
     */
    private long userId;
    /**
     * 合约id
     */
    private long contractId;
    /**
     * 合约名称
     */
    private String contractName;
    /**
     * 账单类型
     * 0：买
     * 1：卖
     * 2：转入
     * 3：转出
     * 20：爆仓
     * 27：周结算
     * 28：交割
     * 30：总账户转入子账户
     * 31：子账户转入总账户
     */
    private int action;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 手续费
     */
    private BigDecimal fee;
    /**
     * 已实现
     */
    private BigDecimal realised;
    /**
     * 账户交易前账户余额
     */
    private BigDecimal oldBalance;
    /**
     * 账户交易后账户余额
     */
    private BigDecimal newBalance;
    /**
     *  创建时间
     */
    private long createdDate;

}
