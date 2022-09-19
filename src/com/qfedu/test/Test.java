package com.qfedu.test;

import com.qfedu.pojo.Product;
import com.qfedu.utils.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class Test {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(DruidUtil.getDataSource());
       /* 2、给所有cid为c001的商品价格提高500*/
       /* int update = jdbcTemplate.update("update product set price=price+500 where cid='c001'");
        System.out.println(update);*/

        System.out.println("3、所有价格在500-5000的商品有：");
        jdbcTemplate.queryForList("select * from product where price between 500 and 5000 ").stream().forEach(products1-> System.out.println(products1));

        System.out.println("4、查询所有未上架的商品");
        jdbcTemplate.queryForList("select*from product where flag=0").stream().forEach(products2-> System.out.println(products2));

       /* System.out.println("5、将名称含有娃娃的商品删除");
        int update2 = jdbcTemplate.update("delete  from product where pname like '%娃娃%'");
        System.out.println(update2);*/

        System.out.println("6、查询cid为c001,c002的商品");
        jdbcTemplate.queryForList("select * from product where cid='c001' or cid='c002'").stream().forEach(products3-> System.out.println(products3));

        System.out.println("7、查询名称的长度为3的商品");
        jdbcTemplate.query("select * from product", new BeanPropertyRowMapper<>(Product.class)).stream().filter((Product p) -> p.getPname().length() == 3).forEach(products4 -> System.out.println(products4) );

        Long aLong = jdbcTemplate.queryForObject("select count(*) from product where flag=0", Long.class);
        System.out.println("8、查询已下架的商品数量:"+aLong);

       /* System.out.println("9、添加一条商品（随意指定，能成功就行）");
        jdbcTemplate.update("insert into product values (10,'生椰拿铁',18,1,'c009')");*/

        System.out.println("10、查询未上架中商品中价格大于上架商品价格的商品");
        jdbcTemplate.queryForList("SELECT DISTINCT a.*  from (\n" +
                "(SELECT * from product WHERE flag=0) a,\n" +
                "(SELECT * from product WHERE flag=1) b\n" +
                ") WHERE a.price > b.price").stream().forEach(products5-> System.out.println(products5));

        System.out.println("11、查询所有商品按价格的降序存到一个List集合里面");
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * from product ORDER BY price DESC");
        list.stream().forEach(products-> System.out.println(products));

        System.out.println("12、按flag进行分组，查询出数量大于3条的统计个数");
        Long aLong1 = jdbcTemplate.queryForObject("SELECT COUNT(flag) a from product GROUP BY flag HAVING a>3", Long.class);
        System.out.println(aLong1);


    }



}
