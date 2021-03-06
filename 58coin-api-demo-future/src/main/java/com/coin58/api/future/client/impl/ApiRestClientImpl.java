
package com.coin58.api.future.client.impl;

import com.alibaba.fastjson.JSONObject;
import com.coin58.api.common.impl.ApiServiceGenerator;
import com.coin58.api.future.client.ApiRestClient;
import com.coin58.api.future.client.domain.*;

import java.math.BigDecimal;
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

    public JSONObject transfer(String currencyName, Integer triggerSiteId, Integer targetSiteId, String amount) {
        return ApiServiceGenerator.executeSync(apiService.transfer(currencyName, triggerSiteId, targetSiteId, amount));
    }

    @Override
    public List<AssetsResponse> getAssets(int siteId) {
        return ApiServiceGenerator.executeSync(apiService.getAssets(siteId));
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

    @Override
    public AssetResponse getAsset() {
        return ApiServiceGenerator.executeSync(apiService.getAsset());
    }

    @Override
    public NewOrderResponse newOrder(NewOrder order) {
        return ApiServiceGenerator.executeSync(apiService.newOrder(order.getContractId(), order.getOrderType().getCode(), order.getSide().getCode(), order.getLeverage(), order.getSize(),