package com.coin58.api.util;

import com.coin58.api.constant.Constants;
import com.coin58.api.constant.SymbolConstants;
import com.coin58.api.core.NameObjectPair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.http.NameValuePair;
import org.springframework.util.Base64Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author coin58
 * @date 2017/5/5
 */
@Slf4j
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static byte[] buildSignSHA256Hex(List<NameValuePair> params, String secretKey, String timestamp) {
        params.sort(Comparator.comparing(NameValuePair::getName));
        params.add(new NameObjectPair(Constants.API_SECRET, secretKey));
        params.add(new NameObjectPair(Constants.TIMESTAMP, timestamp));
        String stringForSign = buildStringForSign(params, secretKey);
        return HmacUtils.getHmacSha256(secretKey.getBytes()).doFinal(stringForSign.getBytes());
    }

    public static String base64Sha256Hex(List<NameValuePair> params, String secretKey, String timestamp) {
        return Base64Utils.encodeToString(new String(Hex.encodeHex(buildSignSHA256Hex(params, secretKey, timestamp), false)).getBytes());
    }

    /**
     * 生成用于加密的字符串
     *
     * @param params    请求参数
     * @param secretKey key
     * @return 用于加密的字符串
     */
    private static String buildStringForSign(List<NameValuePair> params, String secretKey) {
        StringBuilder res = new StringBuilder();
        List<String> paramsList = new ArrayList<>();
        for (NameValuePair pair : params) {
            paramsList.add(pair.getName() + SymbolConstants.EQUALS_SIGN + pair.getValue());
        }
        res.append(join(paramsList, SymbolConstants.AMPERSAND));
        return res.toString();
    }

    public static String buildQueryString(List<NameValuePair> params) {
        StringBuilder queryString = new StringBuilder(SymbolConstants.QUESTION_MARK);
        List<String> paramsList = new ArrayList<>();
        params.forEach(x -> paramsList.add(x.getName() + SymbolConstants.EQUALS_SIGN + x.getValue()));
        return queryString.append(StringUtils.join(paramsList, SymbolConstants.AMPERSAND))
 