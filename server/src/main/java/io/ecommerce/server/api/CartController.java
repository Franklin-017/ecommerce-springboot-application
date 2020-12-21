package io.ecommerce.server.api;

import io.ecommerce.server.model.Cart;
import io.ecommerce.server.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/cart")
@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cartItem) {
        return cartService.addToCart(cartItem);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCartItem() {
        return cartService.getItemFromCart();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cart>> getCartItemById(@PathVariable("id") long id) {
        return cartService.getItemById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCartItem(@PathVariable("id") long id) {
        return cartService.deleteItemById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Cart>> updateCartItemById(@PathVariable("id") long id) {
        return cartService.updateCartItem(id);
    }
}
