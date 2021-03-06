package com.example.sqlitedb;

public class AddDataModel {

    private String name;
    private String password;

    public AddDataModel(){

    }

    public AddDataModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AddDataModel{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}