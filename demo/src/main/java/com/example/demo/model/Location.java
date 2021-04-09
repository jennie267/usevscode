package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location {

    // 대여소 ID
    private int id;
    // 보유 자전거 수
    private int locatedBikesCount;
    
}
