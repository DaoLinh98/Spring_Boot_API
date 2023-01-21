package com.restapi.user.dao;


import com.restapi.user.entity.Department;
import com.restapi.user.model.DeppartmentModel;
import com.restapi.user.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentDAO {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DepartmentRepository departmentRepository;

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
            deppartmentModel.users = userDAO.getUsersByDepartment_Id(id) ;
            deppartmentModels.add(deppartmentModel);
        }
        return deppartmentModels;
    }

    public Department createDepartment(Department department) {
        return this.departmentRepository.saveAndFlush(department);
    }

}
