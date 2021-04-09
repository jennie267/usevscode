package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Truck {

    // 트럭 ID
    private int id;
    // 현재 위치
    private int locationId;
    // 싣고 있는 자전거 수
    private int loadedBikesCount;
    
}
