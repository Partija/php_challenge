package com.coin58.mix.api.examplesPublic;

import com.coin58.api.mix.client.ApiClientFactory;
import com.coin58.api.mix.client.ApiRestClient;

/**
 * @author guozhengMu
 * @version 1.0
 * @date 2019/3/12 18:34
 * @description Term Contract - Market Quotes - Depth Data
 * @modify
 */
public class DepthExample {
    public static void main(String[] args) {
        ApiClientFactory factory = ApiClientFactory.newInstance();
        ApiRestClient client = factory.newRestClient();

        System.out.println(client.getDepth(4001L));
    }
}
