package com.wherex.coretech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin()
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductDto productDto){
        productService.saveProduct(productDto);
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }


}
