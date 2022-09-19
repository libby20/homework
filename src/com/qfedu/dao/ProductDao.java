package com.qfedu.dao;

import com.qfedu.pojo.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    Product findProById(int id);

    int addProduct(Product product);

    int updateProduct(Product product);
}
