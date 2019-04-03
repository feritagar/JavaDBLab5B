package controller;

public class Product {
    private int productID;
    private String productName;
    private String productDetail;
    private double price;

    public Product(int productID, String productName, String productDetail, double price) {
        this.productID = productID;
        this.productName = productName;
        this.productDetail = productDetail;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
