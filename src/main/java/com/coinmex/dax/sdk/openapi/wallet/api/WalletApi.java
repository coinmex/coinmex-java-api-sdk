package com.coinmex.dax.sdk.openapi.wallet.api;

import com.alibaba.fastjson.JSONObject;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Account;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Ledger;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.WithdrawalParam;
import com.coinmex.dax.sdk.openapi.spot.publics.domain.CodeInfo;
import com.coinmex.dax.sdk.openapi.wallet.domain.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author newex-team
 * @data 2018/7/25
 */
public interface WalletApi {
    @POST("spot/wallet/deposit/address/{currency}")
    Call<DepositAddress> generateDepositAddress(@Path("currency") String currency);

    @GET("spot/wallet/deposit/records/{currency}")
    Call<Page<DepositRecord>> getDepositRecord(@Path("currency") String currency,
                                               @Query("address") String address,
                                               @Query("pageNum") Integer pageNum,
                                               @Query("pageSize") Integer pageSize);

    @GET("spot/wallet/deposit/record/{tradeNo}")
    Call<DepositRecord> getDepositRecord(@Path("tradeNo") String tradeNo);


    @GET("spot/wallet/withdraw/info/{currency}")
    Call<WithdrawInfo> getWithdrawInfo(@Path("currency") String currency);


    @POST("spot/wallet/withdraw")
    Call<WithdrawRecord> withdraw(@Body WithdrawParam body);



    @GET("spot/wallet/withdraw/records/{currency}")
    Call<Page<WithdrawRecord>> getWithdrawRecord(@Path("currency") String currency,
                                               @Query("address") String address,
                                               @Query("pageNum") Integer pageNum,
                                               @Query("pageSize") Integer pageSize);

    @GET("spot/wallet/withdraw/record/{tradeNo}")
    Call<WithdrawRecord> getWithdrawRecord(@Path("tradeNo") String tradeNo);


    /**
     *  获取余额
     * @return
     */
    @GET("spot/ccex/account/assets")
    Call<List<Account>> getBalances();


}
