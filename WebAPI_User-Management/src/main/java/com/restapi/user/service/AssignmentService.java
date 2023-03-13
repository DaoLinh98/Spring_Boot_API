package com.restapi.user.service;

import com.restapi.user.dao.AssignmentDAO;
import com.restapi.user.entity.Assignment;
import com.restapi.user.modelResponse.AssetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentDAO assignmentDAO ;
    public AssetResponse findAssetByIdWithUsers(int asset_id){
        return assignmentDAO.findAssetByIdWithUsers(asset_id);
    }


}
