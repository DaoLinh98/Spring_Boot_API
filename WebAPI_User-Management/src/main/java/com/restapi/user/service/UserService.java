package com.restapi.user.service;

import com.restapi.user.dao.UserDAO;
import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    public List<User> getAll() {
        return this.userDAO.getAll();
    }

    public User getById(int id) {

        return this.userDAO.getById(id);
    }

    public User createUesr(User user) {

        return this.userDAO.createUesr(user);
    }
    public User updateUser(int id, User user) {

        return this.userDAO.updateUser(id, user);
    }

    public void deleteUser(int id) {
        this.userDAO.deleteUser(id);
    }

    // order by 'published' column - ascending
    public List<User> pagingAndSortUser(Integer pageNo, Integer pageSize, String[] sortingParams)
    {
        return this.userDAO.pagingAndSortUser(pageNo, pageSize, sortingParams);
    }

}
