package ru.demoshop.beta.dataBaseInterface.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class PersistentLogins {

    private String username;
    private String series;
    private String token;
    private Timestamp last_used;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLast_used(Timestamp last_used) {
        this.last_used = last_used;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    @Id
    public String getSeries() {
        return series;
    }

    public String getToken() {
        return token;
    }

    public Timestamp getLast_used() {
        return last_used;
    }
}
