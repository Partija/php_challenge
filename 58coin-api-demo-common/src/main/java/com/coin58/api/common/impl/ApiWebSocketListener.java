
package com.coin58.api.common.impl;

import com.alibaba.fastjson.JSON;
import com.coin58.api.common.ApiCallback;
import com.coin58.api.common.util.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.coin58.api.common.event.SubMessage;

@Slf4j
public class ApiWebSocketListener<T> extends WebSocketListener {

    private ApiCallback<T> callback;

    private Class<T> eventClass;

//    private volatile boolean closing = false;

    public ApiWebSocketListener(ApiCallback callback, Class eventClass) {

        this.callback = callback;

        this.eventClass = eventClass;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
//        ping(webSocket);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        SubMessage message = JSON.parseObject(text, SubMessage.class);
        callback.onConnected(message);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        try {
            String content = ZipUtil.uncompress(bytes.toByteArray());
            if (StringUtils.isBlank(content)) return;


            if(content.contains("ping")){
                SubMessage subMessage = JSON.parseObject(content, SubMessage.class);
                if("ping".equalsIgnoreCase(subMessage.getEvent())){
                    webSocket.send("{\"event\":\"pong\",\"ts\":" + subMessage.getTs() + "}");
                    return;
                }
            }
            T obj = JSON.parseObject(content, eventClass);
            callback.onResponse(obj);
        } catch (Exception e) {
            log.error("Content decompression exception", e);
        }
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
//        if (!closing) {
            callback.onFailure(t);
//        }
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
//        closing = true;
        callback.onClosing(webSocket, code, reason);
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        callback.onClosed(code, reason);
    }

    /**
     * heartbeat
     */
    private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

//    public void ping(WebSocket socket) {
//        scheduledThreadPool.scheduleAtFixedRate(() -> {
//            socket.send("{\"event\":\"ping\"}");
//        }, 30, 60, TimeUnit.SECONDS);
//    }
}