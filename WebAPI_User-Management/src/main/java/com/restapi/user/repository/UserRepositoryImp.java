package com.restapi.user.repository;

import com.restapi.user.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepositoryCustom {
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
    



//    @Override
//    public List<User> getUserBYAsset_id(int id) {
//        return null;
//    }
}
