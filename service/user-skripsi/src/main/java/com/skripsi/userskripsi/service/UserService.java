package com.skripsi.monolith.service.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skripsi.monolith.dto.user.UserLoginDTO;
import com.skripsi.monolith.dto.user.UserRequestDTO;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.repository.user.UserRepository;
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
        ObjectMapper mapper = new ObjectMapper();
        User users = mapper.convertValue(user, User.class);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    public User updateUser(UserRequestDTO user){
        User userUpdate = userRepository.findById(user.getId()).orElse(null);
        log.info(userUpdate.toString());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setUsername(user.getUsername());
        userUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
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
