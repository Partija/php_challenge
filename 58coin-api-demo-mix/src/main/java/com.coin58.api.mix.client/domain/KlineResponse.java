package com.coin58.api.mix.client.domain;

import lombok.Data;

/**
 * @author lhc
 * @version 1.0
 * @date 2019/3/14 19:55
 * @description
 * @modify
 */
@Data
public class KlineResponse {

    private String id;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String amount;
    private String productId;
    private String type;
    private String time;

    @Override
    public String toString() {
        return "Kline{" +
                "id=" + id +
         