package org.fasttrackit.onlineshop.web;

import org.fasttrackit.onlineshop.domain.Cart;
import org.fasttrackit.onlineshop.service.CartService;
import org.fasttrackit.onlineshop.transfer.AddProductToCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/carts")
public class CartController {
// bean invalid
@Autowired
private final CartService cartService;

@Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PutMapping
    public ResponseEntity<Cart> addProductToCard(AddProductToCartRequest request) {
        Cart cart = cartService.addProductToCart(request);
        return ResponseEntity.ok(cart);

    }
}
