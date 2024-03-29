package com.restapi.user.entity;

import java.io.Serializable;
import java.util.Objects;

public class AssignmentKey implements Serializable {
    private int id;
    private Asset asset;
    private User user;
    //override hashCode()


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssignmentKey)) return false;
        AssignmentKey that = (AssignmentKey) o;
        return getId() == that.getId() && getAsset().equals(that.getAsset()) && getUser().equals(that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAsset(), getUser());
    }
}
