package com.soft.demosoftunispring.entities;

public class Town {
    private String name;
    private String country;

    public Town(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Town(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
