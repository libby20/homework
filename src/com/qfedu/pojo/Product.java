package com.qfedu.pojo;

public class Product {
    private int pid;
    private String pname;
    private int price;
    private int flag;
    private String cid;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", flag=" + flag +
                ", cid='" + cid + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Product(int pid, String pname, int price, int flag, String cid) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.flag = flag;
        this.cid = cid;
    }

    public Product() {
    }
}
