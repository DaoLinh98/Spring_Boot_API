package com.restapi.user.dao;


import com.restapi.user.entity.Asset;
import com.restapi.user.model.AssetModel;
import com.restapi.user.repository.AssetRepository;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetDAO {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;
    public AssetModel getById(int id) {
        Asset asset = this.assetRepository.getById(id);
        AssetModel assetModel = new AssetModel();
        assetModel.id = asset.getId();
        assetModel.assetsName = asset.getAssetName();
        assetModel.users = userRepository.getUsersByDepartment_Id(id);
        return assetModel;
    }
    public Asset createAsset(Asset asset) {
        return this.assetRepository.saveAndFlush(asset);
    }
}
