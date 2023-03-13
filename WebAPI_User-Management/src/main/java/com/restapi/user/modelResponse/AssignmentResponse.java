package com.restapi.user.modelResponse;

public class AssignmentResponse {
    private int id;
    private String status;
    private int asset_id;
    private int user_id;

    public AssignmentResponse() {
    }

    public AssignmentResponse(int id, String status, int asset_id, int user_id) {
        this.id = id;
        this.status = status;
        this.asset_id = asset_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
