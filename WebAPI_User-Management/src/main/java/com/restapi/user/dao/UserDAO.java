package com.restapi.user.dao;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.modelRequest.UserRequest;
import com.restapi.user.modelResponse.DepartmentResponse;
import com.restapi.user.modelResponse.UserResponse;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import com.restapi.user.customRepo.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PersistenceContext
public class UserDAO implements UserRepositoryCustom {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<User> findByDepartmentId(int department_id) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.department.id = :department_id", User.class);
        query.setParameter("department_id", department_id);
        List<User> users = query.getResultList();
        return users;
    }

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getUsersByDepartment_Id(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(user.get("department").get("id"), id));
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }

    public void createUesr(UserRequest request) {
        Department getDepartment = departmentRepository.findById(request.getDepartment().getId()).get();
        User user = new User(request.getUserName(), request.getPassWord(), request.getFullName(), request.getDateOfBirth(), getDepartment);
        userRepository.save(user);
    }

    public List<UserResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setUserName(user.getUserName());
            response.setPassWord(user.getPassWord());
            response.setDateOfBirth(user.getDayOfBirth());
            response.setDepartment_id(user.getDepartment().getId());
            userResponses.add(response);
        }
        return userResponses;
    }

    public UserResponse getById(int id) {
        User user = this.userRepository.findById(id).get();
        return new UserResponse(user.getId(), user.getUserName(), user.getPassWord(), user.getFullName(), user.getDayOfBirth(), user.getDepartment().getId());
    }

    public void updateUser(int id, UserRequest request) {
        User user = this.userRepository.findById(id).get();
        if(user != null){
            user.setUserName(request.getUserName());
            user.setPassWord(request.getPassWord());
            user.setFullName(request.getFullName());
            user.setDayOfBirth(request.getDateOfBirth());
            user.setDepartment(request.getDepartment());
            userRepository.save(user);
        }
        else {
            return;
        }
    }

    public void deleteUser(int id) {
        User user = this.userRepository.findById(id).get();
         this.userRepository.delete(user);
    }
//
//    // order by 'published' column - ascending
    public List<UserResponse> pagingAndSortUser(Integer pageNo, Integer pageSize, String[] sortingParams, String sortOrder)
    {

        Pageable pageable;
        if(sortOrder.equalsIgnoreCase("asc")){
            // Create a new PageRequest with the given parameters
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortingParams).ascending());
        }else{
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortingParams).descending());
        }

        // Retrieve a page of users using the UserRepository
        Page<User> userPage = userRepository.findAll(pageable);

        // Map the page of users to a list of UserResponse objects
        List<UserResponse> userResponses = userPage.getContent().stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getUserName(),
                        user.getPassWord(),
                        user.getFullName(),
                        user.getDayOfBirth(),
                        user.getDepartment().getId()))
                .collect(Collectors.toList());
        return userResponses;
    }

}
