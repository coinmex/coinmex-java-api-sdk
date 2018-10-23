package com.coinmex.dax.sdk.openapi.wallet;

import com.coinmex.dax.sdk.openapi.client.ApiClient;
import com.coinmex.dax.sdk.openapi.spot.SpotApiFacade;
import com.coinmex.dax.sdk.openapi.spot.ccex.service.AccountService;
import com.coinmex.dax.sdk.openapi.spot.ccex.service.OrderService;
import com.coinmex.dax.sdk.openapi.spot.ccex.service.impl.AccountServiceImpl;
import com.coinmex.dax.sdk.openapi.spot.ccex.service.impl.OrderServiceImpl;
import com.coinmex.dax.sdk.openapi.wallet.service.WalletService;
import com.coinmex.dax.sdk.openapi.wallet.service.impl.WalletServiceImpl;

/**
 * @author newex-team
 * @data 2018/7/25
 */
public class WalletApiFacade {
    private final ApiClient apiClient;

    public WalletApiFacade(final ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public WalletService wallet() {
        return new WalletEndpoint(this.apiClient).wallet();
    }


    public static class WalletEndpoint {
        private final ApiClient apiClient;

        public WalletEndpoint(final ApiClient apiClient) {
            this.apiClient = apiClient;
        }


        public WalletService wallet() {
            return new WalletServiceImpl(this.apiClient);
        }

    }
}
