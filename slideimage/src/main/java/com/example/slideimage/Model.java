package com.example.slideimage;

public class Model {
    int pic;

    public Model(int pic) {
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Model{" +
                "pic=" + pic +
                '}';
    }
}
