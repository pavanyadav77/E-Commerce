package com.scaler.productcatalogservice.service;

import com.scaler.productcatalogservice.dto.ProductDto;
import com.scaler.productcatalogservice.model.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();
}
