package com.restapi.user.customRepo;

import com.restapi.user.entity.User;

import java.util.List;

public interface UserRepositoryCustom {
   List<User> getUsersByDepartment_Id(int id);
   List<User> findByDepartmentId(int department_id);
}
