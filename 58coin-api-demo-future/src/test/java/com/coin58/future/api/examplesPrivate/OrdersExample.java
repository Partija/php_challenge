
package com.coin58.future.api.examplesPrivate;

import com.coin58.api.common.enums.CloseTypeEnum;
import com.coin58.api.common.enums.OrderTypeEnum;
import com.coin58.api.common.enums.SideEnum;
import com.coin58.api.future.client.ApiClientFactory;
import com.coin58.api.future.client.ApiRestClient;
import com.coin58.api.future.client.domain.NewOrder;
import com.coin58.api.future.client.domain.NewOrderResponse;

import java.math.BigDecimal;
/**
 * @author guozhengMu
 * @version 1.0
 * @date 2019/3/13 16:19
 * @description Term contract - transaction - order
 * @modify
 */

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
public class OrdersExample {

    public static void main(String[] args) {
        String apiKey = "6616146f-6fe6-447c-bd31-c346437f201b";
        String apiSecret = "E4199FA0CD19F4996A3D78E226ACAF2D";

        ApiClientFactory factory = ApiClientFactory.newInstance(apiKey, apiSecret);
        ApiRestClient client = factory.newRestClient();

        NewOrder order = new NewOrder();
        order.setContractId(2002L);
        order.setOrderType(OrderTypeEnum.LIMIT);
        order.setSide(SideEnum.BUY);
        order.setLeverage(10);
        order.setSize(10);
        order.setPrice(new BigDecimal("3.325"));
        order.setCloseType(CloseTypeEnum.OPEN);

        // Placing a real LIMIT order
        NewOrderResponse newOrderResponse = client.newOrder(order);
        System.out.println(newOrderResponse);
    }
}