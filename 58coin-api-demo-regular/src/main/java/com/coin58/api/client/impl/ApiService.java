package com.coin58.api.client.impl;

import com.alibaba.fastjson.JSONObject;
import com.coin58.api.client.domain.*;
import com.coin58.api.common.constant.ApiConstants;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 58coin's REST API URL mappings and endpoint security configuration.
 */
public interface ApiService {

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/account/transfer/request")
    Call<JSONObject> transfer(@Field("currencyName") String currencyName, @Field("triggerSiteId") Integer triggerSiteId, @Field("targetSiteId") Integer targetSiteId, @Field("amount") String amount);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/account/assets/sites")
    Call<List<AssetsResponse>> getAssets(@Query("siteId") int siteId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/regular/account/wallet")
    Call<JSONObject> getWallet();

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/regular/account/transfer")
    Call<JSONObject> accountTransfer(@Field("contractId") long contractId, @Field("action") long action, @Field("amount") BigDecimal amount);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/regular/contract/list")
    Call<List<Contract>> getContractList();

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/regular/guide/settlement/list")
    Call<List<SettlementResponse>> getSettlementList();

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/regular/market/kline")
    Call<List<KlineResponse>> getKline(@Query("contractId") String contractId, @Query("type") String type, @Query("since") long since);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/regular/market/ticker")
    Call<TickerResponse> getTickerList(@Query("contractId") long contraceId);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/regular/market/depth")
    Call<DepthResponse> getDepth(@Query("contractId") long contractId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/regular/account/asset")
    Call<AssetResponse> getAsset(@Query("contractId") Long contractId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/regular/order/place")
    Call<NewOrderResponse> newOrder(@Field("contractId") long contractId, @Field("type") Integer type, @Field("side") Integer side, @Field("leverage") Integer leverage, @Field("size") Integer size,
                                    @Field("price") BigDecimal price, @Field("close") Integer close);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/regular/order/cancel")
    Call<JSONObject> cancelOrder(@Field("orderId") long orderId, @Field("contractId") long contractId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/regular/order/cancel/batch")
    Call<JSONObject> cancelOrderBatch(@Field("contractId") long contractId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @POST("/v1/regular/order/close/all")
    Call<JSONObject> closeAll(long contractId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/regular/order/list")
    Call<List<OrderListResponse>> getOrderList(@Query("contractId") long contractId, @Query("side") Integer side, @Query("close") Integer close);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/regular/order/fill/list")
    Call<List<FillListResponse>> getFillList(@Query("contractId") long contractId, @Query("close") Integer close, @Query("limit") Integer limit);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/regular/order/finish")
    Call<FinishOrderResponse> getFinishOrder(@Query("orderId") long orderId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/regular/position/list")
    Call<JSONObject> getPositionList(@Query("contractId") long contractId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/regular/order/plan/close")
    Call<JSONObject> newPlanOrder(@Field("contractId") long contractId, @Field("side") Integer side, @Field("triggerPrice") String triggerPrice, @Field("size") Integer size, @Field("mode") Integer mode,
                                  @Field("type") Integer type, @Field("price") String price);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/regular/order/plan/cancel")
    Call<JSONObject> cancelPlan(@Field("contractId") long contractId, @Field("planId") long planId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/regular/order/plan/cancel/batch")
    Call<JSONObject> cancelPlanBatch(@Field("contractId") Long contractId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/regular/order/plan/list")
    Call<List<PlanListResponse>> getPlanList(@Query("contractId") long contractId, @Query("limit") Integer limit);


    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/regular/ledger/list")
    Call<List<LedgerResponse>> getLedgetList(@Query("contractId") Long contractId, @Query("action") Integer action, @Query("startDate") Long startDate, @Query("endDate") Long endDate, @Query("curPage") Integer curPage, @Query("pageSize") Integer pageSize);

}