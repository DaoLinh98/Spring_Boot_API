package com.restapi.user.repository;
import com.restapi.user.entity.User;
import com.restapi.user.repository.customRepo.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
}

