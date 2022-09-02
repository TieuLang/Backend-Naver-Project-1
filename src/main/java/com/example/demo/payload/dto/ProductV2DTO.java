package com.example.demo.payload.dto;

import jdk.jfr.Name;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProductV2DTO {
    private Long price;
    private String condition;
}
