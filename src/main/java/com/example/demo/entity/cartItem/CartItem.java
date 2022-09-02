package com.example.demo.entity.cartItem;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.cartItem.CartItemPrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="Cart_item")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem implements Serializable{
    @EmbeddedId
    private CartItemPrimaryKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cartId",referencedColumnName = "cart_id",nullable = false)
    @MapsId("cartId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @NotNull
    private Cart cart;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "product_id",nullable = false)
    @MapsId("productId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @NotNull
    private Product product;

    @Column(name="quantity_wished")
    @NotNull
    private Long quantityWished;

    @Column(name="date_added")
    @NotNull
    private Date date;

    @Column(name="total_amount")
    @NotNull
    private Long totalAmount;
}
