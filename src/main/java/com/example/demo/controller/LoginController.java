package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginPage()
    {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap modelMap, @RequestParam String userName, @RequestParam String password)
    {

        boolean isValid=loginService.isValid(userName,password);
        if(!isValid)
        {
            modelMap.put("errorMessage","invalid credentials");
            return "login";
        }
        modelMap.put("userName", userName);
        modelMap.put("password", password);

        return "welcome";

    }

}
