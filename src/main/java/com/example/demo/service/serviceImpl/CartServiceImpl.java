package com.example.demo.service.serviceImpl;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.entity.cartItem.CartItem;
import com.example.demo.entity.cartItem.CartItemPrimaryKey;
import com.example.demo.payload.dto.CartItemDTO;
import com.example.demo.payload.dto.ProductDTO;
import com.example.demo.payload.request.GetProductRequest;
import com.example.demo.payload.request.ProductAddedRequest;
import com.example.demo.payload.request.AddProductRequest;
import com.example.demo.repository.*;
import com.example.demo.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    JPACartItemRepository cartItemRepository;

    @Autowired
    JPACartRepository cartRepository;

    @Autowired
    JPACustomerRepository customerRepository;

    @Autowired
    JPAProductRepository productRepository;

    @Autowired
    MybatisCartItemRepository mybatisCartItemRepository;


    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CartItemDTO> addItem(AddProductRequest addProductRequest){
        List<CartItemDTO> response=new ArrayList<>();
        Customer customer=customerRepository.findById(addProductRequest.getCustomerId()).orElse(null);
        if (customer==null) return null;
        if (customer.getCart()==null)
        {
            customer.setCart(cartRepository.save(new Cart()));
            customerRepository.save(customer);
        };
        Cart cart=customer.getCart();
        for (ProductAddedRequest productloader:addProductRequest.getProductAddedRequests()) {
            Product product=productRepository.findById(productloader.getProductId()).orElse(null);
            if (product==null)
                response.add(null);
            else{
                CartItem cartItem=cartItemRepository.findById(new CartItemPrimaryKey(cart.getId(),product.getProductId()))
                                                    .orElse(new CartItem());
                cartItem.setDate(new Date());
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setId(new CartItemPrimaryKey(cart.getId(),product.getProductId()));

                if (cartItem.getQuantityWished()==null || cartItem.getQuantityWished()==0) cartItem.setQuantityWished(productloader.getCountProduct());
                else cartItem.setQuantityWished(cartItem.getQuantityWished()+productloader.getCountProduct());
                cartItem.setTotalAmount(cartItem.getQuantityWished()*product.getPrice());
                cartItem=cartItemRepository.save(cartItem);

                response.add(modelMapper.map(cartItem, CartItemDTO.class));
            }
        }
        return response;
    }

    public List<ProductDTO> getProductByCondition(GetProductRequest getProductRequest){
        return mybatisCartItemRepository.getProductByCondition(getProductRequest.getCustomerId(),getProductRequest.getNameProduct(),getProductRequest.getLimit(),getProductRequest.getOffset());
    }
}
