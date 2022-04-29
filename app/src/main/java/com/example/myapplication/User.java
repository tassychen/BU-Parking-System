package com.example.myapplication;

public class User {

    public String permit;
    public String usertype;
    public Vehicle vehicle;
    public Boolean parked;

    public User(String usertype, String permit){
        this.usertype = usertype;
        this.permit = permit;
        this.parked = false;
    }

    public String getPermit() {
        return permit;
    }
    public String getUserType() {
        return usertype;
    }
    public void setPermit(String permit) {
        this.permit = permit;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
