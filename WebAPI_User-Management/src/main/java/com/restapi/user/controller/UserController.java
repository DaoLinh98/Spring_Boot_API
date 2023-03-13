package com.restapi.user.controller;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.modelRequest.UserRequest;
import com.restapi.user.modelResponse.UserResponse;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import com.restapi.user.service.UserService;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/users")
@ToString()
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;
    // creating a logger

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAll() {
        // Logging various log level messages
        logger.info("Getting item with id ");

        List<UserResponse> userResponses = userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(userResponses);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<UserResponse>> pagingAndSortUser(
            @RequestParam(value = "page", defaultValue = "1") int pageNo,
            @RequestParam(value = "size", defaultValue = "2") int pageSize,
            @RequestParam(value = "sort", defaultValue = "userName") String[] sortingParams,
            @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder
    ) {
        List<UserResponse> users = userService.pagingAndSortUser(pageNo, pageSize, sortingParams, sortOrder);

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("{id}")
    @PreAuthorize(" hasRole('ADMIN')")
    public ResponseEntity<UserResponse> getById(@PathVariable Integer id) {
        UserResponse userResponse = this.userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PostMapping()
    public ResponseEntity<String> createUesr(@RequestBody UserRequest request) {
        this.userService.createUesr(request);
        return ResponseEntity.status(HttpStatus.OK).body("Insert Success!");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserRequest request) {
        this.userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Data!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        this.userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Data!");
    }
}
