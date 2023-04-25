package com.example.demoapi.service;

import com.example.demoapi.ModleDto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Userservice {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public List<UserDto> searchUser (String keyword);

}
