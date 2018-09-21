package ru.demoshop.beta.dataBaseInterface.DTO;

public class CommonUSerData {

    private String lastName;
    private String firstName;
    private String Email;

    public CommonUSerData(){}
    public CommonUSerData(String lastName, String firstName, String email)
    {
        this.Email=email;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
