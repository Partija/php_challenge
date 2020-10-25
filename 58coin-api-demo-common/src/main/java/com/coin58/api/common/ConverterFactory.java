package com.coin58.api.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ConverterFactory extends retrofit2.Converter.Factory {

    @Override
    public retrofit2.Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new Converter(type);
    }
}

@Slf4j
class Converter<T> implements retrofit2.Converter<ResponseBody, T> {

    private Type type;

    public Converter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        RestResult restResult = null;
        try{
            restResult = JSO