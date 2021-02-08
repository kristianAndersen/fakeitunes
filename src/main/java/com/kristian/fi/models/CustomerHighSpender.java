package com.kristian.fi.models;

public class CustomerHighSpender {



    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getTotalSpent() {
        return TotalSpent;
    }

    public void setTotalSpent(String totalSpent) {
        TotalSpent = totalSpent;
    }

    private String FirstName;
    private String LastName;
    private String TotalSpent;

    public CustomerHighSpender(String FirstName,String LastName, String TotalSpent){
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.TotalSpent=TotalSpent;
    }
}
