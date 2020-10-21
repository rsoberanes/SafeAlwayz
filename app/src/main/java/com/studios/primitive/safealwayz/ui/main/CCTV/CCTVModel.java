package com.studios.primitive.safealwayz.ui.main.CCTV;

public class CCTVModel {

    //variables
    private int id;
    private String cameraName;

    //Constructor
    public CCTVModel(String cameraName) {
        this.cameraName = cameraName;
        this.id = id;
    }

    public CCTVModel(){

    }

    //toString
    @Override
    public String toString() {
        return "AccountModel{" +
                "userName='" + cameraName + '\'' +
                '}';
    }


    //Getter and Setters


    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String userName) {
        this.cameraName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
