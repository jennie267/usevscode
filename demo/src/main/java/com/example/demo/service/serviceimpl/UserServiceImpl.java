package com.example.demo.service.serviceimpl;

import com.example.demo.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String serviceTest(String test) {
        System.out.println("서비스들어옴");
        return test;
    }
    
}
