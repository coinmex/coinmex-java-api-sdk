package com.coinmex.dax.sdk.openapi.spot.ccex;

import com.coinmex.dax.sdk.openapi.common.domain.Record;
import com.coinmex.dax.sdk.openapi.common.enums.OrderStatusEnEnum;
import com.coinmex.dax.sdk.openapi.common.enums.OrderTypeEnum;
import com.coinmex.dax.sdk.openapi.common.enums.SideTypeEnum;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.AddOrderResult;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.Order;
import com.coinmex.dax.sdk.openapi.spot.ccex.domain.OrderParam;
import com.coinmex.dax.sdk.openapi.spot.common.BaseTest;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author coinmex-sdk-team
 * @date 2018/04/28
 */
public class OrderServiceTest extends BaseTest {


    static final String CODE = "LTC_BTC";

    @Test
    public void testPostOrderLimitedSell() throws IOException {
        // limit sell
        final OrderParam param = OrderParam.builder()
                .code(OrderServiceTest.CODE)
                .side(SideTypeEnum.SELL.getSideName())
                .type(OrderTypeEnum.LIMITED.getTypeName())
                .size("1")
                .price("1.001")
                .build();
        final AddOrderResult result = this.coinmexClient.spot().ccex().order()
                .postOrder(param);
        System.out.println(result);
    }

    @Test
    public void testPostOrderLimitedBuy() throws IOException {
        // limit buy
        final OrderParam param = OrderParam.builder()
                .code(OrderServiceTest.CODE)
                .side(SideTypeEnum.BUY.getSideName())
                .type(OrderTypeEnum.LIMITED.getTypeName())
                .size("1")
                .price("1.001")
                .build();
        final AddOrderResult result = this.coinmexClient.spot().ccex().order().postOrder(param);
        System.out.println(result);
    }

    @Test
    public void testPostOrderMarketSell() throws IOException {
        // market sell
        final OrderParam param = OrderParam.builder()
                .code(OrderServiceTest.CODE)
                .side(SideTypeEnum.SELL.getSideName())
                .type(OrderTypeEnum.MARKET.getTypeName())
                .size("1")
                .build();
        final AddOrderResult result = this.coinmexClient.spot().ccex().order().postOrder(param);
        System.out.println(result);

        
    }

    @Test
    public void testPostOrderMarketBuy() throws IOException {
        // market buy
        final OrderParam param = OrderParam.builder()
                .code(OrderServiceTest.CODE)
                .side(SideTypeEnum.BUY.getSideName())
                .type(OrderTypeEnum.MARKET.getTypeName())
                .funds("1.001")
                .build();
        final AddOrderResult result = this.coinmexClient.spot().ccex().order().postOrder(param);
        System.out.println(result);
    }

    @Test
    public void testDeleteOrder() throws IOException {
        final OrderParam param = OrderParam.builder()
                .code(OrderServiceTest.CODE)
                .side(SideTypeEnum.BUY.getSideName())
                .type(OrderTypeEnum.LIMITED.getTypeName())
                .size("1")
                .price("1.001")
                .build();
        final AddOrderResult result = this.coinmexClient.spot().ccex().order().postOrder(param);
        this.coinmexClient.spot().ccex().order().deleteOrder(OrderServiceTest.CODE, result.getOrderId());
    }

    @Test
    public void testDeleteOrders() throws IOException {
        this.coinmexClient.spot().ccex().order().deleteOrders(OrderServiceTest.CODE);
    }

    @Test
    public void testDeleteOrders2() throws IOException {
        Long[] orderIds = new Long[] {10010L, 10011L, 10012L};
        this.coinmexClient.spot().ccex().order().deleteOrders(OrderServiceTest.CODE, orderIds);
    }

    @Test
    public void testGetOrder() throws IOException {
        final OrderParam param = OrderParam.builder()
                .code(OrderServiceTest.CODE)
                .side(SideTypeEnum.BUY.getSideName())
                .type(OrderTypeEnum.LIMITED.getTypeName())
                .size("1")
                .price("1.001")
                .build();
        final AddOrderResult result = this.coinmexClient.spot().ccex().order().postOrder(param);
        final Order order = this.coinmexClient.spot().ccex().order().getOrder(OrderServiceTest.CODE, result.getOrderId());
        System.out.println(order);
    }

    @Test
    public void testGetOrders() throws IOException {

        final Record<List<Order>, Long> orderList = this.coinmexClient.spot().ccex().order()
                .getOrders(OrderServiceTest.CODE, OrderStatusEnEnum.OPEN, null, null, null);
        System.out.println(orderList);
    }
}
