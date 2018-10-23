package com.coinmex.dax.sdk.openapi.wallet.domain;

import lombok.*;

import java.util.Date;

/**
 * @author newex-team
 * @date 2018-04-06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DepositRecord {
    /**
     *
     */
    private String txId;
    /**
     *
     */
    private String address;
    /**
     *
     */
    private String amount;
    /**
     *
     */
    private Integer confirmation;
    /**
     *
     */
    private String currency;
}