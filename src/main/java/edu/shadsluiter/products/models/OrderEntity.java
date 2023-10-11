package edu.shadsluiter.products.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class OrderEntity {
    
    @Id
    private int id;

    @Column("ORDER_NUMBER")
    private String order_number;

    @Column("PRODUCT_NAME")
    private String product_name;

    @Column("PRICE")

    private double price;

    @Column("QTY")
    private int quantity;

    public OrderEntity(int id, String order_number, String product_name, double price, int quantity) {
        this.id = id;
        this.order_number = order_number;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
    }
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
