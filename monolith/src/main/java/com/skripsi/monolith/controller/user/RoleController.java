package com.skripsi.monolith.controller.user;

import com.skripsi.monolith.model.user.Role;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RoleController {

  @Autowired
  private RoleService roleService;

  @QueryMapping
  public List<Role> getRoles(){
    return roleService.getRoles();
  }

  @SchemaMapping
  public Role role(User user) {
    return roleService.getRole(user.getRole().getId());
  }

}
