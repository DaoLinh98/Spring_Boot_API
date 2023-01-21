package com.restapi.user.service;

import com.restapi.user.dao.AssetDAO;
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
    private AssetDAO assetDAO;

    public AssetModel getById(int id) {
        return this.assetDAO.getById(id);
    }
    public Asset createAsset(Asset asset) {
        return this.assetDAO.createAsset(asset);
    }

}
