package com.coin58.api.common;


import com.coin58.api.common.event.SubMessage;
import okhttp3.WebSocket;

/**
 * ApiCallback is a functional interface used together with the ApiAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return ty