package ru.demoshop.beta.dataBaseInterface.entities;
import ru.demoshop.beta.dataBaseInterface.DTO.UserDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
public class AppUsers {


    private long id;
    private String name;
    private String surname;
    private String email;
    private Date bDay;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getbDay() {
        return bDay;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUsers(UserDto user){
        this.name=user.getFirstName();
        this.surname=user.getLastName();
        this.email=user.getEmail();
        this.bDay = new Date(System.currentTimeMillis());
    }

    public AppUsers(){};

    @Override
    public String toString(){
        return getName()+" "+getSurname()+" "+getbDay();
    }

}
