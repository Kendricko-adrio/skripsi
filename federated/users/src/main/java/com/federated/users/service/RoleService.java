package com.federated.users.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.users.model.Response;
import com.federated.users.model.user.Role;
import com.federated.users.model.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class RoleService extends ExternalBaseService{

    @Value("${external.role.url}")
    private String baseUrl;

    private ObjectMapper mapper = new ObjectMapper();

    public List<Role> getRoles(){
        Response response = hitExternalService(baseUrl, HttpMethod.GET, null,null, Response.class);
        System.out.println(response.getData());
        List<Role> roles = mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, Role.class));
        return roles;
    }

    public Role getRole(BigInteger id){
        Response response = hitExternalService(baseUrl + "/" + id, HttpMethod.GET, null,null, Response.class);
        Role role = mapper.convertValue(response.getData(), Role.class);
        return role;
    }
}
