package com.example.order.controller;

import com.example.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    CartService cartService;

    @GetMapping("/checkout/{userId}")
    public int checkout(@PathVariable Long userId) throws IOException {
       return cartService.totalAmount(userId);
    }

}
