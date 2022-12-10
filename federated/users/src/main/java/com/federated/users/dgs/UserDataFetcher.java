package com.federated.users.dgs;

import com.federated.users.model.Country;
import com.federated.users.model.Role;
import com.federated.users.model.User;
import com.netflix.graphql.dgs.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DgsComponent
public class UserDataFetcher {
    private List<User> users = new ArrayList<>();

    public UserDataFetcher() {
        users.add(new User(new BigInteger("1"), "user1", "", "", "", new Country(new BigInteger("1"), "country1"), new Role(new BigInteger("1"), "role1")));
        users.add(new User(new BigInteger("2"), "user2", "", "", "", new Country(new BigInteger("2"), "country2"), new Role(new BigInteger("2"), "role2")));
        users.add(new User(new BigInteger("3"), "user2", "", "", "", new Country(new BigInteger("2"), "country2"), new Role(new BigInteger("2"), "role2")));
    }

    @DgsEntityFetcher(name = "User")
    public User getUserById(Map<String, Object> values) {
        String id = (String) values.get("id");
        return users.stream().filter(user -> user.getId().compareTo(new BigInteger(id))== 0).findFirst().orElse(null);
    }

    @DgsQuery
    public List<User> users() {
        return users;
    }

}
