package com.coinmex.dax.sdk.openapi.spot.ccex;

import com.alibaba.fastjson.JSONObject;
import com.coinmex.dax.sdk.openapi.client.CoinMexRestClient;
import com.coinmex.dax.sdk.openapi.common.domain.Record;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Account;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Ledger;
import com.coinmex.dax.sdk.openapi.spot.common.BaseTest;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author coinmex-sdk-team
 * @date 2018/04/28
 */
public class AccountServiceTest extends BaseTest {

    @Test
    public void testAssets() throws IOException {
        final List<Account> accounts = this.coinmexClient.spot().ccex().account()
                .assets();
        System.out.println(accounts);
    }

    @Test
    public void testLedger() throws IOException {
        final String currency = "BTC";
        final Record<List<Ledger>, Long> accounts = this.coinmexClient.spot().ccex().account()
                .ledger(currency, null, null, 100);
        System.out.println(accounts);
    }

    @Test
    public void testWithdrawal() throws IOException {
        final String address = "15699188603";
        final String currency = "BTC";
        final BigDecimal amount = new BigDecimal("2.0181");
        final JSONObject object = this.coinmexClient.spot().ccex().account()
                .withdrawal(address, currency, amount);
        System.out.println(object);
    }

    public void testExample() throws IOException {
        final CoinMexRestClient coinmexClient = CoinMexRestClient.builder()
                .configuration(this.parameter)
                .build();

        coinmexClient.spot()
                .ccex()
                .order().postOrder(null);

        coinmexClient.spot()
                .ccex()
                .account().assets();

        coinmexClient.spot()
                .publics()
                .ticker("BTC");

        coinmexClient.spot()
                .margin();
    }
}
