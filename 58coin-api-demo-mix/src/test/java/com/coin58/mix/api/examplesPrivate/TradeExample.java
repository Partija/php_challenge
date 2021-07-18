
package com.coin58.mix.api.examplesPrivate;


import com.coin58.api.mix.client.ApiClientFactory;
import com.coin58.api.mix.client.ApiRestClient;
import com.coin58.api.mix.client.domain.TradeResponse;

import java.util.List;

/**
 * @author guozhengMu
 * @version 1.0
 * @date 2019/3/13 15:17
 * @description Term contract - account - user assets
 * @modify
 */
public class TradeExample {
    public static void main(String[] args) {
        String apiKey = "cc531d0d-5570-4c3a-985f-0bf0d050fbad";
        String apiSecret = "534C96F7EE0236E11442AB852225DB20";
        ApiClientFactory factory = ApiClientFactory.newInstance(apiKey, apiSecret);
        ApiRestClient client = factory.newRestClient();

        List<TradeResponse> trades = client.getTrades(4001l);
        System.out.println(trades);
    }
}