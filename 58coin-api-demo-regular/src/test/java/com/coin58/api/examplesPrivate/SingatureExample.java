package com.coin58.api.examplesPrivate;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.coin58.api.common.security.SignatureUtil.createSignature;

public class SingatureExample {

    private final String apiKey = "089cf604-7b87-4b13-b806-eaadb67c8b70";
    private final String apiSecret = "CE5DB7F718510CF47D73AF75D3CDF3B6";

    @Test
    public void createSingature() {
        String timestamp = "1551084749915";

        Map<String, String> params = new HashMap<>();
        params.put("contractId", "2001");
        params.put("type", "2");
        params.put("side", "1");
        params.put("size", "1");

        String signature = createSignature(apiKey, apiSecret, timestamp, params);
    }

}
