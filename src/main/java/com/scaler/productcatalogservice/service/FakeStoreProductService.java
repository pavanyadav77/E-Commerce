package com.scaler.productcatalogservice.service;

import com.scaler.productcatalogservice.dto.FakeStoreProductDto;
import com.scaler.productcatalogservice.model.Category;
import com.scaler.productcatalogservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto =
            restTemplate
                    .getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,id);
        if(fakeStoreProductDto.getBody()!=null &&
                fakeStoreProductDto.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            return from(fakeStoreProductDto.getBody());
        }
        return null;
    }

    public List<Product> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:response.getBody()){
            products.add(from(fakeStoreProductDto));
        }
        return products;
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
