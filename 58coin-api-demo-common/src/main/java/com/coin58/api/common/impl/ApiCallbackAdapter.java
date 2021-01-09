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

    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {

            RestResult restResult = (RestResult) response.body();

            if (restResult.getCode() != 0) {
                onFailure(call, new ApiException(restResult.getMessage()));
                return;
            }

            callback.onResponse((T) restResult.getData());
        } else {
            if (response.code() == 504) {
                // HTTP 504 return code is used when the API successfully sent the message but not get a response within the timeout period.
                // It is important to NOT treat this as a failure; the execution status is UNKNOWN and could have been a success.
                return;
            }

            try {
                RestResult apiError = ApiServiceGenerator.getApiError(response);
                onFailure(call, new ApiException(apiError.getMessage()));
            } catch (IOException e) {
                onFailure(call, new ApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable instanceof ApiException) {
            callback.onFailure(throwable);
        } else {
            callback.onFailure(new ApiException(throwable));
        }
    }
}
