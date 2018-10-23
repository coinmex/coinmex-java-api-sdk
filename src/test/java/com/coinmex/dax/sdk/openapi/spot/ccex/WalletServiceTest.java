package com.coinmex.dax.sdk.openapi.spot.ccex;

import com.alibaba.fastjson.JSONObject;
import com.coinmex.dax.sdk.openapi.client.CoinMexRestClient;
import com.coinmex.dax.sdk.openapi.common.domain.Record;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Account;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Ledger;
import com.coinmex.dax.sdk.openapi.spot.common.BaseTest;
import com.coinmex.dax.sdk.openapi.wallet.domain.*;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author coinmex-sdk-team
 * @date 2018/04/28
 */
public class WalletServiceTest extends BaseTest {

    @Test
    public void testDepositAddress() throws IOException {
        final DepositAddress address = this.coinmexClient.wallet().wallet().generateDepositAddress("btc");
        System.out.println(address);
    }

    @Test
    public void testGetDepositRecord() throws IOException {
        final String currency = "BTC";
        final Page<DepositRecord> records = this.coinmexClient.wallet().wallet().getDepositRecord("btc",
                "1JrBWZ9NJZUazNzZuc44KSU8eswYSUKryy1",1 , 3);
        System.out.println(records);
    }

    @Test
    public void testGetWithdrawRecord() throws IOException {
        final String currency = "BTC";
        final Page<WithdrawRecord> records = this.coinmexClient.wallet().wallet().getWithdrawRecord("btc",
                "1JrBWZ9NJZUazNzZuc44KSU8eswYSUKryy1",1 , 3);
        System.out.println(records);
    }

    @Test
    public void testGetWithdrawInfo() throws IOException {
        final String currency = "BTC";
        final WithdrawInfo withdrawInfo = this.coinmexClient.wallet().wallet().getWithdrawInfo("btc");
        System.out.println(withdrawInfo);
    }

    @Test
    public void testWithdrawal() throws IOException {
        final String address = "2MxG55ZSi9stA7YCba2yyb31ntEBnYEcYQV";
        final String currency = "BTC";
        final BigDecimal amount = new BigDecimal("2.0181");
        final WithdrawRecord object = this.coinmexClient.wallet().wallet().withdraw(currency, address,amount,"1fa3eef8-8e38-47db-8b5f-60b42f202ad51535533656371");
        System.out.println(object);
    }


    @Test
    public void testDepositRecord() throws IOException {
        final DepositRecord object = this.coinmexClient.wallet().wallet().getDepositRecord("test-2");
        System.out.println(object);
    }

    @Test
    public void testWithdrawRecord() throws IOException {
        final WithdrawRecord object = this.coinmexClient.wallet().wallet().getWithdrawRecord("e016e05a-0374-4497-b7ea-65afdea9ff021533110293619");
        System.out.println(object);
    }

    @Test
    public void testBalances() throws IOException {
        final List<Account> accounts = this.coinmexClient.wallet().wallet().getBalances();
        System.out.println(accounts);
    }
}
