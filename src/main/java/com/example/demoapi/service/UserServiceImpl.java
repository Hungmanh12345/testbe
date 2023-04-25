package com.example.demoapi.service;

import com.example.demoapi.ModleDto.UserDto;
import com.example.demoapi.entity.User;
import com.example.demoapi.exception.notFountException;
import com.example.demoapi.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements Userservice {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Trần Hùng Mạnh", "hungmanh@gmail.com", "0343116535", "avatar.img", "123"));
        users.add(new User(2, "Lại Quang Nam", "sucvat@gmail.com", "0356786521", "avatar2.img", "12345"));
        users.add(new User(3, "Trịnh Đức Minh", "anke@gmail.com", "0356732145", "avatar3.img", "4321"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        throw new notFountException("User không tồn tại trong hệ thống");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user : users){
            if (user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }
}


