
package com.coin58.api.client;

import com.coin58.api.client.domain.Contract;
import com.coin58.api.client.domain.NewOrder;
import com.coin58.api.client.domain.NewOrderResponse;
import com.coin58.api.common.ApiCallback;

import java.util.List;

/**
 * 58coin API façade, supporting asynchronous/non-blocking access 58coin's REST API.
 */
public interface ApiAsyncRestClient {

    // General endpoints

    void getContractList(ApiCallback<List<Contract>> callback);

    /**
     * Send in a new order (asynchronous)
     *
     * @param order    the new order to submit.
     * @param callback the callback that handles the response
     */
    void newOrder(NewOrder order, ApiCallback<NewOrderResponse> callback);
}