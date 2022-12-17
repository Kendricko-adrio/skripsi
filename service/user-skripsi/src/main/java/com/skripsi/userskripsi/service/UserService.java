package com.skripsi.userskripsi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skripsi.userskripsi.dto.UserLoginDTO;
import com.skripsi.userskripsi.dto.UserRequestDTO;
import com.skripsi.userskripsi.model.Country;
import com.skripsi.userskripsi.model.Role;
import com.skripsi.userskripsi.model.User;
import com.skripsi.userskripsi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(BigInteger id){
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username){
        return userRepository.findFirstByUsername(username).orElse(null);
    }

    public User insertUser(UserRequestDTO user){
        User userInsert = requestToUserMapper(user);
        return userRepository.save(userInsert);
    }

    private User requestToUserMapper(UserRequestDTO user){
        return User.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
//                .country(new Country().builder().id(user.getCountryId()).build())
//                .role(new Role().builder().id(user.getRoleId()).build())
                .build();
    }

    public User updateUser(UserRequestDTO user){
        User userUpdate = userRepository.findById(user.getId()).orElse(null);
        log.info(userUpdate.toString());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setUsername(user.getUsername());
        userUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        userUpdate.setName(user.getName());
//        userUpdate.setCountry(new Country().builder().id(user.getCountryId()).build());
//        userUpdate.setRole(new Role().builder().id(user.getRoleId()).build());
        return userRepository.save(userUpdate);
    }

    public Boolean checkUserLogin(UserLoginDTO user){
        log.info(user.toString());

        Optional<User> userSearch = userRepository.findFirstByUsername(user.getUsername());
        if(!userSearch.isPresent()){
            return false;
        }
//        log.info("password : {}", passwordEncoder.encode(user.getPassword()));
        return passwordEncoder.matches(user.getPassword(), userSearch.get().getPassword());
    }

}
