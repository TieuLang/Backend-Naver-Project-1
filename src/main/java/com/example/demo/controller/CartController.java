package com.example.demo.controller;

import com.example.demo.payload.dto.CartItemDTO;
import com.example.demo.payload.request.AddProductRequest;
import com.example.demo.entity.cartItem.CartItem;
import com.example.demo.payload.request.GetProductRequest;
import com.example.demo.service.serviceImpl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartServiceImpl cartService;


    @PostMapping("/addItems")
    public ResponseEntity<List<CartItemDTO>> addItems(@RequestBody AddProductRequest addProductRequest){
        return new ResponseEntity<>(cartService.addItem(addProductRequest), HttpStatus.OK);
    }

    @GetMapping("/getProductWithCondition")
    public ResponseEntity<List> getProductWithCondition(@RequestBody GetProductRequest getProductRequest){
        return new ResponseEntity<>(cartService.getProductByCondition(getProductRequest),HttpStatus.OK);
    }
}
