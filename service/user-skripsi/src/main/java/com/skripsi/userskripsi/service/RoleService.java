package com.skripsi.monolith.service.user;

import com.skripsi.monolith.model.user.Role;
import com.skripsi.monolith.repository.user.RoleRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class RoleService {

  private final RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public List<Role> getRoles() {
    return roleRepository.findAll();
  }

  public Role getRole(BigInteger id) {
    return roleRepository.findById(id).orElse(null);
  }
}
