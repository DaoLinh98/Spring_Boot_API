package com.restapi.user.service;

import com.restapi.user.entity.Department;
import com.restapi.user.model.DeppartmentModel;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    public DepartmentService(UserRepository userRepository, DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }
    public List<DeppartmentModel> getAllWithUsers() {
        List<Department> departments = this.departmentRepository.findAll();
        List<DeppartmentModel> deppartmentModels = new ArrayList<DeppartmentModel>();
        for (Department department : departments) {
            DeppartmentModel deppartmentModel = new DeppartmentModel();
            deppartmentModel.departmentName = department.getDepartmentName();
            deppartmentModel.users = this.userRepository.findAll();
            deppartmentModels.add(deppartmentModel);
        }
        return deppartmentModels;
    }

    public Department createDepartment(Department department) {
        return this.departmentRepository.saveAndFlush(department);
    }

}
