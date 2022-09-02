package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    @NotNull
    private Long id;

    @Column(name="customer_name")
    @NotNull
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phone_no")
    private String phone;

    @OneToOne
    @JoinColumn(name="cart_id",referencedColumnName = "cart_id")
    private Cart cart;

}
