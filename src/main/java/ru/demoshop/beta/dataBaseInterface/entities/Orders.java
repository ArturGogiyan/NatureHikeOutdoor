package ru.demoshop.beta.dataBaseInterface.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Orders {

    private long id;
    private Timestamp date;
    private long userId;
    private boolean isPaid;
    private boolean isSent;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public long getUserId() {
        return userId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }
}
