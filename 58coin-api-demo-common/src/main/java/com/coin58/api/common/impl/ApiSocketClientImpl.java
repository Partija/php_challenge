
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
//        this.client = client;
//    }

    public ApiSocketClientImpl(String apiKey, String secret, OkHttpClient client) {

        this.client = client;
        this.apiKey = apiKey;
        this.secret = secret;
    }

    public ApiSocketClientImpl(String apiKey, String secret, OkHttpClient client, String socketUrl) {

        this.client = client;
        this.apiKey = apiKey;
        this.secret = secret;

        this.socketUrl = socketUrl;
    }

    @Override
    public Closeable onDepthEvent(String products, ApiCallback<DepthEvent> callback) {
        String channel = Stream.of(products.split(COMA))
                .map(product -> String.format("%s@depth", product))
                .collect(Collectors.joining("/"));

        return createWebSocket(channel, new ApiWebSocketListener(callback, DepthEvent.class));
    }

    @Override
    public Closeable onKlineEvent(String products, KlineIntervalEnum interval, ApiCallback<KlineEvent> callback) {
        String channel = Stream.of(products.split(COMA))
                .map(product -> String.format("%s@kline_%s", product, interval.getIntervalId()))
                .collect(Collectors.joining("/"));

        return createWebSocket(channel, new ApiWebSocketListener(callback, KlineEvent.class));
    }

    @Override
    public Closeable onTickerEvent(String products, ApiCallback<TickerEvent> callback) {
        String channel = Stream.of(products.split(COMA))
                .map(product -> String.format("%s@ticker", product))
                .collect(Collectors.joining("/"));
        return createWebSocket(channel, new ApiWebSocketListener(callback, TickerEvent.class));
    }

    @Override
    public Closeable onOrderUpdateEvent(String businesses, ApiCallback<OrderUpdateEvent> callback) {
        String channel = Stream.of(businesses.split(COMA))
                .map(business -> String.format("%s@order", business))
                .collect(Collectors.joining("/"));


        return createWebSocket(channel, new ApiWebSocketListener(callback, OrderUpdateEvent.class));
    }


    public Closeable createWebSocket(String channel, WebSocketListener webSocketListener) {
        String streamingUrl = String.format("%s?streams=%s", socketUrl, channel);

        Request.Builder builder = new Request.Builder()
                .url(streamingUrl);

        if (!Objects.isNull(apiKey) && !Objects.isNull(secret)) {
            builder.addHeader(ApiConstants.HEADER_API_KEY, apiKey);
            client = client.newBuilder()
                    .addInterceptor(new AuthenticationInterceptor(apiKey, secret)).build();
        }
        builder.addHeader("Content-Type", "application/json");
        Request request = builder.build();
        WebSocket socket = client.newWebSocket(request, webSocketListener);

        return () -> {
            //the normal closure
            int code = 1000;
            webSocketListener.onClosing(socket, code, null);
            socket.close(code, null);
            webSocketListener.onClosed(socket, code, null);
        };
    }
}