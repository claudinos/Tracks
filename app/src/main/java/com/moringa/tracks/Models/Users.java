package com.moringa.tracks.Models;

public class Users {
    private String Name;
    private String Status;

    public Users() {
        super();
    }
    public Users(String name,String status){
        Name=name;
        Status=status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
