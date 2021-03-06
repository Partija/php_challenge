package com.coin58.api.future.client.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewOrderResponse implements Serializable {

    private Long orderId;

    @Override
    public String toString() {
        return "NewOrder{" + "orderId='" + orderId + '\'' + '}';
    }
}