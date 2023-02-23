package com.restapi.user.modelRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.restapi.user.entity.Department;
import java.util.Date;
public class UserRequest {
    private String userName;
    private String passWord;
    private String fullName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    private Department department;

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

    public Department getDepartment() {
        return department;
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

    public void setDepartment(Department department) {
        this.department = department;
    }
}
