package com.restapi.user.service;

import com.restapi.user.entity.Asset;
import com.restapi.user.entity.Assignment;
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


    public Optional<Assignment> getById(int id) {

       return this.assignmentRepository.findById(id);
    }

    public Assignment createAssignment(Assignment assignment) {

        User x = userRepository.findById(assignment.getUser().getId()).get();
        Asset y = assetRepository.findById(assignment.getUser().getId()).get();
        Assignment t = new Assignment(assignment.getStatus(), x, y);
        return assignmentRepository.save(t);
    }


}
