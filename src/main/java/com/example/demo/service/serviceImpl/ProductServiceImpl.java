package com.example.demo.service.serviceImpl;

import com.example.demo.payload.dto.ProductDTO;
import com.example.demo.payload.dto.ProductV2DTO;
import com.example.demo.repository.JPAProductRepository;
import com.example.demo.repository.MybatisProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


//INSERT INTO PRODUCT (NAME_PRODUCT,PRICE,TYPE)
//        VALUES ('ASD',20,'FGF');
//        INSERT INTO PRODUCT (NAME_PRODUCT,PRICE,TYPE)
//        VALUES ('ASD',15,'FGF');
//        INSERT INTO PRODUCT (NAME_PRODUCT,PRICE,TYPE)
//        VALUES ('ASD',5,'FGF');
//        INSERT INTO PRODUCT (NAME_PRODUCT,PRICE,TYPE)
//        VALUES ('ASD',25,'FGF');
//        INSERT INTO PRODUCT (NAME_PRODUCT,PRICE,TYPE)
//        VALUES ('ASD',30,'FGF');


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    JPAProductRepository productRepository;

    @Resource
    MybatisProductRepository mybatisProductRepository;

    @Override
    public List<ProductDTO> getProductByConditionPrice(ProductV2DTO productV2DTO) {
        switch (productV2DTO.getCondition()){
            case "LESS_THAN":
                return mybatisProductRepository.getProductsLessThanPrice(productV2DTO.getPrice());
            case "EQUAL":
                return mybatisProductRepository.getProductsEqualPrice(productV2DTO.getPrice());
            case "GREATER_THAN":
                return mybatisProductRepository.getProductsMoreThanPrice(productV2DTO.getPrice());
        }
        return null;
    }
}
