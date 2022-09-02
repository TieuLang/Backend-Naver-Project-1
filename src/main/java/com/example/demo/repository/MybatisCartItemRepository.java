package com.example.demo.repository;

import com.example.demo.payload.dto.CartItemDTO;
import com.example.demo.payload.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MybatisCartItemRepository {
    @Select("SELECT PRODUCT.PRODUCT_ID,PRODUCT.NAME_PRODUCT,PRODUCT.PRICE,PRODUCT.TYPE FROM CUSTOMER,CART_ITEM,PRODUCT WHERE CUSTOMER.CUSTOMER_ID=#{customerId} AND CUSTOMER.CART_ID=CART_ITEM.CART_ID AND CART_ITEM.PRODUCT_ID=PRODUCT.PRODUCT_ID AND PRODUCT.NAME_PRODUCT=#{productName} LIMIT #{limit} OFFSET #{offset}")
    @Results(value={@Result(property = "productId",column = "PRODUCT_ID"),
                    @Result(property = "nameProduct",column = "NAME_PRODUCT"),
                    @Result(property = "type",column = "TYPE"),
                    @Result(property = "price",column = "PRICE")}
    )
    public List<ProductDTO> getProductByCondition(Long customerId, String productName, Long limit, Long offset);

    @Select("SELECT * FROM CART_ITEM WHERE CART_ITEM.CART_ID=#{cartId} AND CART_ITEM.PRODUCT_ID=#{productId}")
    public CartItemDTO getCartItemDTO(Long cartId,Long productId);
}