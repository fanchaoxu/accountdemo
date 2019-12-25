package com.example.demo.Utils;

import lombok.Data;

@Data
public class Result{
    private String resultCode;
    private String resultDesc;

    public Result(String resultCode,String resultDesc){
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }
}

