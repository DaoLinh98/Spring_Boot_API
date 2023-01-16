package com.restapi.user.controller;

import com.restapi.user.entity.Asset;
import com.restapi.user.model.AssetModel;
import com.restapi.user.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/assets")
public class AssetController {
    @Autowired
    private AssetService assetService;
    @GetMapping("{id}")
    public AssetModel getById(@PathVariable Integer id) {
       return this.assetService.getById(id);
    }
    @PostMapping()
    public Asset createAsset(@RequestBody Asset asset) {
        return this.assetService.createAsset(asset);
    }

}
