package com.coinmex.dax.sdk.openapi.ws.domain;

import com.coinmex.dax.sdk.openapi.common.enums.EventEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author newex-team
 * @date 2018/6/11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebSocketRequest {

    /**
     * event type, support: signin,subscribe,unsubscribe
     */
    private EventEnum event;

    /**
     * websocket url
     */
    private String wsBaseUrl;

    /**
     * params
     */
    private ParamRequest params;

}
