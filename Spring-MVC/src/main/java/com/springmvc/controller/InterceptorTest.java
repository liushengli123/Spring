package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorTest {
    @RequestMapping("demo")
    public String test(){
        return "target";
    }
}
