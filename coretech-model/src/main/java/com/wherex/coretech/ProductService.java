package com.wherex.coretech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductDto productDto){
        Product product = toModel(productDto);
        productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    private Product toModel(ProductDto productDto) {
        Long price = productDto.getPrice();
        return new Product(price);
    }

}
