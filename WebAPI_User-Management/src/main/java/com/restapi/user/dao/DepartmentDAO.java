package com.restapi.user.dao;
import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.modelRequest.DepartmentRequest;
import com.restapi.user.modelResponse.DepartmentResponse;
import com.restapi.user.modelResponse.UserResponse;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    public void createDepartment(DepartmentRequest request) {
        Department department = new Department();
        department.setDepartmentName(request.getDepartmentName());
        departmentRepository.save(department);
    }

    public List<DepartmentResponse> getAll() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponse> departmentResponses = new ArrayList<>();
        for (Department department : departments) {
            DepartmentResponse departmentResponse = new DepartmentResponse();
            departmentResponse.setDepartmentName(department.getDepartmentName());
            departmentResponse.setId(department.getId());
            List<User> users = userRepository.findUsersByDepartment_Id(department.getId());
            List<UserResponse> userResponses = new ArrayList<>();
            for (User user : users) {
                UserResponse userResponse = new UserResponse();
                userResponse.setId(user.getId());
                userResponse.setUserName(user.getUserName());
                userResponse.setPassWord(user.getPassWord());
                userResponse.setFullName(user.getFullName());
                userResponse.setDateOfBirth(user.getDayOfBirth());
                userResponse.setDepartment_id(user.getDepartment().getId());

                userResponses.add(userResponse);
            }
            departmentResponse.setUsers(userResponses);
            departmentResponses.add(departmentResponse);
        }
        return departmentResponses;
    }

}
