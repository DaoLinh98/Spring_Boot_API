package com.restapi.user.controller;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.modelRequest.UserRequest;
import com.restapi.user.modelResponse.UserResponse;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import com.restapi.user.service.UserService;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/users")
@ToString()

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAll() {

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
    // @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('MODERATOR') ")
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
