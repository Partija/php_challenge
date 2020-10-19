
package com.coin58.api.common;

import com.coin58.api.common.enums.KlineIntervalEnum;
import com.coin58.api.common.event.DepthEvent;
import com.coin58.api.common.event.KlineEvent;
import com.coin58.api.common.event.OrderUpdateEvent;
import com.coin58.api.common.event.TickerEvent;
import com.coin58.api.common.ApiCallback;
import okhttp3.WebSocketListener;

import java.io.Closeable;

/**
 * 58coin API data streaming façade, supporting streaming of events through web sockets.
 */
public interface ApiSocketClient {

    /**
     * Open a new web socket to receive {@link DepthEvent depthEvents} on a callback.
     *
     * @param products market product(s) number (one or coma-separated) to subscribe to
     * @param callback the callback to call on new events