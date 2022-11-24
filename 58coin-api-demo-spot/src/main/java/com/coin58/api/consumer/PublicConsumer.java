package com.coin58.api.consumer;

import com.coin58.api.response.Coin58Resp;
import com.coin58.api.response.OrderBook;
import com.coin58.api.response.SpotTicker;
import com.coin58.api.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author coin58 - 2018/3/24.
 */
@Component("coin58-publicCon