package com.restapi.user.dao;

import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import com.restapi.user.repository.customRepo.UserRepositoryCustom;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAO implements UserRepositoryCustom {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User getById(int id) {

        return this.userRepository.findById(id).get();
    }

    public User createUesr(User user) {
        Department d = departmentRepository.findById(user.getDepartment().getId()).get();
        User t = new User(user.getUserName(), user.getPassWord(), user.getFullName(), user.getDayOfBirth(), d);
        return userRepository.save(t);
    }

    public User updateUser(int id, User user) {
        User exitUser = this.userRepository.getOne(id);
        BeanUtils.copyProperties(user, exitUser, "id");
        return this.userRepository.saveAndFlush(exitUser);
    }

    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    // order by 'published' column - ascending
    public List<User> pagingAndSortUser(Integer pageNo, Integer pageSize, String[] sortingParams)

    {
        String field = sortingParams[0];
        String sortingDirection = sortingParams[1];
        Sort.Direction direction = sortingDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable paging = (Pageable) PageRequest.of(pageNo, pageSize,Sort.by(direction, field) );

        Page<User> pagedResult = userRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
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
}
