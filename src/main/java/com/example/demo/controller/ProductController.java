package com.example.demo.controller;

import com.example.demo.payload.dto.ProductDTO;
import com.example.demo.payload.dto.ProductV2DTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//INSERT INTO CUSTOMER (ADDRESS,CUSTOMER_NAME,PHONE_NO)
//        VALUES ('abc','test','12312');
//        INSERT INTO CUSTOMER (ADDRESS,CUSTOMER_NAME,PHONE_NO)
//        VALUES ('abc','test','12312');
//        INSERT INTO CUSTOMER (ADDRESS,CUSTOMER_NAME,PHONE_NO)
//        VALUES ('abc','test','12312');
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


@RestController
@RequestMapping(value="/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value="/getProduct")
    public ResponseEntity<List<ProductDTO>> getProductByPriceCondition(@RequestBody ProductV2DTO productV2DTO) {
        return new ResponseEntity<>(productService.getProductByConditionPrice(productV2DTO), HttpStatus.OK);
    }

}
