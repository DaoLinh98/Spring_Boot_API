//package com.restapi.user.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name="assets")
//@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
//@AllArgsConstructor
//@NoArgsConstructor
//public class Asset {
//    @Id
//    @Column(name = "asset_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "asset_name", length = 50)
//    private String departmentName;
//
//    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Assignment> assignments;
//    //@Temporal(TemporalType.DATE)
//}
