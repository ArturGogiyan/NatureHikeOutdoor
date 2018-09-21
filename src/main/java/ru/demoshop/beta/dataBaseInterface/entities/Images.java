package ru.demoshop.beta.dataBaseInterface.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Images {

    private long id;
    private long itemId;
    private String URL;

    public long getItemId() {
        return itemId;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public String getURL() {
        return URL;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Images(){};

    public Images(String url, long id){
        setItemId(id);
        setURL(url);
    }
}