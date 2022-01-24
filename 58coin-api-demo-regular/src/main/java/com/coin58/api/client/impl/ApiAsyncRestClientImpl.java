package com.coin58.api.client.impl;

import com.coin58.api.client.ApiAsyncRestClient;
import com.coin58.api.client.domain.Contract;
import com.coin58.api.client.domain.NewOrder;
import com.coin58.api.client.domain.NewOrderResponse;
import com.coin58.api.common.ApiCallback;
import com.coin58.api.common.impl.ApiCallbackAdapter;
import com.coin58.api.common.impl.ApiServiceGenerator;

import java.util.List;

/**
 * Implementation of 58coin's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class ApiAsyncRestClientImpl implements ApiAsyncRestClient {

    private final ApiService apiService;

    public ApiAsyncRestClientImpl(String apiKey, String secret) {
        apiService = ApiServiceGenerator.createService(ApiService.class, apiKey, secret);
    }

    public ApiAsyn