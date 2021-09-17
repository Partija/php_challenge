package com.coin58.api.client;


import com.coin58.api.common.ApiSocketClient;
import com.coin58.api.client.impl.ApiAsyncRestClientImpl;
import com.coin58.api.client.impl.ApiRestClientImpl;
import com.coin58.api.common.impl.ApiServiceGenerator;
import com.coin58.api.common.impl.ApiSocketClientImpl;

/**
 * A factory for creating 58coin Api client objects.
 */
public class ApiClientFactory {

    private String apiKey;

    private String apiSecret;

    private ApiClientFactory(String apiKey