package ru.demoshop.beta.dataBaseInterface.entities;


import ru.demoshop.beta.dataBaseInterface.DTO.ItemDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Items {

    private long id;
    private long categoryId;
    private boolean available;
    private int price;
    private String name;
    private String info;
    private String ImageURL;

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }



    public String getName() {
        return name;
    }


    public long getCategoryId() {
        return categoryId;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }


    public String getInfo() {
        return info;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public Items(){setAvailable(true);}

    public Items(ItemDTO item){
        this.setAvailable(true);
        this.setInfo(item.getInfo());
        this.setPrice(item.getPrice());
        this.setName(item.getName());
        this.setCategoryId(Long.parseLong(item.getCategoryName()));
    }
}
