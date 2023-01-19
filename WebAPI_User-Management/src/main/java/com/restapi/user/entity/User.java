package com.restapi.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="users")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;
    @Column(name = "password", nullable = false, length = 50)
    private String passWord;
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

   @JsonFormat(pattern="yyyy-MM-dd")
   @Column(name = "day_of_birth", nullable = true)
   private Date dayOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id",nullable = false,referencedColumnName = "department_id")
    private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User(String userName, String passWord, String fullName, Date dayOfBirth, Department department) {
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.dayOfBirth = dayOfBirth;
        this.department = department;
    }

}
