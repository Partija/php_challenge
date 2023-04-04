
package com.coin58.api.swaps.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coin58.api.swaps.client.domain.*;
import retrofit2.http.Query;

import java.util.List;

/**
 * 58coin API façade, supporting synchronous/blocking access 58coin's REST API.
 */
public interface ApiRestClient {

    JSONObject transfer(String currencyName, Integer triggerSiteId, Integer targetSiteId, String amount);

    List<AssetsResponse> getAssets(int siteId);

    List<Contract> getContractList();

    List<KlineResponse> getKline(Long contractId, Integer type, Long since);

    TickerResponse getTicker(long contractId);

    DepthResponse getDepth(Long contractId);

    AssetResponse getAsset(long contractId);

    NewOrderResponse newOrder(NewOrder order);

    JSONObject cancelOrder(long productId, long orderId);

    JSONObject cancelOrderBatch(Long contractId);

    List<OrderListResponse> getOrderList(long contractId, Long orderId, String status,
                                         String beginDate, String endDate,
                                         Integer page, Integer pageSize);

    List<FillListResponse> getOrderFillList(long contractId, String beginDate, String endDate,
                     Integer page, Integer pageSize);

    PositionResponse getPositionList(long contractId);

    JSONObject newPlanOrder(NewPlanOrder planOrder);

    JSONObject cancelPlan(long planId, long contractId);

    JSONObject cancelPlanBatch(Long contractId);

    List<PlanListResponse> getPlanList(long contractId, String status,
                                       String beginDate, String endDate,
                                       Integer page, Integer pageSize);

    /**
     * 获取账单信息
     * @param action
     * @param startDate
     * @param endDate
     * @param curPage
     * @return
     */
    List<LedgerResponse> getLedgerList(Long contractId, Integer action,  String startDate, String endDate, Integer curPage, Integer pageSize);

}