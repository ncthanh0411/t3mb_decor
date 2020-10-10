package com.example.t3mb_decor.model;

import com.sun.istack.NotNull;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "price",nullable = false)
    private int price;
    @Column(name = "description",columnDefinition = "TEXT",nullable = false)
    private String description;
    @Column(name = "quantity",nullable = false)
    private int quantity;
    @Column(name = "material",nullable = false)
    private String material;
    @Column(name = "image",columnDefinition = "TEXT",nullable = false)
    private String image;
    @Column(name = "height",nullable = false)
    private int height;
    @Column(name = "length",nullable = false)
    private int length;
    @Column(name = "width",nullable = false)
    private int width;
    @Column(name = "status", columnDefinition = "integer default 0")
    private int status;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product_wishlist")
    private List<User> customer_wishlist= new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "order_products",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private List<Orders> order_product = new ArrayList<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public Product() {
    }

    public Product(String name, int price, String description, int quantity, String material, String image, int height, int length, int width) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.material = material;
        this.image = image;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public List<User> getCustomer_wishlist() {
        return customer_wishlist;
    }

    public void setCustomer_wishlist(List<User> customer_wishlist) {
        this.customer_wishlist = customer_wishlist;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Orders> getOrder_product() {
        return order_product;
    }

    public void setOrder_product(List<Orders> order_product) {
        this.order_product = order_product;
    }
}
