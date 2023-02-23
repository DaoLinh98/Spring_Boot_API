package com.restapi.user.service;

import com.restapi.user.dao.DepartmentDAO;
import com.restapi.user.dao.UserDAO;
import com.restapi.user.modelRequest.DepartmentRequest;
import com.restapi.user.modelResponse.DepartmentResponse;
import com.restapi.user.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private DepartmentRepository departmentRepository;
    public List<DepartmentResponse> getAll() {
        return this.departmentDAO.getAll();
    }
    public void createDepartment(DepartmentRequest request) {

        this.departmentDAO.createDepartment(request);
    }

}
