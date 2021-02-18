package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean isValid(String userName,String password)
    {
        if(userName.equals("dummy") && password.equals("dummy"))
        {
            return  true;
        }
        else
        {
            return false;
        }
    }
}
