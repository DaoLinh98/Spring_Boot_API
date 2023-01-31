package com.restapi.user.controller;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
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
     public List<User> getAll() {

        return userService.getAll();
    }
    @GetMapping("/sort")
    public ResponseEntity<List<User>> pagingAndSortUser(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize,
            @RequestParam(defaultValue = "id, asc") String[] sortingParams

    )

    {
        List<User> list = userService.pagingAndSortUser(pageNo, pageSize, sortingParams);

        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('MODERATOR') ")
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
