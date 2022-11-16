package com.skripsi.monolith.controller.role;

import com.skripsi.monolith.model.role.Role;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.role.RoleService;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {

  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @SchemaMapping
  public Role role(User user) {
    return roleService.getRole(user.getRole().getId());
  }

}
