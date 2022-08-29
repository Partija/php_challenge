
package com.coin58.api.webSocketExamples;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.coin58.api.common.ApiCallback;
import com.coin58.api.client.ApiClientFactory;
import com.coin58.api.common.ApiSocketClient;
import com.coin58.api.common.enums.KlineIntervalEnum;
import com.coin58.api.common.event.*;
import com.coin58.api.common.util.ZipUtil;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SocketExample {

    @Test
    public void subTicker() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        ApiSocketClient socketClient = ApiClientFactory.newInstance().newWebSocketClient();
        socketClient.onTickerEvent("etc_usdt", new ApiCallback<TickerEvent>() {
            @Override
            public void onConnected(SubMessage message) {
                //                System.out.println("message = [" + JSON.toJSONString(message) + "]");
                System.out.println(format(message));
            }

            @Override
            public void onResponse(TickerEvent response) {
                //                System.out.println("response = [" + JSON.toJSONString(response) + "]");
                System.out.println(format(response));
            }

            @Override
            public void onFailure(Throwable cause) {
                if (cause != null) {
                    cause.printStackTrace();
                }

                latch.countDown();
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                System.out.println("webSocket = [" + webSocket + "], code = [" + code + "], reason = [" + reason + "]");
                latch.countDown();

            }

            @Override
            public void onClosed(int code, String reason) {
                System.out.println("code = [" + code + "], reason = [" + reason + "]");
                latch.countDown();

            }