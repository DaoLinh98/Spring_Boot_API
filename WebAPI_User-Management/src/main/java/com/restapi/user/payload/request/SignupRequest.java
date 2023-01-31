package com.restapi.user.payload.request;

import java.util.Set;

public class SignupRequest {
    private String userName;
    private String passWord;
    private boolean isActive = true;
    private Set<String> listRole ;

    public SignupRequest(String userName, String passWord, boolean isActive, Set<String> listRole) {
        this.userName = userName;
        this.passWord = passWord;
        this.isActive = isActive;
        this.listRole = listRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<String> getListRole() {
        return listRole;
    }

    public void setListRole(Set<String> listRole) {
        this.listRole = listRole;
    }
}
