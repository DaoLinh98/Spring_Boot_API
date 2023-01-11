package com.restapi.user.service;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User createUesr( User user) {
        Department d = departmentRepository.findById(user.getDepartment().getId()).get();
       User t = new User(user.getUserName(), user.getPassWord(), user.getFullName(), user.getDayOfBirth(), d);
       return userRepository.save(t);
    }

    public UserService(UserRepository userRepository, DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }
}
