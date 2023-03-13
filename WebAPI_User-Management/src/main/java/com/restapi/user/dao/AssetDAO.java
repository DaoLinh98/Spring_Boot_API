package com.restapi.user.dao;


import com.restapi.user.entity.Asset;
import com.restapi.user.modelRequest.AssetRequest;
import com.restapi.user.modelResponse.AssetAllResponse;
import com.restapi.user.repository.AssetRepository;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetDAO {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;

    public List<AssetAllResponse> getAll() {
       List<Asset> assets =  assetRepository.findAll();
       List<AssetAllResponse> assetAllResponses = new ArrayList<>();
       for (Asset asset : assets){
           AssetAllResponse assetAllResponse = new AssetAllResponse(asset.getId(),asset.getAssetName());
           assetAllResponses.add(assetAllResponse);
       }
       return assetAllResponses;
    }
    public void createAsset(AssetRequest request) {
        Asset asset = new Asset();
        asset.setAssetName(request.assetsName);
        assetRepository.save(asset);
    }
    public Asset updateAsset(int id, AssetRequest request) {
        Asset exitAsset = this.assetRepository.getOne(id);
        exitAsset.setAssetName(request.getAssetsName());
        return this.assetRepository.saveAndFlush(exitAsset);
    }
    public void deleteAsset(int id) {
        this.assetRepository.deleteById(id);

    }
}
