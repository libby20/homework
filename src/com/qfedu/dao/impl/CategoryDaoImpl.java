package com.qfedu.dao.impl;

import com.qfedu.dao.CategoryDao;
import com.qfedu.pojo.Category;
import com.qfedu.utils.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(DruidUtil.getDataSource());

    @Override
    public List<Category> findAllCategory() {
        String sql="select * from category";
        List<Category> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
        return list;
    }
}
