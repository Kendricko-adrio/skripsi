package com.skripsi.monolith.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skripsi.monolith.dto.UserRequestDTO;
import com.skripsi.monolith.model.User;
import com.skripsi.monolith.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(BigInteger id){
        return userRepository.findById(id).get();
    }

    public User getUserByUsername(String username){
        return userRepository.findFirstByUsername(username).get();
    }

    public User insertUser(UserRequestDTO user){
        log.info(user.getUsername());
        ObjectMapper mapper = new ObjectMapper();
        User users = mapper.convertValue(user, User.class);
        return userRepository.save(users);
    }

}
