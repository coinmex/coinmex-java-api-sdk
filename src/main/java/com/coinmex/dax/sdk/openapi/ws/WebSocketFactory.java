package com.coinmex.dax.sdk.openapi.ws;

import com.coinmex.dax.sdk.openapi.ws.impl.SpotWebSocketClientImpl;

/**
 * @author newex-team
 * @date 2018/6/11
 */
public class WebSocketFactory {

    public static SpotWebSocketClient newWebSocketClient() {
        return new SpotWebSocketClientImpl();
    }

}
