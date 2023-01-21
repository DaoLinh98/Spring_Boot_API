package com.restapi.user.dao;

import com.restapi.user.entity.Asset;
import com.restapi.user.entity.Assignment;
import com.restapi.user.entity.AssignmentPK;
import com.restapi.user.entity.User;
import com.restapi.user.repository.AssetRepository;
import com.restapi.user.repository.AssignmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignmentDAO {
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
