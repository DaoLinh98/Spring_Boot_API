package com.restapi.user.controller;

import com.restapi.user.entity.Assignment;
import com.restapi.user.modelResponse.AssetResponse;
import com.restapi.user.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;


    @GetMapping("{id}")
    public ResponseEntity<AssetResponse> findAssetByIdWithUsers(@PathVariable Integer id) {
        AssetResponse assetResponse =  this.assignmentService.findAssetByIdWithUsers(id);
        return  ResponseEntity.status(HttpStatus.OK).body(assetResponse);
    }
}
