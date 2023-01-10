package com.skripsi.userskripsi.controller;


import com.skripsi.userskripsi.constant.ResponseMessage;
import com.skripsi.userskripsi.dto.BaseResponse;
import com.skripsi.userskripsi.model.Role;
import com.skripsi.userskripsi.model.User;
import com.skripsi.userskripsi.model.response.Response;
import com.skripsi.userskripsi.service.RoleService;
import com.skripsi.userskripsi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping("/{id}")
  public Response<Role> role(@PathVariable BigInteger id) {
    return ResponseHandler.ok(roleService.getRole(id));
  }

}
