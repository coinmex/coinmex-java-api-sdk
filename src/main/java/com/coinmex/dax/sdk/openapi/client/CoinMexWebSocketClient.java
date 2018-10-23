package com.coinmex.dax.sdk.openapi.client;

import com.coinmex.dax.sdk.openapi.ws.WebSocketFactory;
import com.coinmex.dax.sdk.openapi.ws.domain.WebSocketRequest;
import org.apache.commons.lang3.Validate;

/**
 * @author newex-team
 * @date 2018/6/11
 */
public class CoinMexWebSocketClient {

    private final WebSocketRequest webSocketRequest;

    public CoinMexWebSocketClient(final Builder builder) {

        this.webSocketRequest = builder.webSocketRequest;
        Validate.notNull(this.webSocketRequest, "webSocketRequest is null");
        Validate.notNull(this.webSocketRequest.getEvent(), "event is null");
    }

    public WebSocketFactory spot() {
        return new WebSocketFactory();
    }

    public static CoinMexWebSocketClient.Builder builder() {
        return new CoinMexWebSocketClient.Builder();
    }

    public static class Builder {
        private WebSocketRequest webSocketRequest;

        public CoinMexWebSocketClient.Builder configuration(final WebSocketRequest value) {
            this.webSocketRequest = value;
            return this;
        }

        public CoinMexWebSocketClient build() {
            return new CoinMexWebSocketClient(this);
        }
    }
}
