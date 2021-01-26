package com.coin58.api.future.client;


import com.coin58.api.common.ApiSocketClient;
import com.coin58.api.common.impl.ApiServiceGenerator;
import com.coin58.api.common.impl.ApiSocketClientImpl;
import com.coin58.api.future.client.impl.ApiRestClientImpl;

/**
 * A factory for creating 58coin Api client objects.
 */
public class ApiClientFactory {

    private String apiKey;

    private String apiSecret;

    private ApiClientFactory(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public static ApiClientFactory newInstance(String apiKey, St