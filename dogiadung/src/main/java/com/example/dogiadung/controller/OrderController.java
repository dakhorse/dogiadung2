package com.example.dogiadung.controller;

import com.example.dogiadung.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }

    @PostMapping("/order/place")
    public String placeOrder(@RequestParam String customerName,
                             @RequestParam String customerEmail,
                             @RequestParam String shippingAddress) {
        orderService.placeOrder(customerName, customerEmail, shippingAddress);
        return "redirect:/products";
    }
}

