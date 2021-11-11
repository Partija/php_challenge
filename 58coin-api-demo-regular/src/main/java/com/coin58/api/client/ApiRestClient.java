package com.coin58.api.client;

import com.alibaba.fastjson.JSONObject;
import com.coin58.api.client.domain.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 58coin API façade, supporting synchronous/blocking access 58coin's REST API.
 */
public interface ApiRestClient {

    JSONObject transfer(String currencyName, Integer triggerSiteId, Integer targetSiteId, String amount);

    List<AssetsResponse> getAssets(int siteId);

    List<Contract> getContractList();

    List<SettlementResponse> getSettlementList();

    List<KlineResponse> getKline(String product, String type, long since);

    TickerResponse getTicker(long contractId);

    DepthResponse getDepth(Long contractId);

    AssetResponse getAsset(Long contractId);

    NewOrderResponse newOrder(NewOrder order);

    JSONObject cancelOrder(long orderId, long cancelOrder);

    JSONObject cancelOrderBatch(Long contractId);

    JSONObject closeAll(long contractId);

    List<OrderListResponse> getOrderList(long contractId, Integer side, Integer close);

    List<FillListResponse> getFillList(long contractId, Integer close, Integer limit);

    JSONObject getPositionList(long contractId);

    JSONObject newPlanOrder(NewPlanOrder planOrder);

    JSONObject cancelPlan(long contractId, long planId);

    JSONObject cancelPlanBatch(Long contractId);

    List<PlanListResponse> getPlanList(long contractId, Integer limit);

    JSONObject getWallet();

    JSONObject accountTransfer(long contractId, long action, BigDecimal amount);

    /**
     * 获取账单信息
     * @param contractId
     * @param action
     * @param startDate
     * @param endDate
     * @param curPage
     * @return
     */
    List<LedgerResponse> getLedgetList(Long contractId, Integer action, Long startDate, Long endDate, Integer curPage, Integer pageSize);

    /**
     * 获取已完成订单的信息
     * @param orderId
     * @return
     */
    FinishOrderResponse getFinishOrder(long orderId);
}