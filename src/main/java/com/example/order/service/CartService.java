package com.example.order.service;


import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class CartService {

    public int totalAmount(Long userId) throws RestClientException, IOException {
        String baseUrl = "http://localhost:8181/cart/total/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> response = null;
        try {
            response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), Integer.class);
            System.out.println(response.getBody());
            return response.getBody();
        } catch (Exception e) {
            throw new NullPointerException("No user found with Id : " + userId);
        }

    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

}