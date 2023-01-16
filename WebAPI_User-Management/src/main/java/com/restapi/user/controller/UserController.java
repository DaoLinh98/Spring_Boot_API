package com.restapi.user.controller;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import com.restapi.user.service.UserService;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("api/v1/users")
@ToString()

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping()
     public List<User> getAll() {

        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Integer id) {
       return  this.userService.getById(id);
    }

    @PostMapping()
        public User createUesr(@RequestBody User user) {
        return userService.createUesr(user);
    }


    @PutMapping("{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return this.userService.updateUser(id, user);
    }
    @DeleteMapping("{id}")
    public Void deleteUser(@PathVariable Integer id) {
         this.userService.deleteUser(id);
         return null;
    }
}
