package com.kristian.fi.models;

public class CustomerInCountry{
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    private String total;

    public CustomerInCountry(String country,String total){
        this.country=country;
        this.total=total;
    }

}
