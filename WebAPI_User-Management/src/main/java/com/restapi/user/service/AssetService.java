package com.restapi.user.service;

import com.restapi.user.dao.AssetDAO;
import com.restapi.user.entity.Asset;
import com.restapi.user.modelRequest.AssetRequest;
import com.restapi.user.modelResponse.AssetAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetDAO assetDAO;

    public List<AssetAllResponse> getAll() {
        return this.assetDAO.getAll();
    }
    public void createAsset(AssetRequest request) {
      assetDAO.createAsset(request);
    }
    public Asset updateAsset(int id, AssetRequest request) {
        return this.assetDAO.updateAsset(id, request);
    }
    public void deleteAsset(int id) {
        this.assetDAO.deleteAsset(id);
    }
}
