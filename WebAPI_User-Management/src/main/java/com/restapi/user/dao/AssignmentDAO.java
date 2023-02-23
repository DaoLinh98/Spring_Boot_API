package com.restapi.user.dao;

import com.restapi.user.entity.*;
import com.restapi.user.modelResponse.AssetResponse;
import com.restapi.user.modelResponse.AssignmentResponse;
import com.restapi.user.modelResponse.UserResponse;
import com.restapi.user.repository.AssetRepository;
import com.restapi.user.repository.AssignmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentDAO {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssetRepository assetRepository;

   public AssetResponse findAssetByIdWithUsers(int asset_id){
       List<Assignment> a = this.assignmentRepository.findAssetByIdWithUsers(asset_id);
       AssetResponse assetResponse = new AssetResponse();
       assetResponse.setId(a.get(0).getAsset().getId());
       assetResponse.setAssetName(a.get(0).getAsset().getAssetName());
       List<UserResponse> listUserResponse = new ArrayList();
     for (Assignment ag :a){
         UserResponse userResponse = new UserResponse();
         userResponse.setUserName(ag.getUser().getUserName());
         userResponse.setDepartment_id(ag.getUser().getDepartment().getId());
         userResponse.setPassWord(ag.getUser().getPassWord());
         userResponse.setDateOfBirth(ag.getUser().getDayOfBirth());
         userResponse.setId(ag.getUser().getId());
         listUserResponse.add(userResponse);
     }
       assetResponse.setUserResponses(listUserResponse);
       return assetResponse;
   }
}
