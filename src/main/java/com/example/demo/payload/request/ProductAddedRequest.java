package com.example.demo.payload.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductAddedRequest {
    private Long productId;
    private Long countProduct;
}
