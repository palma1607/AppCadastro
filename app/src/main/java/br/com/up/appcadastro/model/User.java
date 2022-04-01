package br.com.up.appcadastro.model;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String surName;
    private String phone;

    public User(String firstName, String surName, String phone) {
        this.firstName = firstName;
        this.surName = surName;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
