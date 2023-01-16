package com.restapi.user.controller;

import com.restapi.user.entity.Asset;
import com.restapi.user.entity.Assignment;
import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.repository.AssetRepository;
import com.restapi.user.repository.AssignmentRepository;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import com.restapi.user.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssetRepository assetRepository;


    @GetMapping("{id}")
    public Assignment getById(@PathVariable Integer id) {
        return this.assignmentService.getById(id);
    }


    @PostMapping()
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return this.assignmentService.createAssignment(assignment);
    }
}
