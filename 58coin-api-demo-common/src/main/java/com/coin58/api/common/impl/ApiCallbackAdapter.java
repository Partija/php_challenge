package com.coin58.api.common.impl;

import com.coin58.api.common.ApiCallback;
import com.coin58.api.common.RestResult;
import com.coin58.api.common.exception.ApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

/**
 * An adapter/wrapper which transforms a Callback from Retrofit into a ApiCallback which is exposed to the client.
 */
public class ApiCallbackAdapter<T> implements Callback<T> {

    private final ApiCallback<T> callback;

    public ApiCallbackAdapter(ApiCallback<T> callback) {
        this.callback = callback;
    }

    public void onResponse(Call<T> call, Response<