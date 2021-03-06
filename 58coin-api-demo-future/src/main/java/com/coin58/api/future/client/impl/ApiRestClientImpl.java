
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
                order.getPrice(), order.getCloseType().getCode()));
    }

    @Override
    public JSONObject cancelOrder(long orderId) {
        return ApiServiceGenerator.executeSync(apiService.cancelOrder(orderId));
    }

    @Override
    public JSONObject cancelOrderBatch(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.cancelOrderBatch(contractId));
    }

    @Override
    public JSONObject closeAll() {
        return ApiServiceGenerator.executeSync(apiService.closeAll());
    }

    @Override
    public List<OrderListResponse> getOrderList(String contractIds, Integer side, Integer close) {
        return ApiServiceGenerator.executeSync(apiService.getOrderList(contractIds, side, close));
    }

    @Override
    public List<FillListResponse> getFillList(String contractIds, Integer close, Integer limit) {
        return ApiServiceGenerator.executeSync(apiService.getFillList(contractIds, close, limit));
    }

    @Override
    public JSONObject getPositionList(String contractIds) {
        return ApiServiceGenerator.executeSync(apiService.getPositionList(contractIds));
    }

    @Override
    public JSONObject newPlanOrder(NewPlanOrder planOrder) {
        return ApiServiceGenerator.executeSync(
                apiService.newPlanOrder(planOrder.getContractId(), planOrder.getSide(), planOrder.getTriggerPrice(), planOrder.getSize(), planOrder.getMode(), planOrder.getType(), planOrder.getPrice()));
    }

    @Override
    public JSONObject cancelPlan(long planId) {
        return ApiServiceGenerator.executeSync(apiService.cancelPlan(planId));
    }

    @Override
    public JSONObject cancelPlanBatch(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.cancelPlanBatch(contractId));
    }

    @Override
    public List<PlanListResponse> getPlanList(String contractIds, Integer limit) {
        return ApiServiceGenerator.executeSync(apiService.getPlanList(contractIds, limit));
    }

    /**
     * 获取账单信息
     * @param action
     * @param startDate
     * @param endDate
     * @param curPage
     * @return
     */
    @Override
    public List<LedgerResponse> getLedgerList(Integer action,  Long startDate, Long endDate, Integer curPage, Integer pageSize) {
        return ApiServiceGenerator.executeSync(apiService.getLedgerList(action,startDate,endDate,curPage, pageSize));
    }


    /**
     * 获取已完成订单的状态
     * @param orderId
     * @return
     */
    @Override
    public FinishOrderResponse getFinishOrder(long orderId) {
        return ApiServiceGenerator.executeSync(apiService.getFinishOrder(orderId));
    }
}