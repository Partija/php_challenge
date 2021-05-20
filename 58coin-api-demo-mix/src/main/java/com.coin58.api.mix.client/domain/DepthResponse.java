
package com.coin58.api.mix.client.domain;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * @author lhc
 * @version 1.0
 * @description
 * @modify
 */
@Data
public class DepthResponse {
    private JSONArray bids;
    private JSONArray asks;

    @Override
    public String toString() {
        return "Depth{" +
                "bids=" + bids +
                ",asks=" + asks +
                "}";
    }
}