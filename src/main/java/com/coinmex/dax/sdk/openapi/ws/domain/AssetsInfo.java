package com.coinmex.dax.sdk.openapi.ws.domain;

import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Account;
import lombok.Data;

/**
 * @author newex-team
 * @date 2018/6/12
 */
@Data
public class AssetsInfo extends ParamRequest {

    /**
     * data
     */
    private Account data;
}
