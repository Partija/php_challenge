package com.coin58.api.mix.client.impl;

import com.coin58.api.common.impl.ApiServiceGenerator;
import com.coin58.api.mix.client.ApiRestClient;
import com.coin58.api.mix.client.domain.Contract;
import com.coin58.api.mix.client.domain.KlineResponse;
import com.coin58.api.mix.client.domain.TickerResponse;
import com.coin58.api.mix.client.domain.TradeResponse;
import com.coin58.api.mix.client.domain.DepthResponse;

import java.util.List;

/**
 * Implementation of 58coin's REST API using Retrofit with synchronous/blocking method calls.
 */
public class ApiRestClientImpl implements ApiRestClient {

    private final ApiService apiService;

    public ApiRestClientImpl(String apiKey, String secret) {
        apiService = ApiServiceGenerator.createService(ApiService.class, apiKey, secret);
    }

    public ApiRestClientImpl(String apiKey, String secret, String restUrl) {
        apiService = ApiServiceGenerator.createService(ApiService.class, apiKey, secret, restUrl);
    }

    @Override
    public List<TradeResponse> getTrades(long contraceId){
        return ApiServiceGenerator.executeSync(apiService.getTrades(contraceId));
    }

    @Override
    public List<Contract> getContractList() {
        return ApiServiceGenerator.executeSync(apiService.getContractList());
    }

    @Override
    public List<KlineResponse> getKline(Long contractId, Integer type, Long since) {
        return ApiServiceGenerator.executeSync(apiService.getKline(contractId, type, since));
    }

    @Override
    public TickerResponse getTicker(long contraceId) {
        return ApiServiceGenerator.executeSync(apiService.getTickerList(contraceId));
    }

    @Override
    public DepthResponse getDepth(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.getDepth(contractId));
    }

}