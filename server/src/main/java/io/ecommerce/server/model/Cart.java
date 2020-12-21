package io.ecommerce.server.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String productName;
    private float productPrice;
    private float discountPrice;
    private int quantity;
    private String Image;
}
