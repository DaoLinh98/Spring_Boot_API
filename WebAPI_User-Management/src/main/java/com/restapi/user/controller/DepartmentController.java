package com.restapi.user.controller;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.model.DeppartmentModel;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.service.DepartmentService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private List<User> users = new ArrayList<User>();

    @Transactional
    @GetMapping()
    public List<Department> getAll() {
        return this.departmentService.getAll();
    }
    @GetMapping("/addAlluser")
    public List<DeppartmentModel> getAllWithUser() {
        return this.departmentService.getAllWithUsers();
    }
    @PostMapping()
    public Department createDepartment(@RequestBody Department department) {
        return this.departmentService.createDepartment(department);
    }


}