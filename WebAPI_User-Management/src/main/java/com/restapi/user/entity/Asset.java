package com.restapi.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "assets")
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Asset {
    @Id
    @Column(name = "asset_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Column(name = "asset_name", length = 50)
    private String assetName;
    @OneToMany(mappedBy = "asset")
    private List<Assignment> assignments;

    public Asset(String assetName) {
        this.assetName = assetName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

}
