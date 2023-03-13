package com.restapi.user.repository;

import com.restapi.user.entity.Assignment;
import com.restapi.user.entity.AssignmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    @Query("SELECT ass FROM Assignment ass LEFT JOIN Asset a ON ass.asset.id = a.id LEFT JOIN User u ON ass.user.id = u.id WHERE a.id = :asset_id")
    List<Assignment> findAssetByIdWithUsers(@Param("asset_id") int asset_id);
}
