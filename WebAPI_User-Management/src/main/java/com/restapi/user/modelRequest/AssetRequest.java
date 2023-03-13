package com.restapi.user.modelRequest;


//public class AssetViewModel {
//    public int id;
//    public String assetsName;
//    public List<User> users;
//}

public class AssetRequest {
    public String assetsName;

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }
}
