package org.fasttrackit.onlineshop.cart;

import org.fasttrackit.onlineshop.service.CartService;
import org.fasttrackit.onlineshop.transfer.cart.AddProductToCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("ALL")
@SpringBootTest
public class CartServiceIntegrationTests {

    @Autowired
    private CartService cartService;

    public void addProductToCart_WhenValidRequest_thenProducsAreAddesToCart() {
        AddProductToCartRequest request = new AddProductToCartRequest();
        request.setUserId(1000L);


         //cartService.addProductToCart();
    }


}
