package com.qfedu.service;

import com.qfedu.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findProById(int id);

    int addProduct(Product product);

}
