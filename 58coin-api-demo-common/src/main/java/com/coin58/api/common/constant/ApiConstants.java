package com.coin58.api.common.constant;

/**
 * Constants used throughout 58coin's API.
 */
public interface ApiConstants {

    /**
     * REST API base URL.
     */
    String REST_API_BASE_URL = "https://openapi.58ex.com";
//    String REST_API_BASE_URL = "http://192.168.112.23:9994";

    /**
     * Streaming API base URL.
     */
    String WS_API_BASE_URL = "wss://openws.58ex.com/v1/stream";
//    String WS_API_BASE_URL = "ws://192.168.112.23:9994/v1/stream";

    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    String HEADER_API_KEY = "X-58COIN-APIKEY";
    String ENDPOINT_HEADER_API_KEY = HEADER_API_KEY + ": #";

    String HEADER_CONTENT_TYPE_JSON = "Content-Type: application/json";

    String HEADER_TIMESTAMP = "Timestamp";
    String HEADER_SIGNATURE = "Signature";

    // 常量
    String ACCESS_KEY_ID = 