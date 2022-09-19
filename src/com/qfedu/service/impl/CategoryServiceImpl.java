package com.qfedu.service.impl;

import com.qfedu.dao.CategoryDao;
import com.qfedu.dao.impl.CategoryDaoImpl;
import com.qfedu.pojo.Category;
import com.qfedu.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao=new CategoryDaoImpl();

    @Override
    public List<Category> findAllCategory() {
        List<Category> list = categoryDao.findAllCategory();
        return list;
    }
}
