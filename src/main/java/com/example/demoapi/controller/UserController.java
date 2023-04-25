package com.example.demoapi.controller;

import com.example.demoapi.ModleDto.UserDto;
import com.example.demoapi.entity.User;
import com.example.demoapi.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private Userservice userservice;
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "keyword", required = false, defaultValue = "") String name){
        List<UserDto> users = userservice.searchUser(name);
        return ResponseEntity.ok(users);
    }
    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        List<UserDto> users = userservice.getListUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto result = userservice.getUserById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity creatUser() {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser() {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser() {
        return null;
    }

}
