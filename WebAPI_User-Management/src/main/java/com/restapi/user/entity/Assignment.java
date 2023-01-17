package com.restapi.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restapi.user.repository.AssignmentPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="assignments")
@Data
@IdClass(AssignmentPK.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id
    @Column(name = "assignment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asset_id",nullable = false,referencedColumnName = "asset_id")
    private Asset asset;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false,referencedColumnName = "user_id")
    private User user;
    private String status;


    public Assignment(String status, User user, Asset asset) {
        this.status = status;
       this.user = user;
       this.asset = asset;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
