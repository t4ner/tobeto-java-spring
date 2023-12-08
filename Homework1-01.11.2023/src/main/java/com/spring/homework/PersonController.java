package com.spring.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persons")
public class PersonController {
    @GetMapping // api/persons
    public String get(){
        return "Get";
    }
    @GetMapping("get2") // api/persons/get2
    public String get2(){
        return "Get 2";
    }
    @PostMapping
    public String post(){
        return "Post";
    }
}
