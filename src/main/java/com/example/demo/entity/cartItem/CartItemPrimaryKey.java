package com.example.demo.entity.cartItem;


import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItemPrimaryKey implements Serializable{
    @Column(name="cartId", insertable = true,updatable = true,unique=true, nullable=false)
    private Long cartId;
    @Column(name="productId", insertable = true,updatable = true,unique=true, nullable=false)
    private Long productId;
}