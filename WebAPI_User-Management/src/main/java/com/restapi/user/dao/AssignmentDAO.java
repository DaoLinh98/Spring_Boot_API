package com.restapi.user.dao;

import com.restapi.user.entity.*;
import com.restapi.user.model.AssignmentModel;
import com.restapi.user.repository.AssetRepository;
import com.restapi.user.repository.AssignmentRepository;
import com.restapi.user.repository.UserRepository;
import lombok.var;
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

    public Optional<Assignment> getById(AssignmentPK assignmentPK) {
        return this.assignmentRepository.findById(assignmentPK);
    }

    public List<AssignmentModel> getAll() {
        List<AssignmentModel> assignmentModels = new ArrayList<AssignmentModel>();
        List<Assignment> assignments = this.assignmentRepository.findAll();
        for (Assignment assignment : assignments)
        {
            AssignmentModel assignmentModel = new AssignmentModel();
            assignmentModel.id = assignment.getId();
            assignmentModel.status= assignment.getStatus();
            assignmentModel.asset_id = assignment.getAsset().getId();
            assignmentModel.user_id = assignment.getUser().getId();
            assignmentModels.add(assignmentModel);
        }
        return assignmentModels;
    }
}
