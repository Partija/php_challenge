
package com.coin58.api.common.event;

import lombok.Data;

@Data
public class KlineEvent {

    private String type;
    private String product;
    private String business;
    private KlineDto data;

    @Data
    public static class KlineDto {