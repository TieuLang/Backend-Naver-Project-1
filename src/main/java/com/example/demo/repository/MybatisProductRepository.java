package com.example.demo.repository;

import com.example.demo.payload.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MybatisProductRepository {
    @Select("SELECT PRODUCT_ID, NAME_PRODUCT, PRICE, TYPE FROM PRODUCT WHERE PRICE<#{Price}")
    @Results(value={@Result(property = "productId", column="PRODUCT_ID"),
            @Result(property = "nameProduct",column = "NAME_PRODUCT"),
            @Result(property = "type",column = "TYPE"),
            @Result(property = "price",column = "PRICE")}
    )
    List<ProductDTO> getProductsLessThanPrice(Long Price);

    @Select("SELECT PRODUCT_ID, NAME_PRODUCT, PRICE, TYPE FROM PRODUCT WHERE PRICE=#{Price}")
    @Results(value={@Result(property = "productId", column="PRODUCT_ID"),
            @Result(property = "nameProduct",column = "NAME_PRODUCT"),
            @Result(property = "type",column = "TYPE"),
            @Result(property = "price",column = "PRICE")}
    )
    List<ProductDTO> getProductsEqualPrice(Long Price);

    @Select("SELECT PRODUCT_ID, NAME_PRODUCT, PRICE, TYPE FROM PRODUCT WHERE PRICE>#{Price}")
    @Results(value={@Result(property = "productId", column="PRODUCT_ID"),
            @Result(property = "nameProduct",column = "NAME_PRODUCT"),
            @Result(property = "type",column = "TYPE"),
            @Result(property = "price",column = "PRICE")}
    )
    List<ProductDTO> getProductsMoreThanPrice(Long Price);
}