package com.restapi.user.model;

import com.restapi.user.entity.User;

import java.util.List;

public class UserResponse {
    private List<User> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
