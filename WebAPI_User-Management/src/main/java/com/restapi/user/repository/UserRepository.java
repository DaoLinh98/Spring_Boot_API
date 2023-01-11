package com.restapi.user.repository;
import com.restapi.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //List<User> findByTutorialId(int postId);
   // void deleteByTutorialId(long departmentId);
}
