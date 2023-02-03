package com.coin58.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
 * "symbol": "LTC_BTC",
 * // The timestamp at which this information was valid
 * "time": 1512744759000,
 * // Current best bid price
 * "bid": "0.019983",
 * // Current best ask price
 * "ask": "0.019984",
 * // The price at which the last trade executed
 * "last": "0.019984",
 * "change": "4.02",
 * // Open price of the last 24 hours
 * "open": "0.019223",
 * // High