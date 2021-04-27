package com.coin58.future.api.examplesPublic;

import com.coin58.api.future.client.ApiClientFactory;
import com.coin58.api.future.client.ApiRestClient;
import com.coin58.api.future.client.domain.Contract;

import java.util.List;

/**
 * @author guozhengMu
 * @version 1.0
 * @date 2019/3/12 19:54
 * @description Term contract-contract-contract list
 * @modify
 */
public class ContractsExample {

    public static void main(String[] args) {

        ApiClientFactory factory = ApiClientFactory.newInstance();
        ApiRestClient client = factory.newRestClient();

        List<Contract> contracts = client.getContractList();

        contracts.forEach(contract -> {
            System.out.println(contract);
        });
    }
}
