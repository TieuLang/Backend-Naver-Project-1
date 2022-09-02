package com.example.demo.service;

import com.example.demo.payload.dto.ProductDTO;
import com.example.demo.payload.dto.ProductV2DTO;

import java.util.List;


public interface ProductService {
    public List<ProductDTO> getProductByConditionPrice(ProductV2DTO productV2DTO);
}
