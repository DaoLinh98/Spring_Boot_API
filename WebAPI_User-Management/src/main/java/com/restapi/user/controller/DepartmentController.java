package com.restapi.user.controller;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.modelRequest.DepartmentRequest;
import com.restapi.user.modelResponse.DepartmentResponse;
import com.restapi.user.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public ResponseEntity<List<DepartmentResponse>> getAll() {

        List<DepartmentResponse> departmentResponses = this.departmentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(departmentResponses);
    }

    @PostMapping()
    public ResponseEntity<String> createDepartment(@RequestBody DepartmentRequest request) {
        this.departmentService.createDepartment(request);
        return ResponseEntity.status(HttpStatus.OK).body("Insert Success!");
    }
}
