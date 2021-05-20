package com.coin58.api.mix.client;

import com.coin58.api.mix.client.domain.Contract;
import com.coin58.api.mix.client.domain.KlineResponse;
import com.coin58.api.mix.client.domain.TickerResponse;
import com.coin58.api.mix.client.domain.TradeResponse;
import com.coin58.api.mix.client.domain.DepthResponse;


import java.util.List;

/**
 * 58coin API façade, supporting synchronous/blocking access 58coin's REST API.
 */
public interface ApiRestClient {

    List<TradeResponse> getTrades(long contraceId);

    List<Contract> getContractList();

    List<KlineResponse> getKline(Long contractId, Integer type, Long since);

    TickerResponse getTicker(long contractId);

    DepthResponse getDepth(Long contractId);

}