package com.scaler.productcatalogservice.controller;

import com.scaler.productcatalogservice.dto.ProductDto;
import com.scaler.productcatalogservice.model.Product;
import com.scaler.productcatalogservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping("/products/{id}")
    public ProductDto getProductDetails(@PathVariable Long id){
        Product product = productService.getProductById(id);
        if(product != null){
            return from(product);
        }
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

    private ProductDto from(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setCategory(product.getCategory().getName());
        productDto.setPrice(product.getPrice());
        productDto.setImage(product.getImage());
        return productDto;
    }
}
