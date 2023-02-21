package com.federated.users.dgs;

import com.federated.users.model.user.Country;
import com.federated.users.model.user.Role;
import com.federated.users.model.user.User;
import com.federated.users.service.RoleService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@DgsComponent
public class RoleDataFetcher {

    @Autowired
    private RoleService roleService;

    @DgsEntityFetcher(name = "Role")
    public Role getRole(Map<String, Object> values) {
        String id = (String) values.get("id");
        return roleService.getRole(new BigInteger(id));
    }

    @DgsQuery
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
