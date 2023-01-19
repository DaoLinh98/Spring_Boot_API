package com.restapi.user.service;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.model.DeppartmentModel;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import com.restapi.user.repository.UserRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentService {
    @Autowired
    private UserRepositoryImp userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentService(UserRepositoryImp userRepository, DepartmentRepository departmentRepository) {
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
            int id = department.getId();
            deppartmentModel.id = department.getId();
            deppartmentModel.departmentName = department.getDepartmentName();
            deppartmentModel.users = userRepository.getUsersByDepartment_Id(id);
            deppartmentModels.add(deppartmentModel);
        }
        return deppartmentModels;
    }

    public Department createDepartment(Department department) {
        return this.departmentRepository.saveAndFlush(department);
    }

}
