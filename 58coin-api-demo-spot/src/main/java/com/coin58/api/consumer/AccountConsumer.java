package com.coin58.api.consumer;

import com.coin58.api.response.Account;
import com.coin58.api.response.Coin58Resp;
import com.coin58.api.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Response;
import org.springframework.stereotype.Component;

import java.io.IO