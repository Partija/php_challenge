
package com.coin58.api.swaps.client.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coin58.api.common.constant.ApiConstants;
import com.coin58.api.swaps.client.domain.*;
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
    @GET("/v1/swaps/contract/list")
    Call<List<Contract>> getContractList();

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/swaps/market/kline")
    Call<List<KlineResponse>> getKline(@Query("productId") Long productId, @Query("type") Integer type, @Query("since") Long since);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/swaps/market/ticker")
    Call<List<TickerResponse>> getTickerList(@Query("productId") Long productId);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/swaps/market/depth")
    Call<List<DepthResponse>> getDepth(@Query("productId") long productId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/swaps/wallet/asset")
    Call<AssetResponse> getAsset(@Query("contractId") long contractId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/swaps/position/leverage/change")
    Call<JSONObject> changeLeverage(@Field("contractId") Long contractId, @Field("newLeverage") String newLeverage);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/swaps/order/place")
    Call<NewOrderResponse> newOrder(@Field("contractId") long contractId, @Field("type") Integer type,
                                    @Field("side") Integer side, @Field("size") Integer size,
                                    @Field("price") String price, @Field("close") Integer close);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/swaps/order/cancel")
    Call<JSONObject> cancelOrder(@Field("productId") long productId, @Field("orderId") long orderId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/swaps/order/batch/cancel")
    Call<JSONObject> cancelOrderBatch(@Field("productId") Long productId);

//    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
//    @POST("/v1/usdt/order/close/all")
//    Call<JSONObject> closeAll();

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/swaps/order/list")
    Call<List<OrderListResponse>> getOrderList(@Query("contractId") long contractId, @Query("orderId") Long orderId, @Query("status") String status,
                                               @Query("beginDate") String beginDate, @Query("endDate") String endDate,
                                               @Query("page") Integer page, @Query("pageSize") Integer pageSize);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/swaps/order/fill/list")
    Call<List<FillListResponse>> getOrderFillList(@Query("contractId") long contractId,
                                               @Query("beginDate") String beginDate, @Query("endDate") String endDate,
                                               @Query("page") Integer page, @Query("pageSize") Integer pageSize);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/swaps/order/place/planOrder")
    Call<JSONObject> placePlanOrder(@Field("contractId") long contractId, @Field("side") Integer side,
                                    @Field("triggerPrice") BigDecimal triggerPrice, @Field("size") Integer size,
                                    @Field("price") String price);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/swaps/position/get")
    Call<PositionResponse> getPositionList(@Query("contractId") long contractId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/swaps/order/plan/cancel")
    Call<JSONObject> cancelPlan(@Field("planOrderId") long planOrderId, @Field("contractId") long contractId);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/swaps/order/plan/batch/cancel")
    Call<JSONObject> cancelPlanBatch(@Field("contractId") Long contractId);

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/swaps/order/plan/list")
    Call<List<PlanListResponse>> getPlanList(@Query("contractId") long contractId, @Query("status") String status,
                                             @Query("beginDate") String beginDate, @Query("endDate") String endDate,
                                             @Query("page") Integer page, @Query("pageSize") Integer pageSize);


    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/swaps/ledger/list")
    Call<List<LedgerResponse>> getLedgerList(@Query("contractId") Long contractId, @Query("action") Integer action,
                                             @Query("startDate") String startDate, @Query("endDate") String endDate,
                                             @Query("curPage") Integer curPage, @Query("pageSize") Integer pageSize);

    @FormUrlEncoded
    @Headers(ApiConstants.ENDPOINT_HEADER_API_KEY)
    @POST("/v1/swaps/position/margin/add")
    Call<JSONObject> addPositionMargin(@Field("contractId") long contractId, @Field("addValue") BigDecimal addValue);
}