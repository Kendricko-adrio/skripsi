package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.model.user.Role;
import com.skripsi.graphqlserver.client.user.RoleClient;
import com.skripsi.graphqlserver.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RoleController {

  @Autowired
  private RoleClient roleClient;

  @QueryMapping
  public List<Role> getRoles() {
    return roleClient.getRoles().getData();
  }

  @Deprecated
  @SchemaMapping
  public Role role(User user) {
    return roleClient.getRole(user.getRole().getId()).getData();
  }

}
