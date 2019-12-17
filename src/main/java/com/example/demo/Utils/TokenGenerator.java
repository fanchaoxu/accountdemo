package com.example.demo.Utils;

import java.util.UUID;

public class TokenGenerator{

    /**
     * 生成一个临时的token
     * @return
     */
    public static String createToken(){
        String token = UUID.randomUUID().toString();
        return token;
    }
}
