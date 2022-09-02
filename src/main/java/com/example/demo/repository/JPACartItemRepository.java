package com.example.demo.repository;

import com.example.demo.entity.cartItem.CartItem;
import com.example.demo.entity.cartItem.CartItemPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPACartItemRepository extends JpaRepository<CartItem, CartItemPrimaryKey> {
}
