package com.restapi.user.modelResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restapi.user.entity.Department;

import java.util.Date;

public class UserResponse {
    private int id;
    private String userName;
    private String passWord;
    private String fullName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    private int department_id;
    public UserResponse() {
    }

    public UserResponse(int id, String userName, String passWord, String fullName, Date dateOfBirth, int department_id) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.department_id = department_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getDepartment_id() {
        return department_id;
    }
}
