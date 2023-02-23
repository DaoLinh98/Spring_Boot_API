package com.restapi.user.repository;
import com.restapi.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getUsersByDepartment_Id(int id);
    List<User> findByDepartmentId(int department_id);
    List<User> findUsersByDepartment_Id(int department_id);
}

