package com.restapi.user.modelResponse;

import java.util.List;

public class DepartmentResponse {

    private int id;

    private String departmentName;

    private List<UserResponse> users;

    public DepartmentResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }

    public DepartmentResponse(int id, String departmentName, List<UserResponse> users) {
        this.id = id;
        this.departmentName = departmentName;
        this.users = users;
    }
}
