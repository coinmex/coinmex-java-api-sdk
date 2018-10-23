package com.coinmex.dax.sdk.openapi.ws.domain;

import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Order;
import lombok.Data;

/**
 * @author newex-team
 * @date 2018/6/12
 */
@Data
public class OrdersInfo extends ParamRequest {
    /**
     * order
     */
    private Order data;
}
