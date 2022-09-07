
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
        });

        latch.await();
    }

    @Test
    public void subDepth() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        ApiSocketClient socketClient = ApiClientFactory.newInstance().newWebSocketClient();
        socketClient.onDepthEvent("2001", new ApiCallback<DepthEvent>() {
            @Override
            public void onConnected(SubMessage message) {
                //                System.out.println("message = [" + JSON.toJSONString(message) + "]");
                System.out.println(format(message));
            }

            @Override
            public void onResponse(DepthEvent response) {
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
            public void onClosed(int code, String reason) {
                //                System.out.println("code = [" + code + "], reason = [" + reason + "]");
                System.out.println(format(reason));
            }
        });

        latch.await();
    }

    @Test
    public void subKline() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        ApiSocketClient socketClient = ApiClientFactory.newInstance().newWebSocketClient();
        socketClient.onKlineEvent("2001", KlineIntervalEnum.FIVE_MINUTES, new ApiCallback<KlineEvent>() {
            @Override
            public void onConnected(SubMessage message) {
                //                System.out.println("message = [" + JSON.toJSONString(message) + "]");
                System.out.println(format(message));
            }

            @Override
            public void onResponse(KlineEvent response) {
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
            public void onClosed(int code, String reason) {
                System.out.println("code = [" + code + "], reason = [" + reason + "]");
            }
        });

        latch.await();
    }

    private String format(Object object) {
        return JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    @Test
    public void subOrder() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        String apiKey = "6616146f-6fe6-447c-bd31-c346437f201b";
        String apiSecret = "E4199FA0CD19F4996A3D78E226ACAF2D";
        ApiClientFactory.newInstance(apiKey, apiSecret).newWebSocketClient().onOrderUpdateEvent("regular", new ApiCallback<OrderUpdateEvent>() {
            @Override
            public void onConnected(SubMessage message) {
                //                System.out.println("message = [" + JSON.toJSONString(message) + "]");
                System.out.println(format(message));
            }

            @Override
            public void onResponse(OrderUpdateEvent response) {
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
            public void onClosed(int code, String reason) {
                System.out.println("code = [" + code + "], reason = [" + reason + "]");
            }
        });

        latch.await();
    }

    @Test
    public void subTickers() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        String products = "2001,2002,2003";
        ApiSocketClient socketClient = ApiClientFactory.newInstance().newWebSocketClient();
        socketClient.onTickerEvent(products, new ApiCallback<TickerEvent>() {
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
            public void onClosed(int code, String reason) {
                System.out.println("code = [" + code + "], reason = [" + reason + "]");
            }
        });

        latch.await();
    }

    @Test
    public void subMixedData() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);

        String depthChannel = Stream.of("2001", "2002").map(product -> product.concat("@depth")).collect(Collectors.joining("/"));

        String klineChannel = Stream.of("2001", "2003").map(product -> product.concat("@kline_").concat(KlineIntervalEnum.ONE_MINUTE.getIntervalId())).collect(Collectors.joining("/"));

        String channels = depthChannel.concat("/").concat(klineChannel);

        //        channels = channels.concat("/").concat("regular@order");
        //
        //        String apiKey = "6616146f-6fe6-447c-bd31-c346437f201b";
        //        String secret = "E4199FA0CD19F4996A3D78E226ACAF2D";
        ApiClientFactory.newInstance()
                //        ApiClientFactory.newInstance(apiKey, secret)
                .newWebSocketClient().createWebSocket(channels, new WebSocketListener() {
            @Override
            public void onMessage(WebSocket webSocket, String text) {
                System.out.println("webSocket = [" + webSocket + "], text = [" + format(text) + "]");
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                try {
                    System.out.println("webSocket = [" + webSocket + "], bytes = [" + format(ZipUtil.uncompress(bytes.toByteArray())) + "]");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                System.out.println("webSocket = [" + webSocket + "], t = [" + t + "], response = [" + response + "]");
                latch.countDown();
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                System.out.println("webSocket = [" + webSocket + "], code = [" + code + "], reason = [" + reason + "]");
            }

        });

        latch.await();

    }
}