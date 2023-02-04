package com.restapi.user.service;

import com.restapi.user.dao.DepartmentDAO;
import com.restapi.user.dao.UserDAO;
import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.model.DeppartmentModel;
import com.restapi.user.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Department> getAll() {
        return this.departmentDAO.getAll();
    }
    public List<DeppartmentModel> getAllWithUsers() {
        return this.departmentDAO.getAllWithUsers();
    }
    public Department createDepartment(Department department) {
        return this.departmentDAO.createDepartment(department);
    }

    public Department updateDepart(int id, Department department) {
        return this.departmentDAO.updateDepart(id, department);
    }
    public void deleteDepart(int id) {
        this.departmentDAO.deleteDepart(id);
    }

}
