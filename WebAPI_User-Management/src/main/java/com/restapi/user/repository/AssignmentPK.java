//package com.restapi.user.repository;
//
//import com.restapi.user.entity.Asset;
//import com.restapi.user.entity.User;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//public class AssignmentPK implements Serializable {
//    private int id;
//    private Asset asset;
//    private User user;
//    //override hashCode()
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Asset getAsset() {
//        return asset;
//    }
//
//    public void setAsset(Asset asset) {
//        this.asset = asset;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof AssignmentPK)) return false;
//        AssignmentPK that = (AssignmentPK) o;
//        return getId() == that.getId() && getAsset().equals(that.getAsset()) && getUser().equals(that.getUser());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getAsset(), getUser());
//    }
//}
