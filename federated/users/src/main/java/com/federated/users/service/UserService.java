package com.federated.users.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.users.dto.user.UserLoginDTO;
import com.federated.users.dto.user.UserRequestDTO;
import com.federated.users.dto.user.UserRequestExternalDTO;
import com.federated.users.model.Response;
import com.federated.users.model.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserService extends ExternalBaseService {


    @Value("${external.user.url}")
    private String baseUrl;

    private ObjectMapper mapper = new ObjectMapper();

    public List<User> getUsers(){

        Response response = hitExternalService(baseUrl, HttpMethod.GET, null,null, Response.class);
        List<User> users = mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        return users;
    }

    public User getUser(BigInteger id){
        Response response = hitExternalService(baseUrl + "/" + id, HttpMethod.GET, null,null, Response.class);
        User user = mapper.convertValue(response.getData(), User.class);
        return user;
    }

    public User getUserByUsername(String username){
        Response response = hitExternalService(baseUrl + "/username/" + username, HttpMethod.GET, null,null, Response.class);
        User user = mapper.convertValue(response.getData(), User.class);
        return user;
    }

    public User insertUser(UserRequestDTO user){
        Response response = hitExternalService(baseUrl, HttpMethod.POST, mapToExternal(user),null, Response.class);
        User userDto = mapper.convertValue(response.getData(), User.class);
        return userDto;
    }

    public User updateUser(UserRequestDTO user){
        Response response = hitExternalService(baseUrl, HttpMethod.PUT, mapToExternal(user),null, Response.class);
        User userDto = mapper.convertValue(response.getData(), User.class);
        return userDto;
    }

    public Boolean checkUserLogin(UserLoginDTO user){
        Response response = hitExternalService(baseUrl + "/login", HttpMethod.POST, user,null, Response.class);
        Boolean result = mapper.convertValue(response.getData(), Boolean.class);
        return result;
    }

    private UserRequestExternalDTO mapToExternal(UserRequestDTO user){
        return UserRequestExternalDTO.builder()
                .id(user.getId() == null ? null : new BigInteger(user.getId()))
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .countryId(new BigInteger(user.getCountryId()))
                .roleId(new BigInteger(user.getRoleId()))
                .build();
    }
}
