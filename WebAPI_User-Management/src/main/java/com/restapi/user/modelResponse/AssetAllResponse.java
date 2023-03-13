package com.restapi.user.modelResponse;

public class AssetAllResponse {
    private int id;

    private String assetName;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public AssetAllResponse(int id, String assetName) {
        this.id = id;
        this.assetName = assetName;
    }
}
