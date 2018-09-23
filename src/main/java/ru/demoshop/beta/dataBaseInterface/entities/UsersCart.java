package ru.demoshop.beta.dataBaseInterface.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsersCart {
    private long id;
    private long userId;
    private long colorId;
    private int quantity;

    public long getColorId() {
        return colorId;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getUserId() {
        return userId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
