package com.restapi.user.service;



import com.restapi.user.entity.ERole;
import com.restapi.user.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(ERole roleName);
}