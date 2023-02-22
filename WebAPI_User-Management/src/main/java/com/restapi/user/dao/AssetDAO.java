package com.restapi.user.dao;


import com.restapi.user.entity.Asset;
import com.restapi.user.entity.User;
import com.restapi.user.model.AssetModel;
import com.restapi.user.repository.AssetRepository;
import com.restapi.user.repository.DepartmentRepository;
import com.restapi.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetDAO {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Asset> getAll() {
        return assetRepository.findAll();
    }

    public void createAsset(AssetModel assetModel) {

        Asset asset = new Asset();
        asset.setAssetName(assetModel.assetsName);
        assetRepository.save(asset);
    }
    public Asset updateAsset(int id, Asset asset) {
        Asset exitAsset = this.assetRepository.getOne(id);
        BeanUtils.copyProperties(asset, exitAsset, "id");
        return this.assetRepository.saveAndFlush(exitAsset);
    }
    public void deleteAsset(int id) {
        this.assetRepository.deleteById(id);
    }
}
