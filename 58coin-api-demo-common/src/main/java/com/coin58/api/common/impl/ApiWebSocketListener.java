
package com.coin58.api.common.impl;

import com.alibaba.fastjson.JSON;
import com.coin58.api.common.ApiCallback;
import com.coin58.api.common.util.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.apache.commons.lang3.StringUtils;