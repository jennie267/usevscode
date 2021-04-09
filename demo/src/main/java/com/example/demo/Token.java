package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Token {
    @Getter
    @Setter
    private static String url;
    @Getter
    @Setter
    private static String value;
}
