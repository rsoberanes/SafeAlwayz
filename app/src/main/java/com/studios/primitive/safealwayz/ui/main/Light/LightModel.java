package com.studios.primitive.safealwayz.ui.main.Light;
import com.studios.primitive.safealwayz.ui.main.Account.AccountModel;

public class LightModel {
    int lightID;
    String location;
    String username;
    boolean active;
    int timer;
    AccountModel account;

    LightModel(String loc, AccountModel acc){
        this.account = acc;
        this.location = loc;
        this.active = false;
        this.username = account.getUserName();

    }
    LightModel(String user){
        this.username = user;


    }
    LightModel(int id){
        this.lightID = id;
    }
    @Override
    public String toString() {
        return "Light{" +
                "LightID='" + lightID + '\'' +
                ", Location='" + location + '\'' +
                ", Status='" + active + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLightID() {
        return lightID;
    }

    public void setLightID(int lightID) {
        this.lightID = lightID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
