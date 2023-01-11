//package com.restapi.user.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.restapi.user.repository.AssignmentPK;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import javax.persistence.*;
//
//@Entity
//@Table(name="assignments")
//@Data
//@IdClass(AssignmentPK.class)
//@JsonIgnoreProperties(ignoreUnknown = true)
//@AllArgsConstructor
//@NoArgsConstructor
//public class Assignment {
//    @Id
//    @Column(name = "assignment_id")
//    private int id;
//    @Id
//    @ManyToOne()
//    @JoinColumn(name="asset_id")
//    private Asset asset;
//    @Id
//    @ManyToOne()
//    @JoinColumn(name="user_id")
//    private User user;
//    private String status;
//
//
//}
