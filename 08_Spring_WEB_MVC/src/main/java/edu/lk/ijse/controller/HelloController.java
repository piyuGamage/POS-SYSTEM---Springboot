package edu.lk.ijse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//define to view
@Controller
//map to request
@RequestMapping("hello")


public class HelloController {
    public HelloController() {
        System.out.println("HelloController");
    }
    //get req ekak awama map karagannawa
    @GetMapping
    public String hello() {
        return "index";
    }
}
