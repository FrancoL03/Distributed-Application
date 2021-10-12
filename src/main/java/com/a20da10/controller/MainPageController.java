package com.a20da10.controller;

import com.a20da10.service.spring.StudentSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @Autowired
    private StudentSelfService studentSelfService;

    @RequestMapping("/test")
    public String test(){
        System.out.println("studentSelfService id is" + studentSelfService.getStudentId());
        System.out.println(studentSelfService);
        return "home";
    }
}
