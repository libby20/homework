package com.qfedu.dao.impl;

import com.qfedu.dao.ProductDao;
import com.qfedu.pojo.Product;
import com.qfedu.utils.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());

    @Override
    public int updateProduct(Product product) {

        String sql="update product set pname=? price=? flag=? cid=? where pid=?";
        int rows = jdbcTemplate.update(sql, product.getPname(), product.getPrice(), product.getFlag(), product.getCid(),product.getPid());
        return rows;
    }

    @Override
    public int addProduct(Product product) {
        String sql="insert into product values (null,?,?,?,?)";
        int rows = jdbcTemplate.update(sql, product.getPname(), product.getPrice(), product.getFlag(), product.getCid());
        return rows;
    }

    @Override
    public List<Product> findAll() {
        String sql = "select * from product";
        List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
        return list;
    }


    @Override
    public Product findProById(int id) {
        String sql="select * from product where pid=?";
        List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), id);
        return list.size()==1? list.get(0) :null;
    }
}
