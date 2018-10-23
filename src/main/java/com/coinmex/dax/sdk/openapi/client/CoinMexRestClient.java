package com.coinmex.dax.sdk.openapi.client;

import com.coinmex.dax.sdk.openapi.common.domain.ClientParameter;
import com.coinmex.dax.sdk.openapi.common.enums.Content;
import com.coinmex.dax.sdk.openapi.common.enums.SupportedLocaleEnum;
import com.coinmex.dax.sdk.openapi.spot.SpotApiFacade;
import com.coinmex.dax.sdk.openapi.wallet.WalletApiFacade;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * coinmex exchange rest open api Client
 *
 * @author coinmex-sdk-team
 * @date 2018/04/28
 */
public class CoinMexRestClient {
    private final ApiClient apiClient;
    private final ClientParameter configuration;

    private CoinMexRestClient(final Builder builder) {
        this.configuration = builder.configuration;
        Validate.notNull(this.configuration, "configuration is null");
        Validate.notNull(this.configuration.getApiKey(), "apiKey is null");
        Validate.notNull(this.configuration.getSecretKey(), "secretKey is null");
        Validate.notNull(this.configuration.getPassphrase(), "passphrase is null");

        this.configuration.setBaseUrl(StringUtils.defaultIfBlank(this.configuration.getBaseUrl(), Content.BASE_URL));
        this.configuration.setTimeout(ObjectUtils.defaultIfNull(this.configuration.getTimeout(), Content.TIME_OUT));
        this.configuration.setLocale(ObjectUtils.defaultIfNull(this.configuration.getLocale(), SupportedLocaleEnum.EN_US.getName()));

        this.apiClient = new ApiClient(this.configuration);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * 现货 REST API Endpoint
     *
     * @return SpotApiFacade
     */
    public SpotApiFacade spot() {
        return new SpotApiFacade(this.apiClient);
    }

    /**
     * 现货 REST API Endpoint
     *
     * @return WalletApiFacade
     */
    public WalletApiFacade wallet() {
        return new WalletApiFacade(this.apiClient);
    }


    public static class Builder {
        private ClientParameter configuration;

        public Builder configuration(final ClientParameter value) {
            this.configuration = value;
            return this;
        }

        public CoinMexRestClient build() {
            return new CoinMexRestClient(this);
        }
    }
}
