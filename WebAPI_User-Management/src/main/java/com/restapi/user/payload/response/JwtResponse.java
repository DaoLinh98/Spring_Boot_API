package com.restapi.user.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type="Bearer";
    private int id;
    private String userName;
    private List<String> listRole;

    public JwtResponse(String token, int id, String userName, List<String> listRole) {
        this.token = token;
        this.id = id;
        this.userName = userName;
        this.listRole = listRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getListRole() {
        return listRole;
    }

    public void setListRole(List<String> listRole) {
        this.listRole = listRole;
    }
}