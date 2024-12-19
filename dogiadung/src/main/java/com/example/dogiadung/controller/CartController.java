package com.example.dogiadung.controller;

import com.example.dogiadung.model.Product;
import com.example.dogiadung.service.CartService;
import com.example.dogiadung.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity, Model model) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            cartService.addProductToCart(product, quantity);
        }
        // Sau khi thêm sản phẩm, chuyển hướng đến trang giỏ hàng
        return "redirect:/cart/view";
    }

    @GetMapping("/view")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        return "cart"; // Trả về tên của file HTML 'cart.html'
    }

}

