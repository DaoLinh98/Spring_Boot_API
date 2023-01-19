package com.restapi.user.service;

import com.restapi.user.entity.Asset;
import com.restapi.user.entity.Department;
import com.restapi.user.entity.User;
import com.restapi.user.model.AssetModel;
import com.restapi.user.repository.AssetRepository;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;

    public AssetService(AssetRepository assetRepository, DepartmentRepository departmentRepository, UserRepository userRepository) {
        this.assetRepository = assetRepository;
        this.departmentRepository = departmentRepository;
        this.userRepository = userRepository;
    }

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
