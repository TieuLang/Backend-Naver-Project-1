package com.example.demo.service;

import com.example.demo.payload.dto.CartItemDTO;
import com.example.demo.payload.request.AddProductRequest;

import java.util.List;

public interface CartService {
    List<CartItemDTO> addItem(AddProductRequest addProductRequest);
}
