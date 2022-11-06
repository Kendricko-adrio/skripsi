package com.skripsi.monolith.service.user;

import com.skripsi.monolith.model.user.Role;
import com.skripsi.monolith.repository.user.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Slf4j
@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role role(BigInteger id){
        Role role = roleRepository.findById(id).get();

        return role;
    }
}
