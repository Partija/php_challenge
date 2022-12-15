package com.coin58.api.core;

import com.coin58.api.constant.SymbolConstants;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coin58 - 2018/3/26.
 */
public class QueryString {
    private StringBuilder sb;
    private List<NameValuePair> queryStringList;

    public QueryString() {
        this.queryStringList = new ArrayList<>();
    }

    public static QueryString builder() {
        QueryString qs = new QueryString();
        qs.sb = new StringBuilder();
        return qs;
    }

    public QueryString query(String name, Object value) {
        this.queryStringList.add(new NameObjectPair(name, value));
        return this;
    }

    public Li