package com.coin58.api.mix.client.impl;

import com.coin58.api.common.constant.ApiConstants;
import com.coin58.api.mix.client.domain.Contract;
import com.coin58.api.mix.client.domain.KlineResponse;
import com.coin58.api.mix.client.domain.TickerResponse;
import com.coin58.api.mix.client.domain.TradeResponse;
import com.coin58.api.mix.client.domain.DepthResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * 58coin's REST API URL mappings and endpoint security configuration.
 */
public interface ApiService {

    @Headers({ApiConstants.HEADER_CONTENT_TYPE_JSON, ApiConstants.ENDPOINT_HEADER_API_KEY})
    @GET("/v1/mix/market/trades")
    Call<List<TradeResponse>> getTrades(@Query("contractId") Long contractId);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/mix/contract/list")
    Call<List<Contract>> getContractList();

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/mix/market/kline")
    Call<List<KlineResponse>> getKline(@Query("contractId") Long contractId, @Query("type") Integer type, @Query("since") Long since);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/mix/market/ticker")
    Call<TickerResponse> getTickerList(@Query("contractId") long contraceId);

    @Headers(ApiConstants.HEADER_CONTENT_TYPE_JSON)
    @GET("/v1/mix/market/depth")
    Call<DepthResponse> getDepth(@Query("contractId") long contractId);


}