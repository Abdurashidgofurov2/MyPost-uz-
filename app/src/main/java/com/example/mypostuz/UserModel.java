package com.example.mypostuz;

public class UserModel {
    String name,number,id,image,email,qoshimcha;
    public UserModel(){

    }

    public UserModel(String name, String number, String id, String image, String email, String qoshimcha) {
        this.name = name;
        this.number = number;
        this.id = id;
        this.image = image;
        this.email = email;
        this.qoshimcha = qoshimcha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQoshimcha() {
        return qoshimcha;
    }

    public void setQoshimcha(String qoshimcha) {
        this.qoshimcha = qoshimcha;
    }
}
