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
    @PO