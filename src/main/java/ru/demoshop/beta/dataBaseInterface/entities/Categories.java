package ru.demoshop.beta.dataBaseInterface.entities;

import ru.demoshop.beta.dataBaseInterface.DTO.CategoryDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories {

    private long id;
    private String name;
    private String pictireUrl;
    private boolean available;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPictireUrl() {
        return pictireUrl;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPictireUrl(String pictireUrl) {
        this.pictireUrl = pictireUrl;
    }

    public Categories(){
        setAvailable(true);
    }
    public Categories(CategoryDTO categoryDTO){
        setAvailable(true);
        setName(categoryDTO.getName());
    }
}

