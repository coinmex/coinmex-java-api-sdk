package com.coinmex.dax.sdk.openapi.ws.domain;

import lombok.Data;

/**
 * @author newex-team
 * @date 2018/6/12
 */
@Data
public class TickersInfo extends ParamRequest {

    /**
     * data
     */
    private Object[] data;

}
