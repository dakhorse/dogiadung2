package com.example.dogiadung.service;

import com.example.dogiadung.model.CartItem;
import com.example.dogiadung.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final List<CartItem> cartItems = new ArrayList<>();

    public void addProductToCart(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalAmount() {
        return cartItems.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
    }

    public void clearCart() {
        cartItems.clear();
    }
}

