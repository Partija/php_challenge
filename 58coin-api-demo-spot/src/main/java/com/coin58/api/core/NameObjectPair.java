package com.coin58.api.core;

import lombok.Data;
import org.apache.http.NameValuePair;

import java.math.BigDecimal;

/**
 * @author coin58
 * @date 2017/7/16.
 */
@Data
public class NameObjectPair implements NameValuePair {

    private String name;
    private Object value;

    public NameObjectPair(String name, Object value) {
        