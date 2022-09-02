package com.example.demo.entity;

import com.example.demo.entity.cartItem.CartItem;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Product")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    @NotNull
    private Long productId;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<CartItem> cartItems;

    @Column(name="name_product")
    @NotNull
    private String nameProduct;

    @Column(name="type")
    private String type;

    @Column(name="price")
    @NotNull
    private Long price;

}
