package ru.demoshop.beta.dataBaseInterface.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Password {

    private long Id;
    private String password;
    private long userId;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return Id;
    }

    public long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
