package com.restapi.user.model;

import com.restapi.user.entity.Asset;
import com.restapi.user.entity.Department;

import java.util.Date;
import java.util.List;

public class UserModel {
    int id;
    String userName;
    String passWord;
    String fullName;
    Date dateOfBirth;
    Department department;
    List<Asset> assets;
}
