package com.life.share.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping("/hello")
    public String test(){
        return "Data";
    }
}
