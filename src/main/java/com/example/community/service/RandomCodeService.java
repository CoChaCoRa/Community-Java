package com.example.community.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomCodeService {

    public String createActiveCode(){
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }

    public String CreateAccountId(){
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }
}
