package com.wherex.coretech.User;

public class User {

    private String login;

    private String password;

    private String privilege;

    public User(String login, String password, String privilege) {
        this.login = login;
        this.password = password;
        this.privilege = privilege;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object obj) {
        User usr = (User)obj;
        if(password.equals(usr.getPassword()) && login.equals(usr.getLogin()))
            return true;
        return false;
    }
}
