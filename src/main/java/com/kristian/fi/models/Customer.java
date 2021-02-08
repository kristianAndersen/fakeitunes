package com.kristian.fi.models;

public class Customer {

    private String CustomerId;
    private String FirstName;
    private String LastName;
    private String Country;
    private String PostalCode;
    private String Phone;
    private String Email;

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        this.PostalCode = postalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }



    public Customer(String CustomerId, String FirstName, String LastName, String Country, String PostalCode, String Phone, String Email){
        this.CustomerId=CustomerId;
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Country=Country;
        this.PostalCode=PostalCode;
        this.Phone=Phone;
        this.Email=Email;
    }
}
