package ru.demoshop.beta.dataBaseInterface.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Colors {
    private long id;
    private long itemId;
    private long categoryId;
    private String name;
    private int quantity;
    private boolean available;

    public String getName() {
        return name;
    }

    public long getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Colors(){};

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Colors(String name, int quantity, long id, long categoryId){
        setAvailable((quantity>0));
        setName(name);
        setQuantity(quantity);
        setItemId(id);
        setCategoryId(categoryId);
    }
}
