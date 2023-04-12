
package com.coin58.api.swaps.client.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coin58.api.common.impl.ApiServiceGenerator;
import com.coin58.api.swaps.client.ApiRestClient;
import com.coin58.api.swaps.client.domain.*;
import retrofit2.http.Query;

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
    public TickerResponse getTicker(long contractId) {
        List<TickerResponse> tickerResponses = ApiServiceGenerator.executeSync(apiService.getTickerList(contractId));
        if(tickerResponses == null || tickerResponses.size() == 0) return null;
        return tickerResponses.get(0);
    }

    @Override
    public DepthResponse getDepth(Long contractId) {
        List<DepthResponse> depthResponses = ApiServiceGenerator.executeSync(apiService.getDepth(contractId));
        if(depthResponses == null || depthResponses.size() == 0) return null;
        return depthResponses.get(0);
    }

    @Override
    public AssetResponse getAsset(long contractId) {
        return ApiServiceGenerator.executeSync(apiService.getAsset(contractId));
    }

    @Override
    public NewOrderResponse newOrder(NewOrder order) {
        return ApiServiceGenerator.executeSync(apiService.newOrder(order.getContractId(), order.getOrderType().getCode(),
                order.getSide().getCode(),  order.getSize(),
                order.getPrice().toPlainString(), order.getCloseType().getCode()));
    }

    @Override
    public JSONObject cancelOrder(long productId, long orderId) {
        return ApiServiceGenerator.executeSync(apiService.cancelOrder(productId, orderId));
    }

    @Override
    public JSONObject cancelOrderBatch(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.cancelOrderBatch(contractId));
    }

//    @Override
//    public JSONObject closeAll() {
//        return ApiServiceGenerator.executeSync(apiService.closeAll());
//    }

    @Override
    public List<OrderListResponse> getOrderList(long contractId, Long orderId, String status,
                                                String beginDate, String endDate,
                                                Integer page, Integer pageSize) {
        return ApiServiceGenerator.executeSync(apiService.getOrderList(contractId, orderId, status, beginDate, endDate, page, pageSize));
    }

    @Override
    public List<FillListResponse> getOrderFillList(long contractId, String beginDate, String endDate,
                                                   Integer page, Integer pageSize){

        return ApiServiceGenerator.executeSync(apiService.getOrderFillList(contractId, beginDate, endDate, page, pageSize));
    }

    @Override
    public PositionResponse getPositionList(long contractId) {
        return ApiServiceGenerator.executeSync(apiService.getPositionList(contractId));
    }

    @Override
    public JSONObject newPlanOrder(NewPlanOrder planOrder) {
        return ApiServiceGenerator.executeSync(
                apiService.placePlanOrder(planOrder.getContractId(), planOrder.getSide(),
                        planOrder.getTriggerPrice(), planOrder.getSize(),
                        planOrder.getPrice()));
    }

    @Override
    public JSONObject cancelPlan(long planId, long contractId) {
        return ApiServiceGenerator.executeSync(apiService.cancelPlan(planId, contractId));
    }

    @Override
    public JSONObject cancelPlanBatch(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.cancelPlanBatch(contractId));
    }

    @Override
    public List<PlanListResponse> getPlanList(long contractId, String status,
                                              String beginDate, String endDate,
                                              Integer page, Integer pageSize) {
        return ApiServiceGenerator.executeSync(apiService.getPlanList(contractId, status, beginDate, endDate, page, pageSize));
    }

    /**
     * 获取账单信息
     * @param action