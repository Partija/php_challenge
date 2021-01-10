
package com.coin58.api.common.impl;

import com.coin58.api.common.ApiCallback;
import com.coin58.api.common.ApiSocketClient;
import com.coin58.api.common.constant.ApiConstants;
import com.coin58.api.common.enums.KlineIntervalEnum;
import com.coin58.api.common.event.DepthEvent;
import com.coin58.api.common.event.KlineEvent;
import com.coin58.api.common.event.OrderUpdateEvent;
import com.coin58.api.common.event.TickerEvent;
import com.coin58.api.common.security.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.Closeable;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApiSocketClientImpl implements ApiSocketClient {

    private static final String COMA = ",";

    private OkHttpClient client;

    private String apiKey;

    private String secret;

    private String socketUrl = ApiConstants.WS_API_BASE_URL;

//    public ApiSocketClientImpl(OkHttpClient client){