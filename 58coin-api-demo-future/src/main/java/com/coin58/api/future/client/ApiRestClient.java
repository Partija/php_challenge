package com.coin58.api.future.client;

import com.alibaba.fastjson.JSONObject;
import com.coin58.api.future.client.domain.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 58coin API façade, supporting synchronous/blocking access 58coin's REST API.
 */
public interface ApiRestClient {

    JSONObject transfer(String