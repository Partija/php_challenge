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
 * 58coin's REST API URL mappings and end