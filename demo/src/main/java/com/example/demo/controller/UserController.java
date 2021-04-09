package com.example.demo.controller;

import com.example.demo.Token;
import com.example.demo.dto.TokenDTO;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    TokenDTO tokenDTO = new TokenDTO();

    @GetMapping("/get/{userId}")
    public String test(@PathVariable String userId)
    {
        tokenDTO.setXAuthToken("토큰 : " +userId);
        tokenDTO.setBaseUrl("https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users");
        return userService.serviceTest("서비스로 들어옴!" +userId);
    }

    @GetMapping("/token")
    public String test2()
    {
        Token.setUrl("테스트");
        return tokenDTO.getXAuthToken();
    }

    @GetMapping("/base-url")
    public String test3()
    {
        Token.getUrl();
        return Token.getUrl();
    }


}
