package com.restapi.user.service;

import com.restapi.user.entity.Asset;
import com.restapi.user.entity.Assignment;
import com.restapi.user.entity.AssignmentPK;
import com.restapi.user.entity.User;
import com.restapi.user.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository ;
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private AssetRepository assetRepository ;


    public Optional<Assignment> getById(AssignmentPK assignmentPK) {

       return this.assignmentRepository.findById(assignmentPK);
    }

    public Assignment createAssignment(Assignment assignment) {

        User x = userRepository.findById(assignment.getUser().getId()).get();
        Asset y = assetRepository.findById(assignment.getAsset().getId()).get();
        Assignment t = new Assignment(assignment.getId() , assignment.getStatus(), x, y);
        return assignmentRepository.save(t);
    }


}
