package com.example.demo.controller;

import java.util.List;

import com.example.demo.Connection;
import com.example.demo.entity.User;
import com.example.demo.repository.UserDAO;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDAO userDAO;
    
    @GetMapping()
    public List<User> getAllUser()
    {
        return userDAO.findAll();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId)
    {
        userDAO.deleteById(userId);
    }

    @GetMapping("/get/{userId}")
    public String test(@PathVariable String userId)
    {
        return userService.serviceTest("서비스로 들어옴!" +userId);
    }

    @GetMapping("/token")
    public String test2()
    {
        return Connection.getXAuthToken();
    }

    @GetMapping("/base-url")
    public String test3()
    {
        return Connection.getBaseUrl();
    }


}
