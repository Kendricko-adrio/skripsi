package com.skripsi.userskripsi.service;

import com.skripsi.userskripsi.model.Role;
import com.skripsi.userskripsi.repository.RoleRepository;
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
