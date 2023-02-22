package com.restapi.user.controller;

import com.restapi.user.entity.Asset;
import com.restapi.user.entity.User;
import com.restapi.user.model.AssetModel;
import com.restapi.user.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/assets")
public class AssetController {
    @Autowired
    private AssetService assetService;
    @GetMapping()
    public List<Asset> getAll() {
       return this.assetService.getAll();
    }
    @PostMapping()
    public void createAsset(@RequestBody AssetModel assetModel) {
        assetService.createAsset(assetModel);
    }

    @PutMapping("{id}")
    public Asset updateAsset(@PathVariable Integer id, @RequestBody Asset asset) {
        return this.assetService.updateAsset(id, asset);
    }
    @DeleteMapping("{id}")
    public Void deleteAsset(@PathVariable Integer id) {
        this.assetService.deleteAsset(id);
        return null;
    }

}
