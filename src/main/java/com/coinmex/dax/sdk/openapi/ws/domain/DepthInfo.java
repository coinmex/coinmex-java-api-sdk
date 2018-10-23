package com.coinmex.dax.sdk.openapi.ws.domain;

import com.coinmex.dax.sdk.openapi.spot.publics.domain.OrderBook;
import lombok.Data;

/**
 * @author newex-team
 * @date 2018/6/12
 */
@Data
public class DepthInfo extends ParamRequest {

    /**
     * data
     */
    private OrderBook data;
}
