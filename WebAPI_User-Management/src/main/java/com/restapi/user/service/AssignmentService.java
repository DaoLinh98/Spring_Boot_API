package com.restapi.user.service;

import com.restapi.user.dao.AssignmentDAO;
import com.restapi.user.entity.Asset;
import com.restapi.user.entity.Assignment;
import com.restapi.user.entity.AssignmentPK;
import com.restapi.user.entity.User;
import com.restapi.user.model.AssignmentModel;
import com.restapi.user.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentDAO assignmentDAO ;
    public Optional<Assignment> getById(AssignmentPK assignmentPK) {
       return this.assignmentDAO.getById(assignmentPK);
    }
    public List<AssignmentModel> getAll() {
        return this.assignmentDAO.getAll();
    }


}
