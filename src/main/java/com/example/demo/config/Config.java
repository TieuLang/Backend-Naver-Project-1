package com.example.demo.config;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.repository.JPACustomerRepository;
import com.example.demo.repository.JPAProductRepository;
import org.modelmapper.ModelMapper;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    };

    private static  final Logger logger = LoggerFactory.getLogger(Config.class);
    @Bean
    CommandLineRunner initDatabase(JPACustomerRepository customerRepository, JPAProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception{
                for (int i=0;i<5;++i)
                {
                    Customer customer=new Customer();
                    customer.setName("Khach hang "+String.valueOf(i));
                    customer.setAddress(Character.toString((int)'a'+i));
                    customer.setPhone("0");
                    customerRepository.save(customer);
                };
                for (int i=0;i<10;++i)
                {
                    Product product=new Product();
                    product.setNameProduct("San pham "+String.valueOf(i));
                    product.setType(Character.toString((int)'a'+i));
                    product.setPrice((long)(10000+i*1000));
                    productRepository.save(product);
                };
                for (int i=0;i<10;++i)
                {
                    Product product=new Product();
                    product.setNameProduct("Product");
                    product.setType(Character.toString((int)'a'+i));
                    product.setPrice((long)(10000+i*1000));
                    productRepository.save(product);
                };
            }
        };
    }

}
