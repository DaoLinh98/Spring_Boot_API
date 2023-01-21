package com.restapi.user.repository.customRepo;

import com.restapi.user.entity.User;

import java.util.List;

public interface UserRepositoryCustom {
   List<User> getUsersByDepartment_Id(int id);
}
