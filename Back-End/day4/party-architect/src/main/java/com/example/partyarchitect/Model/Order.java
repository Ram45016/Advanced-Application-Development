package com.example.partyarchitect.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long retailerId;
    private Long manufacturerId;
    private Long productId;
    private int quantity;
    private String deliveryAddress;
    private String paymentMethod;
    private double price;
    private String orderStatus;
    public Order() {
    }
    public Order(Long orderId, Long retailerId, Long manufacturerId, Long productId, int quantity,
            String deliveryAddress, String paymentMethod, double price, String orderStatus) {
        this.orderId = orderId;
        this.retailerId = retailerId;
        this.manufacturerId = manufacturerId;
        this.productId = productId;
        this.quantity = quantity;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.price = price;
        this.orderStatus = orderStatus;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getRetailerId() {
        return retailerId;
    }
    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }
    public Long getManufacturerId() {
        return manufacturerId;
    }
    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
