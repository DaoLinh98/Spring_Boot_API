package com.restapi.user.controller;

import com.restapi.user.entity.Asset;
import com.restapi.user.modelRequest.AssetRequest;
import com.restapi.user.modelResponse.AssetAllResponse;
import com.restapi.user.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/assets")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @GetMapping()
    public ResponseEntity<List<AssetAllResponse>> getAll() {
        List<AssetAllResponse> assetAllResponses = this.assetService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(assetAllResponses);
    }

    @PostMapping()
    public ResponseEntity<String> createAsset(@RequestBody AssetRequest request) {
        this.assetService.createAsset(request);
        return ResponseEntity.status(HttpStatus.OK).body("Insert Success!");
    }

    @PutMapping("{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable Integer id, @RequestBody AssetRequest request) {
        Asset asset = this.assetService.updateAsset(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(asset);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable Integer id) {
        this.assetService.deleteAsset(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
    }

}
