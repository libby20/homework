package com.qfedu.service.impl;

import com.qfedu.dao.ProductDao;
import com.qfedu.dao.impl.ProductDaoImpl;
import com.qfedu.pojo.Product;
import com.qfedu.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
  private   ProductDao productDao=new ProductDaoImpl();

    @Override
    public int addProduct(Product product) {
        int rows = productDao.addProduct(product);
        return rows;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = productDao.findAll();
        return list;
    }

    @Override
    public Product findProById(int id) {
        Product product=productDao.findProById(id);
        return product;
    }
}
