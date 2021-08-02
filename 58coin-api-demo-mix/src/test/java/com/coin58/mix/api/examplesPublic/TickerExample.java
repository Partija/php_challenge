package com.coin58.mix.api.examplesPublic;

import com.coin58.api.mix.client.ApiClientFactory;
import com.coin58.api.mix.client.ApiRestClient;
import com.coin58.api.mix.client.domain.TickerResponse;

/**
 * @author guozhengMu
 * @version 1.0
 * @description Term Contract - Market Data - Latest Transaction Data List
 * @modify
 */
public class TickerExample {
    public static void main(String[] args) {
        ApiClientFactory factory = ApiClientFactory.newInstance();
        ApiRestClient client = factory.newRestClient();

        TickerResponse tickerResponses = client.getTicker(4001L);

        System.out.println(tickerResponses);
    }
}
