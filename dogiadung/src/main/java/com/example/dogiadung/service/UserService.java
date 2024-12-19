package com.example.dogiadung.service;

import com.example.dogiadung.dto.UserDto;
import com.example.dogiadung.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
