package com.coin58.api.future.client;

import com.alibaba.fastjson.JSONObject;
import com.coin58.api.future.client.domain.*;

import java.math.BigDecimal;
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

    AssetResponse getAsset();

    NewOrderResponse newOrder(NewOrder order);

    JSONObject cancelOrder(long orderId);

    JSONObject cancelOrderBatch(Long contractId);

    JSONObject closeAll();

    List<OrderListResponse> getOrderList(String contractIds, Integer side, Integer close);

    List<FillListResponse> getFillList(String contractIds, Integer close, Integer limit);

    JSONObject getPositionList(String contractIds);

    JSONObject newPlanOrder(NewPlanOrder planOrder);

    JSONObject cancelPlan(long planId);

    JSONObject c