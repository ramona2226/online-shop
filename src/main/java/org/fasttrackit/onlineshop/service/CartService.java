package org.fasttrackit.onlineshop.service;

import org.fasttrackit.onlineshop.domain.Cart;
import org.fasttrackit.onlineshop.domain.User;
import org.fasttrackit.onlineshop.persistance.CartRepository;
import org.fasttrackit.onlineshop.persistance.UserRepository;
import org.fasttrackit.onlineshop.transfer.AddProductToCartRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

@Autowired
    private final CartRepository cartRepository;
private final UserService userService;

    public CartService(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    @Transactional
        public Cart addProductToCart(AddProductToCartRequest request) {

        LOGGER.info("Adding product to cart : {}", request);

        Cart cart = cartRepository.findById(request.getUserId())
                .orElse(new Cart());
        if (cart.getUser() == null) {
            User user = userService.getUser(request.getUserId());
            cart.setUser(user);
        }

//add product to card

        return cartRepository.save(cart);


    }
}
