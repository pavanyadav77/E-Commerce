package com.scaler.productcatalogservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category extends BaseModel{
    String  name;
    List<Product> products;
}
