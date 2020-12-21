package io.ecommerce.server.service;

import io.ecommerce.server.dao.CartDao;
import io.ecommerce.server.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartDao cartDao;

    @Autowired
    public CartService(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    // Add to cart
    public ResponseEntity<Cart> addToCart(Cart cart) {
        try {
            Cart _cart = cartDao.save(cart);
            return new ResponseEntity<>(_cart, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Items from cart
    public ResponseEntity<List<Cart>> getItemFromCart(){
        try {
            List<Cart> cartItems = cartDao.findAll();
            if(cartItems.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(cartItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Cart item by id
    public ResponseEntity<Optional<Cart>> getItemById(long id) {
        try{
            Optional<Cart> cartItem = cartDao.findById(id);
            if(cartItem.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(cartItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete Cart Item by Id
    public ResponseEntity<HttpStatus> deleteItemById(long id) {
        try {
            cartDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update Cart Item by Id
    public ResponseEntity<Optional<Cart>> updateCartItem(long id) {
        try {
            Optional<Cart> cartData = cartDao.findById(id);
            return new ResponseEntity<>(cartData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
