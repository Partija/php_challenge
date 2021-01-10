
package com.coin58.api.common.impl;

import com.alibaba.fastjson.JSON;
import com.coin58.api.common.ConverterFactory;
import com.coin58.api.common.HttpStatusEnum;
import com.coin58.api.common.RestResult;
import com.coin58.api.common.constant.ApiConstants;
import com.coin58.api.common.exception.ApiException;
import com.coin58.api.common.security.AuthenticationInterceptor;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Generates a 58coin API implementation.
 */
public class ApiServiceGenerator {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = new ConverterFactory();

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder().dispatcher(dispatcher).pingInterval(20, TimeUnit.SECONDS).build();
    }

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, RestResult> errorBodyConverter = (Converter<ResponseBody, RestResult>) converterFactory.responseBodyConverter(RestResult.class, null,
            null);

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret) {

        return createService(serviceClass, apiKey, secret, ApiConstants.REST_API_BASE_URL);
    }


    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret, String restUrl){
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(restUrl).addConverterFactory(converterFactory);

        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }
    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();

            if (!response.isSuccessful()) {
                int code = response.code();
                RestResult restResult = JSON.parseObject(response.errorBody().string(), RestResult.class);
                if (restResult != null) {
                    throw new ApiException(restResult.getMessage());
                }

                throw new ApiException(HttpStatusEnum.of(code).getMessage());
            }

            RestResult restResult = (RestResult) response.body();
            if (restResult == null) {
                return null;
            }

            if (restResult.getCode() != 0) {
                throw new ApiException(restResult.getMessage());
            }

            return (T) restResult.getData();
        } catch (IOException e) {
            throw new ApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static RestResult getApiError(Response<?> response) throws IOException, ApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}