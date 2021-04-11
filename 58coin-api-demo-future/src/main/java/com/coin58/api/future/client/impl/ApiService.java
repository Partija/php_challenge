package com.coin58.api.future.client.impl;

import com.alibaba.fastjson.JSONObject;
import com.coin58.api.common.constant.ApiConstants;
import com.coin58.api.future.client.domain.*;
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

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/usdt/contract/list")
    Call<List<Contract>> getContractList();

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/usdt/market/kline")
    Call<List<KlineResponse>> getKline(@Query("contractId") Long contractId, @Query("type") Integer type, @Query("since") Long since);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/usdt/market/ticker")
    Call<TickerResponse> getTickerList(@Query("contractId") long contraceId);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/usdt/market/depth")
    Call<DepthResponse> getDepth(@Query("contractId") long contractId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/usdt/account/asset")
    Call<AssetResponse> getAsset();

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/usdt/order/place")
    Call<NewOrderResponse> newOrder(@Field("contractId") long contractId, @Field("type") Integer type, @Field("side") Integer side,
                                    @Field("leverage") Integer leverage, @Field("size") Integer size,
                                    @Field("price") BigDecimal price, @Field("close") Integer close);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/usdt/order/cancel")
    Call<JSONObject> cancelOrder(@Field("orderId") long orderId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/usdt/order/cancel/batch")
    Call<JSONObject> cancelOrderBatch(@Field("contractId") Long contractId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @POST("/v1/usdt/order/close/all")
    Call<JSONObject> closeAll();

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/usdt/order/list")
    Call<List<OrderListResponse>> getOrderList(@Query("contractIds") String contractIds, @Query("side") Integer side,
                                               @Query("close") Integer close);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/usdt/order/fill/list")
    Call<List<FillListResponse>> getFillList(@Query("contractIds") String contractI