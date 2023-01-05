package com.federated.users.dgs;

import com.federated.users.dto.user.UserLoginDTO;
import com.federated.users.dto.user.UserRequestDTO;
import com.federated.users.model.notif.Notification;
import com.federated.users.model.user.User;
import com.federated.users.service.UserService;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@DgsComponent
public class UserDataFetcher {

    @Autowired
    private UserService userService;

    @DgsEntityFetcher(name = "User")
    public User getUserById(Map<String, Object> values) {
        String id = (String) values.get("id");
        return userService.getUser(new BigInteger(id));
    }

    @DgsQuery
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @DgsQuery
    public User getUser(@InputArgument String id) {
        return userService.getUser(new BigInteger(id));
    }

    @DgsQuery(field = "getUserByUsername")
    public User getUserByUsername(@InputArgument String username) {
        return userService.getUserByUsername(username);
    }

    @DgsQuery
    public Boolean checkUserLogin(@InputArgument UserLoginDTO user) {
        return userService.checkUserLogin(user);
    }

    @DgsMutation
    public User insertUser(@Argument UserRequestDTO input) {
        return userService.insertUser(input);
    }

    @DgsMutation
    public User updateUser(@Argument UserRequestDTO input) {
        return userService.updateUser(input);
    }

    @DgsData(parentType = "Notification", field = "user")
    public User user (DgsDataFetchingEnvironment dfe) {
        Notification notification = dfe.getSource();
        return userService.getUser(notification.getUserId());
    }

}
