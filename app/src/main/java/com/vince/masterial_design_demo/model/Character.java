package com.vince.masterial_design_demo.model;

/**
 * Created by Administrator on 2017/3/19.
 */

public class Character {
    private String name;
    private int imageId;

    public Character(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
