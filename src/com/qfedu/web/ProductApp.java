package com.qfedu.web;

import com.qfedu.pojo.Category;
import com.qfedu.pojo.Product;
import com.qfedu.service.CategoryService;
import com.qfedu.service.ProductService;
import com.qfedu.service.impl.CategoryServiceImpl;
import com.qfedu.service.impl.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//客户端入口
public class ProductApp {
   static ProductService productService=new ProductServiceImpl();
   static CategoryService categoryService=new CategoryServiceImpl();
    public static void main(String[] args) {
       // Scanner sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("输入以下命令进行操作");
            System.out.println("C:创建 U:修改 D:删除 FA:查询所有 FI:根据id查询 DA:根据id批量删除 Q:退出");
            try {
            String s = br.readLine();
            switch (s.toUpperCase()) {
                case "C":
                   // System.out.println("创建");
                    createProduct(br);
                    break;
                case "U":
                    System.out.println("修改");
                    updateProduct(br);
                    break;
                case "D":
                    System.out.println("删除");
                    break;
                case "FA":
                  //  System.out.println("查询所有");
                    findAllProduct();
                    break;
                case "FI":
                   // System.out.println("根据id查询");
                    findProById(br);
                    break;
                case "DA":
                    System.out.println("根据id批量删除");
                    break;
                case "Q":
                    System.out.println("退出系统");
                    System.exit(1);
                    break;
                default:
                    System.out.println("输入有误，请重试");
                    break;
            }
            }catch (Exception e){
                System.out.println("系统正在维护，请稍后重试！");
            }
        }
    }

    private static void updateProduct(BufferedReader br){
        //根据ID查询，然后修改
            System.out.println("请输入你要修改的商品id:");
            try {
                int id = Integer.parseInt(br.readLine());
                Product product = productService.findProById(id);


            }catch (Exception e){
                System.out.println("输入有误，请重新输入");
            }



    }






    private static void createProduct(BufferedReader br) {
        try {
            System.out.println("请输入商品信息");
            System.out.print("1、输入商品的名称：");
            String pname = br.readLine();
            System.out.print("请输入商品价格：");
            int price= Integer.parseInt(br.readLine());
            System.out.println("请选择商品是否上架：1 代表上架 0 代表下架");
            int flag=Integer.parseInt(br.readLine());
            System.out.println("请选择商品分类，输入编号");
            //获取商品的所有分类并选择赋值
            List<Category> list = categoryService.findAllCategory();
            Map<String,String> map=new HashMap<>();
            list.stream().forEach(category -> {
                System.out.println("商品ID："+category.getCid()+"\t商品分类："+category.getCname());
                map.put(category.getCid(),category.getCname());
            });
            String cid= br.readLine();
            Product product =new Product();
            product.setPname(pname);
            product.setPrice(price);
            product.setFlag(flag);
            product.setCid(cid);
           int rows= productService.addProduct(product);
            if (rows>0) System.out.println("添加成功！");
            else System.out.println("添加失败，请重新添加");
        }catch (Exception e){
            System.out.println("输入有误，请重新输入");
        }
    }

    public static void findProById(BufferedReader br){
        System.out.println("请输入id");
        try {
            int id = Integer.parseInt(br.readLine());
            Product product = productService.findProById(id);
            System.out.println(product);
        }catch (Exception e){
            System.out.println("输入有误，请重新输入");
        }
    }

    public static void findAllProduct(){
        List<Product> list = productService.findAll();
        list.stream().forEach(product -> System.out.println(product));
    }
}
