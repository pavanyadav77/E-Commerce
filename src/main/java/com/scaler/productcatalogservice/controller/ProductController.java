package com.scaler.productcatalogservice.controller;

import com.scaler.productcatalogservice.dto.ProductDto;
import com.scaler.productcatalogservice.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public ProductDto getProductDetails(@PathVariable Long id){
        return null;
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts(){
        return null;
    }

    @PostMapping("Products/add")
    public String  addProduct(@RequestBody ProductDto product){
        return null;
    }

    @PutMapping("products/{id}")
    public ProductDto  updateProduct(@PathVariable Long id, @RequestBody ProductDto product){
        return null;
    }

    @PatchMapping("products/{id}")
    public ProductDto  patchProduct(@PathVariable Long id, @RequestBody ProductDto product){
        return null;
    }

    @DeleteMapping("products/{id}")
    public Boolean  deleteProduct(@PathVariable Long id){
        return false;
    }
}
