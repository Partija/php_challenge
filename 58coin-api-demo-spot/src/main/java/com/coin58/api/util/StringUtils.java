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
public class S