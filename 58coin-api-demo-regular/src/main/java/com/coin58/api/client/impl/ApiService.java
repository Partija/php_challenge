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
    Call<JSONObject> transfer(@Field("currencyName") String currencyName, @Field