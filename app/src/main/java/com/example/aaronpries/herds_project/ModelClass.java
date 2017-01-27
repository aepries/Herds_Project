package com.example.aaronpries.herds_project;

/**
 * Created by aaronpries on 1/18/17.
 */

public class ModelClass {
    String title,image, name, bio;

    public ModelClass(String image, String title, String name, String bio) {
        this.image = image;
        this.title = title;
        this.name = name;
        this.bio = bio;
    }

    public ModelClass() {
    }



    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public String getBio() {
        return bio;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
}
