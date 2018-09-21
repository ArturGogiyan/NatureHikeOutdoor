package ru.demoshop.beta.dataBaseInterface.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRole {

    private long id;
    private long userId;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
