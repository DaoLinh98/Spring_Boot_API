package com.restapi.user.model;

import com.restapi.user.entity.User;

import javax.persistence.Column;
import java.util.List;

public class DeppartmentModel {
    public int id;
    public String departmentName;
    public List<User> users;
}
