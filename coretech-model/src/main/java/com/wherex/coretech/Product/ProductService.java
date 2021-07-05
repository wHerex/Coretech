package com.wherex.coretech.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
        Long id = productDto.getId();
        String name = productDto.getName();
        String description = productDto.getDescription();
        Long quantity = productDto.getQuantity();
        Long price = productDto.getPrice();
        return new Product(id, name, description, price, quantity);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void editProduct(Long id, Product product) {
        Product oldProduct = productRepository.findById(id)
                .orElseThrow();
        String name = product.getName();
        String description = product.getDescription();
        Long price = product.getPrice();
        Long quantity = product.getQuantity();
        oldProduct.setName(name);
        oldProduct.setDescription(description);
        oldProduct.setPrice(price);
        oldProduct.setQuantity(quantity);
    }
}
