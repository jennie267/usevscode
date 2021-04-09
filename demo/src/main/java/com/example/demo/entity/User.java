package com.example.demo.entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @NonNull
    private String userId;
    
    private String name;
    private String password;
    private String description;
    
}
