package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Connection {
    @Getter
    private static String baseUrl = "https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users";
    @Getter
    private static String xAuthToken = "b009fcbb9c127e3686c64f7206666909";
    @Getter
    private static String contentType = "b009fcbb9c127e3686c64f7206666909";
    @Getter
    @Setter
    private static String authKey;
}
