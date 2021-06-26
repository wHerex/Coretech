package com.wherex.coretech;

import com.wherex.coretech.User.User;

public class Callback {

    private User user;

    private Status status;

    public Callback(User user, Status status) {
        this.user = user;
        this.status = status;
    }

    public Callback(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
