package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TokenDTO {

    @NonNull
    private String xAuthToken;

    private String test2;

    private String baseUrl;

    
}
