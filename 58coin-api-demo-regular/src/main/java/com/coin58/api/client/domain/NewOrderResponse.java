package com.coin58.api.client.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewOrderResponse implements Serializable {

    private String orderId;

    @Override
    public String toString() {
        return "NewOrder{" + "orderId='" + orderId + '\'' + '}';
    }
}