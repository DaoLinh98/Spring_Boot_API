package com.restapi.user.repository;

import com.restapi.user.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
    @Query("SELECT '*' FROM Assignment ass LEFT JOIN Asset a ON ass.asset.id = a.id LEFT JOIN User u ON ass.user.id = u.id WHERE a.id = :asset_id")
    List<Object[]> findAssetByIdWithUsers(@Param("asset_id") int asset_id);
}
