package com.restapi.user.serviceImp;


import com.restapi.user.entity.ERole;
import com.restapi.user.entity.Role;
import com.restapi.user.repository.RoleRepository;
import com.restapi.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {
@Autowired
private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
