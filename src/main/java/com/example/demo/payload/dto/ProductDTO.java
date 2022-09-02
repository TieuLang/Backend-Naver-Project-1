package com.example.demo.payload.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String nameProduct;
    private String type;
    private Long price;
}
