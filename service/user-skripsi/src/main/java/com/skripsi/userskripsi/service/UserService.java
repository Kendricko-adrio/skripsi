package com.skripsi.userskripsi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skripsi.userskripsi.dto.UserLoginDTO;
import com.skripsi.userskripsi.dto.UserRequestDTO;
import com.skripsi.userskripsi.model.Country;
import com.skripsi.userskripsi.model.Role;
import com.skripsi.userskripsi.model.User;
import com.skripsi.userskripsi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUser(BigInteger id) {
    return userRepository.findById(id).orElse(null);
  }

  public User getUserByUsername(String username) {
    return userRepository.findFirstByUsername(username).orElse(null);
  }

  public User insertUser(UserRequestDTO request) {
    User user = User.builder()
        .name(request.getName())
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .email(request.getEmail())
        .country(Country.builder().id(request.getCountryId()).build())
        .role(Role.builder().id(request.getRoleId()).build())
        .build();
    return userRepository.save(user);
  }

  public User updateUser(UserRequestDTO request) {
    return userRepository.findById(request.getId()).map(user -> {
      user.setEmail(user.getEmail());
      user.setUsername(request.getUsername());
      user.setPassword(passwordEncoder.encode(request.getPassword()));
      user.setName(request.getName());
      user.setCountry(Country.builder().id(user.getCountry().getId()).name(user.getCountry().getName()).build());
      user.setRole(Role.builder().id(user.getRole().getId()).name(user.getRole().getName()).build());

      return userRepository.save(user);
    }).orElse(null);
  }

  public Boolean checkUserLogin(UserLoginDTO user) {
    Optional<User> userSearch = userRepository.findFirstByUsername(user.getUsername());
    return userSearch.filter(value -> passwordEncoder.matches(user.getPassword(),
        value.getPassword())).isPresent();
  }

}
