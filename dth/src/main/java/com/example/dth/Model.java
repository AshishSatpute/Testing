package com.example.dth;

public class Model {
    String one, two;

    public Model() {
    }


    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }


    @Override
    public String toString() {
        return "Model{" +
                "one='" + one + '\'' +
                ", two='" + two + '\'' +
                '}';
    }
}
