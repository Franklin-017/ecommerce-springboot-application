package io.ecommerce.server.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String productName;
    private int productPrice;
    private int discountPrice;
    private float productReview;
    private String productImage;
    private int productQuantity;

    public void setId(long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setProductReview(float productReview) {
        this.productReview = productReview;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public float getProductReview() {
        return productReview;
    }

    public String getProductImage() {
        return productImage;
    }
}
