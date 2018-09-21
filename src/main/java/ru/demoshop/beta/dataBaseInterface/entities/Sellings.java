package ru.demoshop.beta.dataBaseInterface.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sellings {

    private long id;
    private long orderId;
    private long itemId;
    private long colorId;
    private long quantity;
    private long totalPrice;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public long getItemId() {
        return itemId;
    }

    public long getColorId() {
        return colorId;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
