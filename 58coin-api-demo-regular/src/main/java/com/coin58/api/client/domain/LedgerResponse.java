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
