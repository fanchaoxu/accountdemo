package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class User{
    private int id;
    private String username;
    private String pwd;
}
