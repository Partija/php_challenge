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
import jav