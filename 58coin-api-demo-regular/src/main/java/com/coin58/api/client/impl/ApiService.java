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

    @Heade