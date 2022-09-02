package com.example.demo.payload.dto;

import com.example.demo.entity.cartItem.CartItemPrimaryKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItemDTO {
    private CartItemPrimaryKey id;

    private Long quantityWished;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss dd-MM-yyyy")
    private Date date;

    private Long totalAmount;
}
